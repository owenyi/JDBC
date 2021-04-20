<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style>
	#count { background-color: gray; }
	#image { float: left; margin-left: 32%; }
	#info {float: right; width: 350px; height: 300px; margin-right: 32%; padding-top: 50px; }
</style>

</head>
<body>
	<h1 align="center">${item.name}</h2>
	
	<div id="count" align="center">
		조회수 : ${item.count}
		<button type="button">장바구니 담기</button>
		<button type="button">장바구니 확인</button>
	</div>
	
	<div align="center">
		<div>
			<img id="image" alt="" src="${item.url}" widht="350px" height="350px">
			<div id="info">
				종류 : ${item.name}<br><br><br>
				가격 : ${item.price}<br><br><br>
				<p>설명 : ${item.description}</p>
			</div>
		</div>
		<a href="itemList.do">상품 목록 보기</a>
	</div>
	
</body>
</html>