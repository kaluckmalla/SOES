package indexClickBoard;

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

import SqlConn.ConnectionProvider;

/**
 * Servlet implementation class ContentView
 */
@WebServlet("/NewsView")
public class NewsView extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public NewsView() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int newspostid=Integer.parseInt(request.getParameter("newsId"));

		Connection con=ConnectionProvider.getCon();

		PreparedStatement ps=null;
		ResultSet rs=null;
		String resultMessage="";
		try {

//sending data from database if link is clicked
			if(newspostid !=0) {//checking if index page notice title clicked or not
				ps=con.prepareStatement("select * from news where id=?");
				ps.setInt(1,newspostid);
				rs = ps.executeQuery();

				while(rs.next()) {     //if statement  with rs.next() can be use because there is only one data present in resultset by primary key id

					request.setAttribute("notice","News");
					request.setAttribute("contentDate", rs.getString(2));
					request.setAttribute("contentNewsTitle", rs.getString(3));
					request.setAttribute("contentDescription", rs.getString(4));
					request.setAttribute("contentImageName", rs.getString(5));

					RequestDispatcher dispatcher=request.getRequestDispatcher("/contentview.jsp");
					dispatcher.forward(request, response);

				}

			}

			else {
				resultMessage = "Data not available because you are entering without any link click ";

				request.setAttribute("Message", resultMessage);
				RequestDispatcher dispatcher=request.getRequestDispatcher("Result.jsp");
				dispatcher.forward(request, response);

			}

		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
				if(con!=null) con.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
