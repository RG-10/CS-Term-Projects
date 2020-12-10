package com.uog.login;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


import com.uog.person.PersonData;



public class AdminData {

	private static String cvsFile = "C:\\Users\\JD Computrz\\Desktop\\Excel\\Admin.csv";	
	public static Admin FindOne(int Person_ID){
		List<Admin> admins = new ArrayList<Admin>();	
		String line;
		try {
		@SuppressWarnings("resource")
		BufferedReader bufferreader = new BufferedReader(new FileReader(cvsFile));
		while((line=bufferreader.readLine())!=null) {
			Admin admin = new Admin();
			String[] rowAdmin = line.split(",");
			if(Integer.parseInt(rowAdmin[0]) == Person_ID ) {
			admin.setADMIN_ID(Integer.parseInt(rowAdmin[0]));
			admin.setPerson_ID(PersonData.FindOne(Integer.parseInt(rowAdmin[1])));
			admin.setADMIN_USERNAME(rowAdmin[2]);
			admin.setADMIN_PASSWORD(rowAdmin[3]);
			
			admins.add(admin);
			return admin;
			}
		}
	} catch (IOException e) {
		
		e.printStackTrace();
	}
	return null;
}

	@SuppressWarnings("resource")
	public static List<Admin> FindAll(){
		List<Admin> admins= new ArrayList<Admin>();
		String line ;
		try {			
			BufferedReader bufferedReader = new BufferedReader(new FileReader(cvsFile));
			while((line=bufferedReader.readLine()) != null) {
				Admin admin = new Admin();
				String[] rowAdmin = line.split(",");
				admin.setADMIN_ID(Integer.parseInt(rowAdmin[0]));
				admin.setPerson_ID(PersonData.FindOne(Integer.parseInt(rowAdmin[1])));
				admin.setADMIN_USERNAME(rowAdmin[2]);
				admin.setADMIN_PASSWORD(rowAdmin[3]);
				admins.add(admin);
			}
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		return admins;
	}
	public static List<Admin> Search(String search){
		List<Admin> admins= new ArrayList<Admin>();
		String line ;
		try {
			@SuppressWarnings("resource")
			BufferedReader bufferedReader = new BufferedReader(new FileReader(cvsFile));
			Admin admin = new Admin();
			while((line=bufferedReader.readLine())!=null) {	
				String[] rowAdmin = line.split(",");
				if(rowAdmin[2].contains(search)==true) {
					admin.setADMIN_ID(Integer.parseInt(rowAdmin[0]));
					admin.setPerson_ID(PersonData.FindOne(Integer.parseInt(rowAdmin[1])));
					admin.setADMIN_USERNAME(rowAdmin[2]);
					admin.setADMIN_PASSWORD(rowAdmin[3]);
				}
				admins.add(admin);
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
				admin.setADMIN_ID(admins.get(admins.size()-1).getADMIN_ID()+1);
				
			}
			else {
				admin.setADMIN_ID(1);
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
	public static String DelAll() {
		FileWriter filewriter;
		List<Admin> persons = FindAll();
		try {
			filewriter = new FileWriter(cvsFile);
			
			for(int i=0;i<persons.size();i++) {
				persons.remove(i);
			}
				filewriter.flush();
				filewriter.close();
	} catch (IOException e) {
			e.printStackTrace();
		}
		return "Removed Successfully";
	}
	public static Admin DelOne(int Admin_ID) {
		FileWriter filewriter;
		List<Admin> admins = FindAll();
		Admin admin = AdminData.FindOne(Admin_ID);
		
		try {
			filewriter = new FileWriter(cvsFile);
			
			for(int i=0;i<admins.size();i++) {
				if(admins.get(i).getADMIN_ID()!=Admin_ID) {
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
}