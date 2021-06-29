<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.oreilly.servlet.MultipartRequest" %>
<%@ page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy" %>
<%@ page import="java.util.*" %>
<%

request.setCharacterEncoding("utf-8"); 

int maxSize = 5 * 1024 * 1024;	 
String img = "", img_old ="";	
String file1 = "", file2 = "", file3 = "";	
String file1_old = "", file2_old = "", file3_old = "";  
String uploadPath = "D://ssw\\web\\jsp\\work\\testExam\\WebContent\\upload";

System.out.println(uploadPath);

request.setCharacterEncoding("utf-8"); 

try {
	MultipartRequest multi = new MultipartRequest(
		request, 	 
		uploadPath, 
		maxSize, 	 
		"utf-8", 	 
		new DefaultFileRenamePolicy());	 

	Enumeration files = multi.getFileNames();
 
	
	String img1 = (String)files.nextElement();
	img = multi.getFilesystemName(img1);		 
	img_old = multi.getOriginalFileName(img1);	  
	
	String f1 = (String)files.nextElement();
	file1 = multi.getFilesystemName(f1);		 
	file1_old = multi.getOriginalFileName(f1);	 

	String f2 = (String)files.nextElement();
	file2 = multi.getFilesystemName(f2);
	file2_old = multi.getOriginalFileName(f2);

	String f3 = (String)files.nextElement();
	file3 = multi.getFilesystemName(f3);
	file3_old = multi.getOriginalFileName(f3);

	System.out.println(file1 + file2 + file3);
} catch (Exception e) {
	e.printStackTrace();
}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>파일 업로드 결과</h3>
<table cellpadding="5"> 
<tr><th>증명사진</th><td><a href="fileDownload.jsp?file=<%=img%>"><%=img_old %></a></td></tr>
<tr><th>이력서</th><td><a href="fileDownload.jsp?file=<%=file1%>"><%=file1_old %></a></td></tr>
<tr><th>증빙서류1</th><td><a href="fileDownload.jsp?file=<%=file2%>"><%=file2_old %></a></td></tr>
<tr><th>증빙서류2</th><td><a href="fileDownload.jsp?file=<%=file3%>"><%=file3_old %></a></td></tr>
</table>
</body>
</html>
