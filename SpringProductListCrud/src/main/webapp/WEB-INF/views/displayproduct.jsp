<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div align="center" border="2" style="border-style:groove;background-color:mediumseagreen;padding:20px;margin:auto;width:fit-content;font:bold">
<h3>	Product List	</h3>
<table border="2">
<tr ><span style="background-color:gray"><th>Product id</th>
    <th>Product name</th>
    <th>Product quantity</th>
    <th>Product Price</th>
    <th>action</th></span>
</tr>
<c:forEach var="prod" items="${plist}">
<tr>
    <td>${prod.prodid}</td>
    <td>${prod.pname}</td>
    <td>${prod.quantity}</td>
    <td>${prod.price}</td>
    <td>
    <a href="edit/${prod.prodid}">edit </a>/
    <a href="delete/${prod.prodid}">delete </a>
    </td>
</tr>

</c:forEach>
</table><br>
<a href="addnewproduct"><button>Add new product</button></a>&nbsp;&nbsp;
<a href="/SpringProductListCrud/mylogin/logout"><button>Logout</button></a>
</div>
</body>
</html>