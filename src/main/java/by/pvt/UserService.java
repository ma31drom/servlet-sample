package by.pvt;

import java.util.HashMap;
import java.util.Map;

public class UserService {

	Map<String, UserInfo> users = new HashMap<String, UserInfo>();

	{
		users.put("Max", new UserInfo("Max", "Max", "Max"));
	}

	static private UserService instance = new UserService();

	private UserService() {
		super();
	}

	public UserInfo getUserByPassAndName(String password, String name) {
		UserInfo ui = users.get(name);
		if (ui != null) {
			if (ui.getPassword().contentEquals(password)) {
				return ui;
			} else
				return null;
		}
		return null;
	}

	static UserService getInstance() {
		return instance;
	}

}
