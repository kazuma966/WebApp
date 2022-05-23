<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="shop.ShohinBean" import="java.util.ArrayList"%>
<!DOCTYPE html >
<html>
<head>
<meta charset="UTF-8">
<title>商品検索結果</title>
</head>
<body>
 <form action="ShohinQueryServlet" method ="GET">
<jsp:useBean id="shnArrayBean" class="shop.ShohinArrayBean" scope="session" />
<h1>商品検索結果</h1>
<p>検索方法</p>
<input type="radio" name="item" value="name" checked>商品名
<input type="radio" name="item" value="value">価格

<p>キーワード:(商品名の一部、価格を入力してください)</p>
<input type="text" name="keyword" size="30" value="">

<p>
<input type="submit" value="送信する">
<input type="reset" value="リセット">
</p>
</form>
	<table border="1">
<tr><th>商品画像</th><th>商品名</th><th>容量</th><th>販売価格</th><th>商品説明</th></tr>

<%
ArrayList<ShohinBean> ShohinHistoryArray = shnArrayBean.getShohinHistoryArray();
for(ShohinBean shb : ShohinHistoryArray) {

%>
 
<tr>
	<td><img src="img/<%= shb.getImage() %>"></td>
	<td><%= shb.getName() %></td>
	<td><%= shb.getVol() %></td>
	<td><%= shb.getPrice() %></td>
	<td><%= shb.getComment() %></td>
	<td><form action="ShohinDetailServlet" method ="GET">
			<input type="hidden" name="code" value="<%= shb.getCode()%>">
			<input type="submit" value="詳細"/>
		</form>
	</td>
</tr>
<%
}
%>
</table>

</body>
</html>