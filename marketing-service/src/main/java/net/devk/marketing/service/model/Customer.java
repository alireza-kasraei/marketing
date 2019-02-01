
package net.devk.marketing.service.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = true, onlyExplicitlyIncluded = true)
@Entity
@Table(name = "CUSTOMERS")
@NoArgsConstructor
public class Customer extends AbstractModel {

	private static final String CUSTOMER_GENERATOR = "customers_generator";

	@GeneratedValue(generator = CUSTOMER_GENERATOR)
	@SequenceGenerator(name = CUSTOMER_GENERATOR, sequenceName = "customers_sequence", initialValue = 1, allocationSize = 1)
	@Id
	@EqualsAndHashCode.Include
	private Long id;

	@Column(name = "CUSTOMER_NAME")
	private String name;

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

	@EqualsAndHashCode.Exclude
	@OneToOne(mappedBy = "customer", cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false)
	private CustomerAddress address;

	@JoinColumn(name = "BUSINESS_SCALE_ID")
	@ManyToOne(fetch = FetchType.LAZY)
	private BusinessScale businessScale;
	@JoinColumn(name = "OWNERSHIP_TYPE_ID")
	@ManyToOne(fetch = FetchType.LAZY)
	private OwnershipType ownershipType;
	@JoinColumn(name = "ORGANIZATION_TYPE_ID")
	@ManyToOne(fetch = FetchType.LAZY)
	private OrganizationType organizationType;

}