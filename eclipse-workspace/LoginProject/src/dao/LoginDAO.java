package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import static db.JDBCUtil.*; //�ش� Ŭ���� �ȿ��ִ� �޼ҵ�� �Ӽ��� ����Ʈ

import vo.MemberVO;

public class LoginDAO {
	//����� ���� Ŀ�ؼ� ��ü�� ����� �޾�����  ���ϴ� �۾��� ���� Ŀ�ؼ��� �������� ����Ҽ�����.
	//�������� �۾��� �ϳ��� Ŀ�ؼ����� �� ���ֵ��� ��.
	Connection con;
	
	//singleton �����̶�?
	//��ü�� �ν��Ͻ��� �ϳ��� �޸𸮿� �����ϰ� �����ؼ� ����ϴ� ���
	private static LoginDAO instance;
	
	private LoginDAO() {
		// TODO Auto-generated constructor stub
		// �ܺο��� ���� ��ü�� ������ ���ϰ� ��.
	}
	
	//getInstance�� ���� LoginDAO�� ������ ��������.
	public static LoginDAO getInstance() {
		if(instance == null) {
			//�ܺ� Ŭ�������� getInstance�� ó������ ȣ���� ��� (ù���)
			//���� �ν��Ͻ� ��ü�� ��������� �ʾ���.
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
//		MemberVO loginMember = null; //���ú����ϱ� �ʱ�ȭ
//		
//		//����ó�� : �Ǽ��� ��Ƴ��°� or �۾��߿� �Ͼ���ִ� ������ ó��
//		try {
//			String sql = "SELECT * FROM member WHERE " + "id = '" + id + "' AND passwd = '" + passwd + "'";
//			stmt = con.createStatement();
//			rs = stmt.executeQuery(sql);
//			
//			if(rs.next()) {
//				//select�� ���� ��ȯ�� ���ڵ� ����
//				//���ǿ� �´� ���ڵ尡 ��ȯ�Ǿ����� true
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
		MemberVO loginMember = null; //���ú����ϱ� �ʱ�ȭ
		
		try {
			String sql = "SELECT * FROM member WHERE " + " id = ? AND passwd = ?";
			// ������ �� �ڸ��� ?��ũ�� �̿��� ����
			pstmt = con.prepareStatement(sql);
			
			//���ǰ��� �������ְ� ����
			pstmt.setString(1, id);	//ù��° ?�� id
			pstmt.setString(2, passwd); //�ι�° ?�� passwd
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				//select�� ���� ��ȯ�� ���ڵ� ����
				//���ǿ� �´� ���ڵ尡 ��ȯ�Ǿ����� true
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
			// ������ �� �ڸ��� ?��ũ�� �̿��� ����
			pstmt = con.prepareStatement(sql);
			
			//insert��  �������ְ� ����
			pstmt.setString(1, memberVO.getId());	//ù��° ?�� id
			pstmt.setString(2, memberVO.getName()); //�ι�° ?�� passwd
			pstmt.setString(3, memberVO.getPasswd());
			pstmt.setString(4, memberVO.getEmail());
			
			insertCount = pstmt.executeUpdate(); //�����(insert��) ���� ��ȯ
			
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return insertCount;
	}
}














