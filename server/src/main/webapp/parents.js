var fichesParents =[];
var id = 1;

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
    if(fichesParents = null){
        fichesParents = [];
    }
}
function saveParents(){
        var nomEnfant =$("#nomEnfant").val() ;
    console.log(nomEnfant);
        var prenomEnfant =$("#prenomEnfant").val() ;
        var nomA = $("#nomA").val();
        var prenomA = $("#prenomA").val();
        var dateNaissanceA = $("#dateNaissanceA").val();
        var adresseA = $("#adresseA").val();
        var congesA = $("#congesA").val();
        var professionA = $("#professionA").val();
        var numeroCafA = $("#numeroCafA").val();
        var categorieCafA =$("#categorieCafA").val() ;
        var nomB = $("#nomB").val();
        var prenomB = $("#prenomB").val();
        var dateNaissanceB = $("#dateNaissanceB").val();
        var adresseB = $("#adresseB").val();
        var congesB = $("#congesB").val();
        var professionB = $("#professionB").val();
        var numeroCafB = $("#numeroCafB").val();
        var categorieCafB =$("#categorieCafB").val() ;
        var dureeContrat = $("#dureeContrat").val();
        var typeContrat = $("#typeContrat").val();
    
        if( fichesParents == null || id ==fichesParents.length ){
             $.ajax({
            type : 'POST',
            contentType : 'application/json',
            url: "v1/parent/",
            dataType: 'json',
            async:false,
            data : JSON.stringify({
            "nomEnfant":nomEnfant,
            "prenomEnfant":prenomEnfant,
            "nomA" : nomA,
            "prenomA" :prenomA,
            "dateNaissanceA" : dateNaissanceA,
            "adresseA" : adresseA,
            "congesA" : congesA,
            "professionA" :professionA ,
            "numeroCafA" : numeroCafA,
            "categorieCafA" : categorieCafA,
            "nomB" : nomB,
            "prenomB" :prenomB,
            "dateNaissanceB" : dateNaissanceB,
            "adresseB" : adresseB,
            "congesB" : congesB,
            "professionB" :professionB ,
            "numeroCafB" : numeroCafB,
            "categorieCafB" : categorieCafB,
            "dureeContrat" : dureeContrat,
            "typeContrat" : typeContrat,
		}),
            success: function(data, textStatus, jqXHR) {
               console.log(data);	
            },
            error : function(jqXHR, textStatus, errorThrown) {
			 console.log("error post fiche: " + textStatus);
            }
        });
        }else{
            $.ajax({
            type : 'POST',
            contentType : 'application/json',
            url: "v1/parent/"+id,
            dataType: 'json',
            async:false,
            data : JSON.stringify({
            "nomEnfant":nomEnfant,
            "prenomEnfant":prenomEnfant,
            "nomA" : nomA,
            "prenomA" :prenomA,
            "dateNaissanceA" : dateNaissanceA,
            "adresseA" : adresseA,
            "congesA" : congesA,
            "professionA" :professionA ,
            "numeroCafA" : numeroCafA,
            "categorieCafA" : categorieCafA,
            "nomB" : nomB,
            "prenomB" :prenomB,
            "dateNaissanceB" : dateNaissanceB,
            "adresseB" : adresseB,
            "congesB" : congesB,
            "professionB" :professionB ,
            "numeroCafB" : numeroCafB,
            "categorieCafB" : categorieCafB,
            "dureeContrat" : dureeContrat,
            "typeContrat" : typeContrat,
		}),
            success: function(data, textStatus, jqXHR) {
               console.log(data);	
            },
            error : function(jqXHR, textStatus, errorThrown) {
			 console.log("error post fiche: " + textStatus);
            }
        });
        }
       
        loadParents();
       
}
function decrementerIdParent(){
    if(id>1){
        id -=1;
    }
    console.log("(-)id:"+id);
}
function incrementerIdParent(){
    if(fichesParents != null && id < fichesParents.length){
        id +=1;
    }
    console.log("(+)id:"+id);
}

    
