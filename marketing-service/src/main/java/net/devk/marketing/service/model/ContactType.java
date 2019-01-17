package net.devk.marketing.service.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "CONTACT_TYPES")
@NoArgsConstructor
public class ContactType {

	private static final String CONTACT_TYPES_GENERATOR = "contact_types_generator";

	@GeneratedValue(generator = CONTACT_TYPES_GENERATOR)
	@SequenceGenerator(name = CONTACT_TYPES_GENERATOR, sequenceName = "contact_types_sequence", initialValue = 1)
	private Long id;

	@Column(name = "CONTACT_TYPE_NAME")
	private String type;

	// TODO FIXME int or string?
	@Column(name = "CONTACT_TYPE_CATEGORY")
	@Enumerated(EnumType.ORDINAL)
	private ContactCategory category;
}