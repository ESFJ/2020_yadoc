package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import vo.ActionForward;

public class LogoutAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		//1. ���� ����
		HttpSession session = request.getSession();
		//2. �Ӽ� ������
		session.invalidate();
		
		//return value
		ActionForward forward = new ActionForward();
		forward.setUrl("index.jsp");
		forward.setRedirect(true); //redirect ������� ������
		return forward;
	}

}
