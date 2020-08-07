package dao;


import java.util.ArrayList;

import dto.MovieInsertDTO;
import dto.MovieselectDTO;

public interface MovieDAO {
	
	public void insert(MovieInsertDTO dto);
	
	public ArrayList<MovieselectDTO> select();
	
	public MovieselectDTO select(int num);
}
