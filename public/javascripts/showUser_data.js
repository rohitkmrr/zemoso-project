$(function () {
    
    var $orders= $('show_data_id');
    
    $.ajax({
    type: 'GET',
    url: 'http://localhost/9000/user', 
    success: function(orders) {
        $.each(orders, function(i,order){
            $orders.append('<li> Id: '+order.id + 'name: '+ order.username +' Password: '+order.password +'email id: '+order.email+ '</li>');
        });
    }
    
});

});