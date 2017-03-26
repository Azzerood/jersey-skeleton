package fr.iutinfo.skeleton.planning;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import fr.iutinfo.skeleton.common.dto.CreneauDto;

public class Creneau {
        private int id;
	private String status = "previsionnel";
	private String date="";
	private int heureDebut;
	private int heureFin;
	private String listEnfant="";

	public Creneau() {
	}

	public Creneau(String status, String date, int heureDebut, int heureFin, String listEnfant) throws Exception {
		if (heureDebut > 800 && heureFin < 1900) {
			this.heureDebut = heureDebut;
			this.heureFin = heureFin;
			this.date = date;
			this.listEnfant = listEnfant;
			this.status = status;
		}else{
			throw new Exception("invalide heure crenau");
		}
	}
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) throws Exception {
	    if (status.equals("previsionnel") || status.equals("reel"))
			this.status = status;
		else
			throw new Exception("invalide status");
	    
	}


	public String getDate() {
		return date;
	}

	public void setDate(String date) {
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
	    this.listEnfant = listEnfant;
	}

	public String getListEnfant() {
		return listEnfant;
	}
    public int getId(){
	return id;
    }
    public void setId(int id){
	this.id = id;
    }
	public void initFromDto(CreneauDto dto) throws Exception {
		this.setDate(dto.getDate());
		this.setHeureDebut(dto.getHeureDebut());;
		this.setHeureFin(dto.getHeureFin());
		this.setListEnfant(dto.getListEnfant());
		this.setStatus(dto.getStatus());
		setId(dto.getId());
	}
	
	public CreneauDto convertToDto()  {
		CreneauDto dto = new CreneauDto();
		dto.setDate(getDate());
		dto.setHeureDebut(getHeureDebut());
		dto.setHeureFin(getHeureFin());
		dto.setListEnfant(getListEnfant());
		dto.setStatus(getStatus());
		dto.setId(id);
		return dto;
	}
}
