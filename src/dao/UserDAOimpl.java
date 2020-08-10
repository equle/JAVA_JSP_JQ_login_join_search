package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import db.DB;
import dto.UserDTO;

public class UserDAOimpl implements UserDAO {
	// 유저 전체 보기
	public void select() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = DB.conn();

			String sql = "SELECT * FROM signup_tb";
			pstmt = conn.prepareStatement(sql);

			rs = pstmt.executeQuery();

//			while (rs.next()) {
//				System.out.println("＋－－－－－－－－－－－－－－＋");
//				System.out.println("회원번호 : " + rs.getInt("usernum"));
//				System.out.println("아이디 : " + rs.getString("id"));
//				System.out.println("비밀번호 : " + rs.getString("pw"));
//				System.out.println("이름 : " + rs.getString("name"));
//				System.out.println("이메일 : " + rs.getString("email"));
//				System.out.println("전화번호 : " + rs.getString("phone"));
//				System.out.println("＋－－－－－－－－－－－－－－＋");
//			}

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
	}

	// 선택 보기
	public void unum_select(int num) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = DB.conn();

			String sql = "SELECT * FROM signup_tb WHERE usernum = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);

			rs = pstmt.executeQuery();

//			while (rs.next()) {
//				System.out.println("＋－－－－－－－－－－－－－－＋");
//				System.out.println("회원번호 : " + rs.getInt("usernum"));
//				System.out.println("비밀번호 : " + rs.getString("pw"));
//				System.out.println("이름 : " + rs.getString("name"));
//				System.out.println("이메일 : " + rs.getString("email"));
//				System.out.println("전화번호 : " + rs.getString("phone"));
//				System.out.println("＋－－－－－－－－－－－－－－＋");
//			}

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

	}

	// 같은 이메일 찾기
	public boolean email_select(String email) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		boolean isemail = false;
		
		try {
			conn = DB.conn();

			String sql = "SELECT * FROM signup_tb WHERE email = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, email);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				//데이터가 있을 경우
				isemail = true;

			} else {
				//데이터가 없을 경우
				isemail = false;

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
		return isemail;
	}

	//로그인
	public UserDTO email_select(String email, String pw) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		UserDTO dto = null;

		try {
			conn = DB.conn();

			String sql = "SELECT * FROM signup_tb WHERE email = ? AND pw = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, email);
			pstmt.setString(2, pw);

			rs = pstmt.executeQuery();

			if(rs.next()) {
				dto = new UserDTO();
				dto.setEmail(rs.getString("email"));
				dto.setPw(rs.getString("pw"));
				dto.setName(rs.getString("name"));
				dto.setPhone(rs.getString("phone"));
				dto.setNum(rs.getInt("usernum"));
			}else {
				System.out.println("사용자가 없다.");
				return null;
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

	// 데이터 넣기
	public boolean insert(UserDTO dto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {

			conn = DB.conn();

			String sql = "INSERT INTO signup_tb (email, pw, name, phone) VALUES ( ?, ?, ?, ?)";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getEmail());
			pstmt.setString(2, dto.getPw());
			pstmt.setString(3, dto.getName());
			pstmt.setString(4, dto.getPhone());

			int rs = pstmt.executeUpdate();
			if (rs == 0) {
				System.out.println("데이터 입력 실패");
			} else {
				System.out.println("데이터 입력 성공");
				return true;
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
		return false;
	}
}