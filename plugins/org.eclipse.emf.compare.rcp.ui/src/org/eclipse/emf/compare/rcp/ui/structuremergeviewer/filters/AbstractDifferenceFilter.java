package org.eclipse.emf.compare.rcp.ui.structuremergeviewer.filters;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates;

import org.eclipse.emf.compare.Comparison;
import org.eclipse.emf.compare.scope.IComparisonScope;
import org.eclipse.emf.ecore.EObject;

/**
 * An abstract filter implementation.
 * 
 * @author <a href="mailto:axel.richard@obeo.fr">Axel Richard</a>
 * @since 3.0
 */
public abstract class AbstractDifferenceFilter implements IDifferenceFilter {

	/** A human-readable label for this filter. This will be displayed in the EMF Compare UI. */
	protected String label;

	/** The initial activation state of the filter. */
	protected boolean activeByDefault;

	/**
	 * Constructs the filter with the appropriate predicate.
	 */
	public AbstractDifferenceFilter() {
		super();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.compare.rcp.ui.structuremergeviewer.filters.IDifferenceFilter#getPredicateWhenSelected()
	 */
	public abstract Predicate<? super EObject> getPredicateWhenSelected();

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.compare.rcp.ui.structuremergeviewer.filters.IDifferenceFilter#getPredicateWhenUnselected()
	 */
	public Predicate<? super EObject> getPredicateWhenUnselected() {
		return Predicates.alwaysFalse();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.compare.rcp.ui.structuremergeviewer.filters.IDifferenceFilter#getLabel()
	 */
	public String getLabel() {
		return label;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.compare.rcp.ui.structuremergeviewer.filters.IDifferenceFilter#setLabel(java.lang.String)
	 */
	public void setLabel(String label) {
		this.label = label;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.compare.rcp.ui.structuremergeviewer.filters.IDifferenceFilter#defaultSelected()
	 */
	public boolean defaultSelected() {
		return activeByDefault;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.compare.rcp.ui.structuremergeviewer.filters.IDifferenceFilter#setDefaultSelected(boolean)
	 */
	public void setDefaultSelected(boolean activeByDefault) {
		this.activeByDefault = activeByDefault;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.compare.rcp.ui.structuremergeviewer.filters.IDifferenceFilter#isEnabled(org.eclipse.emf.compare.scope.IComparisonScope,
	 *      org.eclipse.emf.compare.Comparison)
	 */
	public boolean isEnabled(IComparisonScope scope, Comparison comparison) {
		return true;
	}

}