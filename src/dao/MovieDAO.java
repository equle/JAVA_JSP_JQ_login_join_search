package dao;


import java.util.ArrayList;

import dto.MovieDTO;
import dto.MovieInsertDTO;
import dto.MovieselectDTO;

public interface MovieDAO {
	
	public void insert(MovieInsertDTO dto);
	
	public ArrayList<MovieDTO> select();
	
	public MovieDTO select(String num);
}
