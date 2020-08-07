package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import db.DB;
import dto.MovieInsertDTO;
import dto.MovieselectDTO;

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
	
	public ArrayList<MovieselectDTO> select() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<MovieselectDTO> dtoList = new ArrayList<MovieselectDTO>();
		try {

			conn = DB.conn();

			String sql = "SELECT * FROM movie_tb";
			pstmt = conn.prepareStatement(sql);

//			StringBuffer sql = new StringBuffer();
//			sql.append("INSERT INTO movie_tb(m_title, m_actor, m_director,m_img)\r\n");
			
			rs = pstmt.executeQuery(sql);
			while (rs.next()) {
			System.out.println("영화번호 : " + rs.getInt("m_num"));
			System.out.println("영화제목 : " + rs.getString("m_title"));
			System.out.println("주연배우 : " + rs.getString("m_actor"));
			System.out.println("감독 : " + rs.getString("m_director"));
			System.out.println("이미지 : " + rs.getString("m_img"));
//			System.out.println("링크 : " + rs.getString("pw")); url없음
			
			MovieselectDTO dto = new MovieselectDTO();
			dto.setNum((rs.getInt("m_num")));
			dto.setTitle((rs.getString("m_title")));
			dto.setAt((rs.getString("m_actor")));
			dto.setDt((rs.getString("m_director")));
			dto.setSrc((rs.getString("m_img")));
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
	
	public MovieselectDTO select(int num) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		MovieselectDTO dto = new MovieselectDTO();
		try {
			
			conn = DB.conn();
			
			String sql = "SELECT * FROM movie_tb WHERE m_num = ?";
			pstmt = conn.prepareStatement(sql);
			
//			StringBuffer sql = new StringBuffer();
//			sql.append("INSERT INTO movie_tb(m_title, m_actor, m_director,m_img)\r\n");
			
			pstmt.setInt(1, num);
			
			rs = pstmt.executeQuery(sql);
			while (rs.next()) {
				System.out.println("영화번호 : " + rs.getInt("m_num"));
				System.out.println("영화제목 : " + rs.getString("m_title"));
				System.out.println("주연배우 : " + rs.getString("m_actor"));
				System.out.println("감독 : " + rs.getString("m_director"));
				System.out.println("이미지 : " + rs.getString("m_img"));
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
