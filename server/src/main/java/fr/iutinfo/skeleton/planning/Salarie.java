package fr.iutinfo.skeleton.planning;

import java.util.Calendar;

import fr.iutinfo.skeleton.common.dto.ParentDto;
import fr.iutinfo.skeleton.common.dto.SalarieDto;

public class Salarie {

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

	public Salarie(){}

	public Salarie(String nom, String prenom, String nationnalite, Calendar dateNaissance, String adresse, String renumeration, String numeroSecu) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.dateNaissance = dateNaissance;
		this.adresse = adresse;
		this.renumeration = renumeration;
	}

	public Salarie(String nom, String prenom, String nationnalite, Calendar dateNaissance, String adresse,
			String departement, String typeContrat, String tempsContrat, String debutContrat, String finContrat,
			String renumeration, String numeroSecu) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.nationnalite = nationnalite;
		this.dateNaissance = dateNaissance;
		this.adresse = adresse;
		this.departement = departement;
		this.typeContrat = typeContrat;
		this.tempsContrat = tempsContrat;
		this.debutContrat = debutContrat;
		this.finContrat = finContrat;
		this.renumeration = renumeration;
		this.numeroSecu = numeroSecu;
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


	public void initFromDto(SalarieDto dto) throws Exception {
		this.setNom(dto.getNom());
		this.setPrenom(dto.getPrenom());
		this.setAdresse(dto.getAdresse());
		this.setDateNaissance(dto.getDateNaissance());
		this.setNationnalite(dto.getNationnalite());
		this.setDepartement(dto.getDepartement());
		this.setTypeContrat(dto.getTypeContrat());
		this.setTempsContrat(dto.getTempsContrat());
		this.setDebutContrat(dto.getDebutContrat());
		this.setFinContrat(dto.getFinContrat());
		this.setRenumeration(dto.getRenumeration());
		this.setNumeroSecu(dto.getNumeroSecu());
	}
	

	public SalarieDto convertToDto(){
		SalarieDto dto = new SalarieDto();
		dto.setNom(getNom());
		dto.setPrenom(getPrenom());
		dto.setAdresse(getAdresse());
		dto.setDateNaissance(getDateNaissance());
		dto.setNationnalite(getNationnalite());
		dto.setDepartement(getDepartement());
		dto.setTypeContrat(getTypeContrat());
		dto.setTempsContrat(getTempsContrat());
		dto.setDebutContrat(getDebutContrat());
		dto.setFinContrat(getFinContrat());
		dto.setRenumeration(getRenumeration());
		dto.setNumeroSecu(getNumeroSecu());
		return dto;
	}
}
