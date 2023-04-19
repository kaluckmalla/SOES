<!-- For using nepali language  charactset and page encoding update gareko -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.io.*,java.util.*,java.sql.*"%>

					<%@page import="java.util.ArrayList"%>
					<%@page import="SqlConn.ConnectionProvider"%>
					<%@page import="newsManage.AddPostNewsClass"%>
					<%@page import="newsManage.AddPostNewsDao"%>

    
<!DOCTYPE html>
<html>
<head>
<!-- Required below  meta tags change gareko x -->
    <meta charset="utf-8"><meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<title>All News List</title>
<!-- Bootstrap css file which is must be above custom css file -->
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="icon" href="images/soeslogo.jpg">

<style>
.news-title a{
color:maroon;
margin-left:1rem;
margin-right:1rem;
text-decoration:none;
}
.news-title a:hover{
background-color:white;
color:red;
}
</style>

</head>
<body>
		<%@ include file="header.jsp" %>
						

<div class="container-fluid d-flex justify-content-center" style="background-color: lightyellow;">
			<div class="row col-sm-10">
			<h2 class="text-center text-info bg-dark">ALL NEWS LIST</h2>
			
				<table class="table-bordered text-center">
					<tr class="text-white bg-success">
						<th class="h3">Date</th>
						<th class="h3">Title</th>
						
					</tr>
	<%
								try{
					Connection con=ConnectionProvider.getCon();

					AddPostNewsDao npdao=new AddPostNewsDao();
					ArrayList<AddPostNewsClass> newspostlist=npdao.getAllPost();
					
								for(AddPostNewsClass allnewslistpage:newspostlist){
									
									%>
<tr style="background-color: #F5F5DC;height:3rem;">
<td class="h6 fw-normal" width="120rem"><%= allnewslistpage.getpDate() %></td>
<td class="news-title h5  text-break"><a href="<%=request.getContextPath()%>/NewsView?newsId=<%= allnewslistpage.getpId() %>"><%= allnewslistpage.getpTitle()%></a>
</td>
<td></td>

</tr>
	
					<%
					
								

					}con.close();
								}catch(Exception e){
								String	resultMessage = "Server error occur : " + e.getMessage();

									request.setAttribute("Message", resultMessage);
									RequestDispatcher dispatcher=request.getRequestDispatcher("Result.jsp");
									dispatcher.forward(request, response);
								}
								
					%>
				</table>
				</div>
				</div>	
				<%@ include file="footer.jsp" %>
				
	<!-- JQuery must be above bootstrap js file -->
	<!-- Bootstrap js file or JavaScript Bundle with Popper -->
	<script src="js/bootstrap.bundle.min.js"></script>
				

</body>
</html>