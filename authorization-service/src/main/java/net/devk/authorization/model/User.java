package net.devk.authorization.model;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import net.devk.commons.jpa.model.AbstractModel;

@EqualsAndHashCode(callSuper = true, onlyExplicitlyIncluded = true)
@Data
@NoArgsConstructor
@Entity
@Table(name = "USERS")
public class User extends AbstractModel {

	private static final String USER_SEQUENCE_NAME = "user_sequence";

	private static final String USER_GENERATOR_NAME = "user_generator";

	@Id
	@GeneratedValue(generator = USER_GENERATOR_NAME)
	@SequenceGenerator(name = USER_GENERATOR_NAME, sequenceName = USER_SEQUENCE_NAME, initialValue = 1, allocationSize = 1)
	@EqualsAndHashCode.Include
	private Long id;

	@Column(name = "USER_NAME")
	private String username;
	@Column(name = "PASS_WORD")
	private String password;
	@Column(name = "EMAIL")
	private String email;
	@Column(name = "MOBILE_NUMBER")
	private String mobileNumber;
	@Column(name = "FIRST_NAME")
	private String firstName;
	@Column(name = "LAST_NAME")
	private String lastName;
	@Column(name = "EXP_DATE")
	private LocalDate expireDate;
	@Column(name = "CRE_EXP_DATE")
	private LocalDate credentialExpireDate;
	@Column(name = "ENABLED")
	private boolean enabled;
	@Column(name = "LOCKED")
	private boolean locked;

	@ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.REFRESH })
	@JoinTable(name = "USERS_GROUPS", joinColumns = {
			@JoinColumn(name = "USER_ID", nullable = false) }, inverseJoinColumns = {
					@JoinColumn(name = "GROUP_ID", nullable = false) })
	private Set<Group> groups = new HashSet<>();

}
