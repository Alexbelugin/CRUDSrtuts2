<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="s" uri="/struts-tags" %>


<html>
<head>
    <title>Editing</title>
</head>
<body>
<s:actionerror/>
<s:form action="save" validate="true">
    <s:textfield name="post.txt" value="%{post.txt}" label="Post" requiredLabel="true"/>
    <s:textfield name="user.name" value="%{user.name}"  label="Login"/>
    <s:password name="user.password" value="%{user.password}" label="Password"/>
    <s:hidden name="post.id" value="%{post.id}"/>
    <s:submit value="Submit"/>
    <s:submit value="Cancel" action="index"/>
</s:form>
</body>
</html>
