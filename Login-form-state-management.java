Server Side Code:
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
          
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uname = request.getParameter("uname");
		String pass = request.getParameter("pass");
		if(pass.equals("root"))
		{
			Cookie ck = new Cookie("Username", uname);
			response.addCookie(ck);
			HttpSession session = request.getSession();
            session.setAttribute("Username", uname);
            response.sendRedirect("Welcome?username="+uname+"");
		}
	}
}
@WebServlet("/Welcome")
public class Welcome extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public Welcome() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();
        if(session != null)
        {	
        String username = (String)session.getAttribute("Username");
        out.println("Hello "+username);
        Cookie ck[] = request.getCookies();
        for(int i = 0; i<ck.length-1;i++)
        {
        	out.println("<br>Getting cookies value: "+ck[i].getValue());
        }
        session.invalidate();
        out.println("Session Destroyed");
        }
        else
        {
        	response.sendRedirect("index.html");
        }
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
