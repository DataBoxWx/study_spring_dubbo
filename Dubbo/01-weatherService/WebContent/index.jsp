<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery-1.11.1-min.js"></script>
<script type="text/javascript">
  $(function(){
	  $("button").click(function(){
		  $.ajax({
			  url:"qwservlet",
			  data:{
				  "cityCode":"101010100"
			  },
			  type:"post",
			  success:function(data){
				  alert(data)
			  }
		  })
	  })
  })

</script>
</head>
<body>
  index.jsp <br>
  <button>发起请求获取天气的信息</button>
</body>
</html>