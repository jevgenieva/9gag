//
//package controller;
//
//import java.io.IOException;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//
//@WebServlet("/WebContent/loginRequired/*")
//public class LoginCheckerServlet extends HttpServlet {
//	
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		HttpSession session = request.getSession();
//		String url = "";
//		
//		if(session.getAttribute("logged") != null || (boolean)session.getAttribute("logged")) 
//			url = request.getRequestURL().toString();
//		else
//			url = "login.jsp";
//		
//		request.getRequestDispatcher(url).forward(request,response);
//	}	
//
//}
