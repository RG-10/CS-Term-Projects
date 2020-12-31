package com.uog.medical;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;



public class Medical_Data {
	
	private static String cvsFile = "src\\CSVs\\Medical.csv";
	
	
	public static Medical FindOne(int Medical_ID){

		List<Medical> medicals = new ArrayList<Medical>();	
		String line;
		try {
			@SuppressWarnings("resource")
			BufferedReader bufferreader = new BufferedReader(new FileReader(cvsFile));
			
			while((line=bufferreader.readLine())!=null) {
				Medical medical = new Medical();
				String[] rowMedical = line.split(",");
				
				if(Integer.parseInt(rowMedical[0]) == Medical_ID ) 
				
				{
					medical.setMedicine_ID(Integer.parseInt(rowMedical[0]));
					medical.setMedicine_Name(rowMedical[1]);
					medical.setPrice(Integer.parseInt(rowMedical[2]));
					medical.setManufacturer(rowMedical[3]);
				
					
					
				
				
				medicals.add(medical);
				
				return medical;
				}
				
				
			}
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		return null;
		
		
	}

		public static List<Medical> FindAll(){
		List<Medical> medicals= new ArrayList<Medical>();
		String line ;
		try {
			
			@SuppressWarnings("resource")
			BufferedReader bufferedReader = new BufferedReader(new FileReader(cvsFile));
			
			while((line=bufferedReader.readLine()) != null) {
				Medical medical = new Medical();
				String[] rowMedical = line.split(",");
				medical.setMedicine_ID(Integer.parseInt(rowMedical[0]));
				medical.setMedicine_Name(rowMedical[1]);
				medical.setPrice(Integer.parseInt(rowMedical[2]));
				medical.setManufacturer(rowMedical[3]);
				
				
				
				
				medicals.add(medical);
			}
			
			
			
			
		} catch (IOException e) {
			
			System.out.println("--Sorry! List is empty--");
		}
		return medicals;
	}

		public static List<Medical> Search(String search){
		List<Medical> medicals= new ArrayList<Medical>();
		String line ;
		try {
			@SuppressWarnings("resource")
			BufferedReader bufferedReader = new BufferedReader(new FileReader(cvsFile));
			
			while((line=bufferedReader.readLine())!=null) {
				Medical medical = new Medical();
				String[] rowMedical = line.split(",");
				if(rowMedical[1].contains(search)==true){
				medical.setMedicine_ID(Integer.parseInt(rowMedical[0]));
				medical.setMedicine_Name(rowMedical[1]);
				medical.setPrice(Integer.parseInt(rowMedical[2]));
				medical.setManufacturer(rowMedical[3]);
			
				
				
				
				medicals.add(medical);
				}
				//return rooms;
			}
			
			
			
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		return medicals;
	}

		public static Medical Save(Medical medical) {
		
		FileWriter filewriter;
		List<Medical> medicals = FindAll();
		
		try {
			filewriter = new FileWriter(cvsFile);
			
			for(int i=0;i<medicals.size();i++) {
				filewriter.append(medicals.get(i).toString());
				filewriter.append("\n");
			}
			
			
			if(medicals.size()>0) {
				medical.setMedicine_ID(medicals.get(medicals.size()-1).getMedicine_ID()+1);
				
				
			}
			else {
				medical.setMedicine_ID(1);
			}
			medicals.add(medical);
				filewriter.append(medical.toString());
				filewriter.append("\n");
				filewriter.flush();
				filewriter.close();
			
			
			
	} catch (IOException e) {
			
			e.printStackTrace();
		}
		return medical;
	}

		public static Medical DelOne(int Medical_ID) {
		
		FileWriter filewriter;
		List<Medical> medicals = FindAll();
		Medical medical = Medical_Data.FindOne(Medical_ID);
		
		try {
			filewriter = new FileWriter(cvsFile);
			
			for(int i=0;i<medicals.size();i++) {
				if(medicals.get(i).getMedicine_ID()!=Medical_ID) {
				filewriter.append(medicals.get(i).toString());
				filewriter.append("\n");
				}
			}
			
			medicals.add(medical);
				
				filewriter.flush();
				filewriter.close();
			
	} catch (IOException e) {
			
			e.printStackTrace();
		}
		return medical;
	}

		public static String DelAll() {
		
		FileWriter filewriter;
		List<Medical> medicals = FindAll();
		try {
			filewriter = new FileWriter(cvsFile);
			
			for(int i=0;i<medicals.size();i++) {
				medicals.remove(i);
			}
				filewriter.flush();
				filewriter.close();
			
	} catch (IOException e) {
			
			e.printStackTrace();
		}
		return "Removed Successfully";
		
	}

		public static Medical Update(int id, Medical medical) {
		FileWriter filewriter;
		List<Medical> medicals = FindAll();
		
		try {
			filewriter = new FileWriter(cvsFile);
			for(int i=0;i<medicals.size();i++) {
				if(medicals.get(i).getMedicine_ID()!=id) {
				filewriter.append(medicals.get(i).toString());	
				filewriter.append("\n");
				}
			}
			DelOne(id);
			medical.setMedicine_ID(id);;
			medicals.set(id-1, medical);
			
			
			
			
			filewriter.append(medical.toString());
			filewriter.append("\n");
			filewriter.flush();
			filewriter.close();
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		return medical;
		
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
