$(document).ready(function() {



$('#get').click(function (event) {
    
    console.log("get books")
  $.ajax({
    // The URL for the request
    url: "/books",
    // The data to send (will be converted to a query string)
    /*data: {
        id: 123
    },
    */
    // Whether this is a POST/GET/UPDATE/DELETE request
    type: "GET",
    // The type of data we expect back
    dataType : "json",
    // Code to run if the request succeeds;
    // the response is passed to the function
    success: function( json ) {
        JSON.stringify(json);
       
        var output = $("#output");
         $("<h1>").text("Livres :").appendTo(output);
        for(var i = 0 ; i < json.length ; i++){
          $("<h4>").html("-["+json[i].id+"] "+json[i].title +" "+json[i].author).appendTo(output);   
        }
        $( "<div class=\"content\">").html(json.html).appendTo( "body" );
       
    },
    // Code to run if the request fails; the raw request and
    // status codes are passed to the function
    error: function( xhr, status, errorThrown ) {
        alert( "Sorry, there was a problem!" );
        console.log( "Error: " + errorThrown );
        console.log( "Status: " + status );
        console.dir( xhr );
    },
    // Code to run regardless of success or failure
    complete: function( xhr, status ) {
        console.log( "The request is complete!" );
    }
  });
});
    
$('#create').click(function(event) {
                 
  $.ajax({
    // The URL for the request
    url:"books",
    data: {
        author : $('#insertTitre').val(),
        title : $('#insertAuteur').val()
        
    },
    // Whether this is a POST/GET/UPDATE/DELETE request
    type:"POST",
    // The type of data we expect back
    dataType:"json",
    // Code to run if the request succeeds;
    // the response is passed to the function
    success: function(json) {
        //OK
    },
    // Code to run if the request fails; the raw request and
    // status codes are passed to the function
    error: function( xhr, status, errorThrown ) {
        alert( "Sorry, there was a problem!" );
        console.log( "Error: " + errorThrown );
        console.log( "Status: " + status );
        console.dir( xhr );
    },
    // Code to run regardless of success or failure
    complete: function( xhr, status ) {
        console.log("complete");
    }
  });
});
    
$('#DELETE').click(function(event) {
   var tmp;
    tmp = $('#deleteId').val();
    console.log(tmp);
  $.ajax({
   url:"books/"+tmp,
    // Whether this is a POST/GET/UPDATE/DELETE request
    type:"DELETE",
    // The type of data we expect back
    dataType:"json",
    success: function(json) {
        //OK
    },
    // Code to run if the request fails; the raw request and
    // status codes are passed to the function
    error: function( xhr, status, errorThrown ) {
        alert( "Sorry, there was a problem!" );
        console.log( "Error: " + errorThrown );
        console.log( "Status: " + status );
        console.dir( xhr );
    },
    // Code to run regardless of success or failure
    complete: function( xhr, status ) {
        console.log("complete");
    }
  });
});
}); // end document.ready