package ResetPassword;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import SqlConn.ConnectionProvider;

/**
 * Servlet implementation class ResetPass
 */
@WebServlet("/ResetPass")
public class ResetPass extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ResetPass() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email=request.getParameter("toAddress");
		String newpass=request.getParameter("newpassword");
		String confirmnewpass=request.getParameter("confirmpassword");

		PreparedStatement ps=null;
		PreparedStatement ps1=null;
		HttpSession session=request.getSession();

        ResultSet rs=null;

		String resultMessage = " ";


		Connection con=ConnectionProvider.getCon();
		String sql="select * from admin_login";

		try {
			ps=con.prepareStatement(sql);

			 rs=ps.executeQuery();
			if(rs.next()) {
				if(rs.getString(3).equals(email)){


					if(newpass.equals(confirmnewpass)){

						ps1=con.prepareStatement(sql);

						ps1.executeUpdate("update admin_login set password='"+confirmnewpass+"' where email='"+email+"'");

						 if (session!=null) {
					        	session.setAttribute("sessionEmail", null);
					            session.setAttribute("sessionPassword", null);
					         
					            
					            
					            session.invalidate();
					          //  System.out.println("logout successfully With changing password...");
					           
					          //also update in cookies password......... 
								
					        }

						resultMessage = "Hello "+rs.getString(2)+", your password was changed. Remember new password : "+confirmnewpass;

						request.setAttribute("msg", resultMessage);
						RequestDispatcher dispatcher=request.getRequestDispatcher("adminlogin.jsp");
						dispatcher.forward(request, response);

					}
					else {

						resultMessage = "Hello "+rs.getString(2)+", new password & confirm password are not matche.";
						

						request.setAttribute("PasswordMessage", resultMessage);
						RequestDispatcher dispatcher=request.getRequestDispatcher("resetpassword.jsp");
						dispatcher.forward(request, response);


					}
				}
				else {
					resultMessage = "Sorry, email : "+email+" not exist in our database.";


					request.setAttribute("PasswordMessage", resultMessage);
					RequestDispatcher dispatcher=request.getRequestDispatcher("resetpassword.jsp");
					dispatcher.forward(request, response);



				}

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			resultMessage = "Server error occur : " + e.getMessage();

			request.setAttribute("Message", resultMessage);
			RequestDispatcher dispatcher=request.getRequestDispatcher("Result.jsp");
			dispatcher.forward(request, response);



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
					      if(ps1!=null) ps1.close();
					   } catch (SQLException se) {
					      se.printStackTrace();
					   }
					  
				   try {
				      if(con!=null) con.close();
				   } catch (SQLException se) {
				      se.printStackTrace();
				   }
				}
		
		
		
		
		
	}

}
