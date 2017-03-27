package fr.iutinfo.skeleton.common.dto;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.security.Principal;
import java.util.Calendar;

public class ParentDto implements Principal {
    final static Logger logger = LoggerFactory.getLogger(ParentDto.class);
    private int id;
    private String nomEnfant;
	private String prenomEnfant;
	private String nomA;
	private String prenomA;
	private String dateNaissanceA;
	private String adresseA;
	private String congesA;
	private String professionA;
	private String numeroCafA;
	private String categorieCafA;
	private String nomB;
	private String prenomB;
	private String dateNaissanceB;
	private String adresseB;
	private String congesB;
	private String professionB;
	private String numeroCafB;
	private String categorieCafB;
	private String dureeCntrat;
	private String typeContrat;	

	

	public String getNomA() {
		return nomA;
	}




	public void setNomA(String nomA) {
		this.nomA = nomA;
	}




	public String getCongesB() {
		return congesB;
	}




	public void setCongesB(String congesB) {
		this.congesB = congesB;
	}




	public String getPrenomA() {
		return prenomA;
	}




	public void setPrenomA(String prenomA) {
		this.prenomA = prenomA;
	}




	public String getDateNaissanceA() {
		return dateNaissanceA;
	}




	public void setDateNaissanceA(String dateNaissanceA) {
		this.dateNaissanceA = dateNaissanceA;
	}




	public String getAdresseA() {
		return adresseA;
	}




	public void setAdresseA(String adresseA) {
		this.adresseA = adresseA;
	}




	public String getCongesA() {
		return congesA;
	}




	public void setCongesA(String congesA) {
		this.congesA = congesA;
	}




	public String getProfessionA() {
		return professionA;
	}




	public void setProfessionA(String professionA) {
		this.professionA = professionA;
	}




	public String getNumeroCafA() {
		return numeroCafA;
	}




	public void setNumeroCafA(String numeroCafA) {
		this.numeroCafA = numeroCafA;
	}




	public String getCategorieCafA() {
		return categorieCafA;
	}




	public void setCategorieCafA(String categorieCafA) {
		this.categorieCafA = categorieCafA;
	}




	public String getNomB() {
		return nomB;
	}




	public void setNomB(String nomB) {
		this.nomB = nomB;
	}




	public String getPrenomB() {
		return prenomB;
	}




	public void setPrenomB(String prenomB) {
		this.prenomB = prenomB;
	}




	public String getDateNaissanceB() {
		return dateNaissanceB;
	}




	public void setDateNaissanceB(String dateNaissanceB) {
		this.dateNaissanceB = dateNaissanceB;
	}




	public String getAdresseB() {
		return adresseB;
	}




	public void setAdresseB(String adresseB) {
		this.adresseB = adresseB;
	}




	public String getProfessionB() {
		return professionB;
	}




	public void setProfessionB(String professionB) {
		this.professionB = professionB;
	}




	public String getNumeroCafB() {
		return numeroCafB;
	}




	public void setNumeroCafB(String numeroCafB) {
		this.numeroCafB = numeroCafB;
	}




	public String getCategorieCafB() {
		return categorieCafB;
	}




	public void setCategorieCafB(String categorieCafB) {
		this.categorieCafB = categorieCafB;
	}




	public String getDureeCntrat() {
		return dureeCntrat;
	}




	public void setDureeCntrat(String dureeCntrat) {
		this.dureeCntrat = dureeCntrat;
	}




	public String getTypeContrat() {
		return typeContrat;
	}




	public void setTypeContrat(String typeContrat) {
		this.typeContrat = typeContrat;
	}
	
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}




	public String getNomEnfant() {
		return nomEnfant;
	}




	public void setNomEnfant(String nomEnfant) {
		nomEnfant = nomEnfant;
	}




	public String getPrenomEnfant() {
		return prenomEnfant;
	}




	public void setPrenomEnfant(String prenomEnfant) {
		this.prenomEnfant = prenomEnfant;
	}




	public int getId() {
		return id;
	}




	public void setId(int id) {
		this.id = id;
	}
}
