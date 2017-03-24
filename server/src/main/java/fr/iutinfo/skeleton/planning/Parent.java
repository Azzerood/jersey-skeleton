package fr.iutinfo.skeleton.planning;

import java.util.Calendar;

import fr.iutinfo.skeleton.common.dto.ParentDto;

public class Parent {

	private String nom;
	private String prenom;
	private Calendar dateNaissance;
	private String adresse;
	private String congés;
	private String profession;
	private String numeroCaf;
	private String categorieCaf;
	private String debutContrat;
	private String finContrat;
	private String typeContrat;
	private String numero;

	public Parent(){}

	
	public Parent(String nom, String prenom, Calendar dateNaissance, String adresse, String numero) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.dateNaissance = dateNaissance;
		this.adresse = adresse;
		this.numero = numero;
	}


	public Parent(String nom, String prenom, Calendar dateNaissance, String adresse, String congés, String profession,
			String numeroCaf, String categorieCaf, String debutContrat, String finContrat, String typeContrat,
			String numero) {
		this.nom = nom;
		this.prenom = prenom;
		this.dateNaissance = dateNaissance;
		this.adresse = adresse;
		this.congés = congés;
		this.profession = profession;
		this.numeroCaf = numeroCaf;
		this.categorieCaf = categorieCaf;
		this.debutContrat = debutContrat;
		this.finContrat = finContrat;
		this.typeContrat = typeContrat;
		this.numero = numero;
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


	public String getCongés() {
		return congés;
	}


	public void setCongés(String congés) {
		this.congés = congés;
	}


	public String getProfession() {
		return profession;
	}


	public void setProfession(String profession) {
		this.profession = profession;
	}


	public String getNumeroCaf() {
		return numeroCaf;
	}


	public void setNumeroCaf(String numeroCaf) {
		this.numeroCaf = numeroCaf;
	}


	public String getCategorieCaf() {
		return categorieCaf;
	}


	public void setCategorieCaf(String categorieCaf) {
		this.categorieCaf = categorieCaf;
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


	public String getTypeContrat() {
		return typeContrat;
	}


	public void setTypeContrat(String typeContrat) {
		this.typeContrat = typeContrat;
	}


	public String getNumero() {
		return numero;
	}


	public void setNumero(String numero) {
		this.numero = numero;
	}
	
	
	public void initFromDto(ParentDto dto) throws Exception {
		this.setNom(getNom());
		this.setPrenom(getPrenom());
		this.setAdresse(getAdresse());
		this.setDateNaissance(getDateNaissance());
		this.setProfession(getProfession());
		this.setCategorieCaf(getCategorieCaf());
		this.setNumeroCaf(getNumeroCaf());
		this.setDebutContrat(getDebutContrat());
		this.setFinContrat(getFinContrat());
		this.setCongés(getCongés());
		this.setTypeContrat(getTypeContrat());
		this.setNumero(getNumero());
	 }
	

	public ParentDto convertToDto(){
		ParentDto dto = new ParentDto();
		dto.setNom(getNom());
		dto.setPrenom(getPrenom());
		dto.setAdresse(getAdresse());
		dto.setDateNaissance(getDateNaissance());
		dto.setProfession(getProfession());
		dto.setCategorieCaf(getCategorieCaf());
		dto.setNumeroCaf(getNumeroCaf());
		dto.setDebutContrat(getDebutContrat());
		dto.setFinContrat(getFinContrat());
		dto.setCongés(getCongés());
		dto.setTypeContrat(getTypeContrat());
		dto.setNumero(getNumero());
		return dto;
	}
}
