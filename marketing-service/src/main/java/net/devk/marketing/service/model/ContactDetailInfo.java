package net.devk.marketing.service.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "CONTACTS_INFO_DETAILS")
@NoArgsConstructor
public class ContactDetailInfo {

	private static final String CONTACTS_INFO_DETAILS_GENERATOR = "contacts_info_details_generator";

	@GeneratedValue(generator = CONTACTS_INFO_DETAILS_GENERATOR)
	@SequenceGenerator(name = CONTACTS_INFO_DETAILS_GENERATOR, sequenceName = "contacts_info_details_sequence", initialValue = 1)
	@Id
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY,cascade=CascadeType.ALL)
	@JoinColumn(name = "CONTACT_INFO_ID")
	private ContactInfo contactInfo;
	@Column(name = "CONTACT_DATA")
	private String contactData;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CONTACT_TYPE_ID")
	private ContactType contactType;
}