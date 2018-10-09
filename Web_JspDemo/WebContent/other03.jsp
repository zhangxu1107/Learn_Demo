<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jsp作用域</title>
</head>
<body>
	<h2>这是other03的页面</h2>
	<h3><br>使用作用域来存储数据</h3>
	<br>

	<%
		pageContext.setAttribute("name", "page");
		request.setAttribute("name", "request");
		session.setAttribute("name", "session");
		application.setAttribute("name", "application");
	%>
	<h3>取出四个作用域中的值</h3>
	<br>

	<%=pageContext.getAttribute("name")%>
	<%=request.getAttribute("name")%>
	<%=session.getAttribute("name")%>
	<%=application.getAttribute("name")%>

	<!-- //跳转到下一个界面去了 -->
	<%
		//请求转发. 一次请求
		//request.getRequestDispatcher("other04.jsp").forward(request, response);

		//重定向 2次请求
		response.sendRedirect("other04.jsp");
	%>
</body>
</html>