package com.student.manage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class StudentDao {
	public static boolean insertStudentToDao(Student st) {
		
		boolean flag = false;
		
		//JDBC Code...
		try {
			Connection con = ConnectionProvider.createConnection();
			String qry = "insert into students(sname, sphone, scity) values(?, ?, ?)"; //Dynamic Query
			
			// Prepared Statement
			PreparedStatement pstmt = con.prepareStatement(qry);
			
			// Set the parameter values
			pstmt.setString(1, st.getStudentName());
			pstmt.setString(2, st.getStudentPhone());
			pstmt.setString(3, st.getStudentCity());
			
			// Execute the query
			pstmt.executeUpdate();
			flag = true;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return flag;
	}

	public static boolean deleteStudent(int id) {
		boolean flag = false;
		
		//JDBC Code...
		try {
			Connection con = ConnectionProvider.createConnection();
			String qry = "delete from students where sid = ?"; //Dynamic Query
			
			// Prepared Statement
			PreparedStatement pstmt = con.prepareStatement(qry);
			
			// Set the parameter values
			pstmt.setInt(1, id);
			
			// Execute the query
			pstmt.executeUpdate();
			flag = true;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	public static void showAllStudents() {
		//JDBC Code...
		try {
			Connection con = ConnectionProvider.createConnection();
			String qry = "select * from students"; //Dynamic Query
			
			// Statement
			Statement stmt = con.createStatement();
			
			ResultSet set = stmt.executeQuery(qry);
			
			while(set.next()) {
				int id = set.getInt(1);
				String name = set.getString(2);
				String phone = set.getString(3);
				String city = set.getString(4);
				
				System.out.println("ID: " + id);
				System.out.println("Name: " + name);
				System.out.println("Phone No.: " + phone);
				System.out.println("City: " + city);

				System.out.println("================================================");
				
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
