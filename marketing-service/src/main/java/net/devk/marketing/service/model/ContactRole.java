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
@Table(name = "CONTACT_ROLES")
@NoArgsConstructor
public class ContactRole {

	private static final String CONTACT_ROLES_GENERATOR = "contact_roles_generator";

	@GeneratedValue(generator = CONTACT_ROLES_GENERATOR)
	@SequenceGenerator(name = CONTACT_ROLES_GENERATOR, sequenceName = "contact_roles_sequence", initialValue = 1)
	@Id
	private Long id;

	@Column(name = "CONTACT_ROLE_NAME")
	private String name;
}