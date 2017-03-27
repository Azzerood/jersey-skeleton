package fr.iutinfo.skeleton.common.dto;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.security.Principal;
import java.util.Calendar;

public class ParentDto implements Principal {
    final static Logger logger = LoggerFactory.getLogger(ParentDto.class);
	private String[] nom;
	private String[] prenom;
	private String[] dateNaissance;
	private String[] adresses;
	private String[] conges;
	private String[] profession;
	private String[] numeroCaf;
	private String[] categorieCaf;
	private String dureeCntrat;
	private String typeContrat;
	
	public String[] getNom() {
		return nom;
	}


	public void setNom(String[] nom) {
		this.nom = nom;
	}


	public String[] getPrenom() {
		return prenom;
	}


	public void setPrenom(String[] prenom) {
		this.prenom = prenom;
	}


	public String[] getDateNaissance() {
		return dateNaissance;
	}


	public void setDateNaissance(String[] dateNaissance) {
		this.dateNaissance = dateNaissance;
	}


	public String[] getAdresse() {
		return adresse;
	}


	public void setAdresse(String[] adresse) {
		this.adresse = adresse;
	}


	public String[] getConges() {
		return conges;
	}


	public void setCongés(String[] conges) {
		this.conges = conges;
	}


	public String[] getProfession() {
		return profession;
	}


	public void setProfession(String[] profession) {
		this.profession = profession;
	}


	public String[] getNumeroCaf() {
		return numeroCaf;
	}


	public void setNumeroCaf(String[] numeroCaf) {
		this.numeroCaf = numeroCaf;
	}


	public String[] getCategorieCaf() {
		return categorieCaf;
	}


	public void setCategorieCaf(String[] categorieCaf) {
		this.categorieCaf = categorieCaf;
	}


	public String getDureeContrat() {
		return dureeContrat;
	}


	public void setDureeContrat(String dureeContrat) {
		this.dureeContrat = dureeContrat;
	}



	public void setTypeContrat(String typeContrat) {
		this.typeContrat = typeContrat;
	}


	public String[] getNumero() {
		return numero;
	}


	public void setNumero(String[] numero) {
		this.numero = numero;
	}
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}
}
