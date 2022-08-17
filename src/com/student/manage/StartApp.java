package com.student.manage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StartApp {

	public static void main(String[] args) throws IOException{
		while(true) {
			System.out.println("Welcome To Student Management App!");
			System.out.println("Press 1 to Display Student Details");
			System.out.println("Press 2 to Add Student");
			System.out.println("Press 3 to Delete Student");
			System.out.println("Press 4 to Update Student Details");
			System.out.println("Press 5 to Exi!");
			System.out.println("heheh");
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			

			int choice = Integer.parseInt(br.readLine());
			System.out.println(choice);
			
			if(choice == 1) {
				// Display Student Details
			} else if(choice == 2) {
				// Add New Student
				System.out.println("Name of the Student: ");
				String name = br.readLine();
				System.out.println("Phone No. of the Student: ");
				String phone = br.readLine();
				System.out.println("City of the Student: ");
				String city = br.readLine();
				
				Student st = new Student(name, phone, city);
				if(StudentDao.insertStudentToDao(st))
					System.out.println("Student Added Successfully!");
				else System.out.println("An error occurred, Student not added");
			} else if(choice == 3) {
				// Delete Student
			} else if(choice == 4) {
				// Update Student Details
			} else if(choice == 5) {
				// Exit App
				break;
			} else {
//				System.out.println("MEME");
			}
		}
	}

}
