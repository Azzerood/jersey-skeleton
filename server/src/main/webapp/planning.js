 var creneaux = [];
var listeEnfants = [];
var enfantsMatin = [];
var enfantsAprem = [];
var dispo = [];
 /*
 function creerCreneaux(){
  var enfants =["Paul","Luc","Camille","Théo","Eva","Julie","Alexandre","Mathieu"] ;
	var creneauTest = new Object();
	creneauTest.heureDebut = 800;
	creneauTest.heureFin = 900;
	creneauTest.enfants ="";
	creneaux.push(creneauTest);
  for(var heure =900; heure <1800;heure += 100 ){
	var creneau = new Object;
	creneau.heureDebut = heure;
	creneau.heureFin = heure+100;
	creneau.enfants = "";
	for(var enfant = 0; enfant<enfants.length;enfant++){
		if(Math.random() >=0.5){
			
			creneau.enfants += enfants[enfant]+";";
			
		}
		
	}
	creneau.enfants = creneau.enfants.substring(0,creneau.enfants.length-1);
	creneaux.push(creneau);
	
  
	
	}
	console.log(creneaux);
	recupererListeEnfants();
	refreshAffichagePlanning();
	
 }
 */
 function dessinerCasePlanning(){
	var canvas = document.getElementById("planningJournee");	
	var gfx = canvas.getContext("2d");
	gfx.fillStyle = 'rgb(0,0,0)';
	gfx.rect(0,0,canvas.width,canvas.height);
	gfx.stroke();
	gfx.font ="15px Arial";
	gfx.fillText("Enfants",10,30);
	for(var cpt=0; cpt <creneaux.length ;cpt++){
		var heure = creneaux[cpt].heureDebut;
		gfx.font = "10px Arial";
		gfx.fillText(Math.trunc(heure/100)+"h"+heure%100,105+cpt*100,30)
		gfx.beginPath();
		gfx.moveTo(100+cpt*100,canvas.height)
		gfx.lineTo(100+cpt*100,0);
		gfx.stroke();
	}
     gfx.font = "10px Arial";
     gfx.fillText("18h30",1100,30);
	
 }
 
 function recupererListeEnfants(){
    listeEnfants =[];
	for(var cpt = 0 ; cpt < creneaux.length ; cpt++){
		var noms = creneaux[cpt].listEnfant.split(";");
		for(var name = 0 ; name<noms.length; name ++){
			if(  listeEnfants.indexOf(noms[name]) ===-1  && noms[name] != ""){
				listeEnfants.push(noms[name]);
			}
		}
	}
	listeEnfants.sort();
 }
 function placerEnfantsPlanning(){
	var canvas = document.getElementById("planningJournee");	
	var gfx = canvas.getContext("2d");
	gfx.beginPath();
	
	for(var enfant = 0; enfant < 20 ; enfant ++){
		gfx.font = "10px Arial";
		if( listeEnfants[enfant] != undefined){
		  gfx.fillText(listeEnfants[enfant],10,40+(enfant+1)*30 );
		}
		
		gfx.beginPath();
		gfx.moveTo(0,50+(enfant*30))
		gfx.lineTo(canvas.width,50+(enfant*30) );
		gfx.stroke();
	}
	
 }
 function compare(a,b) {
  if (a.heureDebut < b.heureDebut)
    return -1;
  if (a.heureDebut > b.heureDebut)
    return 1;
  return 0;
}
 
 function colorierPresence(){
	var canvas = document.getElementById("planningJournee");	
	var gfx = canvas.getContext("2d");
	creneaux.sort(compare);
	console.log(creneaux);
	for(var creneau = 0; creneau<creneaux.length ; creneau ++){
		if(creneaux[creneau].listEnfant !== ""){
			var enfantsDuCreneau = creneaux[creneau].listEnfant.split(";");
			for(var enfant = 0; enfant < enfantsDuCreneau.length ; enfant++){
				var idx = listeEnfants.indexOf(enfantsDuCreneau[enfant]);
				if(idx >-1){
				gfx.fillStyle = 'green';
				gfx.fillRect(100+creneau*100,50+idx*30,100,30 );
				}
			}
		}
	}

	
	
 }



 function refreshAffichagePlanning(){
	var canvas = document.getElementById("planningJournee");	
	var gfx = canvas.getContext("2d");
	gfx.fillStyle="white";
	gfx.fillRect(0,0,canvas.width,canvas.height );
	colorierPresence();
	dessinerCasePlanning();
	placerEnfantsPlanning();
    compterEnfantsParDemiJournee();
     console.log("Enfants de l'aprem");
     console.log(enfantsAprem);
	 console.log("Enfants du matin");
     console.log(enfantsMatin);
     afficherSalarieNecessaire();
 }
 function relMouseCoords(canvas, event){
     var rect = canvas.getBoundingClientRect();
    var x = event.clientX - rect.left;
    var y = event.clientY - rect.top;
	return [x,y];
	}
