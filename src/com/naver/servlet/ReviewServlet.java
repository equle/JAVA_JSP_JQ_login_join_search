package com.naver.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import dto.ReviewDTO;
import dao.ReviewDAO;
import dao.ReviewDAOimpl;

@WebServlet("/ReviewServlet")
public class ReviewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ReviewServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		int m_num = Integer.parseInt(request.getParameter("m_num"));
		int u_num = Integer.parseInt(request.getParameter("u_num"));
		float r_score = Float.parseFloat(request.getParameter("r_score"));
		String r_title = request.getParameter("r_title");
		String r_text = request.getParameter("r_text");
		
		ReviewDTO dto = new ReviewDTO();
		dto.setM_num(m_num);
		dto.setU_num(u_num);
		dto.setR_title(r_title);
		dto.setR_score(r_score);
		dto.setR_text(r_text);
		
		ReviewDAO dao = new ReviewDAOimpl();
		dao.insert(dto);
		
		response.getWriter().append("ok");			
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
