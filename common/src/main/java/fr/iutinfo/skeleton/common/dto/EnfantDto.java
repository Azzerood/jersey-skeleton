package fr.iutinfo.skeleton.common.dto;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.security.Principal;
import java.util.Calendar;

public class EnfantDto implements Principal {
    final static Logger logger = LoggerFactory.getLogger(EnfantDto.class);
    private String nom;
	private String prenom;
	private String dateNaissance;
	private String adresse;
	private String tempsAccueil;
	private String horraireAccueil;
	private String periodeAdaptation;
	private String allergies;
	private String traitements;
	private String personnes;
	private String numeroUrgence;
	private String numeroMedecin;
	private String photo;
	
	public String getPeriodeAdaptation() {
		return periodeAdaptation;
	}

	public void setPeriodeAdaptation(String periodeAdaptation) {
		this.periodeAdaptation = periodeAdaptation;
	}

	public String getNumeroUrgence() {
		return numeroUrgence;
	}

	public void setNumeroUrgence(String numeroUrgence) {
		this.numeroUrgence = numeroUrgence;
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

	public String getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(String dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getTempsAccueil() {
		return tempsAccueil;
	}

	public void setTempsAccueil(String tempsAccueil) {
		this.tempsAccueil = tempsAccueil;
	}

	public String getHorraireAccueil() {
		return horraireAccueil;
	}

	public void setHorraireAccueil(String horraireAccueil) {
		this.horraireAccueil = horraireAccueil;
	}

	public String getAllergies() {
		return allergies;
	}

	public void setAllergies(String allergies) {
		if(("").equals(this.allergies)){
			this.allergies = allergies;
		}else{
			this.allergies = this.allergies + " " + allergies;
		}
	}

	public String getTraitements() {
		return traitements;
	}

	public void setTraitements(String traitements) {
		if(("").equals(this.traitements)){
			this.traitements = traitements;
		}else{
			this.traitements = this.traitements + " " + traitements;
		}
	}

	public String getPersonnes() {
		return personnes;
	}

	public void setPersonnes(String personnes) {
		if(("").equals(this.personnes)){
			this.personnes = personnes;
		}else{
			this.personnes = this.personnes + " " + personnes;
		}
	}

	public String getNumeroParents() {
		return numeroUrgence;
	}

	public void setNumeroParents(String numeroUrgence) {
		this.numeroUrgence = numeroUrgence;
	}

	public String getNumeroMedecin() {
		return numeroMedecin;
	}

	public void setNumeroMedecin(String numeroMedecin) {
		this.numeroMedecin = numeroMedecin;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}
}
