<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<html>
<head>
    <title>Index page</title>
</head>
<body>

<security:authorize access="isAuthenticated()">
    <h2> User: <security:authentication property="principal.username" /> </h2>
    <h2> Roles: <security:authentication property="principal.authorities"/> </h2>
</security:authorize>

<security:authorize access="hasAuthority('CUSTOMER')">
    <h2> You are customer </h2>
</security:authorize>

<h1>Doggo!!!!</h1>
<img src="img/nora.jpg" alt="doggo">

</body>
</html>
