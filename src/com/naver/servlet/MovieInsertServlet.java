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
import naver.NVmovieCrawler;
import naver.NVmovieinsertCrawler;

@WebServlet("/MovieInsertServlet")
public class MovieInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MovieInsertServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ArrayList<MovieInsertDTO> dtoList = NVmovieinsertCrawler.movieinsert();
		
		MovieDAO dao = new MovieDAOimpl();
		
		for(MovieInsertDTO dto : dtoList) {
			dao.insert(dto);
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
