<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ include file="/WEB-INF/views/jsp/main/ad_header.jsp"%>

<script>
let uploadedImg = 0;
function showImg(input) {
	   if(input.files[0]) {
	      let reader = new FileReader();
	      reader.readAsDataURL(input.files[0]);
	      reader.addEventListener('load', () => {
	         $('#previewImg').attr('src', reader.result);
	         $('#previewImg').show();
	      }, false);
	      uploadedImg = 1;
	   }
	}
function init(){
	$('#photoo').change(function() {
	      showImg(this);
	});
}
$(init);
</script>
<div class="container-fluid text-center">    
  <div class="row content">
    <div class="col-sm-2 text-left"> 
    </div>
    
    <div class="col-sm-10 text-left"> 
    
  	<form  method="POST" action="/main/regist" id="product_register_form"  enctype="multipart/form-data" >
			<div class="mb-4 row">
			<label for="subject" class="col-sm-2 col-form-label">상품 카테고리</label>
			<div class="col-sm-5">	
				<select class="form-select" aria-label="Default select example" name="category">
					<option selected>카테고리를 선택하세요</option>
				  	<option value="NEW">NEW</option>
					<option value="STANDARD">STANDARD</option>
					<option value="OUTER">OUTER</option>
					<option value="TOP">TOP</option>
					<option value="BOTTOM">BOTTOM</option>
					<option value="ACC">ACC</option>
					<option value="ALL">ALL</option>
				</select>
			</div>	
			</div><br>
			<div class="mb-4 row">
				<label for="subject" class="col-sm-2 col-form-label">상품 제목</label>
				<div class="col-sm-5">
					<input type="text" class="form-control" id="title " name="title"  maxlength="20" placeholder="상품명">
				</div>
			</div><br>
			<div class="mb-3 row">
				<label for="writer" class="col-sm-2 col-form-label">작성자</label>
				<div class="col-sm-5">
					<input type="text" class="form-control" id="writer" name="writer"  maxlength="20" value="admin">
				</div>
			</div><br>
			<div class="mb-3 row">
				<label for="price " class="col-sm-2 col-form-label">상품 가격</label>
				<div class="col-sm-5">
					<input type="text" class="form-control" id="price " name="price " maxlength="40" placeholder="상품가격">	
				</div>
			</div><br>
			<div class="mb-3 row">
				<label for="contents " class="col-sm-2 col-form-label">상품 설명</label>
				<div class="col-sm-5">
					<div class="form-floating">
					  	<textarea class="form-control" placeholder="상품 설명" name="contents" style="height: 200px"></textarea>
					  	<label for="floatingTextarea2"></label>
					</div>
				</div>
			</div><br>
			
			<div class='mb-3 row'>
					<label for="photoo" class="col-sm-2 col-form-label">메인 이미지</label>
					<div>
					<!-- <input type="file" name="photoo" id="photoo"> -->
					<input multiple="multiple" type="file" name="photoo" id="photoo">
					</div><br>
					<hr><br>
					<label for="previewImg " class="col-sm-2 col-form-label">선택한 메인 이미지</label>
					<img id='previewImg'/>
					<hr><br>
			</div>
			
		<button type="submit" id="joinBtn" class="w3-button w3-block w3-black w3-ripple w3-margin-top w3-round">등록</button>
		<button type="button" onclick="history.go(-1);" class="w3-button w3-block w3-black w3-ripple w3-margin-top w3-round">취소</button>
	</form>
</div>
  </div>
</div>

<!-- 관리자페이지 푸터 삭제 -->
</body>
</html>