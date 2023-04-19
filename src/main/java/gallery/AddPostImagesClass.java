package gallery;

public class AddPostImagesClass {
private int pId;
private String pDate;
private String pAboutImage;
private String pImage;

public AddPostImagesClass() {
	
	
}
public AddPostImagesClass(int postId,String postDate, String postAboutImage, String postImage) {
	this.pId=postId;
	this.pDate = postDate;
	this.pAboutImage = postAboutImage;
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
public String getpAboutImage() {
	return pAboutImage;
}
public void setpAboutImages(String pAboutImage) {
	this.pAboutImage = pAboutImage;
}

public String getpImage() {
	return pImage;
}
public void setpImage(String pImage) {
	this.pImage = pImage;
}

}
