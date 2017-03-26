package fr.iutinfo.skeleton.common.dto;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.security.Principal;
import java.util.Calendar;

public class CreneauDto implements Principal {
    final static Logger logger = LoggerFactory.getLogger(CreneauDto.class);
    private String status= "previsionnel";
    private int id;
	private String date;
	private int heureDebut;
	private int heureFin;
	private String listEnfant;
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}
    public int getId(){
	return id;
    }
    public void setId(int id){
	this.id = id;
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
	public int getHeureDebut() {
		return heureDebut;
	}
	public void setHeureDebut(int i) {
		this.heureDebut = i;
	}
	public int getHeureFin() {
		return heureFin;
	}
	public void setHeureFin(int i) {
		this.heureFin = i;
	}
	public String getListEnfant() {
		return listEnfant;
	}
	public void setListEnfant(String listEnfant) {
		this.listEnfant = listEnfant;
	}
}
