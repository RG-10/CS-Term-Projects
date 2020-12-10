package edu.uog.student;

import java.util.List;
import java.util.Scanner;

public class studentinterface {

	public static void StudentManu() {
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		int choice=-1;

		choice = -1;
		while (choice!=10) {
			System.out.println("=====================================================");
			System.out.println("Student Menu");
			System.out.println("=====================================================");
			System.out.println("1.   Insert");
			System.out.println("2.   Delete");
			System.out.println("3.   Show");
			System.out.println("4.   Search");
			System.out.println("5.   Delete All");
			System.out.println("10.   Back");
			System.out.print("Enter Your Choice [1-10]: ");
			choice = scan.nextInt();

			switch (choice) {
			case 1:
				System.out.println("---------------------------------");
				System.out.println("Add New Student ID");
				System.out.println("---------------------------------");
				Student student = new Student();
				
				System.out.println("Enter STUDENT ROLLNO: ");
				String rollno = scan.nextLine();
				rollno+=scan.nextLine();
				student.setSTUDENT_ROLLNO(rollno);

				System.out.println("Enter STUDY PROGRAM: ");
				String studyprogram = scan.next();
				student.setSTUDY_PROGRAM(studyprogram);

				System.out.println("Enter STUDY YEAR: ");
				String studyyear = scan.next();
				studyyear+=scan.nextLine();
				student.setSTUDY_YEAR(studyyear);

				

				student = studentData.Save(student);
				System.out.println(student.toString());
				System.out.println("---------------------------------");
				break;
			case 2:
				System.out.println("---------------------------------");
				System.out.println("Delete Student");
				System.out.println("---------------------------------");
				System.out.println("Enter Student ID: ");
				int student_ID = scan.nextInt();
				
				Student studentdelete = studentData.deleteOne(student_ID);
				System.out.println(studentdelete.toString());
				System.out.println("---------------------------------");
				break;
			case 3:
				System.out.println("---------------------------------");
				System.out.println("Show All Students Data");
				System.out.println("---------------------------------");
				List<Student> students = studentData.findAll();
				for (int i=0; i<students.size(); i++) {
					System.out.println(students.get(i).toString());
				}
				System.out.println("---------------------------------");
				break;
			case 4:
				System.out.println("---------------------------------");
				System.out.println("Search Student");
				System.out.println("---------------------------------");
				System.out.println("Enter search: ");
				String search = scan.nextLine();
				search+=scan.nextLine();
				List<Student> studentsearch = studentData.search(search);
				for (int i=0; i<studentsearch.size(); i++) {
					System.out.println(studentsearch.get(i).toString());
				}
				System.out.println("---------------------------------");
				
				break;
			case 10:
				break;
			}
		}
	}
	}
