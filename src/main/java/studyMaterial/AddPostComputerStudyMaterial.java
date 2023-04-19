package studyMaterial;

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

@WebServlet("/AddPostComputerStudyMaterial")

@MultipartConfig(
		fileSizeThreshold = 1024 * 1024 * 5, // 5.24 MB
		maxFileSize = 1024 * 1024 * 500,      // 524 MB
		maxRequestSize = 1024 * 500 * 1000   // 1048 MB
		)

public class AddPostComputerStudyMaterial extends HttpServlet {

	private final String UPLOAD_DIRECTORY = "C:\\Users\\Dell\\eclipse-workspace\\SOES\\WebContent\\studymaterial";
	private static final long serialVersionUID = 1L;

	public AddPostComputerStudyMaterial() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int postId=Integer.parseInt(request.getParameter("spId"));
		String postDate=request.getParameter("spDate");
		String postFaculty=request.getParameter("spFaculty");
		String postSemester=request.getParameter("spSemester");
		String postType=request.getParameter("spType");
		String postSubject=request.getParameter("spSubject");
		Part postFile=request.getPart("spFile");
		String resultMessage="";
		try {
			//For computer Engineering
			//Section 2: For Computer->Add Book
			//1st Sem
			if(postFaculty.equals("Computer Engineering") && postSemester.equals("1st sem") && postType.equals("Book")) {
				if(postSubject.equals("Engineering Drawing")) {
					String fileName = postFile.getSubmittedFileName();
					String path=UPLOAD_DIRECTORY+"\\computer\\book\\1st\\Engineering Drawing" + File.separator + fileName; //best way
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
							String newpath=UPLOAD_DIRECTORY+"\\computer\\book\\1st\\Engineering Drawing" + File.separator + newfileName; //best way
							File newdirectory=new File(newpath);
							if(!newdirectory.exists()) {
								AddPostStudyMaterialClass p=new AddPostStudyMaterialClass(postId,postDate,postFaculty,postSemester,postType,postSubject,newfileName);
								AddPostStudyMaterialDao dao=new AddPostStudyMaterialDao();
								if(dao.savePost(p)) {
									for (Part part : request.getParts()) {
										part.write(newpath);
									}
									request.setAttribute("AddPostNoticeMsg","Study material was publish successfully !!! . Your file name already existed. So we have changed file name to "+newfileName+" & save to "+newpath);

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
						AddPostStudyMaterialClass p=new AddPostStudyMaterialClass(postId,postDate,postFaculty,postSemester,postType,postSubject,fileName);
						AddPostStudyMaterialDao dao=new AddPostStudyMaterialDao();
						if(dao.savePost(p)) {
							for (Part part : request.getParts()) {
								part.write(path);
							}
							request.setAttribute("AddPostNoticeMsg","Study Material was publish successfully !!!. & save to "+path);

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
				else if(postSubject.equals("Engineering Math I")) {
					String fileName = postFile.getSubmittedFileName();
					String path=UPLOAD_DIRECTORY+"\\computer\\book\\1st\\Engineering Math I" + File.separator + fileName; //best way
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
							String newpath=UPLOAD_DIRECTORY+"\\computer\\book\\1st\\Engineering Math I" + File.separator + newfileName; //best way
							File newdirectory=new File(newpath);

							if(!newdirectory.exists()) {

								AddPostStudyMaterialClass p=new AddPostStudyMaterialClass(postId,postDate,postFaculty,postSemester,postType,postSubject,newfileName);
								AddPostStudyMaterialDao dao=new AddPostStudyMaterialDao();
								if(dao.savePost(p)) {

									for (Part part : request.getParts()) {
										part.write(newpath);
									}

									request.setAttribute("AddPostNoticeMsg","Study material was publish successfully !!! . Your file name already existed. So we have changed file name to "+newfileName+" & save to "+newpath);

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
						AddPostStudyMaterialClass p=new AddPostStudyMaterialClass(postId,postDate,postFaculty,postSemester,postType,postSubject,fileName);
						AddPostStudyMaterialDao dao=new AddPostStudyMaterialDao();
						if(dao.savePost(p)) {
							for (Part part : request.getParts()) {
								part.write(path);
							}
							request.setAttribute("AddPostNoticeMsg","Study Material was publish successfully !!!. & save to "+path);

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
				else if(postSubject.equals("Engineering Physics")) {
					String fileName = postFile.getSubmittedFileName();
					String path=UPLOAD_DIRECTORY+"\\computer\\book\\1st\\Engineering Physics" + File.separator + fileName; //best way
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
							String newpath=UPLOAD_DIRECTORY+"\\computer\\book\\1st\\Engineering Physics" + File.separator + newfileName; //best way
							File newdirectory=new File(newpath);

							if(!newdirectory.exists()) {

								AddPostStudyMaterialClass p=new AddPostStudyMaterialClass(postId,postDate,postFaculty,postSemester,postType,postSubject,newfileName);
								AddPostStudyMaterialDao dao=new AddPostStudyMaterialDao();
								if(dao.savePost(p)) {
									for (Part part : request.getParts()) {
										part.write(newpath);
									}
									request.setAttribute("AddPostNoticeMsg","Study material was publish successfully !!! . Your file name already existed. So we have changed file name to "+newfileName+" & save to "+newpath);

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
						AddPostStudyMaterialClass p=new AddPostStudyMaterialClass(postId,postDate,postFaculty,postSemester,postType,postSubject,fileName);
						AddPostStudyMaterialDao dao=new AddPostStudyMaterialDao();
						if(dao.savePost(p)) {
							for (Part part : request.getParts()) {
								part.write(path);
							}
							request.setAttribute("AddPostNoticeMsg","Study Material was publish successfully !!!. & save to "+path);

							RequestDispatcher requestDispatcher = request.getRequestDispatcher("/admincontrol.jsp");
							requestDispatcher.forward(request, response);
						}
						else {
							request.setAttribute("AddPostNoticeMsg", "Internal error occured.");
							RequestDispatcher dispatcher=request.getRequestDispatcher("/admincontrol.jsp");
							dispatcher.forward(request, response);

						}
					}

				}else if(postSubject.equals("Basic Electrical Engineering")) {
					String fileName = postFile.getSubmittedFileName();
					String path=UPLOAD_DIRECTORY+"\\computer\\book\\1st\\Basic Electrical Engineering" + File.separator + fileName; //best way
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
							String newpath=UPLOAD_DIRECTORY+"\\computer\\book\\1st\\Basic Electrical Engineering" + File.separator + newfileName; //best way
							File newdirectory=new File(newpath);
							if(!newdirectory.exists()) {
								AddPostStudyMaterialClass p=new AddPostStudyMaterialClass(postId,postDate,postFaculty,postSemester,postType,postSubject,newfileName);
								AddPostStudyMaterialDao dao=new AddPostStudyMaterialDao();
								if(dao.savePost(p)) {
									for (Part part : request.getParts()) {
										part.write(newpath);
									}
									request.setAttribute("AddPostNoticeMsg","Study material was publish successfully !!! . Your file name already existed. So we have changed file name to "+newfileName+" & save to "+newpath);

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

						AddPostStudyMaterialClass p=new AddPostStudyMaterialClass(postId,postDate,postFaculty,postSemester,postType,postSubject,fileName);
						AddPostStudyMaterialDao dao=new AddPostStudyMaterialDao();
						if(dao.savePost(p)) {
							for (Part part : request.getParts()) {
								part.write(path);
							}
							request.setAttribute("AddPostNoticeMsg","Study Material was publish successfully !!!. & save to "+path);

							RequestDispatcher requestDispatcher = request.getRequestDispatcher("/admincontrol.jsp");
							requestDispatcher.forward(request, response);
						}
						else {
							request.setAttribute("AddPostNoticeMsg", "Internal error occured.");
							RequestDispatcher dispatcher=request.getRequestDispatcher("/admincontrol.jsp");
							dispatcher.forward(request, response);

						}
					}

				}else if(postSubject.equals("Programming in C")) {
					String fileName = postFile.getSubmittedFileName();
					String path=UPLOAD_DIRECTORY+"\\computer\\book\\1st\\Programming in C" + File.separator + fileName; //best way
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
							String newpath=UPLOAD_DIRECTORY+"\\computer\\book\\1st\\Programming in C" + File.separator + newfileName; //best way
							File newdirectory=new File(newpath);

							if(!newdirectory.exists()) {

								AddPostStudyMaterialClass p=new AddPostStudyMaterialClass(postId,postDate,postFaculty,postSemester,postType,postSubject,newfileName);
								AddPostStudyMaterialDao dao=new AddPostStudyMaterialDao();
								if(dao.savePost(p)) {

									for (Part part : request.getParts()) {
										part.write(newpath);
									}

									request.setAttribute("AddPostNoticeMsg","Study material was publish successfully !!! . Your file name already existed. So we have changed file name to "+newfileName+" & save to "+newpath);

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

						AddPostStudyMaterialClass p=new AddPostStudyMaterialClass(postId,postDate,postFaculty,postSemester,postType,postSubject,fileName);
						AddPostStudyMaterialDao dao=new AddPostStudyMaterialDao();
						if(dao.savePost(p)) {
							for (Part part : request.getParts()) {
								part.write(path);
							}
							request.setAttribute("AddPostNoticeMsg","Study Material was publish successfully !!!. & save to "+path);

							RequestDispatcher requestDispatcher = request.getRequestDispatcher("/admincontrol.jsp");
							requestDispatcher.forward(request, response);
						}
						else {
							request.setAttribute("AddPostNoticeMsg", "Internal error occured.");
							RequestDispatcher dispatcher=request.getRequestDispatcher("/admincontrol.jsp");
							dispatcher.forward(request, response);

						}
					}

				}else if(postSubject.equals("Workshop Technology")) {
					String fileName = postFile.getSubmittedFileName();
					String path=UPLOAD_DIRECTORY+"\\computer\\book\\1st\\Workshop Technology" + File.separator + fileName; //best way
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
							String newpath=UPLOAD_DIRECTORY+"\\computer\\book\\1st\\Workshop Technology" + File.separator + newfileName; //best way
							File newdirectory=new File(newpath);

							if(!newdirectory.exists()) {

								AddPostStudyMaterialClass p=new AddPostStudyMaterialClass(postId,postDate,postFaculty,postSemester,postType,postSubject,newfileName);
								AddPostStudyMaterialDao dao=new AddPostStudyMaterialDao();
								if(dao.savePost(p)) {

									for (Part part : request.getParts()) {
										part.write(newpath);
									}

									request.setAttribute("AddPostNoticeMsg","Study material was publish successfully !!! . Your file name already existed. So we have changed file name to "+newfileName+" & save to "+newpath);

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

						AddPostStudyMaterialClass p=new AddPostStudyMaterialClass(postId,postDate,postFaculty,postSemester,postType,postSubject,fileName);
						AddPostStudyMaterialDao dao=new AddPostStudyMaterialDao();
						if(dao.savePost(p)) {
							for (Part part : request.getParts()) {
								part.write(path);
							}
							request.setAttribute("AddPostNoticeMsg","Study Material was publish successfully !!!. & save to "+path);

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
					request.setAttribute("AddPostNoticeMsg", "Failed to post due to you have not selected any subject.");
					RequestDispatcher dispatcher=request.getRequestDispatcher("/admincontrol.jsp");
					dispatcher.forward(request, response);
				}

			}

			//2nd Sem
			
			else if(postFaculty.equals("Computer Engineering") && postSemester.equals("2nd sem") && postType.equals("Book")) {

				if(postSubject.equals("Engineering Math II")) {
					String fileName = postFile.getSubmittedFileName();
					String path=UPLOAD_DIRECTORY+"\\computer\\book\\2nd\\Engineering Math II" + File.separator + fileName; //best way
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
							String newpath=UPLOAD_DIRECTORY+"\\computer\\book\\2nd\\Engineering Math II" + File.separator + newfileName; //best way
							File newdirectory=new File(newpath);

							if(!newdirectory.exists()) {

								AddPostStudyMaterialClass p=new AddPostStudyMaterialClass(postId,postDate,postFaculty,postSemester,postType,postSubject,newfileName);
								AddPostStudyMaterialDao dao=new AddPostStudyMaterialDao();
								if(dao.savePost(p)) {

									for (Part part : request.getParts()) {
										part.write(newpath);
									}

									request.setAttribute("AddPostNoticeMsg","Study material was publish successfully !!! . Your file name already existed. So we have changed file name to "+newfileName+" & save to "+newpath);

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
						AddPostStudyMaterialClass p=new AddPostStudyMaterialClass(postId,postDate,postFaculty,postSemester,postType,postSubject,fileName);
						AddPostStudyMaterialDao dao=new AddPostStudyMaterialDao();
						if(dao.savePost(p)) {
							for (Part part : request.getParts()) {
								part.write(path);
							}
							request.setAttribute("AddPostNoticeMsg","Study Material was publish successfully !!!. & save to "+path);

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
				else if(postSubject.equals("Engineering Chemistry")) {
					String fileName = postFile.getSubmittedFileName();
					String path=UPLOAD_DIRECTORY+"\\computer\\book\\2nd\\Engineering Chemistry" + File.separator + fileName; //best way
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
							String newpath=UPLOAD_DIRECTORY+"\\computer\\book\\2nd\\Engineering Chemistry" + File.separator + newfileName; //best way
							File newdirectory=new File(newpath);

							if(!newdirectory.exists()) {

								AddPostStudyMaterialClass p=new AddPostStudyMaterialClass(postId,postDate,postFaculty,postSemester,postType,postSubject,newfileName);
								AddPostStudyMaterialDao dao=new AddPostStudyMaterialDao();
								if(dao.savePost(p)) {

									for (Part part : request.getParts()) {
										part.write(newpath);
									}

									request.setAttribute("AddPostNoticeMsg","Study material was publish successfully !!! . Your file name already existed. So we have changed file name to "+newfileName+" & save to "+newpath);

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

						AddPostStudyMaterialClass p=new AddPostStudyMaterialClass(postId,postDate,postFaculty,postSemester,postType,postSubject,fileName);
						AddPostStudyMaterialDao dao=new AddPostStudyMaterialDao();
						if(dao.savePost(p)) {
							for (Part part : request.getParts()) {
								part.write(path);
							}
							request.setAttribute("AddPostNoticeMsg","Study Material was publish successfully !!!. & save to "+path);

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
				else if(postSubject.equals("Thermodynamics")) {
					String fileName = postFile.getSubmittedFileName();
					String path=UPLOAD_DIRECTORY+"\\computer\\book\\2nd\\Thermodynamics" + File.separator + fileName; //best way
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
							String newpath=UPLOAD_DIRECTORY+"\\computer\\book\\2nd\\Thermodynamics" + File.separator + newfileName; //best way
							File newdirectory=new File(newpath);

							if(!newdirectory.exists()) {

								AddPostStudyMaterialClass p=new AddPostStudyMaterialClass(postId,postDate,postFaculty,postSemester,postType,postSubject,newfileName);
								AddPostStudyMaterialDao dao=new AddPostStudyMaterialDao();
								if(dao.savePost(p)) {

									for (Part part : request.getParts()) {
										part.write(newpath);
									}
									request.setAttribute("AddPostNoticeMsg","Study material was publish successfully !!! . Your file name already existed. So we have changed file name to "+newfileName+" & save to "+newpath);

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

						AddPostStudyMaterialClass p=new AddPostStudyMaterialClass(postId,postDate,postFaculty,postSemester,postType,postSubject,fileName);
						AddPostStudyMaterialDao dao=new AddPostStudyMaterialDao();
						if(dao.savePost(p)) {
							for (Part part : request.getParts()) {
								part.write(path);
							}
							request.setAttribute("AddPostNoticeMsg","Study Material was publish successfully !!!. & save to "+path);

							RequestDispatcher requestDispatcher = request.getRequestDispatcher("/admincontrol.jsp");
							requestDispatcher.forward(request, response);
						}
						else {
							request.setAttribute("AddPostNoticeMsg", "Internal error occured.");
							RequestDispatcher dispatcher=request.getRequestDispatcher("/admincontrol.jsp");
							dispatcher.forward(request, response);
						}
					}
				}else if(postSubject.equals("Applied Mechanics")) {
					String fileName = postFile.getSubmittedFileName();
					String path=UPLOAD_DIRECTORY+"\\computer\\book\\2nd\\Applied Mechanics" + File.separator + fileName; //best way
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
							String newpath=UPLOAD_DIRECTORY+"\\computer\\book\\2nd\\Applied Mechanics" + File.separator + newfileName; //best way
							File newdirectory=new File(newpath);
							if(!newdirectory.exists()) {

								AddPostStudyMaterialClass p=new AddPostStudyMaterialClass(postId,postDate,postFaculty,postSemester,postType,postSubject,newfileName);
								AddPostStudyMaterialDao dao=new AddPostStudyMaterialDao();
								if(dao.savePost(p)) {
									for (Part part : request.getParts()) {
										part.write(newpath);
									}
									request.setAttribute("AddPostNoticeMsg","Study material was publish successfully !!! . Your file name already existed. So we have changed file name to "+newfileName+" & save to "+newpath);

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

						AddPostStudyMaterialClass p=new AddPostStudyMaterialClass(postId,postDate,postFaculty,postSemester,postType,postSubject,fileName);
						AddPostStudyMaterialDao dao=new AddPostStudyMaterialDao();
						if(dao.savePost(p)) {
							for (Part part : request.getParts()) {
								part.write(path);
							}
							request.setAttribute("AddPostNoticeMsg","Study Material was publish successfully !!!. & save to "+path);

							RequestDispatcher requestDispatcher = request.getRequestDispatcher("/admincontrol.jsp");
							requestDispatcher.forward(request, response);

						}
						else {
							request.setAttribute("AddPostNoticeMsg", "Internal error occured.");
							RequestDispatcher dispatcher=request.getRequestDispatcher("/admincontrol.jsp");
							dispatcher.forward(request, response);

						}
					}

				}else if(postSubject.equals("Object Oriented Programming")) {
					String fileName = postFile.getSubmittedFileName();
					String path=UPLOAD_DIRECTORY+"\\computer\\book\\2nd\\Object Oriented Programming" + File.separator + fileName; //best way
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
							String newpath=UPLOAD_DIRECTORY+"\\computer\\book\\2nd\\Object Oriented Programming" + File.separator + newfileName; //best way
							File newdirectory=new File(newpath);

							if(!newdirectory.exists()) {

								AddPostStudyMaterialClass p=new AddPostStudyMaterialClass(postId,postDate,postFaculty,postSemester,postType,postSubject,newfileName);
								AddPostStudyMaterialDao dao=new AddPostStudyMaterialDao();
								if(dao.savePost(p)) {

									for (Part part : request.getParts()) {
										part.write(newpath);
									}

									request.setAttribute("AddPostNoticeMsg","Study material was publish successfully !!! . Your file name already existed. So we have changed file name to "+newfileName+" & save to "+newpath);

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

						AddPostStudyMaterialClass p=new AddPostStudyMaterialClass(postId,postDate,postFaculty,postSemester,postType,postSubject,fileName);
						AddPostStudyMaterialDao dao=new AddPostStudyMaterialDao();
						if(dao.savePost(p)) {
							for (Part part : request.getParts()) {
								part.write(path);
							}
							request.setAttribute("AddPostNoticeMsg","Study Material was publish successfully !!!. & save to "+path);

							RequestDispatcher requestDispatcher = request.getRequestDispatcher("/admincontrol.jsp");
							requestDispatcher.forward(request, response);

						}
						else {
							request.setAttribute("AddPostNoticeMsg", "Internal error occured.");
							RequestDispatcher dispatcher=request.getRequestDispatcher("/admincontrol.jsp");
							dispatcher.forward(request, response);

						}
					}

				}else if(postSubject.equals("Discrete Structure")) {
					String fileName = postFile.getSubmittedFileName();
					String path=UPLOAD_DIRECTORY+"\\computer\\book\\2nd\\Discrete Structure" + File.separator + fileName; //best way
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
							String newpath=UPLOAD_DIRECTORY+"\\computer\\book\\2nd\\Discrete Structure" + File.separator + newfileName; //best way
							File newdirectory=new File(newpath);

							if(!newdirectory.exists()) {

								AddPostStudyMaterialClass p=new AddPostStudyMaterialClass(postId,postDate,postFaculty,postSemester,postType,postSubject,newfileName);
								AddPostStudyMaterialDao dao=new AddPostStudyMaterialDao();
								if(dao.savePost(p)) {

									for (Part part : request.getParts()) {
										part.write(newpath);
									}

									request.setAttribute("AddPostNoticeMsg","Study material was publish successfully !!! . Your file name already existed. So we have changed file name to "+newfileName+" & save to "+newpath);

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

						AddPostStudyMaterialClass p=new AddPostStudyMaterialClass(postId,postDate,postFaculty,postSemester,postType,postSubject,fileName);
						AddPostStudyMaterialDao dao=new AddPostStudyMaterialDao();
						if(dao.savePost(p)) {
							for (Part part : request.getParts()) {
								part.write(path);
							}
							request.setAttribute("AddPostNoticeMsg","Study Material was publish successfully !!!. & save to "+path);

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
					request.setAttribute("AddPostNoticeMsg", "Failed to post due to you have not selected any subject.");
					RequestDispatcher dispatcher=request.getRequestDispatcher("/admincontrol.jsp");
					dispatcher.forward(request, response);

				}

			}

			//3rd sem

			else if(postFaculty.equals("Computer Engineering") && postSemester.equals("3rd sem") && postType.equals("Book")) {

				if(postSubject.equals("Engineering Math III")) {
					String fileName = postFile.getSubmittedFileName();
					String path=UPLOAD_DIRECTORY+"\\computer\\book\\3rd\\Engineering Math III" + File.separator + fileName; //best way
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
							String newpath=UPLOAD_DIRECTORY+"\\computer\\book\\3rd\\Engineering Math III" + File.separator + newfileName; //best way
							File newdirectory=new File(newpath);

							if(!newdirectory.exists()) {

								AddPostStudyMaterialClass p=new AddPostStudyMaterialClass(postId,postDate,postFaculty,postSemester,postType,postSubject,newfileName);
								AddPostStudyMaterialDao dao=new AddPostStudyMaterialDao();
								if(dao.savePost(p)) {

									for (Part part : request.getParts()) {
										part.write(newpath);
									}

									request.setAttribute("AddPostNoticeMsg","Study material was publish successfully !!! . Your file name already existed. So we have changed file name to "+newfileName+" & save to "+newpath);

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

						AddPostStudyMaterialClass p=new AddPostStudyMaterialClass(postId,postDate,postFaculty,postSemester,postType,postSubject,fileName);
						AddPostStudyMaterialDao dao=new AddPostStudyMaterialDao();
						if(dao.savePost(p)) {
							for (Part part : request.getParts()) {
								part.write(path);
							}
							request.setAttribute("AddPostNoticeMsg","Study Material was publish successfully !!!. & save to "+path);

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
				else if(postSubject.equals("Data Structure & Algorithm")) {
					String fileName = postFile.getSubmittedFileName();
					String path=UPLOAD_DIRECTORY+"\\computer\\book\\3rd\\Data Structure & Algorithm" + File.separator + fileName; //best way
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
							String newpath=UPLOAD_DIRECTORY+"\\computer\\book\\3rd\\Data Structure & Algorithm" + File.separator + newfileName; //best way
							File newdirectory=new File(newpath);

							if(!newdirectory.exists()) {

								AddPostStudyMaterialClass p=new AddPostStudyMaterialClass(postId,postDate,postFaculty,postSemester,postType,postSubject,newfileName);
								AddPostStudyMaterialDao dao=new AddPostStudyMaterialDao();
								if(dao.savePost(p)) {

									for (Part part : request.getParts()) {
										part.write(newpath);
									}

									request.setAttribute("AddPostNoticeMsg","Study material was publish successfully !!! . Your file name already existed. So we have changed file name to "+newfileName+" & save to "+newpath);

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

						AddPostStudyMaterialClass p=new AddPostStudyMaterialClass(postId,postDate,postFaculty,postSemester,postType,postSubject,fileName);
						AddPostStudyMaterialDao dao=new AddPostStudyMaterialDao();
						if(dao.savePost(p)) {
							for (Part part : request.getParts()) {
								part.write(path);
							}
							request.setAttribute("AddPostNoticeMsg","Study Material was publish successfully !!!. & save to "+path);

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
				else if(postSubject.equals("Theory of Computation")) {
					String fileName = postFile.getSubmittedFileName();
					String path=UPLOAD_DIRECTORY+"\\computer\\book\\3rd\\Theory of Computation" + File.separator + fileName; //best way
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
							String newpath=UPLOAD_DIRECTORY+"\\computer\\book\\3rd\\Theory of Computation" + File.separator + newfileName; //best way
							File newdirectory=new File(newpath);

							if(!newdirectory.exists()) {

								AddPostStudyMaterialClass p=new AddPostStudyMaterialClass(postId,postDate,postFaculty,postSemester,postType,postSubject,newfileName);
								AddPostStudyMaterialDao dao=new AddPostStudyMaterialDao();
								if(dao.savePost(p)) {

									for (Part part : request.getParts()) {
										part.write(newpath);
									}

									request.setAttribute("AddPostNoticeMsg","Study material was publish successfully !!! . Your file name already existed. So we have changed file name to "+newfileName+" & save to "+newpath);

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

						AddPostStudyMaterialClass p=new AddPostStudyMaterialClass(postId,postDate,postFaculty,postSemester,postType,postSubject,fileName);
						AddPostStudyMaterialDao dao=new AddPostStudyMaterialDao();
						if(dao.savePost(p)) {
							for (Part part : request.getParts()) {
								part.write(path);
							}
							request.setAttribute("AddPostNoticeMsg","Study Material was publish successfully !!!. & save to "+path);

							RequestDispatcher requestDispatcher = request.getRequestDispatcher("/admincontrol.jsp");
							requestDispatcher.forward(request, response);

						}
						else {
							request.setAttribute("AddPostNoticeMsg", "Internal error occured.");
							RequestDispatcher dispatcher=request.getRequestDispatcher("/admincontrol.jsp");
							dispatcher.forward(request, response);
						}
					}

				}else if(postSubject.equals("Electrical Circuit Theory")) {
					String fileName = postFile.getSubmittedFileName();
					String path=UPLOAD_DIRECTORY+"\\computer\\book\\3rd\\Electrical Circuit Theory" + File.separator + fileName; //best way
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
							String newpath=UPLOAD_DIRECTORY+"\\computer\\book\\3rd\\Electrical Circuit Theory" + File.separator + newfileName; //best way
							File newdirectory=new File(newpath);

							if(!newdirectory.exists()) {

								AddPostStudyMaterialClass p=new AddPostStudyMaterialClass(postId,postDate,postFaculty,postSemester,postType,postSubject,newfileName);
								AddPostStudyMaterialDao dao=new AddPostStudyMaterialDao();
								if(dao.savePost(p)) {

									for (Part part : request.getParts()) {
										part.write(newpath);
									}

									request.setAttribute("AddPostNoticeMsg","Study material was publish successfully !!! . Your file name already existed. So we have changed file name to "+newfileName+" & save to "+newpath);

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

						AddPostStudyMaterialClass p=new AddPostStudyMaterialClass(postId,postDate,postFaculty,postSemester,postType,postSubject,fileName);
						AddPostStudyMaterialDao dao=new AddPostStudyMaterialDao();
						if(dao.savePost(p)) {
							for (Part part : request.getParts()) {
								part.write(path);
							}
							request.setAttribute("AddPostNoticeMsg","Study Material was publish successfully !!!. & save to "+path);

							RequestDispatcher requestDispatcher = request.getRequestDispatcher("/admincontrol.jsp");
							requestDispatcher.forward(request, response);
						}
						else {
							request.setAttribute("AddPostNoticeMsg", "Internal error occured.");
							RequestDispatcher dispatcher=request.getRequestDispatcher("/admincontrol.jsp");
							dispatcher.forward(request, response);
						}
					}

				}else if(postSubject.equals("Digital Logic")) {
					String fileName = postFile.getSubmittedFileName();
					String path=UPLOAD_DIRECTORY+"\\computer\\book\\3rd\\Digital Logic" + File.separator + fileName; //best way
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
							String newpath=UPLOAD_DIRECTORY+"\\computer\\book\\3rd\\Digital Logic" + File.separator + newfileName; //best way
							File newdirectory=new File(newpath);

							if(!newdirectory.exists()) {

								AddPostStudyMaterialClass p=new AddPostStudyMaterialClass(postId,postDate,postFaculty,postSemester,postType,postSubject,newfileName);
								AddPostStudyMaterialDao dao=new AddPostStudyMaterialDao();
								if(dao.savePost(p)) {

									for (Part part : request.getParts()) {
										part.write(newpath);
									}

									request.setAttribute("AddPostNoticeMsg","Study material was publish successfully !!! . Your file name already existed. So we have changed file name to "+newfileName+" & save to "+newpath);

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
						AddPostStudyMaterialClass p=new AddPostStudyMaterialClass(postId,postDate,postFaculty,postSemester,postType,postSubject,fileName);
						AddPostStudyMaterialDao dao=new AddPostStudyMaterialDao();
						if(dao.savePost(p)) {
							for (Part part : request.getParts()) {
								part.write(path);
							}
							request.setAttribute("AddPostNoticeMsg","Study Material was publish successfully !!!. & save to "+path);

							RequestDispatcher requestDispatcher = request.getRequestDispatcher("/admincontrol.jsp");
							requestDispatcher.forward(request, response);
						}
						else {
							request.setAttribute("AddPostNoticeMsg", "Internal error occured.");
							RequestDispatcher dispatcher=request.getRequestDispatcher("/admincontrol.jsp");
							dispatcher.forward(request, response);

						}
					}

				}else if(postSubject.equals("Electromagnetics")) {
					String fileName = postFile.getSubmittedFileName();
					String path=UPLOAD_DIRECTORY+"\\computer\\book\\3rd\\Electromagnetics" + File.separator + fileName; //best way
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
							String newpath=UPLOAD_DIRECTORY+"\\computer\\book\\3rd\\Electromagnetics" + File.separator + newfileName; //best way
							File newdirectory=new File(newpath);

							if(!newdirectory.exists()) {

								AddPostStudyMaterialClass p=new AddPostStudyMaterialClass(postId,postDate,postFaculty,postSemester,postType,postSubject,newfileName);
								AddPostStudyMaterialDao dao=new AddPostStudyMaterialDao();
								if(dao.savePost(p)) {

									for (Part part : request.getParts()) {
										part.write(newpath);
									}

									request.setAttribute("AddPostNoticeMsg","Study material was publish successfully !!! . Your file name already existed. So we have changed file name to "+newfileName+" & save to "+newpath);

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

						AddPostStudyMaterialClass p=new AddPostStudyMaterialClass(postId,postDate,postFaculty,postSemester,postType,postSubject,fileName);
						AddPostStudyMaterialDao dao=new AddPostStudyMaterialDao();
						if(dao.savePost(p)) {




							for (Part part : request.getParts()) {
								part.write(path);
							}
							request.setAttribute("AddPostNoticeMsg","Study Material was publish successfully !!!. & save to "+path);

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
					request.setAttribute("AddPostNoticeMsg", "Failed to post due to you have not selected any subject.");
					RequestDispatcher dispatcher=request.getRequestDispatcher("/admincontrol.jsp");
					dispatcher.forward(request, response);

				}
			}

			//4th

			else if(postFaculty.equals("Computer Engineering") && postSemester.equals("4th sem") && postType.equals("Book")) {

				if(postSubject.equals("Applied Mathematics")) {
					String fileName = postFile.getSubmittedFileName();
					String path=UPLOAD_DIRECTORY+"\\computer\\book\\4th\\Applied Mathematics" + File.separator + fileName; //best way
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
							String newpath=UPLOAD_DIRECTORY+"\\computer\\book\\4th\\Applied Mathematics" + File.separator + newfileName; //best way
							File newdirectory=new File(newpath);

							if(!newdirectory.exists()) {

								AddPostStudyMaterialClass p=new AddPostStudyMaterialClass(postId,postDate,postFaculty,postSemester,postType,postSubject,newfileName);
								AddPostStudyMaterialDao dao=new AddPostStudyMaterialDao();
								if(dao.savePost(p)) {

									for (Part part : request.getParts()) {
										part.write(newpath);
									}

									request.setAttribute("AddPostNoticeMsg","Study material was publish successfully !!! . Your file name already existed. So we have changed file name to "+newfileName+" & save to "+newpath);

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

						AddPostStudyMaterialClass p=new AddPostStudyMaterialClass(postId,postDate,postFaculty,postSemester,postType,postSubject,fileName);
						AddPostStudyMaterialDao dao=new AddPostStudyMaterialDao();
						if(dao.savePost(p)) {




							for (Part part : request.getParts()) {
								part.write(path);
							}
							request.setAttribute("AddPostNoticeMsg","Study Material was publish successfully !!!. & save to "+path);

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
				else if(postSubject.equals("Microprocessor")) {
					String fileName = postFile.getSubmittedFileName();
					String path=UPLOAD_DIRECTORY+"\\computer\\book\\4th\\Microprocessor" + File.separator + fileName; //best way
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
							String newpath=UPLOAD_DIRECTORY+"\\computer\\book\\4th\\Microprocessor" + File.separator + newfileName; //best way
							File newdirectory=new File(newpath);

							if(!newdirectory.exists()) {

								AddPostStudyMaterialClass p=new AddPostStudyMaterialClass(postId,postDate,postFaculty,postSemester,postType,postSubject,newfileName);
								AddPostStudyMaterialDao dao=new AddPostStudyMaterialDao();
								if(dao.savePost(p)) {

									for (Part part : request.getParts()) {
										part.write(newpath);
									}

									request.setAttribute("AddPostNoticeMsg","Study material was publish successfully !!! . Your file name already existed. So we have changed file name to "+newfileName+" & save to "+newpath);

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

						AddPostStudyMaterialClass p=new AddPostStudyMaterialClass(postId,postDate,postFaculty,postSemester,postType,postSubject,fileName);
						AddPostStudyMaterialDao dao=new AddPostStudyMaterialDao();
						if(dao.savePost(p)) {




							for (Part part : request.getParts()) {
								part.write(path);
							}
							request.setAttribute("AddPostNoticeMsg","Study Material was publish successfully !!!. & save to "+path);

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
				else if(postSubject.equals("Algorithmic Mathematics")) {
					String fileName = postFile.getSubmittedFileName();
					String path=UPLOAD_DIRECTORY+"\\computer\\book\\4th\\Algorithmic Mathematics" + File.separator + fileName; //best way
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
							String newpath=UPLOAD_DIRECTORY+"\\computer\\book\\4th\\Algorithmic Mathematics" + File.separator + newfileName; //best way
							File newdirectory=new File(newpath);

							if(!newdirectory.exists()) {

								AddPostStudyMaterialClass p=new AddPostStudyMaterialClass(postId,postDate,postFaculty,postSemester,postType,postSubject,newfileName);
								AddPostStudyMaterialDao dao=new AddPostStudyMaterialDao();
								if(dao.savePost(p)) {

									for (Part part : request.getParts()) {
										part.write(newpath);
									}

									request.setAttribute("AddPostNoticeMsg","Study material was publish successfully !!! . Your file name already existed. So we have changed file name to "+newfileName+" & save to "+newpath);

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

						AddPostStudyMaterialClass p=new AddPostStudyMaterialClass(postId,postDate,postFaculty,postSemester,postType,postSubject,fileName);
						AddPostStudyMaterialDao dao=new AddPostStudyMaterialDao();
						if(dao.savePost(p)) {




							for (Part part : request.getParts()) {
								part.write(path);
							}
							request.setAttribute("AddPostNoticeMsg","Study Material was publish successfully !!!. & save to "+path);

							RequestDispatcher requestDispatcher = request.getRequestDispatcher("/admincontrol.jsp");
							requestDispatcher.forward(request, response);


						}
						else {
							request.setAttribute("AddPostNoticeMsg", "Internal error occured.");
							RequestDispatcher dispatcher=request.getRequestDispatcher("/admincontrol.jsp");
							dispatcher.forward(request, response);

						}
					}


				}else if(postSubject.equals("Electrical Machine")) {
					String fileName = postFile.getSubmittedFileName();
					String path=UPLOAD_DIRECTORY+"\\computer\\book\\4th\\Electrical Machine" + File.separator + fileName; //best way
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
							String newpath=UPLOAD_DIRECTORY+"\\computer\\book\\4th\\Electrical Machine" + File.separator + newfileName; //best way
							File newdirectory=new File(newpath);

							if(!newdirectory.exists()) {

								AddPostStudyMaterialClass p=new AddPostStudyMaterialClass(postId,postDate,postFaculty,postSemester,postType,postSubject,newfileName);
								AddPostStudyMaterialDao dao=new AddPostStudyMaterialDao();
								if(dao.savePost(p)) {

									for (Part part : request.getParts()) {
										part.write(newpath);
									}

									request.setAttribute("AddPostNoticeMsg","Study material was publish successfully !!! . Your file name already existed. So we have changed file name to "+newfileName+" & save to "+newpath);

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

						AddPostStudyMaterialClass p=new AddPostStudyMaterialClass(postId,postDate,postFaculty,postSemester,postType,postSubject,fileName);
						AddPostStudyMaterialDao dao=new AddPostStudyMaterialDao();
						if(dao.savePost(p)) {




							for (Part part : request.getParts()) {
								part.write(path);
							}
							request.setAttribute("AddPostNoticeMsg","Study Material was publish successfully !!!. & save to "+path);

							RequestDispatcher requestDispatcher = request.getRequestDispatcher("/admincontrol.jsp");
							requestDispatcher.forward(request, response);


						}
						else {
							request.setAttribute("AddPostNoticeMsg", "Internal error occured.");
							RequestDispatcher dispatcher=request.getRequestDispatcher("/admincontrol.jsp");
							dispatcher.forward(request, response);

						}
					}

				}else if(postSubject.equals("Electronic Device & Circuit")) {
					String fileName = postFile.getSubmittedFileName();
					String path=UPLOAD_DIRECTORY+"\\computer\\book\\4th\\Electronic Device & Circuit" + File.separator + fileName; //best way
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
							String newpath=UPLOAD_DIRECTORY+"\\computer\\book\\4th\\Electronic Device & Circuit" + File.separator + newfileName; //best way
							File newdirectory=new File(newpath);

							if(!newdirectory.exists()) {

								AddPostStudyMaterialClass p=new AddPostStudyMaterialClass(postId,postDate,postFaculty,postSemester,postType,postSubject,newfileName);
								AddPostStudyMaterialDao dao=new AddPostStudyMaterialDao();
								if(dao.savePost(p)) {

									for (Part part : request.getParts()) {
										part.write(newpath);
									}

									request.setAttribute("AddPostNoticeMsg","Study material was publish successfully !!! . Your file name already existed. So we have changed file name to "+newfileName+" & save to "+newpath);

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

						AddPostStudyMaterialClass p=new AddPostStudyMaterialClass(postId,postDate,postFaculty,postSemester,postType,postSubject,fileName);
						AddPostStudyMaterialDao dao=new AddPostStudyMaterialDao();
						if(dao.savePost(p)) {




							for (Part part : request.getParts()) {
								part.write(path);
							}
							request.setAttribute("AddPostNoticeMsg","Study Material was publish successfully !!!. & save to "+path);

							RequestDispatcher requestDispatcher = request.getRequestDispatcher("/admincontrol.jsp");
							requestDispatcher.forward(request, response);


						}
						else {
							request.setAttribute("AddPostNoticeMsg", "Internal error occured.");
							RequestDispatcher dispatcher=request.getRequestDispatcher("/admincontrol.jsp");
							dispatcher.forward(request, response);

						}
					}

				}else if(postSubject.equals("Communication English")) {
					String fileName = postFile.getSubmittedFileName();
					String path=UPLOAD_DIRECTORY+"\\computer\\book\\4th\\Communication English" + File.separator + fileName; //best way
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
							String newpath=UPLOAD_DIRECTORY+"\\computer\\book\\4th\\Communication English" + File.separator + newfileName; //best way
							File newdirectory=new File(newpath);

							if(!newdirectory.exists()) {

								AddPostStudyMaterialClass p=new AddPostStudyMaterialClass(postId,postDate,postFaculty,postSemester,postType,postSubject,newfileName);
								AddPostStudyMaterialDao dao=new AddPostStudyMaterialDao();
								if(dao.savePost(p)) {

									for (Part part : request.getParts()) {
										part.write(newpath);
									}

									request.setAttribute("AddPostNoticeMsg","Study material was publish successfully !!! . Your file name already existed. So we have changed file name to "+newfileName+" & save to "+newpath);

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

						AddPostStudyMaterialClass p=new AddPostStudyMaterialClass(postId,postDate,postFaculty,postSemester,postType,postSubject,fileName);
						AddPostStudyMaterialDao dao=new AddPostStudyMaterialDao();
						if(dao.savePost(p)) {




							for (Part part : request.getParts()) {
								part.write(path);
							}
							request.setAttribute("AddPostNoticeMsg","Study Material was publish successfully !!!. & save to "+path);

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
					request.setAttribute("AddPostNoticeMsg", "Failed to post due to you have not selected any subject.");
					RequestDispatcher dispatcher=request.getRequestDispatcher("/admincontrol.jsp");
					dispatcher.forward(request, response);

				}
			}


			//5th sem


			else if(postFaculty.equals("Computer Engineering") && postSemester.equals("5th sem") && postType.equals("Book")) {

				if(postSubject.equals("Probability & Statistic")) {
					String fileName = postFile.getSubmittedFileName();
					String path=UPLOAD_DIRECTORY+"\\computer\\book\\5th\\Probability & Statistic" + File.separator + fileName; //best way
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
							String newpath=UPLOAD_DIRECTORY+"\\computer\\book\\5th\\Probability & Statistic" + File.separator + newfileName; //best way
							File newdirectory=new File(newpath);

							if(!newdirectory.exists()) {

								AddPostStudyMaterialClass p=new AddPostStudyMaterialClass(postId,postDate,postFaculty,postSemester,postType,postSubject,newfileName);
								AddPostStudyMaterialDao dao=new AddPostStudyMaterialDao();
								if(dao.savePost(p)) {

									for (Part part : request.getParts()) {
										part.write(newpath);
									}

									request.setAttribute("AddPostNoticeMsg","Study material was publish successfully !!! . Your file name already existed. So we have changed file name to "+newfileName+" & save to "+newpath);

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

						AddPostStudyMaterialClass p=new AddPostStudyMaterialClass(postId,postDate,postFaculty,postSemester,postType,postSubject,fileName);
						AddPostStudyMaterialDao dao=new AddPostStudyMaterialDao();
						if(dao.savePost(p)) {




							for (Part part : request.getParts()) {
								part.write(path);
							}
							request.setAttribute("AddPostNoticeMsg","Study Material was publish successfully !!!. & save to "+path);

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
				else if(postSubject.equals("Instrumentation")) {
					String fileName = postFile.getSubmittedFileName();
					String path=UPLOAD_DIRECTORY+"\\computer\\book\\5th\\Instrumentation" + File.separator + fileName; //best way
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
							String newpath=UPLOAD_DIRECTORY+"\\computer\\book\\5th\\Instrumentation" + File.separator + newfileName; //best way
							File newdirectory=new File(newpath);

							if(!newdirectory.exists()) {

								AddPostStudyMaterialClass p=new AddPostStudyMaterialClass(postId,postDate,postFaculty,postSemester,postType,postSubject,newfileName);
								AddPostStudyMaterialDao dao=new AddPostStudyMaterialDao();
								if(dao.savePost(p)) {

									for (Part part : request.getParts()) {
										part.write(newpath);
									}

									request.setAttribute("AddPostNoticeMsg","Study material was publish successfully !!! . Your file name already existed. So we have changed file name to "+newfileName+" & save to "+newpath);

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

						AddPostStudyMaterialClass p=new AddPostStudyMaterialClass(postId,postDate,postFaculty,postSemester,postType,postSubject,fileName);
						AddPostStudyMaterialDao dao=new AddPostStudyMaterialDao();
						if(dao.savePost(p)) {




							for (Part part : request.getParts()) {
								part.write(path);
							}
							request.setAttribute("AddPostNoticeMsg","Study Material was publish successfully !!!. & save to "+path);

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
				else if(postSubject.equals("Computer Graphics")) {
					String fileName = postFile.getSubmittedFileName();
					String path=UPLOAD_DIRECTORY+"\\computer\\book\\5th\\Computer Graphics" + File.separator + fileName; //best way
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
							String newpath=UPLOAD_DIRECTORY+"\\computer\\book\\5th\\Computer Graphics" + File.separator + newfileName; //best way
							File newdirectory=new File(newpath);

							if(!newdirectory.exists()) {

								AddPostStudyMaterialClass p=new AddPostStudyMaterialClass(postId,postDate,postFaculty,postSemester,postType,postSubject,newfileName);
								AddPostStudyMaterialDao dao=new AddPostStudyMaterialDao();
								if(dao.savePost(p)) {

									for (Part part : request.getParts()) {
										part.write(newpath);
									}

									request.setAttribute("AddPostNoticeMsg","Study material was publish successfully !!! . Your file name already existed. So we have changed file name to "+newfileName+" & save to "+newpath);

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

						AddPostStudyMaterialClass p=new AddPostStudyMaterialClass(postId,postDate,postFaculty,postSemester,postType,postSubject,fileName);
						AddPostStudyMaterialDao dao=new AddPostStudyMaterialDao();
						if(dao.savePost(p)) {




							for (Part part : request.getParts()) {
								part.write(path);
							}
							request.setAttribute("AddPostNoticeMsg","Study Material was publish successfully !!!. & save to "+path);

							RequestDispatcher requestDispatcher = request.getRequestDispatcher("/admincontrol.jsp");
							requestDispatcher.forward(request, response);


						}
						else {
							request.setAttribute("AddPostNoticeMsg", "Internal error occured.");
							RequestDispatcher dispatcher=request.getRequestDispatcher("/admincontrol.jsp");
							dispatcher.forward(request, response);

						}
					}


				}else if(postSubject.equals("Object Oriented Software Engineering")) {
					String fileName = postFile.getSubmittedFileName();
					String path=UPLOAD_DIRECTORY+"\\computer\\book\\5th\\Object Oriented Software Engineering" + File.separator + fileName; //best way
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
							String newpath=UPLOAD_DIRECTORY+"\\computer\\book\\5th\\Object Oriented Software Engineering" + File.separator + newfileName; //best way
							File newdirectory=new File(newpath);

							if(!newdirectory.exists()) {

								AddPostStudyMaterialClass p=new AddPostStudyMaterialClass(postId,postDate,postFaculty,postSemester,postType,postSubject,newfileName);
								AddPostStudyMaterialDao dao=new AddPostStudyMaterialDao();
								if(dao.savePost(p)) {

									for (Part part : request.getParts()) {
										part.write(newpath);
									}

									request.setAttribute("AddPostNoticeMsg","Study material was publish successfully !!! . Your file name already existed. So we have changed file name to "+newfileName+" & save to "+newpath);

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

						AddPostStudyMaterialClass p=new AddPostStudyMaterialClass(postId,postDate,postFaculty,postSemester,postType,postSubject,fileName);
						AddPostStudyMaterialDao dao=new AddPostStudyMaterialDao();
						if(dao.savePost(p)) {




							for (Part part : request.getParts()) {
								part.write(path);
							}
							request.setAttribute("AddPostNoticeMsg","Study Material was publish successfully !!!. & save to "+path);

							RequestDispatcher requestDispatcher = request.getRequestDispatcher("/admincontrol.jsp");
							requestDispatcher.forward(request, response);


						}
						else {
							request.setAttribute("AddPostNoticeMsg", "Internal error occured.");
							RequestDispatcher dispatcher=request.getRequestDispatcher("/admincontrol.jsp");
							dispatcher.forward(request, response);

						}
					}

				}else if(postSubject.equals("Computer Architecture & Design")) {
					String fileName = postFile.getSubmittedFileName();
					String path=UPLOAD_DIRECTORY+"\\computer\\book\\5th\\Computer Architecture & Design" + File.separator + fileName; //best way
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
							String newpath=UPLOAD_DIRECTORY+"\\computer\\book\\5th\\Computer Architecture & Design" + File.separator + newfileName; //best way
							File newdirectory=new File(newpath);

							if(!newdirectory.exists()) {

								AddPostStudyMaterialClass p=new AddPostStudyMaterialClass(postId,postDate,postFaculty,postSemester,postType,postSubject,newfileName);
								AddPostStudyMaterialDao dao=new AddPostStudyMaterialDao();
								if(dao.savePost(p)) {

									for (Part part : request.getParts()) {
										part.write(newpath);
									}

									request.setAttribute("AddPostNoticeMsg","Study material was publish successfully !!! . Your file name already existed. So we have changed file name to "+newfileName+" & save to "+newpath);

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

						AddPostStudyMaterialClass p=new AddPostStudyMaterialClass(postId,postDate,postFaculty,postSemester,postType,postSubject,fileName);
						AddPostStudyMaterialDao dao=new AddPostStudyMaterialDao();
						if(dao.savePost(p)) {




							for (Part part : request.getParts()) {
								part.write(path);
							}
							request.setAttribute("AddPostNoticeMsg","Study Material was publish successfully !!!. & save to "+path);

							RequestDispatcher requestDispatcher = request.getRequestDispatcher("/admincontrol.jsp");
							requestDispatcher.forward(request, response);


						}
						else {
							request.setAttribute("AddPostNoticeMsg", "Internal error occured.");
							RequestDispatcher dispatcher=request.getRequestDispatcher("/admincontrol.jsp");
							dispatcher.forward(request, response);

						}
					}

				}else if(postSubject.equals("Operating System")) {
					String fileName = postFile.getSubmittedFileName();
					String path=UPLOAD_DIRECTORY+"\\computer\\book\\5th\\Operating System" + File.separator + fileName; //best way
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
							String newpath=UPLOAD_DIRECTORY+"\\computer\\book\\5th\\Operating System" + File.separator + newfileName; //best way
							File newdirectory=new File(newpath);

							if(!newdirectory.exists()) {

								AddPostStudyMaterialClass p=new AddPostStudyMaterialClass(postId,postDate,postFaculty,postSemester,postType,postSubject,newfileName);
								AddPostStudyMaterialDao dao=new AddPostStudyMaterialDao();
								if(dao.savePost(p)) {

									for (Part part : request.getParts()) {
										part.write(newpath);
									}

									request.setAttribute("AddPostNoticeMsg","Study material was publish successfully !!! . Your file name already existed. So we have changed file name to "+newfileName+" & save to "+newpath);

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

						AddPostStudyMaterialClass p=new AddPostStudyMaterialClass(postId,postDate,postFaculty,postSemester,postType,postSubject,fileName);
						AddPostStudyMaterialDao dao=new AddPostStudyMaterialDao();
						if(dao.savePost(p)) {




							for (Part part : request.getParts()) {
								part.write(path);
							}
							request.setAttribute("AddPostNoticeMsg","Study Material was publish successfully !!!. & save to "+path);

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
					request.setAttribute("AddPostNoticeMsg", "Failed to post due to you have not selected any subject.");
					RequestDispatcher dispatcher=request.getRequestDispatcher("/admincontrol.jsp");
					dispatcher.forward(request, response);

				}
			}


			//6th sem


			else if(postFaculty.equals("Computer Engineering") && postSemester.equals("6th sem") && postType.equals("Book")) {

				if(postSubject.equals("Project & Organization Management")) {
					String fileName = postFile.getSubmittedFileName();
					String path=UPLOAD_DIRECTORY+"\\computer\\book\\6th\\Project & Organization Management" + File.separator + fileName; //best way
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
							String newpath=UPLOAD_DIRECTORY+"\\computer\\book\\6th\\Project & Organization Management" + File.separator + newfileName; //best way
							File newdirectory=new File(newpath);

							if(!newdirectory.exists()) {

								AddPostStudyMaterialClass p=new AddPostStudyMaterialClass(postId,postDate,postFaculty,postSemester,postType,postSubject,newfileName);
								AddPostStudyMaterialDao dao=new AddPostStudyMaterialDao();
								if(dao.savePost(p)) {

									for (Part part : request.getParts()) {
										part.write(newpath);
									}

									request.setAttribute("AddPostNoticeMsg","Study material was publish successfully !!! . Your file name already existed. So we have changed file name to "+newfileName+" & save to "+newpath);

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

						AddPostStudyMaterialClass p=new AddPostStudyMaterialClass(postId,postDate,postFaculty,postSemester,postType,postSubject,fileName);
						AddPostStudyMaterialDao dao=new AddPostStudyMaterialDao();
						if(dao.savePost(p)) {




							for (Part part : request.getParts()) {
								part.write(path);
							}
							request.setAttribute("AddPostNoticeMsg","Study Material was publish successfully !!!. & save to "+path);

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
				else if(postSubject.equals("Research Methodology")) {
					String fileName = postFile.getSubmittedFileName();
					String path=UPLOAD_DIRECTORY+"\\computer\\book\\6th\\Research Methodology" + File.separator + fileName; //best way
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
							String newpath=UPLOAD_DIRECTORY+"\\computer\\book\\6th\\Research Methodology" + File.separator + newfileName; //best way
							File newdirectory=new File(newpath);

							if(!newdirectory.exists()) {

								AddPostStudyMaterialClass p=new AddPostStudyMaterialClass(postId,postDate,postFaculty,postSemester,postType,postSubject,newfileName);
								AddPostStudyMaterialDao dao=new AddPostStudyMaterialDao();
								if(dao.savePost(p)) {

									for (Part part : request.getParts()) {
										part.write(newpath);
									}

									request.setAttribute("AddPostNoticeMsg","Study material was publish successfully !!! . Your file name already existed. So we have changed file name to "+newfileName+" & save to "+newpath);

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

						AddPostStudyMaterialClass p=new AddPostStudyMaterialClass(postId,postDate,postFaculty,postSemester,postType,postSubject,fileName);
						AddPostStudyMaterialDao dao=new AddPostStudyMaterialDao();
						if(dao.savePost(p)) {




							for (Part part : request.getParts()) {
								part.write(path);
							}
							request.setAttribute("AddPostNoticeMsg","Study Material was publish successfully !!!. & save to "+path);

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
				else if(postSubject.equals("Artificial Intelligence")) {
					String fileName = postFile.getSubmittedFileName();
					String path=UPLOAD_DIRECTORY+"\\computer\\book\\6th\\Artificial Intelligence" + File.separator + fileName; //best way
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
							String newpath=UPLOAD_DIRECTORY+"\\computer\\book\\6th\\Artificial Intelligence" + File.separator + newfileName; //best way
							File newdirectory=new File(newpath);

							if(!newdirectory.exists()) {

								AddPostStudyMaterialClass p=new AddPostStudyMaterialClass(postId,postDate,postFaculty,postSemester,postType,postSubject,newfileName);
								AddPostStudyMaterialDao dao=new AddPostStudyMaterialDao();
								if(dao.savePost(p)) {

									for (Part part : request.getParts()) {
										part.write(newpath);
									}

									request.setAttribute("AddPostNoticeMsg","Study material was publish successfully !!! . Your file name already existed. So we have changed file name to "+newfileName+" & save to "+newpath);

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

						AddPostStudyMaterialClass p=new AddPostStudyMaterialClass(postId,postDate,postFaculty,postSemester,postType,postSubject,fileName);
						AddPostStudyMaterialDao dao=new AddPostStudyMaterialDao();
						if(dao.savePost(p)) {




							for (Part part : request.getParts()) {
								part.write(path);
							}
							request.setAttribute("AddPostNoticeMsg","Study Material was publish successfully !!!. & save to "+path);

							RequestDispatcher requestDispatcher = request.getRequestDispatcher("/admincontrol.jsp");
							requestDispatcher.forward(request, response);


						}
						else {
							request.setAttribute("AddPostNoticeMsg", "Internal error occured.");
							RequestDispatcher dispatcher=request.getRequestDispatcher("/admincontrol.jsp");
							dispatcher.forward(request, response);

						}
					}


				}else if(postSubject.equals("Database Management System")) {
					String fileName = postFile.getSubmittedFileName();
					String path=UPLOAD_DIRECTORY+"\\computer\\book\\6th\\Database Management System" + File.separator + fileName; //best way
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
							String newpath=UPLOAD_DIRECTORY+"\\computer\\book\\6th\\Database Management System" + File.separator + newfileName; //best way
							File newdirectory=new File(newpath);

							if(!newdirectory.exists()) {

								AddPostStudyMaterialClass p=new AddPostStudyMaterialClass(postId,postDate,postFaculty,postSemester,postType,postSubject,newfileName);
								AddPostStudyMaterialDao dao=new AddPostStudyMaterialDao();
								if(dao.savePost(p)) {

									for (Part part : request.getParts()) {
										part.write(newpath);
									}

									request.setAttribute("AddPostNoticeMsg","Study material was publish successfully !!! . Your file name already existed. So we have changed file name to "+newfileName+" & save to "+newpath);

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

						AddPostStudyMaterialClass p=new AddPostStudyMaterialClass(postId,postDate,postFaculty,postSemester,postType,postSubject,fileName);
						AddPostStudyMaterialDao dao=new AddPostStudyMaterialDao();
						if(dao.savePost(p)) {




							for (Part part : request.getParts()) {
								part.write(path);
							}
							request.setAttribute("AddPostNoticeMsg","Study Material was publish successfully !!!. & save to "+path);

							RequestDispatcher requestDispatcher = request.getRequestDispatcher("/admincontrol.jsp");
							requestDispatcher.forward(request, response);


						}
						else {
							request.setAttribute("AddPostNoticeMsg", "Internal error occured.");
							RequestDispatcher dispatcher=request.getRequestDispatcher("/admincontrol.jsp");
							dispatcher.forward(request, response);

						}
					}

				}else if(postSubject.equals("Communication System")) {
					String fileName = postFile.getSubmittedFileName();
					String path=UPLOAD_DIRECTORY+"\\computer\\book\\6th\\Communication System" + File.separator + fileName; //best way
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
							String newpath=UPLOAD_DIRECTORY+"\\computer\\book\\6th\\Communication System" + File.separator + newfileName; //best way
							File newdirectory=new File(newpath);

							if(!newdirectory.exists()) {

								AddPostStudyMaterialClass p=new AddPostStudyMaterialClass(postId,postDate,postFaculty,postSemester,postType,postSubject,newfileName);
								AddPostStudyMaterialDao dao=new AddPostStudyMaterialDao();
								if(dao.savePost(p)) {

									for (Part part : request.getParts()) {
										part.write(newpath);
									}

									request.setAttribute("AddPostNoticeMsg","Study material was publish successfully !!! . Your file name already existed. So we have changed file name to "+newfileName+" & save to "+newpath);

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

						AddPostStudyMaterialClass p=new AddPostStudyMaterialClass(postId,postDate,postFaculty,postSemester,postType,postSubject,fileName);
						AddPostStudyMaterialDao dao=new AddPostStudyMaterialDao();
						if(dao.savePost(p)) {




							for (Part part : request.getParts()) {
								part.write(path);
							}
							request.setAttribute("AddPostNoticeMsg","Study Material was publish successfully !!!. & save to "+path);

							RequestDispatcher requestDispatcher = request.getRequestDispatcher("/admincontrol.jsp");
							requestDispatcher.forward(request, response);


						}
						else {
							request.setAttribute("AddPostNoticeMsg", "Internal error occured.");
							RequestDispatcher dispatcher=request.getRequestDispatcher("/admincontrol.jsp");
							dispatcher.forward(request, response);

						}
					}

				}else if(postSubject.equals("Engineering Economics")) {
					String fileName = postFile.getSubmittedFileName();
					String path=UPLOAD_DIRECTORY+"\\computer\\book\\6th\\Engineering Economics" + File.separator + fileName; //best way
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
							String newpath=UPLOAD_DIRECTORY+"\\computer\\book\\6th\\Engineering Economics" + File.separator + newfileName; //best way
							File newdirectory=new File(newpath);

							if(!newdirectory.exists()) {

								AddPostStudyMaterialClass p=new AddPostStudyMaterialClass(postId,postDate,postFaculty,postSemester,postType,postSubject,newfileName);
								AddPostStudyMaterialDao dao=new AddPostStudyMaterialDao();
								if(dao.savePost(p)) {

									for (Part part : request.getParts()) {
										part.write(newpath);
									}

									request.setAttribute("AddPostNoticeMsg","Study material was publish successfully !!! . Your file name already existed. So we have changed file name to "+newfileName+" & save to "+newpath);

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

						AddPostStudyMaterialClass p=new AddPostStudyMaterialClass(postId,postDate,postFaculty,postSemester,postType,postSubject,fileName);
						AddPostStudyMaterialDao dao=new AddPostStudyMaterialDao();
						if(dao.savePost(p)) {




							for (Part part : request.getParts()) {
								part.write(path);
							}
							request.setAttribute("AddPostNoticeMsg","Study Material was publish successfully !!!. & save to "+path);

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

				else if(postSubject.equals("Minor Project")) {
					String fileName = postFile.getSubmittedFileName();
					String path=UPLOAD_DIRECTORY+"\\computer\\book\\6th\\Minor Project" + File.separator + fileName; //best way
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
							String newpath=UPLOAD_DIRECTORY+"\\computer\\book\\6th\\Minor Project" + File.separator + newfileName; //best way
							File newdirectory=new File(newpath);

							if(!newdirectory.exists()) {

								AddPostStudyMaterialClass p=new AddPostStudyMaterialClass(postId,postDate,postFaculty,postSemester,postType,postSubject,newfileName);
								AddPostStudyMaterialDao dao=new AddPostStudyMaterialDao();
								if(dao.savePost(p)) {

									for (Part part : request.getParts()) {
										part.write(newpath);
									}

									request.setAttribute("AddPostNoticeMsg","Study material was publish successfully !!! . Your file name already existed. So we have changed file name to "+newfileName+" & save to "+newpath);

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

						AddPostStudyMaterialClass p=new AddPostStudyMaterialClass(postId,postDate,postFaculty,postSemester,postType,postSubject,fileName);
						AddPostStudyMaterialDao dao=new AddPostStudyMaterialDao();
						if(dao.savePost(p)) {




							for (Part part : request.getParts()) {
								part.write(path);
							}
							request.setAttribute("AddPostNoticeMsg","Study Material was publish successfully !!!. & save to "+path);

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
					request.setAttribute("AddPostNoticeMsg", "Failed to post due to you have not selected any subject.");
					RequestDispatcher dispatcher=request.getRequestDispatcher("/admincontrol.jsp");
					dispatcher.forward(request, response);

				}
			}

			//7th sem

			else if(postFaculty.equals("Computer Engineering") && postSemester.equals("7th sem") && postType.equals("Book")) {

				if(postSubject.equals("Computer Networks")) {
					String fileName = postFile.getSubmittedFileName();
					String path=UPLOAD_DIRECTORY+"\\computer\\book\\7th\\Computer Networks" + File.separator + fileName; //best way
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
							String newpath=UPLOAD_DIRECTORY+"\\computer\\book\\7th\\Computer Networks" + File.separator + newfileName; //best way
							File newdirectory=new File(newpath);

							if(!newdirectory.exists()) {

								AddPostStudyMaterialClass p=new AddPostStudyMaterialClass(postId,postDate,postFaculty,postSemester,postType,postSubject,newfileName);
								AddPostStudyMaterialDao dao=new AddPostStudyMaterialDao();
								if(dao.savePost(p)) {

									for (Part part : request.getParts()) {
										part.write(newpath);
									}

									request.setAttribute("AddPostNoticeMsg","Study material was publish successfully !!! . Your file name already existed. So we have changed file name to "+newfileName+" & save to "+newpath);

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

						AddPostStudyMaterialClass p=new AddPostStudyMaterialClass(postId,postDate,postFaculty,postSemester,postType,postSubject,fileName);
						AddPostStudyMaterialDao dao=new AddPostStudyMaterialDao();
						if(dao.savePost(p)) {




							for (Part part : request.getParts()) {
								part.write(path);
							}
							request.setAttribute("AddPostNoticeMsg","Study Material was publish successfully !!!. & save to "+path);

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
				else if(postSubject.equals("Distributed Computing")) {
					String fileName = postFile.getSubmittedFileName();
					String path=UPLOAD_DIRECTORY+"\\computer\\book\\7th\\Distributed Computing" + File.separator + fileName; //best way
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
							String newpath=UPLOAD_DIRECTORY+"\\computer\\book\\7th\\Distributed Computing" + File.separator + newfileName; //best way
							File newdirectory=new File(newpath);

							if(!newdirectory.exists()) {

								AddPostStudyMaterialClass p=new AddPostStudyMaterialClass(postId,postDate,postFaculty,postSemester,postType,postSubject,newfileName);
								AddPostStudyMaterialDao dao=new AddPostStudyMaterialDao();
								if(dao.savePost(p)) {

									for (Part part : request.getParts()) {
										part.write(newpath);
									}

									request.setAttribute("AddPostNoticeMsg","Study material was publish successfully !!! . Your file name already existed. So we have changed file name to "+newfileName+" & save to "+newpath);

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

						AddPostStudyMaterialClass p=new AddPostStudyMaterialClass(postId,postDate,postFaculty,postSemester,postType,postSubject,fileName);
						AddPostStudyMaterialDao dao=new AddPostStudyMaterialDao();
						if(dao.savePost(p)) {




							for (Part part : request.getParts()) {
								part.write(path);
							}
							request.setAttribute("AddPostNoticeMsg","Study Material was publish successfully !!!. & save to "+path);

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
				else if(postSubject.equals("Information System")) {
					String fileName = postFile.getSubmittedFileName();
					String path=UPLOAD_DIRECTORY+"\\computer\\book\\7th\\Information System" + File.separator + fileName; //best way
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
							String newpath=UPLOAD_DIRECTORY+"\\computer\\book\\7th\\Information System" + File.separator + newfileName; //best way
							File newdirectory=new File(newpath);

							if(!newdirectory.exists()) {

								AddPostStudyMaterialClass p=new AddPostStudyMaterialClass(postId,postDate,postFaculty,postSemester,postType,postSubject,newfileName);
								AddPostStudyMaterialDao dao=new AddPostStudyMaterialDao();
								if(dao.savePost(p)) {

									for (Part part : request.getParts()) {
										part.write(newpath);
									}

									request.setAttribute("AddPostNoticeMsg","Study material was publish successfully !!! . Your file name already existed. So we have changed file name to "+newfileName+" & save to "+newpath);

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

						AddPostStudyMaterialClass p=new AddPostStudyMaterialClass(postId,postDate,postFaculty,postSemester,postType,postSubject,fileName);
						AddPostStudyMaterialDao dao=new AddPostStudyMaterialDao();
						if(dao.savePost(p)) {




							for (Part part : request.getParts()) {
								part.write(path);
							}
							request.setAttribute("AddPostNoticeMsg","Study Material was publish successfully !!!. & save to "+path);

							RequestDispatcher requestDispatcher = request.getRequestDispatcher("/admincontrol.jsp");
							requestDispatcher.forward(request, response);


						}
						else {
							request.setAttribute("AddPostNoticeMsg", "Internal error occured.");
							RequestDispatcher dispatcher=request.getRequestDispatcher("/admincontrol.jsp");
							dispatcher.forward(request, response);

						}
					}


				}else if(postSubject.equals("Data Mining & Data Warehousing")) {
					String fileName = postFile.getSubmittedFileName();
					String path=UPLOAD_DIRECTORY+"\\computer\\book\\7th\\Data Mining & Data Warehousing" + File.separator + fileName; //best way
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
							String newpath=UPLOAD_DIRECTORY+"\\computer\\book\\7th\\Data Mining & Data Warehousing" + File.separator + newfileName; //best way
							File newdirectory=new File(newpath);

							if(!newdirectory.exists()) {

								AddPostStudyMaterialClass p=new AddPostStudyMaterialClass(postId,postDate,postFaculty,postSemester,postType,postSubject,newfileName);
								AddPostStudyMaterialDao dao=new AddPostStudyMaterialDao();
								if(dao.savePost(p)) {

									for (Part part : request.getParts()) {
										part.write(newpath);
									}

									request.setAttribute("AddPostNoticeMsg","Study material was publish successfully !!! . Your file name already existed. So we have changed file name to "+newfileName+" & save to "+newpath);

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

						AddPostStudyMaterialClass p=new AddPostStudyMaterialClass(postId,postDate,postFaculty,postSemester,postType,postSubject,fileName);
						AddPostStudyMaterialDao dao=new AddPostStudyMaterialDao();
						if(dao.savePost(p)) {




							for (Part part : request.getParts()) {
								part.write(path);
							}
							request.setAttribute("AddPostNoticeMsg","Study Material was publish successfully !!!. & save to "+path);

							RequestDispatcher requestDispatcher = request.getRequestDispatcher("/admincontrol.jsp");
							requestDispatcher.forward(request, response);


						}
						else {
							request.setAttribute("AddPostNoticeMsg", "Internal error occured.");
							RequestDispatcher dispatcher=request.getRequestDispatcher("/admincontrol.jsp");
							dispatcher.forward(request, response);

						}
					}

				}else if(postSubject.equals("Simulation & Modeling")) {
					String fileName = postFile.getSubmittedFileName();
					String path=UPLOAD_DIRECTORY+"\\computer\\book\\7th\\Simulation & Modeling" + File.separator + fileName; //best way
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
							String newpath=UPLOAD_DIRECTORY+"\\computer\\book\\7th\\Simulation & Modeling" + File.separator + newfileName; //best way
							File newdirectory=new File(newpath);

							if(!newdirectory.exists()) {

								AddPostStudyMaterialClass p=new AddPostStudyMaterialClass(postId,postDate,postFaculty,postSemester,postType,postSubject,newfileName);
								AddPostStudyMaterialDao dao=new AddPostStudyMaterialDao();
								if(dao.savePost(p)) {

									for (Part part : request.getParts()) {
										part.write(newpath);
									}

									request.setAttribute("AddPostNoticeMsg","Study material was publish successfully !!! . Your file name already existed. So we have changed file name to "+newfileName+" & save to "+newpath);

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

						AddPostStudyMaterialClass p=new AddPostStudyMaterialClass(postId,postDate,postFaculty,postSemester,postType,postSubject,fileName);
						AddPostStudyMaterialDao dao=new AddPostStudyMaterialDao();
						if(dao.savePost(p)) {




							for (Part part : request.getParts()) {
								part.write(path);
							}
							request.setAttribute("AddPostNoticeMsg","Study Material was publish successfully !!!. & save to "+path);

							RequestDispatcher requestDispatcher = request.getRequestDispatcher("/admincontrol.jsp");
							requestDispatcher.forward(request, response);


						}
						else {
							request.setAttribute("AddPostNoticeMsg", "Internal error occured.");
							RequestDispatcher dispatcher=request.getRequestDispatcher("/admincontrol.jsp");
							dispatcher.forward(request, response);

						}
					}

				}else if(postSubject.equals("Elective-I")) {
					String fileName = postFile.getSubmittedFileName();
					String path=UPLOAD_DIRECTORY+"\\computer\\book\\7th\\Elective-I" + File.separator + fileName; //best way
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
							String newpath=UPLOAD_DIRECTORY+"\\computer\\book\\7th\\Elective-I" + File.separator + newfileName; //best way
							File newdirectory=new File(newpath);

							if(!newdirectory.exists()) {

								AddPostStudyMaterialClass p=new AddPostStudyMaterialClass(postId,postDate,postFaculty,postSemester,postType,postSubject,newfileName);
								AddPostStudyMaterialDao dao=new AddPostStudyMaterialDao();
								if(dao.savePost(p)) {

									for (Part part : request.getParts()) {
										part.write(newpath);
									}

									request.setAttribute("AddPostNoticeMsg","Study material was publish successfully !!! . Your file name already existed. So we have changed file name to "+newfileName+" & save to "+newpath);

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

						AddPostStudyMaterialClass p=new AddPostStudyMaterialClass(postId,postDate,postFaculty,postSemester,postType,postSubject,fileName);
						AddPostStudyMaterialDao dao=new AddPostStudyMaterialDao();
						if(dao.savePost(p)) {




							for (Part part : request.getParts()) {
								part.write(path);
							}
							request.setAttribute("AddPostNoticeMsg","Study Material was publish successfully !!!. & save to "+path);

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
				else if(postSubject.equals("Project-Part A")) {
					String fileName = postFile.getSubmittedFileName();
					String path=UPLOAD_DIRECTORY+"\\computer\\book\\7th\\Project-Part A" + File.separator + fileName; //best way
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
							String newpath=UPLOAD_DIRECTORY+"\\computer\\book\\7th\\Project-Part A" + File.separator + newfileName; //best way
							File newdirectory=new File(newpath);

							if(!newdirectory.exists()) {

								AddPostStudyMaterialClass p=new AddPostStudyMaterialClass(postId,postDate,postFaculty,postSemester,postType,postSubject,newfileName);
								AddPostStudyMaterialDao dao=new AddPostStudyMaterialDao();
								if(dao.savePost(p)) {

									for (Part part : request.getParts()) {
										part.write(newpath);
									}

									request.setAttribute("AddPostNoticeMsg","Study material was publish successfully !!! . Your file name already existed. So we have changed file name to "+newfileName+" & save to "+newpath);

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

						AddPostStudyMaterialClass p=new AddPostStudyMaterialClass(postId,postDate,postFaculty,postSemester,postType,postSubject,fileName);
						AddPostStudyMaterialDao dao=new AddPostStudyMaterialDao();
						if(dao.savePost(p)) {




							for (Part part : request.getParts()) {
								part.write(path);
							}
							request.setAttribute("AddPostNoticeMsg","Study Material was publish successfully !!!. & save to "+path);

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
					request.setAttribute("AddPostNoticeMsg", "Failed to post due to you have not selected any subject.");
					RequestDispatcher dispatcher=request.getRequestDispatcher("/admincontrol.jsp");
					dispatcher.forward(request, response);

				}
			}

			//8th sem

			else if(postFaculty.equals("Computer Engineering") && postSemester.equals("8th sem") && postType.equals("Book")) {

				if(postSubject.equals("Digital Signal Analysis & Processing")) {
					String fileName = postFile.getSubmittedFileName();
					String path=UPLOAD_DIRECTORY+"\\computer\\book\\8th\\Digital Signal Analysis & Processing" + File.separator + fileName; //best way
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
							String newpath=UPLOAD_DIRECTORY+"\\computer\\book\\8th\\Digital Signal Analysis & Processing" + File.separator + newfileName; //best way
							File newdirectory=new File(newpath);

							if(!newdirectory.exists()) {

								AddPostStudyMaterialClass p=new AddPostStudyMaterialClass(postId,postDate,postFaculty,postSemester,postType,postSubject,newfileName);
								AddPostStudyMaterialDao dao=new AddPostStudyMaterialDao();
								if(dao.savePost(p)) {

									for (Part part : request.getParts()) {
										part.write(newpath);
									}

									request.setAttribute("AddPostNoticeMsg","Study material was publish successfully !!! . Your file name already existed. So we have changed file name to "+newfileName+" & save to "+newpath);

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

						AddPostStudyMaterialClass p=new AddPostStudyMaterialClass(postId,postDate,postFaculty,postSemester,postType,postSubject,fileName);
						AddPostStudyMaterialDao dao=new AddPostStudyMaterialDao();
						if(dao.savePost(p)) {




							for (Part part : request.getParts()) {
								part.write(path);
							}
							request.setAttribute("AddPostNoticeMsg","Study Material was publish successfully !!!. & save to "+path);

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
				else if(postSubject.equals("Engineering Professional Practice")) {
					String fileName = postFile.getSubmittedFileName();
					String path=UPLOAD_DIRECTORY+"\\computer\\book\\8th\\Engineering Professional Practice" + File.separator + fileName; //best way
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
							String newpath=UPLOAD_DIRECTORY+"\\computer\\book\\8th\\Engineering Professional Practice" + File.separator + newfileName; //best way
							File newdirectory=new File(newpath);

							if(!newdirectory.exists()) {

								AddPostStudyMaterialClass p=new AddPostStudyMaterialClass(postId,postDate,postFaculty,postSemester,postType,postSubject,newfileName);
								AddPostStudyMaterialDao dao=new AddPostStudyMaterialDao();
								if(dao.savePost(p)) {

									for (Part part : request.getParts()) {
										part.write(newpath);
									}

									request.setAttribute("AddPostNoticeMsg","Study material was publish successfully !!! . Your file name already existed. So we have changed file name to "+newfileName+" & save to "+newpath);

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
						AddPostStudyMaterialClass p=new AddPostStudyMaterialClass(postId,postDate,postFaculty,postSemester,postType,postSubject,fileName);
						AddPostStudyMaterialDao dao=new AddPostStudyMaterialDao();
						if(dao.savePost(p)) {
							for (Part part : request.getParts()) {
								part.write(path);
							}
							request.setAttribute("AddPostNoticeMsg","Study Material was publish successfully !!!. & save to "+path);

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
				else if(postSubject.equals("Information Security")) {
					String fileName = postFile.getSubmittedFileName();
					String path=UPLOAD_DIRECTORY+"\\computer\\book\\8th\\Information Security" + File.separator + fileName; //best way
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
							String newpath=UPLOAD_DIRECTORY+"\\computer\\book\\8th\\Information Security" + File.separator + newfileName; //best way
							File newdirectory=new File(newpath);

							if(!newdirectory.exists()) {

								AddPostStudyMaterialClass p=new AddPostStudyMaterialClass(postId,postDate,postFaculty,postSemester,postType,postSubject,newfileName);
								AddPostStudyMaterialDao dao=new AddPostStudyMaterialDao();
								if(dao.savePost(p)) {

									for (Part part : request.getParts()) {
										part.write(newpath);
									}

									request.setAttribute("AddPostNoticeMsg","Study material was publish successfully !!! . Your file name already existed. So we have changed file name to "+newfileName+" & save to "+newpath);

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

						AddPostStudyMaterialClass p=new AddPostStudyMaterialClass(postId,postDate,postFaculty,postSemester,postType,postSubject,fileName);
						AddPostStudyMaterialDao dao=new AddPostStudyMaterialDao();
						if(dao.savePost(p)) {

							for (Part part : request.getParts()) {
								part.write(path);
							}
							request.setAttribute("AddPostNoticeMsg","Study Material was publish successfully !!!. & save to "+path);

							RequestDispatcher requestDispatcher = request.getRequestDispatcher("/admincontrol.jsp");
							requestDispatcher.forward(request, response);

						}
						else {
							request.setAttribute("AddPostNoticeMsg", "Internal error occured.");
							RequestDispatcher dispatcher=request.getRequestDispatcher("/admincontrol.jsp");
							dispatcher.forward(request, response);

						}
					}

				}else if(postSubject.equals("Big Data")) {
					String fileName = postFile.getSubmittedFileName();
					String path=UPLOAD_DIRECTORY+"\\computer\\book\\8th\\Big Data" + File.separator + fileName; //best way
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
							String newpath=UPLOAD_DIRECTORY+"\\computer\\book\\8th\\Big Data" + File.separator + newfileName; //best way
							File newdirectory=new File(newpath);

							if(!newdirectory.exists()) {

								AddPostStudyMaterialClass p=new AddPostStudyMaterialClass(postId,postDate,postFaculty,postSemester,postType,postSubject,newfileName);
								AddPostStudyMaterialDao dao=new AddPostStudyMaterialDao();
								if(dao.savePost(p)) {

									for (Part part : request.getParts()) {
										part.write(newpath);
									}

									request.setAttribute("AddPostNoticeMsg","Study material was publish successfully !!! . Your file name already existed. So we have changed file name to "+newfileName+" & save to "+newpath);

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
						AddPostStudyMaterialClass p=new AddPostStudyMaterialClass(postId,postDate,postFaculty,postSemester,postType,postSubject,fileName);
						AddPostStudyMaterialDao dao=new AddPostStudyMaterialDao();
						if(dao.savePost(p)) {
							for (Part part : request.getParts()) {
								part.write(path);
							}
							request.setAttribute("AddPostNoticeMsg","Study Material was publish successfully !!!. & save to "+path);

							RequestDispatcher requestDispatcher = request.getRequestDispatcher("/admincontrol.jsp");
							requestDispatcher.forward(request, response);

						}
						else {
							request.setAttribute("AddPostNoticeMsg", "Internal error occured.");
							RequestDispatcher dispatcher=request.getRequestDispatcher("/admincontrol.jsp");
							dispatcher.forward(request, response);

						}
					}

				}else if(postSubject.equals("Elective-II")) {
					String fileName = postFile.getSubmittedFileName();
					String path=UPLOAD_DIRECTORY+"\\computer\\book\\8th\\Elective-II" + File.separator + fileName; //best way
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
							String newpath=UPLOAD_DIRECTORY+"\\computer\\book\\8th\\Elective-II" + File.separator + newfileName; //best way
							File newdirectory=new File(newpath);

							if(!newdirectory.exists()) {

								AddPostStudyMaterialClass p=new AddPostStudyMaterialClass(postId,postDate,postFaculty,postSemester,postType,postSubject,newfileName);
								AddPostStudyMaterialDao dao=new AddPostStudyMaterialDao();
								if(dao.savePost(p)) {

									for (Part part : request.getParts()) {
										part.write(newpath);
									}

									request.setAttribute("AddPostNoticeMsg","Study material was publish successfully !!! . Your file name already existed. So we have changed file name to "+newfileName+" & save to "+newpath);

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
						AddPostStudyMaterialClass p=new AddPostStudyMaterialClass(postId,postDate,postFaculty,postSemester,postType,postSubject,fileName);
						AddPostStudyMaterialDao dao=new AddPostStudyMaterialDao();
						if(dao.savePost(p)) {
							for (Part part : request.getParts()) {
								part.write(path);
							}
							request.setAttribute("AddPostNoticeMsg","Study Material was publish successfully !!!. & save to "+path);

							RequestDispatcher requestDispatcher = request.getRequestDispatcher("/admincontrol.jsp");
							requestDispatcher.forward(request, response);
						}
						else {
							request.setAttribute("AddPostNoticeMsg", "Internal error occured.");
							RequestDispatcher dispatcher=request.getRequestDispatcher("/admincontrol.jsp");
							dispatcher.forward(request, response);

						}
					}

				}else if(postSubject.equals("Project-Part B")) {
					String fileName = postFile.getSubmittedFileName();
					String path=UPLOAD_DIRECTORY+"\\computer\\book\\8th\\Project-Part B" + File.separator + fileName; //best way
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
							String newpath=UPLOAD_DIRECTORY+"\\computer\\book\\8th\\Project-Part B" + File.separator + newfileName; //best way
							File newdirectory=new File(newpath);

							if(!newdirectory.exists()) {

								AddPostStudyMaterialClass p=new AddPostStudyMaterialClass(postId,postDate,postFaculty,postSemester,postType,postSubject,newfileName);
								AddPostStudyMaterialDao dao=new AddPostStudyMaterialDao();
								if(dao.savePost(p)) {

									for (Part part : request.getParts()) {
										part.write(newpath);
									}

									request.setAttribute("AddPostNoticeMsg","Study material was publish successfully !!! . Your file name already existed. So we have changed file name to "+newfileName+" & save to "+newpath);

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
						AddPostStudyMaterialClass p=new AddPostStudyMaterialClass(postId,postDate,postFaculty,postSemester,postType,postSubject,fileName);
						AddPostStudyMaterialDao dao=new AddPostStudyMaterialDao();
						if(dao.savePost(p)) {
							for (Part part : request.getParts()) {
								part.write(path);
							}
							request.setAttribute("AddPostNoticeMsg","Study Material was publish successfully !!!. & save to "+path);

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
					request.setAttribute("AddPostNoticeMsg", "Failed to post due to you have not selected any subject.");
					RequestDispatcher dispatcher=request.getRequestDispatcher("/admincontrol.jsp");
					dispatcher.forward(request, response);

				}
			}

			
			
			//Section 2: For Computer->Add Note
			//1st Sem
			else if(postFaculty.equals("Computer Engineering") && postSemester.equals("1st sem") && postType.equals("Note")) {
				if(postSubject.equals("Engineering Drawing")) {
					String fileName = postFile.getSubmittedFileName();
					String path=UPLOAD_DIRECTORY+"\\computer\\note\\1st\\Engineering Drawing" + File.separator + fileName; //best way
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
							String newpath=UPLOAD_DIRECTORY+"\\computer\\note\\1st\\Engineering Drawing" + File.separator + newfileName; //best way
							File newdirectory=new File(newpath);
							if(!newdirectory.exists()) {
								AddPostStudyMaterialClass p=new AddPostStudyMaterialClass(postId,postDate,postFaculty,postSemester,postType,postSubject,newfileName);
								AddPostStudyMaterialDao dao=new AddPostStudyMaterialDao();
								if(dao.savePost(p)) {
									for (Part part : request.getParts()) {
										part.write(newpath);
									}
									request.setAttribute("AddPostNoticeMsg","Study material was publish successfully !!! . Your file name already existed. So we have changed file name to "+newfileName+" & save to "+newpath);

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
						AddPostStudyMaterialClass p=new AddPostStudyMaterialClass(postId,postDate,postFaculty,postSemester,postType,postSubject,fileName);
						AddPostStudyMaterialDao dao=new AddPostStudyMaterialDao();
						if(dao.savePost(p)) {
							for (Part part : request.getParts()) {
								part.write(path);
							}
							request.setAttribute("AddPostNoticeMsg","Study Material was publish successfully !!!. & save to "+path);

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
				else if(postSubject.equals("Engineering Math I")) {
					String fileName = postFile.getSubmittedFileName();
					String path=UPLOAD_DIRECTORY+"\\computer\\note\\1st\\Engineering Math I" + File.separator + fileName; //best way
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
							String newpath=UPLOAD_DIRECTORY+"\\computer\\note\\1st\\Engineering Math I" + File.separator + newfileName; //best way
							File newdirectory=new File(newpath);

							if(!newdirectory.exists()) {

								AddPostStudyMaterialClass p=new AddPostStudyMaterialClass(postId,postDate,postFaculty,postSemester,postType,postSubject,newfileName);
								AddPostStudyMaterialDao dao=new AddPostStudyMaterialDao();
								if(dao.savePost(p)) {

									for (Part part : request.getParts()) {
										part.write(newpath);
									}

									request.setAttribute("AddPostNoticeMsg","Study material was publish successfully !!! . Your file name already existed. So we have changed file name to "+newfileName+" & save to "+newpath);

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
						AddPostStudyMaterialClass p=new AddPostStudyMaterialClass(postId,postDate,postFaculty,postSemester,postType,postSubject,fileName);
						AddPostStudyMaterialDao dao=new AddPostStudyMaterialDao();
						if(dao.savePost(p)) {
							for (Part part : request.getParts()) {
								part.write(path);
							}
							request.setAttribute("AddPostNoticeMsg","Study Material was publish successfully !!!. & save to "+path);

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
				else if(postSubject.equals("Engineering Physics")) {
					String fileName = postFile.getSubmittedFileName();
					String path=UPLOAD_DIRECTORY+"\\computer\\note\\1st\\Engineering Physics" + File.separator + fileName; //best way
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
							String newpath=UPLOAD_DIRECTORY+"\\computer\\note\\1st\\Engineering Physics" + File.separator + newfileName; //best way
							File newdirectory=new File(newpath);

							if(!newdirectory.exists()) {

								AddPostStudyMaterialClass p=new AddPostStudyMaterialClass(postId,postDate,postFaculty,postSemester,postType,postSubject,newfileName);
								AddPostStudyMaterialDao dao=new AddPostStudyMaterialDao();
								if(dao.savePost(p)) {
									for (Part part : request.getParts()) {
										part.write(newpath);
									}
									request.setAttribute("AddPostNoticeMsg","Study material was publish successfully !!! . Your file name already existed. So we have changed file name to "+newfileName+" & save to "+newpath);

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
						AddPostStudyMaterialClass p=new AddPostStudyMaterialClass(postId,postDate,postFaculty,postSemester,postType,postSubject,fileName);
						AddPostStudyMaterialDao dao=new AddPostStudyMaterialDao();
						if(dao.savePost(p)) {
							for (Part part : request.getParts()) {
								part.write(path);
							}
							request.setAttribute("AddPostNoticeMsg","Study Material was publish successfully !!!. & save to "+path);

							RequestDispatcher requestDispatcher = request.getRequestDispatcher("/admincontrol.jsp");
							requestDispatcher.forward(request, response);
						}
						else {
							request.setAttribute("AddPostNoticeMsg", "Internal error occured.");
							RequestDispatcher dispatcher=request.getRequestDispatcher("/admincontrol.jsp");
							dispatcher.forward(request, response);

						}
					}

				}else if(postSubject.equals("Basic Electrical Engineering")) {
					String fileName = postFile.getSubmittedFileName();
					String path=UPLOAD_DIRECTORY+"\\computer\\note\\1st\\Basic Electrical Engineering" + File.separator + fileName; //best way
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
							String newpath=UPLOAD_DIRECTORY+"\\computer\\note\\1st\\Basic Electrical Engineering" + File.separator + newfileName; //best way
							File newdirectory=new File(newpath);
							if(!newdirectory.exists()) {
								AddPostStudyMaterialClass p=new AddPostStudyMaterialClass(postId,postDate,postFaculty,postSemester,postType,postSubject,newfileName);
								AddPostStudyMaterialDao dao=new AddPostStudyMaterialDao();
								if(dao.savePost(p)) {
									for (Part part : request.getParts()) {
										part.write(newpath);
									}
									request.setAttribute("AddPostNoticeMsg","Study material was publish successfully !!! . Your file name already existed. So we have changed file name to "+newfileName+" & save to "+newpath);

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

						AddPostStudyMaterialClass p=new AddPostStudyMaterialClass(postId,postDate,postFaculty,postSemester,postType,postSubject,fileName);
						AddPostStudyMaterialDao dao=new AddPostStudyMaterialDao();
						if(dao.savePost(p)) {
							for (Part part : request.getParts()) {
								part.write(path);
							}
							request.setAttribute("AddPostNoticeMsg","Study Material was publish successfully !!!. & save to "+path);

							RequestDispatcher requestDispatcher = request.getRequestDispatcher("/admincontrol.jsp");
							requestDispatcher.forward(request, response);
						}
						else {
							request.setAttribute("AddPostNoticeMsg", "Internal error occured.");
							RequestDispatcher dispatcher=request.getRequestDispatcher("/admincontrol.jsp");
							dispatcher.forward(request, response);

						}
					}

				}else if(postSubject.equals("Programming in C")) {
					String fileName = postFile.getSubmittedFileName();
					String path=UPLOAD_DIRECTORY+"\\computer\\note\\1st\\Programming in C" + File.separator + fileName; //best way
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
							String newpath=UPLOAD_DIRECTORY+"\\computer\\note\\1st\\Programming in C" + File.separator + newfileName; //best way
							File newdirectory=new File(newpath);

							if(!newdirectory.exists()) {

								AddPostStudyMaterialClass p=new AddPostStudyMaterialClass(postId,postDate,postFaculty,postSemester,postType,postSubject,newfileName);
								AddPostStudyMaterialDao dao=new AddPostStudyMaterialDao();
								if(dao.savePost(p)) {

									for (Part part : request.getParts()) {
										part.write(newpath);
									}

									request.setAttribute("AddPostNoticeMsg","Study material was publish successfully !!! . Your file name already existed. So we have changed file name to "+newfileName+" & save to "+newpath);

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

						AddPostStudyMaterialClass p=new AddPostStudyMaterialClass(postId,postDate,postFaculty,postSemester,postType,postSubject,fileName);
						AddPostStudyMaterialDao dao=new AddPostStudyMaterialDao();
						if(dao.savePost(p)) {
							for (Part part : request.getParts()) {
								part.write(path);
							}
							request.setAttribute("AddPostNoticeMsg","Study Material was publish successfully !!!. & save to "+path);

							RequestDispatcher requestDispatcher = request.getRequestDispatcher("/admincontrol.jsp");
							requestDispatcher.forward(request, response);
						}
						else {
							request.setAttribute("AddPostNoticeMsg", "Internal error occured.");
							RequestDispatcher dispatcher=request.getRequestDispatcher("/admincontrol.jsp");
							dispatcher.forward(request, response);

						}
					}

				}else if(postSubject.equals("Workshop Technology")) {
					String fileName = postFile.getSubmittedFileName();
					String path=UPLOAD_DIRECTORY+"\\computer\\note\\1st\\Workshop Technology" + File.separator + fileName; //best way
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
							String newpath=UPLOAD_DIRECTORY+"\\computer\\note\\1st\\Workshop Technology" + File.separator + newfileName; //best way
							File newdirectory=new File(newpath);

							if(!newdirectory.exists()) {

								AddPostStudyMaterialClass p=new AddPostStudyMaterialClass(postId,postDate,postFaculty,postSemester,postType,postSubject,newfileName);
								AddPostStudyMaterialDao dao=new AddPostStudyMaterialDao();
								if(dao.savePost(p)) {

									for (Part part : request.getParts()) {
										part.write(newpath);
									}

									request.setAttribute("AddPostNoticeMsg","Study material was publish successfully !!! . Your file name already existed. So we have changed file name to "+newfileName+" & save to "+newpath);

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

						AddPostStudyMaterialClass p=new AddPostStudyMaterialClass(postId,postDate,postFaculty,postSemester,postType,postSubject,fileName);
						AddPostStudyMaterialDao dao=new AddPostStudyMaterialDao();
						if(dao.savePost(p)) {
							for (Part part : request.getParts()) {
								part.write(path);
							}
							request.setAttribute("AddPostNoticeMsg","Study Material was publish successfully !!!. & save to "+path);

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
					request.setAttribute("AddPostNoticeMsg", "Failed to post due to you have not selected any subject.");
					RequestDispatcher dispatcher=request.getRequestDispatcher("/admincontrol.jsp");
					dispatcher.forward(request, response);
				}

			}

			//2nd Sem
			
			else if(postFaculty.equals("Computer Engineering") && postSemester.equals("2nd sem") && postType.equals("Note")) {

				if(postSubject.equals("Engineering Math II")) {
					String fileName = postFile.getSubmittedFileName();
					String path=UPLOAD_DIRECTORY+"\\computer\\note\\2nd\\Engineering Math II" + File.separator + fileName; //best way
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
							String newpath=UPLOAD_DIRECTORY+"\\computer\\note\\2nd\\Engineering Math II" + File.separator + newfileName; //best way
							File newdirectory=new File(newpath);

							if(!newdirectory.exists()) {

								AddPostStudyMaterialClass p=new AddPostStudyMaterialClass(postId,postDate,postFaculty,postSemester,postType,postSubject,newfileName);
								AddPostStudyMaterialDao dao=new AddPostStudyMaterialDao();
								if(dao.savePost(p)) {

									for (Part part : request.getParts()) {
										part.write(newpath);
									}

									request.setAttribute("AddPostNoticeMsg","Study material was publish successfully !!! . Your file name already existed. So we have changed file name to "+newfileName+" & save to "+newpath);

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
						AddPostStudyMaterialClass p=new AddPostStudyMaterialClass(postId,postDate,postFaculty,postSemester,postType,postSubject,fileName);
						AddPostStudyMaterialDao dao=new AddPostStudyMaterialDao();
						if(dao.savePost(p)) {
							for (Part part : request.getParts()) {
								part.write(path);
							}
							request.setAttribute("AddPostNoticeMsg","Study Material was publish successfully !!!. & save to "+path);

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
				else if(postSubject.equals("Engineering Chemistry")) {
					String fileName = postFile.getSubmittedFileName();
					String path=UPLOAD_DIRECTORY+"\\computer\\note\\2nd\\Engineering Chemistry" + File.separator + fileName; //best way
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
							String newpath=UPLOAD_DIRECTORY+"\\computer\\note\\2nd\\Engineering Chemistry" + File.separator + newfileName; //best way
							File newdirectory=new File(newpath);

							if(!newdirectory.exists()) {

								AddPostStudyMaterialClass p=new AddPostStudyMaterialClass(postId,postDate,postFaculty,postSemester,postType,postSubject,newfileName);
								AddPostStudyMaterialDao dao=new AddPostStudyMaterialDao();
								if(dao.savePost(p)) {

									for (Part part : request.getParts()) {
										part.write(newpath);
									}

									request.setAttribute("AddPostNoticeMsg","Study material was publish successfully !!! . Your file name already existed. So we have changed file name to "+newfileName+" & save to "+newpath);

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

						AddPostStudyMaterialClass p=new AddPostStudyMaterialClass(postId,postDate,postFaculty,postSemester,postType,postSubject,fileName);
						AddPostStudyMaterialDao dao=new AddPostStudyMaterialDao();
						if(dao.savePost(p)) {
							for (Part part : request.getParts()) {
								part.write(path);
							}
							request.setAttribute("AddPostNoticeMsg","Study Material was publish successfully !!!. & save to "+path);

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
				else if(postSubject.equals("Thermodynamics")) {
					String fileName = postFile.getSubmittedFileName();
					String path=UPLOAD_DIRECTORY+"\\computer\\note\\2nd\\Thermodynamics" + File.separator + fileName; //best way
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
							String newpath=UPLOAD_DIRECTORY+"\\computer\\note\\2nd\\Thermodynamics" + File.separator + newfileName; //best way
							File newdirectory=new File(newpath);

							if(!newdirectory.exists()) {

								AddPostStudyMaterialClass p=new AddPostStudyMaterialClass(postId,postDate,postFaculty,postSemester,postType,postSubject,newfileName);
								AddPostStudyMaterialDao dao=new AddPostStudyMaterialDao();
								if(dao.savePost(p)) {

									for (Part part : request.getParts()) {
										part.write(newpath);
									}
									request.setAttribute("AddPostNoticeMsg","Study material was publish successfully !!! . Your file name already existed. So we have changed file name to "+newfileName+" & save to "+newpath);

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

						AddPostStudyMaterialClass p=new AddPostStudyMaterialClass(postId,postDate,postFaculty,postSemester,postType,postSubject,fileName);
						AddPostStudyMaterialDao dao=new AddPostStudyMaterialDao();
						if(dao.savePost(p)) {
							for (Part part : request.getParts()) {
								part.write(path);
							}
							request.setAttribute("AddPostNoticeMsg","Study Material was publish successfully !!!. & save to "+path);

							RequestDispatcher requestDispatcher = request.getRequestDispatcher("/admincontrol.jsp");
							requestDispatcher.forward(request, response);
						}
						else {
							request.setAttribute("AddPostNoticeMsg", "Internal error occured.");
							RequestDispatcher dispatcher=request.getRequestDispatcher("/admincontrol.jsp");
							dispatcher.forward(request, response);
						}
					}
				}else if(postSubject.equals("Applied Mechanics")) {
					String fileName = postFile.getSubmittedFileName();
					String path=UPLOAD_DIRECTORY+"\\computer\\note\\2nd\\Applied Mechanics" + File.separator + fileName; //best way
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
							String newpath=UPLOAD_DIRECTORY+"\\computer\\note\\2nd\\Applied Mechanics" + File.separator + newfileName; //best way
							File newdirectory=new File(newpath);
							if(!newdirectory.exists()) {

								AddPostStudyMaterialClass p=new AddPostStudyMaterialClass(postId,postDate,postFaculty,postSemester,postType,postSubject,newfileName);
								AddPostStudyMaterialDao dao=new AddPostStudyMaterialDao();
								if(dao.savePost(p)) {
									for (Part part : request.getParts()) {
										part.write(newpath);
									}
									request.setAttribute("AddPostNoticeMsg","Study material was publish successfully !!! . Your file name already existed. So we have changed file name to "+newfileName+" & save to "+newpath);

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

						AddPostStudyMaterialClass p=new AddPostStudyMaterialClass(postId,postDate,postFaculty,postSemester,postType,postSubject,fileName);
						AddPostStudyMaterialDao dao=new AddPostStudyMaterialDao();
						if(dao.savePost(p)) {
							for (Part part : request.getParts()) {
								part.write(path);
							}
							request.setAttribute("AddPostNoticeMsg","Study Material was publish successfully !!!. & save to "+path);

							RequestDispatcher requestDispatcher = request.getRequestDispatcher("/admincontrol.jsp");
							requestDispatcher.forward(request, response);

						}
						else {
							request.setAttribute("AddPostNoticeMsg", "Internal error occured.");
							RequestDispatcher dispatcher=request.getRequestDispatcher("/admincontrol.jsp");
							dispatcher.forward(request, response);

						}
					}

				}else if(postSubject.equals("Object Oriented Programming")) {
					String fileName = postFile.getSubmittedFileName();
					String path=UPLOAD_DIRECTORY+"\\computer\\note\\2nd\\Object Oriented Programming" + File.separator + fileName; //best way
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
							String newpath=UPLOAD_DIRECTORY+"\\computer\\note\\2nd\\Object Oriented Programming" + File.separator + newfileName; //best way
							File newdirectory=new File(newpath);

							if(!newdirectory.exists()) {

								AddPostStudyMaterialClass p=new AddPostStudyMaterialClass(postId,postDate,postFaculty,postSemester,postType,postSubject,newfileName);
								AddPostStudyMaterialDao dao=new AddPostStudyMaterialDao();
								if(dao.savePost(p)) {

									for (Part part : request.getParts()) {
										part.write(newpath);
									}

									request.setAttribute("AddPostNoticeMsg","Study material was publish successfully !!! . Your file name already existed. So we have changed file name to "+newfileName+" & save to "+newpath);

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

						AddPostStudyMaterialClass p=new AddPostStudyMaterialClass(postId,postDate,postFaculty,postSemester,postType,postSubject,fileName);
						AddPostStudyMaterialDao dao=new AddPostStudyMaterialDao();
						if(dao.savePost(p)) {
							for (Part part : request.getParts()) {
								part.write(path);
							}
							request.setAttribute("AddPostNoticeMsg","Study Material was publish successfully !!!. & save to "+path);

							RequestDispatcher requestDispatcher = request.getRequestDispatcher("/admincontrol.jsp");
							requestDispatcher.forward(request, response);

						}
						else {
							request.setAttribute("AddPostNoticeMsg", "Internal error occured.");
							RequestDispatcher dispatcher=request.getRequestDispatcher("/admincontrol.jsp");
							dispatcher.forward(request, response);

						}
					}

				}else if(postSubject.equals("Discrete Structure")) {
					String fileName = postFile.getSubmittedFileName();
					String path=UPLOAD_DIRECTORY+"\\computer\\note\\2nd\\Discrete Structure" + File.separator + fileName; //best way
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
							String newpath=UPLOAD_DIRECTORY+"\\computer\\note\\2nd\\Discrete Structure" + File.separator + newfileName; //best way
							File newdirectory=new File(newpath);

							if(!newdirectory.exists()) {

								AddPostStudyMaterialClass p=new AddPostStudyMaterialClass(postId,postDate,postFaculty,postSemester,postType,postSubject,newfileName);
								AddPostStudyMaterialDao dao=new AddPostStudyMaterialDao();
								if(dao.savePost(p)) {

									for (Part part : request.getParts()) {
										part.write(newpath);
									}

									request.setAttribute("AddPostNoticeMsg","Study material was publish successfully !!! . Your file name already existed. So we have changed file name to "+newfileName+" & save to "+newpath);

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

						AddPostStudyMaterialClass p=new AddPostStudyMaterialClass(postId,postDate,postFaculty,postSemester,postType,postSubject,fileName);
						AddPostStudyMaterialDao dao=new AddPostStudyMaterialDao();
						if(dao.savePost(p)) {
							for (Part part : request.getParts()) {
								part.write(path);
							}
							request.setAttribute("AddPostNoticeMsg","Study Material was publish successfully !!!. & save to "+path);

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
					request.setAttribute("AddPostNoticeMsg", "Failed to post due to you have not selected any subject.");
					RequestDispatcher dispatcher=request.getRequestDispatcher("/admincontrol.jsp");
					dispatcher.forward(request, response);

				}

			}

			//3rd sem

			else if(postFaculty.equals("Computer Engineering") && postSemester.equals("3rd sem") && postType.equals("Note")) {

				if(postSubject.equals("Engineering Math III")) {
					String fileName = postFile.getSubmittedFileName();
					String path=UPLOAD_DIRECTORY+"\\computer\\note\\3rd\\Engineering Math III" + File.separator + fileName; //best way
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
							String newpath=UPLOAD_DIRECTORY+"\\computer\\note\\3rd\\Engineering Math III" + File.separator + newfileName; //best way
							File newdirectory=new File(newpath);

							if(!newdirectory.exists()) {

								AddPostStudyMaterialClass p=new AddPostStudyMaterialClass(postId,postDate,postFaculty,postSemester,postType,postSubject,newfileName);
								AddPostStudyMaterialDao dao=new AddPostStudyMaterialDao();
								if(dao.savePost(p)) {

									for (Part part : request.getParts()) {
										part.write(newpath);
									}

									request.setAttribute("AddPostNoticeMsg","Study material was publish successfully !!! . Your file name already existed. So we have changed file name to "+newfileName+" & save to "+newpath);

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

						AddPostStudyMaterialClass p=new AddPostStudyMaterialClass(postId,postDate,postFaculty,postSemester,postType,postSubject,fileName);
						AddPostStudyMaterialDao dao=new AddPostStudyMaterialDao();
						if(dao.savePost(p)) {
							for (Part part : request.getParts()) {
								part.write(path);
							}
							request.setAttribute("AddPostNoticeMsg","Study Material was publish successfully !!!. & save to "+path);

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
				else if(postSubject.equals("Data Structure & Algorithm")) {
					String fileName = postFile.getSubmittedFileName();
					String path=UPLOAD_DIRECTORY+"\\computer\\note\\3rd\\Data Structure & Algorithm" + File.separator + fileName; //best way
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
							String newpath=UPLOAD_DIRECTORY+"\\computer\\note\\3rd\\Data Structure & Algorithm" + File.separator + newfileName; //best way
							File newdirectory=new File(newpath);

							if(!newdirectory.exists()) {

								AddPostStudyMaterialClass p=new AddPostStudyMaterialClass(postId,postDate,postFaculty,postSemester,postType,postSubject,newfileName);
								AddPostStudyMaterialDao dao=new AddPostStudyMaterialDao();
								if(dao.savePost(p)) {

									for (Part part : request.getParts()) {
										part.write(newpath);
									}

									request.setAttribute("AddPostNoticeMsg","Study material was publish successfully !!! . Your file name already existed. So we have changed file name to "+newfileName+" & save to "+newpath);

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

						AddPostStudyMaterialClass p=new AddPostStudyMaterialClass(postId,postDate,postFaculty,postSemester,postType,postSubject,fileName);
						AddPostStudyMaterialDao dao=new AddPostStudyMaterialDao();
						if(dao.savePost(p)) {
							for (Part part : request.getParts()) {
								part.write(path);
							}
							request.setAttribute("AddPostNoticeMsg","Study Material was publish successfully !!!. & save to "+path);

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
				else if(postSubject.equals("Theory of Computation")) {
					String fileName = postFile.getSubmittedFileName();
					String path=UPLOAD_DIRECTORY+"\\computer\\note\\3rd\\Theory of Computation" + File.separator + fileName; //best way
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
							String newpath=UPLOAD_DIRECTORY+"\\computer\\note\\3rd\\Theory of Computation" + File.separator + newfileName; //best way
							File newdirectory=new File(newpath);

							if(!newdirectory.exists()) {

								AddPostStudyMaterialClass p=new AddPostStudyMaterialClass(postId,postDate,postFaculty,postSemester,postType,postSubject,newfileName);
								AddPostStudyMaterialDao dao=new AddPostStudyMaterialDao();
								if(dao.savePost(p)) {

									for (Part part : request.getParts()) {
										part.write(newpath);
									}

									request.setAttribute("AddPostNoticeMsg","Study material was publish successfully !!! . Your file name already existed. So we have changed file name to "+newfileName+" & save to "+newpath);

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

						AddPostStudyMaterialClass p=new AddPostStudyMaterialClass(postId,postDate,postFaculty,postSemester,postType,postSubject,fileName);
						AddPostStudyMaterialDao dao=new AddPostStudyMaterialDao();
						if(dao.savePost(p)) {
							for (Part part : request.getParts()) {
								part.write(path);
							}
							request.setAttribute("AddPostNoticeMsg","Study Material was publish successfully !!!. & save to "+path);

							RequestDispatcher requestDispatcher = request.getRequestDispatcher("/admincontrol.jsp");
							requestDispatcher.forward(request, response);

						}
						else {
							request.setAttribute("AddPostNoticeMsg", "Internal error occured.");
							RequestDispatcher dispatcher=request.getRequestDispatcher("/admincontrol.jsp");
							dispatcher.forward(request, response);
						}
					}

				}else if(postSubject.equals("Electrical Circuit Theory")) {
					String fileName = postFile.getSubmittedFileName();
					String path=UPLOAD_DIRECTORY+"\\computer\\note\\3rd\\Electrical Circuit Theory" + File.separator + fileName; //best way
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
							String newpath=UPLOAD_DIRECTORY+"\\computer\\note\\3rd\\Electrical Circuit Theory" + File.separator + newfileName; //best way
							File newdirectory=new File(newpath);

							if(!newdirectory.exists()) {

								AddPostStudyMaterialClass p=new AddPostStudyMaterialClass(postId,postDate,postFaculty,postSemester,postType,postSubject,newfileName);
								AddPostStudyMaterialDao dao=new AddPostStudyMaterialDao();
								if(dao.savePost(p)) {

									for (Part part : request.getParts()) {
										part.write(newpath);
									}

									request.setAttribute("AddPostNoticeMsg","Study material was publish successfully !!! . Your file name already existed. So we have changed file name to "+newfileName+" & save to "+newpath);

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

						AddPostStudyMaterialClass p=new AddPostStudyMaterialClass(postId,postDate,postFaculty,postSemester,postType,postSubject,fileName);
						AddPostStudyMaterialDao dao=new AddPostStudyMaterialDao();
						if(dao.savePost(p)) {
							for (Part part : request.getParts()) {
								part.write(path);
							}
							request.setAttribute("AddPostNoticeMsg","Study Material was publish successfully !!!. & save to "+path);

							RequestDispatcher requestDispatcher = request.getRequestDispatcher("/admincontrol.jsp");
							requestDispatcher.forward(request, response);
						}
						else {
							request.setAttribute("AddPostNoticeMsg", "Internal error occured.");
							RequestDispatcher dispatcher=request.getRequestDispatcher("/admincontrol.jsp");
							dispatcher.forward(request, response);
						}
					}

				}else if(postSubject.equals("Digital Logic")) {
					String fileName = postFile.getSubmittedFileName();
					String path=UPLOAD_DIRECTORY+"\\computer\\note\\3rd\\Digital Logic" + File.separator + fileName; //best way
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
							String newpath=UPLOAD_DIRECTORY+"\\computer\\note\\3rd\\Digital Logic" + File.separator + newfileName; //best way
							File newdirectory=new File(newpath);

							if(!newdirectory.exists()) {

								AddPostStudyMaterialClass p=new AddPostStudyMaterialClass(postId,postDate,postFaculty,postSemester,postType,postSubject,newfileName);
								AddPostStudyMaterialDao dao=new AddPostStudyMaterialDao();
								if(dao.savePost(p)) {

									for (Part part : request.getParts()) {
										part.write(newpath);
									}

									request.setAttribute("AddPostNoticeMsg","Study material was publish successfully !!! . Your file name already existed. So we have changed file name to "+newfileName+" & save to "+newpath);

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
						AddPostStudyMaterialClass p=new AddPostStudyMaterialClass(postId,postDate,postFaculty,postSemester,postType,postSubject,fileName);
						AddPostStudyMaterialDao dao=new AddPostStudyMaterialDao();
						if(dao.savePost(p)) {
							for (Part part : request.getParts()) {
								part.write(path);
							}
							request.setAttribute("AddPostNoticeMsg","Study Material was publish successfully !!!. & save to "+path);

							RequestDispatcher requestDispatcher = request.getRequestDispatcher("/admincontrol.jsp");
							requestDispatcher.forward(request, response);
						}
						else {
							request.setAttribute("AddPostNoticeMsg", "Internal error occured.");
							RequestDispatcher dispatcher=request.getRequestDispatcher("/admincontrol.jsp");
							dispatcher.forward(request, response);

						}
					}

				}else if(postSubject.equals("Electromagnetics")) {
					String fileName = postFile.getSubmittedFileName();
					String path=UPLOAD_DIRECTORY+"\\computer\\note\\3rd\\Electromagnetics" + File.separator + fileName; //best way
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
							String newpath=UPLOAD_DIRECTORY+"\\computer\\note\\3rd\\Electromagnetics" + File.separator + newfileName; //best way
							File newdirectory=new File(newpath);

							if(!newdirectory.exists()) {

								AddPostStudyMaterialClass p=new AddPostStudyMaterialClass(postId,postDate,postFaculty,postSemester,postType,postSubject,newfileName);
								AddPostStudyMaterialDao dao=new AddPostStudyMaterialDao();
								if(dao.savePost(p)) {

									for (Part part : request.getParts()) {
										part.write(newpath);
									}

									request.setAttribute("AddPostNoticeMsg","Study material was publish successfully !!! . Your file name already existed. So we have changed file name to "+newfileName+" & save to "+newpath);

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

						AddPostStudyMaterialClass p=new AddPostStudyMaterialClass(postId,postDate,postFaculty,postSemester,postType,postSubject,fileName);
						AddPostStudyMaterialDao dao=new AddPostStudyMaterialDao();
						if(dao.savePost(p)) {




							for (Part part : request.getParts()) {
								part.write(path);
							}
							request.setAttribute("AddPostNoticeMsg","Study Material was publish successfully !!!. & save to "+path);

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
					request.setAttribute("AddPostNoticeMsg", "Failed to post due to you have not selected any subject.");
					RequestDispatcher dispatcher=request.getRequestDispatcher("/admincontrol.jsp");
					dispatcher.forward(request, response);

				}
			}

			//4th

			else if(postFaculty.equals("Computer Engineering") && postSemester.equals("4th sem") && postType.equals("Note")) {

				if(postSubject.equals("Applied Mathematics")) {
					String fileName = postFile.getSubmittedFileName();
					String path=UPLOAD_DIRECTORY+"\\computer\\note\\4th\\Applied Mathematics" + File.separator + fileName; //best way
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
							String newpath=UPLOAD_DIRECTORY+"\\computer\\note\\4th\\Applied Mathematics" + File.separator + newfileName; //best way
							File newdirectory=new File(newpath);

							if(!newdirectory.exists()) {

								AddPostStudyMaterialClass p=new AddPostStudyMaterialClass(postId,postDate,postFaculty,postSemester,postType,postSubject,newfileName);
								AddPostStudyMaterialDao dao=new AddPostStudyMaterialDao();
								if(dao.savePost(p)) {

									for (Part part : request.getParts()) {
										part.write(newpath);
									}

									request.setAttribute("AddPostNoticeMsg","Study material was publish successfully !!! . Your file name already existed. So we have changed file name to "+newfileName+" & save to "+newpath);

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

						AddPostStudyMaterialClass p=new AddPostStudyMaterialClass(postId,postDate,postFaculty,postSemester,postType,postSubject,fileName);
						AddPostStudyMaterialDao dao=new AddPostStudyMaterialDao();
						if(dao.savePost(p)) {




							for (Part part : request.getParts()) {
								part.write(path);
							}
							request.setAttribute("AddPostNoticeMsg","Study Material was publish successfully !!!. & save to "+path);

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
				else if(postSubject.equals("Microprocessor")) {
					String fileName = postFile.getSubmittedFileName();
					String path=UPLOAD_DIRECTORY+"\\computer\\note\\4th\\Microprocessor" + File.separator + fileName; //best way
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
							String newpath=UPLOAD_DIRECTORY+"\\computer\\note\\4th\\Microprocessor" + File.separator + newfileName; //best way
							File newdirectory=new File(newpath);

							if(!newdirectory.exists()) {

								AddPostStudyMaterialClass p=new AddPostStudyMaterialClass(postId,postDate,postFaculty,postSemester,postType,postSubject,newfileName);
								AddPostStudyMaterialDao dao=new AddPostStudyMaterialDao();
								if(dao.savePost(p)) {

									for (Part part : request.getParts()) {
										part.write(newpath);
									}

									request.setAttribute("AddPostNoticeMsg","Study material was publish successfully !!! . Your file name already existed. So we have changed file name to "+newfileName+" & save to "+newpath);

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

						AddPostStudyMaterialClass p=new AddPostStudyMaterialClass(postId,postDate,postFaculty,postSemester,postType,postSubject,fileName);
						AddPostStudyMaterialDao dao=new AddPostStudyMaterialDao();
						if(dao.savePost(p)) {




							for (Part part : request.getParts()) {
								part.write(path);
							}
							request.setAttribute("AddPostNoticeMsg","Study Material was publish successfully !!!. & save to "+path);

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
				else if(postSubject.equals("Algorithmic Mathematics")) {
					String fileName = postFile.getSubmittedFileName();
					String path=UPLOAD_DIRECTORY+"\\computer\\note\\4th\\Algorithmic Mathematics" + File.separator + fileName; //best way
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
							String newpath=UPLOAD_DIRECTORY+"\\computer\\note\\4th\\Algorithmic Mathematics" + File.separator + newfileName; //best way
							File newdirectory=new File(newpath);

							if(!newdirectory.exists()) {

								AddPostStudyMaterialClass p=new AddPostStudyMaterialClass(postId,postDate,postFaculty,postSemester,postType,postSubject,newfileName);
								AddPostStudyMaterialDao dao=new AddPostStudyMaterialDao();
								if(dao.savePost(p)) {

									for (Part part : request.getParts()) {
										part.write(newpath);
									}

									request.setAttribute("AddPostNoticeMsg","Study material was publish successfully !!! . Your file name already existed. So we have changed file name to "+newfileName+" & save to "+newpath);

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

						AddPostStudyMaterialClass p=new AddPostStudyMaterialClass(postId,postDate,postFaculty,postSemester,postType,postSubject,fileName);
						AddPostStudyMaterialDao dao=new AddPostStudyMaterialDao();
						if(dao.savePost(p)) {




							for (Part part : request.getParts()) {
								part.write(path);
							}
							request.setAttribute("AddPostNoticeMsg","Study Material was publish successfully !!!. & save to "+path);

							RequestDispatcher requestDispatcher = request.getRequestDispatcher("/admincontrol.jsp");
							requestDispatcher.forward(request, response);


						}
						else {
							request.setAttribute("AddPostNoticeMsg", "Internal error occured.");
							RequestDispatcher dispatcher=request.getRequestDispatcher("/admincontrol.jsp");
							dispatcher.forward(request, response);

						}
					}


				}else if(postSubject.equals("Electrical Machine")) {
					String fileName = postFile.getSubmittedFileName();
					String path=UPLOAD_DIRECTORY+"\\computer\\note\\4th\\Electrical Machine" + File.separator + fileName; //best way
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
							String newpath=UPLOAD_DIRECTORY+"\\computer\\note\\4th\\Electrical Machine" + File.separator + newfileName; //best way
							File newdirectory=new File(newpath);

							if(!newdirectory.exists()) {

								AddPostStudyMaterialClass p=new AddPostStudyMaterialClass(postId,postDate,postFaculty,postSemester,postType,postSubject,newfileName);
								AddPostStudyMaterialDao dao=new AddPostStudyMaterialDao();
								if(dao.savePost(p)) {

									for (Part part : request.getParts()) {
										part.write(newpath);
									}

									request.setAttribute("AddPostNoticeMsg","Study material was publish successfully !!! . Your file name already existed. So we have changed file name to "+newfileName+" & save to "+newpath);

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

						AddPostStudyMaterialClass p=new AddPostStudyMaterialClass(postId,postDate,postFaculty,postSemester,postType,postSubject,fileName);
						AddPostStudyMaterialDao dao=new AddPostStudyMaterialDao();
						if(dao.savePost(p)) {




							for (Part part : request.getParts()) {
								part.write(path);
							}
							request.setAttribute("AddPostNoticeMsg","Study Material was publish successfully !!!. & save to "+path);

							RequestDispatcher requestDispatcher = request.getRequestDispatcher("/admincontrol.jsp");
							requestDispatcher.forward(request, response);


						}
						else {
							request.setAttribute("AddPostNoticeMsg", "Internal error occured.");
							RequestDispatcher dispatcher=request.getRequestDispatcher("/admincontrol.jsp");
							dispatcher.forward(request, response);

						}
					}

				}else if(postSubject.equals("Electronic Device & Circuit")) {
					String fileName = postFile.getSubmittedFileName();
					String path=UPLOAD_DIRECTORY+"\\computer\\note\\4th\\Electronic Device & Circuit" + File.separator + fileName; //best way
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
							String newpath=UPLOAD_DIRECTORY+"\\computer\\note\\4th\\Electronic Device & Circuit" + File.separator + newfileName; //best way
							File newdirectory=new File(newpath);

							if(!newdirectory.exists()) {

								AddPostStudyMaterialClass p=new AddPostStudyMaterialClass(postId,postDate,postFaculty,postSemester,postType,postSubject,newfileName);
								AddPostStudyMaterialDao dao=new AddPostStudyMaterialDao();
								if(dao.savePost(p)) {

									for (Part part : request.getParts()) {
										part.write(newpath);
									}

									request.setAttribute("AddPostNoticeMsg","Study material was publish successfully !!! . Your file name already existed. So we have changed file name to "+newfileName+" & save to "+newpath);

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

						AddPostStudyMaterialClass p=new AddPostStudyMaterialClass(postId,postDate,postFaculty,postSemester,postType,postSubject,fileName);
						AddPostStudyMaterialDao dao=new AddPostStudyMaterialDao();
						if(dao.savePost(p)) {




							for (Part part : request.getParts()) {
								part.write(path);
							}
							request.setAttribute("AddPostNoticeMsg","Study Material was publish successfully !!!. & save to "+path);

							RequestDispatcher requestDispatcher = request.getRequestDispatcher("/admincontrol.jsp");
							requestDispatcher.forward(request, response);


						}
						else {
							request.setAttribute("AddPostNoticeMsg", "Internal error occured.");
							RequestDispatcher dispatcher=request.getRequestDispatcher("/admincontrol.jsp");
							dispatcher.forward(request, response);

						}
					}

				}else if(postSubject.equals("Communication English")) {
					String fileName = postFile.getSubmittedFileName();
					String path=UPLOAD_DIRECTORY+"\\computer\\note\\4th\\Communication English" + File.separator + fileName; //best way
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
							String newpath=UPLOAD_DIRECTORY+"\\computer\\note\\4th\\Communication English" + File.separator + newfileName; //best way
							File newdirectory=new File(newpath);

							if(!newdirectory.exists()) {

								AddPostStudyMaterialClass p=new AddPostStudyMaterialClass(postId,postDate,postFaculty,postSemester,postType,postSubject,newfileName);
								AddPostStudyMaterialDao dao=new AddPostStudyMaterialDao();
								if(dao.savePost(p)) {

									for (Part part : request.getParts()) {
										part.write(newpath);
									}

									request.setAttribute("AddPostNoticeMsg","Study material was publish successfully !!! . Your file name already existed. So we have changed file name to "+newfileName+" & save to "+newpath);

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

						AddPostStudyMaterialClass p=new AddPostStudyMaterialClass(postId,postDate,postFaculty,postSemester,postType,postSubject,fileName);
						AddPostStudyMaterialDao dao=new AddPostStudyMaterialDao();
						if(dao.savePost(p)) {




							for (Part part : request.getParts()) {
								part.write(path);
							}
							request.setAttribute("AddPostNoticeMsg","Study Material was publish successfully !!!. & save to "+path);

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
					request.setAttribute("AddPostNoticeMsg", "Failed to post due to you have not selected any subject.");
					RequestDispatcher dispatcher=request.getRequestDispatcher("/admincontrol.jsp");
					dispatcher.forward(request, response);

				}
			}


			//5th sem


			else if(postFaculty.equals("Computer Engineering") && postSemester.equals("5th sem") && postType.equals("Note")) {

				if(postSubject.equals("Probability & Statistic")) {
					String fileName = postFile.getSubmittedFileName();
					String path=UPLOAD_DIRECTORY+"\\computer\\note\\5th\\Probability & Statistic" + File.separator + fileName; //best way
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
							String newpath=UPLOAD_DIRECTORY+"\\computer\\note\\5th\\Probability & Statistic" + File.separator + newfileName; //best way
							File newdirectory=new File(newpath);

							if(!newdirectory.exists()) {

								AddPostStudyMaterialClass p=new AddPostStudyMaterialClass(postId,postDate,postFaculty,postSemester,postType,postSubject,newfileName);
								AddPostStudyMaterialDao dao=new AddPostStudyMaterialDao();
								if(dao.savePost(p)) {

									for (Part part : request.getParts()) {
										part.write(newpath);
									}

									request.setAttribute("AddPostNoticeMsg","Study material was publish successfully !!! . Your file name already existed. So we have changed file name to "+newfileName+" & save to "+newpath);

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

						AddPostStudyMaterialClass p=new AddPostStudyMaterialClass(postId,postDate,postFaculty,postSemester,postType,postSubject,fileName);
						AddPostStudyMaterialDao dao=new AddPostStudyMaterialDao();
						if(dao.savePost(p)) {




							for (Part part : request.getParts()) {
								part.write(path);
							}
							request.setAttribute("AddPostNoticeMsg","Study Material was publish successfully !!!. & save to "+path);

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
				else if(postSubject.equals("Instrumentation")) {
					String fileName = postFile.getSubmittedFileName();
					String path=UPLOAD_DIRECTORY+"\\computer\\note\\5th\\Instrumentation" + File.separator + fileName; //best way
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
							String newpath=UPLOAD_DIRECTORY+"\\computer\\note\\5th\\Instrumentation" + File.separator + newfileName; //best way
							File newdirectory=new File(newpath);

							if(!newdirectory.exists()) {

								AddPostStudyMaterialClass p=new AddPostStudyMaterialClass(postId,postDate,postFaculty,postSemester,postType,postSubject,newfileName);
								AddPostStudyMaterialDao dao=new AddPostStudyMaterialDao();
								if(dao.savePost(p)) {

									for (Part part : request.getParts()) {
										part.write(newpath);
									}

									request.setAttribute("AddPostNoticeMsg","Study material was publish successfully !!! . Your file name already existed. So we have changed file name to "+newfileName+" & save to "+newpath);

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

						AddPostStudyMaterialClass p=new AddPostStudyMaterialClass(postId,postDate,postFaculty,postSemester,postType,postSubject,fileName);
						AddPostStudyMaterialDao dao=new AddPostStudyMaterialDao();
						if(dao.savePost(p)) {




							for (Part part : request.getParts()) {
								part.write(path);
							}
							request.setAttribute("AddPostNoticeMsg","Study Material was publish successfully !!!. & save to "+path);

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
				else if(postSubject.equals("Computer Graphics")) {
					String fileName = postFile.getSubmittedFileName();
					String path=UPLOAD_DIRECTORY+"\\computer\\note\\5th\\Computer Graphics" + File.separator + fileName; //best way
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
							String newpath=UPLOAD_DIRECTORY+"\\computer\\note\\5th\\Computer Graphics" + File.separator + newfileName; //best way
							File newdirectory=new File(newpath);

							if(!newdirectory.exists()) {

								AddPostStudyMaterialClass p=new AddPostStudyMaterialClass(postId,postDate,postFaculty,postSemester,postType,postSubject,newfileName);
								AddPostStudyMaterialDao dao=new AddPostStudyMaterialDao();
								if(dao.savePost(p)) {

									for (Part part : request.getParts()) {
										part.write(newpath);
									}

									request.setAttribute("AddPostNoticeMsg","Study material was publish successfully !!! . Your file name already existed. So we have changed file name to "+newfileName+" & save to "+newpath);

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

						AddPostStudyMaterialClass p=new AddPostStudyMaterialClass(postId,postDate,postFaculty,postSemester,postType,postSubject,fileName);
						AddPostStudyMaterialDao dao=new AddPostStudyMaterialDao();
						if(dao.savePost(p)) {




							for (Part part : request.getParts()) {
								part.write(path);
							}
							request.setAttribute("AddPostNoticeMsg","Study Material was publish successfully !!!. & save to "+path);

							RequestDispatcher requestDispatcher = request.getRequestDispatcher("/admincontrol.jsp");
							requestDispatcher.forward(request, response);


						}
						else {
							request.setAttribute("AddPostNoticeMsg", "Internal error occured.");
							RequestDispatcher dispatcher=request.getRequestDispatcher("/admincontrol.jsp");
							dispatcher.forward(request, response);

						}
					}


				}else if(postSubject.equals("Object Oriented Software Engineering")) {
					String fileName = postFile.getSubmittedFileName();
					String path=UPLOAD_DIRECTORY+"\\computer\\note\\5th\\Object Oriented Software Engineering" + File.separator + fileName; //best way
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
							String newpath=UPLOAD_DIRECTORY+"\\computer\\note\\5th\\Object Oriented Software Engineering" + File.separator + newfileName; //best way
							File newdirectory=new File(newpath);

							if(!newdirectory.exists()) {

								AddPostStudyMaterialClass p=new AddPostStudyMaterialClass(postId,postDate,postFaculty,postSemester,postType,postSubject,newfileName);
								AddPostStudyMaterialDao dao=new AddPostStudyMaterialDao();
								if(dao.savePost(p)) {

									for (Part part : request.getParts()) {
										part.write(newpath);
									}

									request.setAttribute("AddPostNoticeMsg","Study material was publish successfully !!! . Your file name already existed. So we have changed file name to "+newfileName+" & save to "+newpath);

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

						AddPostStudyMaterialClass p=new AddPostStudyMaterialClass(postId,postDate,postFaculty,postSemester,postType,postSubject,fileName);
						AddPostStudyMaterialDao dao=new AddPostStudyMaterialDao();
						if(dao.savePost(p)) {




							for (Part part : request.getParts()) {
								part.write(path);
							}
							request.setAttribute("AddPostNoticeMsg","Study Material was publish successfully !!!. & save to "+path);

							RequestDispatcher requestDispatcher = request.getRequestDispatcher("/admincontrol.jsp");
							requestDispatcher.forward(request, response);


						}
						else {
							request.setAttribute("AddPostNoticeMsg", "Internal error occured.");
							RequestDispatcher dispatcher=request.getRequestDispatcher("/admincontrol.jsp");
							dispatcher.forward(request, response);

						}
					}

				}else if(postSubject.equals("Computer Architecture & Design")) {
					String fileName = postFile.getSubmittedFileName();
					String path=UPLOAD_DIRECTORY+"\\computer\\note\\5th\\Computer Architecture & Design" + File.separator + fileName; //best way
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
							String newpath=UPLOAD_DIRECTORY+"\\computer\\note\\5th\\Computer Architecture & Design" + File.separator + newfileName; //best way
							File newdirectory=new File(newpath);

							if(!newdirectory.exists()) {

								AddPostStudyMaterialClass p=new AddPostStudyMaterialClass(postId,postDate,postFaculty,postSemester,postType,postSubject,newfileName);
								AddPostStudyMaterialDao dao=new AddPostStudyMaterialDao();
								if(dao.savePost(p)) {

									for (Part part : request.getParts()) {
										part.write(newpath);
									}

									request.setAttribute("AddPostNoticeMsg","Study material was publish successfully !!! . Your file name already existed. So we have changed file name to "+newfileName+" & save to "+newpath);

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

						AddPostStudyMaterialClass p=new AddPostStudyMaterialClass(postId,postDate,postFaculty,postSemester,postType,postSubject,fileName);
						AddPostStudyMaterialDao dao=new AddPostStudyMaterialDao();
						if(dao.savePost(p)) {




							for (Part part : request.getParts()) {
								part.write(path);
							}
							request.setAttribute("AddPostNoticeMsg","Study Material was publish successfully !!!. & save to "+path);

							RequestDispatcher requestDispatcher = request.getRequestDispatcher("/admincontrol.jsp");
							requestDispatcher.forward(request, response);


						}
						else {
							request.setAttribute("AddPostNoticeMsg", "Internal error occured.");
							RequestDispatcher dispatcher=request.getRequestDispatcher("/admincontrol.jsp");
							dispatcher.forward(request, response);

						}
					}

				}else if(postSubject.equals("Operating System")) {
					String fileName = postFile.getSubmittedFileName();
					String path=UPLOAD_DIRECTORY+"\\computer\\note\\5th\\Operating System" + File.separator + fileName; //best way
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
							String newpath=UPLOAD_DIRECTORY+"\\computer\\note\\5th\\Operating System" + File.separator + newfileName; //best way
							File newdirectory=new File(newpath);

							if(!newdirectory.exists()) {

								AddPostStudyMaterialClass p=new AddPostStudyMaterialClass(postId,postDate,postFaculty,postSemester,postType,postSubject,newfileName);
								AddPostStudyMaterialDao dao=new AddPostStudyMaterialDao();
								if(dao.savePost(p)) {

									for (Part part : request.getParts()) {
										part.write(newpath);
									}

									request.setAttribute("AddPostNoticeMsg","Study material was publish successfully !!! . Your file name already existed. So we have changed file name to "+newfileName+" & save to "+newpath);

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

						AddPostStudyMaterialClass p=new AddPostStudyMaterialClass(postId,postDate,postFaculty,postSemester,postType,postSubject,fileName);
						AddPostStudyMaterialDao dao=new AddPostStudyMaterialDao();
						if(dao.savePost(p)) {




							for (Part part : request.getParts()) {
								part.write(path);
							}
							request.setAttribute("AddPostNoticeMsg","Study Material was publish successfully !!!. & save to "+path);

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
					request.setAttribute("AddPostNoticeMsg", "Failed to post due to you have not selected any subject.");
					RequestDispatcher dispatcher=request.getRequestDispatcher("/admincontrol.jsp");
					dispatcher.forward(request, response);

				}
			}


			//6th sem


			else if(postFaculty.equals("Computer Engineering") && postSemester.equals("6th sem") && postType.equals("Note")) {

				if(postSubject.equals("Project & Organization Management")) {
					String fileName = postFile.getSubmittedFileName();
					String path=UPLOAD_DIRECTORY+"\\computer\\note\\6th\\Project & Organization Management" + File.separator + fileName; //best way
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
							String newpath=UPLOAD_DIRECTORY+"\\computer\\note\\6th\\Project & Organization Management" + File.separator + newfileName; //best way
							File newdirectory=new File(newpath);

							if(!newdirectory.exists()) {

								AddPostStudyMaterialClass p=new AddPostStudyMaterialClass(postId,postDate,postFaculty,postSemester,postType,postSubject,newfileName);
								AddPostStudyMaterialDao dao=new AddPostStudyMaterialDao();
								if(dao.savePost(p)) {

									for (Part part : request.getParts()) {
										part.write(newpath);
									}

									request.setAttribute("AddPostNoticeMsg","Study material was publish successfully !!! . Your file name already existed. So we have changed file name to "+newfileName+" & save to "+newpath);

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

						AddPostStudyMaterialClass p=new AddPostStudyMaterialClass(postId,postDate,postFaculty,postSemester,postType,postSubject,fileName);
						AddPostStudyMaterialDao dao=new AddPostStudyMaterialDao();
						if(dao.savePost(p)) {




							for (Part part : request.getParts()) {
								part.write(path);
							}
							request.setAttribute("AddPostNoticeMsg","Study Material was publish successfully !!!. & save to "+path);

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
				else if(postSubject.equals("Research Methodology")) {
					String fileName = postFile.getSubmittedFileName();
					String path=UPLOAD_DIRECTORY+"\\computer\\note\\6th\\Research Methodology" + File.separator + fileName; //best way
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
							String newpath=UPLOAD_DIRECTORY+"\\computer\\note\\6th\\Research Methodology" + File.separator + newfileName; //best way
							File newdirectory=new File(newpath);

							if(!newdirectory.exists()) {

								AddPostStudyMaterialClass p=new AddPostStudyMaterialClass(postId,postDate,postFaculty,postSemester,postType,postSubject,newfileName);
								AddPostStudyMaterialDao dao=new AddPostStudyMaterialDao();
								if(dao.savePost(p)) {

									for (Part part : request.getParts()) {
										part.write(newpath);
									}

									request.setAttribute("AddPostNoticeMsg","Study material was publish successfully !!! . Your file name already existed. So we have changed file name to "+newfileName+" & save to "+newpath);

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

						AddPostStudyMaterialClass p=new AddPostStudyMaterialClass(postId,postDate,postFaculty,postSemester,postType,postSubject,fileName);
						AddPostStudyMaterialDao dao=new AddPostStudyMaterialDao();
						if(dao.savePost(p)) {




							for (Part part : request.getParts()) {
								part.write(path);
							}
							request.setAttribute("AddPostNoticeMsg","Study Material was publish successfully !!!. & save to "+path);

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
				else if(postSubject.equals("Artificial Intelligence")) {
					String fileName = postFile.getSubmittedFileName();
					String path=UPLOAD_DIRECTORY+"\\computer\\note\\6th\\Artificial Intelligence" + File.separator + fileName; //best way
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
							String newpath=UPLOAD_DIRECTORY+"\\computer\\note\\6th\\Artificial Intelligence" + File.separator + newfileName; //best way
							File newdirectory=new File(newpath);

							if(!newdirectory.exists()) {

								AddPostStudyMaterialClass p=new AddPostStudyMaterialClass(postId,postDate,postFaculty,postSemester,postType,postSubject,newfileName);
								AddPostStudyMaterialDao dao=new AddPostStudyMaterialDao();
								if(dao.savePost(p)) {

									for (Part part : request.getParts()) {
										part.write(newpath);
									}

									request.setAttribute("AddPostNoticeMsg","Study material was publish successfully !!! . Your file name already existed. So we have changed file name to "+newfileName+" & save to "+newpath);

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

						AddPostStudyMaterialClass p=new AddPostStudyMaterialClass(postId,postDate,postFaculty,postSemester,postType,postSubject,fileName);
						AddPostStudyMaterialDao dao=new AddPostStudyMaterialDao();
						if(dao.savePost(p)) {




							for (Part part : request.getParts()) {
								part.write(path);
							}
							request.setAttribute("AddPostNoticeMsg","Study Material was publish successfully !!!. & save to "+path);

							RequestDispatcher requestDispatcher = request.getRequestDispatcher("/admincontrol.jsp");
							requestDispatcher.forward(request, response);


						}
						else {
							request.setAttribute("AddPostNoticeMsg", "Internal error occured.");
							RequestDispatcher dispatcher=request.getRequestDispatcher("/admincontrol.jsp");
							dispatcher.forward(request, response);

						}
					}


				}else if(postSubject.equals("Database Management System")) {
					String fileName = postFile.getSubmittedFileName();
					String path=UPLOAD_DIRECTORY+"\\computer\\note\\6th\\Database Management System" + File.separator + fileName; //best way
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
							String newpath=UPLOAD_DIRECTORY+"\\computer\\note\\6th\\Database Management System" + File.separator + newfileName; //best way
							File newdirectory=new File(newpath);

							if(!newdirectory.exists()) {

								AddPostStudyMaterialClass p=new AddPostStudyMaterialClass(postId,postDate,postFaculty,postSemester,postType,postSubject,newfileName);
								AddPostStudyMaterialDao dao=new AddPostStudyMaterialDao();
								if(dao.savePost(p)) {

									for (Part part : request.getParts()) {
										part.write(newpath);
									}

									request.setAttribute("AddPostNoticeMsg","Study material was publish successfully !!! . Your file name already existed. So we have changed file name to "+newfileName+" & save to "+newpath);

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

						AddPostStudyMaterialClass p=new AddPostStudyMaterialClass(postId,postDate,postFaculty,postSemester,postType,postSubject,fileName);
						AddPostStudyMaterialDao dao=new AddPostStudyMaterialDao();
						if(dao.savePost(p)) {




							for (Part part : request.getParts()) {
								part.write(path);
							}
							request.setAttribute("AddPostNoticeMsg","Study Material was publish successfully !!!. & save to "+path);

							RequestDispatcher requestDispatcher = request.getRequestDispatcher("/admincontrol.jsp");
							requestDispatcher.forward(request, response);


						}
						else {
							request.setAttribute("AddPostNoticeMsg", "Internal error occured.");
							RequestDispatcher dispatcher=request.getRequestDispatcher("/admincontrol.jsp");
							dispatcher.forward(request, response);

						}
					}

				}else if(postSubject.equals("Communication System")) {
					String fileName = postFile.getSubmittedFileName();
					String path=UPLOAD_DIRECTORY+"\\computer\\note\\6th\\Communication System" + File.separator + fileName; //best way
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
							String newpath=UPLOAD_DIRECTORY+"\\computer\\note\\6th\\Communication System" + File.separator + newfileName; //best way
							File newdirectory=new File(newpath);

							if(!newdirectory.exists()) {

								AddPostStudyMaterialClass p=new AddPostStudyMaterialClass(postId,postDate,postFaculty,postSemester,postType,postSubject,newfileName);
								AddPostStudyMaterialDao dao=new AddPostStudyMaterialDao();
								if(dao.savePost(p)) {

									for (Part part : request.getParts()) {
										part.write(newpath);
									}

									request.setAttribute("AddPostNoticeMsg","Study material was publish successfully !!! . Your file name already existed. So we have changed file name to "+newfileName+" & save to "+newpath);

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

						AddPostStudyMaterialClass p=new AddPostStudyMaterialClass(postId,postDate,postFaculty,postSemester,postType,postSubject,fileName);
						AddPostStudyMaterialDao dao=new AddPostStudyMaterialDao();
						if(dao.savePost(p)) {




							for (Part part : request.getParts()) {
								part.write(path);
							}
							request.setAttribute("AddPostNoticeMsg","Study Material was publish successfully !!!. & save to "+path);

							RequestDispatcher requestDispatcher = request.getRequestDispatcher("/admincontrol.jsp");
							requestDispatcher.forward(request, response);


						}
						else {
							request.setAttribute("AddPostNoticeMsg", "Internal error occured.");
							RequestDispatcher dispatcher=request.getRequestDispatcher("/admincontrol.jsp");
							dispatcher.forward(request, response);

						}
					}

				}else if(postSubject.equals("Engineering Economics")) {
					String fileName = postFile.getSubmittedFileName();
					String path=UPLOAD_DIRECTORY+"\\computer\\note\\6th\\Engineering Economics" + File.separator + fileName; //best way
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
							String newpath=UPLOAD_DIRECTORY+"\\computer\\note\\6th\\Engineering Economics" + File.separator + newfileName; //best way
							File newdirectory=new File(newpath);

							if(!newdirectory.exists()) {

								AddPostStudyMaterialClass p=new AddPostStudyMaterialClass(postId,postDate,postFaculty,postSemester,postType,postSubject,newfileName);
								AddPostStudyMaterialDao dao=new AddPostStudyMaterialDao();
								if(dao.savePost(p)) {

									for (Part part : request.getParts()) {
										part.write(newpath);
									}

									request.setAttribute("AddPostNoticeMsg","Study material was publish successfully !!! . Your file name already existed. So we have changed file name to "+newfileName+" & save to "+newpath);

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

						AddPostStudyMaterialClass p=new AddPostStudyMaterialClass(postId,postDate,postFaculty,postSemester,postType,postSubject,fileName);
						AddPostStudyMaterialDao dao=new AddPostStudyMaterialDao();
						if(dao.savePost(p)) {




							for (Part part : request.getParts()) {
								part.write(path);
							}
							request.setAttribute("AddPostNoticeMsg","Study Material was publish successfully !!!. & save to "+path);

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

				else if(postSubject.equals("Minor Project")) {
					String fileName = postFile.getSubmittedFileName();
					String path=UPLOAD_DIRECTORY+"\\computer\\note\\6th\\Minor Project" + File.separator + fileName; //best way
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
							String newpath=UPLOAD_DIRECTORY+"\\computer\\note\\6th\\Minor Project" + File.separator + newfileName; //best way
							File newdirectory=new File(newpath);

							if(!newdirectory.exists()) {

								AddPostStudyMaterialClass p=new AddPostStudyMaterialClass(postId,postDate,postFaculty,postSemester,postType,postSubject,newfileName);
								AddPostStudyMaterialDao dao=new AddPostStudyMaterialDao();
								if(dao.savePost(p)) {

									for (Part part : request.getParts()) {
										part.write(newpath);
									}

									request.setAttribute("AddPostNoticeMsg","Study material was publish successfully !!! . Your file name already existed. So we have changed file name to "+newfileName+" & save to "+newpath);

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

						AddPostStudyMaterialClass p=new AddPostStudyMaterialClass(postId,postDate,postFaculty,postSemester,postType,postSubject,fileName);
						AddPostStudyMaterialDao dao=new AddPostStudyMaterialDao();
						if(dao.savePost(p)) {




							for (Part part : request.getParts()) {
								part.write(path);
							}
							request.setAttribute("AddPostNoticeMsg","Study Material was publish successfully !!!. & save to "+path);

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
					request.setAttribute("AddPostNoticeMsg", "Failed to post due to you have not selected any subject.");
					RequestDispatcher dispatcher=request.getRequestDispatcher("/admincontrol.jsp");
					dispatcher.forward(request, response);

				}
			}

			//7th sem

			else if(postFaculty.equals("Computer Engineering") && postSemester.equals("7th sem") && postType.equals("Note")) {

				if(postSubject.equals("Computer Networks")) {
					String fileName = postFile.getSubmittedFileName();
					String path=UPLOAD_DIRECTORY+"\\computer\\note\\7th\\Computer Networks" + File.separator + fileName; //best way
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
							String newpath=UPLOAD_DIRECTORY+"\\computer\\note\\7th\\Computer Networks" + File.separator + newfileName; //best way
							File newdirectory=new File(newpath);

							if(!newdirectory.exists()) {

								AddPostStudyMaterialClass p=new AddPostStudyMaterialClass(postId,postDate,postFaculty,postSemester,postType,postSubject,newfileName);
								AddPostStudyMaterialDao dao=new AddPostStudyMaterialDao();
								if(dao.savePost(p)) {

									for (Part part : request.getParts()) {
										part.write(newpath);
									}

									request.setAttribute("AddPostNoticeMsg","Study material was publish successfully !!! . Your file name already existed. So we have changed file name to "+newfileName+" & save to "+newpath);

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

						AddPostStudyMaterialClass p=new AddPostStudyMaterialClass(postId,postDate,postFaculty,postSemester,postType,postSubject,fileName);
						AddPostStudyMaterialDao dao=new AddPostStudyMaterialDao();
						if(dao.savePost(p)) {




							for (Part part : request.getParts()) {
								part.write(path);
							}
							request.setAttribute("AddPostNoticeMsg","Study Material was publish successfully !!!. & save to "+path);

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
				else if(postSubject.equals("Distributed Computing")) {
					String fileName = postFile.getSubmittedFileName();
					String path=UPLOAD_DIRECTORY+"\\computer\\note\\7th\\Distributed Computing" + File.separator + fileName; //best way
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
							String newpath=UPLOAD_DIRECTORY+"\\computer\\note\\7th\\Distributed Computing" + File.separator + newfileName; //best way
							File newdirectory=new File(newpath);

							if(!newdirectory.exists()) {

								AddPostStudyMaterialClass p=new AddPostStudyMaterialClass(postId,postDate,postFaculty,postSemester,postType,postSubject,newfileName);
								AddPostStudyMaterialDao dao=new AddPostStudyMaterialDao();
								if(dao.savePost(p)) {

									for (Part part : request.getParts()) {
										part.write(newpath);
									}

									request.setAttribute("AddPostNoticeMsg","Study material was publish successfully !!! . Your file name already existed. So we have changed file name to "+newfileName+" & save to "+newpath);

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

						AddPostStudyMaterialClass p=new AddPostStudyMaterialClass(postId,postDate,postFaculty,postSemester,postType,postSubject,fileName);
						AddPostStudyMaterialDao dao=new AddPostStudyMaterialDao();
						if(dao.savePost(p)) {




							for (Part part : request.getParts()) {
								part.write(path);
							}
							request.setAttribute("AddPostNoticeMsg","Study Material was publish successfully !!!. & save to "+path);

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
				else if(postSubject.equals("Information System")) {
					String fileName = postFile.getSubmittedFileName();
					String path=UPLOAD_DIRECTORY+"\\computer\\note\\7th\\Information System" + File.separator + fileName; //best way
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
							String newpath=UPLOAD_DIRECTORY+"\\computer\\note\\7th\\Information System" + File.separator + newfileName; //best way
							File newdirectory=new File(newpath);

							if(!newdirectory.exists()) {

								AddPostStudyMaterialClass p=new AddPostStudyMaterialClass(postId,postDate,postFaculty,postSemester,postType,postSubject,newfileName);
								AddPostStudyMaterialDao dao=new AddPostStudyMaterialDao();
								if(dao.savePost(p)) {

									for (Part part : request.getParts()) {
										part.write(newpath);
									}

									request.setAttribute("AddPostNoticeMsg","Study material was publish successfully !!! . Your file name already existed. So we have changed file name to "+newfileName+" & save to "+newpath);

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

						AddPostStudyMaterialClass p=new AddPostStudyMaterialClass(postId,postDate,postFaculty,postSemester,postType,postSubject,fileName);
						AddPostStudyMaterialDao dao=new AddPostStudyMaterialDao();
						if(dao.savePost(p)) {




							for (Part part : request.getParts()) {
								part.write(path);
							}
							request.setAttribute("AddPostNoticeMsg","Study Material was publish successfully !!!. & save to "+path);

							RequestDispatcher requestDispatcher = request.getRequestDispatcher("/admincontrol.jsp");
							requestDispatcher.forward(request, response);


						}
						else {
							request.setAttribute("AddPostNoticeMsg", "Internal error occured.");
							RequestDispatcher dispatcher=request.getRequestDispatcher("/admincontrol.jsp");
							dispatcher.forward(request, response);

						}
					}


				}else if(postSubject.equals("Data Mining & Data Warehousing")) {
					String fileName = postFile.getSubmittedFileName();
					String path=UPLOAD_DIRECTORY+"\\computer\\note\\7th\\Data Mining & Data Warehousing" + File.separator + fileName; //best way
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
							String newpath=UPLOAD_DIRECTORY+"\\computer\\note\\7th\\Data Mining & Data Warehousing" + File.separator + newfileName; //best way
							File newdirectory=new File(newpath);

							if(!newdirectory.exists()) {

								AddPostStudyMaterialClass p=new AddPostStudyMaterialClass(postId,postDate,postFaculty,postSemester,postType,postSubject,newfileName);
								AddPostStudyMaterialDao dao=new AddPostStudyMaterialDao();
								if(dao.savePost(p)) {

									for (Part part : request.getParts()) {
										part.write(newpath);
									}

									request.setAttribute("AddPostNoticeMsg","Study material was publish successfully !!! . Your file name already existed. So we have changed file name to "+newfileName+" & save to "+newpath);

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

						AddPostStudyMaterialClass p=new AddPostStudyMaterialClass(postId,postDate,postFaculty,postSemester,postType,postSubject,fileName);
						AddPostStudyMaterialDao dao=new AddPostStudyMaterialDao();
						if(dao.savePost(p)) {




							for (Part part : request.getParts()) {
								part.write(path);
							}
							request.setAttribute("AddPostNoticeMsg","Study Material was publish successfully !!!. & save to "+path);

							RequestDispatcher requestDispatcher = request.getRequestDispatcher("/admincontrol.jsp");
							requestDispatcher.forward(request, response);


						}
						else {
							request.setAttribute("AddPostNoticeMsg", "Internal error occured.");
							RequestDispatcher dispatcher=request.getRequestDispatcher("/admincontrol.jsp");
							dispatcher.forward(request, response);

						}
					}

				}else if(postSubject.equals("Simulation & Modeling")) {
					String fileName = postFile.getSubmittedFileName();
					String path=UPLOAD_DIRECTORY+"\\computer\\note\\7th\\Simulation & Modeling" + File.separator + fileName; //best way
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
							String newpath=UPLOAD_DIRECTORY+"\\computer\\note\\7th\\Simulation & Modeling" + File.separator + newfileName; //best way
							File newdirectory=new File(newpath);

							if(!newdirectory.exists()) {

								AddPostStudyMaterialClass p=new AddPostStudyMaterialClass(postId,postDate,postFaculty,postSemester,postType,postSubject,newfileName);
								AddPostStudyMaterialDao dao=new AddPostStudyMaterialDao();
								if(dao.savePost(p)) {

									for (Part part : request.getParts()) {
										part.write(newpath);
									}

									request.setAttribute("AddPostNoticeMsg","Study material was publish successfully !!! . Your file name already existed. So we have changed file name to "+newfileName+" & save to "+newpath);

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

						AddPostStudyMaterialClass p=new AddPostStudyMaterialClass(postId,postDate,postFaculty,postSemester,postType,postSubject,fileName);
						AddPostStudyMaterialDao dao=new AddPostStudyMaterialDao();
						if(dao.savePost(p)) {




							for (Part part : request.getParts()) {
								part.write(path);
							}
							request.setAttribute("AddPostNoticeMsg","Study Material was publish successfully !!!. & save to "+path);

							RequestDispatcher requestDispatcher = request.getRequestDispatcher("/admincontrol.jsp");
							requestDispatcher.forward(request, response);


						}
						else {
							request.setAttribute("AddPostNoticeMsg", "Internal error occured.");
							RequestDispatcher dispatcher=request.getRequestDispatcher("/admincontrol.jsp");
							dispatcher.forward(request, response);

						}
					}

				}else if(postSubject.equals("Elective-I")) {
					String fileName = postFile.getSubmittedFileName();
					String path=UPLOAD_DIRECTORY+"\\computer\\note\\7th\\Elective-I" + File.separator + fileName; //best way
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
							String newpath=UPLOAD_DIRECTORY+"\\computer\\note\\7th\\Elective-I" + File.separator + newfileName; //best way
							File newdirectory=new File(newpath);

							if(!newdirectory.exists()) {

								AddPostStudyMaterialClass p=new AddPostStudyMaterialClass(postId,postDate,postFaculty,postSemester,postType,postSubject,newfileName);
								AddPostStudyMaterialDao dao=new AddPostStudyMaterialDao();
								if(dao.savePost(p)) {

									for (Part part : request.getParts()) {
										part.write(newpath);
									}

									request.setAttribute("AddPostNoticeMsg","Study material was publish successfully !!! . Your file name already existed. So we have changed file name to "+newfileName+" & save to "+newpath);

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

						AddPostStudyMaterialClass p=new AddPostStudyMaterialClass(postId,postDate,postFaculty,postSemester,postType,postSubject,fileName);
						AddPostStudyMaterialDao dao=new AddPostStudyMaterialDao();
						if(dao.savePost(p)) {




							for (Part part : request.getParts()) {
								part.write(path);
							}
							request.setAttribute("AddPostNoticeMsg","Study Material was publish successfully !!!. & save to "+path);

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
				else if(postSubject.equals("Project-Part A")) {
					String fileName = postFile.getSubmittedFileName();
					String path=UPLOAD_DIRECTORY+"\\computer\\note\\7th\\Project-Part A" + File.separator + fileName; //best way
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
							String newpath=UPLOAD_DIRECTORY+"\\computer\\note\\7th\\Project-Part A" + File.separator + newfileName; //best way
							File newdirectory=new File(newpath);

							if(!newdirectory.exists()) {

								AddPostStudyMaterialClass p=new AddPostStudyMaterialClass(postId,postDate,postFaculty,postSemester,postType,postSubject,newfileName);
								AddPostStudyMaterialDao dao=new AddPostStudyMaterialDao();
								if(dao.savePost(p)) {

									for (Part part : request.getParts()) {
										part.write(newpath);
									}

									request.setAttribute("AddPostNoticeMsg","Study material was publish successfully !!! . Your file name already existed. So we have changed file name to "+newfileName+" & save to "+newpath);

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

						AddPostStudyMaterialClass p=new AddPostStudyMaterialClass(postId,postDate,postFaculty,postSemester,postType,postSubject,fileName);
						AddPostStudyMaterialDao dao=new AddPostStudyMaterialDao();
						if(dao.savePost(p)) {




							for (Part part : request.getParts()) {
								part.write(path);
							}
							request.setAttribute("AddPostNoticeMsg","Study Material was publish successfully !!!. & save to "+path);

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
					request.setAttribute("AddPostNoticeMsg", "Failed to post due to you have not selected any subject.");
					RequestDispatcher dispatcher=request.getRequestDispatcher("/admincontrol.jsp");
					dispatcher.forward(request, response);

				}
			}
			//8th sem

			else if(postFaculty.equals("Computer Engineering") && postSemester.equals("8th sem") && postType.equals("Note")) {

				if(postSubject.equals("Digital Signal Analysis & Processing")) {
					String fileName = postFile.getSubmittedFileName();
					String path=UPLOAD_DIRECTORY+"\\computer\\note\\8th\\Digital Signal Analysis & Processing" + File.separator + fileName; //best way
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
							String newpath=UPLOAD_DIRECTORY+"\\computer\\note\\8th\\Digital Signal Analysis & Processing" + File.separator + newfileName; //best way
							File newdirectory=new File(newpath);

							if(!newdirectory.exists()) {

								AddPostStudyMaterialClass p=new AddPostStudyMaterialClass(postId,postDate,postFaculty,postSemester,postType,postSubject,newfileName);
								AddPostStudyMaterialDao dao=new AddPostStudyMaterialDao();
								if(dao.savePost(p)) {

									for (Part part : request.getParts()) {
										part.write(newpath);
									}

									request.setAttribute("AddPostNoticeMsg","Study material was publish successfully !!! . Your file name already existed. So we have changed file name to "+newfileName+" & save to "+newpath);

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

						AddPostStudyMaterialClass p=new AddPostStudyMaterialClass(postId,postDate,postFaculty,postSemester,postType,postSubject,fileName);
						AddPostStudyMaterialDao dao=new AddPostStudyMaterialDao();
						if(dao.savePost(p)) {




							for (Part part : request.getParts()) {
								part.write(path);
							}
							request.setAttribute("AddPostNoticeMsg","Study Material was publish successfully !!!. & save to "+path);

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
				else if(postSubject.equals("Engineering Professional Practice")) {
					String fileName = postFile.getSubmittedFileName();
					String path=UPLOAD_DIRECTORY+"\\computer\\note\\8th\\Engineering Professional Practice" + File.separator + fileName; //best way
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
							String newpath=UPLOAD_DIRECTORY+"\\computer\\note\\8th\\Engineering Professional Practice" + File.separator + newfileName; //best way
							File newdirectory=new File(newpath);

							if(!newdirectory.exists()) {

								AddPostStudyMaterialClass p=new AddPostStudyMaterialClass(postId,postDate,postFaculty,postSemester,postType,postSubject,newfileName);
								AddPostStudyMaterialDao dao=new AddPostStudyMaterialDao();
								if(dao.savePost(p)) {

									for (Part part : request.getParts()) {
										part.write(newpath);
									}

									request.setAttribute("AddPostNoticeMsg","Study material was publish successfully !!! . Your file name already existed. So we have changed file name to "+newfileName+" & save to "+newpath);

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
						AddPostStudyMaterialClass p=new AddPostStudyMaterialClass(postId,postDate,postFaculty,postSemester,postType,postSubject,fileName);
						AddPostStudyMaterialDao dao=new AddPostStudyMaterialDao();
						if(dao.savePost(p)) {
							for (Part part : request.getParts()) {
								part.write(path);
							}
							request.setAttribute("AddPostNoticeMsg","Study Material was publish successfully !!!. & save to "+path);

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
				else if(postSubject.equals("Information Security")) {
					String fileName = postFile.getSubmittedFileName();
					String path=UPLOAD_DIRECTORY+"\\computer\\note\\8th\\Information Security" + File.separator + fileName; //best way
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
							String newpath=UPLOAD_DIRECTORY+"\\computer\\note\\8th\\Information Security" + File.separator + newfileName; //best way
							File newdirectory=new File(newpath);

							if(!newdirectory.exists()) {

								AddPostStudyMaterialClass p=new AddPostStudyMaterialClass(postId,postDate,postFaculty,postSemester,postType,postSubject,newfileName);
								AddPostStudyMaterialDao dao=new AddPostStudyMaterialDao();
								if(dao.savePost(p)) {

									for (Part part : request.getParts()) {
										part.write(newpath);
									}

									request.setAttribute("AddPostNoticeMsg","Study material was publish successfully !!! . Your file name already existed. So we have changed file name to "+newfileName+" & save to "+newpath);

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

						AddPostStudyMaterialClass p=new AddPostStudyMaterialClass(postId,postDate,postFaculty,postSemester,postType,postSubject,fileName);
						AddPostStudyMaterialDao dao=new AddPostStudyMaterialDao();
						if(dao.savePost(p)) {

							for (Part part : request.getParts()) {
								part.write(path);
							}
							request.setAttribute("AddPostNoticeMsg","Study Material was publish successfully !!!. & save to "+path);

							RequestDispatcher requestDispatcher = request.getRequestDispatcher("/admincontrol.jsp");
							requestDispatcher.forward(request, response);

						}
						else {
							request.setAttribute("AddPostNoticeMsg", "Internal error occured.");
							RequestDispatcher dispatcher=request.getRequestDispatcher("/admincontrol.jsp");
							dispatcher.forward(request, response);

						}
					}

				}else if(postSubject.equals("Big Data")) {
					String fileName = postFile.getSubmittedFileName();
					String path=UPLOAD_DIRECTORY+"\\computer\\note\\8th\\Big Data" + File.separator + fileName; //best way
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
							String newpath=UPLOAD_DIRECTORY+"\\computer\\note\\8th\\Big Data" + File.separator + newfileName; //best way
							File newdirectory=new File(newpath);

							if(!newdirectory.exists()) {

								AddPostStudyMaterialClass p=new AddPostStudyMaterialClass(postId,postDate,postFaculty,postSemester,postType,postSubject,newfileName);
								AddPostStudyMaterialDao dao=new AddPostStudyMaterialDao();
								if(dao.savePost(p)) {

									for (Part part : request.getParts()) {
										part.write(newpath);
									}

									request.setAttribute("AddPostNoticeMsg","Study material was publish successfully !!! . Your file name already existed. So we have changed file name to "+newfileName+" & save to "+newpath);

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
						AddPostStudyMaterialClass p=new AddPostStudyMaterialClass(postId,postDate,postFaculty,postSemester,postType,postSubject,fileName);
						AddPostStudyMaterialDao dao=new AddPostStudyMaterialDao();
						if(dao.savePost(p)) {
							for (Part part : request.getParts()) {
								part.write(path);
							}
							request.setAttribute("AddPostNoticeMsg","Study Material was publish successfully !!!. & save to "+path);

							RequestDispatcher requestDispatcher = request.getRequestDispatcher("/admincontrol.jsp");
							requestDispatcher.forward(request, response);

						}
						else {
							request.setAttribute("AddPostNoticeMsg", "Internal error occured.");
							RequestDispatcher dispatcher=request.getRequestDispatcher("/admincontrol.jsp");
							dispatcher.forward(request, response);

						}
					}

				}else if(postSubject.equals("Elective-II")) {
					String fileName = postFile.getSubmittedFileName();
					String path=UPLOAD_DIRECTORY+"\\computer\\note\\8th\\Elective-II" + File.separator + fileName; //best way
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
							String newpath=UPLOAD_DIRECTORY+"\\computer\\note\\8th\\Elective-II" + File.separator + newfileName; //best way
							File newdirectory=new File(newpath);

							if(!newdirectory.exists()) {

								AddPostStudyMaterialClass p=new AddPostStudyMaterialClass(postId,postDate,postFaculty,postSemester,postType,postSubject,newfileName);
								AddPostStudyMaterialDao dao=new AddPostStudyMaterialDao();
								if(dao.savePost(p)) {

									for (Part part : request.getParts()) {
										part.write(newpath);
									}

									request.setAttribute("AddPostNoticeMsg","Study material was publish successfully !!! . Your file name already existed. So we have changed file name to "+newfileName+" & save to "+newpath);

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
						AddPostStudyMaterialClass p=new AddPostStudyMaterialClass(postId,postDate,postFaculty,postSemester,postType,postSubject,fileName);
						AddPostStudyMaterialDao dao=new AddPostStudyMaterialDao();
						if(dao.savePost(p)) {
							for (Part part : request.getParts()) {
								part.write(path);
							}
							request.setAttribute("AddPostNoticeMsg","Study Material was publish successfully !!!. & save to "+path);

							RequestDispatcher requestDispatcher = request.getRequestDispatcher("/admincontrol.jsp");
							requestDispatcher.forward(request, response);
						}
						else {
							request.setAttribute("AddPostNoticeMsg", "Internal error occured.");
							RequestDispatcher dispatcher=request.getRequestDispatcher("/admincontrol.jsp");
							dispatcher.forward(request, response);

						}
					}

				}else if(postSubject.equals("Project-Part B")) {
					String fileName = postFile.getSubmittedFileName();
					String path=UPLOAD_DIRECTORY+"\\computer\\note\\8th\\Project-Part B" + File.separator + fileName; //best way
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
							String newpath=UPLOAD_DIRECTORY+"\\computer\\note\\8th\\Project-Part B" + File.separator + newfileName; //best way
							File newdirectory=new File(newpath);

							if(!newdirectory.exists()) {

								AddPostStudyMaterialClass p=new AddPostStudyMaterialClass(postId,postDate,postFaculty,postSemester,postType,postSubject,newfileName);
								AddPostStudyMaterialDao dao=new AddPostStudyMaterialDao();
								if(dao.savePost(p)) {

									for (Part part : request.getParts()) {
										part.write(newpath);
									}

									request.setAttribute("AddPostNoticeMsg","Study material was publish successfully !!! . Your file name already existed. So we have changed file name to "+newfileName+" & save to "+newpath);

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
						AddPostStudyMaterialClass p=new AddPostStudyMaterialClass(postId,postDate,postFaculty,postSemester,postType,postSubject,fileName);
						AddPostStudyMaterialDao dao=new AddPostStudyMaterialDao();
						if(dao.savePost(p)) {
							for (Part part : request.getParts()) {
								part.write(path);
							}
							request.setAttribute("AddPostNoticeMsg","Study Material was publish successfully !!!. & save to "+path);

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
					request.setAttribute("AddPostNoticeMsg", "Failed to post due to you have not selected any subject.");
					RequestDispatcher dispatcher=request.getRequestDispatcher("/admincontrol.jsp");
					dispatcher.forward(request, response);

				}
			}	
			
							//Section 2: For Computer->Add Question collection

			//All Sem
			else if(postFaculty.equals("Computer Engineering") && postSemester.equals("1st sem") || postSemester.equals("2nd sem") || postSemester.equals("3rd sem") || postSemester.equals("4th sem") || postSemester.equals("5th sem") || postSemester.equals("6th sem") || postSemester.equals("7th sem") || postSemester.equals("8th sem") && postType.equals("Question collection")) {

				String fileName = postFile.getSubmittedFileName();
				String path=UPLOAD_DIRECTORY+"\\computer\\oldisgold" + File.separator + fileName; //best way
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
						String newpath=UPLOAD_DIRECTORY+"\\computer\\oldisgold" + File.separator + newfileName; //best way
						File newdirectory=new File(newpath);

						if(!newdirectory.exists()) {

							AddPostStudyMaterialClass p=new AddPostStudyMaterialClass(postId,postDate,postFaculty,postSemester,postType,"",newfileName);
							AddPostStudyMaterialDao dao=new AddPostStudyMaterialDao();
							if(dao.savePost(p)) {

								for (Part part : request.getParts()) {
									part.write(newpath);
								}

								request.setAttribute("AddPostNoticeMsg","Study material was publish successfully !!! . Your file name already existed. So we have changed file name to "+newfileName+" & save to "+newpath);

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

					AddPostStudyMaterialClass p=new AddPostStudyMaterialClass(postId,postDate,postFaculty,postSemester,postType,"",fileName);
					AddPostStudyMaterialDao dao=new AddPostStudyMaterialDao();
					if(dao.savePost(p)) {
						for (Part part : request.getParts()) {
							part.write(path);
						}
						request.setAttribute("AddPostNoticeMsg","Study Material was publish successfully !!!. & save to "+path);

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
				request.setAttribute("AddPostNoticeMsg", "Your data not match.");
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
