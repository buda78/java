import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;

public class RequestInfoServlet extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<html>");
        out.println("<head>");
        out.println("<title>Request Information</title>");
        out.println("</head>");
        out.println("<body>");

        out.println("<h2>Client Information:</h2>");
        out.println("<p><b>IP Address:</b> " + request.getRemoteAddr() + "</p>");
        out.println("<p><b>Browser Type:</b> " + request.getHeader("User-Agent") + "</p>");

        out.println("<h2>Server Information:</h2>");
        out.println("<p><b>Server Name:</b> " + request.getServerName() + "</p>");
        out.println("<p><b>Server Port:</b> " + request.getServerPort() + "</p>");
        out.println("<p><b>Server Info:</b> " + getServletContext().getServerInfo() + "</p>");

        out.println("</body>");
        out.println("</html>");
    }
}

