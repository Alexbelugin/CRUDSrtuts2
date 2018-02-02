<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="s" uri="/struts-tags" %>

<html>
<head>
    <title>Hided Posts</title>
</head>
<body>
<div><a href="<s:url action="index"/>">Zabor</a></div>
<table>
    <s:iterator value="posts">
        <tr>
            <td><s:property value="id"/></td>
            <td><s:property value="txt"/></td>
            <td>
                <s:url action="restorePost" var="url">
                    <s:param name="post.id" value="id"/>
                </s:url>
                <a href="<s:property value="#url"/> ">Restore</a>
                <%--<a href="<s:url action="restorePost"><s:param name="post.id" value="id"/></s:url>" >Restore</a>--%>
                <%--<a href="<s:url action="deletePost"><s:param name="post.id" value="id"/></s:url>" >Delete</a>--%>
                <s:url action="deletePost" var="url">
                    <s:param name="post.id" value="id"/>
                </s:url>
                <a href="<s:property value="#url"/> ">Delete</a>
            </td>
        </tr>
    </s:iterator>
</table>
</body>
</html>
