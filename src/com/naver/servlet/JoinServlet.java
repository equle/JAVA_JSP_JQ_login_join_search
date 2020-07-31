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

@WebServlet("/JoinServlet")
public class JoinServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public JoinServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		response.setContentType("text/html;charset=UTF-8"); //인코딩
		request.setCharacterEncoding("utf-8");
		UserDTO dto = new UserDTO();
		
		String email = request.getParameter("email");
		dto.setEmail(email);

		String pw = request.getParameter("pw");
		dto.setPw(pw);
		
		String name = request.getParameter("name");
		dto.setName(name);
		
		String phone = request.getParameter("phone1") +"-"+ request.getParameter("phone2");
		dto.setPhone(phone);
		
		UserDAO dao = new UserDAOimpl();
		HttpSession session = request.getSession();
		if(dao.insert(dto)) {
			System.out.println("회원가입을 성공했다.");
			session.setAttribute("join", true);
		}else {
			System.out.println("회원가입에 실패했다.");
			session.setAttribute("join", false);
		}
		response.sendRedirect("joincheck.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
