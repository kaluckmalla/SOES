package SqlConn;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionProvider {
	public static Connection getCon()
	{
		try {


			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con= DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/soes","root","");
			return con;
		} catch (Exception e) {
			
			e.printStackTrace();//System.out.println(e);// TODO: handle exception
		}
		return null;
	}
}
