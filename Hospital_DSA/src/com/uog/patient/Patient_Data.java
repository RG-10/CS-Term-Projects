package com.uog.patient;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.uog.doctor.Doctor_Data;



public class Patient_Data {

	private static String cvsFile = "src\\CSVs\\Patient.csv";

	public static void Show() {
		
		for(int z=0;z<FindAll().size();z++) {
			System.out.println(FindAll().get(z).toString());
		}
	
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
	
	public static Patient FindOne(int Patient_ID){

	List<Patient> patients = new ArrayList<Patient>();	
	String line;
	try {
		@SuppressWarnings("resource")
		BufferedReader bufferreader = new BufferedReader(new FileReader(cvsFile));
		
		while((line=bufferreader.readLine())!=null) {
			Patient patient = new Patient();
			String[] rowPatient = line.split(",");
			
			if(Integer.parseInt(rowPatient[0]) == Patient_ID ) 
			
			{
				patient.setPatient_ID(Integer.parseInt(rowPatient[0]));
				patient.setPatient_Name(rowPatient[1]);
				patient.setGender(rowPatient[2]);
				patient.setWeight(rowPatient[3]);
				
				patient.setAddress(rowPatient[4]);
				patient.setDisease(rowPatient[5]);
				patient.setStatus(rowPatient[6]);
				patient.setDoc_App(Doctor_Data.FindOne(Integer.parseInt(rowPatient[7])));
				
			
			
			patients.add(patient);
			
			return patient;
			}
			
			
		}
	} catch (IOException e) {
		
		e.printStackTrace();
	}
	return null;
	
	
}

	public static List<Patient> FindAll(){
	List<Patient> patients= new ArrayList<Patient>();
	String line ;
	try {
		
		@SuppressWarnings("resource")
		BufferedReader bufferedReader = new BufferedReader(new FileReader(cvsFile));
		
		while((line=bufferedReader.readLine()) != null) {
			Patient patient = new Patient();
			String[] rowPatient = line.split(",");
			patient.setPatient_ID(Integer.parseInt(rowPatient[0]));
			patient.setPatient_Name(rowPatient[1]);
			patient.setGender(rowPatient[2]);
			patient.setWeight(rowPatient[3]);
			
			patient.setAddress(rowPatient[4]);
			patient.setDisease(rowPatient[5]);
			patient.setStatus(rowPatient[6]);
			patient.setDoc_App(Doctor_Data.FindOne(Integer.parseInt(rowPatient[7])));
			
			
			patients.add(patient);
		}
		
		
		
		
	} catch (IOException e) {
		
		System.out.println("--Oops! List is Empty--");
	}
	return patients;
}

	public static List<Patient> Search(String search){
	List<Patient> patients= new ArrayList<Patient>();
	String line ;
	try {
		@SuppressWarnings("resource")
		BufferedReader bufferedReader = new BufferedReader(new FileReader(cvsFile));
		
		while((line=bufferedReader.readLine())!=null) {
			Patient patient = new Patient();
			String[] rowPatient = line.split(",");
			if(rowPatient[1].contains(search)==true){
			patient.setPatient_ID(Integer.parseInt(rowPatient[0]));
			patient.setPatient_Name(rowPatient[1]);
			patient.setGender(rowPatient[2]);
			patient.setWeight(rowPatient[3]);
			
			patient.setAddress(rowPatient[4]);
			patient.setDisease(rowPatient[5]);
			patient.setStatus(rowPatient[6]);
			patient.setDoc_App(Doctor_Data.FindOne(Integer.parseInt(rowPatient[7])));
			
			
			patients.add(patient);
			}
			//return rooms;
		}
		
		
		
	} catch (IOException e) {
		
		e.printStackTrace();
	}
	return patients;
}

	public static Patient Save(Patient patient) {
	
	FileWriter filewriter;
	List<Patient> patients = FindAll();
	
	try {
		filewriter = new FileWriter(cvsFile);
		
		for(int i=0;i<patients.size();i++) {
			filewriter.append(patients.get(i).toString());
			filewriter.append("\n");
		}
		
		
		if(patients.size()>0) {
			patient.setPatient_ID(patients.get(patients.size()-1).getPatient_ID()+1);
			
		}
		else {
			patient.setPatient_ID(1);
		}
		patients.add(patient);
			filewriter.append(patient.toString());
			filewriter.append("\n");
			filewriter.flush();
			filewriter.close();
		
		
		
} catch (IOException e) {
		
		e.printStackTrace();
	}
	return patient;
}

	public static Patient DelOne(int Patient_ID) {
	
	FileWriter filewriter;
	List<Patient> patients = FindAll();
	Patient patient = Patient_Data.FindOne(Patient_ID);
	
	try {
		filewriter = new FileWriter(cvsFile);
		
		for(int i=0;i<patients.size();i++) {
			if(patients.get(i).getPatient_ID()!=Patient_ID) {
			filewriter.append(patients.get(i).toString());
			filewriter.append("\n");
			}
		}
		
		patients.add(patient);
			
			filewriter.flush();
			filewriter.close();
		
} catch (IOException e) {
		
		e.printStackTrace();
	}
	return patient;
}

	public static String DelAll() {
	
	FileWriter filewriter;
	List<Patient> patients = FindAll();
	try {
		filewriter = new FileWriter(cvsFile);
		
		for(int i=0;i<patients.size();i++) {
			patients.remove(i);
		}
			filewriter.flush();
			filewriter.close();
		
} catch (IOException e) {
		
		e.printStackTrace();
	}
	return "Removed Successfully";
	
}

	public static Patient Update(int id, Patient patient) {
	FileWriter filewriter;
	List<Patient> patients = FindAll();
	
	try {
		filewriter = new FileWriter(cvsFile);
		for(int i=0;i<patients.size();i++) {
			if(patients.get(i).getPatient_ID()!=id) {
			filewriter.append(patients.get(i).toString());	
			filewriter.append("\n");
			}
		}
		Patient_Data.DelOne(id);
		patient.setPatient_ID(id);
		patients.set(id-1, patient);
		
		
		
		
		filewriter.append(patient.toString());
		filewriter.append("\n");
		filewriter.flush();
		filewriter.close();
		
	} catch (IOException e) {
		
		e.printStackTrace();
	}
	return patient;
	
}
	public static List<Patient> SearchByDisease(String search){
		List<Patient> patients= new ArrayList<Patient>();
		String line ;
		try {
			@SuppressWarnings("resource")
			BufferedReader bufferedReader = new BufferedReader(new FileReader(cvsFile));
			
			while((line=bufferedReader.readLine())!=null) {
				Patient patient = new Patient();
				String[] rowPatient = line.split(",");
				if(rowPatient[5].contains(search)==true){
				patient.setPatient_ID(Integer.parseInt(rowPatient[0]));
				patient.setPatient_Name(rowPatient[1]);
				patient.setGender(rowPatient[2]);
				patient.setWeight(rowPatient[3]);
				
				patient.setAddress(rowPatient[4]);
				patient.setDisease(rowPatient[5]);
				patient.setStatus(rowPatient[6]);
				patient.setDoc_App(Doctor_Data.FindOne(Integer.parseInt(rowPatient[7])));
				
				
				patients.add(patient);
				}
				//return rooms;
			}
			
			
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		return patients;
	}
}
