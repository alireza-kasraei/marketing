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
@Table(name = "OWNERSHIP_TYPES")
@NoArgsConstructor
public class OwnershipType extends AbstractModel {

	private static final String OWNERSHIP_TYPE_GENERATOR = "ownership_types_generator";
	@GeneratedValue(generator = OWNERSHIP_TYPE_GENERATOR)
	@SequenceGenerator(name = OWNERSHIP_TYPE_GENERATOR, sequenceName = "ownership_types_sequence", initialValue = 1, allocationSize = 1)
	@Id
	@EqualsAndHashCode.Include
	private Long id;

	@Column(name = "TYPE_NAME")
	private String type;
}