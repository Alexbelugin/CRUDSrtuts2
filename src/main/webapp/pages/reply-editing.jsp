<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>Reply</title>
</head>
<body>
<s:form action="saveReply">
    <s:textfield name="reply.txt" value="%{reply.txt}" label="Reply"/>
    <s:hidden name="reply.superPostId" value="%{post.id}"/>
    <s:submit value="Submit"/>
    <s:submit value="Cancel" action="index"/>
</s:form>
</body>
</html>
