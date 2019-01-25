package net.devk.marketing.service.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "ASSIGNED_STATUS_TYPES")
@NoArgsConstructor
public class AssignedStatusType {
	
	public static final String ASSIGNED_STATUS_TYPE1="AST1";

	@GeneratedValue(generator = "assigned_status_types_generator")
	@SequenceGenerator(name = "assigned_status_types_generator", sequenceName = "assigned_status_types_sequence", initialValue = 1)
	@Id
	private Long id;

	@Column(name = "TYPE_NAME")
	private String name;
	
	@Column(name = "TYPE_CODE")
	private String code;

}
