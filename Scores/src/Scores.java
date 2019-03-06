// Assignment #: CCU OOT Assignment #2
//         Name: Ong Hong Xiang
//    StudentID: 4055300028

//  Description: Calculate the Scores.

import java.util.Scanner;

public class Scores {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		
		Scanner scanner = new Scanner(System.in);						//scanner open.
		
		String scores;
		
		System.out.print("Please enter the Scores: ");					//input data.
		scores = scanner.nextLine();
		
		while(scores.length() == 0)										//check the input data.
		{
			System.out.print("Please enter the Scores: ");
			scores = scanner.nextLine();
		}
		
		String array[] = scores.split(" ");								//separate the data into array.
		
		int array1[] = new int[(array.length-1)];						//new array.
		
		if (Integer.parseInt(array[array.length - 1]) == -1)			//the data with -1 at last.
		{
			for(int i=0;i < (array.length-1);i++)
			{
				array1[i] = Integer.parseInt(array[i]);					//convert the data to integer.
			}
			
			if(array1 != null)											//if data not null.
			{
				int a = 0;
				for(int i = 0; i <array1.length; i++)					//for data is 0.
				{
					a += array1[0];
				}
				
				if(a == 0)
				{
					System.out.println("The min score is: "+a);
					System.out.println("The max score is: "+a);
					System.out.println("The avg score is: "+a);
					System.out.println("The number of score 90 is: "+a);
					System.out.println("Score Not improving!");
					System.out.println("The stdDev is: "+a);
					System.out.println("The adjusted ave score is: "+a);
				}			
				
				else
				{
				System.out.println("The min score is: "+minScore(array1));				//send to method and calculate data.
				System.out.println("The max score is: "+maxScore(array1));
			
				double mean = avgScore(array1);
				System.out.println("The avg score is: "+mean);
				System.out.println("The number of score 90 is: "+numOfNinety(array1));
			
				boolean diff = adjacentDiff(array1);
				if(diff == true)
				{
					System.out.println("Score improving!");
				}
				else
				{
					System.out.println("Score Not improving!");
				}
			
				System.out.println("The stdDev is: "+stdDeviation(array1,mean));
				System.out.println("The adjusted ave score is: "+squareRoot(avgScore(array1))*10);
				}
			}
		}
		else
		{	
			int array2[] = new int[(array.length)];					//the data with no -1 at last.
			
			for(int i=0;i<array.length;i++)
			{
				array2[i] = Integer.parseInt(array[i]);
			}if(array2 != null)
			{
				int a = 0;
				for(int i = 0; i <array2.length; i++)
				{
					a += array2[i];
				}
				
				if(a == 0)
				{
					System.out.println("The min score is: "+a);
					System.out.println("The max score is: "+a);
					System.out.println("The avg score is: "+a);
					System.out.println("The number of score 90 is: "+a);
					System.out.println("Score Not improving!");
					System.out.println("The stdDev is: "+a);
					System.out.println("The adjusted ave score is: "+a);
				}			
				
				else
				{
				System.out.println("The min score is: "+minScore(array2));
				System.out.println("The max score is: "+maxScore(array2));
			
				double mean = avgScore(array2);
				System.out.println("The avg score is: "+mean);
				System.out.println("The number of score 90 is: "+numOfNinety(array2));
			
				boolean diff = adjacentDiff(array2);
				if(diff == true)
				{
					System.out.println("Score improving!");
				}
				else
				{
					System.out.println("Score Not improving!");
				}
			
				System.out.println("The stdDev is: "+stdDeviation(array2,mean));
				System.out.println("The adjusted ave score is: "+squareRoot(avgScore(array2))*10);
				}
			}
		}
	}
	
	public static int maxScore(int[] array)					//method calculate the maxScore.
	{
		int maxScore = array[0];							//assign first score.
	    for (int i = 1; i < array.length; i++) 				//compare the number.
	    {													//if the number is bigger than other,than change to that number
	        if (array[i] > maxScore) 						//and continue compare.
	        {												
	            maxScore = array[i];
	        }
	    }
	    
	    return maxScore;									//return the result.
	}
	
	public static int minScore(int[] array)					//method calculate the minScore.
	{
		int minScore = array[0];							//assign first score.
	    for (int i = 1; i < array.length; i++) 				//compare the number.
	    {
	        if (array[i] < minScore)						//if the number is smaller than other,than change to that number
	        {												//and continue compare.
	            minScore = array[i];
	            System.out.println(array[i]);
	        }    
	    }
	    
	    return minScore;
	}
	
	public static double avgScore(int[] array)				//method calculate the avgScore.
	{
		double AllScores = 0;
		
		for(int i = 0; i < array.length; i++)				//add all score.
		{
			AllScores += array[i];
		}
		
		double avg = AllScores/array.length;				//total divide the N of score.
		
		return avg;
	}
		
	public static int numOfNinety(int[] array)				//method calculate the numOfNinety.
	{
		int num = 0;
		
	    for (int i = 0; i < array.length; i++) {			//check all the number with 90 about.
	        if (array[i] >= 90) {							//number +1.
	            num += 1;
	        }
	    }
	    
	    return num;
	}
	
	public static boolean adjacentDiff(int[] array)			//check the scores is improving or not improving
	{
		boolean Diff = true;
		if(array.length == 1)								//for 1 score only.
		{
			return Diff;
		}

		else
		{
		for (int i = 1; i < array.length; i++)				//for N score compare.
		{
			if(array[i-1] <= array[i])						//if second score bigger than first score,return true;
			{
				Diff = true;
			}
			else if (i == array.length)						//prevent error
			{
				if(array[i-1] <= array[i])
				{
					Diff = true;
				}
				
				else
				{
					Diff = false;
				}
			}
			
			else
			{
				Diff = false;
			}
		}
		}
		
		return Diff;
		}
	
	public static double squareRoot(double mean)		//squareRoot method
	{
		double a;
		double squareRoot = mean / 2;
		
		do 
		{
			a = squareRoot;
			squareRoot = (a+(mean/a))/2;
		}while ((a - squareRoot) != 0);
		
		return squareRoot;
	}
	
	public static double stdDeviation(int[] array, double mean)		//Standard Deviation method
	{
		double s = 0;
		double total = 0, result;
		
		for(int i = 0; i < array.length;i++)
		{
			s = array[i] - mean;
			total += s*s;
		}
		
		result = total/array.length;
		
		return squareRoot(result);
	}
}