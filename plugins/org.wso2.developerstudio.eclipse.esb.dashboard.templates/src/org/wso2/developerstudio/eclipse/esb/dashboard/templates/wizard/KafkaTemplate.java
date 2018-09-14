/*
 *  Copyright (c) 2018, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 *  WSO2 Inc. licenses this file to you under the Apache License,
 *  Version 2.0 (the "License"); you may not use this file except
 *  in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.wso2.developerstudio.eclipse.esb.dashboard.templates.wizard;

import org.apache.maven.model.Dependency;
import org.apache.maven.project.MavenProject;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchWizard;
import org.wso2.developerstudio.eclipse.esb.project.artifact.ESBProjectArtifact;
import org.wso2.developerstudio.eclipse.maven.util.MavenUtils;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * The class which handles Kafka Template Sample.
 */
public class KafkaTemplate extends Wizard implements INewWizard {

    String sampleName = "KafkaTemplate";
    String baseId = "wso2.sample" + sampleName + ".";
    String name = "Kafka Consumer and Producer";
    private TemplateProjectWizardPage page;
    private ISelection selection;
    private TemplateWizardUtil templateWizardUtil;
    private String groupId;

    public KafkaTemplate() {
        super();
        setNeedsProgressMonitor(true);
        templateWizardUtil = new TemplateWizardUtil();
        setWindowTitle(TemplateProjectConstants.PROJECT_WIZARD_TITLE);
    }

    /**
     * Adding the page to the wizard.
     */
    @Override
    public void addPages() {
        page = new TemplateProjectWizardPage(selection, name);
        addPage(page);
    }

    /**
     * This method is called when 'Finish' button is pressed in the wizard. We will
     * create an operation and run it using wizard as execution context.
     */
    @Override
    public boolean performFinish() {

        final String containerName = page.getContainerName();

        IRunnableWithProgress op = new IRunnableWithProgress() {
            @Override
            public void run(IProgressMonitor monitor) throws InvocationTargetException {
                try {
                    doFinish(containerName, monitor);
                } catch (CoreException e) {
                    throw new InvocationTargetException(e);
                } finally {
                    monitor.done();
                }
            }
        };

        try {
            getContainer().run(true, false, op);
        } catch (InterruptedException e) {
            return false;
        } catch (InvocationTargetException e) {
            Throwable realException = e.getTargetException();
            MessageDialog.openError(getShell(), TemplateProjectConstants.ERROR_MESSAGE, realException.getMessage());
            return false;
        }
        return true;
    }

    /**
     * The worker method. It will find the container, create the file if missing or
     * just replace its contents, and open the editor on the newly created file.
     */
    private void doFinish(String containerName, IProgressMonitor monitor) throws CoreException {

        try {
            // ESB project creation
            IProject project = ProjectCreationUtil
                    .createProject(containerName, TemplateProjectConstants.ESB_PROJECT_NATURE);

            File pomfile = project.getFile("pom.xml").getLocation().toFile();
            groupId = baseId + containerName;
            ProjectCreationUtil.createProjectPOM(groupId, pomfile, containerName, "pom");

            templateWizardUtil.addNature(project, TemplateProjectConstants.ESB_PROJECT_NATURE);

            MavenUtils.updateWithMavenEclipsePlugin(pomfile, new String[] {},
                    new String[] { TemplateProjectConstants.ESB_PROJECT_NATURE });

            // Create connector exporter project .
            IProject connectorProject = ProjectCreationUtil.createConnectorExporterProject(groupId, containerName);

            // add connector.
            String connectorName = "kafkaTransport-connector";
            String connectorVersion = "2.0.5";
            ProjectCreationUtil.addConnectorToWorkSpace(connectorName + "-" + connectorVersion);
            ProjectCreationUtil.addConnectorToProject(connectorProject, connectorName, connectorVersion, groupId);

            // refresh connector project .
            connectorProject.refreshLocal(IResource.DEPTH_INFINITE, new NullProgressMonitor());

            // ESB solution project artifact.xml
            ESBProjectArtifact esbProjectArtifact = new ESBProjectArtifact();
            IFile artifactXML = project.getFile("artifact.xml");
            esbProjectArtifact.setSource(artifactXML.getLocation().toFile());
            copyFiles(project, esbProjectArtifact);
            esbProjectArtifact.toFile();

            project.refreshLocal(IResource.DEPTH_INFINITE, new NullProgressMonitor());

            // carbon application project creation
            IProject cappProject = ProjectCreationUtil
                    .carbonAppCreation(containerName + "CarbonApplication", containerName, groupId, sampleName);
            addCappDependencies(cappProject);

            // Open synapse application on sample creation.
            String openFileName = "src" + File.separator + "main" + File.separator + "synapse-config" + File.separator
                    + "proxy-services" + File.separator + "WeatherDataPublishService.xml";
            IFile fileDesc = project.getFile(openFileName);
            Shell shell = getShell();
            ProjectCreationUtil.openEditor(shell, fileDesc, TemplateProjectConstants.SYNAPSE_CONFIG_EDITOR_ID,
                    TemplateProjectConstants.KAFKA_TEMPLATE_HELP_CONTEXT);

        } catch (CoreException ex) {
            templateWizardUtil
                    .throwCoreException(TemplateProjectConstants.THE_PROJECT_EXISTS_IN_THE_WORKSPACE_MESSAGE, null);
        } catch (Exception ex) {
            templateWizardUtil.throwCoreException("Error creating sample project " + containerName, ex);
        }
    }

