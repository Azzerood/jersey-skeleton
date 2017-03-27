package fr.iutinfo.skeleton.planning;

import fr.iutinfo.skeleton.common.dto.ParentDto;

public class Parent {

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

	public Parent(){}



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
	
	
	public void initFromDto(ParentDto dto) throws Exception {
		this.setNom(dto.getNom());
		this.setPrenom(dto.getPrenom());
		this.setAdresse(dto.getAdresse());
		this.setDateNaissance(dto.getDateNaissance());
		this.setProfession(dto.getProfession());
		this.setCategorieCaf(dto.getCategorieCaf());
		this.setNumeroCaf(dto.getNumeroCaf());
		this.setDureeContrat(dto.getDureeContrat);
		this.setConges(dto.getConges());
		this.setTypeContrat(dto.getTypeContrat());
		this.setNumero(dto.getNumero());
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
		dto.setConges(getCongés());
		dto.setTypeContrat(getTypeContrat());
		dto.setNumero(getNumero());
		dto.setDureeContrat(getDureeContrat);
		return dto;
	}
    
}             


