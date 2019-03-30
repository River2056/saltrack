package test;

import java.util.List;

import dao.SalaryDAO;
import dao.UserDAO;
import entity.Salary;
import entity.User;

public class Test {
	
	public static void testFindUser() {
		UserDAO dao = new UserDAO();
		User user = dao.find("river2056");
		System.out.println(user);
	}
	
	public static void testCount() {
		SalaryDAO dao = new SalaryDAO();
		double[] sal = dao.count();
		for(double d : sal) {
			System.out.println(d);
		}
	}
	
	public static void testAdd() {
		SalaryDAO dao = new SalaryDAO();
		Salary sal = new Salary(9, 1700, "2019-03-09", "full", 0, "test");
		dao.add(sal);
	}

	public static void testList() {
		SalaryDAO dao = new SalaryDAO();
		List<Salary> salList = dao.listAll();
		System.out.println(salList);
	}
	
	public static void main(String[] args) {
//		testList();
//		testAdd();
//		testCount();
		testFindUser();
		
	}
	
}
