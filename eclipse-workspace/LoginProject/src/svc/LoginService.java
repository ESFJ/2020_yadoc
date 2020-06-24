package svc;

import static db.JDBCUtil.*;
import java.sql.Connection;

import dao.LoginDAO;
import vo.MemberVO;
//트랜잭션 처리는 서비스단에서 하므로 Connection 객체를 Service 클래스에서 다루어야 한다.
//자바에서는 Connection 단위로 트랜잭션이 이루어진다.
public class LoginService {

	public MemberVO getLoginMember(String id, String passwd) {
		// TODO Auto-generated method stub
		Connection con = getConnection();
		
		//SQL 작업은 DAO(data access object) 클래스에서 수행한다.
		LoginDAO loginDAO = LoginDAO.getInstance(); //싱글톤 패턴 이용
		
		//DAO는 동일하지만 connection은 각각 다른 객체를 요청함.(트랜잭션단위로 다름)
		//setConnection을 이용해 하나의 비즈니스 로직을 처리할때마다 따로 커넥션을 처리할수있도록 함.
		loginDAO.setConnection(con);
		
		//SQL 작업
		//seletct, update 이런 이름으로 함수가 정해져야함
		//사용하는 위치에 따라 함수의 이름도 달라짐.
		MemberVO loginMember = loginDAO.selectLoginMember(id, passwd);
		close(con);
		return loginMember;
	}
}
