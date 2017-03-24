$(document).ready(function() {
		$(".connectionDiv").hide();
		$(".inscriptionDiv").hide();
        $(".FormEnfant").hide();
		$(".dashboardDiv").hide();
		$(".FormParent").hide();
		$("FormEnfant").hide();
		$(".planningDiv").hide();
		$(".vitrineDiv").show();
		

		
	function afficherConnection(){
		$(".connectionDiv").show();
		$(".inscriptionDiv").hide();
        $(".FormEnfant").hide();
		$(".dashboardDiv").hide();
		$(".FormParent").hide();
		$(".planningDiv").hide();
		$(".vitrineDiv").hide();
	}
	function afficherInscription(){
		$(".connectionDiv").hide();
		$(".inscriptionDiv").show();
        $(".FormEnfant").hide();
		$(".dashboardDiv").hide();
		$(".FormParent").hide();
		$(".planningDiv").hide();
		$(".vitrineDiv").hide();
	}
	function afficherFormEnfant(){
		$(".connectionDiv").hide();
		$(".inscriptionDiv").hide();
        $(".FormEnfant").show();
		$(".dashboardDiv").hide();
		$(".FormParent").hide();
		$(".planningDiv").hide();
		$(".vitrineDiv").hide();
	}
	function afficherDashboard(){
		$(".connectionDiv").hide();
		$(".inscriptionDiv").hide();
        $(".FormEnfant").hide();
		$(".dashboardDiv").show();
		$(".FormParent").hide();
		$(".planningDiv").hide();
		$(".vitrineDiv").hide();
	}
	function afficherFormParent(){
		$(".connectionDiv").hide();
		$(".inscriptionDiv").hide();
        $(".FormEnfant").hide();
		$(".dashboardDiv").hide();
		$(".FormParent").show();
		$(".planningDiv").hide();
		$(".vitrineDiv").hide();
	}
	
	function afficherPlanningDiv(){
		$(".connectionDiv").hide();
		$(".inscriptionDiv").hide();
        $(".FormEnfant").hide();
		$(".dashboardDiv").hide();
		$(".FormParent").hide();
		$(".planningDiv").show();
		$(".vitrineDiv").hide();
	}
	function afficherPlanningDiv(){
		$(".connectionDiv").hide();
		$(".inscriptionDiv").hide();
        $(".FormEnfant").hide();
		$(".dashboardDiv").hide();
		$(".FormParent").hide();
		$(".planningDiv").show();
		$(".vitrineDiv").hide();
	}
	function afficherVitrineDiv(){
		$(".connectionDiv").hide();
		$(".inscriptionDiv").hide();
        $(".FormEnfant").hide();
		$(".dashboardDiv").hide();
		$(".FormParent").hide();
		$(".planningDiv").hide();
		$(".vitrineDiv").show();
	}

    $('#connection').click(function (event) {
        $(".inscriptionDiv").hide();
        $(".vitrineDiv").hide();
        $(".connectionDiv").hide();
        $(".FormEnfant").hide();
    });
    
    $('#inscription').click(function (event) {
        $(".FormEnfant").hide();
        $(".vitrineDiv").hide();
        $(".connectionDiv").hide();
        $(".dashboardDiv").hide();
    });
    
});