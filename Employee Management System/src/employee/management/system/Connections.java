/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package employee.management.system;

/**
 *
 * @author arulj
 */
import java.sql.*;

public class Connections
{
    Connection c;
    Statement s;
    public Connections()
    {
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/Employee_System","root","root");
            s = c.createStatement();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}