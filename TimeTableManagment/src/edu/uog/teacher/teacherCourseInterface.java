package edu.uog.teacher;

import java.util.List;

import java.util.Scanner;

public class teacherCourseInterface {

	public static void TeacherCourseManu() {
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		int choice=-1;

		choice = -1;
		while (choice!=10) {
			System.out.println("=====================================================");
			System.out.println("TeacherCourse Menu");
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
				System.out.println("Add New TeacherCourse ID");
				System.out.println("---------------------------------");
				TeacherCourse teachercourse = new TeacherCourse();
				
				System.out.println("Enter COURSE ID: ");
				String course_id = scan.nextLine();
				course_id+=scan.nextLine();
				teachercourse.setCOURSE_ID(course_id);

				System.out.println("Enter TEACHER ID: ");
				int teacher_id = scan.nextInt();
				teachercourse.setTEACHER_ID(teacher_id);

				System.out.println("Enter SECTION: ");
				String section = scan.next();
				section+= scan.nextLine();
				teachercourse.setSECTION(section);

				

				teachercourse = teacherCourseData.Save(teachercourse);
				System.out.println(teachercourse.toString());
				System.out.println("---------------------------------");
				break;
			case 2:
				System.out.println("---------------------------------");
				System.out.println("Delete TeacherCourse");
				System.out.println("---------------------------------");
				System.out.println("Enter TeacherCourse ID: ");
				int teacherCourse_ID = scan.nextInt();
				
				TeacherCourse teachercoursedelete = teacherCourseData.deleteOne(teacherCourse_ID);
				System.out.println(teachercoursedelete.toString());
				System.out.println("---------------------------------");
				break;
			case 3:
				System.out.println("---------------------------------");
				System.out.println("Show All TeacherCourse Data");
				System.out.println("---------------------------------");
				List<TeacherCourse> teachercourses = teacherCourseData.findAll();
				for (int i=0; i<teachercourses.size(); i++) {
					System.out.println(teachercourses.get(i).toString());
				}
				System.out.println("---------------------------------");
				break;
			case 4:
				System.out.println("---------------------------------");
				System.out.println("Search TeacherCourse");
				System.out.println("---------------------------------");
				System.out.println("Enter search: ");
				String search = scan.nextLine();
				search+=scan.nextLine();
				List<TeacherCourse> teachercoursesearch = teacherCourseData.search(search);
				for (int i=0; i<teachercoursesearch.size(); i++) {
					System.out.println(teachercoursesearch.get(i).toString());
				}
				System.out.println("---------------------------------");
				
				break;
			case 10:
				break;
			}
		}
	}
	}
