package com.imd.web.swaptales.model;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.imd.web.swaptales.enums.AvailabilityStatus;
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
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Book extends AbstractEntity{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(length = 200, nullable = false)
	private String title;
	
	@Column(length = 200)
	private String author;
	
	@Column
	private Integer publishingYear;

	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private ConditionBook conditionBook;

	@Column
	private Integer edition;

	@Column(length = 1000)
	private String description;
	
	@Column
	private String urlImg;
	
	@Column
	private String idioma;
	
	@ManyToOne
    @JoinColumn(name = "user_id")
    private User ownerUser;
	
	@Column(length = 200)
	private String publishingCompany;

	@OneToMany(mappedBy = "book")
    private List<Review> reviews;

	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private AvailabilityStatus availabilityStatus;

	@Column
	private Double price;

	@Column
	private Integer countDaysLoan;


	@Override
	public int hashCode() {
		return Objects.hash(author, conditionBook, description, edition, id, idioma, ownerUser, publishingCompany,
				publishingYear, reviews, title, urlImg, availabilityStatus, price);
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
				&& Objects.equals(description, other.description) && Objects.equals(edition, other.edition)
				&& Objects.equals(id, other.id) && Objects.equals(idioma, other.idioma)
				&& Objects.equals(ownerUser, other.ownerUser)
				&& Objects.equals(publishingCompany, other.publishingCompany)
				&& Objects.equals(publishingYear, other.publishingYear) && Objects.equals(reviews, other.reviews)
				&& Objects.equals(title, other.title) && Objects.equals(urlImg, other.urlImg)
				&& Objects.equals(availabilityStatus, other.availabilityStatus) && Objects.equals(price, other.price);
	}	
}