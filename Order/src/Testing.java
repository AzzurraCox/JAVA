import java.util.ArrayList;
import java.util.Comparator;
import java.util.stream.Stream;

public class Testing{
    public String[] Data;
    public String ID;
    public int ID1;
    static ArrayList<Testing> testings2 = new ArrayList<>();

    

    public Testing(String id, String[] data2) {
    	this.ID = id;
		this.Data = data2;
		this.ID1 = Integer.parseInt(id);
	}
    
    public String getId()  //return ID
	{	
		return this.ID;
	}
    
    public String[] getDataCsv() // return Student Score
	{
    	
    	//Data = getcombineData(Data);
		return this.Data;
	}
    
    public String[] getDataJson() // return Student Score
	{
    	
		return this.Data;
	}
    
    public static String[] getcombineData(String[] data) {
    	String[] datas = data;
    	String[] combine = new String[7];
    	combine[0] = datas[0];
    	combine[1] = datas[1];
    	combine[2] = datas[2]+datas[3]+datas[4]+ datas[5]+ datas[6];
    	combine[3] = datas[7];
    	combine[4] = datas[8];
    	combine[5] = datas[9]+datas[10]+datas[11]+datas[12]+datas[13];
    	combine[6] = datas[14];
    	
    	return combine;
    	
    }

	public static ArrayList<Testing> asort(ArrayList<Testing> testings) {
		// TODO Auto-generated method stub
		testings2 = testings;
		aSortComparator comparator;
		comparator = new aSortComparator();
		
		 testings2.sort(comparator);
		return testings;
	}
	
	public static ArrayList<Testing> dsort(ArrayList<Testing> testings) {
		// TODO Auto-generated method stub
		testings2 = testings;
		dSortComparator comparator;
		comparator = new dSortComparator();
		
		 testings2.sort(comparator);
		return testings;
	}
	
	public int getId1()
	{
		return ID1;
	}
}


class aSortComparator implements Comparator<Testing> //Sorting Function (comparator)
{
	 
    @Override
    public int compare(Testing e1, Testing e2) {
        if(e1.getId1() > e2.getId1()){
            return 1;
        } else {
            return -1;
        }

    }
}

class dSortComparator implements Comparator<Testing> //Sorting Function (comparator)
{
	 
    @Override
    public int compare(Testing e1, Testing e2) {
        if(e1.getId1() < e2.getId1()){
            return 1;
        } else {
            return -1;
        }

    }
}