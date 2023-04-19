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

@WebServlet("/AddPostCivilStudyMaterial")

@MultipartConfig(
		fileSizeThreshold = 1024 * 1024 * 5, // 5.24 MB
		maxFileSize = 1024 * 1024 * 500,      // 524 MB
		maxRequestSize = 1024 * 500 * 1000   // 1048 MB
		)

public class AddPostCivilStudyMaterial extends HttpServlet {

	private final String UPLOAD_DIRECTORY = "C:\\Users\\Dell\\eclipse-workspace\\SOES\\WebContent\\studymaterial";
	private static final long serialVersionUID = 1L;

	public AddPostCivilStudyMaterial() {
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
			//For civil Engineering
			//Section 1: For Civil->Add Book
			//1st Sem
			if(postFaculty.equals("Civil Engineering") && postSemester.equals("1st sem") && postType.equals("Book")) {
				if(postSubject.equals("Engineering Mathematics I")) {
					String fileName = postFile.getSubmittedFileName();
					String path=UPLOAD_DIRECTORY+"\\civil\\book\\1st\\Engineering Mathematics I" + File.separator + fileName; //best way
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
							String newpath=UPLOAD_DIRECTORY+"\\civil\\book\\1st\\Engineering Mathematics I" + File.separator + newfileName; //best way
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
				else if(postSubject.equals("Basic Programming & Data Structure")) {
					String fileName = postFile.getSubmittedFileName();
					String path=UPLOAD_DIRECTORY+"\\civil\\book\\1st\\Basic Programming & Data Structure" + File.separator + fileName; //best way
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
							String newpath=UPLOAD_DIRECTORY+"\\civil\\book\\1st\\Basic Programming & Data Structure" + File.separator + newfileName; //best way
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
					String path=UPLOAD_DIRECTORY+"\\civil\\book\\1st\\Engineering Chemistry" + File.separator + fileName; //best way
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
							String newpath=UPLOAD_DIRECTORY+"\\civil\\book\\1st\\Engineering Chemistry" + File.separator + newfileName; //best way
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

				}else if(postSubject.equals("Engineering Drawing I")) {
					String fileName = postFile.getSubmittedFileName();
					String path=UPLOAD_DIRECTORY+"\\civil\\book\\1st\\Engineering Drawing I" + File.separator + fileName; //best way
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
							String newpath=UPLOAD_DIRECTORY+"\\civil\\book\\1st\\Engineering Drawing I" + File.separator + newfileName; //best way
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

				}else if(postSubject.equals("English for Communication")) {
					String fileName = postFile.getSubmittedFileName();
					String path=UPLOAD_DIRECTORY+"\\civil\\book\\1st\\English for Communication" + File.separator + fileName; //best way
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
							String newpath=UPLOAD_DIRECTORY+"\\civil\\book\\1st\\English for Communication" + File.separator + newfileName; //best way
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

				}else if(postSubject.equals("Electricity & Magnetism")) {
					String fileName = postFile.getSubmittedFileName();
					String path=UPLOAD_DIRECTORY+"\\civil\\book\\1st\\Electricity & Magnetism" + File.separator + fileName; //best way
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
							String newpath=UPLOAD_DIRECTORY+"\\civil\\book\\1st\\Electricity & Magnetism" + File.separator + newfileName; //best way
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
			
			else if(postFaculty.equals("Civil Engineering") && postSemester.equals("2nd sem") && postType.equals("Book")) {

				if(postSubject.equals("Object Oriented Programming")) {
					String fileName = postFile.getSubmittedFileName();
					String path=UPLOAD_DIRECTORY+"\\civil\\book\\2nd\\Object Oriented Programming" + File.separator + fileName; //best way
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
							String newpath=UPLOAD_DIRECTORY+"\\civil\\book\\2nd\\Object Oriented Programming" + File.separator + newfileName; //best way
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
				else if(postSubject.equals("Fundamentals of Thermodynamics & Heat Transfer")) {
					String fileName = postFile.getSubmittedFileName();
					String path=UPLOAD_DIRECTORY+"\\civil\\book\\2nd\\Fundamentals of Thermodynamics & Heat Transfer" + File.separator + fileName; //best way
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
							String newpath=UPLOAD_DIRECTORY+"\\civil\\book\\2nd\\Fundamentals of Thermodynamics & Heat Transfer" + File.separator + newfileName; //best way
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
				else if(postSubject.equals("Engineering Mathematics II")) {
					String fileName = postFile.getSubmittedFileName();
					String path=UPLOAD_DIRECTORY+"\\civil\\book\\2nd\\Engineering Mathematics II" + File.separator + fileName; //best way
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
							String newpath=UPLOAD_DIRECTORY+"\\civil\\book\\2nd\\Engineering Mathematics II" + File.separator + newfileName; //best way
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
				}else if(postSubject.equals("Engineering Drawing II")) {
					String fileName = postFile.getSubmittedFileName();
					String path=UPLOAD_DIRECTORY+"\\civil\\book\\2nd\\Engineering Drawing II" + File.separator + fileName; //best way
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
							String newpath=UPLOAD_DIRECTORY+"\\civil\\book\\2nd\\Engineering Drawing II" + File.separator + newfileName; //best way
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

				}else if(postSubject.equals("Study Skills in English for Academic Purposes")) {
					String fileName = postFile.getSubmittedFileName();
					String path=UPLOAD_DIRECTORY+"\\civil\\book\\2nd\\Study Skills in English for Academic Purposes" + File.separator + fileName; //best way
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
							String newpath=UPLOAD_DIRECTORY+"\\civil\\book\\2nd\\Study Skills in English for Academic Purposes" + File.separator + newfileName; //best way
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

				}else if(postSubject.equals("Mechanics & Optics")) {
					String fileName = postFile.getSubmittedFileName();
					String path=UPLOAD_DIRECTORY+"\\civil\\book\\2nd\\Mechanics & Optics" + File.separator + fileName; //best way
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
							String newpath=UPLOAD_DIRECTORY+"\\civil\\book\\2nd\\Mechanics & Optics" + File.separator + newfileName; //best way
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

			else if(postFaculty.equals("Civil Engineering") && postSemester.equals("3rd sem") && postType.equals("Book")) {

				if(postSubject.equals("Basic Mechanical Engineering")) {
					String fileName = postFile.getSubmittedFileName();
					String path=UPLOAD_DIRECTORY+"\\civil\\book\\3rd\\Basic Mechanical Engineering" + File.separator + fileName; //best way
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
							String newpath=UPLOAD_DIRECTORY+"\\civil\\book\\3rd\\Basic Mechanical Engineering" + File.separator + newfileName; //best way
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
				else if(postSubject.equals("Basic Electrical & Electronics Engineering")) {
					String fileName = postFile.getSubmittedFileName();
					String path=UPLOAD_DIRECTORY+"\\civil\\book\\3rd\\Basic Electrical & Electronics Engineering" + File.separator + fileName; //best way
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
							String newpath=UPLOAD_DIRECTORY+"\\civil\\book\\3rd\\Basic Electrical & Electronics Engineering" + File.separator + newfileName; //best way
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
				else if(postSubject.equals("Engineering Geology")) {
					String fileName = postFile.getSubmittedFileName();
					String path=UPLOAD_DIRECTORY+"\\civil\\book\\3rd\\Engineering Geology" + File.separator + fileName; //best way
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
							String newpath=UPLOAD_DIRECTORY+"\\civil\\book\\3rd\\Engineering Geology" + File.separator + newfileName; //best way
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

				}else if(postSubject.equals("Engineering Mathematics III")) {
					String fileName = postFile.getSubmittedFileName();
					String path=UPLOAD_DIRECTORY+"\\civil\\book\\3rd\\Engineering Mathematics III" + File.separator + fileName; //best way
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
							String newpath=UPLOAD_DIRECTORY+"\\civil\\book\\3rd\\Engineering Mathematics III" + File.separator + newfileName; //best way
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

				}else if(postSubject.equals("Strength of Materials")) {
					String fileName = postFile.getSubmittedFileName();
					String path=UPLOAD_DIRECTORY+"\\civil\\book\\3rd\\Strength of Materials" + File.separator + fileName; //best way
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
							String newpath=UPLOAD_DIRECTORY+"\\civil\\book\\3rd\\Strength of Materials" + File.separator + newfileName; //best way
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

				}else if(postSubject.equals("Surveying I")) {
					String fileName = postFile.getSubmittedFileName();
					String path=UPLOAD_DIRECTORY+"\\civil\\book\\3rd\\Surveying I" + File.separator + fileName; //best way
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
							String newpath=UPLOAD_DIRECTORY+"\\civil\\book\\3rd\\Surveying I" + File.separator + newfileName; //best way
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

			else if(postFaculty.equals("Civil Engineering") && postSemester.equals("4th sem") && postType.equals("Book")) {

				if(postSubject.equals("Building Drawing")) {
					String fileName = postFile.getSubmittedFileName();
					String path=UPLOAD_DIRECTORY+"\\civil\\book\\4th\\Building Drawing" + File.separator + fileName; //best way
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
							String newpath=UPLOAD_DIRECTORY+"\\civil\\book\\4th\\Building Drawing" + File.separator + newfileName; //best way
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
				else if(postSubject.equals("Communication English II")) {
					String fileName = postFile.getSubmittedFileName();
					String path=UPLOAD_DIRECTORY+"\\civil\\book\\4th\\Communication English II" + File.separator + fileName; //best way
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
							String newpath=UPLOAD_DIRECTORY+"\\civil\\book\\4th\\Communication English II" + File.separator + newfileName; //best way
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
				else if(postSubject.equals("Structural Analysis I")) {
					String fileName = postFile.getSubmittedFileName();
					String path=UPLOAD_DIRECTORY+"\\civil\\book\\4th\\Structural Analysis I" + File.separator + fileName; //best way
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
							String newpath=UPLOAD_DIRECTORY+"\\civil\\book\\4th\\Structural Analysis I" + File.separator + newfileName; //best way
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


				}else if(postSubject.equals("Building Technology")) {
					String fileName = postFile.getSubmittedFileName();
					String path=UPLOAD_DIRECTORY+"\\civil\\book\\4th\\Building Technology" + File.separator + fileName; //best way
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
							String newpath=UPLOAD_DIRECTORY+"\\civil\\book\\4th\\Building Technology" + File.separator + newfileName; //best way
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

				}else if(postSubject.equals("Hydraulics")) {
					String fileName = postFile.getSubmittedFileName();
					String path=UPLOAD_DIRECTORY+"\\civil\\book\\4th\\Hydraulics" + File.separator + fileName; //best way
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
							String newpath=UPLOAD_DIRECTORY+"\\civil\\book\\4th\\Hydraulics" + File.separator + newfileName; //best way
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

				}else if(postSubject.equals("Probability & Experimental Design")) {
					String fileName = postFile.getSubmittedFileName();
					String path=UPLOAD_DIRECTORY+"\\civil\\book\\4th\\Probability & Experimental Design" + File.separator + fileName; //best way
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
							String newpath=UPLOAD_DIRECTORY+"\\civil\\book\\4th\\Probability & Experimental Design" + File.separator + newfileName; //best way
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
				else if(postSubject.equals("Surveying II")) {
					String fileName = postFile.getSubmittedFileName();
					String path=UPLOAD_DIRECTORY+"\\civil\\book\\4th\\Surveying II" + File.separator + fileName; //best way
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
							String newpath=UPLOAD_DIRECTORY+"\\civil\\book\\4th\\Surveying II" + File.separator + newfileName; //best way
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


			else if(postFaculty.equals("Civil Engineering") && postSemester.equals("5th sem") && postType.equals("Book")) {

				if(postSubject.equals("Structural Analysis II")) {
					String fileName = postFile.getSubmittedFileName();
					String path=UPLOAD_DIRECTORY+"\\civil\\book\\5th\\Structural Analysis II" + File.separator + fileName; //best way
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
							String newpath=UPLOAD_DIRECTORY+"\\civil\\book\\5th\\Structural Analysis II" + File.separator + newfileName; //best way
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
				else if(postSubject.equals("Transportation Engineering")) {
					String fileName = postFile.getSubmittedFileName();
					String path=UPLOAD_DIRECTORY+"\\civil\\book\\5th\\Transportation Engineering" + File.separator + fileName; //best way
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
							String newpath=UPLOAD_DIRECTORY+"\\civil\\book\\5th\\Transportation Engineering" + File.separator + newfileName; //best way
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
				else if(postSubject.equals("Water Supply Engineering")) {
					String fileName = postFile.getSubmittedFileName();
					String path=UPLOAD_DIRECTORY+"\\civil\\book\\5th\\Water Supply Engineering" + File.separator + fileName; //best way
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
							String newpath=UPLOAD_DIRECTORY+"\\civil\\book\\5th\\Water Supply Engineering" + File.separator + newfileName; //best way
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


				}else if(postSubject.equals("Hydrology & River Engineering")) {
					String fileName = postFile.getSubmittedFileName();
					String path=UPLOAD_DIRECTORY+"\\civil\\book\\5th\\Hydrology & River Engineering" + File.separator + fileName; //best way
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
							String newpath=UPLOAD_DIRECTORY+"\\civil\\book\\5th\\Hydrology & River Engineering" + File.separator + newfileName; //best way
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
					String path=UPLOAD_DIRECTORY+"\\civil\\book\\5th\\Engineering Economics" + File.separator + fileName; //best way
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
							String newpath=UPLOAD_DIRECTORY+"\\civil\\book\\5th\\Engineering Economics" + File.separator + newfileName; //best way
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

				}else if(postSubject.equals("Computer Methods in Civil Engineering")) {
					String fileName = postFile.getSubmittedFileName();
					String path=UPLOAD_DIRECTORY+"\\civil\\book\\5th\\Computer Methods in Civil Engineering" + File.separator + fileName; //best way
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
							String newpath=UPLOAD_DIRECTORY+"\\civil\\book\\5th\\Computer Methods in Civil Engineering" + File.separator + newfileName; //best way
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


			else if(postFaculty.equals("Civil Engineering") && postSemester.equals("6th sem") && postType.equals("Book")) {

				if(postSubject.equals("Soil & Rock Mechanics")) {
					String fileName = postFile.getSubmittedFileName();
					String path=UPLOAD_DIRECTORY+"\\civil\\book\\6th\\Soil & Rock Mechanics" + File.separator + fileName; //best way
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
							String newpath=UPLOAD_DIRECTORY+"\\civil\\book\\6th\\Soil & Rock Mechanics" + File.separator + newfileName; //best way
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
				else if(postSubject.equals("Design of Steel & Timber Structure")) {
					String fileName = postFile.getSubmittedFileName();
					String path=UPLOAD_DIRECTORY+"\\civil\\book\\6th\\Design of Steel & Timber Structure" + File.separator + fileName; //best way
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
							String newpath=UPLOAD_DIRECTORY+"\\civil\\book\\6th\\Design of Steel & Timber Structure" + File.separator + newfileName; //best way
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
				else if(postSubject.equals("Concrete Technology & Masonary Structures")) {
					String fileName = postFile.getSubmittedFileName();
					String path=UPLOAD_DIRECTORY+"\\civil\\book\\6th\\Concrete Technology & Masonary Structures" + File.separator + fileName; //best way
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
							String newpath=UPLOAD_DIRECTORY+"\\civil\\book\\6th\\Concrete Technology & Masonary Structures" + File.separator + newfileName; //best way
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


				}else if(postSubject.equals("Airport & Engineering")) {
					String fileName = postFile.getSubmittedFileName();
					String path=UPLOAD_DIRECTORY+"\\civil\\book\\6th\\Airport & Engineering" + File.separator + fileName; //best way
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
							String newpath=UPLOAD_DIRECTORY+"\\civil\\book\\6th\\Airport & Engineering" + File.separator + newfileName; //best way
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

				}else if(postSubject.equals("Irrigation Engineering")) {
					String fileName = postFile.getSubmittedFileName();
					String path=UPLOAD_DIRECTORY+"\\civil\\book\\6th\\Irrigation Engineering" + File.separator + fileName; //best way
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
							String newpath=UPLOAD_DIRECTORY+"\\civil\\book\\6th\\Irrigation Engineering" + File.separator + newfileName; //best way
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

				}else if(postSubject.equals("Estimation, Cost & Valuation")) {
					String fileName = postFile.getSubmittedFileName();
					String path=UPLOAD_DIRECTORY+"\\civil\\book\\6th\\Estimation, Cost & Valuation" + File.separator + fileName; //best way
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
							String newpath=UPLOAD_DIRECTORY+"\\civil\\book\\6th\\Estimation, Cost & Valuation" + File.separator + newfileName; //best way
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

				else if(postSubject.equals("Sanitary & Environmental Engineering")) {
					String fileName = postFile.getSubmittedFileName();
					String path=UPLOAD_DIRECTORY+"\\civil\\book\\6th\\Sanitary & Environmental Engineering" + File.separator + fileName; //best way
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
							String newpath=UPLOAD_DIRECTORY+"\\civil\\book\\6th\\Sanitary & Environmental Engineering" + File.separator + newfileName; //best way
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

			else if(postFaculty.equals("Civil Engineering") && postSemester.equals("7th sem") && postType.equals("Book")) {

				if(postSubject.equals("Design of RCC Structure")) {
					String fileName = postFile.getSubmittedFileName();
					String path=UPLOAD_DIRECTORY+"\\civil\\book\\7th\\Design of RCC Structure" + File.separator + fileName; //best way
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
							String newpath=UPLOAD_DIRECTORY+"\\civil\\book\\7th\\Design of RCC Structure" + File.separator + newfileName; //best way
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
				else if(postSubject.equals("Hydropower Engineering")) {
					String fileName = postFile.getSubmittedFileName();
					String path=UPLOAD_DIRECTORY+"\\civil\\book\\7th\\Hydropower Engineering" + File.separator + fileName; //best way
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
							String newpath=UPLOAD_DIRECTORY+"\\civil\\book\\7th\\Hydropower Engineering" + File.separator + newfileName; //best way
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
				else if(postSubject.equals("Foundation Engineering")) {
					String fileName = postFile.getSubmittedFileName();
					String path=UPLOAD_DIRECTORY+"\\civil\\book\\7th\\Foundation Engineering" + File.separator + fileName; //best way
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
							String newpath=UPLOAD_DIRECTORY+"\\civil\\book\\7th\\Foundation Engineering" + File.separator + newfileName; //best way
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
				}else if(postSubject.equals("Safety Engineering")) {
					String fileName = postFile.getSubmittedFileName();
					String path=UPLOAD_DIRECTORY+"\\civil\\book\\7th\\Safety Engineering" + File.separator + fileName; //best way
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
							String newpath=UPLOAD_DIRECTORY+"\\civil\\book\\7th\\Safety Engineering" + File.separator + newfileName; //best way
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

				}else if(postSubject.equals("Minor Project")) {
					String fileName = postFile.getSubmittedFileName();
					String path=UPLOAD_DIRECTORY+"\\civil\\book\\7th\\Minor Project" + File.separator + fileName; //best way
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
							String newpath=UPLOAD_DIRECTORY+"\\civil\\book\\7th\\Minor Project" + File.separator + newfileName; //best way
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

				}else if(postSubject.equals("Elective I")) {
					String fileName = postFile.getSubmittedFileName();
					String path=UPLOAD_DIRECTORY+"\\civil\\book\\7th\\Elective I" + File.separator + fileName; //best way
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
							String newpath=UPLOAD_DIRECTORY+"\\civil\\book\\7th\\Elective I" + File.separator + newfileName; //best way
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
				else if(postSubject.equals("Elective II")) {
					String fileName = postFile.getSubmittedFileName();
					String path=UPLOAD_DIRECTORY+"\\civil\\book\\7th\\Elective II" + File.separator + fileName; //best way
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
							String newpath=UPLOAD_DIRECTORY+"\\civil\\book\\7th\\Elective II" + File.separator + newfileName; //best way
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

			else if(postFaculty.equals("Civil Engineering") && postSemester.equals("8th sem") && postType.equals("Book")) {

				if(postSubject.equals("RS & GIS Application to Engineering")) {
					String fileName = postFile.getSubmittedFileName();
					String path=UPLOAD_DIRECTORY+"\\civil\\book\\8th\\RS & GIS Application to Engineering" + File.separator + fileName; //best way
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
							String newpath=UPLOAD_DIRECTORY+"\\civil\\book\\8th\\RS & GIS Application to Engineering" + File.separator + newfileName; //best way
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
				else if(postSubject.equals("Construction Management & Project Engineering")) {
					String fileName = postFile.getSubmittedFileName();
					String path=UPLOAD_DIRECTORY+"\\civil\\book\\8th\\Construction Management & Project Engineering" + File.separator + fileName; //best way
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
							String newpath=UPLOAD_DIRECTORY+"\\civil\\book\\8th\\Construction Management & Project Engineering" + File.separator + newfileName; //best way
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
				else if(postSubject.equals("Engineering Professional Practice & Society")) {
					String fileName = postFile.getSubmittedFileName();
					String path=UPLOAD_DIRECTORY+"\\civil\\book\\8th\\Engineering Professional Practice & Society" + File.separator + fileName; //best way
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
							String newpath=UPLOAD_DIRECTORY+"\\civil\\book\\8th\\Engineering Professional Practice & Society" + File.separator + newfileName; //best way
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
				}else if(postSubject.equals("Major Project")) {
					String fileName = postFile.getSubmittedFileName();
					String path=UPLOAD_DIRECTORY+"\\civil\\book\\8th\\Major Project" + File.separator + fileName; //best way
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
							String newpath=UPLOAD_DIRECTORY+"\\civil\\book\\8th\\Major Project" + File.separator + newfileName; //best way
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

				}else if(postSubject.equals("Elective III")) {
					String fileName = postFile.getSubmittedFileName();
					String path=UPLOAD_DIRECTORY+"\\civil\\book\\8th\\Elective III" + File.separator + fileName; //best way
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
							String newpath=UPLOAD_DIRECTORY+"\\civil\\book\\8th\\Elective III" + File.separator + newfileName; //best way
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

				}else if(postSubject.equals("Elective IV")) {
					String fileName = postFile.getSubmittedFileName();
					String path=UPLOAD_DIRECTORY+"\\civil\\book\\8th\\Elective IV" + File.separator + fileName; //best way
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
							String newpath=UPLOAD_DIRECTORY+"\\civil\\book\\8th\\Elective IV" + File.separator + newfileName; //best way
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

			//Section 1: For Civil->Add Note
			//1st Sem

			else if(postFaculty.equals("Civil Engineering") && postSemester.equals("1st sem") && postType.equals("Note")) {

				if(postSubject.equals("Engineering Mathematics I")) {
					String fileName = postFile.getSubmittedFileName();
					String path=UPLOAD_DIRECTORY+"\\civil\\note\\1st\\Engineering Mathematics I" + File.separator + fileName; //best way
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
							String newpath=UPLOAD_DIRECTORY+"\\civil\\note\\1st\\Engineering Mathematics I" + File.separator + newfileName; //best way
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
				else if(postSubject.equals("Basic Programming & Data Structure")) {
					String fileName = postFile.getSubmittedFileName();
					String path=UPLOAD_DIRECTORY+"\\civil\\note\\1st\\Basic Programming & Data Structure" + File.separator + fileName; //best way
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
							String newpath=UPLOAD_DIRECTORY+"\\civil\\note\\1st\\Basic Programming & Data Structure" + File.separator + newfileName; //best way
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
					String path=UPLOAD_DIRECTORY+"\\civil\\note\\1st\\Engineering Chemistry" + File.separator + fileName; //best way
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
							String newpath=UPLOAD_DIRECTORY+"\\civil\\note\\1st\\Engineering Chemistry" + File.separator + newfileName; //best way
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


				}else if(postSubject.equals("Engineering Drawing I")) {
					String fileName = postFile.getSubmittedFileName();
					String path=UPLOAD_DIRECTORY+"\\civil\\note\\1st\\Engineering Drawing I" + File.separator + fileName; //best way
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
							String newpath=UPLOAD_DIRECTORY+"\\civil\\note\\1st\\Engineering Drawing I" + File.separator + newfileName; //best way
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

				}else if(postSubject.equals("English for Communication")) {
					String fileName = postFile.getSubmittedFileName();
					String path=UPLOAD_DIRECTORY+"\\civil\\note\\1st\\English for Communication" + File.separator + fileName; //best way
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
							String newpath=UPLOAD_DIRECTORY+"\\civil\\note\\1st\\English for Communication" + File.separator + newfileName; //best way
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

				}else if(postSubject.equals("Electricity & Magnetism")) {
					String fileName = postFile.getSubmittedFileName();
					String path=UPLOAD_DIRECTORY+"\\civil\\note\\1st\\Electricity & Magnetism" + File.separator + fileName; //best way
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
							String newpath=UPLOAD_DIRECTORY+"\\civil\\note\\1st\\Electricity & Magnetism" + File.separator + newfileName; //best way
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


			else if(postFaculty.equals("Civil Engineering") && postSemester.equals("2nd sem") && postType.equals("Note")) {

				if(postSubject.equals("Object Oriented Programming")) {
					String fileName = postFile.getSubmittedFileName();
					String path=UPLOAD_DIRECTORY+"\\civil\\note\\2nd\\Object Oriented Programming" + File.separator + fileName; //best way
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
							String newpath=UPLOAD_DIRECTORY+"\\civil\\note\\2nd\\Object Oriented Programming" + File.separator + newfileName; //best way
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
				else if(postSubject.equals("Fundamentals of Thermodynamics & Heat Transfer")) {
					String fileName = postFile.getSubmittedFileName();
					String path=UPLOAD_DIRECTORY+"\\civil\\note\\2nd\\Fundamentals of Thermodynamics & Heat Transfer" + File.separator + fileName; //best way
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
							String newpath=UPLOAD_DIRECTORY+"\\civil\\note\\2nd\\Fundamentals of Thermodynamics & Heat Transfer" + File.separator + newfileName; //best way
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
				else if(postSubject.equals("Engineering Mathematics II")) {
					String fileName = postFile.getSubmittedFileName();
					String path=UPLOAD_DIRECTORY+"\\civil\\note\\2nd\\Engineering Mathematics II" + File.separator + fileName; //best way
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
							String newpath=UPLOAD_DIRECTORY+"\\civil\\note\\2nd\\Engineering Mathematics II" + File.separator + newfileName; //best way
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


				}else if(postSubject.equals("Engineering Drawing II")) {
					String fileName = postFile.getSubmittedFileName();
					String path=UPLOAD_DIRECTORY+"\\civil\\note\\2nd\\Engineering Drawing II" + File.separator + fileName; //best way
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
							String newpath=UPLOAD_DIRECTORY+"\\civil\\note\\2nd\\Engineering Drawing II" + File.separator + newfileName; //best way
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

				}else if(postSubject.equals("Study Skills in English for Academic Purposes")) {
					String fileName = postFile.getSubmittedFileName();
					String path=UPLOAD_DIRECTORY+"\\civil\\note\\2nd\\Study Skills in English for Academic Purposes" + File.separator + fileName; //best way
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
							String newpath=UPLOAD_DIRECTORY+"\\civil\\note\\2nd\\Study Skills in English for Academic Purposes" + File.separator + newfileName; //best way
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

				}else if(postSubject.equals("Mechanics & Optics")) {
					String fileName = postFile.getSubmittedFileName();
					String path=UPLOAD_DIRECTORY+"\\civil\\note\\2nd\\Mechanics & Optics" + File.separator + fileName; //best way
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
							String newpath=UPLOAD_DIRECTORY+"\\civil\\note\\2nd\\Mechanics & Optics" + File.separator + newfileName; //best way
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

			else if(postFaculty.equals("Civil Engineering") && postSemester.equals("3rd sem") && postType.equals("Note")) {

				if(postSubject.equals("Basic Mechanical Engineering")) {
					String fileName = postFile.getSubmittedFileName();
					String path=UPLOAD_DIRECTORY+"\\civil\\note\\3rd\\Basic Mechanical Engineering" + File.separator + fileName; //best way
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
							String newpath=UPLOAD_DIRECTORY+"\\civil\\note\\3rd\\Basic Mechanical Engineering" + File.separator + newfileName; //best way
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
				else if(postSubject.equals("Basic Electrical & Electronics Engineering")) {
					String fileName = postFile.getSubmittedFileName();
					String path=UPLOAD_DIRECTORY+"\\civil\\note\\3rd\\Basic Electrical & Electronics Engineering" + File.separator + fileName; //best way
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
							String newpath=UPLOAD_DIRECTORY+"\\civil\\note\\3rd\\Basic Electrical & Electronics Engineering" + File.separator + newfileName; //best way
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
				else if(postSubject.equals("Engineering Geology")) {
					String fileName = postFile.getSubmittedFileName();
					String path=UPLOAD_DIRECTORY+"\\civil\\note\\3rd\\Engineering Geology" + File.separator + fileName; //best way
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
							String newpath=UPLOAD_DIRECTORY+"\\civil\\note\\3rd\\Engineering Geology" + File.separator + newfileName; //best way
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


				}else if(postSubject.equals("Engineering Mathematics III")) {
					String fileName = postFile.getSubmittedFileName();
					String path=UPLOAD_DIRECTORY+"\\civil\\note\\3rd\\Engineering Mathematics III" + File.separator + fileName; //best way
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
							String newpath=UPLOAD_DIRECTORY+"\\civil\\note\\3rd\\Engineering Mathematics III" + File.separator + newfileName; //best way
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

				}else if(postSubject.equals("Strength of Materials")) {
					String fileName = postFile.getSubmittedFileName();
					String path=UPLOAD_DIRECTORY+"\\civil\\note\\3rd\\Strength of Materials" + File.separator + fileName; //best way
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
							String newpath=UPLOAD_DIRECTORY+"\\civil\\note\\3rd\\Strength of Materials" + File.separator + newfileName; //best way
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

				}else if(postSubject.equals("Surveying I")) {
					String fileName = postFile.getSubmittedFileName();
					String path=UPLOAD_DIRECTORY+"\\civil\\note\\3rd\\Surveying I" + File.separator + fileName; //best way
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
							String newpath=UPLOAD_DIRECTORY+"\\civil\\note\\3rd\\Surveying I" + File.separator + newfileName; //best way
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
			else if(postFaculty.equals("Civil Engineering") && postSemester.equals("4th sem") && postType.equals("Note")) {

				if(postSubject.equals("Building Drawing")) {
					String fileName = postFile.getSubmittedFileName();
					String path=UPLOAD_DIRECTORY+"\\civil\\note\\4th\\Building Drawing" + File.separator + fileName; //best way
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
							String newpath=UPLOAD_DIRECTORY+"\\civil\\note\\4th\\Building Drawing" + File.separator + newfileName; //best way
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
				else if(postSubject.equals("Communication English II")) {
					String fileName = postFile.getSubmittedFileName();
					String path=UPLOAD_DIRECTORY+"\\civil\\note\\4th\\Communication English II" + File.separator + fileName; //best way
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
							String newpath=UPLOAD_DIRECTORY+"\\civil\\note\\4th\\Communication English II" + File.separator + newfileName; //best way
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
				else if(postSubject.equals("Structural Analysis I")) {
					String fileName = postFile.getSubmittedFileName();
					String path=UPLOAD_DIRECTORY+"\\civil\\note\\4th\\Structural Analysis I" + File.separator + fileName; //best way
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
							String newpath=UPLOAD_DIRECTORY+"\\civil\\note\\4th\\Structural Analysis I" + File.separator + newfileName; //best way
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
				}else if(postSubject.equals("Building Technology")) {
					String fileName = postFile.getSubmittedFileName();
					String path=UPLOAD_DIRECTORY+"\\civil\\note\\4th\\Building Technology" + File.separator + fileName; //best way
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
							String newpath=UPLOAD_DIRECTORY+"\\civil\\note\\4th\\Building Technology" + File.separator + newfileName; //best way
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

				}else if(postSubject.equals("Hydraulics")) {
					String fileName = postFile.getSubmittedFileName();
					String path=UPLOAD_DIRECTORY+"\\civil\\note\\4th\\Hydraulics" + File.separator + fileName; //best way
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
							String newpath=UPLOAD_DIRECTORY+"\\civil\\note\\4th\\Hydraulics" + File.separator + newfileName; //best way
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

				}else if(postSubject.equals("Probability & Experimental Design")) {
					String fileName = postFile.getSubmittedFileName();
					String path=UPLOAD_DIRECTORY+"\\civil\\note\\4th\\Probability & Experimental Design" + File.separator + fileName; //best way
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
							String newpath=UPLOAD_DIRECTORY+"\\civil\\note\\4th\\Probability & Experimental Design" + File.separator + newfileName; //best way
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
				else if(postSubject.equals("Surveying II")) {
					String fileName = postFile.getSubmittedFileName();
					String path=UPLOAD_DIRECTORY+"\\civil\\note\\4th\\Surveying II" + File.separator + fileName; //best way
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
							String newpath=UPLOAD_DIRECTORY+"\\civil\\note\\4th\\Surveying II" + File.separator + newfileName; //best way
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
			else if(postFaculty.equals("Civil Engineering") && postSemester.equals("5th sem") && postType.equals("Note")) {

				if(postSubject.equals("Structural Analysis II")) {
					String fileName = postFile.getSubmittedFileName();
					String path=UPLOAD_DIRECTORY+"\\civil\\note\\5th\\Structural Analysis II" + File.separator + fileName; //best way
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
							String newpath=UPLOAD_DIRECTORY+"\\civil\\note\\5th\\Structural Analysis II" + File.separator + newfileName; //best way
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
				else if(postSubject.equals("Transportation Engineering")) {
					String fileName = postFile.getSubmittedFileName();
					String path=UPLOAD_DIRECTORY+"\\civil\\note\\5th\\Transportation Engineering" + File.separator + fileName; //best way
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
							String newpath=UPLOAD_DIRECTORY+"\\civil\\note\\5th\\Transportation Engineering" + File.separator + newfileName; //best way
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
				else if(postSubject.equals("Water Supply Engineering")) {
					String fileName = postFile.getSubmittedFileName();
					String path=UPLOAD_DIRECTORY+"\\civil\\note\\5th\\Water Supply Engineering" + File.separator + fileName; //best way
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
							String newpath=UPLOAD_DIRECTORY+"\\civil\\note\\5th\\Water Supply Engineering" + File.separator + newfileName; //best way
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
				}else if(postSubject.equals("Hydrology & River Engineering")) {
					String fileName = postFile.getSubmittedFileName();
					String path=UPLOAD_DIRECTORY+"\\civil\\note\\5th\\Hydrology & River Engineering" + File.separator + fileName; //best way
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
							String newpath=UPLOAD_DIRECTORY+"\\civil\\note\\5th\\Hydrology & River Engineering" + File.separator + newfileName; //best way
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
					String path=UPLOAD_DIRECTORY+"\\civil\\note\\5th\\Engineering Economics" + File.separator + fileName; //best way
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
							String newpath=UPLOAD_DIRECTORY+"\\civil\\note\\5th\\Engineering Economics" + File.separator + newfileName; //best way
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

				}else if(postSubject.equals("Computer Methods in Civil Engineering")) {
					String fileName = postFile.getSubmittedFileName();
					String path=UPLOAD_DIRECTORY+"\\civil\\note\\5th\\Computer Methods in Civil Engineering" + File.separator + fileName; //best way
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
							String newpath=UPLOAD_DIRECTORY+"\\civil\\note\\5th\\Computer Methods in Civil Engineering" + File.separator + newfileName; //best way
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
			else if(postFaculty.equals("Civil Engineering") && postSemester.equals("6th sem") && postType.equals("Note")) {

				if(postSubject.equals("Soil & Rock Mechanics")) {
					String fileName = postFile.getSubmittedFileName();
					String path=UPLOAD_DIRECTORY+"\\civil\\note\\6th\\Soil & Rock Mechanics" + File.separator + fileName; //best way
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
							String newpath=UPLOAD_DIRECTORY+"\\civil\\note\\6th\\Soil & Rock Mechanics" + File.separator + newfileName; //best way
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
				else if(postSubject.equals("Design of Steel & Timber Structure")) {
					String fileName = postFile.getSubmittedFileName();
					String path=UPLOAD_DIRECTORY+"\\civil\\note\\6th\\Design of Steel & Timber Structure" + File.separator + fileName; //best way
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
							String newpath=UPLOAD_DIRECTORY+"\\civil\\note\\6th\\Design of Steel & Timber Structure" + File.separator + newfileName; //best way
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
				else if(postSubject.equals("Concrete Technology & Masonary Structures")) {
					String fileName = postFile.getSubmittedFileName();
					String path=UPLOAD_DIRECTORY+"\\civil\\note\\6th\\Concrete Technology & Masonary Structures" + File.separator + fileName; //best way
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
							String newpath=UPLOAD_DIRECTORY+"\\civil\\note\\6th\\Concrete Technology & Masonary Structures" + File.separator + newfileName; //best way
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
				}else if(postSubject.equals("Airport & Engineering")) {
					String fileName = postFile.getSubmittedFileName();
					String path=UPLOAD_DIRECTORY+"\\civil\\note\\6th\\Airport & Engineering" + File.separator + fileName; //best way
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
							String newpath=UPLOAD_DIRECTORY+"\\civil\\note\\6th\\Airport & Engineering" + File.separator + newfileName; //best way
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
				}else if(postSubject.equals("Irrigation Engineering")) {
					String fileName = postFile.getSubmittedFileName();
					String path=UPLOAD_DIRECTORY+"\\civil\\note\\6th\\Irrigation Engineering" + File.separator + fileName; //best way
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
							String newpath=UPLOAD_DIRECTORY+"\\civil\\note\\6th\\Irrigation Engineering" + File.separator + newfileName; //best way
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

				}else if(postSubject.equals("Estimation, Cost & Valuation")) {
					String fileName = postFile.getSubmittedFileName();
					String path=UPLOAD_DIRECTORY+"\\civil\\note\\6th\\Estimation, Cost & Valuation" + File.separator + fileName; //best way
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
							String newpath=UPLOAD_DIRECTORY+"\\civil\\note\\6th\\Estimation, Cost & Valuation" + File.separator + newfileName; //best way
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
				else if(postSubject.equals("Sanitary & Environmental Engineering")) {
					String fileName = postFile.getSubmittedFileName();
					String path=UPLOAD_DIRECTORY+"\\civil\\note\\6th\\Sanitary & Environmental Engineering" + File.separator + fileName; //best way
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
							String newpath=UPLOAD_DIRECTORY+"\\civil\\note\\6th\\Sanitary & Environmental Engineering" + File.separator + newfileName; //best way
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
			else if(postFaculty.equals("Civil Engineering") && postSemester.equals("7th sem") && postType.equals("Note")) {

				if(postSubject.equals("Design of RCC Structure")) {
					String fileName = postFile.getSubmittedFileName();
					String path=UPLOAD_DIRECTORY+"\\civil\\note\\7th\\Design of RCC Structure" + File.separator + fileName; //best way
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
							String newpath=UPLOAD_DIRECTORY+"\\civil\\note\\7th\\Design of RCC Structure" + File.separator + newfileName; //best way
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
				else if(postSubject.equals("Hydropower Engineering")) {
					String fileName = postFile.getSubmittedFileName();
					String path=UPLOAD_DIRECTORY+"\\civil\\note\\7th\\Hydropower Engineering" + File.separator + fileName; //best way
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
							String newpath=UPLOAD_DIRECTORY+"\\civil\\note\\7th\\Hydropower Engineering" + File.separator + newfileName; //best way
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
				else if(postSubject.equals("Foundation Engineering")) {
					String fileName = postFile.getSubmittedFileName();
					String path=UPLOAD_DIRECTORY+"\\civil\\note\\7th\\Foundation Engineering" + File.separator + fileName; //best way
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
							String newpath=UPLOAD_DIRECTORY+"\\civil\\note\\7th\\Foundation Engineering" + File.separator + newfileName; //best way
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
				}else if(postSubject.equals("Safety Engineering")) {
					String fileName = postFile.getSubmittedFileName();
					String path=UPLOAD_DIRECTORY+"\\civil\\note\\7th\\Safety Engineering" + File.separator + fileName; //best way
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
							String newpath=UPLOAD_DIRECTORY+"\\civil\\note\\7th\\Safety Engineering" + File.separator + newfileName; //best way
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
				}else if(postSubject.equals("Minor Project")) {
					String fileName = postFile.getSubmittedFileName();
					String path=UPLOAD_DIRECTORY+"\\civil\\note\\7th\\Minor Project" + File.separator + fileName; //best way
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
							String newpath=UPLOAD_DIRECTORY+"\\civil\\note\\7th\\Minor Project" + File.separator + newfileName; //best way
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
				}else if(postSubject.equals("Elective I")) {
					String fileName = postFile.getSubmittedFileName();
					String path=UPLOAD_DIRECTORY+"\\civil\\note\\7th\\Elective I" + File.separator + fileName; //best way
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
							String newpath=UPLOAD_DIRECTORY+"\\civil\\note\\7th\\Elective I" + File.separator + newfileName; //best way
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
				else if(postSubject.equals("Elective II")) {
					String fileName = postFile.getSubmittedFileName();
					String path=UPLOAD_DIRECTORY+"\\civil\\note\\7th\\Elective II" + File.separator + fileName; //best way
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
							String newpath=UPLOAD_DIRECTORY+"\\civil\\note\\7th\\Elective II" + File.separator + newfileName; //best way
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
			else if(postFaculty.equals("Civil Engineering") && postSemester.equals("8th sem") && postType.equals("Note")) {
				if(postSubject.equals("RS & GIS Application to Engineering")) {
					String fileName = postFile.getSubmittedFileName();
					String path=UPLOAD_DIRECTORY+"\\civil\\note\\8th\\RS & GIS Application to Engineering" + File.separator + fileName; //best way
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
							String newpath=UPLOAD_DIRECTORY+"\\civil\\note\\8th\\RS & GIS Application to Engineering" + File.separator + newfileName; //best way
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
				else if(postSubject.equals("Construction Management & Project Engineering")) {
					String fileName = postFile.getSubmittedFileName();
					String path=UPLOAD_DIRECTORY+"\\civil\\note\\8th\\Construction Management & Project Engineering" + File.separator + fileName; //best way
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
							String newpath=UPLOAD_DIRECTORY+"\\civil\\note\\8th\\Construction Management & Project Engineering" + File.separator + newfileName; //best way
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
				else if(postSubject.equals("Engineering Professional Practice & Society")) {
					String fileName = postFile.getSubmittedFileName();
					String path=UPLOAD_DIRECTORY+"\\civil\\note\\8th\\Engineering Professional Practice & Society" + File.separator + fileName; //best way
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
							String newpath=UPLOAD_DIRECTORY+"\\civil\\note\\8th\\Engineering Professional Practice & Society" + File.separator + newfileName; //best way
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
				}else if(postSubject.equals("Major Project")) {
					String fileName = postFile.getSubmittedFileName();
					String path=UPLOAD_DIRECTORY+"\\civil\\note\\8th\\Major Project" + File.separator + fileName; //best way
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
							String newpath=UPLOAD_DIRECTORY+"\\civil\\note\\8th\\Major Project" + File.separator + newfileName; //best way
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
				}else if(postSubject.equals("Elective III")) {
					String fileName = postFile.getSubmittedFileName();
					String path=UPLOAD_DIRECTORY+"\\civil\\note\\8th\\Elective III" + File.separator + fileName; //best way
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
							String newpath=UPLOAD_DIRECTORY+"\\civil\\note\\8th\\Elective III" + File.separator + newfileName; //best way
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

				}else if(postSubject.equals("Elective IV")) {
					String fileName = postFile.getSubmittedFileName();
					String path=UPLOAD_DIRECTORY+"\\civil\\note\\8th\\Elective IV" + File.separator + fileName; //best way
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
							String newpath=UPLOAD_DIRECTORY+"\\civil\\note\\8th\\Elective IV" + File.separator + newfileName; //best way
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
			
			
			//Section 1: For Civil->Add Question collection
		

			//All Sem
			else if(postFaculty.equals("Civil Engineering") && postSemester.equals("1st sem") || postSemester.equals("2nd sem") || postSemester.equals("3rd sem") || postSemester.equals("4th sem") || postSemester.equals("5th sem") || postSemester.equals("6th sem") || postSemester.equals("7th sem") || postSemester.equals("8th sem") && postType.equals("Question collection")) {

				String fileName = postFile.getSubmittedFileName();
				String path=UPLOAD_DIRECTORY+"\\civil\\oldisgold" + File.separator + fileName; //best way
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
						String newpath=UPLOAD_DIRECTORY+"\\civil\\oldisgold" + File.separator + newfileName; //best way
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
