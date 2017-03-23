package fr.iutinfo.skeleton.planning;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Creneau {

	private Calendar date;
	private int heureDebut;
	private int heureFin;
	
	public Creneau(int heureDebut, int heureFin, Calendar date) throws Exception{
		if(heureDebut>730 && heureFin<1900){
			this.heureDebut = heureDebut;
			this.heureFin = heureFin;
			this.date = date;
		}
		 throw new Exception("invalide heure crenau");		
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
}
