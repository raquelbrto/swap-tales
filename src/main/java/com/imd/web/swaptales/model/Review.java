package com.imd.web.swaptales.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

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
	private Double stars;
	@Column
	private Integer likesCount;
	@Column
	private String text;
	@Column(name = "review_date")
	private LocalDate reviewDate;
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User authorReview;
	@ManyToOne
	@JoinColumn(name = "book_id")
	private Book book;
}
