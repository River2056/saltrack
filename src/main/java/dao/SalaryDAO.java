package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import entity.Salary;
import entity.Tracker;
import util.DBUtils;

public class SalaryDAO {
	
	public double[] count() {
		double sum = 0;
		double day = 0;
		Connection conn = null;
		try {
			conn = DBUtils.getConnection();
			String currentDate = new SimpleDateFormat("yyyy-MM").format(Calendar.getInstance().getTime());
			String sql = "select extract(month from workdate) `month`, worktime, count(*) quan, daysal "
					+ "from sal where workdate like '" + currentDate + "-%' group by worktime;";
			Statement stat = conn.createStatement();
			ResultSet rs = stat.executeQuery(sql);
			while(rs.next()) {
				String workTime = rs.getString("worktime");
				double quantity = rs.getDouble("quan");
				double daySalary = rs.getDouble("daysal");
				Tracker trk = new Tracker();
				trk.setWorkTime(workTime);
				trk.setQuantity(quantity);
				trk.setDaySalary(daySalary);
				sum += trk.getTotal();
				day += trk.getDays();
			}
			double[] result = {sum, day};
			return result;
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			DBUtils.closeConnection(conn);
		}
	}
	
	public void delete(int id) {
		Connection conn = null;
		try {
			conn = DBUtils.getConnection();
			String sql = "DELETE FROM sal WHERE id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ps.executeUpdate();
			
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			DBUtils.closeConnection(conn);
		}
		
	}
	
	public void add(Salary sal) {
		Connection conn = null;
		try {
			conn = DBUtils.getConnection();
			String sql = "INSERT INTO sal(daysal, workdate, worktime, overtime, comments) VALUES(?, ?, ?, ?, ?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, sal.getDaysal());
			ps.setString(2, sal.getWorkdate());
			ps.setString(3, sal.getWorktime());
			ps.setInt(4, sal.getOvertime());
			ps.setString(5, sal.getComments());
			int check = ps.executeUpdate();
			System.out.println("check: " + check);
			if(check != 1) {
				throw new RuntimeException("Insertion Error!");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			DBUtils.closeConnection(conn);
		}
		
	}

	public List<Salary> listAll() {
		Connection conn = null;
		List<Salary> list = new ArrayList<Salary>();
		
		try {
			conn = DBUtils.getConnection();
			String currentDate = new SimpleDateFormat("yyyy-MM").format(Calendar.getInstance().getTime());
			String sql = "SELECT * FROM sal WHERE workdate LIKE '" + currentDate + "-%' ORDER BY workdate";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				int id = rs.getInt("id");
				int daysal = rs.getInt("daysal");
				String workdate = rs.getString("workdate");
				String worktime = rs.getString("worktime");
				int overtime = rs.getInt("overtime");
				String comments = rs.getString("comments");
				
				Salary sal = new Salary(id, daysal, workdate, worktime, overtime, comments);
				list.add(sal);
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			DBUtils.closeConnection(conn);
		}
		
		return list;
	}
}
