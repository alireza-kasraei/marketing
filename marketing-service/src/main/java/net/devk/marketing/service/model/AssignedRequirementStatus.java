package net.devk.marketing.service.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "ASSIGNED_REQUIREMENTS_STATUSES")
@NoArgsConstructor
public class AssignedRequirementStatus {

	private static final String ASSIGNED_REQUIREMENTS_STATUSES_GENERATOR = "assigned_requirements_statuses_generator";

	@GeneratedValue(generator = ASSIGNED_REQUIREMENTS_STATUSES_GENERATOR)
	@SequenceGenerator(name = ASSIGNED_REQUIREMENTS_STATUSES_GENERATOR, sequenceName = "assigned_requirements_statuses_sequence", initialValue = 1)
	private Long id;

	@Column(name = "REGISTER_DATE")
	private Date registerDate;

	@ManyToOne
	@Column(name = "ASSIGNED_STATUS_TYPE_ID")
	private AssignedStatusType assignedStatusType;
	
	@ManyToOne
	@Column(name = "ASSIGNED_REQUIREMENT_ID")
	private AssignedRequirement assignedRequirement;

}
