package newsManage;

public class AddPostNewsClass {
private int pId;
private String pDate;
private String pTitle;
private String pDescription;
private String pImage;

public AddPostNewsClass() {
	
	
}
public AddPostNewsClass(int postId,String postDate, String postTitle, String postDescription, String postImage) {
	this.pId=postId;
	this.pDate = postDate;
	this.pTitle = postTitle;
	this.pDescription = postDescription;
	this.pImage = postImage;
}

public int getpId() {
	return pId;
}
public void setpId(int pId) {
	this.pId = pId;
}
public String getpDate() {
	return pDate;
}
public void setpDate(String pDate) {
	this.pDate = pDate;
}
public String getpTitle() {
	return pTitle;
}
public void setpTitle(String pTitle) {
	this.pTitle = pTitle;
}
public String getpDescription() {
	return pDescription;
}
public void setpDescription(String pDescription) {
	this.pDescription = pDescription;
}
public String getpImage() {
	return pImage;
}
public void setpImage(String pImage) {
	this.pImage = pImage;
}

}
