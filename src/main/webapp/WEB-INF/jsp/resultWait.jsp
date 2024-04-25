<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%-- ④結果出力待ち画面のJSP --%>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="refresh" content="5; URL=/W_Project/mainOutput">
<title>W</title>
</head>

<body style="background-color: #ffd900;">
	<div style="text-align: center;">
		<h2>W作成中</h2>
		＼ちょっと待ってね／<br> <img src="./image/mazemaze.GIF" width="" height=""
			alt="W"><br>
		<%--BGM設定--%>
		<audio autoplay="autoplay" src=".\BGM\wait1.mp3" loop></audio>
		<audio autoplay="autoplay" src=".\BGM\wait2.mp3" loop></audio>
		<audio autoplay="autoplay" src=".\BGM\wait3.mp3" loop></audio>
	</div>
</body>

</html>