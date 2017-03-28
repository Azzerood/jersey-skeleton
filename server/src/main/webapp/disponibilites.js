
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
