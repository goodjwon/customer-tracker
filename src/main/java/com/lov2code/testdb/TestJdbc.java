package com.lov2code.testdb;

import java.sql.Connection;
import java.sql.DriverManager;

/* MySQL Conntection Test
 * */
public class TestJdbc 
{
    public static void main(String[] args) 
    {
    	String jdbcUrl = "jdbc:mysql://localhost:3306/web_customer_tracker?useSSL=false";
        String user = "springstudent";
        String password = "springstudent";

        try
        {
            System.out.println("Connecting to database: "+ jdbcUrl);

            Connection myConn = DriverManager.getConnection(jdbcUrl, user, password);

            System.out.println("Connection successful !!!");
        }
        
        catch (Exception exc) 
        {
            exc.printStackTrace();
            exc.printStackTrace();
        }
    }
}
