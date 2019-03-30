package util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.commons.dbcp.BasicDataSource;

public class DBUtils {
	static String driverClassName, url, username, password;
	static int initialSize, maxActive;
	static BasicDataSource bds = null;
	
	static {
		bds = new BasicDataSource();
		Properties cfg = new Properties();
		InputStream inStream = DBUtils.class.getClassLoader().getResourceAsStream("db.properties");
		try {
			cfg.load(inStream);
			driverClassName = cfg.getProperty("jdbc.className");
			url = cfg.getProperty("jdbc.url");
			username = cfg.getProperty("jdbc.user");
			password = cfg.getProperty("jdbc.password");
			initialSize = Integer.parseInt(cfg.getProperty("InitialSize"));
			maxActive = Integer.parseInt(cfg.getProperty("MaxActive"));
			
			bds.setDriverClassName(driverClassName);
			bds.setUrl(url);
			bds.setUsername(username);
			bds.setPassword(password);
			bds.setInitialSize(initialSize);
			bds.setMaxActive(maxActive);
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() throws SQLException {
		Connection conn = bds.getConnection();
		return conn;
	}
	
	public static void closeConnection(Connection conn) {
		if(conn != null) {
			try {
				// 先還原為原樣, 再歸還給連接池
				conn.setAutoCommit(true);
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	// 增加rollback方法
	public static void rollback(Connection conn) {
		if(conn != null) {
			try {
				conn.rollback();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
}
