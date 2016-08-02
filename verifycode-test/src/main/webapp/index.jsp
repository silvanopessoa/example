<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<html>
<body>
	<script type="text/javascript" src="https://code.jquery.com/jquery-3.1.0.min.js"></script>
	<script type="text/javascript">
		$(function() { //生成验证码         
			$('#kaptchaImage').click(
					function() {
						$(this).hide().attr(
								'src',
								'/verifycode-test/kaptcha.jpg?'
										+ Math.floor(Math.random() * 100))
								.fadeIn();
					});
		});

		window.onbeforeunload = function() {
			//关闭窗口时自动退出  
			if (event.clientX > 360 && event.clientY < 0 || event.altKey) {
				alert(parent.document.location);
			}
		};

		function changeCode() { //刷新
			$('#kaptchaImage').hide().attr('src',
					'/verifycode-test/kaptcha.jpg?' + Math.floor(Math.random() * 100))
					.fadeIn();
			//event.cancelBubble = true;
		}
	</script>
	<form action="login/check" method="POST">
		<div class="form-group">
			<label>用户名 </label> <input name="username" type="text" /><br>
			<label>密&nbsp;&nbsp;  码 </label> <input name="password" type="password" /><br>
			<label>验证码 </label> <input name="j_code" type="text" id="kaptcha"
				maxlength="4" class="form-control" /> <br /> <img
				src="/verifycode-test/kaptcha.jpg" id="kaptchaImage"
				style="margin-bottom: -3px" /> <a href="#" onclick="changeCode()">看不清?换一张</a>
		</div>
		<br>
		<input type="submit" value="submit">
	</form>
</body>
</html>
