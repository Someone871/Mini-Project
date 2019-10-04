<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Set Menu</title>
</head>
<body>

<form action="SetMenu" method="post">
Cuisine:: <input type="text" name="cuisine"><br>
Tiffin Description:: <input type="text" name="tiff_desc"><br>
Number of tiffins:: <input type="text" name="num_avl"><br>
Cost per tiffin:: <input type="text" name="unit_cost">
<input type="hidden" name="action" value="set_menu">
<%
String chef_id = session.getAttribute("Chef_id").toString();
%>
<input type="hidden" name="id" value="<%out.print(chef_id);%>">
<input type="submit" name="save_menu">
</form>

</body>
</html>