package noticeManage;

public class AddPostNoticeClass {
private int pId;
private String pDate;
private String pTitle;
private String pFile;

public AddPostNoticeClass() {
	
	
}
public AddPostNoticeClass(int postId,String postDate, String postTitle, String postFile) {
	this.pId=postId;
	this.pDate = postDate;
	this.pTitle = postTitle;
	this.pFile = postFile;
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
public String getpFile() {
	return pFile;
}
public void setpFile(String pFile) {
	this.pFile = pFile;
}

}
