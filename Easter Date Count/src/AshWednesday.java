import java.util.Date;
import java.util.Calendar;

/**
 * Assigment #: 2
 * Name: Ong Hong Xiang
 * StudentID: 405530028
 * Description: Implement Gauss's algorithm and calculate Ash Wednesday.
 * Time spent: 4 hours
 */
public class AshWednesday 
{
/**
 * private constructor: class can't be instantiated
 */
	private AshWednesday()
	{
		
	}
	/**
	 * calculate Easter
	 */
	public static String calculateEaster(int selectYear)
{
		String return_str = "";
		String return_str2 = "";
		Date dt;
		int MO;
		int DA;
		int Y = selectYear,M = 24, N= 5;
		int a = Y % 19;
		int b = Y % 4;
		int c = Y % 7;
		int d = (19*a + M) % 30;
		int e = (2*b + 4*c + 6*d + N) % 7;
		
		if(d+e <10)
		{
			dt = new Date(selectYear,3,(d+e+22));
			return_str = "In "+selectYear+", Easter is: month ="+dt.getMonth()+" and day = "+dt.getDate();
			calculateAshwednesday(dt);
		}
		
		else
		{
			dt = new Date(selectYear,4,(d+e-9));
			return_str = "In "+selectYear+", Easter is: month ="+dt.getMonth()+" and day = "+dt.getDate();
			calculateAshwednesday(dt);
			
		}
		return return_str;

}
	/**
	 * calculate Ash Wednesday
	 */
	public static void calculateAshwednesday(Date dt)
	{
		Date dt2 = dt;
		Calendar cal = Calendar.getInstance();
		cal.setTime(dt2);
		cal.add(Calendar.DATE, -45);
		Date dt3 = cal.getTime();
		boolean leapyear = ((dt3.getYear() % 4 == 0) && (dt3.getYear() % 100 != 0) || (dt3.getYear() % 400 == 0));

		if(dt3.getMonth() == 2)
		{
			if(leapyear)
			{
				System.out.println("In "+dt3.getYear()+", Ash Wednesday is: month ="+dt3.getMonth()+" and day = "+(dt3.getDate()-2));
			}
			else
			{
				System.out.println("In "+dt3.getYear()+", Ash Wednesday is: month ="+dt3.getMonth()+" and day = "+(dt3.getDate()-3));
			}
		}
		else
		{
			System.out.println("In "+dt3.getYear()+", Ash Wednesday is: month ="+dt3.getMonth()+" and day = "+dt3.getDate());
		}
	}
}
