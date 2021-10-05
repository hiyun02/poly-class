<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="/mail/sendMail.do" method="post">
<table border="5" width="300" height="80">
<tr>
<th>받는사람</th>
<td><input type="text" name="toMail"  ></td>
</tr>

<tr>
<th>메일제목</th>
<td><input type="text" name="title"></td>
</tr>

<tr>
<th>메일내용</th>
<td><input type="text" name="contents"></td></tr>
</table>
<div>
<button type="submit">[메일 전송]</button>
<button type="reset">[내용 초기화]</button>
</div>
</form>
</body>
</html>