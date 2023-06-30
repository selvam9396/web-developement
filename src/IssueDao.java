import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class IssueDao {
public static Connection getconnection() throws SQLException{
	Connection con=null;
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/users","root", "selva");
	} catch (Exception e) {
		// TODO Auto-generated catch block
		System.out.println(e);;
	}
	return con;	
}
public static int save(Issue i) throws SQLException{
	int status=0;
	Connection con;
	try {
		con = IssueDao.getconnection();
		PreparedStatement pst=con.prepareStatement("insert into library(bname,aname,date,name) values(?,?,?,?)");
		pst.setString(1, i.getBname());
		pst.setString(2, i.getAname());
		pst.setString(3, i.getDate());
		pst.setString(4, i.getName());
		status=pst.executeUpdate();
		con.close();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return status;
}
public static int update(Issue i){
	int status=0;
	try {
		Connection con=IssueDao.getconnection();
		PreparedStatement pst=con.prepareStatement("update library set bname=?,aname=?,date=?,name=? where id=?");
		pst.setString(1, i.getBname());
		pst.setString(2, i.getAname());
		pst.setString(3, i.getDate());
		pst.setString(4, i.getName());
		pst.setInt(5, i.getId());
		status=pst.executeUpdate();
		con.close();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return status;
}
public static int delete(int id){
	int status=0;
	try {
		Connection con=IssueDao.getconnection();
		PreparedStatement pst=con.prepareStatement("delete from library where id=?");
		pst.setInt(1, id);
		status=pst.executeUpdate();
		con.close();
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return status;
	
}
	public static Issue getdatabyid(int id){
		Issue i=new Issue();
		
		try {
			Connection con=IssueDao.getconnection();
			PreparedStatement pst=con.prepareStatement("select * from library where id=?");
			pst.setInt(1, id);
			ResultSet rs=pst.executeQuery();
			if(rs.next()){
				i.setId(rs.getInt(1));
				i.setBname(rs.getString(2));
				i.setAname(rs.getString(3));
				i.setDate(rs.getString(4));
				i.setName(rs.getString(5));
				
			}
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			
			e.printStackTrace();
		}
		return i;
	}
	public static List<Issue> getalldata(){
		List<Issue> list=new ArrayList<Issue>();
		
		try {
			Connection con=IssueDao.getconnection();
			PreparedStatement pst=con.prepareStatement("select * from library");
			ResultSet rs=pst.executeQuery();
			
			while(rs.next()){
				Issue i=new Issue();
				i.setId(rs.getInt(1));
				i.setBname(rs.getString(2));
				i.setAname(rs.getString(3));
				i.setDate(rs.getString(4));
				i.setName(rs.getString(5));
				
				list.add(i);
			}
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
		
	}
}


