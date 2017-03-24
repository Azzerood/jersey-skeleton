package fr.iutinfo.skeleton.common.dto;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.security.Principal;
import java.util.Calendar;

public class CreneauDto implements Principal {
    final static Logger logger = LoggerFactory.getLogger(CreneauDto.class);
    private String status= "previsionnel";
	private String date;
	private String heureDebut;
	private String heureFin;
	private String listEnfant;
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
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
	public String getListEnfant() {
		return listEnfant;
	}
	public void setListEnfant(String listEnfant) {
		this.listEnfant = listEnfant;
	}
}
