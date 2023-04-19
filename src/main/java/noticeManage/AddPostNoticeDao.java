package noticeManage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import SqlConn.ConnectionProvider;

public class AddPostNoticeDao {
	Connection con=ConnectionProvider.getCon();
	ResultSet rs=null;
	PreparedStatement ps=null;
	
	// We can use/display notice post data in jsp page by calling getAllPost object
	
	public ArrayList<AddPostNoticeClass> getAllPost(){
		ArrayList<AddPostNoticeClass> postlist=new ArrayList<>();
		try {

			ps= con.prepareStatement("select * from notice order by id desc");

			rs = ps.executeQuery();

			while(rs.next())
			{
				int postId=rs. getInt("id");
				String postDate=rs. getString("date");

				String postTitle=rs. getString("title");
				String postFile=rs.getString("file");
				
				AddPostNoticeClass pn=new AddPostNoticeClass(postId,postDate, postTitle,postFile);
				postlist.add(pn);


			}


		} catch (Exception e) {
			e.printStackTrace();// TODO: handle exception
		}
		return postlist;

	}


	// save notice in database
	public boolean savePost(AddPostNoticeClass apnc) {
		boolean f=false;

		try {
							// Create a statement using connection object
				ps= con.prepareStatement("insert into notice values(null,?,?,?)");
				ps.setString(1, apnc.getpDate());
				ps.setString(2, apnc.getpTitle());
				ps.setString(3, apnc.getpFile());


				ps.executeUpdate();

				f=true;

			
		}catch (SQLException e) {
			// process sql exception
			e.printStackTrace();
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
		return f;


	}


}
