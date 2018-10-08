package train_ticket;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.*;



public class Connect {
	public Connection con;
	
	public Connect() {
	
		try
	    {

	        Connection con=DriverManager.getConnection("jdbc:ucanaccess://C:\\WORKSPACE\\train_ticket\\src\\train_ticket\\Railway.mdb");
	        Statement stment = con.createStatement();
	    
 	     
	    }
	catch(Exception err)
	    {
	System.out.println(err);
	    }}
	public static void main(String args[]) {
		new Connect();
		
	}
}


	
	



