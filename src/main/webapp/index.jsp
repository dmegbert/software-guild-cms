<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Holiday Direct - HOME</title>
        <!-- Bootstrap core CSS -->
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet" />
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

            <!--            <h2>Home Page</h2>
                        <textarea id="my_editor"></textarea>
                        <iframe id="upload_target" name="upload_target" style="display:none"></iframe>
                        <form id="upload_form" action="/upload/" target="upload_target" method="post" enctype="multipart/form-data" style="width:0px;height:0;overflow:hidden"><input name="image" type="file" onchange="$('#upload_form').submit();this.value = '';"></form>-->
            <div class="container-fluid">
                <div class="row">
                    <h2>From Our Blog</h2>
                    <div class="col-lg-12 col-sm-12 col-md-12" style="border: 1px solid black">
                        <!--BLOG CONTENT--> 

                        <div>
                            <h3> Blog Title </h3>
                            <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nam nunc odio, placerat quis odio faucibus, pellentesque placerat tortor. Sed leo nunc, fermentum a felis feugiat, volutpat aliquet nisl. Etiam eget dui nisi. 
                                Vestibulum nec ligula ligula. Mauris vestibulum porttitor lectus, quis eleifend purus rhoncus vehicula. Nulla quis hendrerit nulla. Donec velit tortor, vestibulum eu nisl quis, luctus lobortis neque. Maecenas ornare 
                                mauris ut interdum accumsan. Aliquam bibendum ligula id sem aliquet facilisis. Vivamus metus elit, pharetra sed tempus non, ultrices ac turpis...</p><!--REMOVE FOR ACTUAL CONTENT-->
                            <a class="btn btn-sm  btn-info pull-right" style="margin-top: 2px; margin-bottom:2px;" href="" type="button">Read More</a>
                        </div>

                    </div>
                    <!--END BLOG CONTENT--> 
                </div>
            </div>


            <hr>
            <div class="container">

                <div class="row">
                    <div class="col-md-6">
                        <img src="${pageContext.request.contextPath}/img/wreath.jpg" alt="Wreath" class="img-responsive">
                    </div>
                    
                    <div class="col-md-6">
                        <h1>Holiday Direct: Direct-to-market Holiday Supplies</h1>
                        <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nam nunc odio, placerat quis odio faucibus, pellentesque placerat tortor.</p>
                        <a class="btn btn-sm btn-info" style="margin-top: 2px; margin-bottom:2px;" href="" type="button">Contact Holiday Direct</a>
                    </div>
                    
                </div>

            </div>

        </div>
    </div>

    <!-- Placed at the end of the document so the pages load faster MUST BE PLACED BEFORE TINYMC-->
    <script src="${pageContext.request.contextPath}/js/jquery-1.12.1.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/tinymce/tinymce.min.js" type="text/javascript"></script>

    <!--TINYMC-->
    <script>
        tinymce.init({
            selector: '#my_editor',
            plugins: ["image"],
            file_browser_callback: function (field_name, url, type, win) {
                if (type == 'image')
                    $('#upload_form input').click();
            }
        });
    </script>
    <!--END TINYMC-->

    <jsp:include page="/jsp/footer.jsp" />




</body>
</html>

