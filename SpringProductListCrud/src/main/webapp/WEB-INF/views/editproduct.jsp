<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body><div align="center" border="2" style="border-style:groove;margin:auto;width:fit-content;font:bold">
<form action="/SpringProductListCrud/product/updateproduct" method="post">
	Product id : <input type="text" name="prodid" id="pid" value="${p.prodid}" readonly> <br>
	Product name : <input type="text" name="pname" id="pname" value="${p.pname}" ><br>
	Quantity : <input type="text" name="qty" id="qty" value="${p.quantity}"><br>
	Price <input type="text" name="price" id="price" value="${p.price}" ><br>
	
	<button type="submit" name="btn" id="btn" value="update">Update Product</button>
	</form>
	<a href="/SpringProductListCrud/mylogin/logout">Logout</a>
	</div>
</body>
</html>