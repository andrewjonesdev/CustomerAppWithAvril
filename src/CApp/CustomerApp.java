//Author: Avril Douglas
//Date" June 12, 2017

package CApp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

import utilityForHire.UtilityStringNScan;

import java.sql.PreparedStatement;


public abstract class CustomerApp {
	/*
	public static void main(String[] args){
		String cFName;
		String cLName;
		String result;
		Scanner keyboard = new Scanner(System.in);
		boolean keepLooping = false;
		//System.out.println("Please enter the customer last name: ");
		ArrayList <String> list = new ArrayList();
		getCustomer(UtilityStringNScan.sentenceCheck("Please enter the customer first Name", "Invalid Name. Please try again.", keepLooping, list, keyboard),UtilityStringNScan.sentenceCheck("Please enter the customer last Name", "Invalid Name. Please try again.", keepLooping, list, keyboard));
	}
	*/
	public static String getCustomer(String cFName, String cLName){
		Connection con = null;
		Statement stmt = null;
		PreparedStatement pstmt = null;
		ResultSet rst = null;
		String sql= String.format("select * from customers where FirstName ='%s' AND LastName ='%s'", cFName, cLName);
		String output = "";
		try{			
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost/Customers?"+
			"user=root&password=password");
           pstmt = con.prepareStatement(sql); 
           rst=pstmt.executeQuery();
          
           while (rst.next()) {
            	/*System.out.print("Customer Number: " + rst.getString("CustomerID") + "\n");
            	System.out.print(rst.getString("Title") + " ");
            	System.out.print(rst.getString("FullName") + "\n");
               	System.out.print(rst.getString("StreetAddress") + "\n");
            	System.out.print(rst.getString("City") + ", " +  rst.getString("State") + " "+ rst.getString("Zipcode") + "\t\n");
            	System.out.print(rst.getString("EmailAddress") + "\n");
            	System.out.print(rst.getString("Position") + " at " + rst.getString("Company") + "\t\n"); 
         //   	System.out.print(rst.getString("Press (1) to search for another customer or press 2 to Edit the customer"+"\'s"+ "address.");              
         //   	return;
            	 */output +=("Customer Number: " + rst.getString("CustomerID") + "\n");
            	output += (rst.getString("Title") + " ");
            	output += (rst.getString("FullName") + "\n");
               	output += (rst.getString("StreetAddress") + "\n");
            	output += (rst.getString("City") + ", " +  rst.getString("State") + " "+ rst.getString("Zipcode") + "\t\n");
            	output += (rst.getString("EmailAddress") + "\n");
            	output += (rst.getString("Position") + " at " + rst.getString("Company") + "\t\n"); 
         //   	output += (rst.getString("Press (1) to search for another customer or press 2 to Edit the customer"+"\'s"+ "address.");              
         //   	return;
           }
			}catch (SQLException e){
				e.printStackTrace();
			}
		 catch (ClassNotFoundException e) {
				e.printStackTrace();
		} 
		finally {
				try {
					rst.close();
					pstmt.close();
					con.close();
				}catch(SQLException | NullPointerException e){
					e.printStackTrace();
				
				}
		}
	return output;
	}

}
				