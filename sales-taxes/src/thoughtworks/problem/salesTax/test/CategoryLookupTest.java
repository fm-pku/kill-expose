package thoughtworks.problem.salesTax.test;

import junit.framework.TestCase;

import org.junit.Before;
import org.junit.Test;

import thoughtworks.problem.salesTax.application.CategoryLookup;
import thoughtworks.problem.salesTax.application.Rep;
import thoughtworks.problem.salesTax.constants.Constants;

public class CategoryLookupTest extends TestCase {

	@Rep CategoryLookup lookup;

	@Override
	@Before
	public void setUp() throws Exception {
		lookup = CategoryLookup.getInstance();
	}

	@Test
	public void testObjectCreation() {
		assertNotNull(lookup);
	}

	@Test
	public void testcheckSingletonBehavior() {
		CategoryLookup newLookup = CategoryLookup.getInstance();
		assertSame(lookup, newLookup);

	}

	@Test
	public void testDefaultLookupValuesPresent() {
		String category = null;
		category = lookup.getCategoryFor("book");
		assertEquals(category, Constants.OFFICE_SUPPLIES);
		category = lookup.getCategoryFor("books");
		assertEquals(category, Constants.OFFICE_SUPPLIES);
		category = lookup.getCategoryFor("chocolate");
		assertEquals(category, Constants.FOOD_PRODUCT);
		category = lookup.getCategoryFor("chocolates");
		assertEquals(category, Constants.FOOD_PRODUCT);
		category = lookup.getCategoryFor("pills");
		assertEquals(category, Constants.MEDICAL_PRODUCT);
		category = lookup.getCategoryFor("productNameNotInTheLookup");
		assertFalse("Invalid product category returned", category.equals(Constants.OFFICE_SUPPLIES));

	}

	@Test
	public void testCanAddProduct() {
		lookup.addProduct("MacBook", "Electronics");
		String category = lookup.getCategoryFor("MacBook");
		assertEquals(category, "Electronics");

	}

	@Test
	public void testCanRemoveProduct() {
		lookup.addProduct("MacBook", "Electronics");
		String category = lookup.getCategoryFor("MacBook");
		assertEquals(category, "Electronics");
		lookup.removeProduct("MacBook");
		category = lookup.getCategoryFor("MacBook");
		assertFalse(category.equals("Electronics"));

	}

}
