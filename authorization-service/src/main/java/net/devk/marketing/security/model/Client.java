package net.devk.marketing.security.model;

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
@Table(name = "CLIENTS")
public class Client extends AbstractModel {

	@Id
	@EqualsAndHashCode.Include
	@GeneratedValue(generator = "client_generator")
	@SequenceGenerator(name = "client_generator", sequenceName = "client_sequence", initialValue = 3, allocationSize = 1)
	private Long id;

	@Column(name = "CLIENT_ID")
	private String clientId;

	@Column(name = "SECRET")
	private String secret;

	// "openid"
	@ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST })
	@JoinTable(name = "CLIENTS_SCOPES", joinColumns = {
			@JoinColumn(name = "CLIENT_ID", nullable = false, updatable = false) }, inverseJoinColumns = {
					@JoinColumn(name = "SCOPE_ID", nullable = false, updatable = false) })
	private Set<Scope> scopes = new HashSet<Scope>();

	@Column(name = "GRANT_TYPES")
	private String authorizedGrantTypes;// = StringUtils.arrayToCommaDelimitedString(new String[] {
										// "authorization_code", "refresh_token", "password" });

	@Column(name = "AUTHORITIES")
	private String authorities;// = StringUtils.arrayToCommaDelimitedString(new String[] { "ROLE_USER",
								// "ROLE_ADMIN" });

	@Column(name = "AUTHO_APPROVE_SCOPES")
	private String autoApproveScopes;// = StringUtils.arrayToCommaDelimitedString(new String[] { ".*" });

	@Column(name = "REDIRECT_URLS")
	private String redirectUrls;// = StringUtils.arrayToCommaDelimitedString(new String[] { ".*" });

}
