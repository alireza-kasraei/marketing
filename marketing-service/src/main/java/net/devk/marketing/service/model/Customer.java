package net.devk.marketing.service.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "CUSTOMERS")
@NoArgsConstructor
public class Customer {

	private static final String CUSTOMER_GENERATOR = "customers_generator";

	@GeneratedValue(generator = CUSTOMER_GENERATOR)
	@SequenceGenerator(name = CUSTOMER_GENERATOR, sequenceName = "customers_sequence", initialValue = 1)
	private Long id;

	@Column(name = "CUSTOMER_NAME")
	private String name;

	@Column(name = "REGISTER_DATE")
	private Date registerDate;

	@Column(name = "LEGAL")
	private Boolean legal;

	@Column(name = "ECONOMIC_CODE")
	private String economicCode;

	@Column(name = "ECONOMIC_SECTION")
	private String economicSection;

	@Column(name = "HEAD_COUNT")
	private Integer headCount;

	@Column(name = "ANNUAL_INCOME")
	private Long annualIncome;

	// TODO FIXME is it correct?
	@Column(name = "DOC_STATUS")
	private Boolean hasDocument;

	@Column(name = "REGISTRATION_STATUS")
	@Enumerated(EnumType.ORDINAL)
	private RegistrationStatus registrationStatus;

	@Column(name = "USER_NAME")
	private String username;

	@Column(name = "BUSINESS_SCALE_ID")
	@ManyToOne(fetch = FetchType.LAZY)
	private BusinessScale businessScale;
	@Column(name = "CUSTOMER_TYPE_ID")
	@ManyToOne(fetch = FetchType.LAZY)
	private CustomerType customerType;
	@Column(name = "OWNERSHIP_TYPE_ID")
	@ManyToOne(fetch = FetchType.LAZY)
	private OwnershipType ownershipType;
	@Column(name = "ATTRACTION_TYPE_ID")
	@ManyToOne(fetch = FetchType.LAZY)
	private AttractionType attractionType;

}