import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/auth")
public class LoginControl extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String uname = request.getParameter("usnm");
        String password = request.getParameter("pwd");
        User user = new User(uname,password);
        RegDao rdao = new RegDao();
        PrintWriter writer = response.getWriter();
        boolean res = rdao.validateLogin(user);
        if(res){
            String htmlresponse = "<html>";
            htmlresponse+= "<h2>Welcome,"+uname+"!<br/> ";
            htmlresponse+= "<h2>glad to see you<br/> ";
            htmlresponse+= "<img src='https://i1.sndcdn.com/avatars-000448070004-rnaczh-t500x500.jpg'> <br/>";
            htmlresponse += "return to the login page:</h2>";
            htmlresponse += "<a href="+"'index.jsp'"+">  return</a>";
            htmlresponse += "</html>";
            writer.println(htmlresponse);
        }
        else{
            String htmlresponse = "<html>";
            htmlresponse+= "<h2>Sorry, try again<br/> ";
            htmlresponse+= "<h2>wrong uname or password<br/> ";
            htmlresponse+= "<img src='https://i.pinimg.com/originals/a1/b8/27/a1b827c676e952f26f10e8af714f4521.png'> <br/>";

            htmlresponse += "return to the login page:</h2>";
            htmlresponse += "<a href="+"'index.jsp'"+">  return</a> <br/>";
            htmlresponse += "</html>";
            writer.println(htmlresponse);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
