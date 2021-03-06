/**
 * <copyright>
 * </copyright>
 * 
 * $Id$
 */
package org.wso2.integrationstudio.ds.provider;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.ResourceLocator;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.FeatureMap;
import org.eclipse.emf.ecore.util.FeatureMapUtil;
import org.eclipse.emf.ecore.xml.type.XMLTypeFactory;
import org.eclipse.emf.ecore.xml.type.XMLTypePackage;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ItemProviderAdapter;
import org.eclipse.emf.edit.provider.ViewerNotification;

import org.wso2.integrationstudio.ds.DsFactory;
import org.wso2.integrationstudio.ds.DsPackage;
import org.wso2.integrationstudio.ds.ElementMapping;

/**
 * This is the item provider adapter for a {@link org.wso2.integrationstudio.ds.ElementMapping} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class ElementMappingItemProvider extends ItemProviderAdapter implements
                                                                   IEditingDomainItemProvider,
                                                                   IStructuredItemContentProvider,
                                                                   ITreeItemContentProvider,
                                                                   IItemLabelProvider,
                                                                   IItemPropertySource {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ElementMappingItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	/**
	 * This returns the property descriptors for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */

	@Override
	public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object) {
		if (itemPropertyDescriptors == null) {
			super.getPropertyDescriptors(object);

			addNamePropertyDescriptor(object);
			addNamespacePropertyDescriptor(object);
			addColumnPropertyDescriptor(object);
			addQueryParamPropertyDescriptor(object);
			addXsdTypePropertyDescriptor(object);
			addValuePropertyDescriptor(object);
			addExportTypePropertyDescriptor(object);
			addExportPropertyDescriptor(object);
			addRequiredRolesPropertyDescriptor(object);
			addIsComplexTypePropertyDescriptor(object);
			addArrayNamePropertyDescriptor(object);
			addOptionalPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Column feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addColumnPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ElementMapping_column_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ElementMapping_column_feature", "_UI_ElementMapping_type"),
				 DsPackage.Literals.ELEMENT_MAPPING__COLUMN,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Export feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addExportPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ElementMapping_export_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ElementMapping_export_feature", "_UI_ElementMapping_type"),
				 DsPackage.Literals.ELEMENT_MAPPING__EXPORT,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Name feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addNamePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ElementMapping_name_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ElementMapping_name_feature", "_UI_ElementMapping_type"),
				 DsPackage.Literals.ELEMENT_MAPPING__NAME,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Required Roles feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addRequiredRolesPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ElementMapping_requiredRoles_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ElementMapping_requiredRoles_feature", "_UI_ElementMapping_type"),
				 DsPackage.Literals.ELEMENT_MAPPING__REQUIRED_ROLES,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Export Type feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addExportTypePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ElementMapping_exportType_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ElementMapping_exportType_feature", "_UI_ElementMapping_type"),
				 DsPackage.Literals.ELEMENT_MAPPING__EXPORT_TYPE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Namespace feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addNamespacePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ElementMapping_namespace_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ElementMapping_namespace_feature", "_UI_ElementMapping_type"),
				 DsPackage.Literals.ELEMENT_MAPPING__NAMESPACE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Xsd Type feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addXsdTypePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ElementMapping_xsdType_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ElementMapping_xsdType_feature", "_UI_ElementMapping_type"),
				 DsPackage.Literals.ELEMENT_MAPPING__XSD_TYPE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Is Complex Type feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addIsComplexTypePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ElementMapping_isComplexType_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ElementMapping_isComplexType_feature", "_UI_ElementMapping_type"),
				 DsPackage.Literals.ELEMENT_MAPPING__IS_COMPLEX_TYPE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Query Param feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addQueryParamPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ElementMapping_queryParam_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ElementMapping_queryParam_feature", "_UI_ElementMapping_type"),
				 DsPackage.Literals.ELEMENT_MAPPING__QUERY_PARAM,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Value feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addValuePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ElementMapping_value_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ElementMapping_value_feature", "_UI_ElementMapping_type"),
				 DsPackage.Literals.ELEMENT_MAPPING__VALUE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Optional feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addOptionalPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ElementMapping_optional_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ElementMapping_optional_feature", "_UI_ElementMapping_type"),
				 DsPackage.Literals.ELEMENT_MAPPING__OPTIONAL,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Array Name feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addArrayNamePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ElementMapping_arrayName_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ElementMapping_arrayName_feature", "_UI_ElementMapping_type"),
				 DsPackage.Literals.ELEMENT_MAPPING__ARRAY_NAME,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This specifies how to implement {@link #getChildren} and is used to
	 * deduce an appropriate feature for an
	 * {@link org.eclipse.emf.edit.command.AddCommand},
	 * {@link org.eclipse.emf.edit.command.RemoveCommand} or
	 * {@link org.eclipse.emf.edit.command.MoveCommand} in
	 * {@link #createCommand}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	@Override
	public Collection<? extends EStructuralFeature> getChildrenFeatures(Object object) {
		if (childrenFeatures == null) {
			super.getChildrenFeatures(object);
			// childrenFeatures.add(DsPackage.Literals.ELEMENT_MAPPING__MIXED);
			childrenFeatures.add(DsPackage.Literals.ELEMENT_MAPPING__ELEMENT);
			childrenFeatures.add(DsPackage.Literals.ELEMENT_MAPPING__ATTRIBUTE);
			childrenFeatures.add(DsPackage.Literals.ELEMENT_MAPPING__CALL_QUERY);
		}
		return childrenFeatures;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EStructuralFeature getChildFeature(Object object, Object child) {
		// Check the type of the specified child object and return the proper feature to use for
		// adding (see {@link AddCommand}) it as a child.

		return super.getChildFeature(object, child);
	}

	/**
	 * This returns ElementMapping.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */

	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("wso2/element"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */

	@Override
	public String getText(Object object) {
		String label = ((ElementMapping) object).getName();
		String type = " (" + getString("_UI_ElementMapping_type") + ")";
		return label != null ? label.toString() + type : type;

	}

	/**
	 * This handles model notifications by calling {@link #updateChildren} to update any cached
	 * children and by creating a viewer notification, which it passes to {@link #fireNotifyChanged}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */

	@Override
	public void notifyChanged(Notification notification) {
		updateChildren(notification);

		switch (notification.getFeatureID(ElementMapping.class)) {
			case DsPackage.ELEMENT_MAPPING__COLUMN:
			case DsPackage.ELEMENT_MAPPING__EXPORT:
			case DsPackage.ELEMENT_MAPPING__NAME:
			case DsPackage.ELEMENT_MAPPING__REQUIRED_ROLES:
			case DsPackage.ELEMENT_MAPPING__EXPORT_TYPE:
			case DsPackage.ELEMENT_MAPPING__NAMESPACE:
			case DsPackage.ELEMENT_MAPPING__XSD_TYPE:
			case DsPackage.ELEMENT_MAPPING__IS_COMPLEX_TYPE:
			case DsPackage.ELEMENT_MAPPING__QUERY_PARAM:
			case DsPackage.ELEMENT_MAPPING__VALUE:
			case DsPackage.ELEMENT_MAPPING__OPTIONAL:
			case DsPackage.ELEMENT_MAPPING__ARRAY_NAME:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
			case DsPackage.ELEMENT_MAPPING__MIXED:
			case DsPackage.ELEMENT_MAPPING__ELEMENT:
			case DsPackage.ELEMENT_MAPPING__ATTRIBUTE:
			case DsPackage.ELEMENT_MAPPING__CALL_QUERY:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), true, false));
				return;
		}
		super.notifyChanged(notification);
	}

	/**
	 * This adds {@link org.eclipse.emf.edit.command.CommandParameter}s describing the children
	 * that can be created under this object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */

	@Override
	protected void collectNewChildDescriptors(Collection<Object> newChildDescriptors, Object object) {
		super.collectNewChildDescriptors(newChildDescriptors, object);

		newChildDescriptors.add
			(createChildParameter
				(DsPackage.Literals.ELEMENT_MAPPING__MIXED,
				 FeatureMapUtil.createEntry
					(XMLTypePackage.Literals.XML_TYPE_DOCUMENT_ROOT__COMMENT,
					 "")));

		newChildDescriptors.add
			(createChildParameter
				(DsPackage.Literals.ELEMENT_MAPPING__MIXED,
				 FeatureMapUtil.createEntry
					(XMLTypePackage.Literals.XML_TYPE_DOCUMENT_ROOT__TEXT,
					 "")));

		newChildDescriptors.add
			(createChildParameter
				(DsPackage.Literals.ELEMENT_MAPPING__MIXED,
				 FeatureMapUtil.createEntry
					(XMLTypePackage.Literals.XML_TYPE_DOCUMENT_ROOT__PROCESSING_INSTRUCTION,
					 XMLTypeFactory.eINSTANCE.createProcessingInstruction())));

		newChildDescriptors.add
			(createChildParameter
				(DsPackage.Literals.ELEMENT_MAPPING__MIXED,
				 FeatureMapUtil.createEntry
					(XMLTypePackage.Literals.XML_TYPE_DOCUMENT_ROOT__CDATA,
					 "")));

		newChildDescriptors.add
			(createChildParameter
				(DsPackage.Literals.ELEMENT_MAPPING__MIXED,
				 FeatureMapUtil.createEntry
					(DsPackage.Literals.ELEMENT_MAPPING__ELEMENT,
					 DsFactory.eINSTANCE.createElementMapping())));

		newChildDescriptors.add
			(createChildParameter
				(DsPackage.Literals.ELEMENT_MAPPING__MIXED,
				 FeatureMapUtil.createEntry
					(DsPackage.Literals.ELEMENT_MAPPING__ATTRIBUTE,
					 DsFactory.eINSTANCE.createAttributeMapping())));

		newChildDescriptors.add
			(createChildParameter
				(DsPackage.Literals.ELEMENT_MAPPING__MIXED,
				 FeatureMapUtil.createEntry
					(DsPackage.Literals.ELEMENT_MAPPING__CALL_QUERY,
					 DsFactory.eINSTANCE.createCallQuery())));

		newChildDescriptors.add
			(createChildParameter
				(DsPackage.Literals.ELEMENT_MAPPING__ELEMENT,
				 DsFactory.eINSTANCE.createElementMapping()));

		newChildDescriptors.add
			(createChildParameter
				(DsPackage.Literals.ELEMENT_MAPPING__ATTRIBUTE,
				 DsFactory.eINSTANCE.createAttributeMapping()));

		newChildDescriptors.add
			(createChildParameter
				(DsPackage.Literals.ELEMENT_MAPPING__CALL_QUERY,
				 DsFactory.eINSTANCE.createCallQuery()));
	}

	/**
	 * This returns the label text for {@link org.eclipse.emf.edit.command.CreateChildCommand}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getCreateChildText(Object owner, Object feature, Object child,
	                                 Collection<?> selection) {
		Object childFeature = feature;
		Object childObject = child;

		if (childFeature instanceof EStructuralFeature && FeatureMapUtil.isFeatureMap((EStructuralFeature)childFeature)) {
			FeatureMap.Entry entry = (FeatureMap.Entry)childObject;
			childFeature = entry.getEStructuralFeature();
			childObject = entry.getValue();
		}

		boolean qualify =
			childFeature == DsPackage.Literals.ELEMENT_MAPPING__ELEMENT ||
			childFeature == DsPackage.Literals.ELEMENT_MAPPING__ATTRIBUTE ||
			childFeature == DsPackage.Literals.ELEMENT_MAPPING__CALL_QUERY;

		if (qualify) {
			return getString
				("_UI_CreateChild_text2",
				 new Object[] { getTypeText(childObject), getFeatureText(childFeature), getTypeText(owner) });
		}
		return super.getCreateChildText(owner, feature, child, selection);
	}

	/**
	 * Return the resource locator for this item provider's resources.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */

	@Override
	public ResourceLocator getResourceLocator() {
		return DsEditPlugin.INSTANCE;
	}

}
