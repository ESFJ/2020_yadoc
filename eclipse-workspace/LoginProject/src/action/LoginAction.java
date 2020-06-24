package action;

import java.io.PrintWriter;

//controller 역할
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
			LoginService loginService = new LoginService();  //모델영역
			MemberVO loginMember = loginService.getLoginMember(id, passwd);
				
			ActionForward forward = null;
			
			if(loginMember == null) {
				response.setContentType("text/html; charset=UTF-8");
				PrintWriter out = response.getWriter();
				out.println("<script>");
				out.println("alert('로그인실패')"); //경고창 띄움
				out.println("history.back()"); //브라우저에서 방문한 주소들을 저장하는 객체 -> back() 이전에 방문했던 주소로 돌아감
				out.println("</script>");
					
			} else {
				forward = new ActionForward();
				forward.setUrl("index.jsp");
				forward.setRedirect(true); //리다이렉트 방식으로 포워딩
				HttpSession session = request.getSession();
				session.setAttribute("loginMember", loginMember); //loginMember이름으로 loginMember객체 넣어줌
			}
		
		return forward;
	}

}
