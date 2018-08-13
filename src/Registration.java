import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class Registration extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        PrintWriter printWriter=resp.getWriter();
        String fname=req.getParameter("firstname");
        String lname=req.getParameter("lastname");
        String mailid=req.getParameter("mailid");
        String gender=req.getParameter("gender");
        String usname=req.getParameter("uname");
        String password=req.getParameter("password");

//        System.out.println(fname+lname+mailid+gender+usname+password);
        if(fname==null || fname=="first name" || lname=="last name" || lname==null || mailid==null || gender==null || usname==null || password==null )
        {
//            RequestDispatcher requestDispatcher=req.getRequestDispatcher("/Registrate.html");
//            requestDispatcher.forward(req,resp);
            System.out.println("hey you wassup?");


        }
        else
        {
            ServletContext servletContext=getServletContext();
            servletContext.setAttribute("uname1",usname);
            servletContext.setAttribute("password1",password);

            RequestDispatcher requestDispatcher=req.getRequestDispatcher("/login.html");
            requestDispatcher.forward(req,resp);
        }



            }

}
