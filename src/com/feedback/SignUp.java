package com.feedback;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SignUp {
	Connection con=null;
	Statement stmt=null;
	PreparedStatement pstmt=null;
	SignUp(String username,String password) throws SQLException,ClassNotFoundException{
		Class.forName("com.mysql.cj.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/uname","root","");
		String query="insert into passwords (u_name,p_word) values (?,?)";
		pstmt=con.prepareStatement(query);
		pstmt.setString(1,username );
		pstmt.setString(2, password);
		pstmt.executeUpdate();
		con.close();
	}
}
