package net.devk.authorization.model;

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

	private static final String AUTHORITY_SEQUENCE_NAME = "AUTHORITY_SEQUENCE";

	private static final String AUTHORITY_GENERATOR_NAME = "AUTHORITY_GENERATOR";

	@Id
	@GeneratedValue(generator = AUTHORITY_GENERATOR_NAME)
	@SequenceGenerator(name = AUTHORITY_GENERATOR_NAME, sequenceName = AUTHORITY_SEQUENCE_NAME, initialValue = 1, allocationSize = 1)
	@EqualsAndHashCode.Include
	private Long id;

	@Column(name = "AUTHORITY_NAME")
	private String name;

	@Column(name = "DESCRIPTION")
	private String description;

	@ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST })
	@JoinTable(name = "AUTHORITIES_CLIENTS", joinColumns = {
			@JoinColumn(name = "CLIENT_ID", nullable = false, updatable = false) }, inverseJoinColumns = {
					@JoinColumn(name = "AUTHORITY_ID", nullable = false, updatable = false) })
	private Set<Client> clients = new HashSet<>();

}
