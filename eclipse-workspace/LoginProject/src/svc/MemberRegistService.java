package svc;

import static db.JDBCUtil.*;

import java.sql.Connection;

import dao.LoginDAO;
import vo.MemberVO;

public class MemberRegistService {

	public boolean registMember(MemberVO memberVO) {
		// TODO Auto-generated method stub
		boolean registSuccess = false;
		Connection con = getConnection();
		
		//SQL 작업은 DAO(data access object) 클래스에서 수행한다.
		LoginDAO loginDAO = LoginDAO.getInstance(); //싱글톤 패턴 이용
		
		//DAO는 동일하지만 connection은 각각 다른 객체를 요청함.(트랜잭션단위로 다름)
		//setConnection을 이용해 하나의 비즈니스 로직을 처리할때마다 따로 커넥션을 처리할수있도록 함.
		loginDAO.setConnection(con);
		
		//삽입된 레코드 수 리턴
		int insertCount = loginDAO.insertMember(memberVO);
		if(insertCount > 0) {
			//삽입 성공 -> 커밋(트랜잭션 완료)
			commit(con);
			registSuccess = true;
		} else {
			//실패 -> 롤백
			rollback(con);
		}
		return registSuccess;
	}

}
