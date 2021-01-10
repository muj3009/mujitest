<%-- 
    Document   : fileuploadsuccess
    Created on : 04-Jan-2016, 19:55:41
    Author     : p11249988
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Mujify:File Upload</title>
    </head>
    <body>
        <%@include file="../jsp/fragments/header.jspf"%>
        <div class="uploadbox">
        <h1>Spring Multiple File Upload example</h1>
        <p>Following files are uploaded successfully</p>
        
        
        <ol>
            <c:forEach items="${files}" var="file">
                <li>${file}</li>
            </c:forEach>
        </ol>
        
        <input type="hidden" 
                       name="${_csrf.parameterName}" value="${_csrf.token}" />
         </div>
         <%@include file="../jsp/fragments/footer.jspf"%>
        <%@include file="../jsp/fragments/copyright.jspf"%>               
    </body>
</html>
