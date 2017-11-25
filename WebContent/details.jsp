<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head><title>User management. Details</title></head>
<body>
    <form method="get" action="${requestScope.contextPath}/details">
     <p><b>First name:</b> ${user.firstName}</p>
    <p><b>Last name:</b> ${user.lastName}</p>
    <p><b>Date of birth:</b> <fmt:formatDate value="${user.dateOfBirth}" type="date" dateStyle="medium"/></p>
        <input type="submit" name="okButton" value="Ok">
    </form>
    <c:if test="${requestScope.error != null}">
        <script>
            alert("${requestScope.error}")
        </script>
    </c:if>
</body>
</html>