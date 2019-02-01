package net.devk.marketing.service.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = true, onlyExplicitlyIncluded = true)
@Entity
@Table(name = "CONTACT_TYPES")
@NoArgsConstructor
public class ContactType extends AbstractModel {

	private static final String CONTACT_TYPES_GENERATOR = "contact_types_generator";

	@GeneratedValue(generator = CONTACT_TYPES_GENERATOR)
	@SequenceGenerator(name = CONTACT_TYPES_GENERATOR, sequenceName = "contact_types_sequence", initialValue = 1, allocationSize = 1)
	@Id
	@EqualsAndHashCode.Include
	private Long id;

	@Column(name = "TYPE_NAME")
	private String name;

	// TODO FIXME int or string?
	@Column(name = "TYPE_CATEGORY")
	@Enumerated(EnumType.ORDINAL)
	private ContactCategory category;
}