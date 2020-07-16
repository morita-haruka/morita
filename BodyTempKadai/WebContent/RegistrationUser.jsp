<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="RegistUser.css">
</head>
<body>
<div class="form-wrapper">
	<h1>ユーザー登録</h1><br/>
	<form action="/BodyTempKadai/RegistrationServlet" method="post">
		<div class="form-item">
			<input type="text" name="name" placeholder="氏名"/><br/>
		</div>
		<span class="label label-danger" style="color:#ff0000;">${namemessage}</span>
		<div class="form-item">
			<input type="text" name="mail" placeholder="メールアドレス"/><br/>
		</div>
		<span class="label label-danger" style="color:#ff0000;">${mailmessage}</span>
		<div class="form-item">
			<input type="password" name="pass" placeholder="パスワード"/><br/>
		</div>
		<span class="label label-danger" style="color:#ff0000;">${passmessage}</span>
		<div class="button1">
			<input type="submit" class="button" title="登録"  value="登録">
		</div>
	</form>
	<div class="form-footer">
    	<p><a href="index.jsp">ログインへ</a></p>
	</div>
</div>
</body>
</html>