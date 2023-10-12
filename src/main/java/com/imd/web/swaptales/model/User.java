package com.imd.web.swaptales.model;

import java.io.Serial;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class User extends AbstractEntity implements UserDetails {

	@Serial
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(length = 200, nullable = false)
	private String name;
	
	@Column
	private String cpf;
	
	@Column(length = 200, nullable = false)
	private String email;
	
	@Column
	private String telephone;
	
	@Column(length = 200, nullable = false)
	private String username;
	
	@Column
	@JsonIgnore
	private String password;

	@OneToMany(mappedBy = "author_review")
	private List<Review> reviews = new ArrayList<>();

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable( name = "permission",
			joinColumns = {@JoinColumn(
					name = "user_id"
			)},
			inverseJoinColumns = {@JoinColumn(
					name = "role_id"
			)})
	private List<Role> permissions = new ArrayList();

	@Override
	public int hashCode() {
		return Objects.hash(telephone, cpf, email, id, name, username, password);
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
				&& Objects.equals(name, other.name) && Objects.equals(username, other.username)
				&& Objects.equals(password, other.password);
	}


	@Override
	@JsonIgnore
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return this.permissions;
	}

	@Override
	public boolean isAccountNonExpired() {
		return this.getActive();
	}

	@Override
	public boolean isAccountNonLocked() {
		return this.getActive();
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return this.getActive();
	}

	@Override
	public boolean isEnabled() {
		return this.getActive();
	}


}