package by.pvt;

public class UserInfo {

	public UserInfo() {
		super();
	}

	public UserInfo(String username, String password, String age) {
		super();
		this.username = username;
		this.password = password;
		this.age = age;
	}

	String username;
	String password;
	String age;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

}
