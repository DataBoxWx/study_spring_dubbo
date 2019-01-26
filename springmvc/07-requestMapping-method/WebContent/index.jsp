<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
  index.jsp <br>
  <a href="user/other.do">发起Get请求user/some.do</a>
  <br>
  <br>
  <form action="user/first.do" method="post">
  	<input type="submit" value="post请求other.do">
  </form>
</body>
</html>