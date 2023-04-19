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
@WebServlet("/SearchImageByIdServlet")
public class SearchImageByIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 private SearchImageByIdDao siDao;
	    public void init() {
	    	siDao = new SearchImageByIdDao();
	    }
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchImageByIdServlet() {
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

        int imagesearchid = Integer.parseInt(request.getParameter("searchimageid"));
        SearchImageByIdBean siBean = new  SearchImageByIdBean();
        siBean.setSearchImageById(imagesearchid);
        String resultMessage ="";


        try {
            if (siDao.validate(siBean, request)) {            	
resultMessage="Your result shown below : ";
                
        		request.setAttribute("siResult",resultMessage);         		
        		request.setAttribute("siHeadsiId","Image Id");    
        		request.setAttribute("siHeadsiDate","Publish Date");    
        		request.setAttribute("siHeadsiAboutImage","AboutImage");    
        		request.setAttribute("siHeadsiImage","Image Name");    
        		request.setAttribute("siHeadsiAction","Action");    
      		
        		request.setAttribute("siDelete","Delete");    

    			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/AdminManagePages/actiononpostimages.jsp");
        		requestDispatcher.forward(request, response);
        		
            }
            else {
        		resultMessage="This id is already deleted/ not exist in our database.";
                
        		request.setAttribute("siResult",resultMessage);    
        		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/AdminManagePages/actiononpostimages.jsp");
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
