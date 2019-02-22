package net.devk.marketing.security.model;

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
@Table(name = "SCOPES", uniqueConstraints = { @UniqueConstraint(columnNames = "SCOPE_NAME") })
public class Scope extends AbstractModel {

	@Id
	@EqualsAndHashCode.Include
	@GeneratedValue(generator = "scope_generator")
	@SequenceGenerator(name = "scope_generator", sequenceName = "scope_sequence", initialValue = 1, allocationSize = 1)
	private Long id;

	@Column(name = "SCOPE_NAME")
	private String name;

	@Column(name = "DESCRIPTION")
	private String description;

	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "scopes")
	private Set<Client> clients = new HashSet<Client>(0);

}
