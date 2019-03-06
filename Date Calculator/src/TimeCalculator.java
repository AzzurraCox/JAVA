// Assignment #: CCU OOT Assignment #1
//         Name: Ong Hong Xiang
//    StudentID: 4055300028

//  Description: Calculate the Range between two Time.

import java.util.Scanner;

public class TimeCalculator {

	private static Scanner scanner;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String time1,time2;
		int hh1, mm1 = 00;
		int hh2, mm2;
		int hh3 = 0,mm3 = 0;
		scanner = new Scanner(System.in);
		
		System.out.print("Please enter the first Time :");	//First time input
		time1 = scanner.next();
		
		while(time1.length() < 4 || time1.length() > 4) 	//Check the input Length is correct
		{
			System.out.println("please enter the correct military time for First Time");
			time1 = scanner.next();
		}
		
		hh1 = Integer.parseInt(time1.substring(0,2));		//Convert data type and separate the Hour and Minute
		mm1 = Integer.parseInt(time1.substring(2,4));

		while((hh1 < 0 || hh1 > 24) || (mm1 < 0 || mm1 > 60))//check the input time is correct
		{
			System.out.println("please enter the correct military time for First Time");
			time1 = scanner.next();
			hh1 = Integer.parseInt(time1.substring(0,2));
			mm1 = Integer.parseInt(time1.substring(2,4));
		}
		
		
		System.out.print("Please enter the second Time :");		//Second time input
		time2 = scanner.next();
		
		while(time2.length() < 4 || time2.length() >4)			//Check the input length is correct
		{
			System.out.println("please enter the correct military time for Second Time");
			time2 = scanner.next();
		}
		
		hh2 = Integer.parseInt(time2.substring(0,2));		//Covert the data type and separate Hour and Minute
		mm2 = Integer.parseInt(time2.substring(2,4));
		
		while((hh2 < 0 || hh2 > 24) || (mm2 < 0 || mm2 > 60))//Check the input time is correct
		{
			System.out.println("please enter the correct military time for second Time");
			time2 = scanner.next();
			hh2 = Integer.parseInt(time2.substring(0,2));
			mm2 = Integer.parseInt(time2.substring(2,4));
		}
		
		if(hh2 > hh1 || mm2 > mm1)							//Calculate the time if Time2 bigger than Time1
		{
			mm3 = mm2 - mm1;
			hh3 = hh2 - hh1;
			if(mm3< 0)
			{
				hh3 = hh3 - 1;
				mm3 = mm3 + 60;
			}
		}
		else if (hh1 > hh2 || mm1>mm2)						//calculate if The Time1 bigger than Time2
		{
			mm3 = (60 - mm1)+ mm2;
			hh3 = (23 - hh1)+ hh2;
			if(mm3 == 60)
			{
				mm3 = 0;
				hh3 = hh3 + 1;
			}
			
		}
		
		System.out.format("The duration between these two times is "+ hh3 +" hours " + mm3 + " minutes"); //Result Output
		
	}
}