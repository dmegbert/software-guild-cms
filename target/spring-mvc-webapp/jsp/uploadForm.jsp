<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <script src="${pageContext.request.contextPath}/js/jquery-1.12.1.min.js"></script>
        <link href="${pageContext.request.contextPath}/css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap-filestyle.js" type="text/javascript"></script>
        <script src="${pageContext.request.contextPath}/tinymce/tinymce.min.js" type="text/javascript"></script>
        
        <script>
            tinymce.init({
                selector: '#content',
                height: 500,
                toolbar: 'imageButton | undo redo | styleselect | bold italic | strikethrough | alignleft | aligncenter | alignright | indent | outdent | bullist | numlist',
                setup: function (editor) {
                    editor.addButton('imageButton', {
                        text: 'Add an Image',
                        icon: false,
                        onclick: function () {
                            $(uploadModal).modal('show');
                        }
                    });
                },
                content_css: [
                    '//fast.fonts.net/cssapi/e6dc9b99-64fe-4292-ad98-6974f93cd2a2.css',
                    '//www.tinymce.com/css/codepen.min.css'
                ]
            });
        </script>
        <!--END TINYMC-->

        <title>File Upload Page</title>
    </head>
    <body>
        <div class="container">
            <jsp:include page="/jsp/navbar.jsp" />
            <div class="row">


                <div class="col-md-4">
                    <a data-toggle="modal" data-target="#showImageModal">See Images Uploaded</a></td>
                </div>
                <div class="col-md-8">
                    <div class="fileinput fileinput-new">
                        <h3>Upload a File</h3>
                        <p>
                            <textarea id="content"></textarea>
                        </p>
                    </div>
                </div>

            </div>
            <!-- Modal -->
            <div id="uploadModal" class="modal fade" role="dialog" data-backdrop="false">
                <div class="modal-dialog">

                    <!-- Modal content-->
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal">&times;</button>
                            <h4 class="modal-title">Upload Files</h4>
                        </div>
                        <div class="modal-body">
                            <div class="fileinput fileinput-new">
                                <h3>Upload a File</h3>
                                <form method="post" id="upload-form" name="upload-form" action="${pageContext.request.contextPath}/upload" enctype="multipart/form-data" class="form-horizontal">
                                    <input type="file" class="filestyle" name="file" data-input="false">
                                    <br />
                                    <input type="submit" value="Upload" class="btn btn-default btn-file" style="margin-top: 15px;"/>
                                </form>

                            </div>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                        </div>
                    </div>

                </div>
            </div> 
            <div id="showImageModal" class="modal fade" role="dialog" data-backdrop="false">
                <div class="modal-dialog modal-lg">

                    <!-- Modal content-->
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal">&times;</button>
                            <h4 class="modal-title">Upload Files</h4>
                        </div>
                        <table class="table table-hover">
                        <tbody>
                            <c:forEach items="${files}" var="file">
                                <tr id="file-id-${file.id}">
                                    <td><img src="${pageContext.request.contextPath}/upload/showImage/${file.id}" style="height: 20%;">
                                        <p style="margin-top: 10px;">
                                            <a data-image-id="${file.id}" class="delete-link" style="cursor:pointer;">delete <span class="glyphicon glyphicon-remove"></a>
                                        </p>
                                    </td>
                                </tr>
                            </c:forEach> 
                        </tbody>
                    </table>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                        </div>
                    </div>

                </div>
            </div>
            <script type="text/javascript">

                var contextRoot = '${pageContext.request.contextPath}';
            </script>

            <script src="${pageContext.request.contextPath}/js/app-upload.js" type="text/javascript"></script>
    </body>
</html>