package controller;
// (Cookie �ǽ�) �ش� ����Ʈ�� ��û�� �Ҷ��� LoginServlet ������ ���� ���� ��ģ�ٰ� ����
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import svc.LoginService;
import vo.MemberVO;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	// TODO Auto-generated method stub
    	//�����ο� �ٷ� �����ϸ� doGet�� ����ȴٰ� ����(�ּ�ġ�� ����)
    	// Ŭ���̾�Ʈ �ý��ۿ� �α��� �� ���̵�� ��й�ȣ�� ��Ű�� ������ �ش� ������ �α��� ó��
    	// ��Ű ������ ������ �α��� �������� ��ȯ
    	
    	//��Ű ���(��û�� �Ѿ���� ��Ű��ü ������)
    	Cookie[] cookieArray = request.getCookies();
    	
    	 //����Ʈ�� �����ڸ��� ������� id�� ��й�ȣ ���� ������
    	String id = "";
    	String passwd = "";
    	if(cookieArray != null) {
    		//���� ��Ű ��ü�� �ϳ��� �ִ� ���
    		//��Ű�� ����Ǵ� ���
    		//cookieName = cookieValue;
    		for (int i = 0; i < cookieArray.length; i++) {
				if(cookieArray[i].getName().contentEquals("id")) {
					//��Ű �̸��� id�� ��� id��(value)�� id�� ����
					id = cookieArray[i].getValue();
				} else if(cookieArray[i].getName().contentEquals("passwd")) {
					//��Ű �̸��� passwd�� ��� �����(value)�� passwd�� ����
					passwd = cookieArray[i].getValue();
				}
			}
    	}
    	
    	//�α���
    	LoginService loginService = new LoginService();
		
		MemberVO loginMember = loginService.getLoginMember(id, passwd);
		
		if(loginMember == null) {
			//�α��� ����
			response.sendRedirect("loginForm.jsp");
		} else {
			//�α��� ����
			HttpSession session = request.getSession();
			session.setAttribute("loginMember", loginMember); //loginMember�̸����� loginMember��ü �־���
			response.sendRedirect("loginSuccess.jsp"); //�������� �ּ� �־���
		}
    	
    }
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = request.getParameter("id");
		String passwd = request.getParameter("passwd");
		String cookieUse = request.getParameter("cookieUse");
		
		if(cookieUse != null) {
			//üũ�ڽ��� üũ������
			Cookie idCookie = new Cookie("id", id);
			//��Ű ��ü�� �����ϸ� �����Ⱓ�� -1�� ������
			//��,�������� ����Ǿ� �������� ��Ű�� ���������� �������� ���� ��Ű�� ��� �Ҹ��
			idCookie.setMaxAge(60 * 60 * 24); //������ �� //�Ϸ� ����
			response.addCookie(idCookie); //���信 �޾���
			
			Cookie passwdCookie = new Cookie("passwd", passwd);
			//��Ű ��ü�� �����ϸ� �����Ⱓ�� -1�� ������
			//��,�������� ����Ǿ� �������� ��Ű�� ���������� �������� ���� ��Ű�� ��� �Ҹ��
			idCookie.setMaxAge(60 * 60 * 24); //������ �� //�Ϸ� ����
			response.addCookie(passwdCookie); //���信 �޾���
		}
		
		// ����Ͻ� ������ ��Ʈ�ѷ����� ó���ϴ� ���� �ƴ�. (��Ʈ�ѷ����� ó���ϸ� ��1)
		// Model(service Ŭ����)���� ó���ؾ���
		LoginService loginService = new LoginService();  //�𵨿���
		
		//�α��ο� �����ϸ� �α��ο� ������ ȸ���� ������ ������ְ�
		//�α��ο� �����ϸ� �α��� ���� �޼����� ���
		
		//�α����� ����/���ж� ����Ÿ���� boolean���� �ִ°� ����
		//�ٵ� ������ �α��ο� ������ ȸ�������� ���Ϲ����Ŷ� get���� �Լ��̸��� ��
		MemberVO loginMember = loginService.getLoginMember(id, passwd);
		//�α��ο� �����ϸ� �α��ε� ������� ������ ��ȯ
		//�α��ο� �����ϸ� null�� ��ȯ -> null���� �ƴ����� ���� ���� �Ǵܰ���
		
		//js�� ������
		if(loginMember == null) {
			//login false
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('�α��ν���!')"); //���â ���
			out.println("history.back()"); //���������� �湮�� �ּҵ��� �����ϴ� ��ü -> back() ������ �湮�ߴ� �ּҷ� ���ư�
			out.println("</script>");
			
		} else {
			//�α��� ����
			//����� ���� ���
			
			//������ ����
			//�������� ������ �����ϴ� ���
			//1.�ʱ�ȭ �Ķ���͸� �̿��ϴ� ���
			// web.xml�� �ʱ�ȭ �Ķ���͸� �����ؼ� ����(�����ӿ�ũ ���� ����ϱ�~!)
			//2. �Ӽ��� ���
			//Object ������ü.getAttribute(STring attrName)
			
			//������ü ����
			//page : ���� ������ �������� ����
			//request : �ϳ��� ��û�� ó���ϱ� ���ؼ� �������� ��� ���������� ����
		    //session : �ϳ��� �����(������)���� ����
		    //application : ���������̼� �� ����
			
			//�������� JSP�� �������ϴ� ���
			// 1. ����ġ ��� - ������ ��ȯ�� �����󿡼� �̷����
			
			HttpSession session = request.getSession();
			session.setAttribute("loginMember", loginMember); //loginMember�̸����� loginMember��ü �־���

			//��Ű �̿��ϴ� ���
//			response.sendRedirect("loginSuccess.jsp"); //�������� �ּ� �־���
			
			//session
			response.sendRedirect("index.jsp");
		}
	}

}












