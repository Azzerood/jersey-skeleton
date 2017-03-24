package fr.iutinfo.skeleton.planning;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import fr.iutinfo.skeleton.common.dto.CreneauDto;

public class Creneau {

	private String status = "previsionnel";
	private String date;
	private String heureDebut;
	private String heureFin;
	private String listEnfant;

	public Creneau() {
	}

	public Creneau(String status, String date, String heureDebut, String heureFin, String listEnfant) throws Exception {
		if (Integer.parseInt(heureDebut) > 730 && Integer.parseInt(heureFin) < 1900) {
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

	public String getHeureDebut() {
		return heureDebut;
	}

	public void setHeureDebut(String heureDebut) {
		this.heureDebut = heureDebut;
	}

	public String getHeureFin() {
		return heureFin;
	}

	public void setHeureFin(String heureFin) {
		this.heureFin = heureFin;
	}

	public void setListEnfant(String listEnfant) {
		this.listEnfant = this.listEnfant + " " + listEnfant;
	}

	public String getListEnfant() {
		return listEnfant;
	}

	public void initFromDto(CreneauDto dto) throws Exception {
		this.setDate(dto.getDate());
		this.setHeureDebut(dto.getHeureDebut());;
		this.setHeureFin(dto.getHeureFin());
		this.setListEnfant(dto.getListEnfant());
		this.setStatus(dto.getStatus());
	}
	
	public CreneauDto convertToDto()  {
		CreneauDto dto = new CreneauDto();
		dto.setDate(getDate());
		dto.setHeureDebut(getHeureDebut());
		dto.setHeureFin(getHeureFin());
		dto.setListEnfant(getListEnfant());
		dto.setStatus(getStatus());
		return dto;
	}
}
