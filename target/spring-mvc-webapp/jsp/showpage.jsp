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
        <title>${page.title}</title>
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

        <!-- Page Content -->
        <div class="container">

            <div class="row">

                <!-- Page Post Content Column -->
                <div class="col-lg-12">

                    <!-- Title -->
                    <h1 style="text-align:center;">${page.title}</h1>


                    <hr>

                    <!-- Page Content -->
                    <td>${page.content}</td>
                    <hr>
                    <jsp:include page="/jsp/footer.jsp" />

                    <script src="${pageContext.request.contextPath}/js/jquery-1.12.1.min.js"></script>
                    <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>

                    </body>
                    </html>