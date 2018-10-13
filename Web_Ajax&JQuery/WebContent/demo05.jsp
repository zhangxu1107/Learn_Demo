<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<script type="text/javascript" src="js/jquery-1.11.3.min.js"></script>
<script type="text/javascript">
//$.get(URL,callback);
	function get() {
		$.get("/Web_Ajax&JQuery/DemoServlet02"  , function(data ,status){
			alert("结果是："+data);
			
			//$("#div01")  -- document.getElementById("div01");
			
			//$("#div01").val(); //val  用于设置 元素里面有values 的属性值 
			//$("#div01").html(data);
			//$("#div01").val(data);
			$("#div01").text("aaa="+data);
			//$("#div01").html(data); // <font>
			
		});
	}

</script>

<title>JQuery_GET</title>
</head>
<body>

	<input type="button" onclick="get()" value="使用JQuery演示 get方法">
	
	 <div id="div01"  style="width: 100px ; height: 100px ; border: 1px solid blue; ">
	 
	 </div>
</body>
</html>