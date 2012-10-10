<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:url var="_baseUrl" value="/"/>
<c:set var="_baseUrl" value="${empty pageContext.request.contextPath ? '' : _baseUrl}"/>