package eventManage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import SqlConn.ConnectionProvider;

/**
 * Servlet implementation class EditPostNoticeServlet
 */
@WebServlet("/ActionOnEventServlet")

public class ActionOnEventServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ActionOnEventServlet() {
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
		int ActionEventId=Integer.parseInt(request.getParameter("seventId"));
		PreparedStatement ps=null;
		String resultMessage="";
		Connection con=ConnectionProvider.getCon();

		try {
			
			//if click on delete button
			if(request.getParameter("eventdelete")!=null) {
				
					ps=con.prepareStatement("delete from event where id=?");
					ps.setInt(1,ActionEventId);
					ps.executeUpdate();

					request.setAttribute("seResult", "Post "+ ActionEventId+" was deleted successfully.");
					RequestDispatcher dispatcher=request.getRequestDispatcher("/AdminManagePages//actiononpostevent.jsp");
					dispatcher.forward(request, response);
			}
			
		}catch (SQLException e) {
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





	}

}
