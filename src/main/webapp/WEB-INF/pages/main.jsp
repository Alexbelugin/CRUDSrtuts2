<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="s" uri="/struts-tags" %>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
<link rel="stylesheet" href="<s:url value="css/site.css"/>">


<html>
<head>
    <title>Main Zabor</title>
</head>
<body>
<div>
    <%--<s:url action="editPost" var="url">--%>
        <%--<s:param name="post.id" value="null"/>--%>
    <%--</s:url>--%>
    <%--<a href="<s:property value="#url"/>">New Postold</a>--%>
    <a href="<s:url action="editPost"/>">New Post</a>
</div>
<div><a href="<s:url action="hiddenPosts"/>">Hidden Posts</a></div>
<br><br>
<%--<s:if test="posts.size() > 0">--%>
    <%--<p>BOLWE NULLLJJJAAA</p>--%>
<%--</s:if>--%>
<%--<s:property value="printString()"/>--%>
<%--<s:property value="posts.size()"/>--%>
<table border="1">
    <s:iterator value="posts">
        <s:if test="parent == null">
            <tr>
                <td><s:property value="id"/></td>
                <td>
                    <table>
                        <tr>
                            <td><s:property value="txt"/></td>
                        </tr>
                        <s:iterator value="childPosts" var="child">
                            <tr>
                                <td><s:property value="#child.id"/></td>
                                <td><s:property value="#child.txt"/></td>
                                    <%--<td><s:property value="repliedPostId"/></td>--%>
                                <td>
                                    <s:url action="deleteReply" var="deleteReplyUrl">
                                        <s:param name="id" value="id"/>
                                    </s:url>
                                    <s:a href="%{deleteReplyUrl}" escapeAmp="false">X</s:a>
                                </td>
                            </tr>
                        </s:iterator>
                    </table>
                </td>
                <td>
                    <s:url action="addReply" var="addReplyUrl">
                        <s:param name="id" value="id"/>
                    </s:url>
                    <s:a href="%{addReplyUrl}" escapeAmp="false">Reply</s:a>
                        <%--<a href="<s:url action="editPost"><s:param name="post.id" value="id"/></s:url>">Edit</a>--%>
                    <s:url action="editPost" var="url">
                        <s:param name="post.id" value="id"/>
                    </s:url>
                    <a href="<s:property value="#url"/>">Edit</a>
                        <%--&nbsp;&nbsp;&nbsp;--%>
                    <s:url action="hidePost" var="url">
                        <s:param name="post.id" value="id"/>
                    </s:url>
                    <a href="<s:property value="#url"/>">Hide</a>
                        <%--<a href="<s:url action="hidePost"><s:param name="post.id" value="id"/></s:url>" >Hide</a>--%>
                </td>
            </tr>
        </s:if>
    </s:iterator>
</table>
</body>
</html>
