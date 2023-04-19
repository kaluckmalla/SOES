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
@WebServlet("/NoticeView")
public class NoticeView extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public NoticeView() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int noticepostid=Integer.parseInt(request.getParameter("noticeId"));

		Connection con=ConnectionProvider.getCon();

		PreparedStatement ps=null;
		ResultSet rs=null;
		String resultMessage="";
		try {


			if(noticepostid !=0) {//checking if index page notice title clicked or not
				ps=con.prepareStatement("select * from notice where id=?");
				ps.setInt(1,noticepostid);
				rs = ps.executeQuery();

				while(rs.next()) {     //if statement  with rs.next() can be use because there is only one data present in resultset by primary key id

					int index = rs.getString(4).lastIndexOf(".");

					//below code all about sending image to contentview page by checking image or other file present in file server with the help of database
					String onlyExtension="";
					if (index > 0) {

						onlyExtension ="."+rs.getString(4).substring(index + 1);//extension with dot
					}
					//common image extension checking
					//if image then send image with title with link
					if(onlyExtension.equals(".png")|| onlyExtension.equals(".jpg") ||onlyExtension.equals(".jpeg") ||onlyExtension.equals(".jfif") ||onlyExtension.equals(".pjpeg") ||onlyExtension.equals(".pjp") ||onlyExtension.equals(".gif") ||onlyExtension.equals(".avif") ||onlyExtension.equals(".apng") ||onlyExtension.equals(".svg") ||onlyExtension.equals(".webp") ||onlyExtension.equals(".bmp") ||onlyExtension.equals(".ico") ||onlyExtension.equals(".cur") ||onlyExtension.equals(".tif") ||onlyExtension.equals(".tiff")) {
						request.setAttribute("notice","Notice");
						request.setAttribute("contentDate", rs.getString(2));
						request.setAttribute("contentNoticeTitleOfImage", rs.getString(3));
						request.setAttribute("contentFileName", rs.getString(4));

						RequestDispatcher dispatcher=request.getRequestDispatcher("/contentview.jsp");
						dispatcher.forward(request, response);

					}
					//if other than image then send only title with link
					else {
						request.setAttribute("notice","Notice");
						request.setAttribute("contentDate", rs.getString(2));
						request.setAttribute("contentNoticeTitle", rs.getString(3));
						request.setAttribute("contentFileName", rs.getString(4));

						RequestDispatcher dispatcher=request.getRequestDispatcher("/contentview.jsp");
						dispatcher.forward(request, response);


					}
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
