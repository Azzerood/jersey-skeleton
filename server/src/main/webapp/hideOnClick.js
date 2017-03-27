$(document).ready(function() {
		$(".page").hide();
		$(".vitrineDiv").show();
    // creerCreneaux();
    // dessinerCasePlanning();
    $("#planningJournee").click(function(event){
		 onClickCanvas(this,event);
		});
    $("#loadPlanning").click(function(event){
       chargerPlanning();       
    });
    $("#savePlanning").click(function(event){
       updatePlanning(); 
    });
    
    $("#boutonSimulation").click( function () { simulation( $('#ressources2014').val() , $('#enfantsCharge').val() , $('#nbJournee').val() , $('#nbDemiJournee').val()) } );

    $("#validerEnfant").click(function() {
		
		var  inputs = $('.form-group > input');
		
		var CheckInput = [];
		var FileInput = [];
		var TextInput = [];
		var DateInput = [];
		var TelInput = [];

		for (var i = 0; i < inputs.length; i++) {
			if (inputs[i].type.toLowerCase() == 'checkbox') {
				CheckInput.push(inputs[i]);
			} else if (inputs[i].type.toLowerCase() == 'file') {
				FileInput.push(inputs[i]);
			} else if (inputs[i].type.toLowerCase() == 'text') {
				TextInput.push(inputs[i]);
			} else if (inputs[i].type.toLowerCase() == 'tel') {
				TelInput.push(inputs[i]);
			} else if (inputs[i].type.toLowerCase() == 'date') {
				DateInput.push(inputs[i]);
			}
		}
		CheckInput = checkCheck(CheckInput);
		
			postEnfant(CheckInput,FileInput,TextInput,DateInput,TelInput);
	});
});
	function afficherConnection(){
		$(".page").hide();
		$(".connectionDiv").show();
	
	}
	function afficherInscription(){
		$(".page").hide();
		$(".inscriptionDiv").show();
		
	}
	function afficherFormEnfant(){
		$(".page").hide();
        $(".FormEnfant").show();
		
	}
    function afficherDisponibilites(){
        $(".page").hide();
		$(".disponibilitesDiv").show();
    }
	function afficherFormSalarie(){
		$(".page").hide();
		$(".FormSalarie").show();
	}
	function afficherDashboard(){
		$(".page").hide();
		$(".dashboardDiv").show();
	}
	function afficherFormParent(){ 
		$(".page").hide();
		$(".FormParent").show();

	}
	
	function afficherPlanningDiv(){
		$(".page").hide();
		$(".planningDiv").show(); 
	}
	function afficherPlanningDiv(){
		$(".page").hide();
		$(".planningDiv").show();
	}
	function afficherVitrineDiv(){
		$(".page").hide();
		$(".vitrineDiv").show();
	}
	function afficherPlanningDiv(){
		$(".page").hide();
		$(".planningDiv").show();
	}

    $('#connection').click(function (event) {
        afficherDashboard();
    });
    
    $('#validerInscription').click(function (event) {
       afficherDashboard();
    });
    $("#boutonAdmin").click(function(event){
         afficherConnection();                 
    });
	$("#boutonInscription").click(function(event){
		afficherInscription();
	});
    $("#boutonFormEnfant").click(function(event){
		afficherFormEnfant();
	});
	$("#boutonFormParent").click(function(event){
		afficherFormParent();
	});
	$(".backToDashboard").click(function(event){
		afficherDashboard();
	});
	$(".backToSite").click(function(event){
	afficherVitrineDiv();
	});
	$("#boutonVisualiserPlanning").click(function(even){
	afficherPlanningDiv();
	});
	$("#boutonFormSalarie").click(function(even){
	afficherFormSalarie();
	});
    $("#toDisponibilites").click(function(event){
       console.log("To dispo");
	   afficherDisponibilites();
	});
     $("#loadDisponibilites").click(function(event){
       console.log("load dispo");
	    loadDisponibilites();
	});
    
	
});
