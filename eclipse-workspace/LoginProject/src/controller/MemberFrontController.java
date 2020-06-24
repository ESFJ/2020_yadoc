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
@WebServlet("*.me") //Ȯ���ڰ� .me�� ������ ��� FrontController���� ó��
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
		//1. ��û �ľ� 
		String requestURI = request.getRequestURI();
		//��û URL : http://localhost:8088/LoginProject/login
		//requestURI : "/LoginProject/login" �̷��� ��ȯ��
		
		String contextPath = request.getContextPath();
		// "/LoginProject" ��ȯ
		
		String command = requestURI.substring(contextPath.length());
		// URI���� path���̰� ������ ������ ������ ������ -> "/login" �� �̾���
		
		//2. �� ��û ó�� : ������ �̿�
		Action action = null;
		ActionForward forward = null;
		
		//�� ��û���� action��ü ���� -> execute�� ó��
		if(command.contentEquals("/login.me")){
			action = new LoginAction();
			try {
				//�׼ǿ� ���� ����� forward�� �޾Ƽ� ������ó��
				forward = action.execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if(command.contentEquals("/logout.me")){
			action = new LogoutAction();
			try {
				//�׼ǿ� ���� ����� forward�� �޾Ƽ� ������ó��
				forward = action.execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if(command.contentEquals("/memberRegist.me")){
			action = new MemberRegistAction();
			try {
				//�׼ǿ� ���� ����� forward�� �޾Ƽ� ������ó��
				forward = action.execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		//3. ���������� ������
		if(forward != null) {
			//��û�� ����� ó����
			if(forward.isRedirect()) {
				//�����̷�Ʈ ������� �������� ���
				//������ URL�� �����̷�Ʈ
				response.sendRedirect(forward.getUrl());
			} else {
				//����ġ ������� ������
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
		request.setCharacterEncoding("UTF-8"); //�ѱ�ó�� ����
		doGet(request, response); //Poset�� �Ѿ�͵� doGet���� ó���Ѵ�. //����� ������ doGet���� ó���Ѵ�.
	}

}
