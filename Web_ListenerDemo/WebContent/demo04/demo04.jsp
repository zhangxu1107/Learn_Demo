<%@page import="cn.zx.bean.Bean02"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

这是demo04页面

<%
	Bean02 bean = new Bean02();
	bean.setName("lisisi");
	
	session.setAttribute("bean", bean);
%>
</body>
</html>