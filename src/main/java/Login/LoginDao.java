package Login;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import SqlConn.ConnectionProvider;

public class LoginDao {

	public boolean validate(LoginBean loginBean,HttpServletRequest request) throws ClassNotFoundException {
		boolean status = false;
		Connection con=ConnectionProvider.getCon();
		ResultSet rs=null;
		PreparedStatement ps=null;

		try {
				

				// Step 2:Create a statement using connection object
				 ps= con.prepareStatement("select * from admin_login where Email = ? and Password = ?");
			ps.setString(1, loginBean.getUseremail());
			ps.setString(2, loginBean.getUserpassword());

			 rs = ps.executeQuery();

			status = rs.next();

			if(status) {
				HttpSession session=request.getSession();

				session.setAttribute("HiMessage",rs.getString(2));//for admin control page hi admin message

			}

		} catch (SQLException e) {
			// process sql exception
			printSQLException(e);
		}
		
		
		// best approach
		finally{
		   // close JDBC objects
		   try {
		      if(rs!=null) rs.close();
		   } catch (SQLException se) {
		      se.printStackTrace();
		   }
		   try {
		      if(ps!=null) ps.close();
		   } catch (SQLException se) {
		      se.printStackTrace();
		   }
		   try {
		      if(con!=null) con.close();
		   } catch (SQLException se) {
		      se.printStackTrace();
		   }
		}
		
		
		return status;
	}

	private void printSQLException(SQLException ex) {
		
		
		
		
		
		
		
		for (Throwable e: ex) {
			if (e instanceof SQLException) {
				e.printStackTrace(System.err);
				System.err.println("SQLState: " + ((SQLException) e).getSQLState());
				System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
				System.err.println("Message: " + e.getMessage());
				Throwable t = ex.getCause();
				while (t != null) {
					System.out.println("Cause: " + t);
					t = t.getCause();
				}
			}
		}
	}
}