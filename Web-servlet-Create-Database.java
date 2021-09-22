Server Side Code:
@WebServlet("/CreateDb")
public class CreateDb extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public CreateDb() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String dbName= request.getParameter("dbname");
		PrintWriter out = response.getWriter();
		
		try{
			String query="create database "+dbName;
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/","root","");
			Statement st = con.createStatement();
			st.executeUpdate(query);
			out.println("<h2>Database Created</h2>");
			out.println("</br></br><a href=Index.html>Click Here.</a>");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}

@WebServlet("/InsertRecord")
public class InsertRecord extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public InsertRecord() {
        super();
        // TODO Auto-generated constructor stub
    }
    
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String email= request.getParameter("email");
		PrintWriter out = response.getWriter();
		try{
			//String query = "insert into student value("+id+",'"+name+"','"+email+"')";
			String query = "insert into student value(?,?,?)";
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/shirish","root","");
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, id);
			ps.setString(2, name);
			ps.setString(3, email);
			ps.executeUpdate();
			out.println("<h2>Inserted Record</h2>");
			out.println("</br></br><a href=Index.html>Click Here.</a>");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}

@WebServlet("/CreateTb")
public class CreateTb extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
    public CreateTb() {
        super();
        // TODO Auto-generated constructor stub
    }

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String tbName = request.getParameter("tbname");
		PrintWriter out = response.getWriter();
		try{
			String query="create table "+tbName+"(id INTEGER(20) not NULL, " +
				       "Name VARCHAR(50), "+
				       "Email VARCHAR(100), "+
				       "PRIMARY KEY( id ))";
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/shirish","root","");
			Statement st = con.createStatement();
			st.executeUpdate(query);
			out.println("<h2>Table Created</h2>");
			out.println("</br></br><a href=Index.html>Click Here.</a>");
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}

@WebServlet("/DeleteTable")
public class DeleteTable extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public DeleteTable() {
        super();
        // TODO Auto-generated constructor stub
    }
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String tbname=request.getParameter("tbname");
		PrintWriter out = response.getWriter();
		try{
			String query="drop table "+tbname;
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/shirish","root","");
			Statement st = con.createStatement();
			st.executeUpdate(query);
			out.println("<h2>Table Deleted</h2>");
			out.println("</br></br><a href=Index.html>Click Here.</a>");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}

@WebServlet("/DeleteDb")
public class DeleteDb extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public DeleteDb() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String dbname=request.getParameter("dbname");
		PrintWriter out= response.getWriter();
		try{
			String query="drop database "+dbname;
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/shirish","root","");
			Statement st = con.createStatement();
			st.executeUpdate(query);
			out.println("<h2>Database Deleted</h2>");
			out.println("</br></br><a href=Index.html>Click Here.</a>");
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}

@WebServlet("/DeleteRecord")
public class DeleteRecord extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DeleteRecord() {
        super();
        // TODO Auto-generated constructor stub
    }
    
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = request.getParameter("id");
		PrintWriter out = response.getWriter();
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/shirish","root","");
			java.sql.CallableStatement cs = con.prepareCall("{call deleterecord(?)}");
			cs.setString(1, id);
			cs.executeUpdate();
			out.println("<h2>Record Deleted</h2>");
			out.println("</br></br><a href=Index.html>Click Here.</a>");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
