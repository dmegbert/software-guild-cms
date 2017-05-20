
//POST SUBMIT
$(document).ready(function () {

    $.ajax({
        type: 'GET',
        url: contextRoot + "/post/select",
        dataType: 'json',
        beforeSend: function (xhr) {
            xhr.setRequestHeader("Accept", "application/json");
        }
    }).success(function (tagCats, status) {
        $('#categoryId').append('<option></option>');
        $('#tags').append('<option></option>');
        $.each(tagCats.tags, function (index, tag) {
            $('#tags').append('<option value="' + tag.name + '">' + tag.name + '</option>');



        });
        $.each(tagCats.category, function (index, category) {
            $('#categoryId').append('<option value="' + category.id + '">' + category.name + '</option>');
        });

    });
});


$(document).on('submit', '#add-form', function (e) {

    e.preventDefault();
        
    $('#add-errors').empty();

    var postData = JSON.stringify({
        title: $('#title').val(),
        content: $('#content').val(),
        categoryId: $('#categoryId').val(),
        tags: $('#tags').val(),
        published: $('#published').val(),
        expiration: $('#expiration').val()
    });

    $.ajax({
           type:'POST',
           url:contextRoot + '/post',
        data: postData,
        dataType: 'json',
           beforeSend: function(xhr) {
            xhr.setRequestHeader("Accept", "application/json");
            xhr.setRequestHeader("Content-type", "application/json");
        }
        }).success(function(data, status){

        $('#title').val('');
        $('#content').val('');
        $('#categoryId').val('');
        $('#tags').val('');
        $('#published').val('');
        $('#expiration').val('');

           
    }).error(function (data, status) {

        var errors = data.responseJSON.errors;

            $.each(errors, function(index, validationError) {
               $('#add-errors-'+ validationError.fieldName).append(validationError.message); 
        });

    });

});//END POST SUBMIT


$(document).on('submit', '#update-form', function (e) {

    e.preventDefault();
    $('#add-errors').empty();

    var postData = JSON.stringify({
        id: $('#id').val(),
        title: $('#title').val(),
        content: $('#content').val(),
        categoryId: $('#categoryId').val(),
        tags: $('#tags').val(),
        published: $('#published').val(),
        expiration: $('#expiration').val()
    });

    $.ajax({
        type: 'PUT',
        url: contextRoot + '/post',
        data: postData,
        dataType: 'json',
        beforeSend: function (xhr) {
            xhr.setRequestHeader("Accept", "application/json");
            xhr.setRequestHeader("Content-type", "application/json");
        }
    }).success(function (data, status) {
        $('#id').val('');
        $('#title').val('');
        $('#content').val('');
        $('#categoryId').val('');
        $('#tags').val('');
        $('#published').val('');
        $('#expiration').val('');

     }).error(function (data, status) {

        var errors = data.responseJSON.errors;

            $.each(errors, function(index, validationError) {
               $('#add-errors-'+ validationError.fieldName).append(validationError.message); 
});
     });
     });
//END POST UPDATE

//NEW PAGE SUBMIT
$(document).ready(function () {

    $(document).on('submit', '#new-page-form', function (e) {

        e.preventDefault();
        console.log("got here!");

        var pageData = JSON.stringify({
            title: $('#pageAddTitle').val(),
            content: $('#pageAddContent').val()
        });

        $.ajax({
            type: 'POST',
            url: contextRoot + "/page",
            data: pageData,
            dataType: 'json',
            beforeSend: function (xhr) {
                xhr.setRequestHeader("Accept", "application/json");
                xhr.setRequestHeader("Content-type", "application/json");
            }
        }).success(function (data, status) {
            $('#pageAddTitle').val('');
            console.log("Title Cleared");
            $('#pageAddContent').val('');
            console.log("Content Cleared");
            console.log("Done. Worked");

        }).error(function (data, status) {
            console.log("didn't work :( ");
            var errors = data.responseJSON.errors;

            $.each(errors, function (index, validationError) {
                $('#' + validationError.fieldName + '-adderror').replaceWith(validationError.message);
                
            });


        });

    });


});//END NEW PAGE SUBMIT

//ADMIN PAGE FEATURES
$(document).ready(function () {



    $(document).on('submit', '#create-page-form', function (e) {

        e.preventDefault();

        var pageData = JSON.stringify({
            title: $('#pageAddTitle').val(),
            content: $('#pageAddContent').val()
        });

        $.ajax({
            type: 'POST',
            url: contextRoot + "/page",
            data: pageData,
            dataType: 'json',
            beforeSend: function (xhr) {
                xhr.setRequestHeader("Accept", "application/json");
                xhr.setRequestHeader("Content-type", "application/json");
            }
        }).success(function (data, status) {

            $('#radioPageList').prop("checked", true);
            radioCheck();

        }).error(function (data, status) {
            console.log("didn't work :( ");
            var errors = data.responseJSON.errors;


            $.each(errors, function (index, validationError) {
                $('#add-errors-' + validationError.fieldName).append(validationError.message);

            });
        });

    });

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

});//END ADMIN
