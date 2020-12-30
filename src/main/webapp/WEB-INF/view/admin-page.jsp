<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <title> Admin page </title>
</head>
<body>

<h1> Hello, this is admin page! </h1>

<security:authorize access="isAuthenticated()">
    <h2> User: <security:authentication property="principal.username" /> </h2>
    <h2> Roles: <security:authentication property="principal.authorities"/> </h2>
</security:authorize>

<security:authorize access="!isAuthenticated()">
    <h2> Please log in, something is wrong </h2>
</security:authorize>

<security:authorize access="!hasAuthority('ADMIN')">
    <h2> You shouldn't be here </h2>
</security:authorize>

</body>
</html>
