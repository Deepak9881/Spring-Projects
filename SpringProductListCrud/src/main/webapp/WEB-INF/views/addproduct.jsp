<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div align="center" border="2" style="background-color:lightgray;padding:20px;border-style:groove;margin:auto;width:fit-content;font:bold">
<h3 align="center">Edit Product</h3>
<form  action="addproduct" method="post">
Enter the product id:<input type="text" name="prodid"><br><br>
Enter the Product name:<input type="text" name="pname"><br><br>
Enter the product Quantity:<input type="text" name="qty"><br><br>
Enter the product price:<input type="text" name="price"><br><br>
<button type="submit" name="btn" >Add product</button> <br><br>
</form>
<a href="/SpringProductListCrud/mylogin/logout"><button>Logout</button></a>
</div>
</body>
</html>