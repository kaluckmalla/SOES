package search;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import SqlConn.ConnectionProvider;

public class SearchCivilStudyMaterialByIdDao {

	public boolean validate(SearchCivilStudyMaterialByIdBean sBean,HttpServletRequest request) throws ClassNotFoundException {
		boolean status = false;
		Connection con=ConnectionProvider.getCon();
		ResultSet rs=null;
		PreparedStatement ps=null;

		try {
				

				// Create a statement using connection object
				 ps= con.prepareStatement("select * from studymaterial where id =? and faculty=?");
			ps.setInt(1, sBean.getSearchId());
			ps.setString(2, sBean.getSearchFaculty());

			 rs = ps.executeQuery();

			status = rs.next();

			if(status) {//it operate when status true
				request.setAttribute("Id",rs.getString(1));
				request.setAttribute("Date",rs.getString(2));
				request.setAttribute("Faculty",rs.getString(3));
				request.setAttribute("Semester",rs.getString(4));
				request.setAttribute("Type",rs.getString(5));
				request.setAttribute("SubjectName",rs.getString(6));
				request.setAttribute("FileName",rs.getString(7));


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