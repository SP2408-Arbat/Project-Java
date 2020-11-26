import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection 
{
public static void main(String[] args)throws SQLException 
{
Connection con=DriverManager.getConnection("jdbc:postgresql://localhost:5432/student","postgres","root");
System.out.println("Database Connected---------->");

}
}
