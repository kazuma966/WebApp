<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="shop.ShohinBean" import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>商品詳細</title>
</head>
<body>
<jsp:useBean id="shohinBean" class="shop.ShohinArrayBean" scope="session" />
<h1>商品詳細</h1>

<table class = "table" border="1">
<%
ArrayList<ShohinBean> ShohinHistoryArray = shohinBean.getShohinHistoryArray();
for(ShohinBean shb : ShohinHistoryArray) {

%>


	<tr><td class = "cell_title" colspan = "2"><%= shb.getName() %></td></tr>
	<tr><td class = "cell_imagen" rowspan = "4" ><img src="img/<%= shb.getImage() %>"></td>
	<td class = "cell_info"><%= shb.getVol() %></td></tr>
	<tr><td class = "cell_info">価格:<%= shb.getPrice() %></td></tr>
	<tr><td class = "cell_info">配達可能地域:<%= shb.getArea() %></td></tr>
<tr>
<td class = "cell_info">
<form action="AddCartServlet" method="POST">
	<input type = "hidden" name= "code" value = "<%= shb.getCode() %>" />
	<select name="quantity">
				<option value="1" selected>1</option>
				<option value="2">2</option>
				<option value="3">3</option>
				<option value="4">4</option>
				<option value="5">5</option>
				<option value="6">6</option>
				<option value="7">7</option>
				<option value="8">8</option>
				<option value="9">9</option>
		</select>
		<input type="submit" value="カートに追加する"></form></td></tr>

	<tr><td class = "cell_comment" colspan = "2"><%= shb.getComment() %></td></tr>



<%
}
%>

</table>

<input type="button" value="戻る" onClick='history.back();' />

</body>
<style>
table {width: 600px}
th {padding: 3px; height: 50px}
td {padding: 3px; height: 50px}
.cell_title {font-size: 150%}
.cell_image {width: 70%}
.cell_info {width: 30%}
.cell_comment {font-size: 120%}
</style>
</html>