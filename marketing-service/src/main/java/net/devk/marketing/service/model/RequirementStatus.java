package net.devk.marketing.service.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "REQUIREMENT_STATUSES")
@NoArgsConstructor
public class RequirementStatus {

	private static final String REQUIREMENT_STATUSES_GENERATOR = "requirement_statuses_generator";

	@GeneratedValue(generator = REQUIREMENT_STATUSES_GENERATOR)
	@SequenceGenerator(name = REQUIREMENT_STATUSES_GENERATOR, sequenceName = "requirement_statuses_sequence", initialValue = 1)
	private Long id;

	@Column(name = "REGISTER_DATE")
	private Date registerDate;

	@ManyToOne(fetch = FetchType.LAZY)
	@Column(name = "REQUIREMENT_STATUS_TYPE_ID")
	private RequirementStatusType requirementStatusType;

	@ManyToOne(fetch = FetchType.LAZY)
	@Column(name = "REQUIREMENT_ID")
	private Requirment requirment;

}
