<%@page import="dao.Customer"%>
<%@page import="java.util.List"%>
<%@page import="resources.CustomerResource" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Details of All Customers</title>
</head>
<h1>Customer</h1>
<table border="1" style="width: 100%">
	<tr>
	<td>Customer_id</td>
	<td>Customer_Name</td>
	<td>Customer_Mobile</td>
	<td>Car_name</td>
	<td>Car_model</td>
	<%CustomerResource customerResource=new CustomerResource(); %>
	<%List<Customer> customers=customerResource.customer(); %>
	</tr>
	
	<%for(int i=0;i<customers.size();i++){
	int id=customers.get(i).getId();
	String name=customers.get(i).getName();
	String mobile=customers.get(i).getMobile_No();
	String carname=customers.get(i).getCar().getCar_name();
	String carmodel=customers.get(i).getCar().getCar_modelno();%>
		<tr>
			<td style="width: 20px;height: 40px"><%=id%></td>
			<td style="width: 20px;height: 40px"><%=name %></td>
			<td style="width: 20px;height: 40px"><%=mobile %></td>
			<td style="width: 20px;height: 40px"><%=carname %></td>
			<td style="width: 20px;height: 40px"><%=carmodel %></td>
		</tr>
		<%} %>	
</table>
<body>
</body>
</html>