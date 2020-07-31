package com.naver.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Controller
 */
@WebServlet("*.nhn")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Controller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		
		String uri = request.getRequestURI();
		String [] arrUri = uri.split("/");
		uri = arrUri[2];
		
		String site = null;
		
		if(uri.equals("main.nhn")){
			site = "main.jsp";
		}else if(uri.equals("login.nhn")){
			site = "login.jsp";
		}else if(uri.equals("loginok.nhn")){
			site = "LoginServlet";
		}else if(uri.equals("logout.nhn")){
			site = "logout.jsp";
		}else if(uri.equals("join.nhn")){
			site = "join.jsp";
		}else if(uri.equals("joinok.nhn")){
			site = "JoinServlet";
		}else if(uri.equals("emailck.nhn")){
			site = "EmailCkServlet";
		}else if(uri.equals("search.nhn")){
			site = "search.jsp";
		}else if(uri.equals("searchok.nhn")){
			site = "search_ok.jsp";
		}else {
			site = "404.jsp";
		}

		RequestDispatcher dis = request.getRequestDispatcher(site); //전송할 변수 선언
		dis.forward(request, response);
		
//		PrintWriter out = response.getWriter();
//		for(int i=0; i<arrUri.length; i++) {
//			out.println(arrUri[i]);
//		}
//		out.println("내가 써야 하는 부분 : "+arrUri[2]);
//		StringBuffer url = request.getRequestURL();
//		String addr = request.getRemoteAddr();
//		System.out.println(addr);
//		int port = request.getRemotePort();
//		System.out.println(port);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}