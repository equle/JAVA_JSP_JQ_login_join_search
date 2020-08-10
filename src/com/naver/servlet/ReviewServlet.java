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

import dao.MovieDAO;
import dao.MovieDAOimpl;
import dao.UserDAO;
import dto.MovieDTO;
import dto.MovieInsertDTO;
import dto.reviewDTO;
import naver.NVmovieCrawler;
import naver.NVmovieinsertCrawler;

@WebServlet("/ReviewServlet")
public class ReviewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ReviewServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		
		int m_num = Integer.parseInt(request.getParameter("m_num"));
		int u_num = Integer.parseInt(request.getParameter("u_num"));
		int r_score = Integer.parseInt(request.getParameter("r_score"));
		String r_title = request.getParameter("r_title");
		String r_text = request.getParameter("r_text");
		
		reviewDTO dto = new reviewDTO();
		dto.setM_num(m_num);
		dto.setU_num(u_num);
		dto.setR_title(r_title);
		dto.setR_score(r_score);
		dto.setR_text(r_text);
		
		out.println(m_num);
		out.println(u_num);
		out.println(r_title);
		out.println(r_text);
		out.println(r_score);
		
		System.out.println(m_num);
		System.out.println(u_num);
		System.out.println(r_title);
		System.out.println(r_text);
		System.out.println(r_score);
		
		MovieDAO dao = new MovieDAOimpl();
		dao.insert(dto);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
