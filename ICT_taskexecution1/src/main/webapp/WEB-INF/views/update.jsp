<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form:form method="post" modelAttribute="user" action="update">
	    <form:label path="id">ID :</form:label>
	    <form:input path="id" readonly="true"/>
		<form:label path="fullName"> Full Name:</form:label>
		<form:input path="fullName" />
		<br>
		<form:label path="date">Date of Birth</form:label>
		<form:input path="date" />
		<br>
		<form:label path="gender">Gender</form:label>
		<form:radiobuttons path="gender" items="${genderlist}" delimiter=" | " />
		<br>
		<form:label path="address">Address</form:label>
		<form:textarea path="address" />
		<br>
		<form:label path="state">State</form:label>
		<form:input path="state" />
		<br>
		<form:label path="district">District</form:label>
		<form:input path="district" />
		<br>
		<form:label path="taluka">Taluka</form:label>
		<form:input path="taluka" />
		<br>
		<form:label path="pincode">Pincode</form:label>
		<form:input path="pincode" />
		<br>
		<form:label path="familyIncome"> Family Income</form:label>
		<br>
		<form:radiobuttons path="familyIncome" items="${familyincomelist}"
			delimiter=" <br> " />
		<form:label path="interest">Interest :</form:label>
		<form:checkboxes items="${interestList}" path="interest" delimiter="<br>"/>		
		<table border="1px">
			<tr>
				<th>Skills</th>
				<th>Rating</th>
				<th>Out Of</th>
			</tr>
			<tr>
				<td>J2EE</td>
				<td><form:input path="j2ee" /></td>
				<td>10</td>
			</tr>
			<tr>
				<td>Hibernate</td>
				<td><form:input path="hibernate" /></td>
				<td>10</td>
			</tr>
			<tr>
				<td>Spring</td>
				<td><form:input path="spring" /></td>
				<td>10</td>
			</tr>
		</table>
		<form:button>Submit</form:button>
	</form:form>
</body>
</html>