HTMLCanvasElement.prototype.relMouseCoords = relMouseCoords;
	function onClickCanvas(canvas ,event){
		var coords = relMouseCoords(canvas, event);
		var x = coords[0];
		var y = coords[1];
		traiterClick(x,y);
	}
	function traiterClick(x,y){
		if(y>50){ //ON EST DANS LA ZONE DE SAISIE
			if(x<100){ //ON EST DANS LA LISTE DES ENFANTS
				changerNom(Math.trunc( (y-50)/30) ) ;
			}else{
				changerPresence(Math.trunc( (y-50)/30), Math.trunc((x-100)/100) );
			}
		}
		refreshAffichagePlanning();
	}
	function changerNomDansCreneaux(ancien, nouveau){
		for(var cren =0; cren < creneaux.length ; cren ++){
			creneaux[cren].listEnfant = creneaux[cren].listEnfant.replace(ancien,nouveau);
		}
	}
	function changerNom(idx){
		var person = prompt("Entrez le nom de l'enfant", listeEnfants[idx]);
           
        changerNomDansCreneaux(listeEnfants[idx],person);
        listeEnfants[idx] = person;
			
	}
	function changerPresence(idxEnfant, idxCreneau){
		if(idxEnfant < listeEnfants.length){
			var name = listeEnfants[idxEnfant];
			if( creneaux[idxCreneau].listEnfant.indexOf(name) !== -1 ){
				creneaux[idxCreneau].listEnfant = creneaux[idxCreneau].listEnfant.replace(name,"");
			}else{
				creneaux[idxCreneau].listEnfant += ";"+name;
			}
			creneaux[idxCreneau].listEnfant = creneaux[idxCreneau].listEnfant.replace(";;",";");
			while(creneaux[idxCreneau].listEnfant.startsWith(";")){
					creneaux[idxCreneau].listEnfant = creneaux[idxCreneau].listEnfant.substring(1,creneaux[idxCreneau].listEnfant.length);
			}
		}
	}
    
