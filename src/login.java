import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class login extends HttpServlet {

//    static String l;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext servletContext = getServletContext();
        String s = (String) servletContext.getAttribute("uname1");
        String k = (String) servletContext.getAttribute("password1");
//        Cookie[] ar=req.getCookies();
//        System.out.println(ar[0].getValue());
//        System.out.println(ar[1].getValue());
//        System.out.println(ar[2]);
//        System.out.println(req.getSession(false).getAttribute("uname"));
        String z = req.getParameter("uname");
        String y = req.getParameter("password");
        DataBase dataBase = new DataBase();
        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/", "postgres", "Loveu@546");

            String pwd = dataBase.getData(connection, z);
            System.out.println(pwd);

            if (pwd.equals(y)) {
                PrintWriter printWriter = resp.getWriter();
                printWriter.print("<html><body>");
                printWriter.print("<h1>Welcome to main page</h1>" + req.getParameter("uname"));
                printWriter.print("</body></html>");
            } else {
                PrintWriter printWriter = resp.getWriter();

                printWriter.print("<html><body>");
                resp.getWriter().print("<font color='red'> <b>Incorrect name or password</b></font>");

                printWriter.print("</body></html>");
                RequestDispatcher requestDispatcher = req.getRequestDispatcher("/login.html");
                requestDispatcher.include(req, resp);
            }
        }
             catch (Exception e) {

                e.printStackTrace();
            }
        }
//        catch (Exception e)
//        {
//            e.printStackTrace();
//        }
    }
//    @Override
//    private String toString()
//    {
//
//    }



