package net.devk.marketing.security.users;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "USERS")
public class User {

	@Id
	@GeneratedValue(generator = "user_generator")
	@SequenceGenerator(name = "user_generator", sequenceName = "user_sequence", initialValue = 1)
	private Long id;

	private String username, password, email, mobileNumber;

	private boolean active;

	public User(String username, String password, boolean active) {
		this.username = username;
		this.password = password;
		this.active = active;
	}

}
