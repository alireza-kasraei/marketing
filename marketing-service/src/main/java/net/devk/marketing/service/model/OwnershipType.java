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
@Table(name = "OWNERSHIP_TYPES")
@NoArgsConstructor
public class OwnershipType {

	private static final String OWNERSHIP_TYPE_GENERATOR = "ownership_types_generator";
	@GeneratedValue(generator = OWNERSHIP_TYPE_GENERATOR)
	@SequenceGenerator(name = OWNERSHIP_TYPE_GENERATOR, sequenceName = "ownership_types_sequence", initialValue = 1, allocationSize = 1)
	@Id
	private Long id;

	@Column(name = "TYPE_NAME")
	private String type;
}