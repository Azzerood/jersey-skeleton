var fichesEnfants =[];
var id = 1;
/*REQUETE POUR TEST L'AFFICHAGE/SAUVEGARDE
insert into parents(nomEnfant,prenomEnfant , nomA , prenomA, dateNaissanceA, adresseA,congesA , professionA , numeroCafA , categorieCafA ,numeroA ,nomB , prenomB, dateNaissanceB , adresseB ,congesB, professionB, numeroCafB , categorieCafB ,numeroB , dureeContrat, typeContrat) values("Pekin","Camille","Pekin","Lu","1985-03-25","4 rue des legendes","pas de conges","policier","1543458547","A","0612345678","Pekin","Lucy","1985-06-20","4 rue des legendes","20 septrembre au 1 octobre","Documentaliste","54143443548738","0687654321","A","4 mois","5jours semaine");

 */
jQuery.extend({
	getEnfants: function(url){
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

function loadEnfant(){
	fichesEnfants = $.getEnfants("v1/enfant")
}

function refreshChamps(){
	var par = fichesEnfants[id];
	if(par !== undefined){
		$("#photo").val(par.photo) ;
		$("#nom").val(par.nom) ;
		$("#prenom").val(par.prenom);
		$("#datenaissance").val(par.dateNaissance);
		$("#adresse").val(par.adresse);
		$("#taccueil").val(par.tempsAccueil);
		$("#périodeadap").val(par.periodeAdaptation);
		$("#allergie").val(par.allergies);
		$("#pers1").val(par.personne);
		$("#traitement").val(par.traitements) ;
		$("#nurgence").val(par.numeroUrgence);
		$("#nmed").val(par.numeroMedecin);
	}else{
		$("#photo").val("");
		$("#nom").val("");
		$("#prenom").val("");
		$("#datenaissance").val("");
		$("#adresse").val("");
		$("#taccueil").val("");
		$("#périodeadap").val("");
		$("#allergie").val("");
		$("#pers1").val("");
		$("#traitement").val("");
		$("#nurgence").val("");
		$("#nmed").val("");
	}
}   

function decrementerIdEnfant(){
	if(id>1){
		id -=1;
	}
	$("#idEnfant").text(id);
	refreshChamps();
}
function incrementerIdEnfant(){
	console.log("fiche enfant");
	if(fichesEnfants != null && id<= fichesEnfants.length  ){
		id +=1;
	}
	$("#idEnfant").text(id);
	refreshChamps();
}


