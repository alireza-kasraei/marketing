package net.devk.marketing.service.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
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
@Table(name = "REQUIREMENT_STATUSES")
@NoArgsConstructor
public class RequirementStatus extends AbstractModel {

	private static final String REQUIREMENT_STATUSES_GENERATOR = "requirement_statuses_generator";

	@GeneratedValue(generator = REQUIREMENT_STATUSES_GENERATOR)
	@SequenceGenerator(name = REQUIREMENT_STATUSES_GENERATOR, sequenceName = "requirement_statuses_sequence", initialValue = 1, allocationSize = 1)
	@Id
	@EqualsAndHashCode.Include
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "REQUIREMENT_STATUS_TYPE_ID")
	private RequirementStatusType requirementStatusType;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "REQUIREMENT_ID")
	private Requirement requirment;

}
