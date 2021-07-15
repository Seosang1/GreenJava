<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ include file="/WEB-INF/views/jsp/main/header.jsp" %>
<style>
#cart-container{
        margin: 0px;
        padding: 0px;
        box-sizing: border-box;
    }
    #cart-container{
        width: 1024px;
        margin: 0 auto;
        text-align: center;
    }
    #cart-table{
        width: 100%;
    }
    #purchase{
    	float: right;
    }
</style>


<div id="cart-container" style="margin-top : 50px; margin-bottom : 50px;">
    <table id="cart-table">
        <tr style="background-color: whitesmoke">
            <th><input type="checkbox" id="chkAll"> 전체선택</th>
            <th>상품정보</th>
            <th>상품금액</th>
            <th>배송비</th>
        </tr>
        
        <c:forEach var="list" items="${basckets}">
        <tr>
            <td><input type="checkbox" id="product_seq" name="product_seq"></td>
            <td>
                <div>
                    <p>${list.product_title}</p>
                    <span>수량 : <b>${list.product_count}</b></span><span> 가격 : <b><fmt:formatNumber value="${list.price}" pattern="#,###"/>&nbsp;원</b></span>
                </div>
            </td>
            <td><fmt:formatNumber value="${list.total_price}" pattern="#,###"/>&nbsp;원</td>
            <td><fmt:formatNumber value="${list.shopping_price}" pattern="#,###"/>&nbsp;원</td>
        </tr>
        </c:forEach>
    </table>
    <button id="purchase">구매</button>
   </div>
   
   
    <script  src="http://code.jquery.com/jquery-latest.min.js"></script>
    <script>
        $(document).ready(function(){
            $("#chkAll").click(function(){
                if($("#chkAll").prop("checked")){
                    $("input[name=product_seq]").prop("checked",true);
                }else{
                    $("input[name=product_seq]").prop("checked",false);
                }
            });
            
            $("input[name=product_seq]").click(function(){
                if($("#chkAll").prop("checked")){
                    $("#chkAll").prop("checked",false);
                }
            });
            
        });
    </script>

<%@ include file="/WEB-INF/views/jsp/main/footer.jsp" %>