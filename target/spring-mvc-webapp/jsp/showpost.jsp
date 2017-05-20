<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet" />
        <title>${post.title}</title>
    </head>
    <body>
        <!--style-->
        <style>
            body {
                padding-top: 70px;
            }

            footer {
                margin: 50px 0;
            }
            
        </style>


        <!--NOSCRIPT-->
        <noscript>
        <div class="noscript">
            <h1>For the Holiday Direct experience, it is necessary to enable JavaScript.</h1>
            <a href="http://www.enable-javascript.com/" target="_blank"> <h2>Here are instructions how to enable JavaScript in your web browser.</h2></a>
        </div>
        </noscript>
        <!--END NOSCRIPT-->

        <jsp:include page="/jsp/navbar.jsp" />




        <!-- Post Content -->
        <div class="container">

            <div class="row">

                <!-- Blog Post Content Column -->
                <div class="col-lg-8">

                    <!-- Blog Post -->

                    <!-- Title -->
                    <h1>${post.title}</h1>

                    <!-- Author -->
                    <p class="lead">
                        by ${post.user.name}
                    </p>
                    <b>Category: </b>${post.category.name}
                    <p><b>Tags:</b>
                        <c:forEach items="${tags}" var="tag">
                        <td>${tag.name}</td>
                    </c:forEach>

                    </p>


                    <!-- Date/Time -->
                    <p><span class="glyphicon glyphicon-time"></span> ${post.published}</p>

                    <hr>

                    <!-- Post Content -->
                    <td>${post.content}</td>
                    <hr>
                </div>
            </div>
        </div>


        <!--                    <div class="row">
                                <div class="col-md-12">
        
        
                                    <table class="table table-bordered">
                                        <tr>
                                            <th>Title:</th>
                                            <td>${post.title}</td>
                                        </tr>
                                        <tr>
                                            <th>Content</th>
                                            <td>${post.content}</td>
                                        </tr>
                                        <tr>
                                            <th>Created:</th>
                                            <td>${post.created}</td>
                                        </tr>
                                        <tr>
                                            <th>published:</th>
                                            <td>${post.published}</td>
                                        </tr>
                                        <tr>
                                            <th>expiration:</th>
                                            <td>${post.expiration}</td>
                                        </tr>
                                        <tr>
                                            <th>Approved:</th>
                                            <td>${post.isApproved}</td>
                                        </tr>
                                        <tr>
                                            <th>Category:</th>
                                            <td>${post.category.name}</td>
                                        </tr>
                                        <tr>
                                            <th>User:</th>
                                            <td>${post.user.name}</td>
                                        </tr>
                                        <tr>
                                            <th>Tags:</th>
        <c:forEach items="${tags}" var="tag">
        <td>${tag.name}</td>
        </c:forEach>
    </tr>
</table>
</div>
</div>-->



        <!-- Placed at the end of the document so the pages load faster -->
        <script src="${pageContext.request.contextPath}/js/jquery-1.12.1.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>

    </body>
</html>
