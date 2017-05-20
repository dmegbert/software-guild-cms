<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Hello Controller Page</title>
        <!-- Bootstrap core CSS -->
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">

        <!-- SWC Icon -->
        <link rel="shortcut icon" href="${pageContext.request.contextPath}/img/icon.png">

    </head>
    <body>
        <!--NOSCRIPT-->
        <noscript>
        <div class="noscript">
            <h1>For the Holiday Direct experience, it is necessary to enable JavaScript.</h1>
            <a href="http://www.enable-javascript.com/" target="_blank"> <h2>Here are instructions how to enable JavaScript in your web browser.</h2></a>
        </div>
        </noscript>
        <!--END NOSCRIPT-->

        <jsp:include page="/jsp/navbar.jsp" />
        <div class="container">


            <div class="row">
                <div class="col-md-12">
                    <!--Fix This--> 

                    <form class="form-horizontal" id="new-page-form">

                        <!-- Form Name -->
                        <legend>Add Page</legend>

                        <!-- Text input-->
                        <div class="form-group">
                            <label class="col-md-4 control-label" for="title">Title: </label>  
                            <div class="col-md-5">
                                <div id="title-adderror"class="text-warning"></div>
                                <input id="pageAddTitle" name="title" type="text" placeholder="Enter Title" class="form-control input-md">
                                <span class="help-block">This will be page title</span>  
                            </div>
                        </div>

                        <!-- Textarea -->
                        <div class="form-group">
                            <label class="col-md-4 control-label" for="content">Content</label>
                            <div class="col-md-7">
                                <div id="content-adderror"class="text-warning"></div>
                                <textarea class="form-control" id="pageAddContent" name="content" rows="10" cols="50">Enter your page content here.  Use the tools above for formatting, adding images, and inserting links to other pages.</textarea>
                            </div>
                        </div>
                        <!-- Button -->
                        <div class="form-group">
                            <label class="col-md-4 control-label" for="submit"></label>
                            <div class="col-md-4">
                                <button id="submit" name="submit" class="btn btn-primary">Submit</button>
                            </div>
                        </div>

                    </form>
                </div>


            </div>

        </div>
        <!-- Placed at the end of the document so the pages load faster -->
        <!--JQuery-->
        <script type="text/javascript">

            var contextRoot = '${pageContext.request.contextPath}';

        </script>

        <div class="row">
            <div class="col-md-12">
                <script src="https://code.jquery.com/jquery-1.12.0.min.js"></script>

                <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>


                <script type="text/javascript" src="${pageContext.request.contextPath}/js/app.js"
                <script type="text/javascript" src="//cdn.jsdelivr.net/momentjs/latest/moment.min.js"></script>


                    </body>
                    </html>