function chargerPlanning(){
    var date = $("#jourPlanning").val();
    var status = $("#typePlanning").val();
    creneaux= $.getCreneaux("v1/creneaux/"+date+"/"+status);
    recupererListeEnfants();
    refreshAffichagePlanning();
    
    
}
jQuery.extend({
    getCreneaux: function(url){
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

function compterEnfantsParDemiJournee(){
    enfantsAprem = [];
    enfantsMatin = [];
    for(var idxC = 0; idxC < creneaux.length ;idxC++){
        if(creneaux[idxC].heureDebut<1200){
            var enf = creneaux[idxC].listEnfant.split(";");
            for(var idxE = 0; idxE < enf.length; idxE++){
                if(enfantsMatin.indexOf(enf[idxE]) ==-1  && enf[idxE] !== ""){
                    enfantsMatin.push(enf[idxE]); 
                }
            }
        }else{
            if(creneaux[idxC].heureDebut>1300){
             var enf = creneaux[idxC].listEnfant.split(";");
                for(var idxE = 0; idxE < enf.length; idxE++){
                    if(enfantsAprem.indexOf(enf[idxE]) ==-1  && enf[idxE] !== "" ){
                        enfantsAprem.push(enf[idxE]); 
                    }
                }
            }
        }
        
    }
}
function afficherSalarieNecessaire(){
     var remplissageMatin = Math.ceil((enfantsMatin.length/10*100));
    var remplissageAprem = Math.ceil((enfantsAprem.length/10*100));
    
    var matin = "<table><tr><td><p><strong>Matin: </p><p></strong>Nombre d'enfants présents : "+enfantsMatin.length+"</p><p>Adultes nécessaire: "+Math.ceil(enfantsMatin.length/3)+"</p><p> Taux d'occupation : "+remplissageMatin+"%</p></td>";
    var aprem = "<td><p><strong>Apres-midi </p><p></strong>Nombre d'enfants présents : "+enfantsAprem.length+"</p><p>  Adultes nécessaire: "+Math.ceil(enfantsAprem.length/3)+"</p><p> Taux d'occupation : "+remplissageAprem+"%</p></td></tr></table>";
    $("#statPlanning").empty();
    $("#statPlanning").append(matin);
    $("#statPlanning").append(aprem);
}

function updatePlanning(){
    for(var cren = 0; cren < creneaux.length ; cren++){
        var creneau = creneaux[cren];
        var date = creneau.date;
        var status= creneau.status;
        var heureDebut = creneau.heureDebut;
        var enfants = creneau.listEnfant;
        var id = creneau.id;
        var heureFin = creneau.heureFin;
        $.ajax({
            type : 'POST',
            contentType : 'application/json',
            url: "v1/creneaux/",
            dataType: 'json',
            async:false,
            data : JSON.stringify({
			"id":id,
			"date":date,
			"heureDebut":heureDebut,
            "heureFin":heureFin,
            "listEnfant":enfants,
		}),
            success: function(data, textStatus, jqXHR) {
            console.log(id+" | "+date+" | "+heureDebut+" | "+heureFin+" | "+enfants);
               console.log(data);	
            },
            error : function(jqXHR, textStatus, errorThrown) {
			 console.log("error post planning by date and status: " + textStatus);
            }
        });
       
    }
}

function inscription(login,mdp1,mdp2,role) {
	$.ajax({
		type : 'POST',
		contentType : 'application/json',
		url : "v1/user/",
		dataType : "json",
		data : JSON.stringify({
			"login":login,
			"password":mdp1,
			"role":role,
		}),
		success : function(data, textStatus, jqXHR) {
			console.log(data);		
		},
		error : function(jqXHR, textStatus, errorThrown) {
			console.log("error: " + textStatus);
		}
	});
}



function loadDisponibilites(){
    var date = $("#monthDisponibilites").val();
    var status = "previsionnel";
    var year = date.split("-")[0];
    var month = date.split("-")[1];
    dispos = $.getDisponibilites("v1/creneaux/"+status+"/"+year+"/"+month);
    var dispoParJour = TrierParJour(dispos);
    console.log(dispoParJour);
    /*
    for(var jour = 0; jour < dispoTrie[0].length; jour++){
        dispoParJour[jour] = [];
        dispoParJour[jour][0]=compterDispoParDemiJour(10,dispoTrie[jour]);
    }
    console.log(dispoParJour); 
    */
}

function TrierParJour(c){
    var jours = [];
    
    for(var idx ; idx<c; idx++){
        console.log(c[idx]); 
        var j = c[idx].date.split("-")[2];
        console.log("jour numéro: "+j);
        if(jours.indexOf( j) ==-1){
          jours.push(j); 
        }
    }
    console.log("nb de jours: "+jours.length);
    var res = [jours.length];
    for(var idx ; idx<c.length; idx++){
        res[idx]= [];
        var j = c[idx].date.split("-")[2];
        res[jours.indexOf(j)].push(c[idx]);
        res[jours.indexOf(j)].push(c[idx]);
    }
    console.log(res);
    return res;
}
function TrierMatinEtAprem(dispos){
    var dispoJournee = [];
    dispoJournee[0]= [];
    dispoJournee[1]= [];
    for(var c = 0; c<dispos.length; c++){
        if(dispos[c].heureDebut <1200 ){
            dispoJournee[0].push(dispos[c]);
        }else{
            if(dispos[c].heureDebut > 1300){
                dispoJournee[1].push(dispos[c]);
            }
        }
    }
    return dispoJournee;
}

function compterDispoParDemiJour(nbMax,creneaux){
    var listeDesEnfants =[];
    for(idx = 0; idx < creneaux.length; idx++){
        var enf = creneaux[idx].listEnfant.split(";");
        for(idxE = 0; idxE < enf.length; idxE++){
            if( listeDesEnfants.indexOf(enf[idxE]) ==-1 && enf[idxE] !== " " ){
                listeDesEnfants.push(enf[idxE]);
            }
        }
    }
    
    return nbMax-listeDesEnfants.length;
}
jQuery.extend({
    getDisponibilites: function(url){
        var result = null;
        $.ajax({
            url: url,
            type: 'GET',
            contentType : 'application/json',
            dataType: 'json',
            async:false,
            success: function(data, textStatus, jqXHR) {
                result = data;
            },
            error : function(jqXHR, textStatus, errorThrown) {
			     console.log("error get planning of month : " + textStatus);
            }
        });
       return result;
    }
})