    /**
     * Will accept the selection in the workbench to see if we can initialize from
     * it.
     *
     * @see IWorkbenchWizard#init(IWorkbench, IStructuredSelection)
     */
    @Override
    public void init(IWorkbench workbench, IStructuredSelection selection) {
        this.selection = selection;
        setHelpAvailable(true);
    }

    /**
     * Copy the files which belongs to the samples.
     *
     * @param esbProject
     * @param esbProjectArtifact
     */
    private void copyFiles(IProject esbProject, ESBProjectArtifact esbProjectArtifact) {

        String artifactName = "WeatherDataPublishService";
        String type = "proxy-services";
        ProjectCreationUtil.copyArtifact(esbProject, groupId, sampleName, artifactName, esbProjectArtifact, type);

        artifactName = "WeatherDataProcessSeq";
        type = "sequences";
        ProjectCreationUtil.copyArtifact(esbProject, groupId, sampleName, artifactName, esbProjectArtifact, type);

        artifactName = "WeatherDataErrorSeq";
        type = "sequences";
        ProjectCreationUtil.copyArtifact(esbProject, groupId, sampleName, artifactName, esbProjectArtifact, type);

        artifactName = "WeatherDataTransmitInboundEP";
        type = "inbound-endpoints";
        ProjectCreationUtil.copyArtifact(esbProject, groupId, sampleName, artifactName, esbProjectArtifact, type);

    }

    /**
     * Add the dependencies for the carbon application of the {@link #sampleName} sample.
     *
     * @param CarbonAppProject
     * @throws Exception
     */
    private void addCappDependencies(IProject CarbonAppProject) throws Exception {

        File pomfile = CarbonAppProject.getFile("pom.xml").getLocation().toFile();

        List<Dependency> dependencyList = new ArrayList<Dependency>();
        MavenProject mavenProject = MavenUtils.getMavenProject(pomfile);
        Properties properties = mavenProject.getModel().getProperties();

        Dependency dependency = ProjectCreationUtil
                .addDependencyForCAPP(groupId, "WeatherDataPublishService", "proxy-service");
        dependencyList.add(dependency);
        properties.put(ProjectCreationUtil.getArtifactInfoAsString(dependency), "capp/EnterpriseServiceBus");

        Dependency dependency2 = ProjectCreationUtil.addDependencyForCAPP(groupId, "WeatherDataProcessSeq", "sequence");
        dependencyList.add(dependency2);
        properties.put(ProjectCreationUtil.getArtifactInfoAsString(dependency2), "capp/EnterpriseServiceBus");

        Dependency dependency3 = ProjectCreationUtil.addDependencyForCAPP(groupId, "WeatherDataErrorSeq", "sequence");
        dependencyList.add(dependency3);
        properties.put(ProjectCreationUtil.getArtifactInfoAsString(dependency3), "capp/EnterpriseServiceBus");

        Dependency dependency4 = ProjectCreationUtil
                .addDependencyForCAPP(groupId, "WeatherDataTransmitInboundEP", "inbound-endpoint");
        dependencyList.add(dependency4);
        properties.put(ProjectCreationUtil.getArtifactInfoAsString(dependency4), "capp/EnterpriseServiceBus");

        Dependency dependency5 = ProjectCreationUtil.addDependencyForCAPP(groupId, "kafkaTransport-connector", "lib");
        dependencyList.add(dependency5);
        properties.put(ProjectCreationUtil.getArtifactInfoAsString(dependency5), "capp/EnterpriseServiceBus");

        ArtifactTypeMapping artifactTypeMapping = new ArtifactTypeMapping();
        properties.put("artifact.types", artifactTypeMapping.getArtifactTypes());
        mavenProject.getModel().setProperties(properties);
        MavenUtils.addMavenDependency(mavenProject, dependencyList);
        MavenUtils.saveMavenProject(mavenProject, pomfile);
        CarbonAppProject.refreshLocal(IResource.DEPTH_INFINITE, new NullProgressMonitor());
    }

}
