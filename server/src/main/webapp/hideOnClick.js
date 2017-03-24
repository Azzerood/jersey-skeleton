$(document).ready(function() {



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