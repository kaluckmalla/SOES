package eventManage;

public class AddPostEventClass {

private int pId;
private String pDate;
private String pTitle;
private String pStartDate;
private String pStartTime;
private String pEndDate;
private String pEndTime;
private String pDescription;


public AddPostEventClass() {
	
	
}
//parameter anusar call garx 

//Section : coding for fields not image

//for only storing fields data
public AddPostEventClass(int postId, String postDate, String postTitle, String postStartDate, String postStartTime,
		String postEndDate, String postEndTime, String postDescription) {
	super();
	this.pId = postId;
	this.pDate = postDate;
	this.pTitle = postTitle;
	this.pStartDate = postStartDate;
	this.pStartTime = postStartTime;
	this.pEndDate = postEndDate;
	this.pEndTime = postEndTime;
	this.pDescription = postDescription;
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
public String getpStartDate() {
	return pStartDate;
}
public void setpStartDate(String pStartDate) {
	this.pStartDate = pStartDate;
}
public String getpStartTime() {
	return pStartTime;
}
public void setpStartTime(String pStartTime) {
	this.pStartTime = pStartTime;
}
public String getpEndDate() {
	return pEndDate;
}
public void setpEndDate(String pEndDate) {
	this.pEndDate = pEndDate;
}
public String getpEndTime() {
	return pEndTime;
}
public void setpEndTime(String pEndTime) {
	this.pEndTime = pEndTime;
}

public String getpDescription() {
	return pDescription;
}
public void setpDescription(String pDescription) {
	this.pDescription = pDescription;
}

}
