import javax.servlet.*;
import java.io.IOException;
import java.io.PrintWriter;

public class FilterEx implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        PrintWriter printWriter=servletResponse.getWriter();
        System.out.println("im here");

        printWriter.print("<html><body>This is my first filter</body></html>");

        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {

    }
}
