package HomeWork151019;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.sql.Date;

public class Family {

	private static final String sql = 
		"insert into person values (0, ?, ?, ?, ?);";
	private static final String regex = 
		"(\\S+) (\\d{1,4}-\\d{1,2}-\\d{1,2}) (\\d+) (\\d+\\.?\\d*)";


	public static void main(String[] args) {

		Connection connection = null;
		PreparedStatement ps = null;
		Pattern pattern = Pattern.compile(regex);

		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(
				"jdbc:mysql://localhost/family?user=root");

			ps = connection.prepareStatement(sql);

			Scanner scanner = new Scanner(System.in);
			greeting();
			while (scanner.hasNextLine()){

				String line = scanner.nextLine();
				if (line.equals("")) {
					break;
				}

				Matcher matcher = pattern.matcher(line);
				if (!matcher.matches()) {
					System.out.println("incorrect person's data");
					continue;
				}

				insertIntoDB (ps, 
					matcher.group(1),	// name 
					Date.valueOf(matcher.group(2)), //dob
					Integer.parseInt(matcher.group(3)), //height
					Float.parseFloat(matcher.group(4))); //weight

			}
			scanner.close();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (null != connection) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (null != ps) {
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

		}

	}

	private static void greeting() {
		System.out.println("Enter person's data in format:");
		System.out.println("<name> <dob> <height> <weight>");
		System.out.println("Example: Askur 1016-04-01 170 70.1");
		System.out.println("Empty line is end of input");
	}

	private static void insertIntoDB( PreparedStatement ps,
		String name, Date dob, int height, float weight) 
	{
		try {
			ps.setString(1, name);
			ps.setDate(2, dob);
			ps.setInt(3, height);
			ps.setFloat(4, weight);
			int executeUpdate = ps.executeUpdate();
			if (1 == executeUpdate) {
				System.out.println("ok");
			} else {
				throw new SQLException(); 
			}
//			System.out.println(executeUpdate + " rows affected");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
