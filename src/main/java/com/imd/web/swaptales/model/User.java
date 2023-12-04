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

	@Column
	private String urlImg;

	@ManyToMany
	@JoinTable(
			name = "user_follower",
			joinColumns = @JoinColumn(name = "user_id"),
			inverseJoinColumns = @JoinColumn(name = "follower_id")
	)
	@JsonIgnore
	private List<User> followers = new ArrayList<>();

	@ManyToMany
	@JoinTable(
			name = "user_following",
			joinColumns = @JoinColumn(name = "user_id"),
			inverseJoinColumns = @JoinColumn(name = "following_id")
	)
	@JsonIgnore
	private List<User> following = new ArrayList<>();


	@ManyToMany
	@JoinTable(
			name = "user_review_like",
			joinColumns = @JoinColumn(name = "user_id"),
			inverseJoinColumns = @JoinColumn(name = "review_id")
	)
	private List<Review> likedReviews;

	@ManyToMany
	@JoinTable(
			name = "user_book_favorite",
			joinColumns = @JoinColumn(name = "user_id"),
			inverseJoinColumns = @JoinColumn(name = "book_id")
	)
	private List<Book> favoriteBooks;

	@Column
	private Long countFollowers;

	@ElementCollection(targetClass = Role.class, fetch = FetchType.EAGER)
	@CollectionTable(name = "roles", joinColumns = @JoinColumn(name = "user_id"))
	@Enumerated(EnumType.STRING)
	@Column(name = "permissions")
	private List<Role> permissions = new ArrayList();

	@Override
	public int hashCode() {
		return Objects.hash(telephone, cpf, email, id, name, username, password, urlImg);
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
				&& Objects.equals(password, other.password) && Objects.equals(urlImg, other.urlImg);
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