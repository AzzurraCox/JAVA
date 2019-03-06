// Assignment #: 3
// Name: Ong Hong Xiang
// StudentID: 405530028
// Lecture:
// Description: Car class get and set the year color price and use makes class data
// Time spent:
public class Car 
{
	public String year;
	public String color;
	public double price;
	public Makes makes;
	
	public Car()
	{
		year = "?";
		color = "?";
		price = 0.0;
		makes = new Makes();
	}
	
	public String getYear()
	{
		return this.year;
	}
	
	public String getColor()
	{
		return this.color;
	}
	
	public double getPrice()
	{
		return this.price;
	}
	
	public Makes getMakes()
	{
		return this.makes;
	}
	
	public void setYear(String nYear)
	{
		this.year = nYear;
	}
	
	public void setColor(String nColor)
	{
		this.color = nColor;
	}
	
	public void setPrice(double nPrice)
	{
		this.price = nPrice;
	}
	
	public void setMakes(String nCountry, String nManufac, String nBrand)
	{
		this.makes.setCountry(nCountry);
		this.makes.setManufac(nManufac);
		this.makes.setBrand(nBrand);
	}
	
	public String toString()
	{
		return "\nYear:\t\t"+getYear()+"\nColor:\t\t"+getColor()+"\nPrice:\t\t"+getPrice()+"\n";
	}

}
