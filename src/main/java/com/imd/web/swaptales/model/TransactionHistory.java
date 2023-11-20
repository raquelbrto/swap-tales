package com.imd.web.swaptales.model;

import java.util.Date;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;


@MappedSuperclass
@EntityListeners({AuditingEntityListener.class})
@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class TransactionHistory extends AbstractEntity{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column
	private Double price;

	@ManyToOne
	@JoinColumn(name = "user_id")
    private User user;

	@ManyToOne
	@JoinColumn(name = "book_id")
    private Book book;

	@Column
	private Date dateTransaction;
}
