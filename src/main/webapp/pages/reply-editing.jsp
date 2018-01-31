<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>Reply</title>
</head>
<body>
<s:form action="saveReply">
    <s:textfield name="post.replyTxt" value="%{post.replyTxt}" label="Reply"/>
    <s:hidden name="post.id" value="%{post.id}"/>
    <s:submit value="Submit"/>
    <s:submit value="Cancel" action="index"/>
</s:form>
</body>
</html>
