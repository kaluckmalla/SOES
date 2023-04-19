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
@WebServlet("/SearchEventByIdServlet")
public class SearchEventByIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 private SearchEventByIdDao seDao;
	    public void init() {
	    	seDao = new SearchEventByIdDao();
	    }
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchEventByIdServlet() {
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

        int eventsearchid = Integer.parseInt(request.getParameter("searcheventid"));
        SearchEventByIdBean seBean = new  SearchEventByIdBean();
        seBean.setSearchEventById(eventsearchid);
        String resultMessage ="";


        try {
            if (seDao.validate(seBean, request)) {            	
resultMessage="Your result shown below : ";
                
        		request.setAttribute("seResult",resultMessage);         		
        		request.setAttribute("seHeadseId","Event Id");    
        		request.setAttribute("seHeadseDate","Publish Date");    
        		request.setAttribute("seHeadseTitle","Title");    
        		request.setAttribute("seHeadseStartDate","Start Date");  
        		request.setAttribute("seHeadseStartTime","Start Time");    

        		request.setAttribute("seHeadseEndDate","End Date");    

        		request.setAttribute("seHeadseEndTime","End Time");    

        		request.setAttribute("seHeadseDescription","Description");    

        		request.setAttribute("seHeadseAction","Action");    
      		
        		request.setAttribute("seDelete","Delete");    

    			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/AdminManagePages/actiononpostevent.jsp");
        		requestDispatcher.forward(request, response);
        		
            }
            else {
        		resultMessage="This id is already deleted/ not exist in our database.";
                
        		request.setAttribute("seResult",resultMessage);    
        		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/AdminManagePages/actiononpostevent.jsp");
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
