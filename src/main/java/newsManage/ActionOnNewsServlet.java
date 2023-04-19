package newsManage;

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
@WebServlet("/ActionOnNewsServlet")
@MultipartConfig(
		fileSizeThreshold = 1024 * 1024 * 5, // 5.24 MB
		maxFileSize = 1024 * 1024 * 500,      // 524 MB
		maxRequestSize = 1024 * 500 * 1000   // 1048 MB
		)

public class ActionOnNewsServlet extends HttpServlet {
	private final String UPLOAD_DIRECTORY = "C:\\Users\\Dell\\eclipse-workspace\\SOES\\WebContent\\uploads\\news";

	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ActionOnNewsServlet() {
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
		int ActionNewsId=Integer.parseInt(request.getParameter("snewsId"));//here all i.e edit delete and update process is done from same id by giving same name value for id
		String imageNameFromDB=request.getParameter("snImageNameFromDB");
		String action=request.getParameter("action");// input element as button banako x for all i.e. edit, delete & update by giving same name but different input value
		PreparedStatement ps=null;//used by edit btn and delete
		PreparedStatement ps1=null;//used by update
		//note delete ko laagi ps use garepani hunx but update chahi actionon notice bata next page maa jaane hunale same hudaina as ps i.e ps2 hunx 

		ResultSet rs=null;

		String resultMessage="";
		Connection con=ConnectionProvider.getCon();

		try {
			//if click on edit button 
			if(action.equals("Edit")) {//edit button chahi another page i.e. update page maa janako laagi use gareko x by passing value from db with the help of id
				ps=con.prepareStatement("select * from news where id=?");
				ps.setInt(1,ActionNewsId);
				rs=ps.executeQuery();
				while(rs.next()) {//can be used if statement for only one data slection from resultset both work same


					request.setAttribute("editId",ActionNewsId );
					request.setAttribute("editDate", rs.getString(2));
					request.setAttribute("editTitle", rs.getString(3));
					request.setAttribute("editFileName",rs.getString(5));



				}
				RequestDispatcher dispatcher=request.getRequestDispatcher("/AdminManagePages//updatenews.jsp");
				dispatcher.forward(request, response);
				ps.close();//tala aruko laagi use garne hunaale leak nahos bhanera close gareko
				rs.close();

			}
			//if click on delete button
			else if(action.equals("Delete")) {
				String path=UPLOAD_DIRECTORY + File.separator + imageNameFromDB; //file path from server to check if file exist or not
				// System.out.println(getServletContext().getRealPath("WebContent\\uploads\\notice") + File.separator + fileName); //not so good
				File directory=new File(path);

				if(directory.exists()) {//if file exist then delete it from file server & database

					directory.delete();

					ps=con.prepareStatement("delete from news where id=?");
					ps.setInt(1,ActionNewsId);
					ps.executeUpdate();

					request.setAttribute("snResult", "Post "+ ActionNewsId+" was deleted successfully.");
					RequestDispatcher dispatcher=request.getRequestDispatcher("/AdminManagePages//actiononpostnews.jsp");
					dispatcher.forward(request, response);

				}
				else{//if file no exist in file server
					request.setAttribute("snResult","Post "+ActionNewsId+" failed to delete due to file not exist in server.");
					RequestDispatcher dispatcher=request.getRequestDispatcher("/AdminManagePages//actiononpostnews.jsp");
					dispatcher.forward(request, response);
				}
				ps.close();

			}



			//if click on update input element (which is button) in update page for update it uses same notice as update/delete
			else if(action.equals("Update")){
				String edittitle=request.getParameter("editTitle");
				ps=con.prepareStatement("select * from news where id=?");
				ps.setInt(1,ActionNewsId);
				rs=ps.executeQuery();//one operation comnplete bhayepaxi close hune bhayekaale arko rs define gareko(i.e. rs for edit close and then rs1 for update use)

				while(rs.next()) {//if use garepani hunx for only one row in resultset while work same as if
					if(!edittitle.equals(rs.getString(3))){
						ps1=con.prepareStatement("update news set title='"+edittitle+"' where id='"+ActionNewsId+"'");

						ps1.executeUpdate();

						request.setAttribute("snResult","Title update successfully !!!.");

						RequestDispatcher dispatcher=request.getRequestDispatcher("/AdminManagePages//actiononpostnews.jsp");
						dispatcher.forward(request, response);
					}
					else{
						request.setAttribute("snResult","Title not update because no change or you enter same title as before.");
						RequestDispatcher dispatcher=request.getRequestDispatcher("/AdminManagePages//actiononpostnews.jsp");
						dispatcher.forward(request, response);
					}
				}
			}

			else {
				resultMessage = "No data available because you are entering without any action";

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