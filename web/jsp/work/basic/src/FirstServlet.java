import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(description = "ó������ ���� ����", urlPatterns = { "/first" })
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public FirstServlet() { 
    	super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	// ����ڰ� get������� ���� ��û�� �����͵��� request�ϴ� �Ű������� �޾� response�� �����ϴ� �޼ҵ�
 		response.getWriter().append("Served at: ").append(request.getContextPath());
 		// border�� 1�� 3�� 2��¥�� ǥ�� ���
 		String str = "<br /><table border = '1'><tr><td> </td></tr>";
 		str += "<tr><td> </td><td> </td></tr><tr><td> </td><td> </td></tr></table>";
 		response.getWriter().append(str);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	// ����ڰ� post������� ���� ��û�� �����͵��� request�ϴ� �Ű������� �޾� response�� �����ϴ� �޼ҵ�
		doGet(request, response);
	} 
}
