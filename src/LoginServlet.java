import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login")
public class LoginServlet extends HttpServlet 
{
	
	private LoginDAO loginDao;
	public void init()
	{
		loginDao = new LoginDAO();
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String mailid = request.getParameter("mailid");
		String password = request.getParameter("password");
		//TODO regex validation for input
		//TODO password salting/encryption
		LoginBean loginBean = new LoginBean();
		loginBean.setmailid(mailid);
		loginBean.setPassword(password);
		try {
			boolean success = loginDao.validate(loginBean);
			if(success)
			{
				response.sendRedirect("Home.jsp");
				HttpSession session = request.getSession();
		        session.setAttribute("mailid", mailid);
			}
			else
			{
				 PrintWriter out = response.getWriter();
				 out.println("You have entered wrong mailid or password");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}
	
}
