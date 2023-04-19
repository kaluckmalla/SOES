package studyMaterial;

public class AddPostStudyMaterialClass {
private int pId;
private String pDate;
private String pFaculty;
private String pSemester;
private String pType;
private String pSubject;

private String pFile;

public AddPostStudyMaterialClass() {
	
	
}
public AddPostStudyMaterialClass(int postId,String postDate, String postFaculty, String postSemester,String postType,String postSubject,String postFile) {
	this.pId=postId;
	this.pDate = postDate;
	this.pFaculty = postFaculty;
	this.pSemester = postSemester;
	this.pType = postType;
	this.pSubject = postSubject;

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
public String getpFaculty() {
	return pFaculty;
}
public void setpFaculty(String pFaculty) {
	this.pFaculty = pFaculty;
}
public String getpSemester() {
	return pSemester;
}
public void setpSemester(String pSemester) {
	this.pSemester = pSemester;
}
public String getpType() {
	return pType;
}
public void setpType(String pType) {
	this.pType = pType;
}
public String getpSubject() {
	return pSubject;
}
public void setpSubject(String pSubject) {
	this.pSubject = pSubject;
}
public String getpFile() {
	return pFile;
}
public void setpFile(String pFile) {
	this.pFile = pFile;
}

}
