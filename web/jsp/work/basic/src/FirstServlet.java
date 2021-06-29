import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(description = "처음으로 만든 서블릿", urlPatterns = { "/first" })
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public FirstServlet() { 
    	super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	// 사용자가 get방식으로 보낸 요청과 데이터들을 request하는 매개변수로 받아 response로 응답하는 메소드
 		response.getWriter().append("Served at: ").append(request.getContextPath());
 		// border가 1인 3행 2열짜리 표를 출력
 		String str = "<br /><table border = '1'><tr><td> </td></tr>";
 		str += "<tr><td> </td><td> </td></tr><tr><td> </td><td> </td></tr></table>";
 		response.getWriter().append(str);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	// 사용자가 post방식으로 보낸 요청과 데이터들을 request하는 매개변수로 받아 response로 응답하는 메소드
		doGet(request, response);
	} 
}
