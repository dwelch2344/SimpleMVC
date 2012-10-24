<%@ taglib prefix="tags" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<tags:template>
        <jsp:attribute name="head">  
			<%-- <head> contents here --%>               
        </jsp:attribute>
        <jsp:body>
                <h1>Register</h1>
                <p>Thanks for signing up!</p>
                <form:form commandName="bean" action="register">
                	<form:errors path="*"/>
                	<form:label path="name">Name:</form:label>
                	<form:input path="name"/>
                	
                	<form:label path="email">Email:</form:label>
                	<form:input path="email"/>
                	
                	<form:label path="password">Password:</form:label>
                	<form:password path="password"/>
                	
                	<form:button>Register</form:button>
                </form:form>
        </jsp:body>
</tags:template>