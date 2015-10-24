package HomeWork151022;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.PseudoColumnUsage;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class DBManager {

	private static Connection connection;

	static {
		System.out.println("Inizializing DB connection");
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost/Students?user=root");
			// Statement statement = connection.createStatement();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

		// shutdown hook -- выполнение кода по завершении работы программы,
		// например UseDB
		Runtime.getRuntime().addShutdownHook(new Thread() {
			@Override
			public void run() {
				System.out.println("shutting down DB connection");
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		});

	}

	public static <T> T get(Class<T> clazz, int id) {

		String tableName = clazz.getSimpleName().toLowerCase();

		try {
			PreparedStatement st = connection.prepareStatement("select * from " + tableName + " where id = ?");
			st.setInt(1, id);

			ResultSet rs = st.executeQuery();

			T t = load(rs, clazz);

			return t;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	private static <T> T load(ResultSet rs, Class<T> clazz) throws SQLException {

		rs.next();

		try {
			T t = clazz.newInstance();

			ResultSetMetaData metaData = rs.getMetaData();
			for (int i = 1; i <= metaData.getColumnCount(); i++) {
				String name = metaData.getColumnName(i);
				char[] charArray = name.toCharArray();
				charArray[0] = name.toUpperCase().charAt(0);
				String setterName = "set" + new String(charArray);
				Method setter = clazz.getMethod(setterName, String.class);
				setter.invoke(t, rs.getString(i));
			}

			return t;

		} catch (InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
			e.printStackTrace();
		}

		return null;
	}

	public static <T> void save(Class<T> clazz, T t) {

		String tableName = clazz.getSimpleName().toLowerCase();
		List<String> values = new LinkedList<>();

		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("desc " + tableName);
			while (resultSet.next()) {
				String field = resultSet.getString(1);
				char[] charArray = field.toCharArray();
				charArray[0] = field.toUpperCase().charAt(0);
				String getterName = "get" + new String(charArray);
				Method getter = clazz.getMethod(getterName, null);
				String value = (String) getter.invoke(t, null);
				values.add(value);
			}
			statement.close();
			resultSet.close();
			insertIntoDB(values, tableName);
		} catch (SQLException | NoSuchMethodException 
				| SecurityException | IllegalAccessException
				| IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
		} 
	}

	private static void insertIntoDB(List<String> values, 
			String tableName) throws SQLException {
		
		int size = values.size();

		StringBuilder sql = new StringBuilder(
				"insert into " + tableName + " values (?");
		for (int i = 1; i < size; i++) {
			sql.append(", ?");
		}
		sql.append(");");

		String sqlString = new String(sql);
		PreparedStatement prepareStatement = 
				connection.prepareStatement(sqlString);
			
		int pos = 1;
		for (String value : values) {
			prepareStatement.setString(pos++, value);
		}
		int executeUpdate = prepareStatement.executeUpdate();
		if (1 == executeUpdate) {
			System.out.println("ok");
		} else {
			System.out.println("cannot insert into DB:");
			System.out.println(prepareStatement);
			throw new SQLException(); 
		}
		
	}

}
