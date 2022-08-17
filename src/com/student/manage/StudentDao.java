package com.student.manage;

import java.sql.Connection;
import java.sql.PreparedStatement;

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
}
