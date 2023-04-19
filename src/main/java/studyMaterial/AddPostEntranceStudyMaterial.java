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

/**
 * Servlet implementation class AddPostEntranceStudyMaterial
 */
@WebServlet("/AddPostEntranceStudyMaterial")
@MultipartConfig(
		fileSizeThreshold = 1024 * 1024 * 5, // 5.24 MB
		maxFileSize = 1024 * 1024 * 500,      // 524 MB
		maxRequestSize = 1024 * 500 * 1000   // 1048 MB
		)
public class AddPostEntranceStudyMaterial extends HttpServlet {
	private final String UPLOAD_DIRECTORY = "C:\\Users\\Dell\\eclipse-workspace\\SOES\\WebContent\\studymaterial";

	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddPostEntranceStudyMaterial() {
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


		int postId=Integer.parseInt(request.getParameter("entrancepostId"));
		String postDate=request.getParameter("entrancepostDate");
		String postFaculty=request.getParameter("entrancepostFaculty");
		String postSemester=request.getParameter("entrancepostSemester");
		String postType=request.getParameter("entrancepostType");
		String postSubject=request.getParameter("entrancepostSubject");

		Part postFile=request.getPart("entrancepostFile");	

		String resultMessage="";

		try {
			//section 1 chaahi civil ko laagi ho i.e. AddPostCivilStudyMaterial.java

			//section 2 chaahi computer ko laagi ho i.e. AddPostComputerStudyMaterial.java
			//For Entrance
			//Section 3: For Entrance->Add Book
			//1st Sem
			if(postFaculty.equals("Entrance") && postSemester.equals("No Semester") && postType.equals("Book")) {

				if(postSubject.equals("English")) {
					String fileName = postFile.getSubmittedFileName();
					String path=UPLOAD_DIRECTORY+"\\entrance\\book\\English" + File.separator + fileName; //best way
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
							String newpath=UPLOAD_DIRECTORY+"\\entrance\\book\\English" + File.separator + newfileName; //best way
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
				else if(postSubject.equals("Chemistry")) {
					String fileName = postFile.getSubmittedFileName();
					String path=UPLOAD_DIRECTORY+"\\entrance\\book\\Chemistry" + File.separator + fileName; //best way
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
							String newpath=UPLOAD_DIRECTORY+"\\entrance\\book\\Chemistry" + File.separator + newfileName; //best way
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
				else if(postSubject.equals("Physics")) {
					String fileName = postFile.getSubmittedFileName();
					String path=UPLOAD_DIRECTORY+"\\entrance\\book\\Physics" + File.separator + fileName; //best way
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
							String newpath=UPLOAD_DIRECTORY+"\\entrance\\book\\Physics" + File.separator + newfileName; //best way
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
				else if(postSubject.equals("Mathematics")) {
					String fileName = postFile.getSubmittedFileName();
					String path=UPLOAD_DIRECTORY+"\\entrance\\book\\Mathematics" + File.separator + fileName; //best way
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
							String newpath=UPLOAD_DIRECTORY+"\\entrance\\book\\Mathematics" + File.separator + newfileName; //best way
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


			// For Entrance->Add Note


			else if(postFaculty.equals("Entrance") && postSemester.equals("No Semester") && postType.equals("Note")) {

				if(postSubject.equals("English")) {
					String fileName = postFile.getSubmittedFileName();
					String path=UPLOAD_DIRECTORY+"\\entrance\\note\\English" + File.separator + fileName; //best way
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
							String newpath=UPLOAD_DIRECTORY+"\\entrance\\note\\English" + File.separator + newfileName; //best way
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
				else if(postSubject.equals("Chemistry")) {
					String fileName = postFile.getSubmittedFileName();
					String path=UPLOAD_DIRECTORY+"\\entrance\\note\\Chemistry" + File.separator + fileName; //best way
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
							String newpath=UPLOAD_DIRECTORY+"\\entrance\\note\\Chemistry" + File.separator + newfileName; //best way
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
				else if(postSubject.equals("Physics")) {
					String fileName = postFile.getSubmittedFileName();
					String path=UPLOAD_DIRECTORY+"\\entrance\\note\\Physics" + File.separator + fileName; //best way
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
							String newpath=UPLOAD_DIRECTORY+"\\entrance\\note\\Physics" + File.separator + newfileName; //best way
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
				else if(postSubject.equals("Mathematics")) {
					String fileName = postFile.getSubmittedFileName();
					String path=UPLOAD_DIRECTORY+"\\entrance\\note\\Mathematics" + File.separator + fileName; //best way
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
							String newpath=UPLOAD_DIRECTORY+"\\entrance\\note\\Mathematics" + File.separator + newfileName; //best way
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
			
			
			//For Entrance Question Collection
			
			else if(postFaculty.equals("Entrance") && postSemester.equals("No Semester") && postType.equals("Question collection")) {

				
					String fileName = postFile.getSubmittedFileName();
					String path=UPLOAD_DIRECTORY+"\\entrance\\oldisgold" + File.separator + fileName; //best way
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
							String newpath=UPLOAD_DIRECTORY+"\\entrance\\oldisgold" + File.separator + newfileName; //best way
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
