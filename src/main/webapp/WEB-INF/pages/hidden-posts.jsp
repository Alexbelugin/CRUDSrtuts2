<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="s" uri="/struts-tags" %>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">

<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <title>Hided Posts</title>
</head>
<body>
<nav class="navbar sticky-top navbar-light" style="background-color: #e3f2fd;">
    <!-- Navbar content -->
    <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#newPost">
        New Post
    </button>
    <ul class="nav nav-pills justify-content-end">
        <li class="nav-item">
            <a class="nav-link" href="href="<s:url action="index"/>"">Main Zabor</a>
        </li>
        <li class="nav-item">
            <a class="nav-link active" href="#">Hidden Posts</a>
        </li>
    </ul>
</nav>
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
<%--<div><a href="<s:url action="index"/>">Zabor</a></div>--%>
<div class="container" align="center">
    <s:iterator value="posts">
        <div class="card border-secondary mb-3" style="max-width: 18rem;">
            <div class="card-header text-muted"><s:property value="title"/></div>
            <div class="card-body">
                <h5 class="card-title text-muted"><s:property value="user.name"/> wrote:</h5>
                <p class="card-text text-muted"><s:property value="txt"/></p>
                <div class="card-footer">
                    <s:url action="restorePost" var="url">
                        <s:param name="post.id" value="id"/>
                    </s:url>
                    <a href="<s:property value="#url"/> ">Restore</a>
                    <s:url action="deletePost" var="url">
                        <s:param name="post.id" value="id"/>
                    </s:url>
                    <a href="<s:property value="#url"/> ">Delete</a>
                </div>
            </div>
        </div>
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
