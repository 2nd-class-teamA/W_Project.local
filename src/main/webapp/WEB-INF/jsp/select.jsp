<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%-- ②人数選択画面のJSP --%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/css/style.css">
<title>W</title>
<style>
body {
	text-align: center;
}
</style>
</head>
<body style="background-color: #ffd900;">
	<h2>▼遊ぶ人数をえらんでね！！</h2>
	<br>
	<a href="/W_Project/maininput?pcount=1"> <img
		src="./image/B_hitori.jpg" width="189" height="96" alt="1人で遊ぶ"></a>
	<a href="/W_Project/maininput?pcount=2"> <img
		src="./image/B_hutari.jpg" width="189" height="96" alt="2人で遊ぶ"></a>
	<br>
	<br>
	<a href="/W_Project/maininput?pcount=3"> <img
		src="./image/B_sannin.jpg" width="189" height="96" alt="3人で遊ぶ"></a>
	<a href="/W_Project/maininput?pcount=4"> <img
		src="./image/B_yonin.jpg" width="189" height="96" alt="4人で遊ぶ"></a>
	<br>
	<br>
	<p>
		<font size="2">2人以上で遊ぶ場合は入力が完了したら次の人にバトンタッチしてね！</font>
	</p>
	<input type="button" value="TOP画面に戻る"
		style="background-color: #239dda;"
		onclick="location.href = '/W_Project/return'">
	<br>
	<br>
</body>
</html>