import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

public class Student {
	
	public String ID;
	public double[] StuScore;
	public double TotalScore;
	public double AverageScore;
	public String Gpa;
	public double SETttlScore;
	public double Avg;
	public double GETAvgScore;
	public static double[] ALLStuAvgScore = new double[4];
	public static double[] ALLStuStdScore = new double[4];
	public static String Dis;
	static ArrayList<Student> students2 = new ArrayList<>();
	double StuScore1;

	public Student(String id, double[] scores) //get data
	{
		this.ID = id;
		this.StuScore = scores;
		this.StuScore1 = scores[0];
	}

	public static void main(String[] args) {
		

	}
	
	public String getId()  //return ID
	{	
		return this.ID;
	}
	
	public double[] getStuScore() // return Student Score
	{
		return this.StuScore;
	}

	public void setStuTtlScore() // set Student Total Score( included calculate)
	{
		for(int i = 0;i < StuScore.length;i++)
		{
			if(i == 0)
			{
				SETttlScore += StuScore[i]*0.4;
			}
			else if(i == 1)
			{
				SETttlScore += StuScore[i]*0.2;
			}
			else if(i == 2)
			{
				SETttlScore += StuScore[i]*0.2;
			}
			else if(i == 3)
			{
				SETttlScore += StuScore[i]*0.2;
			}
		}
		
	}

	public double getStuTtlScore()  // return Student total score
	{
		return SETttlScore;
	}

	public void setStuAvgScore() //set Student Average Score( included calculate function)
	{
		for(int i = 0;i < StuScore.length;i++)
		{
			TotalScore += StuScore[i];
			if(StuScore[i] > 0 )
			{
				Avg += 1;
			}
		}
		if(TotalScore == 0)
		{
			GETAvgScore = 0;
		}
		else
		{
			GETAvgScore = TotalScore/Avg;
		}
	}

	public double getStuAvgScore()  //return Student Average Score
	{
		return GETAvgScore;
	}

	public void setStuGpa()  //Student GPA calculate
	{
		if(98 <= SETttlScore)
		{
			Gpa = "A+";
		}
		else if (92 <= SETttlScore && SETttlScore < 98)
		{
			Gpa = "A";
		}
		else if (90 <= SETttlScore && SETttlScore < 92)
		{
			Gpa = "A-";
		}
		else if (88 <= SETttlScore && SETttlScore < 90)
		{
			Gpa = "B+";
		}
		else if (82 <= SETttlScore && SETttlScore < 88)
		{
			Gpa = "B";
		}
		else if (80 <= SETttlScore && SETttlScore < 82)
		{
			Gpa = "B-";
		}
		else if (78 <= SETttlScore && SETttlScore < 80)
		{
			Gpa = "C+";
		}
		else if (72 <= SETttlScore && SETttlScore < 78)
		{
			Gpa = "C";
		}
		else if (70 <= SETttlScore && SETttlScore < 72)
		{
			Gpa = "C-";
		}
		else if (60 <= SETttlScore && SETttlScore < 70)
		{
			Gpa = "D";
		}
		else if (SETttlScore < 60)
		{
			Gpa = "F";
		}
	}

	public String getStuGpa() //return GPA
	{
		
		return Gpa;
	}

	public static double[] allStuAvgScore(ArrayList<Student> students) // All Student Average Score
	{
		String stuId = null;
		double a = 0,b = 0,c = 0,d = 0;
		for(Student stu: students) 
		{
			stuId = stu.getId();
			double[] scores = stu.getStuScore();
			a += scores[0];
			b += scores[1];
			c += scores[2];
			d += scores[3];
		}
		double stuId2 = Integer.parseInt(stuId);
		ALLStuAvgScore[0] = Math.round((a/stuId2)*100.0)/100.0;
		ALLStuAvgScore[1] = Math.round((b/stuId2)*100.0)/100.0;
		ALLStuAvgScore[2] = Math.round((c/stuId2)*100.0)/100.0;
		ALLStuAvgScore[3] = Math.round((d/stuId2)*100.0)/100.0;
		
		return ALLStuAvgScore;			//return ALL STUDENT AVERAGE SCORE
	}

	public static double[] allStuStd(ArrayList<Student> students) //All Student Standard Deviation(variance)
	{
		String stuId = null;
		double[] ALLStuStd = new double[4];
		for(Student stu: students) 
		{
			stuId = stu.getId();
			double[] scores = stu.getStuScore();
			ALLStuStdScore[0] += (scores[0] - ALLStuAvgScore[0])*(scores[0] - ALLStuAvgScore[0]);
			ALLStuStdScore[1] += (scores[1] - ALLStuAvgScore[1])*(scores[1] - ALLStuAvgScore[1]);
			ALLStuStdScore[2] += (scores[2] - ALLStuAvgScore[2])*(scores[2] - ALLStuAvgScore[2]);
			ALLStuStdScore[3] += (scores[3] - ALLStuAvgScore[3])*(scores[3] - ALLStuAvgScore[3]);
		}
		double stuId2 = Integer.parseInt(stuId);
		
		for(int i = 0; i < ALLStuStdScore.length;i++)
		{
			ALLStuStdScore[i] = ALLStuStdScore[i]/stuId2;
			
			double a;
			double squareRoot =  ALLStuStdScore[i]/ 2; //Square root function
			
			do 
			{
				a = squareRoot;
				squareRoot = (a+(ALLStuStdScore[i]/a))/2;
			}while ((a - squareRoot) != 0);
			
			ALLStuStdScore[i] = squareRoot;
		}
		return ALLStuStdScore;
	}

	public static void gradeDistribution(ArrayList<Student> students) // grade distribution calculate
	{
		int a = 0,b = 0,c = 0,d = 0,e = 0,f = 0,g = 0,h = 0,i = 0,j = 0,k = 0;
		for(Student stu: students) 
		{
			String gpa = stu.getStuGpa();
			if(gpa == "A+")
			{
				a+=1;
			}
			else if(gpa == "A")
			{
				b+=1;
			}
			else if(gpa == "A-")
			{
				c+=1;
			}
			else if(gpa == "B+")
			{
				d+=1;
			}
			else if(gpa == "B")
			{
				e+=1;
			}
			else if(gpa == "B-")
			{
				f+=1;
			}
			else if(gpa == "C+")
			{
				g+=1;
			}
			else if(gpa == "C")
			{
				h+=1;
			}
			else if(gpa == "C-")
			{
				i+=1;
			}
			else if(gpa == "D")
			{
				j+=1;
			}
			else if(gpa == "F")
			{
				k+=1;
			}
		}
		Dis = "A+ = \t"+a+"\nA  =\t"+b+"\nA- =\t"+c+"\nB+ =\t"+d+"\nB  =\t"+e+"\nB- =\t"+f+"\nC+ =\t"+g+"\nC  =\t"+h+"\nC- =\t"+i+"\nD =\t"+j+"\nF  =\t"+k;
		System.out.println(Dis);
		return;

	}

	public static ArrayList<Student> scoreSorting(ArrayList<Student> students, String string) //score sorting by MIDTERM
	{
		students2 = students;
		StudentScoreComparator comparator;
		comparator = new StudentScoreComparator();
		
		 students2.sort(comparator);
		return students;
	}
	
	
	public double getscore()
	{
		return StuScore1;
	}
}

class StudentScoreComparator implements Comparator<Student> //Sorting Function (comparator)
{
	 
    @Override
    public int compare(Student e1, Student e2) {
        if(e1.getscore() < e2.getscore()){
            return 1;
        } else {
            return -1;
        }

    }
}
