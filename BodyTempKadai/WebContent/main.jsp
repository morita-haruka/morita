<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="java.util.ArrayList"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="ress.css">
<link rel="stylesheet" href="main.css">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/chartist.js/latest/chartist.min.css" />
<script src="https://cdn.jsdelivr.net/chartist.js/latest/chartist.min.js"></script>
<title>Insert title here</title>
</head>
<body>
<div class="container">
	<header class="header">
        <h1 class="p1">体温管理アプリ</h1>
        <div class="h33">
        <h3>ユーザーメニュー</h3>
        <a href="RegistrationBodyTemp.jsp" class="btn-square">体温登録へ</a>
        <form action="/BodyTempKadai/LogoutServlet" method="post">
        <input type="submit" class="btn-square" value="ユーザーの変更">
        </form>
        <a href="https://hazard.yahoo.co.jp/article/20200207" class="btn-square">ニュースを表示</a>
        <form id="submit_form" action="/BodyTempKadai/ChoiceServlet" method="get">
			<select class="btn-square" name="month" onChange="submit(this.form)">
			<option value="" hidden>月選択</option>
			<option value="2020-01">1月</option>
			<option value="2020-02">2月</option>
			<option value="2020-03">3月</option>
			<option value="2020-04">4月</option>
			<option value="2020-05">5月</option>
			<option value="2020-06">6月</option>
			<option value="2020-07">7月</option>
			<option value="2020-08">8月</option>
			<option value="2020-09">9月</option>
			<option value="2020-10">10月</option>
			<option value="2020-11">11月</option>
			<option value="2020-12">12月</option>
			</select>
		</form>
		</div>
    </header>


<main>
	<div class="content">
	<c:forEach var="templist" items="${resultlist}">
	<c:set var="datemonth" value="${templist.date}" />
	</c:forEach>
	<h1><c:out value="${fn:substring(datemonth,5,7)}" />月の体温データグラフ</h1>
	<div class="ct-chart ct-perfect-fourth" style="height: 480px"></div>
	<script>
		var bodytemp = [];
		var date = [];
		var sum = 0;
		var i=0;
	</script>


	<c:forEach var="templist" items="${resultlist}">
    <c:set var="date1" value="${templist.date}" />
	<script>
	bodytemp.push('${templist.bodyTemp}');
	date.push("${fn:substring(date1,8,10)}");
	sum += parseFloat("${templist.bodyTemp}");
	i += 1;
	console.log(sum);
	</script>
	</c:forEach>

	<script>
	var avg=0;
	var avgresult;
	avg =  sum/i;
	avgresult = avg.toFixed(2);
	document.write("<p>");
	document.write("平均体温 : " + avgresult + "℃");
	document.write("</p>");

	</script>
	<script>
	new Chartist.Line('.ct-chart',
			{labels: date,series: [bodytemp]}
			, {low: 35.0,showArea: true});
	</script>
	<c:forEach var="templist" items="${resultlist}">
	<c:set var="datemonth" value="${templist.date}" />
	</c:forEach>
	<h1><c:out value="${fn:substring(datemonth,5,7)}" />月の体温データ一覧</h1>

	<table>
	<tr>
     <td>日付</td>
      <td>体温</td>
      <td>症状</td>
      <td>場所</td>
      <td>メモ</td>
    </tr>
  		<c:forEach var="templist" items="${resultlist}" >
    		<tr>
      			<td><c:out value="${templist.date}" /></td>
      			<td><c:out value="${templist.bodyTemp}" /></td>
      			<td><c:out value="${templist.symptom}" /></td>
      			<td><c:out value="${templist.place}" /></td>
      			<td><c:out value="${templist.memo}" /></td>
    		</tr>
  		</c:forEach>
	</table>
	</div>
</main>

</div>
</body>
</html>