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
@Table(name = "ASSIGNED_STATUS_TYPES")
@NoArgsConstructor
public class AssignedStatusType extends AbstractModel {

	public static final String ASSIGNED_STATUS_TYPE1 = "AST1";

	@GeneratedValue(generator = "assigned_status_types_generator")
	@SequenceGenerator(name = "assigned_status_types_generator", sequenceName = "assigned_status_types_sequence", initialValue = 1, allocationSize = 1)
	@Id
	@EqualsAndHashCode.Include
	private Long id;

	@Column(name = "TYPE_NAME")
	private String name;

	@Column(name = "TYPE_CODE")
	private String code;

}
