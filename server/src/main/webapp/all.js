function connection(login, mdp) {
	$.ajax({
		type : 'GET',
		contentType : 'application/json',
		url : "v1/user/" + login,
		dataType : "json",
		success : function(data, textStatus, jqXHR) {
			afficheUser(data);
			return data;
		},
		error : function(jqXHR, textStatus, errorThrown) {
			console.log("error: " + textStatus);
		}
	});
	return null;
}

function inscription(login, mdp1, mdp2, role) {
	$.ajax({
		type : 'POST',
		contentType : 'application/json',
		url : "v1/user/",
		dataType : "json",
		data : JSON.stringify({
			"login" : login,
			"password" : mdp1,
			"role" : role,
		}),
		success : function(data, textStatus, jqXHR) {
			console.log(data);
		},
		error : function(jqXHR, textStatus, errorThrown) {
			console.log("error: " + textStatus);
		}
	});
}

function checkCheck(inputs) {
	var listobj = [];
	listobj = inputs;
	var res = [];
	for (var i = 0; i < inputs.length; i++) {
		if (listobj[i].type.toLowerCase() == 'checkbox') {
			if (listobj[i].checked == true) {
				res.push(listobj[i].value);
			}
		}
	}
	return res;
}

function postEnfant(CheckInput, FileInput, TextInput, DateInput, TelInput) {
	var temp = "";
	for (var i = 0; i < CheckInput.length; i++) {
		temp = temp + " " + CheckInput[i];
	}
	console.log(temp);
	$.ajax({
		type : 'POST',
		contentType : 'application/json',
		url : "/v1/enfant",
		dataType : "json",
		data : JSON
				.stringify({
					"nom" : TextInput[0].value,
					"prenom" : TextInput[1].value,
					"dateNaissance" : DateInput[0].value,
					"adresse" : TextInput[2].value,
					"tempsAccueil" : TextInput[3].value,
					"horraireAccueil" : temp,
					"periodeAdaptation" : DateInput[1].value,
					"allergies" : TextInput[4].value,
					"traitements" : TextInput[5].value,
					"personne" : (TextInput[6].value + "" + TextInput[7].value
							+ "" + TextInput[8].value),
					"numeroUrgence" : TelInput[1].value,
					"numeroMedecin" : TelInput[0].value,
					"photo" : FileInput[0].value,
				}),
		success : function(data, textStatus, jqXHR) {
			console.log(data);
		},
		error : function(jqXHR, textStatus, errorThrown) {
			console.log("error: " + textStatus);
		}
	});
}

