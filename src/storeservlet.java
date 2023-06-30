

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/storeservlet")
public class storeservlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	response.setContentType("text/html");
	PrintWriter out=response.getWriter();
	String bname=request.getParameter("bname");
	String aname=request.getParameter("aname");
	String date=request.getParameter("date");
	String name=request.getParameter("name");
	
	Issue i=new Issue();
	i.setBname(bname);
	i.setAname(aname);
	i.setDate(date);
    i.setName(name);
try {
	int status=IssueDao.save(i);
	if(status>0){
		out.print("<div align='center'>");
	out.print("<p>Record stored sucessfully</p>");
	
	out.print("</div>");
	request.getRequestDispatcher("NewFile.html").include(request, response);
	}
	else{
		out.print("unable to store the Record");
	}
	out.close();
} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}

	}
}
