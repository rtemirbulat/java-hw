import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/regControl")
public class RegControl extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uname = request.getParameter("usnm");
        String password = request.getParameter("pwd");


        User user = new User(uname,password);
        RegDao rdao = new RegDao();
        boolean res = rdao.insert(user);
        PrintWriter writer = response.getWriter();
        if(res){
            String htmlResponse = "<html>";
            htmlResponse += "<h2>Registration successful <br/>";
            htmlResponse+= "<img src='https://i.pinimg.com/originals/5c/10/6e/5c106e7f7095aef477091236a41d3d57.png' width='225' height='225'> <br/>";
            htmlResponse += "return to the login page:</h2>";
            htmlResponse += "<a href="+"'index.jsp'"+">  return</a>";
            htmlResponse += "</html>";

            // return response
            writer.println(htmlResponse);
        }
        else{
            String htmlResponse = "<html>";
            htmlResponse += "<h2>Duplicate username <br/>";
            htmlResponse+= "<img src='https://i.pinimg.com/originals/a1/b8/27/a1b827c676e952f26f10e8af714f4521.png'> <br/>";

            htmlResponse += "return to the login page:</h2>";
            htmlResponse += "<a href="+"'index.jsp'"+">  return</a>";
            htmlResponse += "</html>";
            writer.println(htmlResponse);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
