package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import db.DB;
import dto.MovieDTO;
import dto.MovieInsertDTO;
import dto.MovieselectDTO;
import dto.reviewDTO;

public class MovieDAOimpl implements MovieDAO{

	public void insert(MovieInsertDTO dto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {

			conn = DB.conn();

//			String sql = "INSERT INTO movie_tb (m_title, m_actor, m_director, m_img) VALUES ( ?, ?, ?, ?)";
//			String sql = "INSERT INTO movie_tb(m_title, m_actor, m_director,m_img)\r\n" + 
//					"SELECT ?, ?, ?, ? FROM DUAL WHERE NOT EXISTS\r\n" + 
//					"(SELECT m_title FROM movie_tb WHERE m_title = ?)";

			StringBuffer sql = new StringBuffer();
			sql.append("INSERT INTO movie_tb(m_title, m_actor, m_director,m_img)\r\n");
			sql.append("SELECT ?, ?, ?, ? FROM DUAL WHERE NOT EXISTS\r\n");
			sql.append("(SELECT m_title FROM movie_tb WHERE m_title = ?)");
			
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, dto.getTitle());
			pstmt.setString(2, dto.getAt());
			pstmt.setString(3, dto.getDt());
			pstmt.setString(4, dto.getSrc());
			pstmt.setString(5, dto.getTitle());

			int rs = pstmt.executeUpdate();
			if (rs == 0) {
				System.out.println("데이터 입력 실패");
			} else {
				System.out.println("데이터 입력 성공");
			}

		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패");
		} catch (SQLException e) {
			System.out.println("에러: " + e);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null && !conn.isClosed()) {
					conn.close();
				}
				if (pstmt != null && !pstmt.isClosed()) {
					pstmt.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public void insert(reviewDTO dto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {

			conn = DB.conn();

			
			StringBuffer sql = new StringBuffer();
			sql.append("INSERT INTO review_tb(m_movie_num, m_user_num, r_title, r_score,r_text)\r\n");
			sql.append("VALUES((SELECT m_num FROM movie_tb WHERE m_num=?),(SELECT usernum FROM signup_tb WHERE usernum=?),?,?,?)");
			
			pstmt = conn.prepareStatement(sql.toString());
			
			pstmt.setInt(1, dto.getM_num());
			pstmt.setInt(2, dto.getU_num());
			pstmt.setString(3, dto.getR_title());
			pstmt.setInt(4, dto.getR_score());
			pstmt.setString(5, dto.getR_text());
			
			
			int rs = pstmt.executeUpdate();
			if (rs == 0) {
				System.out.println("데이터 입력 실패");
			} else {
				System.out.println("데이터 입력 성공");
			}

		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패");
		} catch (SQLException e) {
			System.out.println("에러: " + e);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null && !conn.isClosed()) {
					conn.close();
				}
				if (pstmt != null && !pstmt.isClosed()) {
					pstmt.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public ArrayList<MovieDTO> select() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<MovieDTO> dtoList = new ArrayList<MovieDTO>();
		try {

			conn = DB.conn();

			String sql = "SELECT * FROM movie_tb";
			pstmt = conn.prepareStatement(sql);

			rs = pstmt.executeQuery(sql);
			while (rs.next()) {
				MovieDTO dto = new MovieDTO();
				System.out.println("영화번호 : " + rs.getInt("m_num"));
				System.out.println("영화제목 : " + rs.getString("m_title"));
				System.out.println("주연배우 : " + rs.getString("m_actor"));
				System.out.println("감독 : " + rs.getString("m_director"));
				
				dto.setNum((rs.getInt("m_num")));
				dto.setTitle((rs.getString("m_title")));
				dto.setSrc((rs.getString("m_img")));
				dto.setAt((rs.getString("m_actor")));
				dto.setDt((rs.getString("m_director")));
				dtoList.add(dto);
			}

		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패");
		} catch (SQLException e) {
			System.out.println("에러: " + e);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null && !conn.isClosed()) {
					conn.close();
				}
				if (pstmt != null && !pstmt.isClosed()) {
					pstmt.close();
				}
				if (rs != null && !rs.isClosed()) {
					rs.close();
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	
		return dtoList;
	}
	
	public MovieDTO select(String num) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		MovieDTO dto = new MovieDTO();
		try {
			
			conn = DB.conn();
			
			String sql = "SELECT * FROM movie_tb WHERE m_num = ?";
			pstmt = conn.prepareStatement(sql);
			
//			StringBuffer sql = new StringBuffer();
//			sql.append("INSERT INTO movie_tb(m_title, m_actor, m_director,m_img)\r\n");
			int n = Integer.parseInt(num);
			pstmt.setInt(1, n);
			
			rs = pstmt.executeQuery(sql);
			while (rs.next()) {
				System.out.println("영화번호 : " + rs.getInt("m_num"));
				System.out.println("영화제목 : " + rs.getString("m_title"));
//				System.out.println("주연배우 : " + rs.getString("m_actor"));
//				System.out.println("감독 : " + rs.getString("m_director"));
//				System.out.println("이미지 : " + rs.getString("m_img"));
//			System.out.println("링크 : " + rs.getString("pw")); url없음
				
				dto.setNum((rs.getInt("m_num")));
				dto.setTitle((rs.getString("m_title")));
				dto.setAt((rs.getString("m_actor")));
				dto.setDt((rs.getString("m_director")));
				dto.setSrc((rs.getString("m_img")));
			}
			
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패");
		} catch (SQLException e) {
			System.out.println("에러: " + e);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null && !conn.isClosed()) {
					conn.close();
				}
				if (pstmt != null && !pstmt.isClosed()) {
					pstmt.close();
				}
				if (rs != null && !rs.isClosed()) {
					rs.close();
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return dto;
	}


}
