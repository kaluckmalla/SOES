package studyMaterial;

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
@WebServlet("/ActionOnCivilStudyMaterial")
@MultipartConfig(
		fileSizeThreshold = 1024 * 1024 * 5, // 5.24 MB
		maxFileSize = 1024 * 1024 * 500,      // 524 MB
		maxRequestSize = 1024 * 500 * 1000   // 1048 MB
		)

public class ActionOnCivilStudyMaterial extends HttpServlet {
	private final String UPLOAD_DIRECTORY = "C:\\Users\\Dell\\eclipse-workspace\\SOES\\WebContent\\studymaterial\\civil";

	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ActionOnCivilStudyMaterial() {
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
		int sId=Integer.parseInt(request.getParameter("searchId"));//here all i.e edit delete and update process is done from same id by giving same name value for id
		
		if(request.getParameter("searchTypeFromDB").equals("Book")) {
			String typeFromDB="book";

		}
		else if(request.getParameter("searchTypeFromDB").equals("Note")) {
			String typeFromDB="note";

		}
		else if(request.getParameter("searchTypeFromDB").equals("Question collection")) {
			String typeFromDB="oldisgold";

		}
		else {
			String typeFromDB=null;
		}
		if(request.getParameter("searchSemesterFromDB").equals("1st sem")) {
			String semesterFromDB="1st";

		}
		else if(request.getParameter("searchSemesterFromDB").equals("2nd sem")) {
			String semesterFromDB="2nd";

		}
		else if(request.getParameter("searchSemesterFromDB").equals("3rd sem")) {
			String semesterFromDB="3rd";

		}
		else if(request.getParameter("searchSemesterFromDB").equals("4th sem")) {
			String semesterFromDB="4th";

		}
		else if(request.getParameter("searchSemesterFromDB").equals("5th sem")) {
			String semesterFromDB="5th";

		}
		else if(request.getParameter("searchSemesterFromDB").equals("6th sem")) {
			String semesterFromDB="6th";

		}
		else if(request.getParameter("searchSemesterFromDB").equals("7th sem")) {
			String semesterFromDB="7th";

		}
		else if(request.getParameter("searchSemesterFromDB").equals("8th sem")) {
			String semesterFromDB="8th";

		}
		else if(request.getParameter("searchSemesterFromDB").equals("No Semester")) {
			String semesterFromDB=null;

		}
		String subjectNameFromDB=request.getParameter("searchSubjectNameFromDB");

		String fileNameFromDB=request.getParameter("searchFileNameFromDB");
		String action=request.getParameter("action");// input element as button banako x for all i.e. edit, delete & update by giving same name but different input value
		PreparedStatement ps=null;//used by edit btn and delete
		//note delete ko laagi ps use garepani hunx but update chahi actionon notice bata next page maa jaane hunale same hudaina as ps i.e ps2 hunx 

		ResultSet rs=null;

		String resultMessage="";
		Connection con=ConnectionProvider.getCon();

		try {
			
			//if click on delete button
			 if(action.equals("Delete")) {
				String path=UPLOAD_DIRECTORY + File.separator + typeFromDB+ File.separator + semesterFromDB+ File.separator + subjectNameFromDB+ File.separator + fileNameFromDB; //file path from server to check if file exist or not
				// System.out.println(getServletContext().getRealPath("WebContent\\uploads\\notice") + File.separator + fileName); //not so good
				File directory=new File(path);

				if(directory.exists()) {//if file exist then delete it from file server & database

					directory.delete();

					ps=con.prepareStatement("delete from photogallery where id=?");
					ps.setInt(1,sId);
					ps.executeUpdate();

					request.setAttribute("sResult", "Post "+ sId+" was deleted successfully.");
					RequestDispatcher dispatcher=request.getRequestDispatcher("/AdminManagePages//actiononcivilstudymaterial.jsp");
					dispatcher.forward(request, response);

				}
				else{//if file no exist in file server
					request.setAttribute("sResult","Post "+sId+" failed to delete due to file not exist in server.");
					RequestDispatcher dispatcher=request.getRequestDispatcher("/AdminManagePages//actiononcivilstudymaterial.jsp");
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