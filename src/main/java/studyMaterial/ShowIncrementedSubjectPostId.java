package studyMaterial;

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
 * Servlet implementation class ShowIncrementedSubjectPostId
 */
@WebServlet("/ShowIncrementedSubjectPostId")
public class ShowIncrementedSubjectPostId extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ShowIncrementedSubjectPostId() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String semaction=request.getParameter("semAction");
		Connection con=ConnectionProvider.getCon();

		ResultSet rs=null;
		PreparedStatement ps=null;
		String resultMessage = " ";

		try {
			
			//Section 1: For civil
			
			ps= con.prepareStatement("select id from studymaterial",
					ResultSet.TYPE_SCROLL_SENSITIVE, 
					ResultSet.CONCUR_UPDATABLE); // For moving resultset pointer anywhere i.e. Forward or Backward

			// for Add subject button produce auto increment id in next page

			if(semaction.equals("civil1stAdd")) {

				rs = ps.executeQuery();
				int id;
				if(rs.next()==false) {  //if no data in resultset then make id=1
					id=1;

					request.setAttribute("incrementedPostId",+id); 

					request.setAttribute("semester","1st sem"); 

					request.setAttribute("s1","Engineering Mathematics I"); 
					request.setAttribute("s2","Basic Programming & Data Structure"); 
					request.setAttribute("s3","Engineering Chemistry"); 
					request.setAttribute("s4","Engineering Drawing I"); 
					request.setAttribute("s5","English for Communication"); 
					request.setAttribute("s6","Electricity & Magnetism"); 




					RequestDispatcher requestDispatcher = request.getRequestDispatcher("/AdminManagePages/addpostcivilstudymaterial.jsp");
					requestDispatcher.forward(request, response);
				}

				else { //minimum one row or more in resultset present
					rs.beforeFirst();//means resultset at null position
					while(rs.next()) {//moves resultset pointer to 1st position and repeate until condition meet
						if(rs.isLast())
						{
							id=rs.getInt("id")+1;
							request.setAttribute("incrementedPostId",+id);    

							request.setAttribute("semester","1st sem"); 

							request.setAttribute("s1","Engineering Mathematics I"); 
							request.setAttribute("s2","Basic Programming & Data Structure"); 
							request.setAttribute("s3","Engineering Chemistry"); 
							request.setAttribute("s4","Engineering Drawing I"); 
							request.setAttribute("s5","English for Communication"); 
							request.setAttribute("s6","Electricity & Magnetism"); 


							RequestDispatcher requestDispatcher = request.getRequestDispatcher("/AdminManagePages/addpostcivilstudymaterial.jsp");
							requestDispatcher.forward(request, response);

							break;

						}
					}
				}
			}
			else if(semaction.equals("civil2ndAdd")) {

				rs = ps.executeQuery();
				int id;
				if(rs.next()==false) {  //if no data in resultset then make id=1
					id=1;

					request.setAttribute("incrementedPostId",+id); 

					request.setAttribute("semester","2nd sem"); 

					request.setAttribute("s1","Object Oriented Programming"); 
					request.setAttribute("s2","Fundamentals of Thermodynamics & Heat Transfer"); 
					request.setAttribute("s3","Engineering Mathematics II"); 
					request.setAttribute("s4","Engineering Drawing II"); 
					request.setAttribute("s5","Study Skills in English for Academic Purposes"); 
					request.setAttribute("s6","Mechanics & Optics"); 




					RequestDispatcher requestDispatcher = request.getRequestDispatcher("/AdminManagePages/addpostcivilstudymaterial.jsp");
					requestDispatcher.forward(request, response);
				}

				else { //minimum one row or more in resultset present
					rs.beforeFirst();//means resultset at null position
					while(rs.next()) {//moves resultset pointer to 1st position and repeate until condition meet
						if(rs.isLast())
						{
							id=rs.getInt("id")+1;
							request.setAttribute("incrementedPostId",+id);    

							request.setAttribute("semester","2nd sem"); 

							request.setAttribute("s1","Object Oriented Programming"); 
							request.setAttribute("s2","Fundamentals of Thermodynamics & Heat Transfer"); 
							request.setAttribute("s3","Engineering Mathematics II"); 
							request.setAttribute("s4","Engineering Drawing II"); 
							request.setAttribute("s5","Study Skills in English for Academic Purposes"); 
							request.setAttribute("s6","Mechanics & Optics"); 



							RequestDispatcher requestDispatcher = request.getRequestDispatcher("/AdminManagePages/addpostcivilstudymaterial.jsp");
							requestDispatcher.forward(request, response);

							break;

						}
					}
				}
			}

			else if(semaction.equals("civil3rdAdd")) {

				rs = ps.executeQuery();
				int id;
				if(rs.next()==false) {  //if no data in resultset then make id=1
					id=1;

					request.setAttribute("incrementedPostId",+id); 

					request.setAttribute("semester","3rd sem"); 

					request.setAttribute("s1","Basic Mechanical Engineering"); 
					request.setAttribute("s2","Basic Electrical & Electronics Engineering"); 
					request.setAttribute("s3","Engineering Geology"); 
					request.setAttribute("s4","Engineering Mathematics III"); 
					request.setAttribute("s5","Strength of Materials"); 
					request.setAttribute("s6","Surveying I"); 




					RequestDispatcher requestDispatcher = request.getRequestDispatcher("/AdminManagePages/addpostcivilstudymaterial.jsp");
					requestDispatcher.forward(request, response);
				}

				else { //minimum one row or more in resultset present
					rs.beforeFirst();//means resultset at null position
					while(rs.next()) {//moves resultset pointer to 1st position and repeate until condition meet
						if(rs.isLast())
						{
							id=rs.getInt("id")+1;
							request.setAttribute("incrementedPostId",+id);    

							request.setAttribute("semester","3rd sem"); 

							request.setAttribute("s1","Basic Mechanical Engineering"); 
							request.setAttribute("s2","Basic Electrical & Electronics Engineering"); 
							request.setAttribute("s3","Engineering Geology"); 
							request.setAttribute("s4","Engineering Mathematics III"); 
							request.setAttribute("s5","Strength of Materials"); 
							request.setAttribute("s6","Surveying I"); 


							RequestDispatcher requestDispatcher = request.getRequestDispatcher("/AdminManagePages/addpostcivilstudymaterial.jsp");
							requestDispatcher.forward(request, response);

							break;

						}
					}
				}
			}

			else if(semaction.equals("civil4thAdd")) {

				rs = ps.executeQuery();
				int id;
				if(rs.next()==false) {  //if no data in resultset then make id=1
					id=1;

					request.setAttribute("incrementedPostId",+id); 

					request.setAttribute("semester","4th sem"); 

					request.setAttribute("s1","Building Drawing"); 
					request.setAttribute("s2","Communication English II"); 
					request.setAttribute("s3","Structural Analysis I"); 
					request.setAttribute("s4","Building Technology"); 
					request.setAttribute("s5","Hydraulics"); 
					request.setAttribute("s6","Probability & Experimental Design"); 
					request.setAttribute("s7","Surveying II"); 



					RequestDispatcher requestDispatcher = request.getRequestDispatcher("/AdminManagePages/addpostcivilstudymaterial.jsp");
					requestDispatcher.forward(request, response);
				}

				else { //minimum one row or more in resultset present
					rs.beforeFirst();//means resultset at null position
					while(rs.next()) {//moves resultset pointer to 1st position and repeate until condition meet
						if(rs.isLast())
						{
							id=rs.getInt("id")+1;
							request.setAttribute("incrementedPostId",+id);    

							request.setAttribute("semester","4th sem"); 

							request.setAttribute("s1","Building Drawing"); 
							request.setAttribute("s2","Communication English II"); 
							request.setAttribute("s3","Structural Analysis I"); 
							request.setAttribute("s4","Building Technology"); 
							request.setAttribute("s5","Hydraulics"); 
							request.setAttribute("s6","Probability & Experimental Design"); 
							request.setAttribute("s7","Surveying II"); 


							RequestDispatcher requestDispatcher = request.getRequestDispatcher("/AdminManagePages/addpostcivilstudymaterial.jsp");
							requestDispatcher.forward(request, response);

							break;

						}
					}
				}
			}
			else if(semaction.equals("civil5thAdd")) {

				rs = ps.executeQuery();
				int id;
				if(rs.next()==false) {  //if no data in resultset then make id=1
					id=1;

					request.setAttribute("incrementedPostId",+id); 

					request.setAttribute("semester","5th sem"); 

					request.setAttribute("s1","Structural Analysis II"); 
					request.setAttribute("s2","Transportation Engineering"); 
					request.setAttribute("s3","Water Supply Engineering"); 
					request.setAttribute("s4","Hydrology & River Engineering"); 
					request.setAttribute("s5","Engineering Economics"); 
					request.setAttribute("s6","Computer Methods in Civil Engineering"); 



					RequestDispatcher requestDispatcher = request.getRequestDispatcher("/AdminManagePages/addpostcivilstudymaterial.jsp");
					requestDispatcher.forward(request, response);
				}

				else { //minimum one row or more in resultset present
					rs.beforeFirst();//means resultset at null position
					while(rs.next()) {//moves resultset pointer to 1st position and repeate until condition meet
						if(rs.isLast())
						{
							id=rs.getInt("id")+1;
							request.setAttribute("incrementedPostId",+id);    

							request.setAttribute("semester","5th sem"); 

							request.setAttribute("s1","Structural Analysis II"); 
							request.setAttribute("s2","Transportation Engineering"); 
							request.setAttribute("s3","Water Supply Engineering"); 
							request.setAttribute("s4","Hydrology & River Engineering"); 
							request.setAttribute("s5","Engineering Economics"); 
							request.setAttribute("s6","Computer Methods in Civil Engineering"); 


							RequestDispatcher requestDispatcher = request.getRequestDispatcher("/AdminManagePages/addpostcivilstudymaterial.jsp");
							requestDispatcher.forward(request, response);

							break;

						}
					}
				}
			}

			else if(semaction.equals("civil6thAdd")) {

				rs = ps.executeQuery();
				int id;
				if(rs.next()==false) {  //if no data in resultset then make id=1
					id=1;

					request.setAttribute("incrementedPostId",+id); 

					request.setAttribute("semester","6th sem"); 

					request.setAttribute("s1","Soil & Rock Mechanics"); 
					request.setAttribute("s2","Design of Steel & Timber Structure"); 
					request.setAttribute("s3","Concrete Technology & Masonary Structures"); 
					request.setAttribute("s4","Airport & Engineering"); 
					request.setAttribute("s5","Irrigation Engineering"); 
					request.setAttribute("s6","Estimation, Cost & Valuation"); 
					request.setAttribute("s7","Sanitary & Environmental Engineering"); 


					RequestDispatcher requestDispatcher = request.getRequestDispatcher("/AdminManagePages/addpostcivilstudymaterial.jsp");
					requestDispatcher.forward(request, response);
				}

				else { //minimum one row or more in resultset present
					rs.beforeFirst();//means resultset at null position
					while(rs.next()) {//moves resultset pointer to 1st position and repeate until condition meet
						if(rs.isLast())
						{
							id=rs.getInt("id")+1;
							request.setAttribute("incrementedPostId",+id);    

							request.setAttribute("semester","6th sem"); 

							request.setAttribute("s1","Soil & Rock Mechanics"); 
							request.setAttribute("s2","Design of Steel & Timber Structure"); 
							request.setAttribute("s3","Concrete Technology & Masonary Structures"); 
							request.setAttribute("s4","Airport & Engineering"); 
							request.setAttribute("s5","Irrigation Engineering"); 
							request.setAttribute("s6","Estimation, Cost & Valuation"); 
							request.setAttribute("s7","Sanitary & Environmental Engineering"); 



							RequestDispatcher requestDispatcher = request.getRequestDispatcher("/AdminManagePages/addpostcivilstudymaterial.jsp");
							requestDispatcher.forward(request, response);

							break;

						}
					}
				}
			}
			//civil 7th
			else if(semaction.equals("civil7thAdd")) {

				rs = ps.executeQuery();
				int id;
				if(rs.next()==false) {  //if no data in resultset then make id=1
					id=1;

					request.setAttribute("incrementedPostId",+id); 

					request.setAttribute("semester","7th sem"); 

					request.setAttribute("s1","Design of RCC Structure"); 
					request.setAttribute("s2","Hydropower Engineering"); 
					request.setAttribute("s3","Foundation Engineering"); 
					request.setAttribute("s4","Safety Engineering"); 
					request.setAttribute("s5","Minor Project"); 
					request.setAttribute("s6","Elective I"); 
					request.setAttribute("s7","Elective II"); 


					RequestDispatcher requestDispatcher = request.getRequestDispatcher("/AdminManagePages/addpostcivilstudymaterial.jsp");
					requestDispatcher.forward(request, response);
				}

				else { //minimum one row or more in resultset present
					rs.beforeFirst();//means resultset at null position
					while(rs.next()) {//moves resultset pointer to 1st position and repeate until condition meet
						if(rs.isLast())
						{
							id=rs.getInt("id")+1;
							request.setAttribute("incrementedPostId",+id);    

							request.setAttribute("semester","7th sem"); 

							request.setAttribute("s1","Design of RCC Structure"); 
							request.setAttribute("s2","Hydropower Engineering"); 
							request.setAttribute("s3","Foundation Engineering"); 
							request.setAttribute("s4","Safety Engineering"); 
							request.setAttribute("s5","Minor Project"); 
							request.setAttribute("s6","Elective I"); 
							request.setAttribute("s7","Elective II"); 



							RequestDispatcher requestDispatcher = request.getRequestDispatcher("/AdminManagePages/addpostcivilstudymaterial.jsp");
							requestDispatcher.forward(request, response);

							break;

						}
					}
				}
			}


			//civil 8th
			else if(semaction.equals("civil8thAdd")) {

				rs = ps.executeQuery();
				int id;
				if(rs.next()==false) {  //if no data in resultset then make id=1
					id=1;

					request.setAttribute("incrementedPostId",+id); 

					request.setAttribute("semester","8th sem"); 

					request.setAttribute("s1","RS & GIS Application to Engineering"); 
					request.setAttribute("s2","Construction Management & Project Engineering"); 
					request.setAttribute("s3","Engineering Professional Practice & Society"); 
					request.setAttribute("s4","Major Project"); 
					request.setAttribute("s5","Elective III"); 
					request.setAttribute("s6","Elective IV"); 


					RequestDispatcher requestDispatcher = request.getRequestDispatcher("/AdminManagePages/addpostcivilstudymaterial.jsp");
					requestDispatcher.forward(request, response);
				}

				else { //minimum one row or more in resultset present
					rs.beforeFirst();//means resultset at null position
					while(rs.next()) {//moves resultset pointer to 1st position and repeate until condition meet
						if(rs.isLast())
						{
							id=rs.getInt("id")+1;
							request.setAttribute("incrementedPostId",+id);    

							request.setAttribute("semester","8th sem"); 

							request.setAttribute("s1","RS & GIS Application to Engineering"); 
							request.setAttribute("s2","Construction Management & Project Engineering"); 
							request.setAttribute("s3","Engineering Professional Practice & Society"); 
							request.setAttribute("s4","Major Project"); 
							request.setAttribute("s5","Elective III"); 
							request.setAttribute("s6","Elective IV"); 




							RequestDispatcher requestDispatcher = request.getRequestDispatcher("/AdminManagePages/addpostcivilstudymaterial.jsp");
							requestDispatcher.forward(request, response);

							break;

						}
					}
				}
			}

			
			//Section 2: For Computer
			else if(semaction.equals("computer1stAdd")) {

				rs = ps.executeQuery();
				int id;
				if(rs.next()==false) {  //if no data in resultset then make id=1
					id=1;

					request.setAttribute("incrementedPostId",+id); 

					request.setAttribute("semester","1st sem"); 

					request.setAttribute("s1","Engineering Drawing"); 
					request.setAttribute("s2","Engineering Math I"); 
					request.setAttribute("s3","Engineering Physics"); 
					request.setAttribute("s4","Basic Electrical Engineering"); 
					request.setAttribute("s5","Programming in C"); 
					request.setAttribute("s6","Workshop Technology"); 




					RequestDispatcher requestDispatcher = request.getRequestDispatcher("/AdminManagePages/addpostcomputerstudymaterial.jsp");
					requestDispatcher.forward(request, response);
				}

				else { //minimum one row or more in resultset present
					rs.beforeFirst();//means resultset at null position
					while(rs.next()) {//moves resultset pointer to 1st position and repeate until condition meet
						if(rs.isLast())
						{
							id=rs.getInt("id")+1;
							request.setAttribute("incrementedPostId",+id);    

							request.setAttribute("semester","1st sem"); 

							request.setAttribute("s1","Engineering Drawing"); 
							request.setAttribute("s2","Engineering Math I"); 
							request.setAttribute("s3","Engineering Physics"); 
							request.setAttribute("s4","Basic Electrical Engineering"); 
							request.setAttribute("s5","Programming in C"); 
							request.setAttribute("s6","Workshop Technology"); 


							RequestDispatcher requestDispatcher = request.getRequestDispatcher("/AdminManagePages/addpostcomputerstudymaterial.jsp");
							requestDispatcher.forward(request, response);

							break;

						}
					}
				}
			}
			else if(semaction.equals("computer2ndAdd")) {

				rs = ps.executeQuery();
				int id;
				if(rs.next()==false) {  //if no data in resultset then make id=1
					id=1;

					request.setAttribute("incrementedPostId",+id); 

					request.setAttribute("semester","2nd sem"); 

					request.setAttribute("s1","Engineering Math II"); 
					request.setAttribute("s2","Engineering Chemistry"); 
					request.setAttribute("s3","Thermodynamics"); 
					request.setAttribute("s4","Applied Mechanics"); 
					request.setAttribute("s5","Object Oriented Programming"); 
					request.setAttribute("s6","Discrete Structure"); 




					RequestDispatcher requestDispatcher = request.getRequestDispatcher("/AdminManagePages/addpostcomputerstudymaterial.jsp");
					requestDispatcher.forward(request, response);
				}

				else { //minimum one row or more in resultset present
					rs.beforeFirst();//means resultset at null position
					while(rs.next()) {//moves resultset pointer to 1st position and repeate until condition meet
						if(rs.isLast())
						{
							id=rs.getInt("id")+1;
							request.setAttribute("incrementedPostId",+id);    

							request.setAttribute("semester","2nd sem"); 

							request.setAttribute("s1","Engineering Math II"); 
							request.setAttribute("s2","Engineering Chemistry"); 
							request.setAttribute("s3","Thermodynamics"); 
							request.setAttribute("s4","Applied Mechanics"); 
							request.setAttribute("s5","Object Oriented Programming"); 
							request.setAttribute("s6","Discrete Structure"); 



							RequestDispatcher requestDispatcher = request.getRequestDispatcher("/AdminManagePages/addpostcomputerstudymaterial.jsp");
							requestDispatcher.forward(request, response);

							break;

						}
					}
				}
			}
			else if(semaction.equals("computer3rdAdd")) {

				rs = ps.executeQuery();
				int id;
				if(rs.next()==false) {  //if no data in resultset then make id=1
					id=1;

					request.setAttribute("incrementedPostId",+id); 

					request.setAttribute("semester","3rd sem"); 

					request.setAttribute("s1","Engineering Math III"); 
					request.setAttribute("s2","Data Structure & Algorithm"); 
					request.setAttribute("s3","Theory of Computation"); 
					request.setAttribute("s4","Electrical Circuit Theory"); 
					request.setAttribute("s5","Digital Logic"); 
					request.setAttribute("s6","Electromagnetics"); 




					RequestDispatcher requestDispatcher = request.getRequestDispatcher("/AdminManagePages/addpostcomputerstudymaterial.jsp");
					requestDispatcher.forward(request, response);
				}

				else { //minimum one row or more in resultset present
					rs.beforeFirst();//means resultset at null position
					while(rs.next()) {//moves resultset pointer to 1st position and repeate until condition meet
						if(rs.isLast())
						{
							id=rs.getInt("id")+1;
							request.setAttribute("incrementedPostId",+id);    

							request.setAttribute("semester","3rd sem"); 

							request.setAttribute("s1","Engineering Math III"); 
							request.setAttribute("s2","Data Structure & Algorithm"); 
							request.setAttribute("s3","Theory of Computation"); 
							request.setAttribute("s4","Electrical Circuit Theory"); 
							request.setAttribute("s5","Digital Logic"); 
							request.setAttribute("s6","Electromagnetics"); 

							RequestDispatcher requestDispatcher = request.getRequestDispatcher("/AdminManagePages/addpostcomputerstudymaterial.jsp");
							requestDispatcher.forward(request, response);

							break;

						}
					}
				}
			}
			else if(semaction.equals("computer4thAdd")) {

				rs = ps.executeQuery();
				int id;
				if(rs.next()==false) {  //if no data in resultset then make id=1
					id=1;

					request.setAttribute("incrementedPostId",+id); 

					request.setAttribute("semester","4th sem"); 

					request.setAttribute("s1","Applied Mathematics"); 
					request.setAttribute("s2","Microprocessor"); 
					request.setAttribute("s3","Algorithmic Mathematics"); 
					request.setAttribute("s4","Electrical Machine"); 
					request.setAttribute("s5","Electronic Device & Circuit"); 
					request.setAttribute("s6","Communication English"); 




					RequestDispatcher requestDispatcher = request.getRequestDispatcher("/AdminManagePages/addpostcomputerstudymaterial.jsp");
					requestDispatcher.forward(request, response);
				}

				else { //minimum one row or more in resultset present
					rs.beforeFirst();//means resultset at null position
					while(rs.next()) {//moves resultset pointer to 1st position and repeate until condition meet
						if(rs.isLast())
						{
							id=rs.getInt("id")+1;
							request.setAttribute("incrementedPostId",+id);    

							request.setAttribute("semester","4th sem"); 

							request.setAttribute("s1","Applied Mathematics"); 
							request.setAttribute("s2","Microprocessor"); 
							request.setAttribute("s3","Algorithmic Mathematics"); 
							request.setAttribute("s4","Electrical Machine"); 
							request.setAttribute("s5","Electronic Device & Circuit"); 
							request.setAttribute("s6","Communication English"); 

							RequestDispatcher requestDispatcher = request.getRequestDispatcher("/AdminManagePages/addpostcomputerstudymaterial.jsp");
							requestDispatcher.forward(request, response);

							break;

						}
					}
				}
			}
			else if(semaction.equals("computer5thAdd")) {

				rs = ps.executeQuery();
				int id;
				if(rs.next()==false) {  //if no data in resultset then make id=1
					id=1;

					request.setAttribute("incrementedPostId",+id); 

					request.setAttribute("semester","5th sem"); 

					request.setAttribute("s1","Probability & Statistic"); 
					request.setAttribute("s2","Instrumentation"); 
					request.setAttribute("s3","Computer Graphics"); 
					request.setAttribute("s4","Object Oriented Software Engineering"); 
					request.setAttribute("s5","Computer Architecture & Design"); 
					request.setAttribute("s6","Operating System"); 




					RequestDispatcher requestDispatcher = request.getRequestDispatcher("/AdminManagePages/addpostcomputerstudymaterial.jsp");
					requestDispatcher.forward(request, response);
				}

				else { //minimum one row or more in resultset present
					rs.beforeFirst();//means resultset at null position
					while(rs.next()) {//moves resultset pointer to 1st position and repeate until condition meet
						if(rs.isLast())
						{
							id=rs.getInt("id")+1;
							request.setAttribute("incrementedPostId",+id);    

							request.setAttribute("semester","5th sem"); 
							request.setAttribute("s1","Probability & Statistic"); 
							request.setAttribute("s2","Instrumentation"); 
							request.setAttribute("s3","Computer Graphics"); 
							request.setAttribute("s4","Object Oriented Software Engineering"); 
							request.setAttribute("s5","Computer Architecture & Design"); 
							request.setAttribute("s6","Operating System"); 

							RequestDispatcher requestDispatcher = request.getRequestDispatcher("/AdminManagePages/addpostcomputerstudymaterial.jsp");
							requestDispatcher.forward(request, response);

							break;

						}
					}
				}
			}
			else if(semaction.equals("computer6thAdd")) {

				rs = ps.executeQuery();
				int id;
				if(rs.next()==false) {  //if no data in resultset then make id=1
					id=1;

					request.setAttribute("incrementedPostId",+id); 

					request.setAttribute("semester","6th sem"); 

					request.setAttribute("s1","Project & Organization Management"); 
					request.setAttribute("s2","Research Methodology"); 
					request.setAttribute("s3","Artificial Intelligence"); 
					request.setAttribute("s4","Database Management System"); 
					request.setAttribute("s5","Communication System"); 
					request.setAttribute("s6","Engineering Economics"); 
					request.setAttribute("s7","Minor Project"); 


					RequestDispatcher requestDispatcher = request.getRequestDispatcher("/AdminManagePages/addpostcomputerstudymaterial.jsp");
					requestDispatcher.forward(request, response);
				}

				else { //minimum one row or more in resultset present
					rs.beforeFirst();//means resultset at null position
					while(rs.next()) {//moves resultset pointer to 1st position and repeate until condition meet
						if(rs.isLast())
						{
							id=rs.getInt("id")+1;
							request.setAttribute("incrementedPostId",+id);    

							request.setAttribute("semester","6th sem"); 
							request.setAttribute("s1","Project & Organization Management"); 
							request.setAttribute("s2","Research Methodology"); 
							request.setAttribute("s3","Artificial Intelligence"); 
							request.setAttribute("s4","Database Management System"); 
							request.setAttribute("s5","Communication System"); 
							request.setAttribute("s6","Engineering Economics"); 
							request.setAttribute("s7","Minor Project"); 


							RequestDispatcher requestDispatcher = request.getRequestDispatcher("/AdminManagePages/addpostcomputerstudymaterial.jsp");
							requestDispatcher.forward(request, response);

							break;

						}
					}
				}
			}
			else if(semaction.equals("computer7thAdd")) {

				rs = ps.executeQuery();
				int id;
				if(rs.next()==false) {  //if no data in resultset then make id=1
					id=1;

					request.setAttribute("incrementedPostId",+id); 

					request.setAttribute("semester","7th sem"); 

					request.setAttribute("s1","Computer Networks"); 
					request.setAttribute("s2","Distributed Computing"); 
					request.setAttribute("s3","Information System"); 
					request.setAttribute("s4","Data Mining & Data Warehousing"); 
					request.setAttribute("s5","Simulation & Modeling"); 
					request.setAttribute("s6","Elective-I"); 
					request.setAttribute("s7","Project-Part A"); 


					RequestDispatcher requestDispatcher = request.getRequestDispatcher("/AdminManagePages/addpostcomputerstudymaterial.jsp");
					requestDispatcher.forward(request, response);
				}

				else { //minimum one row or more in resultset present
					rs.beforeFirst();//means resultset at null position
					while(rs.next()) {//moves resultset pointer to 1st position and repeate until condition meet
						if(rs.isLast())
						{
							id=rs.getInt("id")+1;
							request.setAttribute("incrementedPostId",+id);    

							request.setAttribute("semester","7th sem"); 
							request.setAttribute("s1","Computer Networks"); 
							request.setAttribute("s2","Distributed Computing"); 
							request.setAttribute("s3","Information System"); 
							request.setAttribute("s4","Data Mining & Data Warehousing"); 
							request.setAttribute("s5","Simulation & Modeling"); 
							request.setAttribute("s6","Elective-I"); 
							request.setAttribute("s7","Project-Part A"); 



							RequestDispatcher requestDispatcher = request.getRequestDispatcher("/AdminManagePages/addpostcomputerstudymaterial.jsp");
							requestDispatcher.forward(request, response);

							break;

						}
					}
				}
			}

			else if(semaction.equals("computer8thAdd")) {

				rs = ps.executeQuery();
				int id;
				if(rs.next()==false) {  //if no data in resultset then make id=1
					id=1;

					request.setAttribute("incrementedPostId",+id); 

					request.setAttribute("semester","8th sem"); 

					request.setAttribute("s1","Digital Signal Analysis & Processing"); 
					request.setAttribute("s2","Engineering Professional Practice"); 
					request.setAttribute("s3","Information Security"); 
					request.setAttribute("s4","Big Data"); 
					request.setAttribute("s5","Elective-II"); 
					request.setAttribute("s6","Project-Part B"); 


					RequestDispatcher requestDispatcher = request.getRequestDispatcher("/AdminManagePages/addpostcomputerstudymaterial.jsp");
					requestDispatcher.forward(request, response);
				}

				else { //minimum one row or more in resultset present
					rs.beforeFirst();//means resultset at null position
					while(rs.next()) {//moves resultset pointer to 1st position and repeate until condition meet
						if(rs.isLast())
						{
							id=rs.getInt("id")+1;
							request.setAttribute("incrementedPostId",+id);    

							request.setAttribute("semester","8th sem"); 
							request.setAttribute("s1","Digital Signal Analysis & Processing"); 
							request.setAttribute("s2","Engineering Professional Practice"); 
							request.setAttribute("s3","Information Security"); 
							request.setAttribute("s4","Big Data"); 
							request.setAttribute("s5","Elective-II"); 
							request.setAttribute("s6","Project-Part B"); 



							RequestDispatcher requestDispatcher = request.getRequestDispatcher("/AdminManagePages/addpostcomputerstudymaterial.jsp");
							requestDispatcher.forward(request, response);

							break;

						}
					}
				}
			}


			
			//Section 3: For Entrance 
			
			
			else if(semaction.equals("entranceAdd")) {

				rs = ps.executeQuery();
				int id;
				if(rs.next()==false) {  //if no data in resultset then make id=1
					id=1;

					request.setAttribute("incrementedPostId",+id); 


					request.setAttribute("s1","English");
					request.setAttribute("s2","Chemistry"); 
					request.setAttribute("s3","Physics"); 
					request.setAttribute("s4","Mathematics"); 
					
					RequestDispatcher requestDispatcher = request.getRequestDispatcher("/AdminManagePages/addpostentrancestudymaterial.jsp");
					requestDispatcher.forward(request, response);
				}

				else { //minimum one row or more in resultset present
					rs.beforeFirst();//means resultset at null position
					while(rs.next()) {//moves resultset pointer to 1st position and repeate until condition meet
						if(rs.isLast())
						{
							id=rs.getInt("id")+1;
							request.setAttribute("incrementedPostId",+id);    

							
							request.setAttribute("s1","English");
							request.setAttribute("s2","Chemistry"); 
							request.setAttribute("s3","Physics"); 
							request.setAttribute("s4","Mathematics"); 
							
							RequestDispatcher requestDispatcher = request.getRequestDispatcher("/AdminManagePages/addpostentrancestudymaterial.jsp");
							requestDispatcher.forward(request, response);
							break;

						}
					}
				}
			}

			else {
				resultMessage = "You are entering without semester action taken.";

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
