package net.devk.marketing.service.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "REQUIREMENT_STATUS_TYPES")
@NoArgsConstructor
public class RequirementStatusType {

	private static final String REQUIREMENT_STATUS_TYPES_GENERATOR = "requirement_status_types_generator";

	@GeneratedValue(generator = REQUIREMENT_STATUS_TYPES_GENERATOR)
	@SequenceGenerator(name = REQUIREMENT_STATUS_TYPES_GENERATOR, sequenceName = "requirement_status_types_sequence", initialValue = 1)
	private Long id;

	@Column(name = "STATUS_TYPE")
	private String type;

}
