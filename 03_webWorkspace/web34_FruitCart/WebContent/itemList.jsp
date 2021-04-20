<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1 align="center">Fruit Total List 1.</h1>
	<table align="center" border="2">
		<tr>
			<c:forEach items="${list}" var="item">
				<td>
					<a href="itemView.do?itemid=${item.itemNumber}"><img alt="" src="${item.url}" widht="150" height="150"></a><br>
					상품명 : ${item.name}<br>
					상품가격 : ${item.price}
				</td>
			</c:forEach>
		</tr>
	</table>
</body>
</html>