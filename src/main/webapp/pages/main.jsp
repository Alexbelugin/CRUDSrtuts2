<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>Main Zabor</title>
</head>
<body>
<div>
    <%--<s:url action="editPost" var="url">--%>
        <%--<s:param name="post.id" value="null"/>--%>
    <%--</s:url>--%>
    <%--<a href="<s:property value="#url"/>">New Post</a>--%>
    <a href="<s:url action="editPost"/>">New Post</a>
</div>
<div><a href="<s:url action="hiddenPosts"/>">Hidden Posts</a></div>
<br><br>
<s:if test="posts.size() > 0">
    <p>BOLWE NULLLJJJAAA</p>
</s:if>
<table border="1">
    <s:iterator value="posts">
        <tr>
            <td><s:property value="id"/></td>
            <td>
                <table>
                    <tr>
                        <td><s:property value="txt"/></td>
                    </tr>
                    <s:iterator value="replies" var="reply">
                        <tr>
                            <td><s:property value="#reply.id"/></td>
                            <td><s:property value="#reply.txt"/></td>
                            <%--<td><s:property value="repliedPostId"/></td>--%>
                            <td>
                                <%--<s:url action="addReply" var="url">--%>
                                    <%--<s:param name="post.id" value="id"/>--%>
                                <%--</s:url>--%>
                                <%--<a href="<s:property value="#url"/>">Reply</a>--%>
                                <%--<s:url action="editPost" var="url">--%>
                                    <%--<s:param name="post.id" value="id"/>--%>
                                <%--</s:url>--%>
                                <%--<a href="<s:property value="#url"/>">Edit</a>--%>
                                    <%--&lt;%&ndash;&nbsp;&nbsp;&nbsp;&ndash;%&gt;--%>
                                <%--<s:url action="deleteReply" var="url">--%>
                                    <%--<s:param name="post.id" value="repliedPostId"/>--%>
                                    <%--<s:param name="post.replyPointer" value="id"/>&lt;%&ndash;НЕ ПЕРЕДАЕТ ПАРАМЕТР&ndash;%&gt;--%>
                                <%--</s:url>--%>
                                <%--<a href="<s:property value="#url"/>">Delete</a>--%>
                            </td>
                        </tr>
                    </s:iterator>
                </table>
            </td>
            <td>
                <s:url action="addReply" var="addReplyUrl">
                    <s:param name="post.id" value="id"/>
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
    </s:iterator>
</table>
</body>
</html>
