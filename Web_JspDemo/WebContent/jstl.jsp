<%@page import="cn.zx.domain.User"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSTL</title>
</head>
<body>


<!-- 声明一个对象name， 对象的值 zhangsan , 存储到了page（默认） ， 指定是session -->
<c:set var="name" value="zhangsan" scope="session"></c:set>

${sessionScope.name }


<br>----------------------<br>
<c:set var="age" value="18" ></c:set>

<c:if test="${ age > 26 }" var="flag" scope="session">
	年龄大于了26岁...
</c:if>

<c:if test="${ age <= 26 }">
	年龄小于了26岁...
</c:if>

${flag }

<br>----------------------<br>

从1 开始遍历到10 ，得到的结果 ，赋值给 i ,并且会存储到page域中， step=2 , 增幅为2， 
<c:forEach begin="1" end="10" var="i" step="2">
	${i }
</c:forEach>

<br>----------------------<br>
<%

	List list =new ArrayList();

	list.add(new User("zhangsan",18));
	list.add(new User("lisi",28));
	list.add(new User("wagnwu",38));
	list.add(new User("maliu",48));
	list.add(new User("qianqi",58));
	
	pageContext.setAttribute("list", list);
%>

<!-- items : 表示遍历哪一个对象，注意，这里必须写EL表达式。 
var: 遍历出来的每一个元素用user 去接收。 -->
<c:forEach var="user" items="${list }">
	${user.name } ----${user.age }
</c:forEach>
	

</body>
</html>