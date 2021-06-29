import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

@WebServlet("/partUploadProc2")
@MultipartConfig(
		fileSizeThreshold = 0 , 
		location = "E:\\\\web\\\\jsp\\\\work\\\\testExam\\\\WebContent\\\\upload"
)
public class PartUploadProc2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public PartUploadProc2() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		String name = request.getParameter("name");
		String uploadFileNameList = "";		// ���� �̸����� ������ ���� 
		
		for (Part part : request.getParts()) { 
			// getParts() : ���ε�� ���� ��ü���� Collection<Part>�� ��� �����ϴ� �޼ҵ� 
			// getParts()�� �޾ƿ� Part��ü���� �ϳ��� ���ʴ�� Part �� �ν��Ͻ� part�� ��� ������ ��
			if (!part.getName().equals("name")) {
				// part�� �޾ƿ� ��Ʈ���� �̸��� "name"�� �ƴ� ���(file��Ʈ�Ѹ� �۾��ϰڴٴ� �ǹ�) 
				String contentDisposition 	= part.getHeader("content-disposition");
				String uploadFileName 		= getUploadFileName(contentDisposition); 
				uploadFileNameList += ", " + uploadFileName;
				part.write("test_"+ uploadFileName); 
			}
		}
		
		if (!uploadFileNameList.equals(""))
			uploadFileNameList = uploadFileNameList.substring(2);
		
		out.println("���δ� " + name + "���� " + uploadFileNameList + "���ϵ��� ���ε� �߽��ϴ�.");
		// uploadFileNameList : �����̸����� ��ǥ�� �����Ͽ� �����Ǿ� �־�� ��
		// ��) a.txt, b.xls, c.hwp
		
	}

	/**  ���� �̸� ���� 	 */
	private String getUploadFileName(String contentDisposition) {
		String uploadFileName = null;
		String[] contentSplitStr = contentDisposition.split(";");
		// contentDisposition ���ڿ��� �����ݷ��� �������� String �迭�� ����
		
		// contentSplitStr[2] �� ����ִ� �� - filename="1. ȸ�����̺��ۼ�.PNG"
		int firstQutosIndex = contentSplitStr[2].indexOf("\"");
		// contentSplitStr[2] �� ����ִ� ������ ù��° ū ����ǥ�� ��ġ ���� (���ڿ� �ڸ��� ������ġ)
		int lastQutosIndex = contentSplitStr[2].lastIndexOf("\"");
		// contentSplitStr[2] �� ����ִ� ������ ������ ū ����ǥ�� ��ġ ���� (���ڿ� �ڸ��� ������ġ)
		
		uploadFileName = contentSplitStr[2].substring(firstQutosIndex + 1, lastQutosIndex);
		// contentSplitStr[2] �� ����ִ� ������ �����̸� �κи� ����
				
		return uploadFileName;
		
	}
}
