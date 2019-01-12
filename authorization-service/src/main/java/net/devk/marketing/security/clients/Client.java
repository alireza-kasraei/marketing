package net.devk.marketing.security.clients;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "CLIENTS")
public class Client {

	@Id
	@GeneratedValue(generator = "client_generator")
	@SequenceGenerator(name = "client_generator", sequenceName = "client_sequence", initialValue = 3)
	private Long id;

	@Column(name = "CLIENT_ID")
	private String clientId;

	@Column(name = "SECRET")
	private String secret;

	@Column(name = "SCOPES")
	private String scopes; // = StringUtils.arrayToCommaDelimitedString(new String[] { "openid" });

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
