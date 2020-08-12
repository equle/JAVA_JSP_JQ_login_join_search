package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import db.DB;
import dto.MovieDTO;
import dto.ReviewDTO;
import dto.ReviewViewDTO;

public class ReviewDAOimpl implements ReviewDAO{

	public void insert(ReviewDTO dto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String r="fail";
		try {

			conn = DB.conn();

			
			StringBuffer sql = new StringBuffer();
			sql.append("INSERT INTO review_tb(m_movie_num, s_user_num, r_title, r_score,r_text)\r\n");
			sql.append("VALUES((SELECT m_num FROM movie_tb WHERE m_num=?),(SELECT usernum FROM signup_tb WHERE usernum=?),?,?,?)");
			
			pstmt = conn.prepareStatement(sql.toString());
			
			pstmt.setInt(1, dto.getM_num());
			pstmt.setInt(2, dto.getU_num());
			pstmt.setString(3, dto.getR_title());
			pstmt.setFloat(4, dto.getR_score());
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
	
	public ArrayList<ReviewViewDTO> select() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<ReviewViewDTO> dtoList = new ArrayList<ReviewViewDTO>();
		try {

			conn = DB.conn();

			StringBuffer sql = new StringBuffer();
			sql.append("SELECT r.no, m.m_title, (SELECT name FROM signup_tb WHERE usernum = r.s_user_num) AS s_name, r.r_title, r.r_score \r\n");
			sql.append("FROM movie_tb m join review_tb r on m.m_num = r.m_movie_num ");
			
			
			pstmt = conn.prepareStatement(sql.toString());
			
			rs = pstmt.executeQuery();
			while (rs.next()) {
				ReviewViewDTO dto = new ReviewViewDTO();
				
				dto.setNum((rs.getInt("no")));
				dto.setM_title((rs.getString("m_title")));
				dto.setId((rs.getString("s_name")));
				dto.setR_title((rs.getString("r_title")));
				dto.setR_score((rs.getFloat("r_score")));
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
	
	public ReviewViewDTO selectDetail(int num) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ReviewViewDTO dto = new ReviewViewDTO();
		try {
			
			conn = DB.conn();
			
			StringBuffer sql = new StringBuffer();
			sql.append("SELECT r.no, m.m_title, (SELECT name FROM signup_tb WHERE usernum = r.s_user_num) AS s_name, r.r_title, r.r_score, r.r_text \r\n");
			sql.append("FROM movie_tb m join review_tb r on m.m_num = r.m_movie_num  WHERE r.no = ?");
			
			
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setInt(1, num);
			
			rs = pstmt.executeQuery();
			while (rs.next()) {
				System.out.println("게시물 번호 : " + rs.getInt("no"));
				System.out.println("영화제목 : " + rs.getString("m_title"));
				System.out.println("작성자 : " + rs.getString("s_name"));
				System.out.println("평점 : " + rs.getString("r_score"));
				
				dto.setNum((rs.getInt("no")));
				dto.setM_title((rs.getString("m_title")));
				dto.setId((rs.getString("s_name")));
				dto.setR_title((rs.getString("r_title")));
				dto.setR_text((rs.getString("r_text")));
				dto.setR_score((rs.getFloat("r_score")));
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
