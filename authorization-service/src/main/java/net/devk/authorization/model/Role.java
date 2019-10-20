package net.devk.authorization.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
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
@Table(name = "ROLES", uniqueConstraints = { @UniqueConstraint(columnNames = "ROLE_NAME") })
public class Role extends AbstractModel {

	private static final String ROLE_SEQUENCE_NAME = "role_sequence";

	private static final String ROLE_GENERATOR_NAME = "role_generator";

	@Id
	@GeneratedValue(generator = ROLE_GENERATOR_NAME)
	@SequenceGenerator(name = ROLE_GENERATOR_NAME, sequenceName = ROLE_SEQUENCE_NAME, initialValue = 1, allocationSize = 1)
	@EqualsAndHashCode.Include
	private Long id;

	@Column(name = "ROLE_NAME")
	private String name;

	@Column(name = "DESCRIPTION")
	private String description;

	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "roles")
	private Set<Group> groups = new HashSet<>();

}
