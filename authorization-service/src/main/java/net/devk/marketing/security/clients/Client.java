package net.devk.marketing.security.clients;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.util.StringUtils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "CLIENTS")
public class Client {

	@Id
	@GeneratedValue(generator = "client_generator")
	@SequenceGenerator(name = "client_generator", sequenceName = "client_sequence", initialValue = 1)
	private Long id;

	private String clientId;

	private String secret;

	private String scopes = StringUtils.arrayToCommaDelimitedString(new String[] { "openid" });

	private String authorizedGrantTypes = StringUtils
			.arrayToCommaDelimitedString(new String[] { "authorization_code", "refresh_token", "password" });

	private String authorities = StringUtils.arrayToCommaDelimitedString(new String[] { "ROLE_USER", "ROLE_ADMIN" });

	private String autoApproveScopes = StringUtils.arrayToCommaDelimitedString(new String[] { ".*" });

	public Client(String clientId, String clientSecret) {
		this.clientId = clientId;
		this.secret = clientSecret;
	}
}
