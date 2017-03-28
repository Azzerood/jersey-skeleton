var fichesSalarie = [];
var id = 1;

jQuery.extend({
	getSalaries : function(url) {
		var result = null;
		$.ajax({
			url : url,
			type : 'GET',
			contentType : 'application/json',
			dataType : 'json',
			async : false,
			success : function(data, textStatus, jqXHR) {
				result = data;
				console.log("----data---");
				console.log(data);
				console.log("----data---");
			},
			error : function(jqXHR, textStatus, errorThrown) {
				console.log("error get planning by date and status: "
						+ textStatus);
			}
		});
		return result;
	}
})

function loadSalaries() {
	ficheSalarie = $.getSalaries("v1/salaries")
}

function refreshChamps() {
	var par = fichesParents[id];
	if (par !== undefined) {
		$("#nom").val(par.nomEnfant);
	} else {
		$("#nom").val("");
	}
}

function saveSalarie() {
	var nom = $("#nom").val();
	console.log("nom du salarie: " + nomEnfant);
	var prenom = $("#prenom").val();
	var dateNaissance = $("#dateNaissance").val();
	var adresse = $("#adresse").val();
	var codePostal = $("#cp").val();
	var nationalite = $("#nationalite").val();
	var etatCivil = $("#etatcivil").val();
	var nbEnfant = $("#nbEnfant").val();
	var numeroSecu = $("#numSecu").val();
	
	
	if (fichesParents == null || id == fichesParents.length) {
		$.ajax({
			type : 'POST',
			contentType : 'application/json',
			url : "v1/parent/" + id,
			dataType : 'json',
			async : false,
			data : JSON.stringify({
				"id" : id,
				"nom" : nom,
				"prenom" : prenom,
				"nationnalite" : nationnalite,
				"dateNaissance" : dateNaissance,
				"adresse" : adresse,
				"departement" : departement,
				"typeContrat" : typeContrat,
				"tempsContrat" : tempsContrat,
				"debutContrat" : debutContrat,
				"finContrat" : finContrat,
				"renumeration" : renumeration,
				"numeroSecu" : numeroSecu,
			}),
			success : function(data, textStatus, jqXHR) {
				console.log(data);
			},
			error : function(jqXHR, textStatus, errorThrown) {
				console.log("error post fiche: " + textStatus);
			}
		});
	} else {
		$.ajax({
			type : 'POST',
			contentType : 'application/json',
			url : "v1/parent/" + id,
			dataType : 'json',
			async : false,
			data : JSON.stringify({
				"id" : id,
				"nom" : nom,
				"prenom" : prenom,
				"nationnalite" : nationnalite,
				"dateNaissance" : dateNaissance,
				"adresse" : adresse,
				"departement" : departement,
				"typeContrat" : typeContrat,
				"tempsContrat" : tempsContrat,
				"debutContrat" : debutContrat,
				"finContrat" : finContrat,
				"renumeration" : renumeration,
				"numeroSecu" : numeroSecu,
			}),
			success : function(data, textStatus, jqXHR) {
				console.log("post réussi ");
			},
			error : function(jqXHR, textStatus, errorThrown) {
				console.log("error post fiche: " + textStatus);
			}
		});
	}

	loadSalaries();

}
function decrementerIdSalarie() {
	if (id > 1) {
		id -= 1;
	}
	$("#idSalarie").text(id);
	refreshChamps();
}
function incrementerIdParent() {
	console.log("fiche salaries");
	console.log(fichesSalarie);
	if (ficheSalarie != null && id <= ficheSalarie.length) {
		id += 1;
	}
	$("#idSalarie").text(id);
	refreshChamps();
}
