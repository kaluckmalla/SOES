package newsManage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import SqlConn.ConnectionProvider;

public class AddPostNewsDao {
	Connection con=ConnectionProvider.getCon();
	ResultSet rs=null;
	PreparedStatement ps=null;
	
	// We can use/display news post data in jsp page by calling getAllPost object

	public ArrayList<AddPostNewsClass> getAllPost(){
		ArrayList<AddPostNewsClass> postlist=new ArrayList<>();
		try {

			ps= con.prepareStatement("select * from news order by id desc");

			rs = ps.executeQuery();

			while(rs.next())
			{
				int postId=rs. getInt("id");
				String postDate=rs. getString("date");
				String postTitle=rs. getString("title");
				String postDescription=rs. getString("description");
				String postImage=rs.getString("image");
				
				AddPostNewsClass pn=new AddPostNewsClass(postId,postDate, postTitle,postDescription,postImage);
				postlist.add(pn);

			}

		} catch (Exception e) {
			e.printStackTrace();// TODO: handle exception
		}
		return postlist;
	}

	// save news in database


	public boolean savePost(AddPostNewsClass apnc) {
		boolean f=false;

		try {

							// Step 2:Create a statement using connection object
				ps= con.prepareStatement("insert into news values(null,?,?,?,?)");
				ps.setString(1, apnc.getpDate());
				ps.setString(2, apnc.getpTitle());
				ps.setString(3, apnc.getpDescription());
				ps.setString(4, apnc.getpImage());


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
