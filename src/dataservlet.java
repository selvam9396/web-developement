

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class dataservlet
 */
@WebServlet("/dataservlet")
public class dataservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public dataservlet() {
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
		
		out.println("<a href='NewFile.html'>Addnewdata</a>");
		out.println("<p>List of Book data</p>");
		
		List<Issue> list=IssueDao.getalldata();
		out.print("<table border='1' width='100%'>");
		out.print("<tr><th>Id</th><th>Bookname</th><th>Aurthorname</th><th>Date</th><th>Name</th><th>Edit</th><th>Delete</th></tr>");
		for(Issue i:list){
			out.println("<tr><td>"+i.getId()+"</td><td>"+i.getBname()+"</td><td>"+i.getAname()+"</td><td>"+i.getDate()+"</td><td>"+i.getName()+"</td><td><a href='editservlet?id="+i.getId()+"'>Edit</a></td><td><a href='deleteservlet?id="+i.getId()+"'>Delete</a></td></tr>");
		}
		out.print("</table>");
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
