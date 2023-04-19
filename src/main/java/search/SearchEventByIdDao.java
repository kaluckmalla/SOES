package search;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import SqlConn.ConnectionProvider;

public class SearchEventByIdDao {

	public boolean validate(SearchEventByIdBean seBean,HttpServletRequest request) throws ClassNotFoundException {
		boolean status = false;
		Connection con=ConnectionProvider.getCon();
		ResultSet rs=null;
		PreparedStatement ps=null;

		try {
				

				// Create a statement using connection object
				 ps= con.prepareStatement("select * from event where id =?");
			ps.setInt(1, seBean.getSearchEventId());

			 rs = ps.executeQuery();

			status = rs.next();

			if(status) {//it operate when status true
				request.setAttribute("seId",rs.getString(1));
				request.setAttribute("seDate",rs.getString(2));
				request.setAttribute("seTitle",rs.getString(3));
				request.setAttribute("seStartDate",rs.getString(4));
				request.setAttribute("seStartTime",rs.getString(5));
				request.setAttribute("seEndDate",rs.getString(6));
				request.setAttribute("seEndTime",rs.getString(7));
				request.setAttribute("seDescription",rs.getString(8));

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