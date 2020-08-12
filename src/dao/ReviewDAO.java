package dao;


import java.util.ArrayList;

import dto.ReviewDTO;
import dto.ReviewViewDTO;

public interface ReviewDAO {
	
	public void insert(ReviewDTO dto);
	
	public ArrayList<ReviewViewDTO> select();
	
	public ReviewViewDTO selectDetail(int num);
}
