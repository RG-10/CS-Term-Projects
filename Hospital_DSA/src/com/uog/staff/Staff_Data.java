package com.uog.staff;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;



public class Staff_Data {
	
	private static String cvsFile = "src\\CSVs\\Staff.csv";

	public static void Show() {
		
		for(int z=0;z<FindAll().size();z++) {
			System.out.println(FindAll().get(z).toString());
		}
	
}
	
	
	public static Staff FindOne(int Staff_ID){

	List<Staff> staffs = new ArrayList<Staff>();	
	String line;
	try {
		@SuppressWarnings("resource")
		BufferedReader bufferreader = new BufferedReader(new FileReader(cvsFile));
		
		while((line=bufferreader.readLine())!=null) {
			Staff staff = new Staff();
			String[] rowStaff = line.split(",");
			
			if(Integer.parseInt(rowStaff[0]) == Staff_ID ) 
			
			{
				staff.setStaff_ID(Integer.parseInt(rowStaff[0]));
				staff.setStaff_Name(rowStaff[1]);
				staff.setStaff_Duty(rowStaff[2]);
				staff.setQualification(rowStaff[3]);
				staff.setAge(Integer.parseInt(rowStaff[4]));
				staff.setSalary(Integer.parseInt(rowStaff[5]));
				staff.setPhone_Number(rowStaff[6]);
			
			
				staffs.add(staff);
			return staff;
			
			}
			
			
			
		}
	} catch (IOException e) {
		
		System.out.println("--Sorry! We Didn't Find any Record-- :(");
	}
	return null;
	
	
}

	public static List<Staff> FindAll(){
	List<Staff> staffs= new ArrayList<Staff>();
	String line ;
	try {
		
		@SuppressWarnings("resource")
		BufferedReader bufferedReader = new BufferedReader(new FileReader(cvsFile));
		
		while((line=bufferedReader.readLine()) != null) {
			Staff staff = new Staff();
			String[] rowStaff = line.split(",");
			staff.setStaff_ID(Integer.parseInt(rowStaff[0]));
			staff.setStaff_Name(rowStaff[1]);
			staff.setStaff_Duty(rowStaff[2]);
			staff.setQualification(rowStaff[3]);
			staff.setAge(Integer.parseInt(rowStaff[4]));
			staff.setSalary(Integer.parseInt(rowStaff[5]));
			staff.setPhone_Number(rowStaff[6]);
			
			
			
			staffs.add(staff);
		}
		
		
		
		
	} catch (IOException e) {
		
		System.out.println("--Sorry! We Didn't Find any Record-- :(");
	}
	return staffs;
}

	public static List<Staff> Search(String search){
	List<Staff> staffs= new ArrayList<Staff>();
	String line ;
	try {
		@SuppressWarnings("resource")
		BufferedReader bufferedReader = new BufferedReader(new FileReader(cvsFile));
		
		while((line=bufferedReader.readLine())!=null) {
			Staff staff = new Staff();
			String[] rowStaff = line.split(",");
			if(rowStaff[1].contains(search)==true) {
				staff.setStaff_ID(Integer.parseInt(rowStaff[0]));
				staff.setStaff_Name(rowStaff[1]);
				staff.setStaff_Duty(rowStaff[2]);
				staff.setQualification(rowStaff[3]);
				staff.setAge(Integer.parseInt(rowStaff[4]));
				staff.setSalary(Integer.parseInt(rowStaff[5]));
				staff.setPhone_Number(rowStaff[6]);
			
			
			
			staffs.add(staff);
			}
			//return rooms;
		}
		
		
		
		
	} catch (IOException e) {
		
		e.printStackTrace();
	}
	return staffs;
}

	public static Staff Save(Staff staff) {
	
	FileWriter filewriter;
	List<Staff> staffs = FindAll();
	
	try {
		filewriter = new FileWriter(cvsFile);
		
		for(int i=0;i<staffs.size();i++) {
			filewriter.append(staffs.get(i).toString());
			filewriter.append("\n");
		}
		
		
		if(staffs.size()>0) {
			staff.setStaff_ID(staffs.get(staffs.size()-1).getStaff_ID()+1);
			
		}
		else {
			staff.setStaff_ID(1);;
		}
		staffs.add(staff);
			filewriter.append(staff.toString());
			filewriter.append("\n");
			filewriter.flush();
			filewriter.close();
		
		
		
} catch (IOException e) {
		
		e.printStackTrace();
	}
	return staff;
}

	public static Staff DelOne(int Staff_ID) {
	
	FileWriter filewriter;
	List<Staff> staffs = FindAll();
	Staff staff = Staff_Data.FindOne(Staff_ID);
	
	try {
		filewriter = new FileWriter(cvsFile);
		
		for(int i=0;i<staffs.size();i++) {
			if(staffs.get(i).getStaff_ID()!=Staff_ID) {
			filewriter.append(staffs.get(i).toString());
			filewriter.append("\n");
			}
		}
		
		staffs.add(staff);
			
			filewriter.flush();
			filewriter.close();
		
} catch (IOException e) {
		
		e.printStackTrace();
	}
	return staff;
}

	public static String DelAll() {
	
	FileWriter filewriter;
	List<Staff> staffs = FindAll();
	try {
		filewriter = new FileWriter(cvsFile);
		
		for(int i=0;i<staffs.size();i++) {
			staffs.remove(i);
		}
			filewriter.flush();
			filewriter.close();
		
} catch (IOException e) {
		
		e.printStackTrace();
	}
	return "Removed Successfully";
	
}

	public static Staff Update(int id, Staff staff) {
	FileWriter filewriter;
	List<Staff> staffs = FindAll();
	
	try {
		filewriter = new FileWriter(cvsFile);
		for(int i=0;i<staffs.size();i++) {
			if(staffs.get(i).getStaff_ID()!=id) {
			filewriter.append(staffs.get(i).toString());	
			filewriter.append("\n");
			}
		}
		DelOne(id);
		staff.setStaff_ID(id);;
		staffs.set(id-1, staff);
		
		
		
		
		filewriter.append(staff.toString());
		filewriter.append("\n");
		filewriter.flush();
		filewriter.close();
		
	} catch (IOException e) {
		
		e.printStackTrace();
	}
	return staff;
	
}
	public static boolean validateStringforAlpha(String str) {
	      str = str.toLowerCase();
	      char[] charArray = str.toCharArray();
	      for (int i = 0; i < charArray.length; i++) {
	         char ch = charArray[i];
	         if (!(ch >= 'a' && ch <= 'z')) {
	            return false;
	         }
	      }
	      return true;
	   }
	public static boolean validateStringForNumeric(String str) {
	      str = str.toLowerCase();
	      char[] charArray = str.toCharArray();
	      for (int i = 0; i < charArray.length; i++) {
	         char ch = charArray[i];
	         if (!(ch >= '0' && ch <= '9')) {
	            return false;
	         }
	      }
	      return true;
	   }

}
