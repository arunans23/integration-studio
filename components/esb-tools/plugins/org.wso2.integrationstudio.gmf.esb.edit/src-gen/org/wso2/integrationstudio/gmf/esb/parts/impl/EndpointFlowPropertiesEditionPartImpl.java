/**
 * Generated with Acceleo
 */
package org.wso2.integrationstudio.gmf.esb.parts.impl;

// Start of user code for imports
import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent;

import org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent;

import org.eclipse.emf.eef.runtime.api.parts.ISWTPropertiesEditionPart;

import org.eclipse.emf.eef.runtime.impl.notify.PropertiesEditionEvent;

import org.eclipse.emf.eef.runtime.impl.parts.CompositePropertiesEditionPart;

import org.eclipse.emf.eef.runtime.ui.parts.PartComposer;

import org.eclipse.emf.eef.runtime.ui.parts.sequence.BindingCompositionSequence;
import org.eclipse.emf.eef.runtime.ui.parts.sequence.CompositionSequence;

import org.eclipse.emf.eef.runtime.ui.widgets.ReferencesTable;

import org.eclipse.emf.eef.runtime.ui.widgets.ReferencesTable.ReferencesTableListener;

import org.eclipse.emf.eef.runtime.ui.widgets.referencestable.ReferencesTableContentProvider;
import org.eclipse.emf.eef.runtime.ui.widgets.referencestable.ReferencesTableSettings;

import org.eclipse.jface.viewers.ViewerFilter;

import org.eclipse.swt.SWT;

import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;

import org.wso2.integrationstudio.gmf.esb.parts.EndpointFlowPropertiesEditionPart;
import org.wso2.integrationstudio.gmf.esb.parts.EsbViewsRepository;

import org.wso2.integrationstudio.gmf.esb.providers.EsbMessages;

// End of user code

/**
 * 
 * 
 */
public class EndpointFlowPropertiesEditionPartImpl extends CompositePropertiesEditionPart implements ISWTPropertiesEditionPart, EndpointFlowPropertiesEditionPart {

