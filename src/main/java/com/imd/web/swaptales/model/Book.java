package com.imd.web.swaptales.model;

import java.util.Date;
import java.util.Objects;

import com.imd.web.swaptales.enums.ConditionBook;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Book extends AbstractEntity{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(length = 200, nullable = false)
	private String title;
	
	@Column(length = 200, nullable = false)
	private String author;
	
	@Column(name = "publishing_year")
	private Date publishingYear;

	@Enumerated(EnumType.STRING)
	private ConditionBook conditionBook;

	@Column
	private int edition;

	@Column
	private String description;
	
	@ManyToOne
    @JoinColumn(name = "user_id")
    private User ownerUser;
	
	@Column(name= "publishing_company", length = 200)
	private String publishingCompany;

	@Override
	public int hashCode() {
		return Objects.hash(author, conditionBook, description, edition, id, publishingCompany, publishingYear, title);
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
		return Objects.equals(author, other.author) && conditionBook == other.conditionBook
				&& Objects.equals(description, other.description) && edition == other.edition
				&& Objects.equals(id, other.id) && Objects.equals(publishingCompany, other.publishingCompany)
				&& Objects.equals(publishingYear, other.publishingYear) && Objects.equals(title, other.title);
	}
}