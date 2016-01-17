package thoughtworks.problem.salesTax.products;

import thoughtworks.problem.salesTax.application.Rep;
import thoughtworks.problem.salesTax.constants.Constants;

public class Food extends Product {

	@Rep private double salesTaxPercent = Constants.SALES_TAX_FOR_FOOD;

	public Food(String name, double cost, int quantity, boolean isImported) {
		super(name, cost, quantity, isImported);
	}

	@Override
	public double getSalesTax() {
		return this.salesTaxPercent;
	}

}
