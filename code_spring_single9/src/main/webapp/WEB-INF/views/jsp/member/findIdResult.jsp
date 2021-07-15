<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<%@ include file="/WEB-INF/views/jsp/main/header.jsp"%>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<head>
</head>

<div id="login_wrap">
	<div style="height: 400px">
		<c:if test="${check == 1}">

			<label>일치하는 정보가 존재하지 않습니다.</label>
		</c:if>

		<c:if test="${check == 0 }">
			<label>찾으시는 아이디는' ${u_id}' 입니다.</label>
		</c:if>

		<input type="button" value="뒤로가기" class="input_button"
			onclick="goBack();" />
		<script type="text/javascript">
			function goBack() {
				window.history.back();
			}
		</script>
	</div>
</div>


<%@ include file="/WEB-INF/views/jsp/main/footer.jsp"%>