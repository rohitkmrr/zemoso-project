$(document).ready(function () {

$('#add_note').bind("mouseover", function(){
           var color  = $(this).css("background-color");
           $(this).css("background", "#380606");
           $(this).bind("mouseout", function(){
               $(this).css("background", color);
           })    
       }) 

 $('#add_note').bind("click", function(){
           $('#modal-container-261772').modal('show');
            
       }) 
})