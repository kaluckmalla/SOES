package studyMaterial;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import SqlConn.ConnectionProvider;

public class AddPostStudyMaterialDao {
	Connection con=ConnectionProvider.getCon();
	ResultSet rs=null;
	PreparedStatement ps=null;
	
	// We can use/display notice post data in jsp page by calling getAllPost object
	
	public ArrayList<AddPostStudyMaterialClass> getAllPost(){
		ArrayList<AddPostStudyMaterialClass> postlist=new ArrayList<>();
		try {

			ps= con.prepareStatement("select * from studymaterial order by id desc");

			rs = ps.executeQuery();

			while(rs.next())
			{
				int postId=rs. getInt(1);
				String postDate=rs. getString(2);
				String postFaculty=rs. getString(3);
				String postSemester=rs. getString(4);
				String postType=rs. getString(5);

				String postSubjectName=rs. getString(6);
				String postFileName=rs.getString(7);
				
				AddPostStudyMaterialClass asmc=new AddPostStudyMaterialClass(postId,postDate, postFaculty,postSemester,postType,postSubjectName,postFileName);
				postlist.add(asmc);


			}


		} catch (Exception e) {
			e.printStackTrace();// TODO: handle exception
		}
		return postlist;

	}


	// save notice in database
	public boolean savePost(AddPostStudyMaterialClass apsmc) {
		boolean f=false;

		try {
							// Create a statement using connection object
				ps= con.prepareStatement("insert into studymaterial values(null,?,?,?,?,?,?)");
				ps.setString(1, apsmc.getpDate());
				ps.setString(2, apsmc.getpFaculty());
				ps.setString(3, apsmc.getpSemester());
				ps.setString(4, apsmc.getpType());

				ps.setString(5, apsmc.getpSubject());

				ps.setString(6, apsmc.getpFile());


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
