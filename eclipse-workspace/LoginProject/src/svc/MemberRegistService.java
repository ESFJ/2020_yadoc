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
		
		//SQL �۾��� DAO(data access object) Ŭ�������� �����Ѵ�.
		LoginDAO loginDAO = LoginDAO.getInstance(); //�̱��� ���� �̿�
		
		//DAO�� ���������� connection�� ���� �ٸ� ��ü�� ��û��.(Ʈ����Ǵ����� �ٸ�)
		//setConnection�� �̿��� �ϳ��� ����Ͻ� ������ ó���Ҷ����� ���� Ŀ�ؼ��� ó���Ҽ��ֵ��� ��.
		loginDAO.setConnection(con);
		
		//���Ե� ���ڵ� �� ����
		int insertCount = loginDAO.insertMember(memberVO);
		if(insertCount > 0) {
			//���� ���� -> Ŀ��(Ʈ����� �Ϸ�)
			commit(con);
			registSuccess = true;
		} else {
			//���� -> �ѹ�
			rollback(con);
		}
		return registSuccess;
	}

}
