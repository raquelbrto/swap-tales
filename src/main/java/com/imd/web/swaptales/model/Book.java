package com.imd.web.swaptales.model;

import java.util.Date;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.imd.web.swaptales.enums.ConditionBook;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Book extends AbstractEntity{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(length = 200)
	private String title;
	
	@Column(length = 200)
	private String author;
	
	@Column
	private Integer publishingYear;

	@Enumerated(EnumType.STRING)
	private ConditionBook conditionBook;

	@Column
	private Integer edition;

	@Column
	private String description;
	
	@Column
	private String url_img;
	
	@ManyToOne
    @JoinColumn(name = "user_id")
    private User ownerUser;
	
	@Column(length = 200)
	private String publishingCompany;

	@OneToMany(mappedBy = "book")
    private List<Review> reviews;
	
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