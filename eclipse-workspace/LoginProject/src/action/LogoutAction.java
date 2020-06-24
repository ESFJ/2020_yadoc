package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import vo.ActionForward;

public class LogoutAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		//1. 技记 立辟
		HttpSession session = request.getSession();
		//2. 加己 朝府扁
		session.invalidate();
		
		//return value
		ActionForward forward = new ActionForward();
		forward.setUrl("index.jsp");
		forward.setRedirect(true); //redirect 规侥栏肺 器况靛
		return forward;
	}

}
