<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		<p>整合SSM的例子</p>
		<img alt="没有图片显示" src="${pageContext.request.contextPath }/images/ssm.jpg">
		<table>
			<tr>
				<td><a href="${pageContext.request.contextPath }/jump/tojsp?target=addStudent" >点击完成注册</a></td>
				<td><a href="${pageContext.request.contextPath }/jump/tojsp?target=listStudent" >浏览学生</a></td>
			</tr>
		</table>
	
	</div>
</body>
</html>