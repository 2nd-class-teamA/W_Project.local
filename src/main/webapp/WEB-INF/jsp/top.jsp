<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%-- トップ画面のJSP --%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>W</title>
</head>
<body style="background-color: #ffd900;">
	<div style="text-align: center;">
		<img src="./image/aikon.PNG" width="" height="" alt="W"> <br>
		<br> <input type="button" value="Wをはじめる"
			style="background-color: #239dda; width: 10%;" class="button"
			onclick="location.href = '/W_Project/start'"><br> <br>
		<input type="button" value="みんなのW"
			style="background-color: #239dda; width: 10%"
			onclick="location.href = '/W_Project/greatWnew'"><br> <br>
		<strong>◇ルール説明◇</strong>
		<table align="center" border="1" style="width: 550px"
			style="height:500">
			<tr>
				<td>
					<div style="text-align: left;">
						①Wをはじめるボタンを押してまずは人数を選択してね！<br>
						②『いつ』『どこで』『だれが』『なにをした』のお題に合わせて入力！<br> ③完成したW(文章)をみんなで楽しもう！<br>
					</div>
				</td>
			</tr>
		</table>
		<br> ※このアプリは音が出ます。端末で音量設定をしてください<br>
		<audio id="audio" src=".\BGM\top.mp3" preload="auto" loop></audio>
		<script>
			window.onload = function() {
				setTimeout(function() {
					var audio = document.getElementById("audio");
					audio.play();
				}, 10000);
			};
		</script>
	</div>
</body>
</html>