<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.data.Kansei,dao.KanseiDAO,java.util.ArrayList" %>
<%
ArrayList<Kansei> latestLists = (ArrayList<Kansei>)request.getAttribute("latest");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>W</title>
</head>
	<body style="background-image:url(./image/haikei1.PNG);background-repeat:repeat; background-position:center;">
		<div style="text-align:center;">
		
		<%--GreatWの別ページへのリンク--%>
		<table align="center" border="1" bgcolor="#ffffdb" style="width:500px" style="height:500px"><tr><td>
			<strong><font size="4">みんなのW</font></strong>
			<br>
			最新のW　<a href="/W_Project/greatW" style="text-decoration:none;">人気のW</a>　<a href="/W_Project/calender" style="text-decoration:none;">日付検索W</a>
			<br></td></tr>
		</table><br>
		
		<%--投稿された内容を15件for文で出力--%>
		<% for(Kansei latestList : latestLists ){ %>
			<table align="center" border="1" bgcolor="#ffffdb" style="width:600px" style="height:500"><tr><td>
				<p style="font-size:20px; margin-top:30px"><%= latestList.getText() %></p>
				<%--  作成者・日付・いいねボタンをまとめているdivの開始タグ --%>
				<div style="display:flex; justify-content:space-between; width:500px; margin:0 auto; padding:10px">
				<p style="margin-left:20px; font-size:15px">
				<%= latestList.getCreateUser() %><br>
				<%= latestList.getAddDate() %>
				<div><%-- いいねをまとめているdivの開始タグ --%>
				<p style="margin:0">＼<%= latestList.getGood() %>いいね／</p>
				<form action="/W_Project/greatWnew" method="post">
					<input type="hidden" name="wid" value=<%= latestList.getId() %>>
					<input type="image" name="submit" src="./image/B_iine.jpg" width="50" height="50" alt="いいね">
				</form>
				</div><%-- いいねをまとめているdivの終了タグ --%>
				</div><%-- 作成者・日付・いいねボタンをまとめているdivの終了タグ --%>
			</td></tr></table>
			<br>
		<% } %>
		
		<table align="center" border="1" bgcolor="#ffffdb" style="width:500px" style="height:500px"><tr><td>
			最新のW　<a href="/W_Project/greatW" style="text-decoration:none;">人気のW</a>　<a href="/W_Project/calender" style="text-decoration:none;">日付検索W</a>
			<br></td></tr>
		</table>
		<br>
		<input type ="button" value ="TOP画面に戻る" style="background-color:#239dda;" onclick ="location.href = '/W_Project/return'"><br>
		<br>
			<audio id="Waudio"src=".\BGM\greatW.mp3" preload="auto" loop></audio>
			<script>
				window.onload = function(){
					setTimeout(function(){
						var audio = document.getElementById("Waudio");
						audio.play();
					},2000);
				};
			</script>
		</div>
		</body>
</html>