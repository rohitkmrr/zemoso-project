$(function() {
    var $title= $('.form-control');
    var $description= $('#comment');
    
   $('.save_button').on('click', function()
   {
       var order = {
           title= $title.val();
           description= $description.val();
       };
       
       $.ajax({
           type:'POST',
           url: '/localh'
       })
   }) 
    
});