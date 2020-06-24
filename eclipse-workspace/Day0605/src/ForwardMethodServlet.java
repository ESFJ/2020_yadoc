

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
		//1. ����ġ ���
		//�������� �ּҰ� ������� �ʴ´�.
		//��, ��û�� ������� �ʴ´�.
//		request.setAttribute("requestScope", "requestValue");
//		RequestDispatcher dispatcher = request.getRequestDispatcher("forwardTo.jsp");
//		dispatcher.forward(request, response);
		
		//2. �����̷�Ʈ ���
		//�������� �ּҰ� �����.
		//��, ��û�� �����.
		HttpSession session = request.getSession();
		session.setAttribute("sessionScope", "sessionValue");
		response.sendRedirect("forwardTo.jsp");
	}

}
