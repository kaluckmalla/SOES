package ResetPassword;
 
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import SqlConn.ConnectionProvider;
 
/**
 * A servlet that takes message details from user and send it as a new e-mail
 * through an SMTP server.
 *
 * @author www.codejava.net
 *
 */
@WebServlet("/Forgetpass")
public class Forgetpass  extends HttpServlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String host;
    private String port;
    private String user;
    private String pass;
 
    public void init() {
        // reads SMTP server setting from web.xml file
        ServletContext context = getServletContext();
        host = context.getInitParameter("host");
        port = context.getInitParameter("port");
        user = context.getInitParameter("user");
        pass = context.getInitParameter("pass");
    }
 
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        // reads form fields
        String toAddress = request.getParameter("toAddress");
        
        PreparedStatement ps=null;
        String resultMessage = "  ";
        ResultSet rs=null;
 
        
        
        Connection con=ConnectionProvider.getCon();
		String sql="select * from admin_login";
		
		   
        try {
        	ps=con.prepareStatement(sql);
    		
    		 rs=ps.executeQuery();
    		 
    		 if(rs.next()) {

    		if(rs.getString(3).equals(toAddress)) {
    			
    	MailUtility.sendMail(host, port, user, pass, toAddress, rs.getString(4));
request.setAttribute("hello", "hhhhhh");
            resultMessage = "We have sent your password to "+rs.getString(3)+". Please check your email.";
            
            request.setAttribute("Message",resultMessage);     //Sending data to same page use session
    		RequestDispatcher requestDispatcher = request.getRequestDispatcher("Result.jsp");
    		requestDispatcher.forward(request, response);
        	}
    		else {
    			
                resultMessage = "Your email not exist in our database.";

                 
        		request.setAttribute("ForgetPasswordMessage",resultMessage);     //Sending data to same page use session
        		RequestDispatcher requestDispatcher = request.getRequestDispatcher("forgetpassword.jsp");
        		requestDispatcher.forward(request, response);
    		}
    		 }
    		 
    		 else {
    			 resultMessage = "No data in table.";
    	            
    	            request.setAttribute("Message",resultMessage);     //Sending data to same page use session
    	    		RequestDispatcher requestDispatcher = request.getRequestDispatcher("Result.jsp");
    	    		requestDispatcher.forward(request, response); 
    		 }
        } catch (Exception e) {
            
       	 resultMessage = "There were an error: " + e.getMessage();
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
}