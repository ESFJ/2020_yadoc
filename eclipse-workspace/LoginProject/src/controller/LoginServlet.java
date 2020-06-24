package controller;
// (Cookie 실습) 해당 사이트에 요청을 할때는 LoginServlet 서블릿을 가장 먼저 거친다고 가정
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
    	//도메인에 바로 접속하면 doGet이 실행된다고 가정(주소치고 들어갈때)
    	// 클라이언트 시스템에 로그인 된 아이디와 비밀번호가 쿠키에 있으면 해당 정보로 로그인 처리
    	// 쿠키 정보가 없으면 로그인 페이지로 전환
    	
    	//쿠키 사용(요청에 넘어오는 쿠키객체 얻어오기)
    	Cookie[] cookieArray = request.getCookies();
    	
    	 //사이트에 들어오자마자 사용자의 id와 비밀번호 값을 가져옴
    	String id = "";
    	String passwd = "";
    	if(cookieArray != null) {
    		//얻어온 쿠키 객체가 하나라도 있는 경우
    		//쿠키가 저장되는 방법
    		//cookieName = cookieValue;
    		for (int i = 0; i < cookieArray.length; i++) {
				if(cookieArray[i].getName().contentEquals("id")) {
					//쿠키 이름이 id인 경우 id값(value)를 id에 저장
					id = cookieArray[i].getValue();
				} else if(cookieArray[i].getName().contentEquals("passwd")) {
					//쿠키 이름이 passwd인 경우 비번값(value)를 passwd에 저장
					passwd = cookieArray[i].getValue();
				}
			}
    	}
    	
    	//로그인
    	LoginService loginService = new LoginService();
		
		MemberVO loginMember = loginService.getLoginMember(id, passwd);
		
		if(loginMember == null) {
			//로그인 실패
			response.sendRedirect("loginForm.jsp");
		} else {
			//로그인 성공
			HttpSession session = request.getSession();
			session.setAttribute("loginMember", loginMember); //loginMember이름으로 loginMember객체 넣어줌
			response.sendRedirect("loginSuccess.jsp"); //포워딩할 주소 넣어줌
		}
    	
    }
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = request.getParameter("id");
		String passwd = request.getParameter("passwd");
		String cookieUse = request.getParameter("cookieUse");
		
		if(cookieUse != null) {
			//체크박스를 체크했으면
			Cookie idCookie = new Cookie("id", id);
			//쿠키 객체를 생성하면 생존기간은 -1로 설정됨
			//즉,브라우저가 실행되어 있을때는 쿠키가 존재하지만 브라우저를 끄면 쿠키가 즉시 소멸됨
			idCookie.setMaxAge(60 * 60 * 24); //단위는 초 //하루 생존
			response.addCookie(idCookie); //응답에 달아줌
			
			Cookie passwdCookie = new Cookie("passwd", passwd);
			//쿠키 객체를 생성하면 생존기간은 -1로 설정됨
			//즉,브라우저가 실행되어 있을때는 쿠키가 존재하지만 브라우저를 끄면 쿠키가 즉시 소멸됨
			idCookie.setMaxAge(60 * 60 * 24); //단위는 초 //하루 생존
			response.addCookie(passwdCookie); //응답에 달아줌
		}
		
		// 비즈니스 로직은 컨트롤러에서 처리하는 것이 아님. (컨트롤러에서 처리하면 모델1)
		// Model(service 클래스)에서 처리해야함
		LoginService loginService = new LoginService();  //모델영역
		
		//로그인에 성공하면 로그인에 성공한 회원의 정보를 출력해주고
		//로그인에 실패하면 로그인 실패 메세지를 출력
		
		//로그인은 성공/실패라서 리턴타입을 boolean으로 주는게 좋음
		//근데 지금은 로그인에 성공한 회원정보를 리턴받을거라서 get으로 함수이름을 줌
		MemberVO loginMember = loginService.getLoginMember(id, passwd);
		//로그인에 성공하면 로그인된 사용자의 정보를 반환
		//로그인에 실패하면 null을 반환 -> null인지 아닌지로 성공 여부 판단가능
		
		//js로 포워딩
		if(loginMember == null) {
			//login false
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('로그인실패!')"); //경고창 띄움
			out.println("history.back()"); //브라우저에서 방문한 주소들을 저장하는 객체 -> back() 이전에 방문했던 주소로 돌아감
			out.println("</script>");
			
		} else {
			//로그인 성공
			//사용자 정보 출력
			
			//데이터 공유
			//서블릿에서 데이터 공유하는 방법
			//1.초기화 파라미터를 이용하는 방법
			// web.xml에 초기화 파라미터를 정의해서 공유(프레임워크 사용시 사용하기~!)
			//2. 속성을 사용
			//Object 영역객체.getAttribute(STring attrName)
			
			//영역객체 종류
			//page : 동일 페이지 내에서만 공유
			//request : 하나의 요청을 처리하기 위해서 읽혀지는 모든 페이지에서 공유
		    //session : 하나의 사용자(브라우저)에서 공유
		    //application : 애프리케이션 당 공유
			
			//서블릿에서 JSP로 포워딩하는 방식
			// 1. 디스패치 방식 - 페이지 전환이 서버상에서 이루어짐
			
			HttpSession session = request.getSession();
			session.setAttribute("loginMember", loginMember); //loginMember이름으로 loginMember객체 넣어줌

			//쿠키 이용하는 방식
//			response.sendRedirect("loginSuccess.jsp"); //포워딩할 주소 넣어줌
			
			//session
			response.sendRedirect("index.jsp");
		}
	}

}












