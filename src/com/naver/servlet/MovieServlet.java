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
import dto.MovieDTO;
import dto.MovieselectDTO;
import naver.NVmovieCrawler;

@WebServlet("/MovieServlet")
public class MovieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MovieServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("application/json; charset=UTF-8");
//		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();

//		ArrayList<MovieDTO> dtoList = NVmovieCrawler.moviesearch(); 네이버 크롤링 java로 버퍼가 걸려 느리다.
		
		MovieDAO dao = new MovieDAOimpl(); //DB에 저장되어있는 데이터 가져와 출력
		
		ArrayList<MovieDTO> dtoList = dao.select();
		
		Gson gson = new Gson();
		String jsonData = gson.toJson(dtoList);
		System.out.println(jsonData);
		out.println(jsonData);
		
		//dto를 json으로 변환 시켜 작업을 하면 jquary로 출력 가능
		//Gson라이브러리를 활용하면 쉽게 변환 시킬수 있다.
		//변환된 문자열을 아래에서 뿌린다.
		
//		String search = request.getParameter("search") + " 영화";
//		System.out.println(search);
//		String jsonData = NVmovieCrawler; //+"맛집"

//		request.setCharacterEncoding("UTF-8");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
