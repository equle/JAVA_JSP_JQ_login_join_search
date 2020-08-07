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
import dto.MovieselectDTO;
import naver.NVmovieCrawler;
import naver.NVmovieinsertCrawler;

@WebServlet("/WriteServlet")
public class WriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public WriteServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		int num = Integer.parseInt(request.getParameter("num"));
		
		MovieDAO dao = new MovieDAOimpl(); // DB에 저장되어있는 데이터 가져와 출력

		MovieselectDTO dto = dao.select(num);

		Gson gson = new Gson();
		String jsonData = gson.toJson(dto);
		System.out.println(jsonData);
		out.println(jsonData);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
