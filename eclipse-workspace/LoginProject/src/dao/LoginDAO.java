package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import static db.JDBCUtil.*; //해당 클래스 안에있는 메소드와 속성을 임포트

import vo.MemberVO;

public class LoginDAO {
	//멤버로 빼서 커넥션 객체를 멤버로 받았을때  원하는 작업을 쓸때 커넥션을 공통으로 사용할수있음.
	//여러개의 작업을 하나의 커넥션으로 할 수있도록 함.
	Connection con;
	
	//singleton 패턴이란?
	//객체의 인스턴스를 하나만 메모리에 생성하고 공유해서 사용하는 방식
	private static LoginDAO instance;
	
	private LoginDAO() {
		// TODO Auto-generated constructor stub
		// 외부에서 직접 객체를 만들지 못하게 함.
	}
	
	//getInstance를 통해 LoginDAO의 정보를 얻어가도록함.
	public static LoginDAO getInstance() {
		if(instance == null) {
			//외부 클래스에서 getInstance를 처음으로 호출한 경우 (첫사용)
			//아직 인스턴스 객체가 만들어지지 않았음.
			instance = new LoginDAO();
		}
		return instance;
	}

	public void setConnection(Connection con) {
		// TODO Auto-generated method stub
		this.con = con;
	}

	public MemberVO selectLoginMember(String id, String passwd) {
		// TODO Auto-generated method stub
		//Statement 
//		Statement stmt = null;
//		ResultSet rs = null;
//		MemberVO loginMember = null; //로컬변수니까 초기화
//		
//		//예외처리 : 실수를 잡아내는것 or 작업중에 일어날수있는 변수들 처리
//		try {
//			String sql = "SELECT * FROM member WHERE " + "id = '" + id + "' AND passwd = '" + passwd + "'";
//			stmt = con.createStatement();
//			rs = stmt.executeQuery(sql);
//			
//			if(rs.next()) {
//				//select에 의해 반환된 레코드 있음
//				//조건에 맞는 레코드가 반환되었으면 true
//				loginMember = new MemberVO();
//				loginMember.setEmail(rs.getString("email"));
//				loginMember.setId(rs.getString("id"));
//				loginMember.setPasswd(rs.getString("passwd"));
//				loginMember.setName(rs.getString("name"));
//			}
//		} catch (SQLException e) {
//			// TODO: handle exception
//			e.printStackTrace();
//		} finally {
//			close(rs);
//			close(stmt);
//		}
//		return loginMember;

		//PreparedStatement
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		MemberVO loginMember = null; //로컬변수니까 초기화
		
		try {
			String sql = "SELECT * FROM member WHERE " + " id = ? AND passwd = ?";
			// 변수가 들어갈 자리에 ?마크를 이용해 매핑
			pstmt = con.prepareStatement(sql);
			
			//조건값에 매핑해주고 실행
			pstmt.setString(1, id);	//첫번째 ?에 id
			pstmt.setString(2, passwd); //두번째 ?에 passwd
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				//select에 의해 반환된 레코드 있음
				//조건에 맞는 레코드가 반환되었으면 true
				loginMember = new MemberVO();
				loginMember.setEmail(rs.getString("email"));
				loginMember.setId(rs.getString("id"));
				loginMember.setPasswd(rs.getString("passwd"));
				loginMember.setName(rs.getString("name"));
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return loginMember;

	}

	public int insertMember(MemberVO memberVO) {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		int insertCount = 0;
		try {
			String sql = "INSERT INTO member(id, name, passwd, email) "
					+ "VALUES(?,?,?,?)";
			// 변수가 들어갈 자리에 ?마크를 이용해 매핑
			pstmt = con.prepareStatement(sql);
			
			//insert할  매핑해주고 실행
			pstmt.setString(1, memberVO.getId());	//첫번째 ?에 id
			pstmt.setString(2, memberVO.getName()); //두번째 ?에 passwd
			pstmt.setString(3, memberVO.getPasswd());
			pstmt.setString(4, memberVO.getEmail());
			
			insertCount = pstmt.executeUpdate(); //적용된(insert된) 갯수 반환
			
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return insertCount;
	}
}














