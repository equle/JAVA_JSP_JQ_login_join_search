package com.naver.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
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

@WebServlet("/MovieServlet2")
public class MovieServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MovieServlet2() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		MovieDAO dao = new MovieDAOimpl(); //DB에 저장되어있는 데이터 가져와 출력
		ArrayList<MovieDTO> list = dao.select();
		request.setAttribute("movieList", list);
		RequestDispatcher dis = request.getRequestDispatcher("movie2.jsp");
		dis.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

//영화 번호 데이터를 request에 담아 보내고 영화 번호를 이용하여 dao를 통해 db에 있는 해당 영화번호의 데이터를 가져와 데이터를 뿌린다.
//