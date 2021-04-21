<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style>
	#first{ background-color: threedlightshadow;}
	*{ color:  navy;}
</style>

</head>
<body>
	<h1 align="center"><b>${item.name}</b></h2>
	<table align="center" width="600" id="first">
		<tr>
			<td align="center">
				조회수 : ${item.count} &nbsp;&nbsp;
				<button type="button">장바구니 담기</button>
				<button type="button">장바구니 확인</button>
			</td>
		</tr>
	</table>
		
	<table align="center" width="600">
		<tr>
			<td rowspan="3">
				<img alt="" src="${item.url}">
			</td>
			<td>
				종류 : ${item.name}
			</td>
		</tr>
		<tr>
			<td>
				종류 : ${item.name}
			</td>
		</tr>
		<tr>
			<td>
				설명 : ${item.description}
			</td>
		</tr>
		<tr>
			<td colspan="2" align="center"><a href="itemList.do">상품 목록 보기</a></td>
		</tr>
	</table>
	
	
	
	
	<!-- 
	<div id="count" align="center">
		조회수 : ${item.count} &nbsp;&nbsp;
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
	 -->
	
	
</body>
</html>