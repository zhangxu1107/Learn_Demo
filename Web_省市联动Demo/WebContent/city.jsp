<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>省市联动</title>
<script type="text/javascript" src="js/jquery-1.11.3.min.js"></script>
<script type="text/javascript" src="js/city.js"></script>

<!-- 引用的是 xml的处理方法  -->
</head>
<body>
	省份:
	<select name="province" id="province">
		<option value="">-请选择 -
		<option value="1">广东
		<option value="2">湖南
		<option value="3">湖北
		<option value="4">四川
		<option value="5">重庆
	</select> 城市:
	<select name="city" id="city">
		<option value="">-请选择 -
	</select>
</body>
</html>