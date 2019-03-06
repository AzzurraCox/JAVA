public class Clothing extends Product
{
	public String size;
	public String color;
	
	public Clothing(String productIdValue, int quantityValue, double unitPriceValue, String sizeValue, String colorValue)
	{
		super(productIdValue, quantityValue, unitPriceValue);
		size = sizeValue;
		color = colorValue;
	}
	@Override
	public void computeTotalCost()
	{
		totalCost = unitPrice * quantity;
	}
	public String toString()
	{
		String reString = "\nClothing:\n";
		reString = "\nProduct ID:\t\t"+productId;
		reString += "\nQuantity:\t\t"+quantity;
		reString += "\nUnit Price:\t\t$"+unitPrice;
		reString +="\nTotal Cost:\t\t$"+totalCost;
		reString += "\nSize:\t\t"+size;
		reString += "\nColor:\t\t"+color;
		return reString;
	}

}
