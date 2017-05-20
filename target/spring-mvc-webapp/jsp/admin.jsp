<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
        <title>Admin</title>
    </head>
    <body>
        <div class="container">
            <jsp:include page="navbar.jsp" />

            <div class="row">
                <div class="col-md-4">

                </div>

                <div class="col-md-4 text-center">

                    <button type="button" class="btn btn-default btn-lg" style="width: 150px; margin: 5px;" onclick="showPostModal();">Posts</button>
                    <br />
                    <button type="button" class="btn btn-default btn-lg" style="width: 150px; margin: 5px;" onclick="showPageModal();">Pages</button>
                    <br />
                    <button type="button" class="btn btn-default btn-lg" style="width: 150px; margin: 5px;" onclick="showCategoryModal();">Categories</button>
                    <br />
                    <button type="button" class="btn btn-default btn-lg" style="width: 150px; margin: 5px;" onclick="showUserModal();">Users</button>
                    <br />
                    <button type="button" class="btn btn-default btn-lg btn-danger" style="width: 150px; margin: 5px;">Logout</button>

                </div>

                <div class="col-md-4">

                </div>
            </div>
        </div>

        <div id="postModal" class="modal fade" role="dialog">
            <div class="modal-dialog modal-lg">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                    </div>

                    <div class="modal-body">

                        <table class="table">
                            <tr>
                                <th><input onclick="javascript:radioCheck();" type="radio" name="radioPost" id="radioPostList" checked>List Posts</th>
                                <th><input onclick="javascript:radioCheck();" type="radio" name="radioPost" id="radioPostAdd">Add Post</th>
                            </tr>
                        </table>

                        <div id="modalPostList" style="display: block;">
                            <table class="table table-bordered">

                            </table>
                        </div>

                        <div id="modalPostAdd" style="display: none;">
                            <table class="table table-bordered">

                            </table>

                            <button id="add-post-button" class="btn btn-default">Add Post</button>
                        </div>
                    </div>

                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                    </div>
                </div>
            </div>
        </div>

        <div id="pageModal" class="modal fade" role="dialog">
            <div class="modal-dialog modal-lg">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                    </div>

                    <div class="modal-body">

                        <table class="table">
                            <tr>
                                <th><input onclick="javascript:radioCheck();" type="radio" name="radioPage" id="radioPageList" checked>List Pages</th>
                                <th><input onclick="javascript:radioCheck();" type="radio" name="radioPage" id="radioPageAdd">Add Page</th>
                            </tr>
                        </table>

                        <div id="modalPageList" style="display: block;">
                            <table class="table table-bordered">

                            </table>
                        </div>

                        <div id="modalPageAdd" style="display: none; ">
                            <table class="table table-bordered">
                                <form id="create-page-form" class="form-horizontal" action="${pageContext.request.contextPath}/page" method="post">

                                        <div class="form-group">
                                            <label class="col-md-2 control-label" for="title">Title: </label>  
                                            <div class="col-md-10">
                                                <input id="pageAddTitle" name="title" type="text" placeholder="Enter Title" class="form-control input-md" required="">
                                            </div>
                                        </div>

                                        <!-- Textarea -->
                                        <div class="form-group">
                                            <label class="col-md-2 control-label" for="content">Content:</label>
                                            <div class="col-md-10">                     
                                                <textarea class="form-control tmce" id="pageAddContent" name="content" rows="150" cols="300" placeholder="Enter content"></textarea>
                                            </div>
                                        </div>

                                        
                                        <input type="submit" id="add-page-button" class="btn btn-default">
                                </form>
                            </table>

                            
                        </div>
                    </div>

                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                    </div>
                </div>
            </div>
        </div>

        <div id="categoryModal" class="modal fade" role="dialog">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                    </div>

                    <div class="modal-body">

                        <table class="table">
                            <tr>
                                <th><input onclick="javascript:radioCheck();" type="radio" name="radioCategory" id="radioCategoryList" checked>List Categories</th>
                                <th><input onclick="javascript:radioCheck();" type="radio" name="radioCategory" id="radioCategoryAdd">Add Category</th>
                            </tr>
                        </table>

                        <div id="modalCategoryList" style="display: block;">
                            <table class="table table-bordered">

                            </table>
                        </div>

                        <div id="modalCategoryAdd" style="display: none;">
                            <table class="table table-bordered">

                            </table>

                            <button id="add-category-button" class="btn btn-default">Add Post</button>
                        </div>
                    </div>

                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                    </div>
                </div>
            </div>
        </div>

        <div id="userModal" class="modal fade" role="dialog">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                    </div>

                    <div class="modal-body">

                        <table class="table">
                            <tr>
                                <th><input onclick="javascript:radioCheck();" type="radio" name="radioUser" id="radioUserList" checked>List Users</th>
                                <th><input onclick="javascript:radioCheck();" type="radio" name="radioUser" id="radioUserAdd">Add User</th>
                            </tr>
                        </table>

                        <div id="modalUserList" style="display: block;">
                            <table class="table table-bordered">

                            </table>
                        </div>

                        <div id="modalUserAdd" style="display: none;">
                            <table class="table table-bordered">

                            </table>

                            <button id="add-post-button" class="btn btn-default">Add Post</button>
                        </div>
                    </div>

                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                    </div>
                </div>
            </div>
        </div>



        <script type="text/javascript">
            var contextRoot = "${pageContext.request.contextPath}";
        </script>

        <script type="text/javascript">
            function showPostModal() {
                $('#postModal').modal('show');
            }
            function showPageModal() {
                $('#pageModal').modal('show');
                
            }
            function showCategoryModal() {
                $('#categoryModal').modal('show');
            }
            function showUserModal() {
                $('#userModal').modal('show');
            }
        </script>

        <script type="text/javascript">
            function radioCheck() {
                if (document.getElementById('radioPostList').checked) {
                    document.getElementById('modalPostList').style.display = 'block';
                    document.getElementById('modalPostAdd').style.display = 'none';
                } else {
                    document.getElementById('modalPostAdd').style.display = 'block';
                    document.getElementById('modalPostList').style.display = 'none';
                }

                if (document.getElementById('radioPageList').checked) {
                    document.getElementById('modalPageList').style.display = 'block';
                    document.getElementById('modalPageAdd').style.display = 'none';
                } else {
                    document.getElementById('modalPageAdd').style.display = 'block';
                    document.getElementById('modalPageList').style.display = 'none';
                }

                if (document.getElementById('radioCategoryList').checked) {
                    document.getElementById('modalCategoryList').style.display = 'block';
                    document.getElementById('modalCategoryAdd').style.display = 'none';
                } else {
                    document.getElementById('modalCategoryAdd').style.display = 'block';
                    document.getElementById('modalCategoryList').style.display = 'none';
                }

                if (document.getElementById('radioUserList').checked) {
                    document.getElementById('modalUserList').style.display = 'block';
                    document.getElementById('modalUserAdd').style.display = 'none';
                } else {
                    document.getElementById('modalUserAdd').style.display = 'block';
                    document.getElementById('modalUserList').style.display = 'none';
                }
            }
        </script>


        <script src="${pageContext.request.contextPath}/js/jquery-1.12.1.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/app.js"></script>
        <script src="${pageContext.request.contextPath}/tinymce/tinymce.min.js" type="text/javascript"></script>
        <script type="text/javascript">
            tinymce.init({
                selector: '.tmce',
                plugins: 'image'
            });
        </script>

    </body>
</html>
