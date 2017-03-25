 var creneaux = [];
 var listeEnfants = [];
 
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
		gfx.fillText(heure/100+"h"+"00",105+cpt*100,30)
		gfx.beginPath();
		gfx.moveTo(100+cpt*100,canvas.height)
		gfx.lineTo(100+cpt*100,0);
		gfx.stroke();
	}
	
 }
 
 function recupererListeEnfants(){
  
	for(var cpt = 0 ; cpt < creneaux.length ; cpt++){
		var noms = creneaux[cpt].enfants.split(";");
		for(var name = 0 ; name<noms.length; name ++){
			if(  listeEnfants.indexOf(noms[name]) ===-1  && noms[name] != ""){
				listeEnfants.push(noms[name]);
			}
		}
	}
	listeEnfants.sort();
	console.log(listeEnfants);
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
		if(creneaux.enfants !== ""){
			var enfantsDuCreneau = creneaux[creneau].enfants.split(";");
			console.log("enfants présents à "+creneaux[creneau].heureDebut+"h: "+creneaux[creneau].enfants);
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
			creneaux[cren].enfants = creneaux[cren].enfants.replace(ancien,nouveau);
		}
	}
	function changerNom( idx){
		var person = prompt("Please enter your name", listeEnfants[idx]);
		console.log(person);
		if(idx<listeEnfant.length){
			changerNomDansCreneaux(listeEnfants[idx],person);
			listeEnfants[idx] = person;
		}
	}
	function changerPresence(idxEnfant, idxCreneau){
		if(idxEnfant < listeEnfants.length){
			var name = listeEnfants[idxEnfant];
			if( creneaux[idxCreneau].enfants.indexOf(name) !== -1 ){
				creneaux[idxCreneau].enfants = creneaux[idxCreneau].enfants.replace(name,"");
			}else{
				creneaux[idxCreneau].enfants += ";"+name;
			}
			creneaux[idxCreneau].enfants = creneaux[idxCreneau].enfants.replace(";;",";");
			while(creneaux[idxCreneau].enfants.startsWith(";")){
					creneaux[idxCreneau].enfants = creneaux[idxCreneau].enfants.substring(1,creneaux[idxCreneau].enfants.length);
			}
		}
	}