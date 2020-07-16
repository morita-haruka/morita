<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>体温登録</title>
<link rel="stylesheet" href="RegistBodyTemp.css">
</head>
<body>
<div class="form-wrapper">
	<h1>体温登録画面</h1><br/>
	<form action="/BodyTempKadai/RegistBodyTempServlet" method="post">
	<div class="form-item">
		<input type="text" name="bodytemp" placeholder="体温"/><br/>
	</div>
	<span class="label label-danger" style="color:#ff0000;">${tempmessage}</span>
	<div class="form-item">
		<input type="text" name="symptom" placeholder="症状"/><br/>
	</div>
	<span class="label label-danger" style="color:#ff0000;">${symptommessage}</span>
	<div class="form-item">
		<input type="text" name="place" placeholder="出かけた場所"/><br/>
	</div>
	<span class="label label-danger" style="color:#ff0000;">${placemessage}</span>
	<div class="form-item">
		<input type="text" name="memo" placeholder="メモ"/><br/>
	</div>
	<span class="label label-danger" style="color:#ff0000;">${memomessage}</span>
	<span class="label label-danger" style="color:#ff0000;">${message}</span>
	<div class="button1">
		<input type="submit" class="button" title="登録" value="登録">
	</div>
	</form>
	<form action="/BodyTempKadai/mainRetrunServlet" method="get">
	<div class="button1">
		<input type="submit" class="button" title="メイン画面へ戻る" value="メイン画面へ戻る">
	</div>
	</form>
	<div class="form-footer">
    	<p></p>
	</div>
</div>
</body>
</html>