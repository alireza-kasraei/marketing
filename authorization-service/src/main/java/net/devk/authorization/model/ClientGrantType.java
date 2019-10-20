package net.devk.authorization.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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

	private static final String CLIENT_GRANT_TYPE_SEQUENCE_NAME = "CGT_SEQUENCE";

	private static final String CLIENT_GRANT_TYPE_GENERATOR_NAME = "CGT_GENERATOR";

	@Id
	@GeneratedValue(generator = CLIENT_GRANT_TYPE_GENERATOR_NAME)
	@SequenceGenerator(name = CLIENT_GRANT_TYPE_GENERATOR_NAME, sequenceName = CLIENT_GRANT_TYPE_SEQUENCE_NAME, initialValue = 1, allocationSize = 1)
	@EqualsAndHashCode.Include
	private Long id;

	@Column(name = "TYPE_NAME")
	@Enumerated(EnumType.STRING)
	private GrantType grantType;

	@ManyToOne
	@JoinColumn(name = "CLIENT_ID")
	private Client client;

}
