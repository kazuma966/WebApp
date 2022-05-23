<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="shop.CartBean" import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>カート内容</title>
</head>
<body>
<jsp:useBean id="cartArrayBean" class="shop.CartArrayBean" scope="session" />
<h1>カート内容</h1>

<table border="1">
<tr><th>商品名</th><th>容量</th><th>販売価格</th><th>数量</th><th>金額</th><th>取消</th></tr>

<%
ArrayList<CartBean> cartArray = cartArrayBean.getcartArray();
for(CartBean crb : cartArray) {
	
%>

<tr>
	<td><%= crb.getName() %></td>
	<td><%= crb.getVol()%></td>
	<td><%= crb.getPrice() %></td>
	<td><%= crb.getQuantity() %></td>
	<td><%= crb.getSumPrice() %></td>
	<td><form action="DeleteCartServlet" method = "POST">
			<input type="hidden" name="code" value="<%= crb.getCode()%>"/> 
			<input type="submit" value="取消"/>
		</form>
	</td>
</tr>
<%
}
%>

</table><br>
総合計:<%=cartArrayBean.getTotalPrice()  %><br>

<br><input type="button" value="戻る" onClick='history.back();' />

</body>
</html>