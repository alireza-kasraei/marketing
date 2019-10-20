package net.devk.authorization.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "SCOPES_CLIENTS")
public class ScopeClient extends AbstractModel {

	private static final String SCOPE_CLIENT_SEQUENCE_NAME = "sc_sequence";

	private static final String SCOPE_CLIENT_GENERATOR_NAME = "scope_client_generator";

	@Id
	@GeneratedValue(generator = SCOPE_CLIENT_GENERATOR_NAME)
	@SequenceGenerator(name = SCOPE_CLIENT_GENERATOR_NAME, sequenceName = SCOPE_CLIENT_SEQUENCE_NAME, initialValue = 1, allocationSize = 1)
	@EqualsAndHashCode.Include
	private Long id;

	@ManyToOne
	@JoinColumn(name = "SCOPE_ID")
	private Scope scope;

	@ManyToOne
	@JoinColumn(name = "CLIENT_ID")
	private Client client;

	@Column(name = "AUTO_APPROVED")
	private Boolean autoApproved;

}
