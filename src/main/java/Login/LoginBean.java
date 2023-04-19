package Login;

import java.io.Serializable;

public class LoginBean implements Serializable {
    /**
     * 
     */
	private static final long serialVersionUID = 1L;
	private String useremail;
    private String userpassword;
    
    public String getUseremail() {
        return useremail;
    }

    public void setUseremail(String useremail) {
        this.useremail = useremail;
    }

    public String getUserpassword() {
        return userpassword;
    }

    public void setUserpassword(String userpassword) {
        this.userpassword = userpassword;
    }
}