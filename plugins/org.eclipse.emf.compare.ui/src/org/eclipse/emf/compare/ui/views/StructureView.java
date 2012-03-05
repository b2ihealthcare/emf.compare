/*******************************************************************************
 * Copyright (c) 2006, 2012 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.emf.compare.ui.views;

import java.util.List;

import org.eclipse.compare.CompareConfiguration;
import org.eclipse.emf.compare.ui.viewer.filter.IDifferenceFilter;
import org.eclipse.emf.compare.ui.viewer.group.IDifferenceGroupingFacility;
import org.eclipse.emf.compare.ui.viewer.structure.StructureViewer;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.part.ViewPart;

/**
 * View to display compare structure.
 * 
 * @author Cedric Notot <a href="mailto:cedric.notot@obeo.fr">cedric.notot@obeo.fr</a>
 */
public class StructureView extends ViewPart {

	/**
	 * The ID of the view as specified by the extension.
	 */
	public static final String VIEW_ID = "org.eclipse.emf.compare.ui.views.StructureView"; //$NON-NLS-1$

	/**
	 * The compare structure viewer.
	 */
	private StructureViewer viewer;

	/**
	 * The input.
	 */
	private Object input;

	/**
	 * The constructor.
	 */
	public StructureView() {
		/*
		 * nothing to do.
		 */
	}

	/**
	 * The constructor.
	 * 
	 * @param pInput
	 *            The input.
	 */
	public StructureView(Object pInput) {
		input = pInput;
	}

	/**
	 * The constructor.
	 * 
	 * @param pInput
	 *            The input.
	 * @param filters
	 *            The filters to apply.
	 * @param groupingFacility
	 *            The groups to use.
	 */
	public StructureView(Object pInput, List<IDifferenceFilter> filters,
			IDifferenceGroupingFacility groupingFacility) {
		input = pInput;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.ui.part.WorkbenchPart#createPartControl(org.eclipse.swt.widgets.Composite)
	 */
	@Override
	public void createPartControl(Composite parent) {
		viewer = new StructureViewer(parent, new CompareConfiguration());
		viewer.setInput(input);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.ui.part.WorkbenchPart#setFocus()
	 */
	@Override
	public void setFocus() {
		viewer.getControl().setFocus();
	}

	/**
	 * Set the input of the viewer related to this view.
	 * 
	 * @param pInput
	 *            The input.
	 */
	public void setInput(Object pInput) {
		input = pInput;
		viewer.setInput(input);
	}

	/**
	 * Returns the filters.
	 * 
	 * @return The filters.
	 */
	public List<IDifferenceFilter> getDifferenceFilters() {
		return viewer.getDifferenceFilters();
	}

	/**
	 * Sets the value of filters to filters.
	 * 
	 * @param filters
	 *            The filters to set.
	 */
	public void setDifferenceFilters(List<IDifferenceFilter> filters) {
		viewer.setDifferenceFilters(filters);
	}

	/**
	 * Returns the groupingFacility.
	 * 
	 * @return The groupingFacility.
	 */
	public IDifferenceGroupingFacility getDifferenceGroupingFacility() {
		return viewer.getDifferenceGroupingFacility();
	}

	/**
	 * Sets the value of groupingFacility to groupingFacility.
	 * 
	 * @param groupingFacility
	 *            The groupingFacility to set.
	 */
	public void setDifferenceGroupingFacility(IDifferenceGroupingFacility groupingFacility) {
		viewer.setDifferenceGroupingFacility(groupingFacility);
	}

}
