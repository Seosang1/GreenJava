<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>StudentInfo</title>
<script type="text/javascript">
      
      
      function verifyName(input) {
      
      var kor = /[ㄱ-ㅎ|ㅏ-ㅣ|가-힣]/;
      
      if(kor.test(input) == false) {
         alert("올바른 이름을 입력하세요");
         return false;
         
      } else {
         alert("이름 입력 완료");
         return true;      
      }   
}      
      function verifyNumber(input1) {
      
      var num = /^(\s|\d)+$/;
      
      if(num.test(input1) == false) {
         alert("올바르지 않은 학번입니다");
         return false;

      } else {
         alert("학번 입력 완료");
         return true;
      }
}

      function verifyEmail(input2) {
      
      var mail = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;

      if(mail.test(input2) == false) {
         alert("올바른 이메일 형식으로 입력하세요");
         return false;
      } else {
         alert("이메일 입력 완료");
         return true;
      }
     
}
      
</script>
</head>
<body>
   <script>
    var input = prompt("이름을 입력해주세요");
    verifyName(input);
   
   
    var input1 = prompt("학번을 입력해주세요");
    verifyNumber(input1);
   
   var input2 = prompt("이메일을 입력해 주세요");
         verifyEmail(input2);
   
   confirm("학생정보를 입력하시겠습니까?")
   var con_test = confirm
   if(con_test ==true) {
   document.write(input);
   document.write(input1);
   document.write(input2);
   }else if(con_test ==false){
   document.write();
   }
   </script> 
   
</body>
</html>