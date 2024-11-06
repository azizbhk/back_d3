package com.aziz.voyages.entities;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;
@Entity

public class voyage {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long idvoyage;
	@NotNull
	@Size (min = 4,max = 15)
	private String nomvoyage;
	@Min(value = 10)
	@Max(value = 10000)
	private Double prixvoyage;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@PastOrPresent
	private Date dateCreation;
	public List<Image> getImages() {
		return images;
	}
	public void setImages(List<Image> images) {
		this.images = images;
	}
	public Image getImage() {
		return image;
	}
	public void setImage(Image image) {
		this.image = image;
	}
	@ManyToOne
	private Categorie categorie;
	
	@OneToOne
	private Image image ;
	
	public Categorie getCategorie() {
		return categorie;
	}
	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}
	public Long getIdvoyage() {
		return idvoyage;
	}
	public voyage() {
		super();
	
	}
	@OneToMany (mappedBy = "voyage")
	 private List<Image> images;

	public voyage(String nomvoyage, Double prixvoyage, Date dateCreation) {
		super();
		this.nomvoyage = nomvoyage;
		this.prixvoyage = prixvoyage;
		this.dateCreation = dateCreation;
	}
	public void setIdvoyage(Long idvoyage) {
		this.idvoyage = idvoyage;
	}
	public String getNomvoyage() {
		return nomvoyage;
	}
	public void setNomvoyage(String nomvoyage) {
		this.nomvoyage = nomvoyage;
	}
	public Double getPrixvoyage() {
		return prixvoyage;
	}
	public void setPrixvoyage(Double prixvoyage) {
		this.prixvoyage = prixvoyage;
	}
	public Date getDateCreation() {
		return dateCreation;
	}
	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}
	@Override
	public String toString() {
		return "voyage [idvoyage=" + idvoyage + ", nomvoyage=" + nomvoyage + ", prixvoyage=" + prixvoyage
				+ ", dateCreation=" + dateCreation + "]";
	}

	
	

}
