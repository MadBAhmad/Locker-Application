package locker.users;

public class UserCredentialspickup {
	
	private String websiteName;
	private String loggedInUser;
	private String username;
	private String password;

public UserCredentialspickup() {}

public UserCredentialspickup(String websiteName, String loggedInUser, String username, String password)
{
	this.websiteName = websiteName;
	this.loggedInUser = loggedInUser;
	this.username = username;
	this.password = password;
}
 public String getwebsiteName()
 {
	 return websiteName;
 }
 public void setwebsiteName(String websiteName)
 {
	 this.websiteName = websiteName;
 }
 public String getloggedInuser()
 {
	return loggedInUser; 
 }
 public void setloggedInUser(String loggedInUser)
 {
	 this.loggedInUser = loggedInUser;
 }
 public String getusername()
 {
	 return username;
 }
 public void setusername(String username)
 {
	 this.username = username;
 }
 public String getpassword()
 {
	 return password;
 }
 public void setpassword(String password)
 {
	 this.password = password;
 }
 
 public String toString()
 {
	 return "UserCredentials [websiteName="+ websiteName +", loggedInUser="+ loggedInUser +", username="+ username +", password="+ password +"/n/n]";
 }
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 }