	protected ReferencesTable children;
	protected List<ViewerFilter> childrenBusinessFilters = new ArrayList<ViewerFilter>();
	protected List<ViewerFilter> childrenFilters = new ArrayList<ViewerFilter>();



	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 * 
	 */
	public EndpointFlowPropertiesEditionPartImpl(IPropertiesEditionComponent editionComponent) {
		super(editionComponent);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.parts.ISWTPropertiesEditionPart#
	 * 			createFigure(org.eclipse.swt.widgets.Composite)
	 * 
	 */
	public Composite createFigure(final Composite parent) {
		view = new Composite(parent, SWT.NONE);
		GridLayout layout = new GridLayout();
		layout.numColumns = 3;
		view.setLayout(layout);
		createControls(view);
		return view;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.parts.ISWTPropertiesEditionPart#
	 * 			createControls(org.eclipse.swt.widgets.Composite)
	 * 
	 */
	public void createControls(Composite view) { 
		CompositionSequence endpointFlowStep = new BindingCompositionSequence(propertiesEditionComponent);
		endpointFlowStep
			.addStep(EsbViewsRepository.EndpointFlow.Properties.class)
			.addStep(EsbViewsRepository.EndpointFlow.Properties.children);
		
		
		composer = new PartComposer(endpointFlowStep) {

			@Override
			public Composite addToPart(Composite parent, Object key) {
				if (key == EsbViewsRepository.EndpointFlow.Properties.class) {
					return createPropertiesGroup(parent);
				}
				if (key == EsbViewsRepository.EndpointFlow.Properties.children) {
					return createChildrenAdvancedTableComposition(parent);
				}
				return parent;
			}
		};
		composer.compose(view);
	}

	/**
	 * 
	 */
	protected Composite createPropertiesGroup(Composite parent) {
		Group propertiesGroup = new Group(parent, SWT.NONE);
		propertiesGroup.setText(EsbMessages.EndpointFlowPropertiesEditionPart_PropertiesGroupLabel);
		GridData propertiesGroupData = new GridData(GridData.FILL_HORIZONTAL);
		propertiesGroupData.horizontalSpan = 3;
		propertiesGroup.setLayoutData(propertiesGroupData);
		GridLayout propertiesGroupLayout = new GridLayout();
		propertiesGroupLayout.numColumns = 3;
		propertiesGroup.setLayout(propertiesGroupLayout);
		return propertiesGroup;
	}

	/**
	 * @param container
	 * 
	 */
	protected Composite createChildrenAdvancedTableComposition(Composite parent) {
		this.children = new ReferencesTable(getDescription(EsbViewsRepository.EndpointFlow.Properties.children, EsbMessages.EndpointFlowPropertiesEditionPart_ChildrenLabel), new ReferencesTableListener() {
			public void handleAdd() { 
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EndpointFlowPropertiesEditionPartImpl.this, EsbViewsRepository.EndpointFlow.Properties.children, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null, null));
				children.refresh();
			}
			public void handleEdit(EObject element) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EndpointFlowPropertiesEditionPartImpl.this, EsbViewsRepository.EndpointFlow.Properties.children, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.EDIT, null, element));
				children.refresh();
			}
			public void handleMove(EObject element, int oldIndex, int newIndex) { 
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EndpointFlowPropertiesEditionPartImpl.this, EsbViewsRepository.EndpointFlow.Properties.children, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, element, newIndex));
				children.refresh();
			}
			public void handleRemove(EObject element) { 
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EndpointFlowPropertiesEditionPartImpl.this, EsbViewsRepository.EndpointFlow.Properties.children, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.REMOVE, null, element));
				children.refresh();
			}
			public void navigateTo(EObject element) { }
		});
		for (ViewerFilter filter : this.childrenFilters) {
			this.children.addFilter(filter);
		}
		this.children.setHelpText(propertiesEditionComponent.getHelpContent(EsbViewsRepository.EndpointFlow.Properties.children, EsbViewsRepository.SWT_KIND));
		this.children.createControls(parent);
		this.children.addSelectionListener(new SelectionAdapter() {
			
			public void widgetSelected(SelectionEvent e) {
				if (e.item != null && e.item.getData() instanceof EObject) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EndpointFlowPropertiesEditionPartImpl.this, EsbViewsRepository.EndpointFlow.Properties.children, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SELECTION_CHANGED, null, e.item.getData()));
				}
			}
			
		});
		GridData childrenData = new GridData(GridData.FILL_HORIZONTAL);
		childrenData.horizontalSpan = 3;
		this.children.setLayoutData(childrenData);
		this.children.setLowerBound(0);
		this.children.setUpperBound(-1);
		children.setID(EsbViewsRepository.EndpointFlow.Properties.children);
		children.setEEFType("eef::AdvancedTableComposition"); //$NON-NLS-1$
		// Start of user code for createChildrenAdvancedTableComposition

		// End of user code
		return parent;
	}


	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionListener#firePropertiesChanged(org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent)
	 * 
	 */
	public void firePropertiesChanged(IPropertiesEditionEvent event) {
		// Start of user code for tab synchronization
		
		// End of user code
	}



	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.gmf.esb.parts.EndpointFlowPropertiesEditionPart#initChildren(EObject current, EReference containingFeature, EReference feature)
	 */
	public void initChildren(ReferencesTableSettings settings) {
		if (current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		ReferencesTableContentProvider contentProvider = new ReferencesTableContentProvider();
		children.setContentProvider(contentProvider);
		children.setInput(settings);
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.EndpointFlow.Properties.children);
		if (eefElementEditorReadOnlyState && children.isEnabled()) {
			children.setEnabled(false);
			children.setToolTipText(EsbMessages.EndpointFlow_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !children.isEnabled()) {
			children.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.gmf.esb.parts.EndpointFlowPropertiesEditionPart#updateChildren()
	 * 
	 */
	public void updateChildren() {
	children.refresh();
}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.gmf.esb.parts.EndpointFlowPropertiesEditionPart#addFilterChildren(ViewerFilter filter)
	 * 
	 */
	public void addFilterToChildren(ViewerFilter filter) {
		childrenFilters.add(filter);
		if (this.children != null) {
			this.children.addFilter(filter);
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.gmf.esb.parts.EndpointFlowPropertiesEditionPart#addBusinessFilterChildren(ViewerFilter filter)
	 * 
	 */
	public void addBusinessFilterToChildren(ViewerFilter filter) {
		childrenBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.gmf.esb.parts.EndpointFlowPropertiesEditionPart#isContainedInChildrenTable(EObject element)
	 * 
	 */
	public boolean isContainedInChildrenTable(EObject element) {
		return ((ReferencesTableSettings)children.getInput()).contains(element);
	}






	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart#getTitle()
	 * 
	 */
	public String getTitle() {
		return EsbMessages.EndpointFlow_Part_Title;
	}

	// Start of user code additional methods
	
	// End of user code


}
