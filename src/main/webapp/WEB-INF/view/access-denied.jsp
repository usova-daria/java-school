<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<html>
<head>
	<title>Access Denied</title>
</head>

<body>

	<h2>
		Access Denied - You are not authorized to access this resource.
		Roles: <security:authentication property="principal.authorities"/>
	</h2>
	<hr>
	
	<a href="${pageContext.request.contextPath}/"> Back to Home Page </a>
	
</body>

</html>