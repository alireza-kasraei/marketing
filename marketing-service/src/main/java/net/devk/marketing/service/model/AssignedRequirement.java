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
@Table(name = "ASSIGNED_REQUIREMENTS")
@NoArgsConstructor
public class AssignedRequirement {

	private static final String ASSIGNED_REQUIREMENTS_GENERATOR = "assigned_requirements_generator";

	@GeneratedValue(generator = ASSIGNED_REQUIREMENTS_GENERATOR)
	@SequenceGenerator(name = ASSIGNED_REQUIREMENTS_GENERATOR, sequenceName = "assigned_requirements_sequence", initialValue = 1)
	private Long id;

	@Column(name = "REGISTER_DATE")
	private Date registerDate;

	@Column(name = "DESCRIPTION")
	private String description;

	@ManyToOne
	@Column(name = "CUSTOMER_REQUIREMENT_ID")
	private Requirment customerRequirment;

	@ManyToOne
	@Column(name = "PERSONNEL_ID")
	private Personnel personnel;

}
