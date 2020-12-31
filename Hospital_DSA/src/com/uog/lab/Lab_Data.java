package com.uog.lab;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.uog.staff.Staff_Data;



public class Lab_Data {

private static String cvsFile = "src\\CSVs\\Lab.csv";
	
	
	public static Lab FindOne(int Appratus_ID){

		List<Lab> labs = new ArrayList<Lab>();	
		String line;
		try {
			@SuppressWarnings("resource")
			BufferedReader bufferreader = new BufferedReader(new FileReader(cvsFile));
			
			while((line=bufferreader.readLine())!=null) {
				Lab lab = new Lab();
				String[] rowLab = line.split(",");
				
				if(Integer.parseInt(rowLab[0]) == Appratus_ID ) 
				
				{
					lab.setAppratus_ID(Integer.parseInt(rowLab[0]));
					lab.setLab_Name(rowLab[1]);
					lab.setSupervisor(Staff_Data.FindOne(Integer.parseInt(rowLab[2])));
					lab.setApparatus(rowLab[3]);
					lab.setLab_Detail(rowLab[4]);
					
					
					
				
				
				labs.add(lab);
				
				return lab;
				}
				
				
			}
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		return null;
		
		
	}

		public static List<Lab> FindAll(){
		List<Lab> labs= new ArrayList<Lab>();
		String line ;
		try {
			
			@SuppressWarnings("resource")
			BufferedReader bufferedReader = new BufferedReader(new FileReader(cvsFile));
			
			while((line=bufferedReader.readLine()) != null) {
				Lab lab = new Lab();
				String[] rowLab = line.split(",");
				lab.setAppratus_ID(Integer.parseInt(rowLab[0]));
				lab.setLab_Name(rowLab[1]);
				lab.setSupervisor(Staff_Data.FindOne(Integer.parseInt(rowLab[2])));
				lab.setApparatus(rowLab[3]);
				lab.setLab_Detail(rowLab[4]);
				
				
				
				labs.add(lab);
			}
			
			
			
			
		} catch (IOException e) {
			
			System.out.println("--Sorry! List is Empty--");
		}
		return labs;
	}

		public static List<Lab> Search(String search){
		List<Lab> labs= new ArrayList<Lab>();
		String line ;
		try {
			@SuppressWarnings("resource")
			BufferedReader bufferedReader = new BufferedReader(new FileReader(cvsFile));
			
			while((line=bufferedReader.readLine())!=null) {
				Lab lab = new Lab();
				String[] rowLab = line.split(",");
				if(rowLab[1].contains(search)==true) {
				lab.setAppratus_ID(Integer.parseInt(rowLab[0]));
				lab.setLab_Name(rowLab[1]);
				lab.setSupervisor(Staff_Data.FindOne(Integer.parseInt(rowLab[2])));
				lab.setApparatus(rowLab[3]);
				lab.setLab_Detail(rowLab[4]);
				
				
				labs.add(lab);
				}
			}
				//return rooms;
			
			
			
			
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		return labs;
	}

		public static Lab Save(Lab lab) {
		
		FileWriter filewriter;
		List<Lab> labs = FindAll();
		
		try {
			filewriter = new FileWriter(cvsFile);
			
			for(int i=0;i<labs.size();i++) {
				filewriter.append(labs.get(i).toString());
				filewriter.append("\n");
			}
			
			
			if(labs.size()>0) {
				lab.setAppratus_ID(labs.get(labs.size()-1).getAppratus_ID()+1);
				
				
				
				
			}
			else {
				lab.setAppratus_ID(1);
			}
			labs.add(lab);
				filewriter.append(lab.toString());
				filewriter.append("\n");
				filewriter.flush();
				filewriter.close();
			
			
			
	} catch (IOException e) {
			
			e.printStackTrace();
		}
		return lab;
	}

		public static Lab DelOne(int Lab_ID) {
		
		FileWriter filewriter;
		List<Lab> labs = FindAll();
		Lab lab = Lab_Data.FindOne(Lab_ID);
		
		try {
			filewriter = new FileWriter(cvsFile);
			
			for(int i=0;i<labs.size();i++) {
				if(labs.get(i).getAppratus_ID()!=Lab_ID) {
				filewriter.append(labs.get(i).toString());
				filewriter.append("\n");
				}
			}
			
			labs.add(lab);
				
				filewriter.flush();
				filewriter.close();
			
	} catch (IOException e) {
			
			e.printStackTrace();
		}
		return lab;
	}

		public static String DelAll() {
		
		FileWriter filewriter;
		List<Lab> labs = FindAll();
		try {
			filewriter = new FileWriter(cvsFile);
			
			for(int i=0;i<labs.size();i++) {
				labs.remove(i);
			}
				filewriter.flush();
				filewriter.close();
			
	} catch (IOException e) {
			
			e.printStackTrace();
		}
		return "Removed Successfully";
		
	}

		public static Lab Update(int id, Lab lab) {
		FileWriter filewriter;
		List<Lab> labs = FindAll();
		
		try {
			filewriter = new FileWriter(cvsFile);
			for(int i=0;i<labs.size();i++) {
				if(labs.get(i).getAppratus_ID()!=id) {
				filewriter.append(labs.get(i).toString());	
				filewriter.append("\n");
				}
			}
			DelOne(id);
			lab.setAppratus_ID(id);;
			labs.set(id-1, lab);
			
			
			
			
			filewriter.append(lab.toString());
			filewriter.append("\n");
			filewriter.flush();
			filewriter.close();
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		return lab;
		
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
