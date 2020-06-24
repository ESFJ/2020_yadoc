package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCUtil {
	//2. DB드라이버 메모리에 띄우기
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");//얘를 읽겠다 //예외처리 필요
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	
	//커넥션 연결
	public static Connection getConnection() {
		Connection con = null;
		try {
			//접속할 DB URL, oracle user id, passwd
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "hr", "hr");
			//자바는 기본적으로 데이터를 조작하는 작업을 했을때 자동으로 커밋이 됨 -> 트랜잭션 처리를 할수가 없음
			con.setAutoCommit(false); //자동으로 commit하지 못하게해줌
			//얘가 만들어지면 커넥션이 만들어진것
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return con;
	}
	
	//매번 열고 닫아야하니까 close도 함수로 만들어줌(중복코드 제거)
	public static void close(Connection con) {
		try {
			con.close(); //커넥션이 이미 닫혀있으면 에러
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void close(Statement stmt) {
		try {
			stmt.close(); //statement이 이미 닫혀있으면 에러
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//반환되는 레코드 덩어리를 참조하는 resultSet도 닫아줘야함
	public static void close(ResultSet rs) {
		try {
			rs.close(); //statement이 이미 닫혀있으면 에러
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//트랜잭션에 관한 작업 (DB작업할때 트랜잭션은 필수!!)(하나로 묶여서 처리해야하는 작업들을 트랜잭션으로 묶어줘야함)
	//commit
	public static void commit(Connection con) {
		try {
			con.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//모든작업 취소
	public static void rollback(Connection con) {
		try {
			con.rollback();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}