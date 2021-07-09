 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
   Cookie cookie = new Cookie("cookieN", "cookieV"); //쿠키생성, name, value설정
   cookie.setMaxAge(60*60);    //1시간
   response.addCookie(cookie); //reponse객체에 cookie객체를 탑재

    Cookie[] cookies = request.getCookies();

    if (cookies == null ) System.out.println("쿠키없음");
    else System.out.println("쿠키있음"); 
    
    
    for(int i = 0; i < cookies.length; i++){
        String str = cookies[i].getName();
        System.out.println(str + " : str 값");
        if(str != null) {  
            System.out.println("cookies[" + i + "] name :" + cookies[i].getName() );
            System.out.println("cookies[" + i + "] value :" + cookies[i].getValue() );
        }
    } 
   //session :  내부객체
   session.setAttribute("SessionName", "SessionData");
   session.setAttribute("Num", 123); 
   
   
    Object obj1 = session.getAttribute("SessionName");        
    String SessionName = (String)obj1;
    System.out.println("SessionName = " + SessionName);
    
    Object obj2 = session.getAttribute("Num");
    Integer Num = (Integer)obj2;
    System.out.println("Num = " + Num);
%>




 


<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>
<a href="user.do">유저리스트로 가기</a> 
<a href="cookie.do">쿠키로 가기</a> 

</body>
</html>
