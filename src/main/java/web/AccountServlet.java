package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.SalaryDAO;
import dao.UserDAO;
import entity.Salary;
import entity.User;

public class AccountServlet extends HttpServlet {

	public void updateList(SalaryDAO dao, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Salary> list = dao.listAll();
		request.setAttribute("list", list);
		RequestDispatcher rd = request.getRequestDispatcher("list.jsp");
		rd.forward(request, response);
	}
	
	public void checkForSession(HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession session = request.getSession();
		Object obj = session.getAttribute("user");
		
		if(obj == null) {
			response.sendRedirect("login.jsp");
		}
		return;
	}
	
	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		String uri = request.getRequestURI();
		String action = uri.substring(uri.lastIndexOf("/"), uri.lastIndexOf("."));
		System.out.println(uri);
		System.out.println(action);
	
		if("/menu".equals(action)) {
			checkForSession(request, response);
			
			response.sendRedirect("menu.jsp");
		
	 	} else if("/list".equals(action)) {
	 		checkForSession(request, response);
			
			// list all records
			SalaryDAO dao = new SalaryDAO();
			try {
				updateList(dao, request, response);
				
			} catch (Exception e) {
				e.printStackTrace();
				out.println("System busy, Please try again later!");
			}
			
		} else if("/add".equals(action)) {
			checkForSession(request, response);
			
			// add day feature
			int daysal = Integer.parseInt(request.getParameter("daysal"));
			String workdate = request.getParameter("workdate");
			String worktime = request.getParameter("worktime");
			String comments = request.getParameter("comments");
			SalaryDAO dao = new SalaryDAO();
			Salary sal = new Salary();
			sal.setDaysal(daysal);
			sal.setWorkdate(workdate);
			sal.setWorktime(worktime);
			sal.setComments(comments);
			
			try {
				dao.add(sal);
				updateList(dao, request, response);
				
			} catch (Exception e) {
				e.printStackTrace();
				out.println("System busy! try again later!");
			}
			
		} else if("/del".equals(action)) {
			// delete function
			int id = Integer.parseInt(request.getParameter("id"));
			SalaryDAO dao = new SalaryDAO();
			try {
				dao.delete(id);
				updateList(dao, request, response);
				
			} catch (Exception e) {
				e.printStackTrace();
				out.println("System busy! try again later!");
			}
			
		} else if("/count".equals(action)) {
			checkForSession(request, response);
			
			// count paycheck this month
			SalaryDAO dao = new SalaryDAO();
			try {
				double[] salCheck = dao.count();
				request.setAttribute("salCheck", salCheck);
				RequestDispatcher rd = request.getRequestDispatcher("count.jsp");
				rd.forward(request, response);
				
				
			} catch (Exception e) {
				e.printStackTrace();
				out.println("System busy! Please try again later!");
			}
			
		} else if("/login".equals(action)) {
			// Login function
			String username = request.getParameter("uname");
			String password = request.getParameter("pwd");
			
			UserDAO dao = new UserDAO();
			try {
				User user = dao.find(username);
				if(user != null && user.getPassword().equals(password)) {
					// login success, give session id and menu
					HttpSession session = request.getSession();
					session.setAttribute("user", user);
					response.sendRedirect("menu.do");
				} else {
					// login failed
					request.setAttribute("login_failed", "Invalid Username or Password!");
					request.getRequestDispatcher("login.jsp").forward(request, response);
					
				}
				
				
			} catch (Exception e) {
				e.printStackTrace();
				out.println("System busy! Please try again later!");
				
			}
			
		}
		
	}
}






