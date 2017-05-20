<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script language="javascript" type="text/javascript">
            var fileName = ${fileName};
            var result = ${result};
            var resultCode = ${resultCode};
            window.parent.window.jbImagesDialog.uploadFinish({
                filename: fileName,
                result: result,
                resultCode: resultCode
            });
        </script>
    </head>
    <body>
    </body>
</html>
