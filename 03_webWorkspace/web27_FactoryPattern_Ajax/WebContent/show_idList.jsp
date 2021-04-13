<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script>
	function startRequest() { // 비동기 요청을 처리하는 로직
		xhr = new XMLHttpRequest();
		// ID CHOICE의 value는 ""이므로 없는 걸로 처리된다.
		var id = document.getElementById("memberId").value;
		
		xhr.onreadystatechange = callback;
		xhr.open("post", "find.do");

		xhr.setRequestHeader("Content-Type", 
				"application/x-www-form-urlencoded;charset=utf-8");
		xhr.send("id=" + id);
	}
	function callback() { // 비동기 응답을 처리하는 로직
		if (xhr.readyState == 4 && xhr.status == 200) {
			document.getElementById("resultView").innerHTML = 
				"<font color='green' size=3>" + xhr.responseText + "</font>";
		}
	}
</script>

</head>
<body>
	<h2 align="center">ID LIST...</h2>
	<h3 align="center"></h3>
	<p></p>
	<select id="memberId" onchange="startRequest()">
		<option value="">=====ID CHOICE=====</option>
		<c:forEach items="${list}" var="memId">
			<option value="${memId}">${memId}</option>
		</c:forEach>
	</select>

	<span id="resultView"></span>
</body>
</html>