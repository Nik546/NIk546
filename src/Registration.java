import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;

public class Registration extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        PrintWriter printWriter=resp.getWriter();
        String fname=req.getParameter("firstname");
        String lname=req.getParameter("lastname");
        String mailid=req.getParameter("mailid");
        String gender=req.getParameter("gender");
        String usname=req.getParameter("uname");
//        Cookie cookie=new Cookie("uname",usname);
        String password=req.getParameter("password");
//        Cookie cookie1=new Cookie("password",password);
//         HttpSession session=req.getSession();
//                 session.setAttribute("uname",usname);











//        System.out.println(fname+lname+mailid+gender+usname+password);
        if(fname==null || fname=="" || lname=="" || lname==null || mailid==null || gender==null || usname==null || password==null )
        {
            RequestDispatcher requestDispatcher=req.getRequestDispatcher("/Registrate.html");

            requestDispatcher.forward(req,resp);


        }
        else
        {
            ServletContext servletContext=getServletContext();
            servletContext.setAttribute("uname1",usname);
            servletContext.setAttribute("password1",password);
//            resp.addCookie(cookie);
//            resp.addCookie(cookie1);
            DataBase d=new DataBase();
            Connection connection=null;
            try {
                Class.forName("org.postgresql.Driver");
                connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/", "postgres", "Loveu@546");
                d.setData(connection,usname,password);
            }
            catch (Exception e)
            {
                System.out.println("im in connection exception");
                e.printStackTrace();
            }
            finally {
                if(connection !=null)
                    try {
                        connection.close();
                    }
                    catch (Exception e)
                    {
                        e.printStackTrace();
                    }

            }


            RequestDispatcher requestDispatcher=req.getRequestDispatcher("/login.html");
            requestDispatcher.include(req,resp);
        }



            }

}
