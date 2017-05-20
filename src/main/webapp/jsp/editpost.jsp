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

        <!-- Custom styles for this template -->
        <link href="${pageContext.request.contextPath}/css/starter-template.css" rel="stylesheet">

        <!-- SWC Icon -->
        <link rel="shortcut icon" href="${pageContext.request.contextPath}/img/icon.png">

        <!--JQuery-->
        <script src="https://code.jquery.com/jquery-1.12.0.min.js"></script>

        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>

        <script type="text/javascript" src="//cdn.jsdelivr.net/bootstrap.daterangepicker/2/daterangepicker.js"></script>
        <script type="text/javascript" src="//cdn.jsdelivr.net/momentjs/latest/moment.min.js"></script>

        <link href="https://cdnjs.cloudflare.com/ajax/libs/select2/4.0.2/css/select2.min.css" rel="stylesheet" />
        <script src="https://cdnjs.cloudflare.com/ajax/libs/select2/4.0.2/js/select2.min.js"></script>
        <script src="${pageContext.request.contextPath}/tinymce/tinymce.min.js" type="text/javascript"></script>
        <script>
            tinymce.init({
                selector: '#content',
                plugins: ["image"],
                file_browser_callback: function (field_name, url, type, win) {
                    if (type == 'image')
                        $('#upload_form input').click();
                }
            });
        </script>
        <script>
            $(document).ready(function () {
                $(".js-example-basic-multiple").select2({
                    tags: true
                });
            });
        </script>
    </head>
    <body>
        <div class="container">
            <h1>Holiday Direct</h1>
            <hr/>
            <div class="navbar">
                <ul class="nav nav-tabs">
                    <li role="presentation"><a href="${pageContext.request.contextPath}/index.jsp">Home</a></li>
                    <li role="presentation" class="active"><a href="${pageContext.request.contextPath}/hello/sayhi">Hello Controller</a></li>
                </ul>    
            </div>



            <div class="row">
                <div class="col-md-12">
                    <!--Fix This--> 
                    <form:form class="form-horizontal" id="update-form" action="${pageContext.request.contextPath}/post" method="PUT">

                        <fieldset>


                            <legend>Add Post</legend>


                            <div class="form-group">
                                <label class="col-md-4 control-label" for="title">Title: </label>  
                                <div class="col-md-5">
                                    <div id="add-errors-title"></div>
                                    <input type="hidden" name="id" id="id" value="${post.id}">
                                    <input id="title" name="title" type="text" placeholder="Enter Title" value="${post.title}" class="form-control input-md">
                                    <span class="help-block">This will be the headline of your post</span>  
                                </div>
                            </div>


                            <div class="form-group">
                                <label class="col-md-4 control-label" for="content">Content</label>
                                <div class="col-md-7">
                                    <div id="add-errors-content"></div>
                                    <textarea class="form-control" id="content" name="content" rows="10" cols="50">${post.content}</textarea>
                                    <span class="help-block">Enter your post's content here.  Use the tools above for formatting, adding images, and inserting links to other pages.</span> 
                                </div>
                            </div>


                            <div class="form-group">
                                <label class="col-md-4 control-label" for="categoryId">Category</label>
                                <div class="col-md-4">
                                    <div id="add-errors-categoryId"></div>
                                    <select id="categoryId" name="categoryId" class="form-control">
                                        <option>${post.category.name}</option>
                                    </select>
                                </div>
                            </div>


                            <div class="form-group">
                                <label class="col-md-4 control-label" for="tags">Tags</label>
                                <div class="col-md-4">
                                    <select id="tags" name="tags" class="form-control js-example-basic-multiple" multiple="multiple">
                                        <c:forEach items="${tags}" var="tag">
                                            <option selected>${tag.name}</option>
                                        </c:forEach>

                                    </select>
                                </div>
                            </div>

                            <div class="form-group">
                                <label class="col-md-4 control-label" for="published">Created Date: </label>  
                                <div class="col-md-4">
                                    <p class="text-info">${post.created}</p>
                                </div>
                            </div>

                            <div class="form-group">
                                <label class="col-md-4 control-label" for="published">Publish Date: </label>  
                                <div class="col-md-4">
                                    <div id="add-errors-published"></div>
                                    <input id="published" value="${post.published}" name="published" type="date" placeholder="MM/DD/YYYY" class="form-control input-md">
                                    <span class="help-block">This will be when your post is viewable by the public</span>  
                                </div>
                            </div>


                            <div class="form-group">
                                <label class="col-md-4 control-label" for="expiration">Expire Date: </label>  
                                <div class="col-md-4">
                                    <div id="add-errors-expiration"></div>
                                    <input id="expiration" value="${post.expiration}" name="expiration" type="date" placeholder="" class="form-control input-md">
                                    <span class="help-block">This will be when your post will no longer be viewable</span>  
                                </div>
                            </div>


                            <div class="form-group">
                                <label class="col-md-4 control-label" for="submit"></label>
                                <div class="col-md-4">
                                    <button id="submit" name="submit" class="btn btn-primary">Submit</button>
                                </div>
                            </div>
                            <div class="form-group col-md-4" id="add-errors"></div>
                        </fieldset>
                    </form:form>
                </div>


            </div>



        </div>
        <!-- Placed at the end of the document so the pages load faster -->

        <script type="text/javascript">
            var contextRoot = "${pageContext.request.contextPath}";
        </script>
        <script src="${pageContext.request.contextPath}/js/app.js"></script>
    </body>
</html>

