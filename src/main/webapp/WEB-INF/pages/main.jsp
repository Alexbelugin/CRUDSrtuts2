<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="s" uri="/struts-tags" %>

<%--<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">--%>
<%--<link rel="stylesheet" href="<s:url value="css/site.css"/>">--%>


<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <title>Main Zabor</title>
</head>
<body>
<%--<div>--%>
<%--<a href="<s:url action="editPost"/>">New Post</a>--%>
<%--</div>--%>
<div>
    <!-- Button trigger modal -->
    <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#exampleModal">
        New Post
    </button>

    <!-- Modal -->
    <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
         aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">New Post On Zabor</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <s:form action="save">
                        <s:textfield name="post.txt" value="%{post.txt}" label="Post" requiredLabel="true"/>
                        <s:textfield name="user.login" value="%{user.login}" label="Login"/>
                        <s:password name="user.password" value="%{user.password}" label="Password"/>
                        <s:hidden name="post.id" value="%{post.id}"/>
                        <s:submit value="Submit"/>
                        <%--<s:submit value="Cancel" action="index"/>--%>
                    </s:form>
                </div>
                <div class="modal-footer">
                    <%--<input class="btn btn-primary" type="submit" value="Submit">--%>
                <%--<button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>--%>
                <%--<button type="button" class="btn btn-primary">Save changes</button>--%>
                </div>
            </div>
        </div>
    </div>
</div>
<div><a href="<s:url action="hiddenPosts"/>">Hidden Posts</a></div>
<br><br>
<%--<s:if test="posts.size() > 0">--%>
<%--<p>BOLWE NULLLJJJAAA</p>--%>
<%--</s:if>--%>
<%--<s:property value="printString()"/>--%>
<%--<s:property value="posts.size()"/>--%>

<div class="container">
    <s:iterator value="posts">
        <s:if test="parent == null">
            <div class="card bg-light mb-3" style="width: 60rem;">
                <div class="card-header">Post title</div>
                <div class="card-body">
                    <h6 class="card-subtitle mb-2 text-muted">name</h6>
                    <p class="card-text">
                    <table>
                        <tr>
                            <td align="center" style="width: 45rem;">
                                <s:property value="txt"/>
                            </td>
                            <td align="right">
                                <s:iterator value="childPosts" var="child">
                                    <div class="card" style="width: 12rem;">
                                        <div class="card-body">
                                            <h6 class="card-subtitle mb-2 text-muted">name</h6>
                                            <p class="card-text">
                                                <s:property value="#child.txt"/>
                                            </p>
                                            <s:url action="deleteReply" var="deleteReplyUrl">
                                                <s:param name="id" value="id"/>
                                            </s:url>
                                            <s:a href="%{deleteReplyUrl}" escapeAmp="false">X</s:a>
                                                <%--<a href="#" class="card-link">Card link</a>--%>
                                                <%--<a href="#" class="card-link">Another link</a>--%>
                                        </div>
                                    </div>
                                </s:iterator>
                            </td>
                        </tr>
                    </table>
                    </p>
                        <%--<a href="#" class="card-link">--%>
                    <s:url action="addReply" var="addReplyUrl">
                        <s:param name="id" value="id"/>
                    </s:url>
                    <s:a href="%{addReplyUrl}" escapeAmp="false">Reply</s:a>
                        <%--</a>--%>
                        <%--<a href="#" class="card-link">--%>
                    <s:url action="editPost" var="url">
                        <s:param name="post.id" value="id"/>
                    </s:url>
                    <a href="<s:property value="#url"/>" class="card-link">Edit</a>
                        <%--</a>--%>
                        <%--<a href="#" class="card-link">--%>
                    <s:url action="hidePost" var="url">
                        <s:param name="post.id" value="id"/>
                    </s:url>
                    <a href="<s:property value="#url"/>" class="card-link">Hide</a>
                        <%--</a>--%>
                </div>
            </div>
        </s:if>
    </s:iterator>
</div>
<br><br><br><br><br><br><br><br>
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
