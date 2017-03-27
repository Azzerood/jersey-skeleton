var fichesParents =[];

jQuery.extend({
    getParents: function(url){
        var result = null;
        $.ajax({
            url: url,
            type: 'GET',
            contentType : 'application/json',
            dataType: 'json',
            async:false,
            success: function(data, textStatus, jqXHR) {
                result = data;
                console.log("----data---");
                console.log(data);
                console.log("----data---");
            },
            error : function(jqXHR, textStatus, errorThrown) {
			     console.log("error get planning by date and status: " + textStatus);
            }
        });
       return result;
    }
})

function loadParents(){
    fichesParents = $.getParents("v1/parent")
}