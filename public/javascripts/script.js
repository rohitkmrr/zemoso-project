$(document).ready(function () {



 $('#add_note').bind("click", function(){
           $('#modal-container-261772').modal('show');
           $('#modal-container-261772').find('#note_title').html("<br>");
           $('#modal-container-261772').find('#note_description').html("<br>");
           
           
    
  });
  
  $('#note_submit').bind("click", function(){
      var title = $('#modal-container-261772').find('#note_title').html();
      var description = $('#modal-container-261772').find('#note_description').html();
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
      var title = $('#modal-container-261773').find('#note_title').html();
      var description = $('#modal-container-261773').find('#note_description').html();
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
      var title = $(this).find("#note_title").html();
      var note_id = $(this).attr('id');
     // console.log(note_id);
      var description = $(this).find("#note_description").html();
    // console.log(title + " srovn joewv" + description);
      $('#modal-container-261773').find('#note_title').html(title);
      $('#modal-container-261773').find('#note_description').html(description);
        $('#modal-container-261773').find("[name='note_id']").val(note_id);
       $('#modal-container-261773').modal('show');
  })
  
  
    $('.delete_logo').bind("click", function(){
     
	  var note_id = $(this).attr("id");
      //console.log("deletreeeeeeeeeeeeeeeeeeeeeeeeeeeeeee" + note_id);
      var note_data = {
           note_id : note_id
      };
      
      $.ajax({
          type : 'POST',
          url : '/deleteNote',
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
  
   $('.archive_logo').bind("click", function(){
     
	  var note_id = $(this).attr("id");
      console.log("deletreeeeeeeeeeeeeeeeeeeeeeeeeeeeeee" + note_id);
      var note_data = {
           note_id : note_id
      };
      
      $.ajax({
          type : 'POST',
          url : '/archiveNote',
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
        //  $("[name='note_id']").hover(function(){
        //  $('.reminder_logo').fadeToggle();
        // });
       
        

 
 });