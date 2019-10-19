package net.devk.marketing.security.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import net.devk.commons.jpa.model.AbstractModel;

@EqualsAndHashCode(callSuper = true, onlyExplicitlyIncluded = true)
@Data
@NoArgsConstructor
@Entity
@Table(name = "AUTHORITIES", uniqueConstraints = { @UniqueConstraint(columnNames = "AUTHORITY_NAME") })
public class Authority extends AbstractModel {

	private static final String AUTHORITY_SEQUENCE_NAME = "authority_sequence";

	private static final String AUTHORITY_GENERATOR_NAME = "authority_generator";

	@Id
	@GeneratedValue(generator = AUTHORITY_GENERATOR_NAME)
	@SequenceGenerator(name = AUTHORITY_GENERATOR_NAME, sequenceName = AUTHORITY_SEQUENCE_NAME, initialValue = 1, allocationSize = 1)
	@EqualsAndHashCode.Include
	private Long id;

	@Column(name = "AUTHORITY_NAME")
	private String name;

	@Column(name = "DESCRIPTION")
	private String description;

	@ManyToOne
	@JoinColumn(name = "CLIENT_ID")
	private Client client;

}
