<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- ③お題入力画面のJSP --%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>W</title>
<script>
var dblClickFlag = null;

function ThroughDblClick() {
    console.log(dblClickFlag == null);
    // ダブルクリック（連続ポスト）の制御
    if (dblClickFlag == null) {
        dblClickFlag = 1;
        return true;
    } else {
        return false;
    }
}
</script>
</head>
<body style="background-color:#ffd900;">
<div style="text-align:center;">

<h2>▼あなたのお題は『どこ』だよ</h2><br>
<br>
<form action = "maininput" method = "post" onSubmit="return ThroughDblClick();">
<img src="./image/nyuryoku.PNG" width="" height="" alt="W"><br>
ここに入力してね！<br>
<input type="hidden" name="id" value=${ id }>
<input type = "text" name = "text" maxlength="30" required>で
<br>
<br>
▼完成したWに名前を入れたいときは名前を入力してね！(5文字)<br>
<input type = "text" name = "name" width="100px" maxlength="5"><br>
<font size="2">※入力がない場合は名無しさんになります</font><br>
<br>
<input type ="submit" class = "button" value = "完了" style="background-color:#239dda;">
</form>
		<audio loop autoplay="autoplay" src=".\BGM\countdown1.mp3"></audio>
</div>
</body>
</html>