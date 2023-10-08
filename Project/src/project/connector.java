package project;

import java.io.ObjectInputFilter.Status;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JFrame;
public class connector
{
		
		private Connection con;
		connector() 
		{	
				
	 			try
	 			{
					Class.forName("com.mysql.cj.jdbc.Driver");
					con=DriverManager.getConnection("jdbc:mysql://localhost:3306/votingsystem?user=root&password=$Manik$62");
				
	 		   }
	 			catch (Exception e) 
	 			{
	 				System.out.println(e);
	 			}
		}
		int setRegistrationDetails(String first_name,String last_name, String aadhar, String contact, String password, String gender)
		{
						int i=0;
						long longnumber =Long.parseLong(contact);
						try
						{
									PreparedStatement pr=con.prepareStatement("insert into login_details(first_name,last_name,aadhar,Ph_No,password, gender)values(?,?,?,?,?,?)");
									pr.setString(1, first_name);
									pr.setString(2, last_name);
									pr.setString(3, aadhar);
									pr.setLong(4, longnumber);
									pr.setString(5, password);
									pr.setString(6, gender);
									i=pr.executeUpdate();
									
							
						}
						catch(Exception ee)
						{
									System.out.println(ee);
						}
						return i;
		}
		
		
		
		
		ResultSet getLoginDetails(String aadhar, String password) {
			ResultSet rs = null;
			try {
				PreparedStatement pr=con.prepareStatement("Select * FROM login_details WHERE aadhar = ? AND password = ? AND status = 0");
				pr.setString(1, aadhar);
				pr.setString(2, password);
				rs = pr.executeQuery();
				
				
			}
			catch(Exception ee) {
				System.out.println(ee);
			}
			return rs;
		}
		ResultSet getAdminDetails(String aadhar, String password) {
			ResultSet rs = null;
			try {
				PreparedStatement pr=con.prepareStatement("Select * FROM admin WHERE admin = ? AND password = ? ");
				pr.setString(1, aadhar);
				pr.setString(2, password);
				rs = pr.executeQuery();
				
				
			}
			catch(Exception ee) {
				System.out.println(ee);
			}
			return rs;
		}
		
		
		
		
		int updateRegDetail(String aid,String party) {
			int i=0;
			try {
				PreparedStatement pr=con.prepareStatement("Update login_details set party=? ,status=1 WHERE aadhar = ? ");
				pr.setString(1, party);
				pr.setString(2, aid);
				i=pr.executeUpdate();
				
			}
			catch(Exception ee) {
				System.out.println(ee);
			}
			return i;
		}
		
		
		
		
		ResultSet getResultDetails() {
			ResultSet rs = null;
			try {
				PreparedStatement pr=con.prepareStatement("select party ,count(*) as total_vote from login_details group by party");
				rs = pr.executeQuery();
				
				
			}
			catch(Exception ee) {
				System.out.println(ee);
			}
			return rs;
		}
		

}

