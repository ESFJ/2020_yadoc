

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TrotKingChoiceServlet
 */
@WebServlet("/trotKingChoice")
public class TrotKingChoiceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TrotKingChoiceServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String[] trotKingArray = request.getParameterValues("trotKing");
		
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<table align = 'center'>");
		out.println("<tr>");
		for (int i = 0; i < trotKingArray.length; i++) {
			out.println("<td><img src ='images/" + trotKingArray[i] + "'/></td>");
		}
		out.println("</tr>");
		out.println("</table>");
	}

}
