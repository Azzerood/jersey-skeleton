package fr.iutinfo.skeleton.common.dto;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.security.Principal;
import java.util.Calendar;

public class SalarieDto implements Principal {
    final static Logger logger = LoggerFactory.getLogger(SalarieDto.class);

	private String nom;
	private String prenom;
	private String nationnalite;
	private Calendar dateNaissance;
	private String adresse;
	private String departement;
	private String typeContrat;
	private String tempsContrat;
	private String debutContrat;
	private String finContrat;
	private String renumeration;
	private String numeroSecu;
	
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getNationnalite() {
		return nationnalite;
	}

	public void setNationnalite(String nationnalite) {
		this.nationnalite = nationnalite;
	}

	public Calendar getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(Calendar dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getDepartement() {
		return departement;
	}

	public void setDepartement(String departement) {
		this.departement = departement;
	}

	public String getTypeContrat() {
		return typeContrat;
	}

	public void setTypeContrat(String typeContrat) {
		this.typeContrat = typeContrat;
	}

	public String getTempsContrat() {
		return tempsContrat;
	}

	public void setTempsContrat(String tempsContrat) {
		this.tempsContrat = tempsContrat;
	}

	public String getDebutContrat() {
		return debutContrat;
	}

	public void setDebutContrat(String debutContrat) {
		this.debutContrat = debutContrat;
	}

	public String getFinContrat() {
		return finContrat;
	}

	public void setFinContrat(String finContrat) {
		this.finContrat = finContrat;
	}

	public String getRenumeration() {
		return renumeration;
	}

	public void setRenumeration(String renumeration) {
		this.renumeration = renumeration;
	}

	public String getNumeroSecu() {
		return numeroSecu;
	}

	public void setNumeroSecu(String numeroSecu) {
		this.numeroSecu = numeroSecu;
	}
}
