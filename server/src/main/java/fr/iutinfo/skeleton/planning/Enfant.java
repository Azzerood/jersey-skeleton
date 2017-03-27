package fr.iutinfo.skeleton.planning;

import ch.qos.logback.core.net.SyslogOutputStream;
import fr.iutinfo.skeleton.common.dto.CreneauDto;
import fr.iutinfo.skeleton.common.dto.EnfantDto;

public class Enfant {

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

	public Enfant(){}


	public Enfant(String nom, String prenom, String dateNaissance, String adresse,String horraireAccueil){
		this.nom=nom;
		this.prenom =prenom;
		this.dateNaissance = dateNaissance;
		this.adresse = adresse;
		this.horraireAccueil = horraireAccueil;
	}

	public Enfant(String nom, String prenom, String dateNaissance, String adresse, String tempsAccueil,
			String horraireAccueil, String periodeAdaptation, String allergies, String traitements, String personnes, String numeroUrgence,
			String numeroMedecin, String photo) {
		this.nom = nom;
		this.prenom = prenom;
		this.dateNaissance = dateNaissance;
		this.adresse = adresse;
		this.tempsAccueil = tempsAccueil;
		this.horraireAccueil = horraireAccueil;
		this.periodeAdaptation = periodeAdaptation;
		this.allergies = allergies;
		this.numeroUrgence = numeroUrgence;
		this.numeroMedecin = numeroMedecin;
		this.photo = photo;
		this.traitements = traitements;
		this.personnes = personnes;
	}

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
		this.allergies = allergies;
	}

	public String getTraitements() {
		return traitements;
	}


	public void setTraitements(String traitements) {
		this.traitements = traitements;
	}


	public String getPersonnes() {
		return personnes;
	}


	public void setPersonnes(String personnes) {
		this.personnes = personnes;
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

	public void initFromDto(EnfantDto dto) throws Exception {
		this.setPhoto(dto.getPhoto());
		this.setNom(dto.getNom());
		this.setPrenom(dto.getPrenom());
		this.setDateNaissance(dto.getDateNaissance());
		this.setAdresse(dto.getAdresse());
		this.setHorraireAccueil(dto.getHorraireAccueil());
		this.setTempsAccueil(dto.getTempsAccueil());
		this.setPeriodeAdaptation(dto.getPeriodeAdaptation());
		this.setNumeroMedecin(dto.getNumeroMedecin());
		this.setAllergies(dto.getAllergies());
		this.setTraitements(dto.getTraitements());
		this.setNumeroUrgence(dto.getNumeroUrgence());
		this.setPersonnes(dto.getPersonnes());
	}

	public EnfantDto convertToDto(){
		EnfantDto dto = new EnfantDto();

		dto.setPhoto(getPhoto());
		dto.setNom(getNom());
		dto.setPrenom(getPrenom());
		dto.setDateNaissance(getDateNaissance());
		dto.setAdresse(getAdresse());
		dto.setHorraireAccueil(getHorraireAccueil());
		dto.setTempsAccueil(getTempsAccueil());
		dto.setPeriodeAdaptation(getPeriodeAdaptation());
		dto.setNumeroMedecin(getNumeroMedecin());
		dto.setAllergies(getAllergies());
		dto.setTraitements(getTraitements());
		dto.setNumeroUrgence(getNumeroUrgence());
		dto.setPersonnes(getPersonnes());	

		return dto;
	}
}
