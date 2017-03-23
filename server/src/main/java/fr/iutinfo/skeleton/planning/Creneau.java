package fr.iutinfo.skeleton.planning;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

public class Creneau {

	private String status= "previsionnel";
	private Calendar date;
	private int heureDebut;
	private int heureFin;
	private String listEnfant;
		
	public Creneau(int heureDebut, int heureFin, Calendar date, String listEnfant) throws Exception{
		if(heureDebut>730 && heureFin<1900){
			this.heureDebut = heureDebut;
			this.heureFin = heureFin;
			this.date = date;
			this.listEnfant = listEnfant;
		}
		 throw new Exception("invalide heure crenau");		
	}
	public String getPlanning() {
		return status;
	}
	public void setPlanning(String status) throws Exception {
		if(status.equals("previsionnel") || status.equals("reel"))
			this.status = status;
		else
			 throw new Exception("invalide status");
	}
	public Calendar getDate() {
		return date;
	}

	public void setDate(GregorianCalendar date) {
		this.date = date;
	}

	public int getHeureDebut() {
		return heureDebut;
	}

	public void setHeureDebut(int heureDebut) {
		this.heureDebut = heureDebut;
	}

	public int getHeureFin() {
		return heureFin;
	}

	public void setHeureFin(int heureFin) {
		this.heureFin = heureFin;
	}
	public void setListEnfant(String listEnfant) {
		this.listEnfant = this.listEnfant+" "+listEnfant;
	}
	public String getListEnfant() {
		return listEnfant;
	}
	public void setDate(Calendar date) {
		this.date = date;
	}
}
