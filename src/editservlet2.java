

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class editservlet2
 */
@WebServlet("/editservlet2")
public class editservlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public editservlet2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		String sid=request.getParameter("id");
		int id=Integer.parseInt(sid);
		
		String bname=request.getParameter("bname");
		String aname=request.getParameter("aname");
		String date=request.getParameter("date");
		String name=request.getParameter("name");
		
		Issue i=new Issue();
		i.setId(id);
		i.setBname(bname);
		i.setAname(aname);
		i.setDate(date);
		i.setName(name);
		int status=IssueDao.update(i);
		if(status>0){
			response.sendRedirect("dataservlet");
		}
		else{
			out.print("sorry unable to update the record");
		}
		out.close();
	}

}
