package com.uog.admin;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


import com.uog.staff.Staff_Data;

public class Admin_Data {
	
private static String cvsFile = "src\\CSVs\\Admin.csv";
	
	
	public static Admin FindOne(int Admin_ID){

		List<Admin> admins = new ArrayList<Admin>();	
		String line;
		
		try {
			@SuppressWarnings("resource")
			BufferedReader bufferreader = new BufferedReader(new FileReader(cvsFile));
			
			while((line=bufferreader.readLine())!=null) {
				Admin admin = new Admin();
				String[] rowAdmin = line.split(",");
				
				if(Integer.parseInt(rowAdmin[0]) == Admin_ID) {
					
					admin.setAdmin_ID(Integer.parseInt(rowAdmin[0]));
					admin.setStaff_ID(Staff_Data.FindOne(Integer.parseInt(rowAdmin[1])));
					admin.setAdmin_Username(rowAdmin[2]);
					admin.setAdmin_Password(rowAdmin[3]);
					
					admins.add(admin);
				
					return admin;
				}
				
			
				
			}
		} catch (IOException e) {
			
			System.out.println("Record not found");
		}
		return null;
		
		
	}

		public static List<Admin> FindAll(){
		List<Admin> admins= new ArrayList<Admin>();
		String line ;
		try {
			
			@SuppressWarnings("resource")
			BufferedReader bufferedReader = new BufferedReader(new FileReader(cvsFile));
			
			while((line=bufferedReader.readLine()) != null) {
				Admin admin = new Admin();
				String[] rowAdmin = line.split(",");
				
				admin.setAdmin_ID(Integer.parseInt(rowAdmin[0]));
				admin.setStaff_ID(Staff_Data.FindOne(Integer.parseInt(rowAdmin[1])));
				admin.setAdmin_Username(rowAdmin[2]);
				admin.setAdmin_Password(rowAdmin[3]);
				
				
				admins.add(admin);
			
			
			}
			
			
		} catch (IOException e) {
			
			System.out.println("--Sorry! List is Empty--");
		}
		return admins;
	}

		public static List<Admin> Search(String search){
		List<Admin> admins= new ArrayList<Admin>();
		String line ;
		try {
			@SuppressWarnings("resource")
			BufferedReader bufferedReader = new BufferedReader(new FileReader(cvsFile));
			
			while((line=bufferedReader.readLine())!=null) {
				Admin admin = new Admin();
				String[] rowAdmin = line.split(",");
				if(rowAdmin[2].contains(search)==true){
				admin.setAdmin_ID(Integer.parseInt(rowAdmin[0]));
				admin.setStaff_ID(Staff_Data.FindOne(Integer.parseInt(rowAdmin[1])));
				admin.setAdmin_Username(rowAdmin[2]);
				admin.setAdmin_Password(rowAdmin[3]);
				
				
				admins.add(admin);
				}
				//return admins;
			
			}
			
			
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		return admins;
	}

		public static Admin Save(Admin admin) {
		
		FileWriter filewriter;
		List<Admin> admins = FindAll();
		
		try {
			filewriter = new FileWriter(cvsFile);
			
			for(int i=0;i<admins.size();i++) {
				filewriter.append(admins.get(i).toString());
				filewriter.append("\n");
			}
			
			
			if(admins.size()>0) {
				admin.setAdmin_ID(admins.get(admins.size()-1).getAdmin_ID()+1);
				
				
				
				
			}
			else {
				admin.setAdmin_ID(1);
			}
			admins.add(admin);
				filewriter.append(admin.toString());
				filewriter.append("\n");
				filewriter.flush();
				filewriter.close();
			
			
			
	} catch (IOException e) {
			
			e.printStackTrace();
		}
		return admin;
	}

		public static Admin DelOne(int Admin_ID) {
		
		FileWriter filewriter;
		List<Admin> admins = FindAll();
		Admin admin = Admin_Data.FindOne(Admin_ID);
		
		try {
			filewriter = new FileWriter(cvsFile);
			
			for(int i=0;i<admins.size();i++) {
				if(admins.get(i).getAdmin_ID()!=Admin_ID) {
				filewriter.append(admins.get(i).toString());
				filewriter.append("\n");
				}
			}
			
			admins.add(admin);
				
				filewriter.flush();
				filewriter.close();
			
	} catch (IOException e) {
			
			e.printStackTrace();
		}
		return admin;
	}

		public static String DelAll() {
		
		FileWriter filewriter;
		List<Admin> admins = FindAll();
		try {
			filewriter = new FileWriter(cvsFile);
			
			for(int i=0;i<admins.size();i++) {
				admins.remove(i);
			}
				filewriter.flush();
				filewriter.close();
			
	} catch (IOException e) {
			
			e.printStackTrace();
		}
		return "Removed Successfully";
		
	}

		public static Admin Update(int id, Admin admin) {
		FileWriter filewriter;
		List<Admin> admins = FindAll();
		
		try {
			filewriter = new FileWriter(cvsFile);
			for(int i=0;i<admins.size();i++) {
				if(admins.get(i).getAdmin_ID()!=id) {
				filewriter.append(admins.get(i).toString());	
				filewriter.append("\n");
				}
			}
			DelOne(id);
			admin.setAdmin_ID(id);
			admins.set(id-1, admin);
			
			
			
			
			filewriter.append(admin.toString());
			filewriter.append("\n");
			filewriter.flush();
			filewriter.close();
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		return admin;
		
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
		public static List<Admin> PasswordCheck(String search){
			List<Admin> admins= new ArrayList<Admin>();
			String line ;
			try {
				@SuppressWarnings("resource")
				BufferedReader bufferedReader = new BufferedReader(new FileReader(cvsFile));
				
				while((line=bufferedReader.readLine())!=null) {
					Admin admin = new Admin();
					String[] rowAdmin = line.split(",");
					if(rowAdmin[3].contains(search)==true){
					admin.setAdmin_ID(Integer.parseInt(rowAdmin[0]));
					admin.setStaff_ID(Staff_Data.FindOne(Integer.parseInt(rowAdmin[1])));
					admin.setAdmin_Username(rowAdmin[2]);
					admin.setAdmin_Password(rowAdmin[3]);
					
					
					admins.add(admin);
					}
					//return admins;
				
				}
				
				
				
			} catch (IOException e) {
				
				e.printStackTrace();
			}
			return admins;
		}
}
