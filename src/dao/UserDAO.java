package dao;

import dto.UserDTO;

public interface UserDAO {

	public  void select();
	
	public  void unum_select(int num);
	
	public  boolean email_select(String email);
	
	public UserDTO email_select(String email, String pw);
	
	public boolean insert(UserDTO dto);
	
}
