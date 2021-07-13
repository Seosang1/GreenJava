<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<script>
	function chkVal(frm) {
		var uid = frm.uid.value;
		var pwd = frm.pwd.value;

		if (uid == "") {
			alert("아이디를 입력하세요");
			frm.uid.focus(); 	return false;
		} else if (uid.length < 4) {
			alert("아이디는 4자 이상 ");
			frm.uid.focus(); 	return false;
		}

		if (pwd == "") {
			alert("비밀번호를 입력하세요");
			frm.pwd.focus(); 	return false;
		} else if (uid.length < 4) {
			alert("비밀번호는 4자 이상 ");
			frm.pwd.focus(); 	return false;
		}
		
		return true;
	}
</script>

<script>
    //19f93132e50abbfe538037a6c17ff9d2
    window.Kakao.init("19f93132e50abbfe538037a6c17ff9d2");
    function kakaoLogin(){
        window.Kakao.Auth.login({
            scope:'profile, account_email, gender',
            succeess : function(authObj){
                console.log(authObj);
            window.Kakao.API.request({
                url:'/v2/user/me',
                succeess: res =
                    const kakao_account = res.kakao_account;
                    console.log(kakao_account);
                }
            });
            }
        });
    }
</script>

<script type="text/javascript" src="https://static.nid.naver.com/js/naverLogin_implicit-1.0.3.js" charset="utf-8"></script>
<script type="text/javascript" src="http://code.jquery.com/jquery-1.11.3.min.js"></script>

</head>
<body>
	<h3>로그인</h3>
	<form name="frmLogin" action="login" method="post" onsubmit="return chkVal(this);">
		<table cellpadding="5">
			<tr>
				<th><label for="uid">아이디</label></th>
				<td><input type="text" name="uid" maxlength="20" /></td>
			</tr>
			<tr>
				<th><label for="pwd">비밀번호</label></th>
				<td><input type="password" name="pwd" maxlength="20" /></td>
			</tr>
			<tr>
				<td><input type="checkbox"/></td>
				<td><a href="member/join_form.jsp">회원가입</a>	
				<!—  'brd_list.ntc'로 매핑된 서블릿으로 이동 —>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<input type="submit" value="로그인" />&nbsp;&nbsp;&nbsp;&nbsp;
					<input type="reset" value="다시 입력" />
				</td>
			</tr>
		</table>
	</form>
	    <a href="javascript:kakaoLogin();"><img src="https://www.gb.go.kr/Main/Images/ko/member/certi_kakao_login.png"
        style="height:50px;width:auto;"></a>
    <script src="http://developers.kakao.com/sdk/js/kakao.js"></script>


    <!-- 네이버 로그인 버튼 노출 영역 -->
    <div id="naver_id_login"></div>

    <script type="text/javascript">
        var naver_id_login = new naver_id_login("====클라이언트아이디=====", "=====콜백 url====");
        var state = naver_id_login.getUniqState();
        naver_id_login.setButton("white", 5,50);
        naver_id_login.setDomain("YOUR_SERVICE_URL");
        naver_id_login.setState(state);
        naver_id_login.setPopup();
        naver_id_login.init_naver_id_login();
    </script>
</body>
</html>
</body>
</html>