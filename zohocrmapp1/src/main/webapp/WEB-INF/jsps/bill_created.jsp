<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
		<%@ include file="Menu.jsp" %>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Bill Info</title>
</head>
<body>
	<h2>Bill Info</h2>
		First Name:${billings.firstName }<br/>
		Last Name:${billings.lastName }<br/>
		Email:${billings.email }<br/>
	    Mobile:${billings.mobile }<br/>
	    	Product Name:${billings.product }<br/>
	    		    	Quantity:${billings.quantity }<br/>
	    		    	Amount :${billings.amount }<br/>
	    	
	    	
	    

	

</body>
</html>