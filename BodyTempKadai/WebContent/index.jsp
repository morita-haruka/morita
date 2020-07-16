<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>体温記録アプリ</title>
<link rel="stylesheet" href="index.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Open+Sans:400,700">
</head>
<body>


<div class="form-wrapper">
  <h1>ログイン</h1>
  <form action="/BodyTempKadai/LoginServlet" method="get">
    <div class="form-item">
      <input type="email" name="mail" required="required" placeholder="メールアドレス"></input>
    </div>
    <div class="form-item">
      <input type="password" name="pass" required="required" placeholder="パスワード"></input>
    </div>
    <span class="label label-danger" style="color:#ff0000;">${message}</span>
    <div class="button1">
      <input type="submit" class="button" title="ログイン" value="ログイン"></input>
    </div>
  </form>
  <div class="form-footer">
    <p><a href="RegistrationUser.jsp">新規登録</a></p>
  </div>
</div>
</body>
</html>