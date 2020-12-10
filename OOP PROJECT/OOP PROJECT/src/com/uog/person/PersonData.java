package com.uog.person;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PersonData {

	private static String cvsFile = "C:\\Users\\JD Computrz\\Desktop\\Excel\\Person.csv";	
	public static Person FindOne(int Person_ID){
		List<Person> persons = new ArrayList<Person>();	
		String line;
		try {
		@SuppressWarnings("resource")
		BufferedReader bufferreader = new BufferedReader(new FileReader(cvsFile));
		while((line=bufferreader.readLine())!=null) {
			Person person = new Person();
			String[] rowPerson = line.split(",");
			if(Integer.parseInt(rowPerson[0]) == Person_ID ) 
			{
			person.setPerson_ID(Integer.parseInt(rowPerson[0]));
			person.setFore_Name(rowPerson[1]);
			person.setSur_Name(rowPerson[2]);
			person.setAge(Integer.parseInt(rowPerson[3]));
			person.setGender(rowPerson[4]);
			person.setAddress(rowPerson[5]);
			persons.add(person);
			return person;
			}
		}
	} catch (IOException e) {
		
		e.printStackTrace();
	}
	return null;
}

	@SuppressWarnings("resource")
	public static List<Person> FindAll(){
		List<Person> persons= new ArrayList<Person>();
		String line ;
		try {			
			BufferedReader bufferedReader = new BufferedReader(new FileReader(cvsFile));
			while((line=bufferedReader.readLine()) != null) {
				Person person = new Person();
				String[] rowPerson = line.split(",");
				person.setPerson_ID(Integer.parseInt(rowPerson[0]));
				person.setFore_Name(rowPerson[1]);
				person.setSur_Name(rowPerson[2]);
				person.setAge(Integer.parseInt(rowPerson[3]));
				person.setGender(rowPerson[4]);
				person.setAddress(rowPerson[5]);
				persons.add(person);
			}
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		return persons;
	}
	public static List<Person> Search(String search){
		List<Person> persons= new ArrayList<Person>();
		String line ;
		try {
			@SuppressWarnings("resource")
			BufferedReader bufferedReader = new BufferedReader(new FileReader(cvsFile));
			Person person = new Person();
			while((line=bufferedReader.readLine())!=null) {	
				String[] rowPerson = line.split(",");
				if(rowPerson[2].contains(search)==true) {
					person.setPerson_ID(Integer.parseInt(rowPerson[0]));
					person.setFore_Name(rowPerson[1]);
					person.setSur_Name(rowPerson[2]);
					person.setAge(Integer.parseInt(rowPerson[3]));
					person.setGender(rowPerson[4]);
					person.setAddress(rowPerson[5]);
				}
				persons.add(person);
				}
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		return persons;
	}
	public static Person Save(Person person) {	
		FileWriter filewriter;
		List<Person> persons = FindAll();
		try {
			filewriter = new FileWriter(cvsFile);
			
			for(int i=0;i<persons.size();i++) {
				filewriter.append(persons.get(i).toString());
				filewriter.append("\n");
			}
			if(persons.size()>0) {
				person.setPerson_ID(persons.get(persons.size()-1).getPerson_ID()+1);
			}
			else {
				person.setPerson_ID(1);
			}
			persons.add(person);
				filewriter.append(person.toString());
				filewriter.append("\n");
				filewriter.flush();
				filewriter.close();
	} catch (IOException e) {
			
			e.printStackTrace();
		}
		return person;
	}
	public static String DelAll() {
		FileWriter filewriter;
		List<Person> persons = FindAll();
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
	public static Person DelOne(int Person_ID) {
		
		FileWriter filewriter;
		List<Person> persons = FindAll();
		Person person = PersonData.FindOne(Person_ID);
		try {
			filewriter = new FileWriter(cvsFile);
			
			for(int i=0;i<persons.size();i++) {
				if(persons.get(i).getPerson_ID()!=Person_ID) {
				filewriter.append(persons.get(i).toString());
				filewriter.append("\n");
				}
			}
			persons.add(person);	
				filewriter.flush();
				filewriter.close();
	} catch (IOException e) {
			e.printStackTrace();
		}
		return person;
	}
}