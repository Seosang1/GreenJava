<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ include file="/WEB-INF/views/jsp/main/header.jsp"%>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script>

function init(){
	
	$('#plusBtn').click(()=>{
		var q = $('#quantity').val();
		$('#quantity').val(parseInt(q) + 1);
	});
	
	$('#minusBtn').click(()=>{
		var q = parseInt($('#quantity').val());
		if(q >= 2){
			$('#quantity').val(parseInt(q) -1);	
		}
	})
	
	$('#cart').click(()=>{
		$.ajax({
			type:'post',
			url:'../insertCart',// xxxx : controller method 주소 입력
			data:{
				product_seq:$('#seq').val(),
				product_title:$('#title').val(),
				product_count:$('#quantity').val(),
				price:$('#price').val(),
				total_price : $('#price').val() * $('#quantity').val() 
				
			},
		}).done(result => {
			
		});
	})
}



$(init);
</script>
<style>
#aaa {
	color: red;
}

#productName {
	font-size: 100px;
}

#productPrice {
	font-size: 80px;
}
</style>

<div class="container-fluid text-center">
	<div class="row content">
		<!-- include ad_gnb -->
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
		<div class="col-sm-2 text-left"></div>
		<div class="col-sm-10 text-left">

			<form method="POST" id="product_register_form" 	enctype="multipart/form-data" name="productDetail">

				<div class="mb-4 row">

					<div class="col-sm-5"
						style="display: flex; justify-content: center;">
						<input type="hidden" name="photo" value="${ detail.photo }">
						<img id="photo " name="photo" src="/images/${ detail.photo }">
					</div>
					<div class="col-sm-5"
						style="display: flex; justify-content: first;">
						<input type="hidden" name="seq" id="seq" value="${ detail.seq }">
						<%-- <p id="productName">${ detail.title }</p> --%>
								<input type='text' class='col-2' name='title' value='${ detail.title }'
							readonly='readonly' id='title' />
					</div>
				</div>
				<br>
				<div class="mb-3 row">
					<div class='col-sm-5'></div>
					<div class="col-sm-5"
						style="display: flex; justify-content: first;">
						<%-- <p id='productPrice'>${ detail.price }</p> --%>
						<input type='text' class='col-2' name='price' value='${ detail.price }'
							readonly='readonly' id='price' />
					</div>
				</div>
				<br>
				<div class='row mb-3'>
					<div class="col-sm-5"></div>
					<div class="col-sm-5"
						style="display: flex; justify-content: center;">
						<label for="quantity" class='col-sm-2 col-form-label'>수량</label>
						<button type='button' class='btn btn-outline-dark' id='minusBtn'>-</button>
						<input type='text' class='col-2' name='quantity' value='1'
							readonly='readonly' id='quantity' />
						<button type='button' class='btn btn-outline-dark' id='plusBtn'>+</button>

					</div>
				</div>
				<div class='row mb-3'
					style="display: flex; justify-content: center;">
					<button type='button' class='btn btn-secondary' id='cart'
						style="margin-right: 30px;">장바구니
						추가</button>
					<button type='button' class='btn btn-secondary' id='purchase'>구매</button>
				</div>

				<div class="mb-3 row">
					<div class="col-sm-5">
						<div class="form-floating">
							<textarea class="form-control" name="contents"
								style="height: 200px" readonly>${ detail.contents }</textarea>
							<label for="floatingTextarea2"></label>
						</div>
					</div>
				</div>
				<br>
				<div class="mb-3 row"></div>
				<br>
				<div class="mb-3 row">
					<br>
					<br>
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