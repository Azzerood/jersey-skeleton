$(document).ready(function() {
		$(".page").hide();
		$(".vitrineDiv").show();
    //creerCreneaux();
    //dessinerCasePlanning();
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
