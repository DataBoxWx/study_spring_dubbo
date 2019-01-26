<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="js/jquery-1.11.1-min.js"></script>
<script type="text/javascript">
  $(function(){
	$("button").click(function(){
		$.ajax({
			url:"user/myajax.do",
			type:"post",
			//dataType:"json",
			success:function(data){
				alert(data);
			}
		})
	})  
  })

</script>
<title>Insert title here</title>
</head>
<body>
  index.jsp <br>
  <br>
  <button>发起Ajax的请求</button>

</body>
</html>