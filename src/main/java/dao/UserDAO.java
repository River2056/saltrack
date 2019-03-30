package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import entity.User;
import util.DBUtils;

public class UserDAO {
	
	public User find(String username) {
		User user = null;
		Connection conn = null;
		try {
			conn = DBUtils.getConnection();
			String sql = "SELECT * FROM user WHERE username = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				user = new User();
				user.setId(rs.getInt("id"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
			
		} finally {
			DBUtils.closeConnection(conn);
			
		}
		
		return user;
	}
	
}
