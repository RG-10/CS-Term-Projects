package com.uog.facility;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;



public class Facility_Data {

private static String cvsFile = "src\\CSVs\\Facility.csv";
	
	
	public static Facility FindOne(int Facility_ID){

		List<Facility> facilities= new ArrayList<Facility>();	
		String line;
		try {
			@SuppressWarnings("resource")
			BufferedReader bufferreader = new BufferedReader(new FileReader(cvsFile));
			
			while((line=bufferreader.readLine())!=null) {
				Facility facility = new Facility();
				String[] rowFacility = line.split(",");
				
				if(Integer.parseInt(rowFacility[0]) == Facility_ID ) 
				
				{
					facility.setFacility_ID(Integer.parseInt(rowFacility[0]));
					facility.setFacility_Name(rowFacility[1]);
					facility.setFacility_Cost(Integer.parseInt(rowFacility[2]));
					
				
				
				facilities.add(facility);
				
				return facility;
				}
				
				
			}
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		return null;
		
		
	}

		public static List<Facility> FindAll(){
		List<Facility> facilities= new ArrayList<Facility>();
		String line ;
		try {
			
			@SuppressWarnings("resource")
			BufferedReader bufferedReader = new BufferedReader(new FileReader(cvsFile));
			
			while((line=bufferedReader.readLine()) != null) {
				Facility facility = new Facility();
				String[] rowFacility = line.split(",");
				facility.setFacility_ID(Integer.parseInt(rowFacility[0]));
				facility.setFacility_Name(rowFacility[1]);
				facility.setFacility_Cost(Integer.parseInt(rowFacility[2]));
				
				facilities.add(facility);
			}
			
			
			
			
		} catch (IOException e) {
			
			System.out.println("--Sorry! List is empty--");
		}
		return facilities;
	}

		public static List<Facility> Search(String search){
		List<Facility> Facilities= new ArrayList<Facility>();
		String line ;
		try {
			@SuppressWarnings("resource")
			BufferedReader bufferedReader = new BufferedReader(new FileReader(cvsFile));
			
			while((line=bufferedReader.readLine())!=null) {
				
				Facility facility = new Facility();
				String[] rowFacility = line.split(",");
				if(rowFacility[1].contains(search)==true) {
				facility.setFacility_ID(Integer.parseInt(rowFacility[0]));
				facility.setFacility_Name(rowFacility[1]);
				facility.setFacility_Cost(Integer.parseInt(rowFacility[2]));
				
				Facilities.add(facility);
				}
				//return rooms;
			
			}
			
			
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		return Facilities;
	}

		public static Facility Save(Facility facility) {
		
		FileWriter filewriter;
		List<Facility> facilities = FindAll();
		
		try {
			filewriter = new FileWriter(cvsFile);
			
			for(int i=0;i<facilities.size();i++) {
				filewriter.append(facilities.get(i).toString());
				filewriter.append("\n");
			}
			
			
			if(facilities.size()>0) {
				facility.setFacility_ID(facilities.get(facilities.size()-1).getFacility_ID()+1);
				
				
				
				
				
				
			}
			else {
				facility.setFacility_ID(1);;
			}
			facilities.add(facility);
				filewriter.append(facility.toString());
				filewriter.append("\n");
				filewriter.flush();
				filewriter.close();
			
			
			
	} catch (IOException e) {
			
			e.printStackTrace();
		}
		return facility;
	}

		public static Facility DelOne(int Facility_ID) {
		
		FileWriter filewriter;
		List<Facility> facilities = FindAll();
		Facility facility = Facility_Data.FindOne(Facility_ID);
		
		try {
			filewriter = new FileWriter(cvsFile);
			
			for(int i=0;i<facilities.size();i++) {
				if(facilities.get(i).getFacility_ID()!=Facility_ID) {
				filewriter.append(facilities.get(i).toString());
				filewriter.append("\n");
				}
			}
			
			facilities.add(facility);
				
				filewriter.flush();
				filewriter.close();
			
	} catch (IOException e) {
			
			e.printStackTrace();
		}
		return facility;
	}

		public static String DelAll() {
		
		FileWriter filewriter;
		List<Facility> facilities = FindAll();
		try {
			filewriter = new FileWriter(cvsFile);
			
			for(int i=0;i<facilities.size();i++) {
				facilities.remove(i);
			}
				filewriter.flush();
				filewriter.close();
			
	} catch (IOException e) {
			
			e.printStackTrace();
		}
		return "Removed Successfully";
		
	}

		public static Facility Update(int id, Facility facility) {
		FileWriter filewriter;
		List<Facility> facilities = FindAll();
		
		try {
			filewriter = new FileWriter(cvsFile);
			for(int i=0;i<facilities.size();i++) {
				if(facilities.get(i).getFacility_ID()!=id) {
				filewriter.append(facilities.get(i).toString());	
				filewriter.append("\n");
				}
			}
			DelOne(id);
			facility.setFacility_ID(id);;
			facilities.set(id-1, facility);
			
			
			
			
			filewriter.append(facility.toString());
			filewriter.append("\n");
			filewriter.flush();
			filewriter.close();
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		return facility;
		
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
