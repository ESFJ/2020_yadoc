package svc;

import static db.JDBCUtil.*;
import java.sql.Connection;

import dao.LoginDAO;
import vo.MemberVO;
//Ʈ����� ó���� ���񽺴ܿ��� �ϹǷ� Connection ��ü�� Service Ŭ�������� �ٷ��� �Ѵ�.
//�ڹٿ����� Connection ������ Ʈ������� �̷������.
public class LoginService {

	public MemberVO getLoginMember(String id, String passwd) {
		// TODO Auto-generated method stub
		Connection con = getConnection();
		
		//SQL �۾��� DAO(data access object) Ŭ�������� �����Ѵ�.
		LoginDAO loginDAO = LoginDAO.getInstance(); //�̱��� ���� �̿�
		
		//DAO�� ���������� connection�� ���� �ٸ� ��ü�� ��û��.(Ʈ����Ǵ����� �ٸ�)
		//setConnection�� �̿��� �ϳ��� ����Ͻ� ������ ó���Ҷ����� ���� Ŀ�ؼ��� ó���Ҽ��ֵ��� ��.
		loginDAO.setConnection(con);
		
		//SQL �۾�
		//seletct, update �̷� �̸����� �Լ��� ����������
		//����ϴ� ��ġ�� ���� �Լ��� �̸��� �޶���.
		MemberVO loginMember = loginDAO.selectLoginMember(id, passwd);
		close(con);
		return loginMember;
	}
}
