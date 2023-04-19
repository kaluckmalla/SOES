package Login;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private LoginDao loginDao;
    public void init() {
        loginDao = new LoginDao();
    }
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
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

		
        String useremail = request.getParameter("email");
        String userpassword = request.getParameter("password");
        LoginBean loginBean = new LoginBean();
        loginBean.setUseremail(useremail);
        loginBean.setUserpassword(userpassword);
        String resultMessage ="";


        try {
            if (loginDao.validate(loginBean, request)) {
            	
                HttpSession session = request.getSession();
                //Sending data to another page use session
                 
            	session.setAttribute("sessionEmail", useremail); //for logout creating session
    			session.setAttribute("sessionPassword", userpassword);//for logout creating session
    			
    			response.sendRedirect("admincontrol.jsp");
        		
            }
            else {
        		resultMessage="Sorry, phone number and password do not match.";
                
        		//HttpSession session = request.getSession();
        		request.setAttribute("msg",resultMessage);     //Sending data to same page use session
        		RequestDispatcher requestDispatcher = request.getRequestDispatcher("adminlogin.jsp");
        		requestDispatcher.forward(request, response);

        		
               // response.sendRedirect("adminlogin.jsp");
            }
        } catch (Exception e) {
            
          	 resultMessage = "There were an error: " + e.getMessage();
          	 request.setAttribute("Message", resultMessage);
               RequestDispatcher dispatcher=request.getRequestDispatcher("Result.jsp");
                       dispatcher.forward(request, response);

        }
    }
}