// Assignment #: 3
// Name: Ong Hong Xiang
// StudentID: 405530028
// Lecture:
// Description: Makes class get and set the country,manufacturer,brand name data
// Time spent:
public class Makes {

	public String country;
	public String manufacturer;
	public String brandName;
	
	public Makes()
	{
		country = "?";
		manufacturer = "?";
		brandName = "?";
	}

	public String getCountry()
	{
		return this.country;
	}
	public String getManufac()
	{
		return this.manufacturer;
	}
	public String getBrand()
	{
		return this.brandName;
	}
	
	public void setCountry(String nCountry)
	{
		this.country = nCountry;
	}
	public void setManufac(String nManufac)
	{
		this.manufacturer = nManufac;
	}

	public void setBrand(String nBrand)
	{
		this.brandName = nBrand;
	}
	
	public String toString()
	{
		return "Country:\t"+getCountry()+"\nManufacturer:\t"+getManufac()+"\nBrand:\t\t"+getBrand();
	}
}
