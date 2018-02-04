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
<nav class="navbar sticky-top navbar-light" style="background-color: #e3f2fd;">
    <!-- Navbar content -->
    <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#newPost">
        New Post
    </button>
    <ul class="nav nav-pills justify-content-end">
        <li class="nav-item">
            <a class="nav-link active" href="#">Main Zabor</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="<s:url action="hiddenPosts"/>">Hidden Posts</a>
        </li>
    </ul>
</nav>
<%--<div>--%>
<%--<a href="<s:url action="editPost"/>">New Post</a>--%>
<%--</div>--%>
<%--<ul class="nav justify-content-center">--%>
<%--<li class="nav-item">--%>
<%--<a class="nav-link" href="#">Main Zabor</a>--%>
<%--&lt;%&ndash;<s:url action="addReply" var="addReplyUrl">&ndash;%&gt;--%>
<%--&lt;%&ndash;<s:param name="id" value="id"/>&ndash;%&gt;--%>
<%--&lt;%&ndash;</s:url>&ndash;%&gt;--%>
<%--&lt;%&ndash;<s:a href="%{addReplyUrl}" escapeAmp="false" cssClass="card-link" data-toggle="modal" data-target="#exampleModal">New Post</s:a>&ndash;%&gt;--%>
<%--</li>--%>
<%--<li class="nav-item">--%>
<%--<a class="nav-item" href="<s:url action="hiddenPosts"/>">Hidden Posts</a>--%>
<%--</li>--%>
<%--</ul>--%>
<div class="container">
    <div class="col col-md">

    </div>
</div>
<div>
    <!-- Modal -->
    <div class="modal fade" id="newPost" tabindex="-1" role="dialog" aria-labelledby="newPostLabel"
         aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="newPostLabel">New Post On Zabor</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <s:form cssClass="well form-vertical" action="savePost">
                        <s:textfield cssClass="form-control" name="post.title" value="%{post.title}" label="Title"/>
                        <s:textarea cssClass="form-control-lg" name="post.txt" value="%{post.txt}" label="Post"
                                    requiredLabel="true" rows="6"/>
                        <s:textfield cssClass="form-control" name="user.name" value="%{user.name}" label="Name"/>
                        <s:password cssClass="form-control" name="user.password" value="%{user.password}"
                                    label="Password"/>
                        <s:hidden name="post.id" value="%{post.id}"/>
                        <s:submit cssClass="btn btn-primary" value="Submit"/>
                        <%--<s:submit value="Cancel" action="index"/>--%>
                    </s:form>
                </div>
            </div>
        </div>
    </div>
</div>
<div class="container" align="center">
    <s:iterator value="posts">
        <s:if test="parent == null">
            <div class="card bg-light mb-3" style="width: 50rem;">
                <div class="card-header" style="background-color: #E8F1F2;" align="left"><s:property
                        value="title"/></div>
                <div class="card-body">
                    <h6 class="card-subtitle mb-2 text-muted"><s:property value="user.name"/> wrote:</h6>
                    <div class="container-fluid">
                        <div class="row">
                            <div class="col" align="left" style="width: 35rem;">
                                <div class="card">
                                    <div class="card-body" style="width: 30rem;">
                                        <s:property value="txt"/>
                                    </div>
                                </div>
                            </div>
                            <div class="col" align="right">
                                <s:iterator value="replies" var="child">
                                    <div class="card" style="width: 12rem;">
                                        <div class="card-body">
                                            <h6 class="card-subtitle mb-2 text-muted"><s:property value="user.name"/>
                                                replied:</h6>
                                            <p class="card-text">
                                                <s:property value="#child.txt"/>
                                            </p>
                                            <s:url action="deleteReply" var="deleteReplyUrl">
                                                <s:param name="id" value="id"/>
                                            </s:url>
                                            <s:a href="%{deleteReplyUrl}" escapeAmp="false">X</s:a>
                                        </div>
                                    </div>
                                </s:iterator>
                            </div>
                        </div>
                        <div class="row">
                            <s:url action="addReply" var="addReplyUrl">
                                <s:param name="id" value="id"/>
                            </s:url>
                            <s:a href="%{addReplyUrl}" escapeAmp="false" cssClass="card-link">Reply</s:a>
                            <s:url action="editPost" var="editPostUrl">
                                <s:param name="post.id" value="id"/>
                                <s:param name="user.name" value="user.name"/>
                            </s:url>
                            <s:a href="%{editPostUrl}" escapeAmp="false" cssClass="card-link">Edit</s:a>
                            <s:url action="hidePost" var="hidePostUrl">
                                <s:param name="post.id" value="id"/>
                                <s:param name="user.name" value="user.name"/>
                            </s:url>
                            <s:a href="%{hidePostUrl}" escapeAmp="false" cssClass="card-link">Hide</s:a>
                        </div>
                    </div>
                </div>
            </div>
        </s:if>
    </s:iterator>
</div>
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
