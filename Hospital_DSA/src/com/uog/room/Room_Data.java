package com.uog.room;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Room_Data {
	private static String cvsFile = "src\\CSVs\\Room.csv";

	public static void Show() {
		
		for(int z=0;z<FindAll().size();z++) {
			System.out.println(FindAll().get(z).ToString());
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
	
	public static Room FindOne(int Room_ID){

	List<Room> rooms = new ArrayList<Room>();	
	String line;
	try {
		@SuppressWarnings("resource")
		BufferedReader bufferreader = new BufferedReader(new FileReader(cvsFile));
		
		while((line=bufferreader.readLine())!=null) {
			Room room = new Room();
			String[] rowRoom = line.split(",");
			
			if(Integer.parseInt(rowRoom[0]) == Room_ID ) 
			
			{
			room.setROOM_ID(Integer.parseInt(rowRoom[0]));
			room.setROOM_NAME(rowRoom[1]);
			room.setROOM_TYPE(rowRoom[2]);
			room.setROOM_CAPACITY(Integer.parseInt(rowRoom[3]));
			room.setROOM_FLOOR(Integer.parseInt(rowRoom[4]));
			
			
			rooms.add(room);
			
			return room;
			}
			
			
		}
	} catch (IOException e) {
		
		System.out.println("--Sorry! We Didn't Find any Record-- :(");
	}
	return null;
	
	
}

	public static List<Room> FindAll(){
	List<Room> rooms= new ArrayList<Room>();
	String line ;
	try {
		
		@SuppressWarnings("resource")
		BufferedReader bufferedReader = new BufferedReader(new FileReader(cvsFile));
		
		while((line=bufferedReader.readLine()) != null) {
			Room room = new Room();
			String[] row = line.split(",");
			room.setROOM_ID(Integer.parseInt(row[0]));
			room.setROOM_NAME(row[1]);
			room.setROOM_TYPE(row[2]);
			room.setROOM_CAPACITY(Integer.parseInt(row[3]));
			room.setROOM_FLOOR(Integer.parseInt(row[4]));
			
			
			
			rooms.add(room);
		}
		
		
		
		
	} catch (IOException e) {
		
		e.printStackTrace();
	}
	return rooms;
}

	public static List<Room> Search(String search){
	List<Room> rooms= new ArrayList<Room>();
	String line ;
	try {
		@SuppressWarnings("resource")
		BufferedReader bufferedReader = new BufferedReader(new FileReader(cvsFile));
		
		while((line=bufferedReader.readLine())!=null) {
			Room room = new Room();
			String[] row = line.split(",");
			if(row[1].contains(search)==true) {
			room.setROOM_ID(Integer.parseInt(row[0]));
			room.setROOM_NAME(row[1]);
			room.setROOM_TYPE(row[2]);
			room.setROOM_CAPACITY(Integer.parseInt(row[3]));
			room.setROOM_FLOOR(Integer.parseInt(row[4]));
			
			
			
			rooms.add(room);
			}
			//return rooms;
		}
		
		
		
		
	} catch (IOException e) {
		
		e.printStackTrace();
	}
	return rooms;
}

	public static Room Save(Room room) {
	
	FileWriter filewriter;
	List<Room> rooms = FindAll();
	
	try {
		filewriter = new FileWriter(cvsFile);
		
		for(int i=0;i<rooms.size();i++) {
			filewriter.append(rooms.get(i).toString());
			filewriter.append("\n");
		}
		
		
		if(rooms.size()>0) {
			room.setROOM_ID(rooms.get(rooms.size()-1).getROOM_ID()+1);
		}
		else {
			room.setROOM_ID(1);
		}
		rooms.add(room);
			filewriter.append(room.toString());
			filewriter.append("\n");
			filewriter.flush();
			filewriter.close();
		
		
		
} catch (IOException e) {
		
		e.printStackTrace();
	}
	return room;
}

	public static Room DelOne(int Room_ID) {
	
	FileWriter filewriter;
	List<Room> rooms = FindAll();
	Room room = Room_Data.FindOne(Room_ID);
	
	try {
		filewriter = new FileWriter(cvsFile);
		
		for(int i=0;i<rooms.size();i++) {
			if(rooms.get(i).getROOM_ID()!=Room_ID) {
			filewriter.append(rooms.get(i).toString());
			filewriter.append("\n");
			}
		}
		
		rooms.add(room);
			
			filewriter.flush();
			filewriter.close();
		
} catch (IOException e) {
		
		e.printStackTrace();
	}
	return room;
}

	public static String DelAll() {
	
	FileWriter filewriter;
	List<Room> rooms = FindAll();
	try {
		filewriter = new FileWriter(cvsFile);
		
		for(int i=0;i<rooms.size();i++) {
			rooms.remove(i);
		}
			filewriter.flush();
			filewriter.close();
		
} catch (IOException e) {
		
		e.printStackTrace();
	}
	return "Removed Successfully";
	
}

	public static Room Update(int id, Room room) {
	FileWriter filewriter;
	List<Room> rooms = FindAll();
	
	try {
		filewriter = new FileWriter(cvsFile);
		for(int i=0;i<rooms.size();i++) {
			if(rooms.get(i).getROOM_ID()!=id) {
			filewriter.append(rooms.get(i).toString());	
			filewriter.append("\n");
			}
		}
		DelOne(id);
		room.setROOM_ID(id);
		rooms.set(id-1, room);
		
		
		
		
		filewriter.append(room.toString());
		filewriter.append("\n");
		filewriter.flush();
		filewriter.close();
		
	} catch (IOException e) {
		
		e.printStackTrace();
	}
	return room;
	
}
}
	

