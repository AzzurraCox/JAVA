public abstract class Product
{
	protected String productId = "?";
	protected int quantity = 0;
	protected double unitPrice = 0.0;
	protected double totalCost = 0.0;
	
	public Product(String productIdValue, int quantityValue, double unitPriceValue)
	{
		productId = productIdValue;
		quantity = quantityValue;
		unitPrice = unitPriceValue;
	}
	
	public String getProductId()
	{
		return productId;
	}
	
	public abstract void computeTotalCost();
	
	public String toString()
	{
		String reString = "\nProduct ID:\t\t"+productId;
		reString += "\nQuantity:\t\t"+quantity;
		reString += "\nUnit Price:\t\t$"+unitPrice;
		reString += "\nTotal Cost:\t\t$"+totalCost+"\n";
		return reString;
	}

}
