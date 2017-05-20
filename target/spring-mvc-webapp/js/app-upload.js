
$(document).ready(function () {


    $(document).on('submit', '#upload-form', function (e) {

        e.preventDefault();

        var data = new FormData(this);
        
        $.ajax({
            type: 'POST',
            url: contextRoot + "/upload",
            data: data,
            cache: false,
            contentType: false,
            processData: false,
            beforeSend: function (xhr) {
                xhr.setRequestHeader("Accept", "application/json");
            }
        }).success(function (data, status) {
            
            $('#uploadModal').modal('hide');
            
            var imagePara = "<img src='" + contextRoot + "/upload/showImage/" + data.id + "'>";
            
            tinymce.EditorManager.activeEditor.insertContent(imagePara);
            
            


        });

    });
    
    $(document).on('click', '.delete-link', function(e)   {
        
        e.preventDefault();
        
        var imageId = $(e.target).data('image-id');
        
        $.ajax({
            type: 'DELETE',
            url: contextRoot +"/upload/" + imageId
        }).success(function(data, status)   {
            $('#file-id-' + imageId).remove();
        });
        
    });

});

