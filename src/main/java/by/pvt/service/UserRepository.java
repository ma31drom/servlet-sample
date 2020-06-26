package by.pvt.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import by.pvt.models.UserInfo;

public class UserRepository implements IUserRepository {

	private static final String CREATE_POS = "INSERT INTO public.\"position\" (name)\n" + "VALUES (?)";
	private static final String CREATE_DEPT = "INSERT INTO public.\"department\" (name)\n" + "VALUES (?)";
	private static final String CREATE_USER = "INSERT INTO public.\"employee\" (name,salary,deptnum,position_id)\n"
			+ "	VALUES (?,?,?,?)";

	static private UserRepository instance = new UserRepository();
	private Properties connectionDetails;

	static private String GET_ALL_SQL = "select e.id, e.name, e.salary, d.name as deptName, p.name as posName"
			+ " from public.\"employee\" e join public.\"department\" d on e.deptnum = d.id"
			+ " join public.\"position\" p on e.position_id = p.id";
	static private String GET_BY_ID = GET_ALL_SQL + " where e.id = ?";
	static private String DELETE_BY_ID = "delete from public.\"employee\" where id = ?";

	private UserRepository() {

		try {

			Properties properties = new Properties();
			properties.load(getClass().getClassLoader().getResourceAsStream("database.properties"));

			Class.forName(properties.getProperty("driver"));
			connectionDetails = properties;

		} catch (Exception e) {
			throw new RuntimeException(e);
		}

	}

	public static UserRepository getInstance() {
		return instance;
	}

	public List<UserInfo> getAllUsers() throws SQLException {

		List<UserInfo> result = new ArrayList<>();

		try (Connection connection = getConnection();
				Statement stmt = connection.createStatement();
				ResultSet rs = stmt.executeQuery(GET_ALL_SQL)) {

			while (rs.next()) {
				result.add(mapUser(rs));
			}

		}
		return result;
	}

	public UserInfo getUserById(Long id) throws SQLException {
		try (Connection connection = getConnection(); PreparedStatement stmt = connection.prepareStatement(GET_BY_ID)) {
			stmt.setLong(1, id);
			ResultSet rs = stmt.executeQuery();
			UserInfo userInfo = null;
			if (rs.next()) {
				userInfo = mapUser(rs);
			}
			rs.close();
			return userInfo;
		}
	}

	public boolean deleteUserById(Long id) throws SQLException {
		try (Connection connection = getConnection();
				PreparedStatement stmt = connection.prepareStatement(DELETE_BY_ID)) {
			stmt.setLong(1, id);
			int rs = stmt.executeUpdate();
			return rs == 1;
		}
	}

	private UserInfo mapUser(ResultSet rs) throws SQLException {
		UserInfo userInfo = new UserInfo();
		userInfo.setId(rs.getLong(1));
		userInfo.setName(rs.getString("name"));
		userInfo.setSalary(rs.getDouble(3));
		userInfo.setDepartmentName(rs.getString(4));
		userInfo.setPositionName(rs.getString(5));
		return userInfo;
	}

	private Connection getConnection() throws SQLException {
		return DriverManager.getConnection(connectionDetails.getProperty("url"), connectionDetails.getProperty("user"),
				connectionDetails.getProperty("password"));
	}

	public UserInfo createUser(UserInfo readValue) throws SQLException {
		try (Connection connection = getConnection();
				PreparedStatement stmtD = connection.prepareStatement(CREATE_DEPT, Statement.RETURN_GENERATED_KEYS);
				PreparedStatement stmtP = connection.prepareStatement(CREATE_POS, Statement.RETURN_GENERATED_KEYS);
				PreparedStatement stmtU = connection.prepareStatement(CREATE_USER, Statement.RETURN_GENERATED_KEYS);) {

			int createDept = create(readValue.getDepartmentName(), stmtD);
			int createPos = create(readValue.getPositionName(), stmtP);

			stmtU.setString(1, readValue.getName());
			stmtU.setDouble(2, readValue.getSalary());
			stmtU.setInt(3, createDept);
			stmtU.setInt(4, createPos);
			stmtU.executeUpdate();
			ResultSet generatedKeys = stmtU.getGeneratedKeys();
			generatedKeys.next();
			long uId = generatedKeys.getLong(1);
			generatedKeys.close();
			readValue.setId(uId);
			return readValue;
		}
	}

	private int create(String readValue, PreparedStatement stmtD) throws SQLException {
		stmtD.setString(1, readValue);
		stmtD.executeUpdate();
		ResultSet generatedKeys = stmtD.getGeneratedKeys();
		generatedKeys.next();
		long depNum = generatedKeys.getLong(1);
		generatedKeys.close();
		return (int) depNum;
	}

}
