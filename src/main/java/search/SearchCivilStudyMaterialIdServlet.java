package search;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SearchNoticeByIdServlet
 */
@WebServlet("/SearchCivilStudyMaterialIdServlet")
public class SearchCivilStudyMaterialIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 private SearchCivilStudyMaterialByIdDao sDao;
	    public void init() {
	    	sDao = new SearchCivilStudyMaterialByIdDao();
	    }
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchCivilStudyMaterialIdServlet() {
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

        int searchid = Integer.parseInt(request.getParameter("searchcivilstudymaterialid"));
        SearchCivilStudyMaterialByIdBean sBean = new  SearchCivilStudyMaterialByIdBean();
        sBean.setSearchById(searchid);
        sBean.setSearchByFaculty("Civil Engineering");

        String resultMessage ="";


        try {
            if (sDao.validate(sBean, request)) {
            	
resultMessage="Your result shown below : ";
                
        		request.setAttribute("sResult",resultMessage); 
        		
        		request.setAttribute("sId","Id");    
        		request.setAttribute("sDate","Published Date");    
        		request.setAttribute("sFaculty","Faculty"); 
        		request.setAttribute("sSemester","Semester");    

        		request.setAttribute("sType","Type");    
        		request.setAttribute("sSubjectName","Subject Name");    

        		request.setAttribute("sFileName","File Name");    
        		request.setAttribute("sAction","Action");    
 		
        		
        		request.setAttribute("sDelete","Delete");    

    			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/AdminManagePages/actiononcivilstudymaterial.jsp");
        		requestDispatcher.forward(request, response);
        		
            }
            else {
        		resultMessage="This id may exist in another faculty/already deleted/ not exist in our database.";
                
        		request.setAttribute("sResult",resultMessage);    
        		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/AdminManagePages/actiononcivilstudymaterial.jsp");
        		requestDispatcher.forward(request, response);
        		        		
            }
        } catch (Exception e) {
            e.printStackTrace();
            
          	 resultMessage = "There were an error: " + e.getMessage();
          	 request.setAttribute("Message", resultMessage);
               RequestDispatcher dispatcher=request.getRequestDispatcher("Result.jsp");
                       dispatcher.forward(request, response);

        }
 
	}

}
