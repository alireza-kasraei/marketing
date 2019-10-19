package net.devk.marketing.security.model;

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
@Table(name = "CLIENT_GRANT_TYPES")
public class ClientGrantType extends AbstractModel {

	private static final String CLIENT_GRANT_TYPE_SEQUENCE_NAME = "cgt_sequence";

	private static final String CLIENT_GRANT_TYPE_GENERATOR_NAME = "cgt_generator";

	@Id
	@GeneratedValue(generator = CLIENT_GRANT_TYPE_GENERATOR_NAME)
	@SequenceGenerator(name = CLIENT_GRANT_TYPE_GENERATOR_NAME, sequenceName = CLIENT_GRANT_TYPE_SEQUENCE_NAME, initialValue = 1, allocationSize = 1)
	@EqualsAndHashCode.Include
	private Long id;

	@Column(name = "TYPE_NAME")
	private GrantType grantType;

	@ManyToOne
	@JoinColumn(name = "CLIENT_ID")
	private Client client;

}
