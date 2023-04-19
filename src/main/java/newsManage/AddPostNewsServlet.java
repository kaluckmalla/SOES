package newsManage;

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
@WebServlet("/AddPostNewsServlet")

@MultipartConfig(
		fileSizeThreshold = 1024 * 1024 * 5, // 5.24 MB
		maxFileSize = 1024 * 1024 * 500,      // 524 MB
		maxRequestSize = 1024 * 500 * 1000   // 1048 MB
		)

public class AddPostNewsServlet extends HttpServlet {

	private final String UPLOAD_DIRECTORY = "C:\\Users\\Dell\\eclipse-workspace\\SOES\\WebContent\\uploads\\news";

	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddPostNewsServlet() {
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


		int postId=Integer.parseInt(request.getParameter("newsId"));
		String postDate=request.getParameter("newsDate");
		String postTitle=request.getParameter("newsTitle");
		String postDescription=request.getParameter("newsDescription");

		Part postImage=request.getPart("newsImage");	

		String resultMessage="";

		try {
			String imageName = postImage.getSubmittedFileName();
			String path=UPLOAD_DIRECTORY + File.separator + imageName; //best way
			// System.out.println(getServletContext().getRealPath("WebContent\\uploads\\news") + File.separator + fileName); //not so good
			File directory=new File(path);
			
			//separation of input image name in extension and before extension 
			//used for validate image and directory is exist or not
			int index = imageName.lastIndexOf(".");
			String  onlyImageName="";
			String onlyExtension="";
						
			if (index > 0) {
				onlyImageName = imageName.substring(0, index);
				onlyExtension = imageName.substring(index + 1);//extension without dot
			}
			

			//common image extension checking
			//if input file is image then move forward
			if(onlyExtension.equals("png")|| onlyExtension.equals("jpg") ||onlyExtension.equals("jpeg") ||onlyExtension.equals("jfif") ||onlyExtension.equals("pjpeg") ||onlyExtension.equals("pjp") ||onlyExtension.equals("gif") ||onlyExtension.equals("avif") ||onlyExtension.equals("apng") ||onlyExtension.equals("svg") ||onlyExtension.equals("webp") ||onlyExtension.equals("bmp") ||onlyExtension.equals("ico") ||onlyExtension.equals("cur") ||onlyExtension.equals("tif") ||onlyExtension.equals("tiff")) {
				

			if(directory.exists()) {//checking if given file name present in file server

				
				int i=1;
				while(true) {//until satisfy following condition

					String newImageName=onlyImageName.toString()+"("+(i)+")"+"."+onlyExtension.toString();
					String newpath=UPLOAD_DIRECTORY + File.separator + newImageName; //best way
					File newdirectory=new File(newpath);

					if(!newdirectory.exists()) {

						AddPostNewsClass p=new AddPostNewsClass(postId,postDate,postTitle,postDescription,newImageName);
						AddPostNewsDao dao=new AddPostNewsDao();
						if(dao.savePost(p)) {

							for (Part part : request.getParts()) {
								part.write(newpath);
							}

							request.setAttribute("AddPostNoticeMsg","Post was publish successfully !!! . Your file name already existed. So we have changed file name to "+newImageName+" & save to "+newpath);

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

				AddPostNewsClass p=new AddPostNewsClass(postId,postDate,postTitle,postDescription,imageName);
				AddPostNewsDao dao=new AddPostNewsDao();
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
			
			}
			else {
				request.setAttribute("AddPostNoticeMsg", "Please select only image.");
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
