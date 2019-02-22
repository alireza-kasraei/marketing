package net.devk.marketing.service.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import net.devk.commons.jpa.model.AbstractModel;

@Data
@EqualsAndHashCode(callSuper = true, onlyExplicitlyIncluded = true)
@Entity
@Table(name = "CONTACTS_INFO")
@NoArgsConstructor
public class ContactInfo extends AbstractModel {

	private static final String CONTACT_INFO_GENERATOR = "contacts_info_generator";

	@GeneratedValue(generator = CONTACT_INFO_GENERATOR)
	@SequenceGenerator(name = CONTACT_INFO_GENERATOR, sequenceName = "contacts_info_sequence", initialValue = 1, allocationSize = 1)
	@Id
	@EqualsAndHashCode.Include
	private Long id;

	@Column(name = "CONTACT_NAME")
	private String name;

	@JoinColumn(name = "CONTACT_ROLE_ID")
	@ManyToOne(fetch = FetchType.LAZY)
	private ContactRole role;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CUSTOMER_ID")
	private Customer customer;

	@OneToMany(cascade = { CascadeType.ALL }, mappedBy = "contactInfo", fetch = FetchType.LAZY, orphanRemoval = true)
	private Set<ContactDetailInfo> contactDetails = new HashSet<>();

	@ManyToMany(mappedBy = "contactInfos", fetch = FetchType.LAZY)
	private Set<Meeting> meetings = new HashSet<>();
}