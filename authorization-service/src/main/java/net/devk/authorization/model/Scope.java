package net.devk.authorization.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
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
@Table(name = "SCOPES", uniqueConstraints = { @UniqueConstraint(columnNames = "SCOPE_NAME") })
public class Scope extends AbstractModel {

	private static final String SCOPE_SEQUENCE_NAME = "SCOPE_SEQUENCE";

	private static final String SCOPE_GENERATOR_NAME = "SCOPE_GENERATOR";

	@Id
	@EqualsAndHashCode.Include
	@GeneratedValue(generator = SCOPE_GENERATOR_NAME)
	@SequenceGenerator(name = SCOPE_GENERATOR_NAME, sequenceName = SCOPE_SEQUENCE_NAME, initialValue = 1, allocationSize = 1)
	private Long id;

	@Column(name = "SCOPE_NAME")
	private String name;

	@Column(name = "DESCRIPTION")
	private String description;

}
