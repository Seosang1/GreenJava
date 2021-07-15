<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ include file="/WEB-INF/views/jsp/main/ad_header.jsp"%>

<style>
	#aaa {
		color: red;
	}
</style>

<div class="container-fluid text-center">    
  <div class="row content">
   <!-- include ad_gnb -->
    <%@ include file="/WEB-INF/views/jsp/main/ad_gnb.jsp"%>
  	<!--  
    <div class="col-sm-2 sidenav">
      <p><a href="#" id="aaa">NEW</a></p>
      <p><a href="">STANDARD  </a></p>
      <p><a href="#">OUTER</a></p>
      <p><a href="#">TOP</a></p>
      <p><a href="#">BOTTOM</a></p>
      <p><a href="#">ACC</a></p>
      <p><a href="#">ALL</a></p>
    </div>
    -->
    <div class="col-sm-10 text-left"> 
    
  <form  method="POST" action="/admin/update" id="product_register_form"  enctype="multipart/form-data" >

<div>
		<table id=basic-info border="1">
			<div class="mb-4 row">
				<label for="board_subject" class="col-sm-2 col-form-label">상품 제목</label>
				<div class="col-sm-5">
					<input type="hidden" name="seq" value="${ detail.seq }">
					<input type="text" class="form-control" id="title " name="title"  maxlength="20" value="${ detail.title }">
				</div>
			</div><br>
			<div class="mb-4 row">
				<label for="board_subject" class="col-sm-2 col-form-label">상품 수정자</label>
				<div class="col-sm-5">
					<input type="text" class="form-control" id="writer " name="writer"  maxlength="20" value="${ detail.writer }">
				</div>
			</div><br>
			<div class="mb-3 row">
				<label for="board_price " class="col-sm-2 col-form-label">상품 가격</label>
				<div class="col-sm-5">
					<input type="text" class="form-control" id="price " name="price " maxlength="40" value="${ detail.price }">	
				</div>
			</div><br>
			<div class="mb-3 row">
				<label for="board_content " class="col-sm-2 col-form-label">상품 설명</label>
				<div class="col-sm-5">
					<div class="form-floating">
					  	<textarea class="form-control" name="contents" style="height: 200px">${ detail.contents }</textarea>
					  	<label for="floatingTextarea2"></label>
					</div>
				</div>
			</div><br>
			<div class="mb-3 row">
				<label for="board_photo " class="col-sm-2 col-form-label">상품 이미지</label>
				<div class="col-sm-5">
					<input type="hidden" name="photo" value="${ detail.photo }">
					<img id="photo " name="photo" src="/images/product/${ detail.photo }">	
				</div>
			</div><br>
			<div class="mb-3 row">
				<label for="board_photo " class="col-sm-2 col-form-label">상품 이미지 변경</label>
				<div class="col-sm-5">
					<input type="file" name="photoo">
				</div>
			</div><br>
			</table>
		<div class="mb-3 row">
			<label for="board_photo " class="col-sm-4 col-form-label"></label>
		<button type="submit" id="joinBtn" class="w3-button w3-block w3-black w3-ripple w3-margin-top w3-round">수정</button>
		<button type="button" onclick="delete_product(${ detail.seq })" class="w3-button w3-block w3-black w3-ripple w3-margin-top w3-round">삭제</button>
		<button type="button" onclick="history.go(-1);" class="w3-button w3-block w3-black w3-ripple w3-margin-top w3-round">취소</button>
		<br><br>
		</div>
	</form>
</div>
  </div>
</div>
<script>
	function delete_product(seq) {
		var result = confirm("정말 삭제하겠습니까?");
		if (result == true) {
			location.href="/admin/delete?seq=" + seq;
		}
	}
</script>


<%-- 	<%@ include file="/WEB-INF/views/kjh/main/footer.jsp"%> --%>