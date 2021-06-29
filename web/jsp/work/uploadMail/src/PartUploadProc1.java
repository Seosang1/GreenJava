import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/partUploadProc1")
@MultipartConfig(
		fileSizeThreshold = 0 , 
		location = "E:\\web\\jsp\\work\\testExam\\WebContent\\upload"
)
public class PartUploadProc1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
        
    public PartUploadProc1() {
        super();
    }
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String name = request.getParameter("name");
		// cos.jar�� �ٸ��� request��ü�� ����� �� ����
		Part part = request.getPart("file1");
		// ���ε�Ǵ� ������ Part�� �ν��Ͻ��� ����
		
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		
		String contentDisposition = part.getHeader("content-disposition");
		System.out.println(contentDisposition);	// �ܼ�â���� �����		// ��) form-data; name="file1"; filename="1. ȸ�����̺��ۼ�.PNG"
		
		String uploadFileName = getUploadFileName(contentDisposition);	// ���ε��� ������ �̸��� ����.		��) 1. ȸ�����̺��ۼ�.PNG
		System.out.println(uploadFileName);		// �ܼ�â���� �����		
		
		part.write(uploadFileName);
		out.println("�ۼ��� " + name + "���� " + uploadFileName + " ������ ���ε� �Ͽ����ϴ�.");
		
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
