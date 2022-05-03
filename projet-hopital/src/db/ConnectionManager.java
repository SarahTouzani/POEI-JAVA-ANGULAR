package db;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionManager {

	private String driverClass;
	private String url;
	private String username;
	private String password;
	private Connection conn;

	private static ConnectionManager connectionManager;

	private ConnectionManager() throws ClassNotFoundException, IOException, SQLException {
		setConnection();
	}

	public static ConnectionManager getConnectionManager() throws ClassNotFoundException, IOException, SQLException {

		if (connectionManager == null) {
			connectionManager = new ConnectionManager();
		}
		return connectionManager;
	}

	public Connection getConn() {
		return conn;
	}

	public void closeConnection() throws SQLException {

		if (conn != null) {
			conn.close();
		}
	}

	private void setConnection() throws IOException, ClassNotFoundException, SQLException {

		Properties prop = loadPropertiesFile();

		driverClass = prop.getProperty("driver");
		url = prop.getProperty("url");
		username = prop.getProperty("username");
		password = prop.getProperty("password");

		Class.forName(driverClass);

		conn = DriverManager.getConnection(url, username, password);
	}

	private Properties loadPropertiesFile() throws IOException {

		Properties prop = new Properties();
		InputStream in = new FileInputStream("jdbc.properties");
		prop.load(in);
		in.close();

		return prop;
	}

}
