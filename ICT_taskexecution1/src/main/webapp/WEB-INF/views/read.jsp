<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="1px">
		<tr>
			<th>ID</th>
			<th>Full Name</th>
			<th>Date of Birth</th>
			<th>Gender</th>
			<th>Address</th>
			<th>State</th>
			<th>District</th>
			<th>Taluka</th>
			<th>Pincode</th>
			<th>Family Income</th>
			<th>Intersest</th>
			<th>j2ee</th>
			<th>Hibernate</th>
			<th>Spring</th>
			<th>Edit</th>
			<th>Delete</th>
		</tr>
		<c:forEach items="${use}" var="u">
			<tr>
				<th>${u.id}</th>
				<th>${u.fullName}</th>
				<th>${u.date}</th>
				<th>${u.gender}</th>
				<th>${u.address}</th>
				<th>${u.state}</th>
				<th>${u.district}</th>
				<th>${u.taluka}</th>
				<th>${u.pincode}</th>
				<th>${u.familyIncome}</th>
				<th>${u.interest}</th>
				<th>${u.j2ee}</th>
				<th>${u.hibernate}</th>
				<th>${u.spring}</th>
				<th><a href="edit?id=${u.id}"><button>Edit</button> </a></th>
				<th><a href="delete?id=${u.id}"><button>Delete</button></a></th>
			</tr>
		</c:forEach>
	</table>

</body>
</html>