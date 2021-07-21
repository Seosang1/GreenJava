<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<%@ include file="/WEB-INF/views/jsp/main/header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	#button{
		color:gray;
	}


</style>

</head>
<body>
	<div class="container text mt-5 ms-5">
			<button class="btn btn-outline-success btn-lg" style="color: gray;"
			onclick="location.href='productList.do' ">목록</button>
	</div>
	<div class="container mt-5 text-center">
		<div class="row">
			<div class="col">
				<div class="card">

					<div class="card-body">
						<p class="card-text">

							<img src="resources/${dto.title_photo}"
								class="rounded float-start mt-4 ms-5"
								style="width: 550px; height: 400px; object-fit: cover;">
						<div class="mt-5">
							<h1 class="display-5">${dto.title }</h1>
							<div class="">상품가격:${dto.price }</div>
							<textarea class="mt-3" rows="5" cols="30" readonly="readonly"
								style="border: none; text-align: center; resize: none; outline: none;">${dto.contents } </textarea>
							<br>
						</div>

						<div class="container dropdown ms-5" id="button">

							<select id="color"
								class="form-control  btn btn-outline-success btn-lg text-center"
								style="width: 150px; height:50px; text-align-last: center; vertical-align: middle;"
								name="컬러선택">
								<option value="0">&nbsp;&nbsp;color</option>
								<option value="1">&nbsp;&nbsp;red</option>
								<option value="2">&nbsp;&nbsp;blue</option>
								<option value="3">&nbsp;&nbsp;white</option>
								<option value="4">&nbsp;&nbsp;black</option>
							</select>
							&nbsp;
								<select id="color"
									class="form-control  btn btn-outline-success btn-lg text-center"
									style="width: 150px; height:50px; center; vertical-align: middle;"
									name="수량선택">
									<option value="0">&nbsp;&nbsp;수량</option>
									<option value="1">&nbsp;&nbsp;1</option>
									<option value="2">&nbsp;&nbsp;2</option>
									<option value="3">&nbsp;&nbsp;3</option>
									<option value="4">&nbsp;&nbsp;4</option>
									<option value="4">&nbsp;&nbsp;5</option>
								</select>
							</div>
							<br><br>
							<div class="container text mt-5 ms-5"  >
								<button class="btn btn-outline-success btn-lg" style="color: gray; width: 150px;"
									onclick="location.href='like.do' ">좋아요</button>&nbsp;&nbsp;
								<button class="btn btn-outline-success btn-lg" style="color: gray; width: 150px;"
									onclick="location.href='share.do' ">공유하기</button>&nbsp;&nbsp;
								<button class="btn btn-outline-success btn-lg" style="color: gray; width: 150px;"
									onclick="location.href='shoppingBasket.do' ">장바구니</button>&nbsp;&nbsp;
								<button class="btn btn-outline-success btn-lg" style="color: gray; width: 150px;"
									onclick="location.href='pay.do' ">구매하기</button>

							</div>



							<!-- 	<a href="like.do" class="btn btn-outline-success btn-lg mt-4 " style="width:200px" id="like_btn">좋아요</a>
					<a href="share.do" class="btn btn-outline-success btn-lg mt-4 " style="width:200px" id="share_btn">공유하기</a>
					<a href="basketList.do" class="btn btn-outline-success btn-lg mt-4 " style="width:200px" id="addCart_btn">장바구니</a>
					<a href="buy.do" class="btn btn-outline-success btn-lg mt-4 " style="width:200px" id="buy_btn">구매하기</a>
				 -->
							<br> <br>
						</div>
						<div class="text-center" id="detail">
							<hr>
							<h2 class="display-4 mt-3">상세보기</h2>

							<img class="mt-5" src="resources/${dto.title_photo}"
								style="width: 1000px; height: 700px;"> <br> <br>
							<br> <br>

							<div class="container text-center fs-1">
								<span> 상품 이름: ${dto.title } </span> <br> 
								<span> 상품 가격: ${dto.price }</span> <br> 
								<span> 상품 설명:${dto.contents}</span> 
									<br> <br> <br> <br> <br>

							</div>

							<div id="review">
								<hr>
								<h1 class="display-3 mt-3">리뷰보기</h1>
							</div>
							<div>
								<table class="table text-center table-hover">
									<thead class="table-white">
										<tr>
											<th style="width: 20%;">작성자</th>
											<th style="width: 60%;">후기내용</th>
											<th style="width: 20%;">날짜</th>
										</tr>
									</thead>
									<tbody>
										<c:choose>
											<c:when test="${empty review}">

												<td colspan="3">작성된 리뷰가 없습니다.</td>


											</c:when>



											<c:otherwise>
												<c:forEach items="${reply}" var="review">
													<tr>
														<td>${greview.gRewWriter}</td>
														<td>${greview.gRewContent}</td>
														<td><fmt:formatDate value="${greview.gRewDate}"
																pattern="yy.MM.dd HH:mm:ss" /></td>
													</tr>
												</c:forEach>
											</c:otherwise>
										</c:choose>
									</tbody>
								</table>

							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>



</body>
</html>