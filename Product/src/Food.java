
public class Food extends Product
{
	public String name;
	public String expirationDate;
	public double damageRate;
	
	public Food(String productIdValue, int quantityValue, double unitPriceValue, String nameValue, double damageRateValue, String expirationDateValue)
	{
		super(productIdValue, quantityValue, unitPriceValue);
		name = nameValue;
		expirationDate = expirationDateValue;
		damageRate = damageRateValue;
	}
	@Override
	public void computeTotalCost()
	{
		totalCost = (unitPrice * quantity)*(1 + damageRate);
	}
	public String toString()
	{
		String reString = "\nClothing:\n";
		reString = "\nProduct ID:\t\t"+productId;
		reString += "\nQuantity:\t\t"+quantity;
		reString += "\nUnit Price:\t\t$"+unitPrice;
		reString +="\nTotal Cost:\t\t$"+totalCost;
		reString += "\nname:\t\t"+name;
		reString += "\nexpirationDate:\t\t"+expirationDate;
		reString += "\ndamageRate:\t\t"+damageRate;
		return reString;
	}
}
