<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>Editing</title>
</head>
<body>
<s:form action="save">
    <s:textfield name="post.txt" value="%{post.txt}" label="Post"/>
    <s:hidden name="post.id" value="%{post.id}"/>
    <s:submit value="Submit"/>
    <s:submit value="Cancel" action="index"/>
</s:form>
</body>
</html>
