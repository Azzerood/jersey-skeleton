package fr.iutinfo.skeleton.planning;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Planning {

	private List<Creneau> liste;
	
	public Planning(){
		liste = new ArrayList<Creneau>();
	}
	
	public void addCreneau(Creneau creneau){
		liste.add(creneau);
	}

	public void addCreauAll(List<Creneau> liste){
		this.liste.addAll(liste);
	}
	
	public List<Creneau> getListe() {
		return liste;
	}
		
	public List<Creneau> getPlanningMois(int mois) throws Exception{
		List<Creneau> l = new ArrayList<Creneau>();
		if(mois>0 && mois <= 12)
			 throw new Exception("invalide mois");
		for (Creneau creneau : liste) {
//			if(creneau.getDate().get(Calendar.MONTH)+1== mois)
//				l.add(creneau);				
		}
		return l;
	}
	
	public List<Creneau> getPlanningSemaine(int semaine) throws Exception{
		List<Creneau> l = new ArrayList<Creneau>();
		if(semaine>0 && semaine <= 52)
			 throw new Exception("invalide semaine");
		for (Creneau creneau : liste) {
//			if(creneau.getDate().get(Calendar.WEEK_OF_YEAR)== semaine)
//				l.add(creneau);				
		}
		return l;
	}
	
	public List<Creneau> getPlanningJour(int jour) throws Exception{
		List<Creneau> l = new ArrayList<Creneau>();
		if(jour>0 && jour <= 366)
			 throw new Exception("invalide semaine");
		for (Creneau creneau : liste) {
//			if(creneau.getDate().get(Calendar.DAY_OF_YEAR)== jour)
//				l.add(creneau);				
		}
		return l;
	}
}
