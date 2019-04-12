package statistic;

import java.util.Arrays;
import java.util.Scanner;

public class Sort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double a = 0;
		double b = 0;
		double mean = 0;
		
	double[] arr = {3.59,3.59,4.79,3.56,3.55,3.71,3.65,3.6,3.75,3.56,3.57,3.59,3.55,3.99,4.15,3.66,3.63,3.73,3.61,3.57};
	
	Arrays.sort(arr);
	
	System.out.println(Arrays.toString(arr));
	
	for(int i = 0; i<arr.length;i++)
	{ 
		a += arr[i];
	}
	
	System.out.println("total: "+ a);
	
	mean = a/arr.length;
	System.out.println("mean: "+ mean);
	
	for(int i = 0; i < arr.length; i++)
	{
		b += Math.pow(arr[i]-mean, 2);
	}
	
	System.out.println("Standard deviation: "+ Math.sqrt(b/(arr.length-1)));
	}
}