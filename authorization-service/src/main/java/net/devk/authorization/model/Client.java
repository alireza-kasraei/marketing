package net.devk.authorization.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
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
@Table(name = "CLIENTS")
public class Client extends AbstractModel {

	private static final String CLIENT_SEQUENCE_NAME = "CLIENT_SEQUENCE";

	private static final String CLIENT_GENERATOR_NAME = "CLIENT_GENERATOR";

	@Id
	@EqualsAndHashCode.Include
	@GeneratedValue(generator = CLIENT_GENERATOR_NAME)
	@SequenceGenerator(name = CLIENT_GENERATOR_NAME, sequenceName = CLIENT_SEQUENCE_NAME, initialValue = 3, allocationSize = 1)
	private Long id;

	@Column(name = "CLIENT_NAME")
	private String name;

	@Column(name = "SECRET")
	private String secret;

	// "authorization_code", "refresh_token", "password" });
	@OneToMany(cascade = { CascadeType.ALL }, mappedBy = "client", fetch = FetchType.LAZY, orphanRemoval = true)
	private Set<ScopeClient> scopeClients = new HashSet<>();

	@OneToMany(cascade = { CascadeType.ALL }, mappedBy = "client", fetch = FetchType.LAZY, orphanRemoval = true)
	private Set<Redirect> redirects = new HashSet<>();

	@OneToMany(cascade = { CascadeType.ALL }, mappedBy = "client", fetch = FetchType.LAZY, orphanRemoval = true)
	private Set<ClientGrantType> grantTypes = new HashSet<>();

	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "clients")
	private Set<Authority> authorities = new HashSet<>();

}
