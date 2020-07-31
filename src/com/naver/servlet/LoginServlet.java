package com.naver.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserDAO;
import dao.UserDAOimpl;
import dto.UserDTO;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8"); //인코딩
		
		String email = request.getParameter("email");
		System.out.println(email);

		String pw = request.getParameter("pw");
		System.out.println(pw);
		
		//db연결
		//email, pw확인 맞으면 로그인 성공 틀리면 로그인 실패
		UserDAOimpl dao = new UserDAOimpl();
		UserDTO dto = dao.email_select(email, pw);
		if(dto!=null) {
			System.out.println("로그인 하였다.");
			HttpSession session = request.getSession();
			session.setAttribute("user", dto);
		}else {
			System.out.println("로그인 할 수 없다.");
		}
		response.sendRedirect("logincheck.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
