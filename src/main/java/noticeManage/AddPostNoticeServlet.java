package noticeManage;

import java.io.File;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 * Servlet implementation class PostNoticeServlet
 */
@WebServlet("/AddPostNoticeServlet")

@MultipartConfig(
		fileSizeThreshold = 1024 * 1024 * 5, // 5.24 MB
		maxFileSize = 1024 * 1024 * 500,      // 524 MB
		maxRequestSize = 1024 * 500 * 1000   // 1048 MB
		)

public class AddPostNoticeServlet extends HttpServlet {

	private final String UPLOAD_DIRECTORY = "C:\\Users\\Dell\\eclipse-workspace\\SOES\\WebContent\\uploads\\notice";

	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddPostNoticeServlet() {
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


		int postId=Integer.parseInt(request.getParameter("nId"));
		String postDate=request.getParameter("nDate");
		String postTitle=request.getParameter("nTitle");
		Part postFile=request.getPart("nFile");	

		String resultMessage="";

		try {
			String fileName = postFile.getSubmittedFileName();
			String path=UPLOAD_DIRECTORY + File.separator + fileName; //best way
			// System.out.println(getServletContext().getRealPath("WebContent\\uploads\\notice") + File.separator + fileName); //not so good
			File directory=new File(path);

			if(directory.exists()) {//checking if given file name present in file server

				int index = fileName.lastIndexOf(".");
				String  onlyFileName="";
				String onlyExtension="";
				if (index > 0) {
					onlyFileName = fileName.substring(0, index);
					onlyExtension = fileName.substring(index + 1);
				}

				int i=1;
				while(true) {//until satisfy following condition

					String newfileName=onlyFileName.toString()+"("+(i)+")"+"."+onlyExtension.toString();
					String newpath=UPLOAD_DIRECTORY + File.separator + newfileName; //best way
					File newdirectory=new File(newpath);

					if(!newdirectory.exists()) {

						AddPostNoticeClass p=new AddPostNoticeClass(postId,postDate,postTitle,newfileName);
						AddPostNoticeDao dao=new AddPostNoticeDao();
						if(dao.savePost(p)) {

							for (Part part : request.getParts()) {
								part.write(newpath);
							}

							request.setAttribute("AddPostNoticeMsg","Post was publish successfully !!! . Your file name already existed. So we have changed file name to "+newfileName+" & save to "+newpath);

							RequestDispatcher requestDispatcher = request.getRequestDispatcher("/admincontrol.jsp");
							requestDispatcher.forward(request, response);

							break;
						}

						else {
							request.setAttribute("AddPostNoticeMsg", "Internal error occured.");
							RequestDispatcher dispatcher=request.getRequestDispatcher("/admincontrol.jsp");
							dispatcher.forward(request, response);

							break;

						}
					}
					i++;
				}


			}

			else {

				AddPostNoticeClass p=new AddPostNoticeClass(postId,postDate,postTitle,fileName);
				AddPostNoticeDao dao=new AddPostNoticeDao();
				if(dao.savePost(p)) {




					for (Part part : request.getParts()) {
						part.write(path);
					}
					request.setAttribute("AddPostNoticeMsg","Post was publish successfully !!!. & save to "+path);

					RequestDispatcher requestDispatcher = request.getRequestDispatcher("/admincontrol.jsp");
					requestDispatcher.forward(request, response);


				}
				else {
					request.setAttribute("AddPostNoticeMsg", "Internal error occured.");
					RequestDispatcher dispatcher=request.getRequestDispatcher("/admincontrol.jsp");
					dispatcher.forward(request, response);

				}
			}

		}catch(Exception e) {
			resultMessage = "Server error occur : " + e.getMessage();

			request.setAttribute("Message", resultMessage);
			RequestDispatcher dispatcher=request.getRequestDispatcher("Result.jsp");
			dispatcher.forward(request, response);

		}

	}

}
