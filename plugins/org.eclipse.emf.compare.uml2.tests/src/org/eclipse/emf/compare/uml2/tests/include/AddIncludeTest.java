package org.eclipse.emf.compare.uml2.tests.include;

import static com.google.common.base.Predicates.and;
import static com.google.common.base.Predicates.instanceOf;
import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertSame;
import static junit.framework.Assert.assertTrue;
import static org.eclipse.emf.compare.uml2.tests.UMLComparePredicates.added;
import static org.eclipse.emf.compare.uml2.tests.UMLComparePredicates.changedReference;
import static org.eclipse.emf.compare.uml2.tests.UMLComparePredicates.ofKind;
import static org.eclipse.emf.compare.uml2.tests.UMLComparePredicates.removed;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterators;

import java.io.IOException;
import java.util.List;

import org.eclipse.emf.compare.Comparison;
import org.eclipse.emf.compare.Diff;
import org.eclipse.emf.compare.DifferenceKind;
import org.eclipse.emf.compare.EMFCompare;
import org.eclipse.emf.compare.uml2.IncludeChange;
import org.eclipse.emf.compare.uml2.tests.AbstractTest;
import org.eclipse.emf.compare.uml2.tests.include.data.IncludeInputData;
import org.eclipse.emf.ecore.resource.Resource;
import org.junit.Test;

@SuppressWarnings("nls")
public class AddIncludeTest extends AbstractTest {

	private IncludeInputData input = new IncludeInputData();

	@Test
	public void testA10UseCase() throws IOException {
		final Resource left = input.getA1Left();
		final Resource right = input.getA1Right();

		final Comparison comparison = EMFCompare.compare(left, right);
		testAB1(TestKind.ADD, comparison);
	}

	@Test
	public void testA11UseCase() throws IOException {
		final Resource left = input.getA1Left();
		final Resource right = input.getA1Right();

		final Comparison comparison = EMFCompare.compare(right, left);
		testAB1(TestKind.DELETE, comparison);
	}

	private static void testAB1(TestKind kind, final Comparison comparison) {
		final List<Diff> differences = comparison.getDifferences();

		// We should have no less and no more than 4 differences
		assertSame(Integer.valueOf(4), Integer.valueOf(differences.size()));

		Predicate<? super Diff> addExtendDescription = null;
		Predicate<? super Diff> changeRefExtendedCaseInExtendDescription = null;

		if (kind.equals(TestKind.DELETE)) {
			addExtendDescription = removed("model.UseCase1.include"); //$NON-NLS-1$
			changeRefExtendedCaseInExtendDescription = changedReference("model.UseCase1.include", "addition",
					"model.UseCase", null);
		} else {
			addExtendDescription = added("model.UseCase1.include"); //$NON-NLS-1$
			changeRefExtendedCaseInExtendDescription = changedReference("model.UseCase1.include", "addition",
					null, "model.UseCase");
		}

		final Diff addExtend = Iterators.find(differences.iterator(), addExtendDescription);
		final Diff addRefExtendedCaseInExtend = Iterators.find(differences.iterator(),
				changeRefExtendedCaseInExtendDescription);

		assertNotNull(addExtend);
		assertNotNull(addRefExtendedCaseInExtend);

		// CHECK EXTENSION
		assertSame(Integer.valueOf(2), count(differences, instanceOf(IncludeChange.class)));
		Diff addUMLExtend = null;
		Diff changeUMLExtend = Iterators.find(differences.iterator(), and(instanceOf(IncludeChange.class),
				ofKind(DifferenceKind.CHANGE)));
		assertNotNull(changeUMLExtend);
		if (kind.equals(TestKind.ADD)) {
			addUMLExtend = Iterators.find(differences.iterator(), and(instanceOf(IncludeChange.class),
					ofKind(DifferenceKind.ADD)));
			assertNotNull(addUMLExtend);
			assertSame(Integer.valueOf(1), Integer.valueOf(addUMLExtend.getRefinedBy().size()));
			assertTrue(addUMLExtend.getRefinedBy().contains(addRefExtendedCaseInExtend));
			assertSame(Integer.valueOf(1), Integer.valueOf(changeUMLExtend.getRefinedBy().size()));
			assertTrue(changeUMLExtend.getRefinedBy().contains(addRefExtendedCaseInExtend));
		} else {
			addUMLExtend = Iterators.find(differences.iterator(), and(instanceOf(IncludeChange.class),
					ofKind(DifferenceKind.DELETE)));
			assertNotNull(addUMLExtend);
			assertSame(Integer.valueOf(1), Integer.valueOf(addUMLExtend.getRefinedBy().size()));
			assertTrue(addUMLExtend.getRefinedBy().contains(addExtend));
			assertSame(Integer.valueOf(1), Integer.valueOf(changeUMLExtend.getRefinedBy().size()));
			assertTrue(changeUMLExtend.getRefinedBy().contains(addRefExtendedCaseInExtend));
		}

		// CHECK REQUIREMENT
		if (kind.equals(TestKind.ADD)) {
			assertSame(Integer.valueOf(1), Integer.valueOf(addRefExtendedCaseInExtend.getRequires().size()));
			assertTrue(addRefExtendedCaseInExtend.getRequires().contains(addExtend));

			assertSame(Integer.valueOf(1), Integer.valueOf(changeUMLExtend.getRequires().size()));
			assertTrue(changeUMLExtend.getRequires().contains(addUMLExtend));

			assertSame(Integer.valueOf(0), Integer.valueOf(addExtend.getRequires().size()));
			assertSame(Integer.valueOf(0), Integer.valueOf(addUMLExtend.getRequires().size()));
		} else {
			assertSame(Integer.valueOf(0), Integer.valueOf(addRefExtendedCaseInExtend.getRequires().size()));

			assertSame(Integer.valueOf(0), Integer.valueOf(changeUMLExtend.getRequires().size()));

			assertSame(Integer.valueOf(1), Integer.valueOf(addExtend.getRequires().size()));
			assertTrue(addExtend.getRequires().contains(addRefExtendedCaseInExtend));

			assertSame(Integer.valueOf(1), Integer.valueOf(addUMLExtend.getRequires().size()));
			assertTrue(addUMLExtend.getRequires().contains(changeUMLExtend));
		}

		// CHECK EQUIVALENCE
		assertSame(Integer.valueOf(0), Integer.valueOf(comparison.getEquivalences().size()));

	}

}