<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="s" uri="/struts-tags" %>


<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <title>Editing</title>
</head>
<body>
<div class="container">
    <div class="card w-50">
        <div class="card-body">
            <h5 class="card-title">Edit Post</h5>
            <%--<p class="card-text">--%>
            <s:if test="hasActionErrors()">
                <div class="alert alert-danger" role="alert">
                    <s:actionerror/>
                </div>
            </s:if>
            <s:form action="saveEdit">
                <s:textarea cssClass="form-control-lg" name="post.txt" value="%{post.txt}" label="Text"
                            requiredLabel="true" rows="6"/>
                <s:if test="%{user.name != 'anonymous'}">
                    <%--<s:property value="printString()"/>--%>
                    <s:hidden name="user.name" value="%{user.name}"/>
                    <s:password cssClass="form-control" name="user.password" value="%{user.password}" label="Password"/>
                </s:if>
                <s:hidden name="post.id" value="%{post.id}"/>
                <s:submit cssClass="btn btn-primary" value="Submit"/>
                <s:submit cssClass="btn btn-secondary" value="Cancel" action="index"/>
            </s:form>
            <%--</p>--%>
            <%--<a href="#" class="btn btn-primary">Go somewhere</a>--%>
        </div>
    </div>
</div>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
        integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
        integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
        crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
        integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
        crossorigin="anonymous"></script>
</body>
</html>