/** ************************************************************** */
function simulation(ressources2014, enfantsCharge, nbJournee, nbDemiJournee) {

	var tabA = [ 20509, 23420, 26331, 29242, 32153, 35064, 37975 ];
	var tabB = [ 45575, 52044, 58513, 64982, 71451, 77920, 84389 ];
	var categorie;
	var montantJ = 0;
	var montantDJ = 0;
	var montant = 0;
	var montantMini = 0;
	var aide;
	
		// calcul de la catégorie
		if (ressources2014 < tabA[enfantsCharge - 1])
			categorie = "A";
		else if (ressources2014 < tabB[enfantsCharge - 1])
			categorie = "B";
		else
			categorie = "C";

		// montant de l'aide + montant horraire selon le nombre de journées
		if (nbJournee == 1) {
			if (categorie == "A") {
				aide = 311, 95;
				montantJ = 9;
			}
			if (categorie == "B") {
				aide = 326, 40;
				montantJ = 9.4;
			}
			if (categorie == "C") {
				aide = 340;
				montantJ = 9.8;
			}
		}
		if (nbJournee == 2) {
			if (categorie == "A") {
				aide = 583, 10;
				montantJ = 8.4;
			}
			if (categorie == "B") {
				aide = 611, 15;
				montantJ = 8.8;
			}
			if (categorie == "C") {
				aide = 610, 93;
				montantJ = 9.2;
			}
		}
		if (nbJournee == 3) {
			if (categorie == "A") {
				aide = 791, 35;
				montantJ = 7.6;
			}
			if (categorie == "B") {
				aide = 727, 29;
				montantJ = 8;
			}
			if (categorie == "C") {
				aide = 610, 93;
				montantJ = 8.4;
			}
		}
		if (nbJournee == 4) {
			if (categorie == "A") {
				aide = 843, 69;
				montantJ = 6.8;
			}
			if (categorie == "B") {
				aide = 727, 29;
				montantJ = 7.2;
			}
			if (categorie == "C") {
				aide = 610, 93;
				montantJ = 7.6;
			}
		}
		if (nbJournee == 5) {
			if (categorie == "A") {
				aide = 843, 69;
				montantJ = 6.1;
			}
			if (categorie == "B") {
				aide = 727, 29;
				montantJ = 6.4;
			}
			if (categorie == "C") {
				aide = 610, 93;
				montantJ = 6.8;
			}
		}

		// montant horraire en demi-journée
		if (nbDemiJournee != 0) {
			if (categorie == "A")
				montantDJ = 9.1;
			if (categorie == "B")
				montantDJ = 9.6;
			if (categorie == "C")
				montantDJ = 9.9;
		}
		console.log("nbJournee: "+ nbJournee);
		console.log("nbDemiJournee: "+ nbDemiJournee);
		console.log("aide: "+ aide);
		

		montant = (nbDemiJournee*6*montantDJ + nbJournee*10*montantJ) * 4;
		montantMini = montant * 0.15;
		
		if(montant - aide > montantMini)
			montant -= aide;
		
		$("#categorie").text("Vous êtes catégorie " + categorie);
		$("#montant").text("Montant de l'estimation : "+Math.ceil(montant)+"€");	
}
function getUserBdd(name) {
	getUserGeneric(name, "v1/user/");
}

function getUserGeneric(name, url) {
	$.getJSON(url + name, function(data) {
		afficheUser(data);
	});
}

function getForAll() {
	getSecure("v1/secure/who");
}

function getByAnnotation() {
	getSecure("v1/secure/byannotation");
}

function getSecure(url) {
	if ($("#userlogin").val() != "") {
		$.ajax({
			type : "GET",
			url : url,
			dataType : 'json',
			beforeSend : function(req) {
				req.setRequestHeader("Authorization", "Basic "
						+ btoa($("#userlogin").val() + ":"
								+ $("#passwdlogin").val()));
			},
			success : function(data) {
				afficheUser(data);
			},
			error : function(jqXHR, textStatus, errorThrown) {
				alert('error: ' + textStatus);
			}
		});
	} else {
		$.getJSON(url, function(data) {
			console.log(data);
		});
	}
}

function postUserBdd(name, alias, email, pwd) {
	postUserGeneric(name, alias, email, pwd, "v1/user/");
}

function postUserGeneric(name, alias, email, pwd, url) {
	console.log("postUserGeneric " + url)
	$.ajax({
		type : 'POST',
		contentType : 'application/json',
		url : url,
		dataType : "json",
		data : JSON.stringify({
			"name" : name,
			"alias" : alias,
			"email" : email,
			"password" : pwd,
			"id" : 0
		}),
		success : function(data, textStatus, jqXHR) {
			console.log(data);
		},
		error : function(jqXHR, textStatus, errorThrown) {
			console.log('postUser error: ' + textStatus);
		}
	});
}

function listUsersBdd() {
	listUsersGeneric("v1/user/");
}

function listUsersGeneric(url) {
	$.getJSON(url, function(data) {
		afficheListUsers(data)
	});
}

function afficheUser(data) {
	console.log(data);
	$("#reponse").html(
			data.id + " : <b>" + data.alias + "</b> (" + data.name + ")");
}

function afficheListUsers(data) {
	var html = '<ul>';
	var index = 0;
	for (index = 0; index < data.length; ++index) {
		html = html + "<li>" + data[index].name + "</li>";
	}
	html = html + "</ul>";
	$("#reponse").html(html);
}