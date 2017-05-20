

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!-- Custom CSS -->
<link href="${pageContext.request.contextPath}/css/navigation.css" rel="stylesheet">

<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
    <div class="container">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">

            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">
                <img src="${pageContext.request.contextPath}/img/logo.png" alt="Holiday Direct Logo">
            </a>
        </div>
        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">

            <ul class="nav navbar-nav">

                <li class="nav-divider"></li>

                <li><a href="${pageContext.request.contextPath}">Home</a></li>

                <li><a href="${pageContext.request.contextPath}/post/all">Blog</a></li>
                
                <li><a href="${pageContext.request.contextPath}/upload">Upload</a></li>
                
                <li><a href="${pageContext.request.contextPath}/jsp/admin.jsp">Admin</a></li>

            </ul>
                
            <ul class="nav navbar-nav navbar-right">
                
                <li><button class="button"><span>Contact Us </span></button></li>
                
            </ul>
        </div>
        <!-- /.navbar-collapse -->
    </div>
    <!-- /.container -->
</nav>
