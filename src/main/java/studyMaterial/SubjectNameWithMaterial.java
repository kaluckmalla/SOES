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
 * Servlet implementation class SubjectNameWithMaterial
 */
@WebServlet("/SubjectNameWithMaterial")
public class SubjectNameWithMaterial extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SubjectNameWithMaterial() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String type=request.getParameter("type");
		Connection con=ConnectionProvider.getCon();

		ResultSet rs=null;
		PreparedStatement ps=null;
		String resultMessage = " ";

		try {
			ps=con.prepareStatement("select * from studymaterial");
			rs=ps.executeQuery();

			//For Civil Book
			if(type.equals("civilB1st")) {

				request.setAttribute("semHead","1st semester books"); //for  top search name

				//matching with database
				request.setAttribute("selectionType","Book"); 
				request.setAttribute("selectionFaculty","Civil Engineering"); 


				//for searching in file server
				request.setAttribute("faculty","civil"); 
				request.setAttribute("type","book"); 
				request.setAttribute("semester","1st"); 

				request.setAttribute("s1","Engineering Mathematics I"); 
				request.setAttribute("s2","Basic Programming & Data Structure"); 
				request.setAttribute("s3","Engineering Chemistry"); 
				request.setAttribute("s4","Engineering Drawing I"); 
				request.setAttribute("s5","English for Communication"); 
				request.setAttribute("s6","Electricity & Magnetism"); 

				RequestDispatcher requestDispatcher = request.getRequestDispatcher("subjectmaterial.jsp");
				requestDispatcher.forward(request, response);

			}
			else if(type.equals("civilB2nd")) {

				request.setAttribute("semHead","2nd semester books"); //for  top search name

				//matching with database
				request.setAttribute("selectionType","Book"); 
				request.setAttribute("selectionFaculty","Civil Engineering"); 

				//for searching in file server
				request.setAttribute("faculty","civil"); 
				request.setAttribute("type","book"); 
				request.setAttribute("semester","2nd"); 

				request.setAttribute("s1","Object Oriented Programming"); 
				request.setAttribute("s2","Fundamentals of Thermodynamics & Heat Transfer"); 
				request.setAttribute("s3","Engineering Mathematics II"); 
				request.setAttribute("s4","Engineering Drawing II"); 
				request.setAttribute("s5","Study Skills in English for Academic Purposes"); 
				request.setAttribute("s6","Mechanics & Optics"); 

				RequestDispatcher requestDispatcher = request.getRequestDispatcher("subjectmaterial.jsp");
				requestDispatcher.forward(request, response);

			}
			else if(type.equals("civilB3rd")) {

				request.setAttribute("semHead","3rd semester books"); //for  top search name

				//matching with database
				request.setAttribute("selectionType","Book"); 
				request.setAttribute("selectionFaculty","Civil Engineering"); 

				//for searching in file server
				request.setAttribute("faculty","civil"); 
				request.setAttribute("type","book"); 
				request.setAttribute("semester","3rd"); 

				request.setAttribute("s1","Basic Mechanical Engineering"); 
				request.setAttribute("s2","Basic Electrical & Electronics Engineering"); 
				request.setAttribute("s3","Engineering Geology"); 
				request.setAttribute("s4","Engineering Mathematics III"); 
				request.setAttribute("s5","Strength of Materials"); 
				request.setAttribute("s6","Surveying I"); 

				RequestDispatcher requestDispatcher = request.getRequestDispatcher("subjectmaterial.jsp");
				requestDispatcher.forward(request, response);

			}
			else if(type.equals("civilB4th")) {

				request.setAttribute("semHead","4th semester books"); //for  top search name

				//matching with database
				request.setAttribute("selectionType","Book"); 
				request.setAttribute("selectionFaculty","Civil Engineering"); 

				//for searching in file server
				request.setAttribute("faculty","civil"); 
				request.setAttribute("type","book"); 
				request.setAttribute("semester","4th"); 

				request.setAttribute("s1","Building Drawing"); 
				request.setAttribute("s2","Communication English II"); 
				request.setAttribute("s3","Structural Analysis I"); 
				request.setAttribute("s4","Building Technology"); 
				request.setAttribute("s5","Hydraulics"); 
				request.setAttribute("s6","Probability & Experimental Design"); 
				request.setAttribute("s7","Surveying II"); 

				RequestDispatcher requestDispatcher = request.getRequestDispatcher("subjectmaterial.jsp");
				requestDispatcher.forward(request, response);

			}
			else if(type.equals("civilB5th")) {

				request.setAttribute("semHead","5th semester books"); //for  top search name

				//matching with database
				request.setAttribute("selectionType","Book"); 
				request.setAttribute("selectionFaculty","Civil Engineering"); 

				//for searching in file server
				request.setAttribute("faculty","civil"); 
				request.setAttribute("type","book"); 
				request.setAttribute("semester","5th"); 

				request.setAttribute("s1","Structural Analysis II"); 
				request.setAttribute("s2","Transportation Engineering"); 
				request.setAttribute("s3","Water Supply Engineering"); 
				request.setAttribute("s4","Hydrology & River Engineering"); 
				request.setAttribute("s5","Engineering Economics"); 
				request.setAttribute("s6","Computer Methods in Civil Engineering"); 


				RequestDispatcher requestDispatcher = request.getRequestDispatcher("subjectmaterial.jsp");
				requestDispatcher.forward(request, response);

			}
			else if(type.equals("civilB6th")) {

				request.setAttribute("semHead","6th semester books"); //for  top search name

				//matching with database
				request.setAttribute("selectionType","Book"); 
				request.setAttribute("selectionFaculty","Civil Engineering"); 

				//for searching in file server
				request.setAttribute("faculty","civil"); 
				request.setAttribute("type","book"); 
				request.setAttribute("semester","6th"); 

				request.setAttribute("s1","Soil & Rock Mechanics"); 
				request.setAttribute("s2","Design of Steel & Timber Structure"); 
				request.setAttribute("s3","Concrete Technology & Masonary Structures"); 
				request.setAttribute("s4","Airport & Engineering"); 
				request.setAttribute("s5","Irrigation Engineering"); 
				request.setAttribute("s6","Estimation, Cost & Valuation"); 
				request.setAttribute("s7","Sanitary & Environmental Engineering"); 

				RequestDispatcher requestDispatcher = request.getRequestDispatcher("subjectmaterial.jsp");
				requestDispatcher.forward(request, response);

			}
			//7th
			else if(type.equals("civilB7th")) {
				request.setAttribute("semHead","7th semester books"); //for  top search name

				//matching with database
				request.setAttribute("selectionType","Book"); 
				request.setAttribute("selectionFaculty","Civil Engineering"); 

				//for searching in file server
				request.setAttribute("faculty","civil"); 
				request.setAttribute("type","book"); 
				request.setAttribute("semester","7th"); 

				request.setAttribute("s1","Design of RCC Structure"); 
				request.setAttribute("s2","Hydropower Engineering"); 
				request.setAttribute("s3","Foundation Engineering"); 
				request.setAttribute("s4","Safety Engineering"); 
				request.setAttribute("s5","Minor Project"); 
				request.setAttribute("s6","Elective I"); 
				request.setAttribute("s7","Elective II"); 

				RequestDispatcher requestDispatcher = request.getRequestDispatcher("subjectmaterial.jsp");
				requestDispatcher.forward(request, response);

			}
			//8th
			else if(type.equals("civilB8th")) {
				request.setAttribute("semHead","8th semester books"); //for  top search name

				//matching with database
				request.setAttribute("selectionType","Book"); 
				request.setAttribute("selectionFaculty","Civil Engineering"); 

				//for searching in file server
				request.setAttribute("faculty","civil"); 
				request.setAttribute("type","book"); 
				request.setAttribute("semester","8th"); 

				request.setAttribute("s1","RS & GIS Application to Engineering"); 
				request.setAttribute("s2","Construction Management & Project Engineering"); 
				request.setAttribute("s3","Engineering Professional Practice & Society"); 
				request.setAttribute("s4","Major Project"); 
				request.setAttribute("s5","Elective III"); 
				request.setAttribute("s6","Elective IV"); 

				RequestDispatcher requestDispatcher = request.getRequestDispatcher("subjectmaterial.jsp");
				requestDispatcher.forward(request, response);


			}

			//For Civil Note

			else if(type.equals("civilN1st")) {

				request.setAttribute("semHead","1st semester notes"); //for  top search name

				//matching with database
				request.setAttribute("selectionType","Note"); 
				request.setAttribute("selectionFaculty","Civil Engineering"); 

				//for searching in file server
				request.setAttribute("faculty","civil"); 
				request.setAttribute("type","note"); 
				request.setAttribute("semester","1st"); 

				request.setAttribute("s1","Engineering Mathematics I"); 
				request.setAttribute("s2","Basic Programming & Data Structure"); 
				request.setAttribute("s3","Engineering Chemistry"); 
				request.setAttribute("s4","Engineering Drawing I"); 
				request.setAttribute("s5","English for Communication"); 
				request.setAttribute("s6","Electricity & Magnetism"); 

				RequestDispatcher requestDispatcher = request.getRequestDispatcher("subjectmaterial.jsp");
				requestDispatcher.forward(request, response);

			}
			else if(type.equals("civilN2nd")) {

				request.setAttribute("semHead","2nd semester notes"); //for  top search name

				//matching with database
				request.setAttribute("selectionType","Note"); 
				request.setAttribute("selectionFaculty","Civil Engineering"); 

				//for searching in file server
				request.setAttribute("faculty","civil"); 
				request.setAttribute("type","note"); 
				request.setAttribute("semester","2nd"); 

				request.setAttribute("s1","Object Oriented Programming"); 
				request.setAttribute("s2","Fundamentals of Thermodynamics & Heat Transfer"); 
				request.setAttribute("s3","Engineering Mathematics II"); 
				request.setAttribute("s4","Engineering Drawing II"); 
				request.setAttribute("s5","Study Skills in English for Academic Purposes"); 
				request.setAttribute("s6","Mechanics & Optics"); 

				RequestDispatcher requestDispatcher = request.getRequestDispatcher("subjectmaterial.jsp");
				requestDispatcher.forward(request, response);

			}
			else if(type.equals("civilN3rd")) {

				request.setAttribute("semHead","3rd semester notes"); //for  top search name

				//matching with database
				request.setAttribute("selectionType","Note"); 
				request.setAttribute("selectionFaculty","Civil Engineering"); 

				//for searching in file server
				request.setAttribute("faculty","civil"); 
				request.setAttribute("type","note"); 
				request.setAttribute("semester","3rd"); 

				request.setAttribute("s1","Basic Mechanical Engineering"); 
				request.setAttribute("s2","Basic Electrical & Electronics Engineering"); 
				request.setAttribute("s3","Engineering Geology"); 
				request.setAttribute("s4","Engineering Mathematics III"); 
				request.setAttribute("s5","Strength of Materials"); 
				request.setAttribute("s6","Surveying I"); 

				RequestDispatcher requestDispatcher = request.getRequestDispatcher("subjectmaterial.jsp");
				requestDispatcher.forward(request, response);

			}
			else if(type.equals("civilN4th")) {

				request.setAttribute("semHead","4th semester notes"); //for  top search name

				//matching with database
				request.setAttribute("selectionType","Note"); 
				request.setAttribute("selectionFaculty","Civil Engineering"); 

				//for searching in file server
				request.setAttribute("faculty","civil"); 
				request.setAttribute("type","note"); 
				request.setAttribute("semester","4th"); 

				request.setAttribute("s1","Building Drawing"); 
				request.setAttribute("s2","Communication English II"); 
				request.setAttribute("s3","Structural Analysis I"); 
				request.setAttribute("s4","Building Technology"); 
				request.setAttribute("s5","Hydraulics"); 
				request.setAttribute("s6","Probability & Experimental Design"); 
				request.setAttribute("s7","Surveying II"); 

				RequestDispatcher requestDispatcher = request.getRequestDispatcher("subjectmaterial.jsp");
				requestDispatcher.forward(request, response);

			}
			else if(type.equals("civilN5th")) {

				request.setAttribute("semHead","5th semester notes"); //for  top search name

				//matching with database
				request.setAttribute("selectionType","Note"); 
				request.setAttribute("selectionFaculty","Civil Engineering"); 

				//for searching in file server
				request.setAttribute("faculty","civil"); 
				request.setAttribute("type","note"); 
				request.setAttribute("semester","5th"); 

				request.setAttribute("s1","Structural Analysis II"); 
				request.setAttribute("s2","Transportation Engineering"); 
				request.setAttribute("s3","Water Supply Engineering"); 
				request.setAttribute("s4","Hydrology & River Engineering"); 
				request.setAttribute("s5","Engineering Economics"); 
				request.setAttribute("s6","Computer Methods in Civil Engineering"); 


				RequestDispatcher requestDispatcher = request.getRequestDispatcher("subjectmaterial.jsp");
				requestDispatcher.forward(request, response);

			}
			else if(type.equals("civilN6th")) {

				request.setAttribute("semHead","6th semester notes"); //for  top search name

				//matching with database
				request.setAttribute("selectionType","Note"); 
				request.setAttribute("selectionFaculty","Civil Engineering"); 

				//for searching in file server
				request.setAttribute("faculty","civil"); 
				request.setAttribute("type","note"); 
				request.setAttribute("semester","6th"); 

				request.setAttribute("s1","Soil & Rock Mechanics"); 
				request.setAttribute("s2","Design of Steel & Timber Structure"); 
				request.setAttribute("s3","Concrete Technology & Masonary Structures"); 
				request.setAttribute("s4","Airport & Engineering"); 
				request.setAttribute("s5","Irrigation Engineering"); 
				request.setAttribute("s6","Estimation, Cost & Valuation"); 
				request.setAttribute("s7","Sanitary & Environmental Engineering"); 

				RequestDispatcher requestDispatcher = request.getRequestDispatcher("subjectmaterial.jsp");
				requestDispatcher.forward(request, response);

			}
			//7th
			else if(type.equals("civilN7th")) {

				request.setAttribute("semHead","7th semester notes"); //for  top search name

				//matching with database
				request.setAttribute("selectionType","Note"); 
				request.setAttribute("selectionFaculty","Civil Engineering"); 

				//for searching in file server
				request.setAttribute("faculty","civil"); 
				request.setAttribute("type","note"); 
				request.setAttribute("semester","7th"); 

				request.setAttribute("s1","Design of RCC Structure"); 
				request.setAttribute("s2","Hydropower Engineering"); 
				request.setAttribute("s3","Foundation Engineering"); 
				request.setAttribute("s4","Safety Engineering"); 
				request.setAttribute("s5","Minor Project"); 
				request.setAttribute("s6","Elective I"); 
				request.setAttribute("s7","Elective II"); 

				RequestDispatcher requestDispatcher = request.getRequestDispatcher("subjectmaterial.jsp");
				requestDispatcher.forward(request, response);
			}
			//8th
			else if(type.equals("civilN8th")) {
				request.setAttribute("semHead","8th semester notes"); //for  top search name

				//matching with database
				request.setAttribute("selectionType","Note"); 
				request.setAttribute("selectionFaculty","Civil Engineering"); 

				//for searching in file server
				request.setAttribute("faculty","civil"); 
				request.setAttribute("type","note"); 
				request.setAttribute("semester","8th"); 

				request.setAttribute("s1","RS & GIS Application to Engineering"); 
				request.setAttribute("s2","Construction Management & Project Engineering"); 
				request.setAttribute("s3","Engineering Professional Practice & Society"); 
				request.setAttribute("s4","Major Project"); 
				request.setAttribute("s5","Elective III"); 
				request.setAttribute("s6","Elective IV"); 

				RequestDispatcher requestDispatcher = request.getRequestDispatcher("subjectmaterial.jsp");
				requestDispatcher.forward(request, response);

			}


			//Civil Question Collection
			else if(type.equals("civilQC1st")) {

				request.setAttribute("semHead","1st semester Question Collection"); //for  top search name

				//matching with database
				request.setAttribute("selectionType","Question collection"); 
				request.setAttribute("selectionFaculty","Civil Engineering"); 

				//for searching in file server
				request.setAttribute("faculty","civil"); 
				request.setAttribute("type","oldisgold"); 
				request.setAttribute("semester","1st"); 


				RequestDispatcher requestDispatcher = request.getRequestDispatcher("subjectmaterial.jsp");
				requestDispatcher.forward(request, response);

			}
			else if(type.equals("civilQC2nd")) {

				request.setAttribute("semHead","2nd semester Question Collection"); //for  top search name

				//matching with database
				request.setAttribute("selectionType","Question collection"); 
				request.setAttribute("selectionFaculty","Civil Engineering"); 

				//for searching in file server
				request.setAttribute("faculty","civil"); 
				request.setAttribute("type","oldisgold"); 
				request.setAttribute("semester","2nd"); 


				RequestDispatcher requestDispatcher = request.getRequestDispatcher("subjectmaterial.jsp");
				requestDispatcher.forward(request, response);

			}
			else if(type.equals("civilQC3rd")) {

				request.setAttribute("semHead","3rd semester Question Collection"); //for  top search name

				//matching with database
				request.setAttribute("selectionType","Question collection"); 
				request.setAttribute("selectionFaculty","Civil Engineering"); 

				//for searching in file server
				request.setAttribute("faculty","civil"); 
				request.setAttribute("type","oldisgold"); 
				request.setAttribute("semester","3rd"); 


				RequestDispatcher requestDispatcher = request.getRequestDispatcher("subjectmaterial.jsp");
				requestDispatcher.forward(request, response);

			}
			else if(type.equals("civilQC4th")) {

				request.setAttribute("semHead","4th semester Question Collection"); //for  top search name

				//matching with database
				request.setAttribute("selectionType","Question collection"); 
				request.setAttribute("selectionFaculty","Civil Engineering"); 

				//for searching in file server
				request.setAttribute("faculty","civil"); 
				request.setAttribute("type","oldisgold"); 
				request.setAttribute("semester","4th"); 


				RequestDispatcher requestDispatcher = request.getRequestDispatcher("subjectmaterial.jsp");
				requestDispatcher.forward(request, response);

			}
			else if(type.equals("civilQC5th")) {

				request.setAttribute("semHead","5th semester Question Collection"); //for  top search name

				//matching with database
				request.setAttribute("selectionType","Question collection"); 
				request.setAttribute("selectionFaculty","Civil Engineering"); 

				//for searching in file server
				request.setAttribute("faculty","civil"); 
				request.setAttribute("type","oldisgold"); 
				request.setAttribute("semester","5th"); 


				RequestDispatcher requestDispatcher = request.getRequestDispatcher("subjectmaterial.jsp");
				requestDispatcher.forward(request, response);

			}
			else if(type.equals("civilQC6th")) {

				request.setAttribute("semHead","6th semester Question Collection"); //for  top search name

				//matching with database
				request.setAttribute("selectionType","Question collection"); 
				request.setAttribute("selectionFaculty","Civil Engineering"); 

				//for searching in file server
				request.setAttribute("faculty","civil"); 
				request.setAttribute("type","oldisgold"); 
				request.setAttribute("semester","6th"); 


				RequestDispatcher requestDispatcher = request.getRequestDispatcher("subjectmaterial.jsp");
				requestDispatcher.forward(request, response);

			}
			else if(type.equals("civilQC7th")) {

				request.setAttribute("semHead","7th semester Question Collection"); //for  top search name

				//matching with database
				request.setAttribute("selectionType","Question collection"); 
				request.setAttribute("selectionFaculty","Civil Engineering"); 

				//for searching in file server
				request.setAttribute("faculty","civil"); 
				request.setAttribute("type","oldisgold"); 
				request.setAttribute("semester","7th"); 


				RequestDispatcher requestDispatcher = request.getRequestDispatcher("subjectmaterial.jsp");
				requestDispatcher.forward(request, response);

			}
			else if(type.equals("civilQC8th")) {

				request.setAttribute("semHead","8th semester Question Collection"); //for  top search name

				//matching with database
				request.setAttribute("selectionType","Question collection"); 
				request.setAttribute("selectionFaculty","Civil Engineering"); 

				//for searching in file server
				request.setAttribute("faculty","civil"); 
				request.setAttribute("type","oldisgold"); 
				request.setAttribute("semester","8th"); 


				RequestDispatcher requestDispatcher = request.getRequestDispatcher("subjectmaterial.jsp");
				requestDispatcher.forward(request, response);

			}



			//For Computer Book
			else if(type.equals("computerB1st")) {

				request.setAttribute("semHead","1st semester books"); //for  top search name

				//matching with database
				request.setAttribute("selectionType","Book"); 
				request.setAttribute("selectionFaculty","Computer Engineering"); 


				//for searching in file server
				request.setAttribute("faculty","computer"); 
				request.setAttribute("type","book"); 
				request.setAttribute("semester","1st"); 

				request.setAttribute("s1","Engineering Drawing"); 
				request.setAttribute("s2","Engineering Math I"); 
				request.setAttribute("s3","Engineering Physics"); 
				request.setAttribute("s4","Basic Electrical Engineering"); 
				request.setAttribute("s5","Programming in C"); 
				request.setAttribute("s6","Workshop Technology"); 


				RequestDispatcher requestDispatcher = request.getRequestDispatcher("subjectmaterial.jsp");
				requestDispatcher.forward(request, response);

			}
			else if(type.equals("computerB2nd")) {

				request.setAttribute("semHead","2nd semester books"); //for  top search name

				//matching with database
				request.setAttribute("selectionType","Book"); 
				request.setAttribute("selectionFaculty","Computer Engineering"); 


				//for searching in file server
				request.setAttribute("faculty","computer"); 
				request.setAttribute("type","book"); 
				request.setAttribute("semester","2nd"); 

				request.setAttribute("s1","Engineering Math II"); 
				request.setAttribute("s2","Engineering Chemistry"); 
				request.setAttribute("s3","Thermodynamics"); 
				request.setAttribute("s4","Applied Mechanics"); 
				request.setAttribute("s5","Object Oriented Programming"); 
				request.setAttribute("s6","Discrete Structure"); 


				RequestDispatcher requestDispatcher = request.getRequestDispatcher("subjectmaterial.jsp");
				requestDispatcher.forward(request, response);

			}
			else if(type.equals("computerB3rd")) {

				request.setAttribute("semHead","3rd semester books"); //for  top search name

				//matching with database
				request.setAttribute("selectionType","Book"); 
				request.setAttribute("selectionFaculty","Computer Engineering"); 


				//for searching in file server
				request.setAttribute("faculty","computer"); 
				request.setAttribute("type","book"); 
				request.setAttribute("semester","3rd"); 


				request.setAttribute("s1","Engineering Math III"); 
				request.setAttribute("s2","Data Structure & Algorithm"); 
				request.setAttribute("s3","Theory of Computation"); 
				request.setAttribute("s4","Electrical Circuit Theory"); 
				request.setAttribute("s5","Digital Logic"); 
				request.setAttribute("s6","Electromagnetics"); 


				RequestDispatcher requestDispatcher = request.getRequestDispatcher("subjectmaterial.jsp");
				requestDispatcher.forward(request, response);

			}
			else if(type.equals("computerB4th")) {

				request.setAttribute("semHead","4th semester books"); //for  top search name

				//matching with database
				request.setAttribute("selectionType","Book"); 
				request.setAttribute("selectionFaculty","Computer Engineering"); 


				//for searching in file server
				request.setAttribute("faculty","computer"); 
				request.setAttribute("type","book"); 
				request.setAttribute("semester","4th"); 

				request.setAttribute("s1","Applied Mathematics"); 
				request.setAttribute("s2","Microprocessor"); 
				request.setAttribute("s3","Algorithmic Mathematics"); 
				request.setAttribute("s4","Electrical Machine"); 
				request.setAttribute("s5","Electronic Device & Circuit"); 
				request.setAttribute("s6","Communication English"); 


				RequestDispatcher requestDispatcher = request.getRequestDispatcher("subjectmaterial.jsp");
				requestDispatcher.forward(request, response);

			}
			else if(type.equals("computerB5th")) {

				request.setAttribute("semHead","5th semester books"); //for  top search name

				//matching with database
				request.setAttribute("selectionType","Book"); 
				request.setAttribute("selectionFaculty","Computer Engineering"); 


				//for searching in file server
				request.setAttribute("faculty","computer"); 
				request.setAttribute("type","book"); 
				request.setAttribute("semester","5th"); 

				request.setAttribute("s1","Probability & Statistic"); 
				request.setAttribute("s2","Instrumentation"); 
				request.setAttribute("s3","Computer Graphics"); 
				request.setAttribute("s4","Object Oriented Software Engineering"); 
				request.setAttribute("s5","Computer Architecture & Design"); 
				request.setAttribute("s6","Operating System"); 

				RequestDispatcher requestDispatcher = request.getRequestDispatcher("subjectmaterial.jsp");
				requestDispatcher.forward(request, response);

			}
			else if(type.equals("computerB6th")) {

				request.setAttribute("semHead","6th semester books"); //for  top search name

				//matching with database
				request.setAttribute("selectionType","Book"); 
				request.setAttribute("selectionFaculty","Computer Engineering"); 


				//for searching in file server
				request.setAttribute("faculty","computer"); 
				request.setAttribute("type","book"); 
				request.setAttribute("semester","6th"); 

				request.setAttribute("s1","Project & Organization Management"); 
				request.setAttribute("s2","Research Methodology"); 
				request.setAttribute("s3","Artificial Intelligence"); 
				request.setAttribute("s4","Database Management System"); 
				request.setAttribute("s5","Communication System"); 
				request.setAttribute("s6","Engineering Economics"); 
				request.setAttribute("s7","Minor Project"); 

				RequestDispatcher requestDispatcher = request.getRequestDispatcher("subjectmaterial.jsp");
				requestDispatcher.forward(request, response);

			}
			else if(type.equals("computerB7th")) {

				request.setAttribute("semHead","7th semester books"); //for  top search name

				//matching with database
				request.setAttribute("selectionType","Book"); 
				request.setAttribute("selectionFaculty","Computer Engineering"); 


				//for searching in file server
				request.setAttribute("faculty","computer"); 
				request.setAttribute("type","book"); 
				request.setAttribute("semester","7th"); 

				request.setAttribute("s1","Computer Networks"); 
				request.setAttribute("s2","Distributed Computing"); 
				request.setAttribute("s3","Information System"); 
				request.setAttribute("s4","Data Mining & Data Warehousing"); 
				request.setAttribute("s5","Simulation & Modeling"); 
				request.setAttribute("s6","Elective-I"); 
				request.setAttribute("s7","Project-Part A"); 

				RequestDispatcher requestDispatcher = request.getRequestDispatcher("subjectmaterial.jsp");
				requestDispatcher.forward(request, response);

			}
			else if(type.equals("computerB8th")) {

				request.setAttribute("semHead","8th semester books"); //for  top search name

				//matching with database
				request.setAttribute("selectionType","Book"); 
				request.setAttribute("selectionFaculty","Computer Engineering"); 


				//for searching in file server
				request.setAttribute("faculty","computer"); 
				request.setAttribute("type","book"); 
				request.setAttribute("semester","8th"); 

				request.setAttribute("s1","Digital Signal Analysis & Processing"); 
				request.setAttribute("s2","Engineering Professional Practice"); 
				request.setAttribute("s3","Information Security"); 
				request.setAttribute("s4","Big Data"); 
				request.setAttribute("s5","Elective-II"); 
				request.setAttribute("s6","Project-Part B"); 

				RequestDispatcher requestDispatcher = request.getRequestDispatcher("subjectmaterial.jsp");
				requestDispatcher.forward(request, response);

			}


			//For Computer Note
			else if(type.equals("computerN1st")) {

				request.setAttribute("semHead","1st semester notes"); //for  top search name

				//matching with database
				request.setAttribute("selectionType","Note"); 
				request.setAttribute("selectionFaculty","Computer Engineering"); 


				//for searching in file server
				request.setAttribute("faculty","computer"); 
				request.setAttribute("type","note"); 
				request.setAttribute("semester","1st"); 

				request.setAttribute("s1","Engineering Drawing"); 
				request.setAttribute("s2","Engineering Math I"); 
				request.setAttribute("s3","Engineering Physics"); 
				request.setAttribute("s4","Basic Electrical Engineering"); 
				request.setAttribute("s5","Programming in C"); 
				request.setAttribute("s6","Workshop Technology"); 


				RequestDispatcher requestDispatcher = request.getRequestDispatcher("subjectmaterial.jsp");
				requestDispatcher.forward(request, response);

			}
			else if(type.equals("computerN2nd")) {

				request.setAttribute("semHead","2nd semester notes"); //for  top search name

				//matching with database
				request.setAttribute("selectionType","Note"); 
				request.setAttribute("selectionFaculty","Computer Engineering"); 


				//for searching in file server
				request.setAttribute("faculty","computer"); 
				request.setAttribute("type","note"); 
				request.setAttribute("semester","2nd"); 

				request.setAttribute("s1","Engineering Math II"); 
				request.setAttribute("s2","Engineering Chemistry"); 
				request.setAttribute("s3","Thermodynamics"); 
				request.setAttribute("s4","Applied Mechanics"); 
				request.setAttribute("s5","Object Oriented Programming"); 
				request.setAttribute("s6","Discrete Structure"); 


				RequestDispatcher requestDispatcher = request.getRequestDispatcher("subjectmaterial.jsp");
				requestDispatcher.forward(request, response);

			}
			else if(type.equals("computerN3rd")) {

				request.setAttribute("semHead","3rd semester notes"); //for  top search name

				//matching with database
				request.setAttribute("selectionType","Note"); 
				request.setAttribute("selectionFaculty","Computer Engineering"); 


				//for searching in file server
				request.setAttribute("faculty","computer"); 
				request.setAttribute("type","note"); 
				request.setAttribute("semester","3rd"); 


				request.setAttribute("s1","Engineering Math III"); 
				request.setAttribute("s2","Data Structure & Algorithm"); 
				request.setAttribute("s3","Theory of Computation"); 
				request.setAttribute("s4","Electrical Circuit Theory"); 
				request.setAttribute("s5","Digital Logic"); 
				request.setAttribute("s6","Electromagnetics"); 


				RequestDispatcher requestDispatcher = request.getRequestDispatcher("subjectmaterial.jsp");
				requestDispatcher.forward(request, response);

			}
			else if(type.equals("computerN4th")) {

				request.setAttribute("semHead","4th semester notes"); //for  top search name

				//matching with database
				request.setAttribute("selectionType","Note"); 
				request.setAttribute("selectionFaculty","Computer Engineering"); 


				//for searching in file server
				request.setAttribute("faculty","computer"); 
				request.setAttribute("type","note"); 
				request.setAttribute("semester","4th"); 

				request.setAttribute("s1","Applied Mathematics"); 
				request.setAttribute("s2","Microprocessor"); 
				request.setAttribute("s3","Algorithmic Mathematics"); 
				request.setAttribute("s4","Electrical Machine"); 
				request.setAttribute("s5","Electronic Device & Circuit"); 
				request.setAttribute("s6","Communication English"); 


				RequestDispatcher requestDispatcher = request.getRequestDispatcher("subjectmaterial.jsp");
				requestDispatcher.forward(request, response);

			}
			else if(type.equals("computerN5th")) {

				request.setAttribute("semHead","5th semester notes"); //for  top search name

				//matching with database
				request.setAttribute("selectionType","Note"); 
				request.setAttribute("selectionFaculty","Computer Engineering"); 


				//for searching in file server
				request.setAttribute("faculty","computer"); 
				request.setAttribute("type","note"); 
				request.setAttribute("semester","5th"); 

				request.setAttribute("s1","Probability & Statistic"); 
				request.setAttribute("s2","Instrumentation"); 
				request.setAttribute("s3","Computer Graphics"); 
				request.setAttribute("s4","Object Oriented Software Engineering"); 
				request.setAttribute("s5","Computer Architecture & Design"); 
				request.setAttribute("s6","Operating System"); 

				RequestDispatcher requestDispatcher = request.getRequestDispatcher("subjectmaterial.jsp");
				requestDispatcher.forward(request, response);

			}
			else if(type.equals("computerN6th")) {

				request.setAttribute("semHead","6th semester notes"); //for  top search name

				//matching with database
				request.setAttribute("selectionType","Note"); 
				request.setAttribute("selectionFaculty","Computer Engineering"); 


				//for searching in file server
				request.setAttribute("faculty","computer"); 
				request.setAttribute("type","note"); 
				request.setAttribute("semester","6th"); 

				request.setAttribute("s1","Project & Organization Management"); 
				request.setAttribute("s2","Research Methodology"); 
				request.setAttribute("s3","Artificial Intelligence"); 
				request.setAttribute("s4","Database Management System"); 
				request.setAttribute("s5","Communication System"); 
				request.setAttribute("s6","Engineering Economics"); 
				request.setAttribute("s7","Minor Project"); 

				RequestDispatcher requestDispatcher = request.getRequestDispatcher("subjectmaterial.jsp");
				requestDispatcher.forward(request, response);

			}
			else if(type.equals("computerN7th")) {

				request.setAttribute("semHead","7th semester notes"); //for  top search name

				//matching with database
				request.setAttribute("selectionType","Note"); 
				request.setAttribute("selectionFaculty","Computer Engineering"); 


				//for searching in file server
				request.setAttribute("faculty","computer"); 
				request.setAttribute("type","note"); 
				request.setAttribute("semester","7th"); 

				request.setAttribute("s1","Computer Networks"); 
				request.setAttribute("s2","Distributed Computing"); 
				request.setAttribute("s3","Information System"); 
				request.setAttribute("s4","Data Mining & Data Warehousing"); 
				request.setAttribute("s5","Simulation & Modeling"); 
				request.setAttribute("s6","Elective-I"); 
				request.setAttribute("s7","Project-Part A"); 

				RequestDispatcher requestDispatcher = request.getRequestDispatcher("subjectmaterial.jsp");
				requestDispatcher.forward(request, response);

			}
			else if(type.equals("computerN8th")) {

				request.setAttribute("semHead","8th semester notes"); //for  top search name

				//matching with database
				request.setAttribute("selectionType","Note"); 
				request.setAttribute("selectionFaculty","Computer Engineering"); 


				//for searching in file server
				request.setAttribute("faculty","computer"); 
				request.setAttribute("type","note"); 
				request.setAttribute("semester","8th"); 

				request.setAttribute("s1","Digital Signal Analysis & Processing"); 
				request.setAttribute("s2","Engineering Professional Practice"); 
				request.setAttribute("s3","Information Security"); 
				request.setAttribute("s4","Big Data"); 
				request.setAttribute("s5","Elective-II"); 
				request.setAttribute("s6","Project-Part B"); 

				RequestDispatcher requestDispatcher = request.getRequestDispatcher("subjectmaterial.jsp");
				requestDispatcher.forward(request, response);

			}


			//Computer Question Collection

			else if(type.equals("computerQC1st")) {

				request.setAttribute("semHead","1st semester Question Collection"); //for  top search name

				//matching with database
				request.setAttribute("selectionType","Question collection"); 
				request.setAttribute("selectionFaculty","Computer Engineering"); 

				//for searching in file server
				request.setAttribute("faculty","computer"); 
				request.setAttribute("type","oldisgold"); 
				request.setAttribute("semester","1st"); 


				RequestDispatcher requestDispatcher = request.getRequestDispatcher("subjectmaterial.jsp");
				requestDispatcher.forward(request, response);

			}
			else if(type.equals("computerQC2nd")) {

				request.setAttribute("semHead","2nd semester Question Collection"); //for  top search name

				//matching with database
				request.setAttribute("selectionType","Question collection"); 
				request.setAttribute("selectionFaculty","Computer Engineering"); 

				//for searching in file server
				request.setAttribute("faculty","computer"); 
				request.setAttribute("type","oldisgold"); 
				request.setAttribute("semester","2nd"); 


				RequestDispatcher requestDispatcher = request.getRequestDispatcher("subjectmaterial.jsp");
				requestDispatcher.forward(request, response);

			}
			else if(type.equals("computerQC3rd")) {

				request.setAttribute("semHead","3rd semester Question Collection"); //for  top search name

				//matching with database
				request.setAttribute("selectionType","Question collection"); 
				request.setAttribute("selectionFaculty","Computer Engineering"); 

				//for searching in file server
				request.setAttribute("faculty","computer"); 
				request.setAttribute("type","oldisgold"); 
				request.setAttribute("semester","3rd"); 


				RequestDispatcher requestDispatcher = request.getRequestDispatcher("subjectmaterial.jsp");
				requestDispatcher.forward(request, response);

			}
			else if(type.equals("computerQC4th")) {

				request.setAttribute("semHead","4th semester Question Collection"); //for  top search name

				//matching with database
				request.setAttribute("selectionType","Question collection"); 
				request.setAttribute("selectionFaculty","Computer Engineering"); 

				//for searching in file server
				request.setAttribute("faculty","computer"); 
				request.setAttribute("type","oldisgold"); 
				request.setAttribute("semester","4th"); 


				RequestDispatcher requestDispatcher = request.getRequestDispatcher("subjectmaterial.jsp");
				requestDispatcher.forward(request, response);

			}
			else if(type.equals("computerQC5th")) {

				request.setAttribute("semHead","5th semester Question Collection"); //for  top search name

				//matching with database
				request.setAttribute("selectionType","Question collection"); 
				request.setAttribute("selectionFaculty","Computer Engineering"); 

				//for searching in file server
				request.setAttribute("faculty","computer"); 
				request.setAttribute("type","oldisgold"); 
				request.setAttribute("semester","5th"); 


				RequestDispatcher requestDispatcher = request.getRequestDispatcher("subjectmaterial.jsp");
				requestDispatcher.forward(request, response);

			}
			else if(type.equals("computerQC6th")) {

				request.setAttribute("semHead","6th semester Question Collection"); //for  top search name

				//matching with database
				request.setAttribute("selectionType","Question collection"); 
				request.setAttribute("selectionFaculty","Computer Engineering"); 

				//for searching in file server
				request.setAttribute("faculty","computer"); 
				request.setAttribute("type","oldisgold"); 
				request.setAttribute("semester","6th"); 


				RequestDispatcher requestDispatcher = request.getRequestDispatcher("subjectmaterial.jsp");
				requestDispatcher.forward(request, response);

			}
			else if(type.equals("computerQC7th")) {

				request.setAttribute("semHead","7th semester Question Collection"); //for  top search name

				//matching with database
				request.setAttribute("selectionType","Question collection"); 
				request.setAttribute("selectionFaculty","Computer Engineering"); 

				//for searching in file server
				request.setAttribute("faculty","computer"); 
				request.setAttribute("type","oldisgold"); 
				request.setAttribute("semester","7th"); 


				RequestDispatcher requestDispatcher = request.getRequestDispatcher("subjectmaterial.jsp");
				requestDispatcher.forward(request, response);

			}
			else if(type.equals("computerQC8th")) {

				request.setAttribute("semHead","8th semester Question Collection"); //for  top search name

				//matching with database
				request.setAttribute("selectionType","Question collection"); 
				request.setAttribute("selectionFaculty","Computer Engineering"); 

				//for searching in file server
				request.setAttribute("faculty","computer"); 
				request.setAttribute("type","oldisgold"); 
				request.setAttribute("semester","8th"); 


				RequestDispatcher requestDispatcher = request.getRequestDispatcher("subjectmaterial.jsp");
				requestDispatcher.forward(request, response);

			}


			//Entrace book
			else if(type.equals("entranceB")) {

				request.setAttribute("semHead","Entrance preparation books"); //for  top search name

				//matching with database
				request.setAttribute("selectionType","Book"); 
				request.setAttribute("selectionFaculty","Entrance"); 

				//for searching in file server
				request.setAttribute("faculty","entrance"); 
				request.setAttribute("type","book"); 
				request.setAttribute("semester","No Semester"); 

				request.setAttribute("s1","English");
				request.setAttribute("s2","Chemistry"); 
				request.setAttribute("s3","Physics"); 
				request.setAttribute("s4","Mathematics"); 
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("subjectmaterial.jsp");
				requestDispatcher.forward(request, response);

			}
			//Entrace note
			else if(type.equals("entranceN")) {

				request.setAttribute("semHead","Entrance preparation notes"); //for  top search name

				//matching with database
				request.setAttribute("selectionType","Note"); 
				request.setAttribute("selectionFaculty","Entrance"); 

				//for searching in file server
				request.setAttribute("faculty","entrance"); 
				request.setAttribute("type","note"); 
				request.setAttribute("semester","No Semester"); 

				request.setAttribute("s1","English");
				request.setAttribute("s2","Chemistry"); 
				request.setAttribute("s3","Physics"); 
				request.setAttribute("s4","Mathematics"); 
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("subjectmaterial.jsp");
				requestDispatcher.forward(request, response);

			}

			//Entrace Question Collection
			else if(type.equals("entranceQC")) {

				request.setAttribute("semHead","Entrance preparation question collection"); //for  top search name

				//matching with database
				request.setAttribute("selectionType","Question collection"); 
				request.setAttribute("selectionFaculty","Entrance"); 

				//for searching in file server
				request.setAttribute("faculty","entrance"); 
				request.setAttribute("type","oldisgold"); 
				request.setAttribute("semester","No Semester"); 


				RequestDispatcher requestDispatcher = request.getRequestDispatcher("subjectmaterial.jsp");
				requestDispatcher.forward(request, response);

			}
			else {
				request.setAttribute("semHead","Data not available because you are trying to enter without any action."); //for  top search name

				RequestDispatcher requestDispatcher = request.getRequestDispatcher("subjectmaterial.jsp");
				requestDispatcher.forward(request, response); 			}

		} catch (Exception e) {
			resultMessage = "Server error occur : " + e.getMessage();

			request.setAttribute("Message", resultMessage);
			RequestDispatcher dispatcher=request.getRequestDispatcher("Result.jsp");
			dispatcher.forward(request, response);		}


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
