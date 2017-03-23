package fr.iutinfo.skeleton.planning;

import java.util.Calendar;
import java.util.List;

public class Enfant {

	private String nom;
	private String prenom;
	private Calendar dateNaissance;
	private String adresse;
	private int tempsAccueil;
	private List<Creneau> horraireAccueil;
	private List<String> allergies;
	private String numeroParents;
	private String numeroMedecin;
	private String photo;
	
	public Enfant(String nom, String prenom, Calendar dateNaissance, String adresse,List<Creneau> horraireAccueil){
		this.nom=nom;
		this.prenom =prenom;
		this.dateNaissance = dateNaissance;
		this.adresse = adresse;
		this.horraireAccueil = horraireAccueil;
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

	public int getTempsAccueil() {
		return tempsAccueil;
	}

	public void setTempsAccueil(int tempsAccueil) {
		this.tempsAccueil = tempsAccueil;
	}

	public List<Creneau> getHorraireAccueil() {
		return horraireAccueil;
	}

	public void setHorraireAccueil(List<Creneau> horraireAccueil) {
		this.horraireAccueil = horraireAccueil;
	}

	public List<String> getAllergies() {
		return allergies;
	}

	public void setAllergies(List<String> allergies) {
		this.allergies = allergies;
	}

	public String getNumeroParents() {
		return numeroParents;
	}

	public void setNumeroParents(String numeroParents) {
		this.numeroParents = numeroParents;
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
}
