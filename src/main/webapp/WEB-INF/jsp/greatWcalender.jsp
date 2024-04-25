<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.data.Kansei,dao.KanseiDAO,java.util.ArrayList" %>
<%
ArrayList<Kansei> dateLists = (ArrayList<Kansei>)request.getAttribute("date");
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
		<a href="/W_Project/greatWnew" style="text-decoration:none;">最新のW</a>　<a href="/W_Project/greatW" style="text-decoration:none;">人気のW</a>　日付検索W
		<br>
		</td></tr></table>
		<br>
		
		<%--日付入力のフォーム--%>
		<form action="/W_Project/calender" method="get">
			<input name="date" type="date" />
			<input type="submit" value="検索" />
			<br>
		</form>
		
		<%--dateListsのnullチェック--%>
		<% if(dateLists != null){ %>
				
				<%--投稿された内容を15件for文で出力--%>
				<% for(Kansei dateList : dateLists ){ %>
				<table align="center" border="1" bgcolor="#ffffdb" style="width:600px" style="height:500"><tr><td>
				<p style="font-size:20px; margin-top:30px"><%= dateList.getText() %></p>
				
						<%--  作成者・日付・いいねボタンをまとめているdivの開始タグ --%>
						<div style="display:flex; justify-content:space-between; width:500px; margin:0 auto; padding:10px">
						<p style="margin-left:20px; font-size:15px">
								<%= dateList.getCreateUser() %><br>
								<%= dateList.getAddDate() %>
						
						<div><%-- いいねをまとめているdivの開始タグ --%>
								<p style="margin:0">＼<%= dateList.getGood() %>いいね／</p>
								<form action="/W_Project/calender" method="post">
									<input type="hidden" name="wid" value=<%= dateList.getId() %>>
									<input type="image" name="submit" src="./image/B_iine.jpg" width="50" height="50" alt="いいね">
								</form>
						</div><%-- いいねをまとめているdivの終了タグ --%>
						</div><%-- 作成者・日付・いいねボタンをまとめているdivの終了タグ --%>
				</td></tr></table>
				<br>
				<% } %>
		
		<%--GreatWの別ページへのリンク--%>
		<table align="center" border="1" bgcolor="#ffffdb" style="width:500px" style="height:500px"><tr><td>
		<a href="/W_Project/greatWnew" style="text-decoration:none;">最新のW</a>　<a href="/W_Project/greatW" style="text-decoration:none;">人気のW</a>　日付検索W
		<br>
		</td></tr></table>
		<br>
		<% } else {%>
			<br>
			<table align="center" border="1" bgcolor="#ffffdb" style="width:500px" style="height:500px"><tr><td>
			<p>日付を選択して検索ボタンを押してね！</p>
			</td></tr></table>
		<% } %>
		<br>
		
		<%--TOPページへのリンク--%>
		<input type ="button" value ="TOP画面に戻る" style="background-color:#239dda;" onclick ="location.href = '/W_Project/return'"><br>
		<br>
		
		<%--BGM設定--%>
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