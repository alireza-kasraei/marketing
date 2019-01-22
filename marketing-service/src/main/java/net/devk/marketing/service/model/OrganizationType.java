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
@Table(name = "ORGANIZATION_TYPES")
@NoArgsConstructor
public class OrganizationType {

	private static final String ORGANIZATION_TYPE_GENERATOR = "organization_types_generator";
	@GeneratedValue(generator = ORGANIZATION_TYPE_GENERATOR)
	@SequenceGenerator(name = ORGANIZATION_TYPE_GENERATOR, sequenceName = "organization_types_sequence", initialValue = 1)
	@Id
	private Long id;

	@Column(name = "TYPE_NAME")
	private String type;
}