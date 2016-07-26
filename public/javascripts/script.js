$(document).ready(function () {



 $('#add_note').bind("click", function(){
           $('#modal-container-261772').modal('show');
    
  });
  
  $('#note_submit').bind("click", function(){
      var title = $('#modal-container-261772').find('#note_title').val();
      var description = $('#modal-container-261772').find('#note_description').val();
      console.log(title + description + "batman");
      var note_data = {
           title:  title,
           description: description
      };
      
      $.ajax({
          type : 'POST',
          url : '/addNote',
          data : note_data,
          dataType: "json",
          success : function() {
              $('#modal-container-261772').modal('hide');
          },
          error : function() {
             $('#modal-container-261772').modal('hide');
          }
      });
      
  });
   $('#update_note').bind("click", function(){
      var title = $('#modal-container-261773').find('#note_title').val();
      var description = $('#modal-container-261773').find('#note_description').val();
      var note_id = $("[name='note_id']").val();
      var note_data = {
           title:  title,
           description: description,
           note_id : note_id
           
      };
      
      $.ajax({
          type : 'POST',
          url : '/updateNote',
          data : note_data,
          dataType: "json",
          success : function() {
              $('#modal-container-261773').modal('hide');
          },
          error : function() {
             $('#modal-container-261773').modal('hide');
          }
      });
      
  });
  
  $('.note_class').bind("click", function(){
     // console.log($(this).html());
     // console.log($(this).find("h2").html());
      var title = $(this).find("h2").html();
      var note_id = $(this).attr('id');
      console.log(note_id);
      var description = $(this).find("p").html();
      $('#modal-container-261773').find('#note_title').val(title);
      $('#modal-container-261773').find('#note_description').val(description);
        $('#modal-container-261773').find("[name='note_id']").val(note_id);
       $('#modal-container-261773').modal('show');
  })
  
  
  
        //  $("[name='note_id']").hover(function(){
        //  $('.reminder_logo').fadeToggle();
        // });
       
        

 
 });