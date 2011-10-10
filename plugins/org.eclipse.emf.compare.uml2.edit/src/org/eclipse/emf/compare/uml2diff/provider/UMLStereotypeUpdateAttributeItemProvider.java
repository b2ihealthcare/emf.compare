/**
 * Copyright (c) 2011 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 */
package org.eclipse.emf.compare.uml2diff.provider;


import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.compare.diff.metamodel.DiffPackage;
import org.eclipse.emf.compare.diff.provider.UpdateAttributeItemProvider;
import org.eclipse.emf.compare.uml2diff.UML2DiffFactory;
import org.eclipse.emf.compare.uml2diff.UML2DiffPackage;
import org.eclipse.emf.compare.uml2diff.UMLStereotypeUpdateAttribute;
import org.eclipse.emf.compare.util.AdapterUtils;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.util.UMLUtil;

/**
 * This is the item provider adapter for a {@link org.eclipse.emf.compare.uml2diff.UMLStereotypeUpdateAttribute} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class UMLStereotypeUpdateAttributeItemProvider
	extends UpdateAttributeItemProvider
	implements
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
	public UMLStereotypeUpdateAttributeItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	/**
	 * This returns the property descriptors for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object) {
		if (itemPropertyDescriptors == null) {
			super.getPropertyDescriptors(object);

			addHideElementsPropertyDescriptor(object);
			addIsCollapsedPropertyDescriptor(object);
			addStereotypePropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Hide Elements feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addHideElementsPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_AbstractDiffExtension_hideElements_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_AbstractDiffExtension_hideElements_feature", "_UI_AbstractDiffExtension_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 DiffPackage.Literals.ABSTRACT_DIFF_EXTENSION__HIDE_ELEMENTS,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Is Collapsed feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addIsCollapsedPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_AbstractDiffExtension_isCollapsed_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_AbstractDiffExtension_isCollapsed_feature", "_UI_AbstractDiffExtension_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 DiffPackage.Literals.ABSTRACT_DIFF_EXTENSION__IS_COLLAPSED,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Stereotype feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addStereotypePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_UMLStereotypePropertyChange_stereotype_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_UMLStereotypePropertyChange_stereotype_feature", "_UI_UMLStereotypePropertyChange_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 UML2DiffPackage.Literals.UML_STEREOTYPE_PROPERTY_CHANGE__STEREOTYPE,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This returns UMLStereotypeUpdateAttribute.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public Object getImage(Object object) {
		return super.getImage(object);
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public String getText(Object object) {
		final UMLStereotypeUpdateAttribute updateOp = (UMLStereotypeUpdateAttribute)object;

		final String attributeLabel = AdapterUtils.getItemProviderText(updateOp.getAttribute());
		Element leftElement = (Element)updateOp.getLeftElement();
		Element rightElement = (Element)updateOp.getRightElement();
		
		final String elementLabel = AdapterUtils.getItemProviderText(leftElement);
		
		final Object leftValue = UMLUtil.getTaggedValue(leftElement, updateOp.getStereotype().getQualifiedName(), updateOp.getAttribute().getName());
		final Object rightValue = UMLUtil.getTaggedValue(rightElement, updateOp.getStereotype().getQualifiedName(), updateOp.getAttribute().getName());

		final String diffLabel;
		if (updateOp.isRemote()) {
			diffLabel = getString("_UI_UMLRemoteStereotypeUpdateAttribute_type", new Object[] {attributeLabel, //$NON-NLS-1$
					elementLabel, leftValue, rightValue, });
		} else {
			if (updateOp.isConflicting()) {
				diffLabel = getString(
						"_UI_UMLStereotypeUpdateAttribute_conflicting", new Object[] {attributeLabel, rightValue, //$NON-NLS-1$
								leftValue, });
			} else {
				diffLabel = getString(
						"_UI_UMLStereotypeUpdateAttribute_type", new Object[] {attributeLabel, elementLabel, rightValue, //$NON-NLS-1$
								leftValue, });
			}
		}
		return diffLabel;
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

		switch (notification.getFeatureID(UMLStereotypeUpdateAttribute.class)) {
			case UML2DiffPackage.UML_STEREOTYPE_UPDATE_ATTRIBUTE__IS_COLLAPSED:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
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
				(DiffPackage.Literals.DIFF_ELEMENT__SUB_DIFF_ELEMENTS,
				 UML2DiffFactory.eINSTANCE.createUMLAssociationChangeLeftTarget()));

		newChildDescriptors.add
			(createChildParameter
				(DiffPackage.Literals.DIFF_ELEMENT__SUB_DIFF_ELEMENTS,
				 UML2DiffFactory.eINSTANCE.createUMLAssociationChangeRightTarget()));

		newChildDescriptors.add
			(createChildParameter
				(DiffPackage.Literals.DIFF_ELEMENT__SUB_DIFF_ELEMENTS,
				 UML2DiffFactory.eINSTANCE.createUMLAssociationBranchChangeLeftTarget()));

		newChildDescriptors.add
			(createChildParameter
				(DiffPackage.Literals.DIFF_ELEMENT__SUB_DIFF_ELEMENTS,
				 UML2DiffFactory.eINSTANCE.createUMLAssociationBranchChangeRightTarget()));

		newChildDescriptors.add
			(createChildParameter
				(DiffPackage.Literals.DIFF_ELEMENT__SUB_DIFF_ELEMENTS,
				 UML2DiffFactory.eINSTANCE.createUMLDependencyBranchChangeLeftTarget()));

		newChildDescriptors.add
			(createChildParameter
				(DiffPackage.Literals.DIFF_ELEMENT__SUB_DIFF_ELEMENTS,
				 UML2DiffFactory.eINSTANCE.createUMLDependencyBranchChangeRightTarget()));

		newChildDescriptors.add
			(createChildParameter
				(DiffPackage.Literals.DIFF_ELEMENT__SUB_DIFF_ELEMENTS,
				 UML2DiffFactory.eINSTANCE.createUMLGeneralizationSetChangeLeftTarget()));

		newChildDescriptors.add
			(createChildParameter
				(DiffPackage.Literals.DIFF_ELEMENT__SUB_DIFF_ELEMENTS,
				 UML2DiffFactory.eINSTANCE.createUMLGeneralizationSetChangeRightTarget()));

		newChildDescriptors.add
			(createChildParameter
				(DiffPackage.Literals.DIFF_ELEMENT__SUB_DIFF_ELEMENTS,
				 UML2DiffFactory.eINSTANCE.createUMLDependencyChangeLeftTarget()));

		newChildDescriptors.add
			(createChildParameter
				(DiffPackage.Literals.DIFF_ELEMENT__SUB_DIFF_ELEMENTS,
				 UML2DiffFactory.eINSTANCE.createUMLDependencyChangeRightTarget()));

		newChildDescriptors.add
			(createChildParameter
				(DiffPackage.Literals.DIFF_ELEMENT__SUB_DIFF_ELEMENTS,
				 UML2DiffFactory.eINSTANCE.createUMLExtendChangeLeftTarget()));

		newChildDescriptors.add
			(createChildParameter
				(DiffPackage.Literals.DIFF_ELEMENT__SUB_DIFF_ELEMENTS,
				 UML2DiffFactory.eINSTANCE.createUMLExtendChangeRightTarget()));

		newChildDescriptors.add
			(createChildParameter
				(DiffPackage.Literals.DIFF_ELEMENT__SUB_DIFF_ELEMENTS,
				 UML2DiffFactory.eINSTANCE.createUMLExecutionSpecificationChangeLeftTarget()));

		newChildDescriptors.add
			(createChildParameter
				(DiffPackage.Literals.DIFF_ELEMENT__SUB_DIFF_ELEMENTS,
				 UML2DiffFactory.eINSTANCE.createUMLExecutionSpecificationChangeRightTarget()));

		newChildDescriptors.add
			(createChildParameter
				(DiffPackage.Literals.DIFF_ELEMENT__SUB_DIFF_ELEMENTS,
				 UML2DiffFactory.eINSTANCE.createUMLDestructionEventChangeLeftTarget()));

		newChildDescriptors.add
			(createChildParameter
				(DiffPackage.Literals.DIFF_ELEMENT__SUB_DIFF_ELEMENTS,
				 UML2DiffFactory.eINSTANCE.createUMLDestructionEventChangeRightTarget()));

		newChildDescriptors.add
			(createChildParameter
				(DiffPackage.Literals.DIFF_ELEMENT__SUB_DIFF_ELEMENTS,
				 UML2DiffFactory.eINSTANCE.createUMLIntervalConstraintChangeLeftTarget()));

		newChildDescriptors.add
			(createChildParameter
				(DiffPackage.Literals.DIFF_ELEMENT__SUB_DIFF_ELEMENTS,
				 UML2DiffFactory.eINSTANCE.createUMLIntervalConstraintChangeRightTarget()));

		newChildDescriptors.add
			(createChildParameter
				(DiffPackage.Literals.DIFF_ELEMENT__SUB_DIFF_ELEMENTS,
				 UML2DiffFactory.eINSTANCE.createUMLMessageChangeLeftTarget()));

		newChildDescriptors.add
			(createChildParameter
				(DiffPackage.Literals.DIFF_ELEMENT__SUB_DIFF_ELEMENTS,
				 UML2DiffFactory.eINSTANCE.createUMLMessageChangeRightTarget()));

		newChildDescriptors.add
			(createChildParameter
				(DiffPackage.Literals.DIFF_ELEMENT__SUB_DIFF_ELEMENTS,
				 UML2DiffFactory.eINSTANCE.createUMLStereotypeAttributeChangeLeftTarget()));

		newChildDescriptors.add
			(createChildParameter
				(DiffPackage.Literals.DIFF_ELEMENT__SUB_DIFF_ELEMENTS,
				 UML2DiffFactory.eINSTANCE.createUMLStereotypeAttributeChangeRightTarget()));

		newChildDescriptors.add
			(createChildParameter
				(DiffPackage.Literals.DIFF_ELEMENT__SUB_DIFF_ELEMENTS,
				 UML2DiffFactory.eINSTANCE.createUMLStereotypeUpdateAttribute()));

		newChildDescriptors.add
			(createChildParameter
				(DiffPackage.Literals.DIFF_ELEMENT__SUB_DIFF_ELEMENTS,
				 UML2DiffFactory.eINSTANCE.createUMLStereotypeApplicationAddition()));

		newChildDescriptors.add
			(createChildParameter
				(DiffPackage.Literals.DIFF_ELEMENT__SUB_DIFF_ELEMENTS,
				 UML2DiffFactory.eINSTANCE.createUMLStereotypeApplicationRemoval()));

		newChildDescriptors.add
			(createChildParameter
				(DiffPackage.Literals.DIFF_ELEMENT__SUB_DIFF_ELEMENTS,
				 UML2DiffFactory.eINSTANCE.createUMLStereotypeReferenceChangeLeftTarget()));

		newChildDescriptors.add
			(createChildParameter
				(DiffPackage.Literals.DIFF_ELEMENT__SUB_DIFF_ELEMENTS,
				 UML2DiffFactory.eINSTANCE.createUMLStereotypeReferenceChangeRightTarget()));

		newChildDescriptors.add
			(createChildParameter
				(DiffPackage.Literals.DIFF_ELEMENT__SUB_DIFF_ELEMENTS,
				 UML2DiffFactory.eINSTANCE.createUMLStereotypeUpdateReference()));

		newChildDescriptors.add
			(createChildParameter
				(DiffPackage.Literals.DIFF_ELEMENT__SUB_DIFF_ELEMENTS,
				 UML2DiffFactory.eINSTANCE.createUMLStereotypeReferenceOrderChange()));

		newChildDescriptors.add
			(createChildParameter
				(DiffPackage.Literals.DIFF_ELEMENT__SUB_DIFF_ELEMENTS,
				 UML2DiffFactory.eINSTANCE.createUMLProfileApplicationAddition()));

		newChildDescriptors.add
			(createChildParameter
				(DiffPackage.Literals.DIFF_ELEMENT__SUB_DIFF_ELEMENTS,
				 UML2DiffFactory.eINSTANCE.createUMLProfileApplicationRemoval()));

		newChildDescriptors.add
			(createChildParameter
				(DiffPackage.Literals.DIFF_ELEMENT__SUB_DIFF_ELEMENTS,
				 UML2DiffFactory.eINSTANCE.createUMLElementChangeLeftTarget()));

		newChildDescriptors.add
			(createChildParameter
				(DiffPackage.Literals.DIFF_ELEMENT__SUB_DIFF_ELEMENTS,
				 UML2DiffFactory.eINSTANCE.createUMLElementChangeRightTarget()));
	}

	/**
	 * Return the resource locator for this item provider's resources.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ResourceLocator getResourceLocator() {
		return UML2DiffEditPlugin.INSTANCE;
	}

}
