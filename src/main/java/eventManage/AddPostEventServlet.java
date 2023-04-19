package eventManage;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PostNoticeServlet
 */
@WebServlet("/AddPostEventServlet")

public class AddPostEventServlet extends HttpServlet {


	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddPostEventServlet() {
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


		int postId=Integer.parseInt(request.getParameter("eventId"));
		String postDate=request.getParameter("eventDate");
		String postTitle=request.getParameter("eventTitle");
		String postStartDate=request.getParameter("eventStartDate");
		String postStartTime=request.getParameter("eventStartTime");
		String postEndDate=request.getParameter("eventEndDate");
		String postEndTime=request.getParameter("eventEndTime");
		String postDescription=request.getParameter("eventDescription");


		String resultMessage="";

		
		try {
			
			
				AddPostEventClass p=new AddPostEventClass(postId,postDate,postTitle,postStartDate,postStartTime,postEndDate,postEndTime,postDescription);
				AddPostEventDao dao=new AddPostEventDao();
				if(dao.savePostOnlyFields(p)) {

					request.setAttribute("AddPostNoticeMsg","Post was publish successfully with given date & time !!!");

					RequestDispatcher requestDispatcher = request.getRequestDispatcher("/admincontrol.jsp");
					requestDispatcher.forward(request, response);

				}

				else {
					request.setAttribute("AddPostNoticeMsg", "Fields posting internal error occured.");
					RequestDispatcher dispatcher=request.getRequestDispatcher("/admincontrol.jsp");
					dispatcher.forward(request, response);

				}
						
		}catch(Exception e) {
			resultMessage = "Server error occur : " + e.getMessage();

			request.setAttribute("Message", resultMessage);
			RequestDispatcher dispatcher=request.getRequestDispatcher("Result.jsp");
			dispatcher.forward(request, response);

		}




	}

}
