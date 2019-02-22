package net.devk.marketing.service.model;

import javax.persistence.Column;
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
@Table(name = "SUPPLIED_REQUIREMENT_STATUSES")
@NoArgsConstructor
public class SupplyRequirementStatus extends AbstractModel {

	private static final String SUPPLIED_REQUIREMENT_STATUSES_GENERATOR = "supplied_requirement_status_generator";

	@GeneratedValue(generator = SUPPLIED_REQUIREMENT_STATUSES_GENERATOR)
	@SequenceGenerator(name = SUPPLIED_REQUIREMENT_STATUSES_GENERATOR, sequenceName = "srs_sequence", initialValue = 1, allocationSize = 1)
	@Id
	@EqualsAndHashCode.Include
	private Long id;

	@Column(name = "VALUE")
	private String value;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SUPPLY_STATUS_TYPE_ID")
	private SupplyStatusType supplyStatusType;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "REQUIREMENT_STATUS_ID")
	private RequirementStatus requirmentStatus;

}
