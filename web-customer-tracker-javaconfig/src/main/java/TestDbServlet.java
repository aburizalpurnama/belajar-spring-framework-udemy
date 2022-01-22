import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;

@WebServlet("/TestDbServlet")
public class TestDbServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // setup connection variables
        String user = "rizal";
        String password = "3748";
        String url = "jdbc:mysql://localhost:3306/web_customer_tracker?useSSL=false&serverTimezone=UTC";
        String driver = "com.mysql.cj.jdbc.Driver";

        // get connection to database
        try {
            PrintWriter out = resp.getWriter();

            out.println("Connectiong to : " + url);

            Class.forName(driver);

            Connection conn = DriverManager.getConnection(url, user, password);

            out.println("Connection Success");

            conn.close();
        }catch (Exception e){
            e.printStackTrace();
            throw new ServletException(e);
        }
    }
}
