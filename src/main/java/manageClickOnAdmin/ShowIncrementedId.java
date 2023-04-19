package manageClickOnAdmin;

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
 * Servlet implementation class AutoProvideDateAndId
 */
@WebServlet("/ShowIncrementedId")
public class ShowIncrementedId extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ShowIncrementedId() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String action=request.getParameter("actionName");

		Connection con=ConnectionProvider.getCon();

		ResultSet rs=null;
		PreparedStatement ps=null;
		String resultMessage = " ";

		try {

			// for Add News button produce auto increment id in next page

			if(action.equals("addPostNotice")) {
				ps= con.prepareStatement("select id from notice",
						ResultSet.TYPE_SCROLL_SENSITIVE, 
						ResultSet.CONCUR_UPDATABLE); // For moving resultset pointer anywhere i.e. Forward or Backward

				rs = ps.executeQuery();
				int id;
				if(rs.next()==false) {  //if no data in resultset then make id=1
					id=1;

					request.setAttribute("addNoticepId",+id);    
					RequestDispatcher requestDispatcher = request.getRequestDispatcher("/AdminManagePages/addpostnotice.jsp");
					requestDispatcher.forward(request, response);
				}

				else { //minimum one row or more in resultset present
					rs.beforeFirst();//means resultset at null position
					while(rs.next()) {//moves resultset pointer to 1st position and repeate until condition meet
						if(rs.isLast())
						{
							id=rs.getInt("id")+1;
							request.setAttribute("addNoticepId",+id);    
							RequestDispatcher requestDispatcher = request.getRequestDispatcher("/AdminManagePages/addpostnotice.jsp");
							requestDispatcher.forward(request, response);

							break;

						}
					}
				}
			}
			else if(action.equals("addPostNews")) {

				ps= con.prepareStatement("select id from news",
						ResultSet.TYPE_SCROLL_SENSITIVE, 
						ResultSet.CONCUR_UPDATABLE); // For moving resultset pointer anywhere i.e. Forward or Backward

				rs = ps.executeQuery();
				int id;
				if(rs.next()==false) {  //if no data in resultset then make id=1
					id=1;

					request.setAttribute("addNewspId",+id);    
					RequestDispatcher requestDispatcher = request.getRequestDispatcher("/AdminManagePages/addpostnews.jsp");
					requestDispatcher.forward(request, response);
				}

				else { //minimum one row or more in resultset present
					rs.beforeFirst();//means resultset at null position
					while(rs.next()) {//moves resultset pointer to 1st position and repeate until condition meet
						if(rs.isLast())
						{
							id=rs.getInt("id")+1;
							request.setAttribute("addNewspId",+id);    
							RequestDispatcher requestDispatcher = request.getRequestDispatcher("/AdminManagePages/addpostnews.jsp");
							requestDispatcher.forward(request, response);

							break;

						}
					}
				}

			}
			else if(action.equals("addPostEvent")) {

				ps= con.prepareStatement("select id from event",
						ResultSet.TYPE_SCROLL_SENSITIVE, 
						ResultSet.CONCUR_UPDATABLE); // For moving resultset pointer anywhere i.e. Forward or Backward

				rs = ps.executeQuery();
				int id;
				if(rs.next()==false) {  //if no data in resultset then make id=1
					id=1;

					request.setAttribute("addEventpId",+id);    
					RequestDispatcher requestDispatcher = request.getRequestDispatcher("/AdminManagePages/addpostevent.jsp");
					requestDispatcher.forward(request, response);
				}

				else { //minimum one row or more in resultset present
					rs.beforeFirst();//means resultset at null position
					while(rs.next()) {//moves resultset pointer to 1st position and repeate until condition meet
						if(rs.isLast())
						{
							id=rs.getInt("id")+1;
							request.setAttribute("addEventpId",+id);    
							RequestDispatcher requestDispatcher = request.getRequestDispatcher("/AdminManagePages/addpostevent.jsp");
							requestDispatcher.forward(request, response);

							break;

						}
					}
				}
			}
			else if(action.equals("addPostImages")) {
				ps= con.prepareStatement("select id from photogallery",
						ResultSet.TYPE_SCROLL_SENSITIVE, 
						ResultSet.CONCUR_UPDATABLE); // For moving resultset pointer anywhere i.e. Forward or Backward

				rs = ps.executeQuery();
				int id;
				if(rs.next()==false) {  //if no data in resultset then make id=1
					id=1;

					request.setAttribute("addImagepId",+id);    
					RequestDispatcher requestDispatcher = request.getRequestDispatcher("/AdminManagePages/addpostimages.jsp");
					requestDispatcher.forward(request, response);
				}

				else { //minimum one row or more in resultset present
					rs.beforeFirst();//means resultset at null position
					while(rs.next()) {//moves resultset pointer to 1st position and repeate until condition meet
						if(rs.isLast())
						{
							id=rs.getInt("id")+1;
							request.setAttribute("addImagepId",+id);    
							RequestDispatcher requestDispatcher = request.getRequestDispatcher("/AdminManagePages/addpostimages.jsp");
							requestDispatcher.forward(request, response);

							break;

						}
					}
				}

				
			}
			
			
			else {
				resultMessage = "Data not available because you are entering without any button click.";

				request.setAttribute("Message", resultMessage);
				RequestDispatcher dispatcher=request.getRequestDispatcher("Result.jsp");
				dispatcher.forward(request, response);			
				}

		} catch (Exception e) {
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
