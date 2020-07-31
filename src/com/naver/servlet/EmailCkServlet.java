package com.naver.servlet;

import java.io.IOException;
import java.io.PrintWriter;

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

@WebServlet("/EmailCkServlet")
public class EmailCkServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public EmailCkServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8"); //인코딩
		
		String email = request.getParameter("email");
		System.out.println("EmailCkServlet : "+email);

		PrintWriter out = response.getWriter();
		
		//db연결
		//email, pw확인 맞으면 로그인 성공 틀리면 로그인 실패
		UserDAO dao = new UserDAOimpl();
		boolean isemail = dao.email_select(email);
		
		if(isemail) {
			out.println("해당 이메일을 사용할 수 없습니다.");
		}else {
			out.println("사용가능한 이메일 입니다.");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
