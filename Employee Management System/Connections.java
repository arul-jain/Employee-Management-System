import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Connections
{
    Connection c;
    Statement s;
    public Connections()
    {
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306","root","root");
            s = c.createStatement();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    

}
