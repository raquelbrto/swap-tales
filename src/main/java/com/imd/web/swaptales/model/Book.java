package com.imd.web.swaptales.model;

import java.util.Date;
import java.util.Objects;

import com.imd.web.swaptales.enums.ConditionBook;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class Book {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(length = 200, nullable = false)
	private String title;
	
	@Column(length = 200, nullable = false)
	private String Author;
	
	@Column(name = "publishing_year")
	private Date publishingYear;
	
	private ConditionBook condition;
	
	private int edition;
	
	private String description;
	
	@ManyToOne
    @JoinColumn(name = "usuario_id")
    private Account usuarioProprietario;
	
	@Column(name= "publishing_company", length = 200)
	private String publishingCompany;

	@Override
	public int hashCode() {
		return Objects.hash(Author, condition, description, edition, id, publishingCompany, publishingYear, title);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		return Objects.equals(Author, other.Author) && condition == other.condition
				&& Objects.equals(description, other.description) && edition == other.edition
				&& Objects.equals(id, other.id) && Objects.equals(publishingCompany, other.publishingCompany)
				&& Objects.equals(publishingYear, other.publishingYear) && Objects.equals(title, other.title);
	}
}