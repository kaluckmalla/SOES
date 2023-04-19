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
@WebServlet("/SearchNewsByIdServlet")
public class SearchNewsByIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 private SearchNewsByIdDao snDao;
	    public void init() {
	    	snDao = new SearchNewsByIdDao();
	    }
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchNewsByIdServlet() {
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

        int newssearchid = Integer.parseInt(request.getParameter("searchnewsid"));
        SearchNewsByIdBean snBean = new  SearchNewsByIdBean();
        snBean.setSearchNewsById(newssearchid);
        String resultMessage ="";


        try {
            if (snDao.validate(snBean, request)) {            	
resultMessage="Your result shown below : ";
                
        		request.setAttribute("snResult",resultMessage);         		
        		request.setAttribute("snHeadsnId","News Id");    
        		request.setAttribute("snHeadsnDate","Publish Date");    
        		request.setAttribute("snHeadsnTitle","Title");    
        		request.setAttribute("snHeadsnImage","Image Name");    
        		request.setAttribute("snHeadsnAction","Action");    
      		
        		request.setAttribute("snEdit","Edit");    
        		request.setAttribute("snDelete","Delete");    

    			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/AdminManagePages/actiononpostnews.jsp");
        		requestDispatcher.forward(request, response);
        		
            }
            else {
        		resultMessage="This id is already deleted/ not exist in our database.";
                
        		request.setAttribute("snResult",resultMessage);    
        		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/AdminManagePages/actiononpostnews.jsp");
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
