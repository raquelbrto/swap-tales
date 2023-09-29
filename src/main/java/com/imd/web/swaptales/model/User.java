package com.imd.web.swaptales.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Data
@Entity
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(length = 200, nullable = false)
	private String name;
	
	@Column(length = 11, nullable = false)
	private String cpf;
	
	@Column(length = 200, nullable = false)
	private String email;
	
	@Column(length = 11, nullable = false)
	private String telephone;
	
	@Column(name= "nick_name", length = 200, nullable = false)
	private String nickName;
	
	@Column(length = 10, nullable = false)
	private String password;

	@OneToMany(mappedBy = "user")
	private List<Review> reviews = new ArrayList<>();

	@Override
	public int hashCode() {
		return Objects.hash(telephone, cpf, email, id, name, nickName, password);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(telephone, other.telephone) && Objects.equals(cpf, other.cpf)
				&& Objects.equals(email, other.email) && Objects.equals(id, other.id)
				&& Objects.equals(name, other.name) && Objects.equals(nickName, other.nickName)
				&& Objects.equals(password, other.password);
	}
}