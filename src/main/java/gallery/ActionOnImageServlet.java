package gallery;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import SqlConn.ConnectionProvider;

/**
 * Servlet implementation class EditPostNoticeServlet
 */
@WebServlet("/ActionOnImageServlet")
@MultipartConfig(
		fileSizeThreshold = 1024 * 1024 * 5, // 5.24 MB
		maxFileSize = 1024 * 1024 * 500,      // 524 MB
		maxRequestSize = 1024 * 500 * 1000   // 1048 MB
		)

public class ActionOnImageServlet extends HttpServlet {
	private final String UPLOAD_DIRECTORY = "C:\\Users\\Dell\\eclipse-workspace\\SOES\\WebContent\\uploads\\photogallery";

	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ActionOnImageServlet() {
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
		int ActionImageId=Integer.parseInt(request.getParameter("sImageId"));//here all i.e edit delete and update process is done from same id by giving same name value for id
		String imageNameFromDB=request.getParameter("sImageNameFromDB");
		String action=request.getParameter("action");// input element as button banako x for all i.e. edit, delete & update by giving same name but different input value
		PreparedStatement ps=null;//used by edit btn and delete
		//note delete ko laagi ps use garepani hunx but update chahi actionon notice bata next page maa jaane hunale same hudaina as ps i.e ps2 hunx 

		ResultSet rs=null;

		String resultMessage="";
		Connection con=ConnectionProvider.getCon();

		try {
			
			//if click on delete button
			 if(action.equals("Delete")) {
				String path=UPLOAD_DIRECTORY + File.separator + imageNameFromDB; //file path from server to check if file exist or not
				// System.out.println(getServletContext().getRealPath("WebContent\\uploads\\notice") + File.separator + fileName); //not so good
				File directory=new File(path);

				if(directory.exists()) {//if file exist then delete it from file server & database

					directory.delete();

					ps=con.prepareStatement("delete from photogallery where id=?");
					ps.setInt(1,ActionImageId);
					ps.executeUpdate();

					request.setAttribute("siResult", "Post "+ ActionImageId+" was deleted successfully.");
					RequestDispatcher dispatcher=request.getRequestDispatcher("/AdminManagePages//actiononpostimages.jsp");
					dispatcher.forward(request, response);

				}
				else{//if file no exist in file server
					request.setAttribute("siResult","Post "+ActionImageId+" failed to delete due to file not exist in server.");
					RequestDispatcher dispatcher=request.getRequestDispatcher("/AdminManagePages//actiononpostimages.jsp");
					dispatcher.forward(request, response);
				}
				ps.close();

			}



			else {
				resultMessage = "No any action taken because you are entering without any action";

				request.setAttribute("Message", resultMessage);
				RequestDispatcher dispatcher=request.getRequestDispatcher("Result.jsp");
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
}