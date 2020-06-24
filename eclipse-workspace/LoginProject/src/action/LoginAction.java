package action;

import java.io.PrintWriter;

//controller ����
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import svc.LoginService;
import vo.ActionForward;
import vo.MemberVO;

public class LoginAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		String id = request.getParameter("id");
		String passwd = request.getParameter("passwd");
			LoginService loginService = new LoginService();  //�𵨿���
			MemberVO loginMember = loginService.getLoginMember(id, passwd);
				
			ActionForward forward = null;
			
			if(loginMember == null) {
				response.setContentType("text/html; charset=UTF-8");
				PrintWriter out = response.getWriter();
				out.println("<script>");
				out.println("alert('�α��ν���')"); //���â ���
				out.println("history.back()"); //���������� �湮�� �ּҵ��� �����ϴ� ��ü -> back() ������ �湮�ߴ� �ּҷ� ���ư�
				out.println("</script>");
					
			} else {
				forward = new ActionForward();
				forward.setUrl("index.jsp");
				forward.setRedirect(true); //�����̷�Ʈ ������� ������
				HttpSession session = request.getSession();
				session.setAttribute("loginMember", loginMember); //loginMember�̸����� loginMember��ü �־���
			}
		
		return forward;
	}

}
