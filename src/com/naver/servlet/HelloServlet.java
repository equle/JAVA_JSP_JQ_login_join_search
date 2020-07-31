package com.naver.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/hello")
public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public HelloServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
//		response.getWriter().append("Served at: ").append(request.getContextPath());
    	response.setContentType("text/html;charset=UTF-8");
    	
    	String email = request.getParameter("email");
    	
    	PrintWriter out = response.getWriter();
    	System.out.println("server systme : print console window");
    	out.println("user client : print user browser 클라이언트 브라우저 출력 URL=/hello<br>");
    	out.println("user client : print user browser 클라이언트 브라우저 출력 URL=/hello");
    	out.println("email : " + email);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		doGet(request, response);
	}

}
