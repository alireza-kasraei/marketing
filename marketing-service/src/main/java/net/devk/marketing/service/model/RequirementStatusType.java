package net.devk.marketing.service.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import net.devk.commons.jpa.model.AbstractModel;

@Data
@EqualsAndHashCode(callSuper = true, onlyExplicitlyIncluded = true)
@Entity
@Table(name = "REQUIREMENT_STATUS_TYPES")
@NoArgsConstructor
public class RequirementStatusType extends AbstractModel {

	// TODO FIXME change these codes
	// TAARIFE NIAZ
	public static final String REQUIREMENT_STATUS_STATUS1 = "RS1";

	// TAKHSISE NIAZ
	public static final String REQUIREMENT_STATUS_STATUS2 = "RS2";

	// DAR HALE EGHDAM
	public static final String REQUIREMENT_STATUS_STATUS3 = "RS3";

	// TAAMINE NIAZ
	public static final String REQUIREMENT_STATUS_STATUS4 = "RS4";

	private static final String REQUIREMENT_STATUS_TYPES_GENERATOR = "requirement_status_types_generator";

	@GeneratedValue(generator = REQUIREMENT_STATUS_TYPES_GENERATOR)
	@SequenceGenerator(name = REQUIREMENT_STATUS_TYPES_GENERATOR, sequenceName = "rst_sequence", initialValue = 1, allocationSize = 1)
	@Id
	@EqualsAndHashCode.Include
	private Long id;

	@Column(name = "TYPE_NAME")
	private String type;

	@Column(name = "TYPE_CODE", unique = true)
	private String code;

}
