package group.pro150.Datastore;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class DatabaseConnection {

	public static String DatabaseConnetionString = "jdbc:sqlserver://pro-150.database.windows.net:1433;database=Pro150;user=MCurtis@pro-150;password={Rock1000};encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;";
	public static final String DIRVERNAME = "com.microsoft.sqlserver.jdbc.SQLServerDriver";

	public static String getDatabaseConnetionString() {
		return DatabaseConnetionString;
	}

	public static String getDRIVERNAME() {
		return DIRVERNAME;
	}

	/**
	 * 
	 * @param table
	 *            the table to be selected from
	 * @param columns
	 *            the column you wish to select if no column is given all columns
	 *            will be selected
	 * @return the reslut of the query
	 */
	public static String SelectFromTable(String table, String... columns) {
		String sql = "Select ";
		String query = "";
		int size = columns.length;
		if (columns.length > 0) {
			for (int i = 0; i < columns.length; i++) {
				sql += columns[i];
				if (i != size - 1) {
					sql += ",";
				}
			}
		}
		sql += " From ";
		sql += table;
		try {
			Class.forName(getDRIVERNAME());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println(sql + "/n" + query);
		}
		try (Connection connection = DriverManager.getConnection(getDatabaseConnetionString())) {
			try (PreparedStatement statement = connection.prepareStatement(sql)) {
				try (ResultSet resultSet = statement.executeQuery()) {
					ResultSetMetaData meta = resultSet.getMetaData();
					int columnLength = meta.getColumnCount();
					while (resultSet.next()) {
						for (int i = 1; i <= columnLength; i++) {
							query += resultSet.getString(i);
							if (i > 1) {
								query += ",";
							}
						}
					}
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(sql + "/n" + query);
		}
		return query;
	}

	/**
	 * 
	 * @param table
	 *            the table being selected from
	 * @param whereValue
	 *            Where "Value" =
	 * @param whereEquils
	 *            = "Equils"
	 * @param columns
	 *            the column you wish to select if no column is given all columns
	 *            will be selected
	 * @return
	 */
	public static String SelectWithWhereFromTable(String table, String whereValue, String whereEquils,
			String... columns) {
		String sql = "Select ";
		int size = columns.length;
		if (size > 0) {
			for (int i = 0; i < columns.length; i++) {
				sql += columns[i];
				if (i != size - 1) {
					sql += ",";
				}
			}
		} else {
			sql += " * ";
		}
		sql += " From ";
		sql += table;
		sql += " Where ";
		sql += whereValue;
		sql += " = ";
		sql = whereEquils;
		String query = "";
		try {
			Class.forName(getDRIVERNAME());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println(sql + "/n" + query);
		}
		try (Connection connection = DriverManager.getConnection(getDatabaseConnetionString())) {
			try (PreparedStatement statement = connection.prepareStatement(sql)) {
				try (ResultSet resultSet = statement.executeQuery()) {
					ResultSetMetaData rMetaData = resultSet.getMetaData();
					int columnLength = rMetaData.getColumnCount();
					while (resultSet.next()) {
						for (int i = 1; i >= columnLength; i++) {
							query += resultSet.getString(i);
							if (i > 1) {
								query += ",";
							}
						}
					}
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(sql + "/n" + query);
		}
		return query;
	}

	public static boolean InsertIntoTable(String table, String[] values, String[] columns) {
		String sql = "Insert into " + table + " (";
		if (columns.length > 0) {
			for (int i = 0; i < columns.length; i++) {
				sql += columns[i];
				if (i != columns.length - 1) {
					sql += ",";
				}
			}
			sql += ")";
		} else {
			sql = "";
		}
		sql += " Values (";
		if (values.length > 0) {
			for (int i = 0; i < values.length; i++) {
				sql += values[i];
				if (i != values.length - 1) {
					sql += ",";
				}
			}
			sql += ")";
		} else {
			sql = "";
		}
		try {
			Class.forName(getDRIVERNAME());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try (Connection connection = DriverManager.getConnection(getDatabaseConnetionString())) {
			try (PreparedStatement statement = connection.prepareStatement(sql)) {
				statement.executeQuery();
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(sql);
			return false;
		}
		return true;
	}

	public static boolean InsterIntoTableWithWhere(String table, String[] values, String[] columns, String where,
			String wherevalue) {
		return false;
	}

}
