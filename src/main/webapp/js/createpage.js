//PAGE SUBMIT
$(document).ready(function() {
   
   
   
   $(document).on('submit', '#create-page-form' , function(e) {
       
       e.preventDefault();
       console.log("got here!");
       
       var pageData = JSON.stringify({
           title: $('#title').val(),
           content: $('#content').val()
       });

       $.ajax({
           type: 'POST',
           url: contextRoot + "/page",
           data: pageData,
           dataType: 'json',
           beforeSend: function(xhr) {
               xhr.setRequestHeader("Accept", "application/json");
               xhr.setRequestHeader("Content-type", "application/json");
           }
       }).success(function(data, status) {
           console.log("Worked!");
           
       }).error(function(data, status) {
           console.log("didn't work :( ");
           var errors = data.responseJSON.errors;
           
           $.each(errors, function(index, validationError) {
              
               $('#add-contact-validation-errors').append(validationError.fieldName + ": " + validationError.message).append("<br />");
               
           });

       });

  });
  
   });//END PAGE SUBMIT
