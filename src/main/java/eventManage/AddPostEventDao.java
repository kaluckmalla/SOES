package eventManage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import SqlConn.ConnectionProvider;

public class AddPostEventDao {
	Connection con=ConnectionProvider.getCon();
	ResultSet rs=null;
	PreparedStatement ps=null;
	
	// We can use/display event post data in jsp page by calling getAllPost object

	public ArrayList<AddPostEventClass> getAllPost(){
		ArrayList<AddPostEventClass> postlist=new ArrayList<>();
		try {

			ps= con.prepareStatement("select * from event news order by id desc");

			rs = ps.executeQuery();

			while(rs.next())
			{//junsukai page bata access garnako laagi store gareko
				int postId=rs. getInt("id");
				String postDate=rs. getString("date");
				String postTitle=rs.getString("title");
				String postStartDate=rs.getString("start_date");
				String postStartTime=rs.getString("start_time");
				String postEndDate=rs.getString("end_date");
				String postEndTime=rs.getString("end_time");
				String postDescription=rs.getString("description");
				

				//For storing field data not image    can be call by argument matching
				AddPostEventClass peFields=new AddPostEventClass(postId,postDate,postTitle,postStartDate,postStartTime,postEndDate,postEndTime,postDescription);
				postlist.add(peFields);
				
			}

		} catch (Exception e) {
			e.printStackTrace();// TODO: handle exception
		}
		return postlist;
	}

	//Section 1: coding for fields not image

	// save only fields data in event table  in database


	public boolean savePostOnlyFields(AddPostEventClass apncFields) {
		boolean f=false;

		try {

							// Step 2:Create a statement using connection object
				ps= con.prepareStatement("insert into event values(null,?,?,?,?,?,?,?)");
				ps.setString(1, apncFields.getpDate());
				ps.setString(2, apncFields.getpTitle());
				ps.setString(3, apncFields.getpStartDate());
				ps.setString(4, apncFields.getpStartTime());
				ps.setString(5, apncFields.getpEndDate());
				ps.setString(6, apncFields.getpEndTime());
				ps.setString(7, apncFields.getpDescription());


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
