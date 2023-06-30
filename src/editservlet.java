

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class editservlet
 */
@WebServlet("/editservlet")
public class editservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public editservlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		out.println("<h1>Update data</h1>");
		String bid=request.getParameter("id");
		int id=Integer.parseInt(bid);
		
		Issue i=IssueDao.getdatabyid(id);
		
		out.println("<form action='editservlet2' method='post'>");
		out.print("<table>");
		out.print("<tr><td></td><td><input type='hidden' name='id' value='"+i.getId()+"'/></td></tr>");
		out.print("<tr><td>Bookname</td><td><input type='text' name='bname' value='"+i.getBname()+"'/></td></tr>");
		out.print("<tr><td>Aurthorname</td><td><input type='text' name='aname' value='"+i.getAname()+"'></td></tr>");
		out.print("<tr><td>Date</td><td><input type='text' name='date' value='"+i.getDate()+"'></td></tr>");
		out.print("<tr><td>Name</td><td><input type='text' name='name' value='"+i.getName()+"'></td></tr>");
		out.print("<tr><td><input type='submit' value='edit & save'></td></tr>");
		out.print("</table>");
		out.print("</form>");
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
