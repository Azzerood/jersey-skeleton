var fichesParents =[];
var id = 1;
/*REQUETE POUR TEST L'AFFICHAGE/SAUVEGARDE
insert into parents(nomEnfant,prenomEnfant , nomA , prenomA, dateNaissanceA, adresseA,congesA , professionA , numeroCafA , categorieCafA ,numeroA ,nomB , prenomB, dateNaissanceB , adresseB ,congesB, professionB, numeroCafB , categorieCafB ,numeroB , dureeContrat, typeContrat) values("Pekin","Camille","Pekin","Lu","1985-03-25","4 rue des legendes","pas de conges","policier","1543458547","A","0612345678","Pekin","Lucy","1985-06-20","4 rue des legendes","20 septrembre au 1 octobre","Documentaliste","54143443548738","0687654321","A","4 mois","5jours semaine");

*/
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

function refreshChamps(){
    var par = fichesParents[id];
    if(par !== undefined){
        $("#nomEnfant").val(par.nomEnfant) ;
        $("#prenomEnfant").val(par.prenomEnfant) ;
        $("#nomA").val(par.nomA);
        $("#prenomA").val(par.prenomA);
        $("#dateNaissanceA").val(par.dateNaissanceA);
        $("#adresseA").val(par.adresseA);
        $("#congesA").val(par.congesA);
        $("#professionA").val(par.professionA);
        $("#numeroA").val(par.numeroA);
        $("#numeroCafA").val(par.numeroCafA);
        $("#categorieCafA").val(par.categorieCafA) ;
        $("#nomB").val(par.nomB);
        $("#prenomB").val(par.prenomB);
        $("#dateNaissanceB").val(par.dateNaissanceB);
        $("#adresseB").val(par.adresseB);
        $("#congesB").val(par.congesB);
        $("#professionB").val(par.professionB);
        $("#numeroB").val(par.numeroB);
        $("#numeroCafB").val(par.numeroCafB);
        $("#categorieCafB").val(par.categorieCafB) ;
        $("#dureeContrat").val(par.dureeContrat);
        $("#typeContrat").val(par.typeContrat);
    }else{
        $("#nomEnfant").val("") ;
        $("#prenomEnfant").val("") ;
        $("#nomA").val("");
        $("#prenomA").val("");
        $("#dateNaissanceA").val("");
        $("#adresseA").val("");
        $("#congesA").val("");
        $("#professionA").val("");
        $("#numeroCafA").val("");
        $("#categorieCafA").val("") ;
        $("#nomB").val("");
        $("#prenomB").val("");
        $("#dateNaissanceB").val("");
        $("#adresseB").val("");
        $("#congesB").val("");
        $("#professionB").val("");
        $("#numeroCafB").val("");
        $("#categorieCafB").val("") ;
        $("#dureeContrat").val("");
        $("#typeContrat").val("");
    }
}   

function saveParents(){
        var nomEnfant =$("#nomEnfant").val() ;
    console.log("nom de l'enfant: "+nomEnfant);
        var prenomEnfant =$("#prenomEnfant").val() ;
        var nomA = $("#nomA").val();
        var prenomA = $("#prenomA").val();
        var dateNaissanceA = $("#dateNaissanceA").val();
        var adresseA = $("#adresseA").val();
        var congesA = $("#congesA").val();
        var professionA = $("#professionA").val();
        var numeroA = $("#numeroA").val();
        var numeroCafA = $("#numeroCafA").val();
        var categorieCafA =$("#categorieCafA").val() ;
        var nomB = $("#nomB").val();
        var prenomB = $("#prenomB").val();
        var dateNaissanceB = $("#dateNaissanceB").val();
        var adresseB = $("#adresseB").val();
        var congesB = $("#congesB").val();
        var professionB = $("#professionB").val();
        var numeroB = $("#numeroB").val();
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
            "id":id,
            "nomEnfant":nomEnfant,
            "prenomEnfant":prenomEnfant,
            "nomA" : nomA,
            "prenomA" :prenomA,
            "dateNaissanceA" : dateNaissanceA,
            "adresseA" : adresseA,
            "congesA" : congesA,
            "numeroA":numeroA,
            "professionA" :professionA ,
            "numeroCafA" : numeroCafA,
            "categorieCafA" : categorieCafA,
            "nomB" : nomB,
            "prenomB" :prenomB,
            "dateNaissanceB" : dateNaissanceB,
            "adresseB" : adresseB,
            "congesB" : congesB,
            "professionB" :professionB ,
            "numeroB": numeroB,
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
                "id":id,
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
               console.log("post réussi ");	
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
     $("#idParent").text(id);
   refreshChamps();
}
function incrementerIdParent(){
       console.log("fiche parents");
    console.log(fichesParents);
    if(fichesParents != null && id<= fichesParents.length  ){
        id +=1;
    }
    $("#idParent").text(id);
    refreshChamps();
}

    
