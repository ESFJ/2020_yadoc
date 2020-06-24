

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ForwardMethodServlet
 */
@WebServlet("/ForwardMethodServlet")
public class ForwardMethodServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ForwardMethodServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//1. 디스패치 방식
		//브라우저의 주소가 변경되지 않는다.
		//즉, 요청이 변경되지 않는다.
//		request.setAttribute("requestScope", "requestValue");
//		RequestDispatcher dispatcher = request.getRequestDispatcher("forwardTo.jsp");
//		dispatcher.forward(request, response);
		
		//2. 리다이렉트 방식
		//브라우저의 주소가 변경됨.
		//즉, 요청이 변경됨.
		HttpSession session = request.getSession();
		session.setAttribute("sessionScope", "sessionValue");
		response.sendRedirect("forwardTo.jsp");
	}

}
