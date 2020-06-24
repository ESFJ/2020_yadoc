package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import action.LoginAction;
import action.LogoutAction;
import action.MemberRegistAction;
import vo.ActionForward;

/**
 * Servlet implementation class MemberFrontController
 */
@WebServlet("*.me") //확장자가 .me로 끝나는 경우 FrontController에서 처리
public class MemberFrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberFrontController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		//1. 요청 파악 
		String requestURI = request.getRequestURI();
		//요청 URL : http://localhost:8088/LoginProject/login
		//requestURI : "/LoginProject/login" 이렇게 반환됨
		
		String contextPath = request.getContextPath();
		// "/LoginProject" 반환
		
		String command = requestURI.substring(contextPath.length());
		// URI에서 path길이가 끝나는 곳부터 끝까지 가져옴 -> "/login" 이 뽑아짐
		
		//2. 각 요청 처리 : 다형성 이용
		Action action = null;
		ActionForward forward = null;
		
		//각 요청별로 action객체 생성 -> execute로 처리
		if(command.contentEquals("/login.me")){
			action = new LoginAction();
			try {
				//액션에 대한 결과를 forward로 받아서 포워딩처리
				forward = action.execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if(command.contentEquals("/logout.me")){
			action = new LogoutAction();
			try {
				//액션에 대한 결과를 forward로 받아서 포워딩처리
				forward = action.execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if(command.contentEquals("/memberRegist.me")){
			action = new MemberRegistAction();
			try {
				//액션에 대한 결과를 forward로 받아서 포워딩처리
				forward = action.execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		//3. 뷰페이지로 포워딩
		if(forward != null) {
			//요청이 제대로 처리됨
			if(forward.isRedirect()) {
				//리다이렉트 방식으로 포워딩할 경우
				//지정된 URL로 리다이렉트
				response.sendRedirect(forward.getUrl());
			} else {
				//디스패치 방식으로 포워딩
				RequestDispatcher dispatcher = request.getRequestDispatcher(forward.getUrl());
				dispatcher.forward(request, response);
			}
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8"); //한글처리 해줌
		doGet(request, response); //Poset로 넘어와도 doGet으로 처리한다. //공통된 내용은 doGet에서 처리한다.
	}

}
