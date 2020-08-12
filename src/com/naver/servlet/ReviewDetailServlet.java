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
import dto.ReviewViewDTO;
import dao.ReviewDAO;
import dao.ReviewDAOimpl;

@WebServlet("/ReviewDetailServlet")
public class ReviewDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ReviewDetailServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		
		int r_num = Integer.parseInt(request.getParameter("r_num"));
		
		System.out.println(r_num);
		
		ReviewDAO dao = new ReviewDAOimpl();
		ReviewViewDTO dto = dao.selectDetail(r_num);
		
		Gson gson = new Gson();
		String jsonData = gson.toJson(dto);
		System.out.println(jsonData);
		response.setContentType("application/json; charset=UTF-8");
		out.println(jsonData);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
