<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<script type="text/javascript" src="js/jquery-1.11.3.min.js"></script>

<script type="text/javascript">

	function post() {
		$.post("/Web_Ajax&JQuery/DemoServlet03", {name:"zhangsan",age:18},function(data,status) {
			//想要放数据到div里面去。 --- 找到div
			$("#div01").html(data);
		});
	}
</script>

<title>JQuery_post</title>
</head>
<body>

	<input type="button" onclick="post()" value="使用JQuery演示 post方法">
	
	 <div id="div01"  style="width: 100px ; height: 100px ; border: 1px solid blue; ">
	 
	 </div>
</body>
</html>