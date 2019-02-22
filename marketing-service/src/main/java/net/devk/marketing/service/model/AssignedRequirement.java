package net.devk.marketing.service.model;

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

@Data
@EqualsAndHashCode(callSuper = true, onlyExplicitlyIncluded = true)
@Entity
@Table(name = "ASSIGNED_REQUIREMENTS")
@NoArgsConstructor
public class AssignedRequirement extends AbstractModel {

	private static final String ASSIGNED_REQUIREMENTS_GENERATOR = "assigned_requirements_generator";

	@GeneratedValue(generator = ASSIGNED_REQUIREMENTS_GENERATOR)
	@SequenceGenerator(name = ASSIGNED_REQUIREMENTS_GENERATOR, sequenceName = "assigned_requirements_sequence", initialValue = 1, allocationSize = 1)
	@Id
	@EqualsAndHashCode.Include
	private Long id;

	@Column(name = "DESCRIPTION")
	private String description;

	@ManyToOne
	@JoinColumn(name = "CUSTOMER_REQUIREMENT_ID")
	private Requirement customerRequirment;

	@ManyToOne
	@JoinColumn(name = "PERSONNEL_ID")
	private Personnel personnel;

}
