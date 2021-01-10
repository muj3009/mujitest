<%-- 
    Document   : fileuploadform
    Created on : 04-Jan-2016, 19:04:59
    Author     : p11249988
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script
        src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.2/jquery.min.js"></script>
        <script>
            $(document)
                    .ready(
                            function () {
                                //add more file components if Add is clicked
                                $('#addFile')
                                        .click(
                                                function () {
                                                    var fileIndex = $('#fileTable tr')
                                                            .children().length - 1;
                                                    $('#fileTable')
                                                            .append(
                                                                    '<tr><td>'
                                                                    + '   <input type="file" name="files[' + fileIndex + ']" />'
                                                                    + '</td></tr>');
                                                });

                            });
        </script>
    </head>
    <body>
         <%@include file="../jsp/fragments/header.jspf"%>
         <div class="uploadbox">
        <h1>Spring Multiple File Upload example</h1>

        <form:form method="post" action="save.html" modelAttribute="uploadForm" enctype="multipart/form-data">
            <p>Select files to upload. Press Add button to add more file inputs.</p>

            <input id="addFile" type="button" value="Add File"/>

            <table id="fileTable">
                <tr>
                    <td>
                        <input name="files[0]" type="file"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        <input name="files[1]" type="file"/>
                    </td>
                </tr>
            </table>
            <br/><input type="submit" value="Upload" />

        </form:form>
        </div>
        <%@include file="../jsp/fragments/footer.jspf"%>
        <%@include file="../jsp/fragments/copyright.jspf"%>
    </body>
</html>
