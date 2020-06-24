package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCUtil {
	//2. DB����̹� �޸𸮿� ����
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");//�긦 �аڴ� //����ó�� �ʿ�
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	
	//Ŀ�ؼ� ����
	public static Connection getConnection() {
		Connection con = null;
		try {
			//������ DB URL, oracle user id, passwd
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "hr", "hr");
			//�ڹٴ� �⺻������ �����͸� �����ϴ� �۾��� ������ �ڵ����� Ŀ���� �� -> Ʈ����� ó���� �Ҽ��� ����
			con.setAutoCommit(false); //�ڵ����� commit���� ���ϰ�����
			//�갡 ��������� Ŀ�ؼ��� ���������
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return con;
	}
	
	//�Ź� ���� �ݾƾ��ϴϱ� close�� �Լ��� �������(�ߺ��ڵ� ����)
	public static void close(Connection con) {
		try {
			con.close(); //Ŀ�ؼ��� �̹� ���������� ����
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void close(Statement stmt) {
		try {
			stmt.close(); //statement�� �̹� ���������� ����
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//��ȯ�Ǵ� ���ڵ� ����� �����ϴ� resultSet�� �ݾ������
	public static void close(ResultSet rs) {
		try {
			rs.close(); //statement�� �̹� ���������� ����
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//Ʈ����ǿ� ���� �۾� (DB�۾��Ҷ� Ʈ������� �ʼ�!!)(�ϳ��� ������ ó���ؾ��ϴ� �۾����� Ʈ��������� ���������)
	//commit
	public static void commit(Connection con) {
		try {
			con.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//����۾� ���
	public static void rollback(Connection con) {
		try {
			con.rollback();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}