package gallery;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import SqlConn.ConnectionProvider;

public class AddPostImagesDao {
	Connection con=ConnectionProvider.getCon();
	ResultSet rs=null;
	PreparedStatement ps=null;
	
	// We can use/display news post data in jsp page by calling getAllPost object

	public ArrayList<AddPostImagesClass> getAllPost(){
		ArrayList<AddPostImagesClass> postlist=new ArrayList<>();
		try {

			ps= con.prepareStatement("select * from photogallery order by id desc");

			rs = ps.executeQuery();

			while(rs.next())
			{
				int postId=rs. getInt(1);
				String postDate=rs. getString(2);
				String postAboutImage=rs. getString(3);
				String postImage=rs.getString(4);
				
				AddPostImagesClass pn=new AddPostImagesClass(postId,postDate, postAboutImage,postImage);
				postlist.add(pn);

			}

		} catch (Exception e) {
			e.printStackTrace();// TODO: handle exception
		}
		return postlist;
	}

	// save news in database


	public boolean savePost(AddPostImagesClass apnc) {
		boolean f=false;

		try {

							// Step 2:Create a statement using connection object
				ps= con.prepareStatement("insert into photogallery values(null,?,?,?)");
				ps.setString(1, apnc.getpDate());
				ps.setString(2, apnc.getpAboutImage());
				ps.setString(3, apnc.getpImage());


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
