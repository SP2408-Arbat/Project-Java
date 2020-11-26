

import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.DriverManager;

public class Settings {
    public static Dimension getScreenSize(){
        Dimension d=Toolkit.getDefaultToolkit().getScreenSize();
        return d;   
    }//getScreenSize() closed
    
    public static Connection getDBConnection(){
        Connection con;
        try{
           
        	//Class.forName("oracle.jdbc.driver.OracleDriver");
			 //con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl2", "SYSTEM", "root");
        	 con=DriverManager.getConnection("jdbc:postgresql://localhost:5432/student","postgres","root");
        	return con;
        }catch(Exception ex){
            return null;
        }
    }
}//class closed
