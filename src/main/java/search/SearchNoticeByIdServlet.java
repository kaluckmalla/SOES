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
@WebServlet("/SearchNoticeByIdServlet")
public class SearchNoticeByIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 private SearchNoticeByIdDao snDao;
	    public void init() {
	    	snDao = new SearchNoticeByIdDao();
	    }
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchNoticeByIdServlet() {
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

        int noticesearchid = Integer.parseInt(request.getParameter("searchnoticeid"));
        SearchNoticeByIdBean snBean = new  SearchNoticeByIdBean();
        snBean.setSearchNoticeById(noticesearchid);
        String resultMessage ="";


        try {
            if (snDao.validate(snBean, request)) {
            	
resultMessage="Your result shown below : ";
                
        		request.setAttribute("snResult",resultMessage); 
        		
        		request.setAttribute("snHeadsnId","Notice Id");    
        		request.setAttribute("snHeadsnDate","Publish Date");    
        		request.setAttribute("snHeadsnTitle","Title");    
        		request.setAttribute("snHeadsnFile","File Name");    
        		request.setAttribute("snHeadsnAction","Action");    
 		
        		
        		request.setAttribute("snEdit","Edit");    
        		request.setAttribute("snDelete","Delete");    

    			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/AdminManagePages/actiononpostnotice.jsp");
        		requestDispatcher.forward(request, response);
        		
            }
            else {
        		resultMessage="This id is already deleted/ not exist in our database.";
                
        		request.setAttribute("snResult",resultMessage);    
        		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/AdminManagePages/actiononpostnotice.jsp");
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
