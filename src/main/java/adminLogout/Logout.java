package adminLogout;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Logout
 */
@WebServlet("/Logout")
public class Logout extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Logout() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
        String resultMessage="";
try {
	

        if (session!=null) {
        	session.removeAttribute("sessionEmail");//     or   	session.setAttribute("sessionEmail",null);

            session.removeAttribute("sessionPassword");//    or    	session.setAttribute("sessionEmail",null);

           
            session.invalidate();
                      
            
            resultMessage="logout successfully...";

            request.setAttribute("msg", resultMessage);
            RequestDispatcher dispatcher=request.getRequestDispatcher("adminlogin.jsp");
                    dispatcher.forward(request, response);
            
        }
        else {           
       	 resultMessage = "Your session has been expired. Please try to login.";

            request.setAttribute("Message", resultMessage);
            RequestDispatcher dispatcher=request.getRequestDispatcher("Result.jsp");
                    dispatcher.forward(request, response);
            
        }
} catch (Exception e) {

	 resultMessage = "There were an error: " + e.getMessage();
	 request.setAttribute("Message", resultMessage);
     RequestDispatcher dispatcher=request.getRequestDispatcher("Result.jsp");
             dispatcher.forward(request, response);

	}
	
    }
}