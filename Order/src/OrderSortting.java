import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;

import org.json.JSONArray;
import org.json.JSONObject;

public class OrderSortting {

    private static String[] command = new String[4];
    
	public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        ArrayList<Testing> testings = new ArrayList<>();
        
        
        if(args.length < 1) {
            System.out.printf("No Command Found");
            return;
        }
        else {
        	if(args.length > 0)
            {
            int a = 0;
                for (String val:args){
                    command[a] = val;
                    a++;
                }
            }
        }  
        
        
        if(command[1].toString().equals("csv"))
        {
        	try(InputStream csv = new FileInputStream(args[2])) {
                testings = parse_csv(csv);
            }
            catch(IOException e) {
                System.err.println("File not found");
                return;
            }
        }
        
        else if(command[1].toString().equals("json"))
        {
        	try(InputStream json = new FileInputStream(args[2])) {
                testings = parse_json(json);
            }
            catch(IOException e) {
                System.err.println("File not found");
                return;
        }
        }
        
        
        if(command[0].toString().equals("-a")) {    //Sort
        	testings = Testing.asort(testings);
        }
        else if (command[0].toString().equals("-d")) {
        	testings = Testing.dsort(testings);
        }
        else
        {
        	System.out.println("Wrong Command");
        }
        
        
    		
    		
    		
    		if(command[1].toString().equals("csv")) 
    		{
    			FileWriter f0 = new FileWriter(command[3]);
    			String newLine = System.getProperty("line.separator");
    			String[] colName = {"shippingID","shippingType","shipperName","shipperAddress","shipperPhoneNumber","RecipientName","RecipientAddress","RecipientPhoneNumber"};
        		
        		System.out.printf("%-15s%-15s%-15s%-60s%-20s%-15s%-60s%-15s\n", (Object[])colName);
    			for(Testing data : testings) {
        			String Id = data.getId();
        			String[] datas = data.getDataCsv();

        			System.out.printf("%-15s%-15s%-15s%-60s%-20s%-15s%-60s%-15s\n", Id,
        				datas[0], datas[1], datas[2], datas[3],datas[4],datas[5],datas[6]);	
        			
        			String Output =Id+","+"datas[0],"+datas[1]+","+datas[2]+","+datas[3]+","+datas[4]+","+datas[5]+","+datas[6];
        			f0.write(Output + newLine);
    		}	
    			
    			f0.close();
        }else {
        	FileWriter f0 = new FileWriter(command[3]);
			String newLine = System.getProperty("line.separator");
        	String[] colName = {"shippingID","shippingType","shipperName","shipperAddress","RecipientName","RecipientAddress","RecipientPhoneNumber"};
    		
    		System.out.printf("%-15s%-15s%-15s%-60s%-20s%-70s%-15s\n", (Object[])colName);
        	for(Testing data : testings) {
    			String Id = data.getId();
    			String[] datas = data.getDataJson(); 

    			System.out.printf("%-15s%-15s%-15s%-60s%-20s%-70s%-15s\n", Id,
    				datas[0], datas[1], datas[2], datas[3],datas[4],datas[5]);
    			
    			String Output =Id+","+datas[0]+","+datas[1]+","+"\""+datas[2]+"\""+","+datas[3]+","+"\""+datas[4]+"\""+","+datas[5];
    			f0.write(Output + newLine);
		}
        	f0.close();
        }	
	}
        
	
	public static ArrayList<Testing> parse_csv(InputStream src) throws IOException {
        ArrayList<Testing> testings = new ArrayList<Testing>();
		String delim = ",";
				
		try(InputStream input = new BufferedInputStream(src)) {
			Scanner sc = new Scanner(input);
			String row;
			//double[] columns;
			String[] head = sc.nextLine().split(delim);

			while(sc.hasNextLine()) {
				row = sc.nextLine();
				String[] tmp = row.split(delim, 2);
				String id = tmp[0];
				String[] data = tmp[1].split(delim);
				testings.add(new Testing(id, data));
			}
		}
		catch(Exception e) {

		}
		return testings;
}
	public static ArrayList<Testing> parse_json(InputStream src) throws IOException {
		
        ArrayList<Testing> testings = new ArrayList<Testing>();
        
        String[]data = null;
		try(InputStream input = new BufferedInputStream(src)) {
			Scanner sc = new Scanner(input);
	        String data1 = "";
	        while(sc.hasNextLine()) {
	            data1 += sc.nextLine();
	        }
	        JSONArray jsonArr = new JSONArray(data1);    
	        int length = jsonArr.length();  
	        //System.out.println("Size of data(array size): " + length);
	        
	        for(int i = 0; i < length; i++) {
	            JSONObject jsonOb = jsonArr.getJSONObject(i);   

	            String shippingID = jsonOb.get("shippingID").toString();
	            String shippingType = jsonOb.get("shippingType").toString();
	            String shipperName = jsonOb.get("shipperName").toString();
	            String shipperAddress = jsonOb.get("shipperAddress").toString();
	            String RecipientName = jsonOb.get("RecipientName").toString();
	            String RecipientAddress = jsonOb.get("RecipientAddress").toString();
	            String recipientPhoneNumber = jsonOb.get("recipientPhoneNumber").toString();
	            
	            String[] data2 = new String[6];
	            data2[0] = shippingType;
	            data2[1] = shipperName;
	            data2[2] = shipperAddress;
	            data2[3] = RecipientName;
	            data2[4] = RecipientAddress;
	            data2[5] = recipientPhoneNumber;
	            String id = shippingID;
	            testings.add(new Testing(id, data2));
		}
		}
		catch(Exception e) {
			
        }
		return testings;
}
}

    
