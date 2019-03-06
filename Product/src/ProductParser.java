import java.util.ArrayList;
import java.util.Scanner;

public class ProductParser 
{
	private static Scanner scan;
	public static ArrayList<String> listArray;

	public static Product parseStringToProduct(String lineToParse)
	{
	scan = new Scanner(lineToParse);
	scan.useDelimiter("/");
	listArray = new ArrayList<String>();
	
	while(scan.hasNext())
	{
		listArray.add(scan.nextLine());
	}
	
	String productId, size, color, name, expirationDate;
	int quantity;
	double unitPrice, damageRate;
	
	productId = listArray.get(1);
	quantity = Integer.parseInt(listArray.get(2));
	unitPrice = Double.parseDouble(listArray.get(3));
	Product output = new Food("ERROR",0,0,"ERROR",0,"ERROR");
	
	if(listArray.get(0).toLowerCase().equals("clothing"))
	{
		size = listArray.get(4);
		color = listArray.get(5);
		output = new Clothing(productId,quantity,unitPrice,size,color);
	}
	
	if(listArray.get(0).toLowerCase().equals("food"))
	{
		name = listArray.get(4);
		damageRate = Double.parseDouble(listArray.get(5));
		expirationDate = listArray.get(6);
		output = new Food(productId,quantity,unitPrice,name,damageRate,expirationDate);
	}
	return output;
	}

}
