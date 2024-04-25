<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%--⑤結果アニメーション画面のJSP --%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%-- メタリフレッシュ　7秒後にW_ProjectのfinServletにリダイレクト --%>
<meta http-equiv="refresh" content="7; URL=/W_Project/fin">
<%-- css読み込み(textAnimation.css) --%>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/textAnimation.css">
<title>W</title>
</head>

<body>
	<div class="textbox">
		<%-- 文表示枠 --%>
		<p class="itsu">${ room.getText(0) },</p>
		<%-- roomのtextを持ってきて表示（ 0 = いつの情報 ） --%>
		<p class="doko">${ room.getText(1) }で</p>
		<%-- roomのtextを持ってきて表示（ 1 = どこでの情報 ） --%>
		<p class="dare">${ room.getText(2) }が</p>
		<%-- roomのtextを持ってきて表示（ 2 = 誰がの情報 ） --%>
		<p class="nani">${ room.getText(3) }</p>
		<%-- roomのtextを持ってきて表示（ 3 = 何をしたの情報 ） --%>
	</div>
	<%-- 文表示枠終了 --%>
</body>
</html>