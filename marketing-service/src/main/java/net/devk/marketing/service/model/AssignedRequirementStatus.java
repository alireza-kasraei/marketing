package net.devk.marketing.service.model;

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

@Data
@EqualsAndHashCode(callSuper = true, onlyExplicitlyIncluded = true)
@Entity
@Table(name = "ASSIGNED_REQUIREMENTS_STATUSES")
@NoArgsConstructor
public class AssignedRequirementStatus extends AbstractModel {

	private static final String ASSIGNED_REQUIREMENTS_STATUSES_GENERATOR = "assigned_requirements_statuses_generator";

	@GeneratedValue(generator = ASSIGNED_REQUIREMENTS_STATUSES_GENERATOR)
	@SequenceGenerator(name = ASSIGNED_REQUIREMENTS_STATUSES_GENERATOR, sequenceName = "ars_sequence", initialValue = 1, allocationSize = 1)
	@Id
	@EqualsAndHashCode.Include
	private Long id;

	@ManyToOne
	@JoinColumn(name = "ASSIGNED_STATUS_TYPE_ID")
	private AssignedStatusType assignedStatusType;

	@ManyToOne
	@JoinColumn(name = "ASSIGNED_REQUIREMENT_ID")
	private AssignedRequirement assignedRequirement;

}
