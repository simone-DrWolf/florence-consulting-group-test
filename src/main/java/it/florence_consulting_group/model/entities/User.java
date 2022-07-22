package it.florence_consulting_group.model.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "`User`")
public class User {

	@Id
	@GeneratedValue
	private Long id;

	@Column(nullable = false)
	@NotNull
	private String name;

	@Column(nullable = false)
	@NotNull
	private String lastname;

	@Column(nullable = false)
	@NotNull
	private String email;

	private String address;

	public String getAddress() {
		return this.address;
	}

	public String getEmail() {
		return this.email;
	}

	public Long getId() {
		return this.id;
	}

	public String getLastname() {
		return this.lastname;
	}

	public String getName() {
		return this.name;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public void setName(String name) {
		this.name = name;
	}
}