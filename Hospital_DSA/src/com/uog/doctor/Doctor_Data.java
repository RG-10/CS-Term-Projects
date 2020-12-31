package com.uog.doctor;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;



import com.uog.room.Room_Data;
import com.uog.staff.Staff_Data;

public class Doctor_Data {
	
	private static String cvsFile = "src\\CSVs\\Doctor.csv";
	
	
	public static Doctor FindOne(int Doctor_ID){

		List<Doctor> doctors= new ArrayList<Doctor>();	
		String line;
		try {
			@SuppressWarnings("resource")
			BufferedReader bufferreader = new BufferedReader(new FileReader(cvsFile));
			
			while((line=bufferreader.readLine())!=null) {
				Doctor doctor = new Doctor();
				String[] rowDoctor = line.split(",");
				
				if(Integer.parseInt(rowDoctor[0]) == Doctor_ID ) 
				
				{
					doctor.setDoctor_ID(Integer.parseInt(rowDoctor[0]));
					doctor.setStaff_ID(Staff_Data.FindOne(Integer.parseInt(rowDoctor[1])));
					doctor.setSpecialty(rowDoctor[2]);
					
					doctor.setRoom_ID(Room_Data.FindOne(Integer.parseInt(rowDoctor[3])));
				
				
				doctors.add(doctor);
				
				return doctor;
				}
				
				
			}
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		return null;
		
		
	}

		public static List<Doctor> FindAll(){
		List<Doctor> doctors= new ArrayList<Doctor>();
		String line ;
		try {
			
			@SuppressWarnings("resource")
			BufferedReader bufferedReader = new BufferedReader(new FileReader(cvsFile));
			
			while((line=bufferedReader.readLine()) != null) {
				Doctor doctor = new Doctor();
				String[] rowDoctor = line.split(",");
				doctor.setDoctor_ID(Integer.parseInt(rowDoctor[0]));
				doctor.setStaff_ID(Staff_Data.FindOne(Integer.parseInt(rowDoctor[1])));
				doctor.setSpecialty(rowDoctor[2]);
				
				doctor.setRoom_ID(Room_Data.FindOne(Integer.parseInt(rowDoctor[3])));
				
				
				doctors.add(doctor);
			}
			
			
			
			
		} catch (IOException e) {
			
			System.out.println("--Sorry! List is empty--");
		}
		return doctors;
	}

		public static List<Doctor> Search(String search){
		List<Doctor> doctors= new ArrayList<Doctor>();
		String line ;
		try {
			@SuppressWarnings("resource")
			BufferedReader bufferedReader = new BufferedReader(new FileReader(cvsFile));
			
			while((line=bufferedReader.readLine())!=null) {
				Doctor doctor = new Doctor();
				String[] rowDoctor = line.split(",");
				if(rowDoctor[2].contains(search)==true) {
				doctor.setDoctor_ID(Integer.parseInt(rowDoctor[0]));
				doctor.setStaff_ID(Staff_Data.FindOne(Integer.parseInt(rowDoctor[1])));
				doctor.setSpecialty(rowDoctor[2]);
			
				doctor.setRoom_ID(Room_Data.FindOne(Integer.parseInt(rowDoctor[3])));
				
				
				doctors.add(doctor);
				}
				//return rooms;
			}
			
			
			
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		return doctors;
	}

		public static Doctor Save(Doctor doctor) {
		
		FileWriter filewriter;
		List<Doctor> doctors = FindAll();
		
		try {
			filewriter = new FileWriter(cvsFile);
			
			for(int i=0;i<doctors.size();i++) {
				filewriter.append(doctors.get(i).toString());
				filewriter.append("\n");
			}
			
			
			if(doctors.size()>0) {
				doctor.setDoctor_ID(doctors.get(doctors.size()-1).getDoctor_ID()+1);
				
				
				
				
				
			}
			else {
				doctor.setDoctor_ID(1);
			}
			doctors.add(doctor);
				filewriter.append(doctor.toString());
				filewriter.append("\n");
				filewriter.flush();
				filewriter.close();
			
			
			
	} catch (IOException e) {
			
			e.printStackTrace();
		}
		return doctor;
	}

		public static Doctor DelOne(int Doctor_ID) {
		
		FileWriter filewriter;
		List<Doctor> doctors = FindAll();
		Doctor doctor = Doctor_Data.FindOne(Doctor_ID);
		
		try {
			filewriter = new FileWriter(cvsFile);
			
			for(int i=0;i<doctors.size();i++) {
				if(doctors.get(i).getDoctor_ID()!=Doctor_ID) {
				filewriter.append(doctors.get(i).toString());
				filewriter.append("\n");
				}
			}
			
			doctors.add(doctor);
				
				filewriter.flush();
				filewriter.close();
			
	} catch (IOException e) {
			
			e.printStackTrace();
		}
		return doctor;
	}

		public static String DelAll() {
		
		FileWriter filewriter;
		List<Doctor> doctors = FindAll();
		try {
			filewriter = new FileWriter(cvsFile);
			
			for(int i=0;i<doctors.size();i++) {
				doctors.remove(i);
			}
				filewriter.flush();
				filewriter.close();
			
	} catch (IOException e) {
			
			e.printStackTrace();
		}
		return "Removed Successfully";
		
	}

		public static Doctor Update(int id, Doctor doctor) {
		FileWriter filewriter;
		List<Doctor> doctors = FindAll();
		
		try {
			filewriter = new FileWriter(cvsFile);
			for(int i=0;i<doctors.size();i++) {
				if(doctors.get(i).getDoctor_ID()!=id) {
				filewriter.append(doctors.get(i).toString());	
				filewriter.append("\n");
				}
			}
			DelOne(id);
			doctor.setDoctor_ID(id);
			doctors.set(id-1, doctor);
			
			
			
			
			filewriter.append(doctor.toString());
			filewriter.append("\n");
			filewriter.flush();
			filewriter.close();
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		return doctor;
		
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
