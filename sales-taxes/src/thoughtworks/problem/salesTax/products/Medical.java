package thoughtworks.problem.salesTax.products;

import thoughtworks.problem.salesTax.application.Rep;
import thoughtworks.problem.salesTax.constants.Constants;

public class Medical extends Product {

	@Rep private double salesTaxPercent = Constants.SALES_TAX_FOR_MEDICAL;

	public Medical(String name, double cost, int quantity, boolean isImported) {
		super(name, cost, quantity, isImported);
	}

	@Override
	public double getSalesTax() {
		return this.salesTaxPercent;
	}

}
