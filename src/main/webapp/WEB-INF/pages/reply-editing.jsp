<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="s" uri="/struts-tags" %>

<html>
<head>
    <title>Reply</title>
</head>
<body>
<s:form action="saveReply">
    <s:textfield name="post.txt" value="%{post.txt}" label="Reply"/>
    <s:hidden name="id" value="%{id}"/>
    <s:textfield name="user.name" value="%{user.name}" label="Login"/>
    <s:textfield name="user.password" label="Password"/>
    <s:submit value="Submit"/>
    <s:submit value="Cancel" action="index"/>
</s:form>
</body>
</html>
