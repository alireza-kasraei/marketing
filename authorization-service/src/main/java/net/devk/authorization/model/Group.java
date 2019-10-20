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
@Table(name = "GROUPS", uniqueConstraints = { @UniqueConstraint(columnNames = "GROUP_NAME") })
public class Group extends AbstractModel {

	private static final String GROUP_SEQUENCE_NAME = "GROUPS_SEQUENCE";

	private static final String GROUP_GENERATOR_NAME = "GROUPS_GENERATOR";

	@Id
	@GeneratedValue(generator = GROUP_GENERATOR_NAME)
	@SequenceGenerator(name = GROUP_GENERATOR_NAME, sequenceName = GROUP_SEQUENCE_NAME, initialValue = 1, allocationSize = 1)
	@EqualsAndHashCode.Include
	private Long id;

	/**
	 * name of a group
	 */
	@Column(name = "GROUP_NAME")
	private String name;

	/**
	 * group's description
	 */
	@Column(name = "DESCRIPTION")
	private String description;

	/**
	 * set of roles
	 */
	@ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST })
	@JoinTable(name = "ROLES_GROUPS", joinColumns = {
			@JoinColumn(name = "GROUP_ID", nullable = false, updatable = false) }, inverseJoinColumns = {
					@JoinColumn(name = "ROLE_ID", nullable = false, updatable = false) })
	private Set<Role> roles = new HashSet<>();

	/**
	 * bidirectional relation with {@link UserEntity} , indicates users of a group.
	 */
	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "groups")
	private Set<User> users = new HashSet<>();

}
