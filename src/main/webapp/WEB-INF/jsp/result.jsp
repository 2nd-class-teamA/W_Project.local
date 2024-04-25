<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%-- ⑥終り画面のJSP --%>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>W</title>
</head>
<body style="background-color: #ffd900;">
	<div style="text-align: center">
		<img src="./image/result.PNG" width="" height="" alt="W">
		<table align="center" border="1" bgcolor="#ffffdb"
			style="width: 500px" style="height:500">
			<tr>
				<td><br> ${ room.getText(0) },<br> ${ room.getText(1) }で<br>
					${ room.getText(2) }が<br> ${ room.getText(3) }<br> <br>
					<div style="text-align: right; margin-right: 10px;">
						<font size="2">${ room.getTrimmedCreaterNames() }</font>
					</div></td>
			</tr>
		</table>
		<br> <input type="button" value="もう１回遊ぶ"
			style="background-color: #239dda; width: 10%;" class="button"
			onclick="location.href = '/W_Project/start'"> <br>
		<br> <input type="button" value="終わる"
			style="background-color: #239dda; width: 10%;" class="button"
			onclick="location.href = '/W_Project/return'"> <br>
		<br> <input type="button" value="みんなのWをみる"
			style="background-color: #239dda; width: 150px;" class="button"
			onclick="location.href = '/W_Project/greatWnew'"> <br>
		<br>
		<audio loop autoplay="autoplay" src=".\BGM\result1.mp3"></audio>
		<audio loop autoplay="autoplay" src=".\BGM\result2.mp3"></audio>
		<audio id="audio1" src=".\BGM\waa1.mp3" preload="auto"></audio>
		<script>
			window.onload = function() {
				setTimeout(function() {
					var audio = document.getElementById("audio1");
					audio.play();
				}, 2000);
			};
		</script>
		<audio id="audio2" src=".\BGM\waa2.mp3" preload="auto"></audio>
		<script>
			window.onload = function() {
				setTimeout(function() {
					var audio = document.getElementById("audio2");
					audio.play();
				}, 1000);
			};
		</script>
	</div>
</body>
</html>