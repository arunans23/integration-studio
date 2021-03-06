package org.wso2.integrationstudio.gmf.esb.diagram.custom.provider;

import org.eclipse.emf.common.ui.celleditor.ExtendedDialogCellEditor;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.ui.provider.PropertyDescriptor;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.wso2.integrationstudio.gmf.esb.XSLTMediator;
import org.wso2.integrationstudio.gmf.esb.diagram.custom.configure.ui.ConfigureXSLTMediatorDialog;

public class XSLTFeaturesPropertyDescriptor extends PropertyDescriptor {

    public XSLTFeaturesPropertyDescriptor(Object object, IItemPropertyDescriptor itemPropertyDescriptor) {
        super(object, itemPropertyDescriptor);
    }

    public CellEditor createPropertyEditor(Composite parent) {
        return new ExtendedDialogCellEditor(parent, getLabelProvider()) {

            protected Object openDialogBox(Control cellEditorWindow) {
                Shell shell = Display.getDefault().getActiveShell();
                XSLTMediator xsltMediator = (XSLTMediator) object;
                ConfigureXSLTMediatorDialog configDiag = new ConfigureXSLTMediatorDialog(shell, xsltMediator,
                        ConfigureXSLTMediatorDialog.TAB_FEATURES);
                // enrichMediatorConfigurationDialog.setBlockOnOpen(true);
                configDiag.open();
                // configDiag.setCurrentTab(ConfigureXSLTMediatorDialog.TAB_FEATURES);
                return null;
            }
        };
    }

}
