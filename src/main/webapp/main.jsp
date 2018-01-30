<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>Main Zabor</title>
</head>
<body>
<div><a href="<s:url action="editPost"/>">New Post</a></div>
<div><a href="<s:url action="hiddenPosts"/>">Hidden Posts</a></div>
<br><br>
<table>
    <s:iterator value="posts">
        <tr>
            <td><s:property value="id"/></td>
            <td><s:property value="txt"/></td>
            <td>
                <a href="<s:url action="editPost"><s:param name="post.id" value="id"/></s:url>">Edit</a>
                <%--<s:url action="editPost" var="url">--%>
                    <%--<s:param name="post.id" value="id"/>--%>
                <%--</s:url>--%>
                <%--<a href="<s:property value="#url"/>">Edit</a>--%>
                <%--&nbsp;&nbsp;&nbsp;--%>
                <%--<s:url action="hidePost" var="url">--%>
                    <%--<s:param name="post.id" value="id"/>--%>
                <%--</s:url>--%>
                <a href="<s:url action="hidePost"><s:param name="post.id" value="id"/></s:url>" >Hide</a>
            </td>
        </tr>
    </s:iterator>
</table>
</body>
</html>
