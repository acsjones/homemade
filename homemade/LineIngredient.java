package homemade;

public class LineIngredient {

	private String ingredient;
	private String unitMeasurement;
	private Double amount;

	public LineIngredient(String ingredient, String unitMeasurement, Double amount) {
		this.ingredient = ingredient;
		this.unitMeasurement = unitMeasurement;
		this.amount = amount;
	}

	public String getIngredient() {
		return ingredient;
	}

	public void setIngredient(String ingredient) {
		this.ingredient = ingredient;
	}

	public String getUnitMeasurement() {
		return unitMeasurement;
	}

	public void setUnitMeasurement(String unitMeasurement) {
		this.unitMeasurement = unitMeasurement;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return amount + " " + unitMeasurement + " " + ingredient;
	}
}