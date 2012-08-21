/*******************************************************************************
 * Copyright (c) 2011, 2012 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.emf.compare.uml2.diff.internal.extension.usecase;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.compare.Diff;
import org.eclipse.emf.compare.DifferenceKind;
import org.eclipse.emf.compare.ReferenceChange;
import org.eclipse.emf.compare.uml2.IncludeChange;
import org.eclipse.emf.compare.uml2.UMLCompareFactory;
import org.eclipse.emf.compare.uml2.UMLDiff;
import org.eclipse.emf.compare.uml2.diff.internal.extension.UMLAbstractDiffExtensionFactory;
import org.eclipse.emf.compare.utils.MatchUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.uml2.uml.Include;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * Factory for UMLExtendChangeLeftTarget.
 */
public class UMLIncludeChangeFactory extends UMLAbstractDiffExtensionFactory {

	public Class<? extends UMLDiff> getExtensionKind() {
		return IncludeChange.class;
	}

	@Override
	protected UMLDiff createExtension() {
		return UMLCompareFactory.eINSTANCE.createIncludeChange();
	}

	@Override
	protected EObject getDiscriminantFromDiff(Diff input) {
		EObject result = null;
		final DifferenceKind kind = getRelatedExtensionKind(input);
		if (kind == DifferenceKind.ADD || kind == DifferenceKind.DELETE) {
			result = ((ReferenceChange)input).getValue();
		} else if (kind == DifferenceKind.CHANGE) {
			final EObject container = MatchUtil.getContainer(input.getMatch().getComparison(), input);
			if (container instanceof Include) {
				result = container;
			}
		}
		return result;
	}

	@Override
	protected List<EObject> getPotentialChangedValuesFromDiscriminant(EObject discriminant) {
		List<EObject> result = new ArrayList<EObject>();
		if (discriminant instanceof Include) {
			result.add(((Include)discriminant).getAddition());
		}
		return result;
	}

	@Override
	protected DifferenceKind getRelatedExtensionKind(Diff input) {
		if (input instanceof ReferenceChange) {
			if (isRelatedToAnExtensionChange((ReferenceChange)input)) {
				return DifferenceKind.CHANGE;
			} else if (isRelatedToAnExtensionAdd((ReferenceChange)input)) {
				return DifferenceKind.ADD;
			} else if (isRelatedToAnExtensionDelete((ReferenceChange)input)) {
				return DifferenceKind.DELETE;
			}
		}
		return null;
	}

	protected boolean isRelatedToAnExtensionAdd(ReferenceChange input) {
		return input.getReference().isContainment() && input.getKind().equals(DifferenceKind.ADD)
				&& input.getValue() instanceof Include && ((Include)input.getValue()).getAddition() != null;
	}

	protected boolean isRelatedToAnExtensionDelete(ReferenceChange input) {
		return input.getReference().isContainment() && input.getKind().equals(DifferenceKind.DELETE)
				&& input.getValue() instanceof Include;
	}

	protected boolean isRelatedToAnExtensionChange(ReferenceChange input) {
		return input.getReference().equals(UMLPackage.Literals.INCLUDE__ADDITION);
	}

}