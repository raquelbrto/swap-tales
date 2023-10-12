package com.imd.web.swaptales.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Review extends AbstractEntity{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column
	private double stars;

	@Column
	private int likes_count;

	@Column
	private String text;

	@Column(name = "review_date")
	private String reviewDate;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private User author_review;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "book_id")
	private Book book;

}
