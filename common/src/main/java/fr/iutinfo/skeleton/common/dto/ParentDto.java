package fr.iutinfo.skeleton.common.dto;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.security.Principal;
import java.util.Calendar;

public class ParentDto implements Principal {
    final static Logger logger = LoggerFactory.getLogger(ParentDto.class);

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
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}
}
