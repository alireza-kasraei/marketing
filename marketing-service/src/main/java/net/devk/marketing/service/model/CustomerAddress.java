package net.devk.marketing.service.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import net.devk.commons.jpa.model.AbstractModel;

@Data
@EqualsAndHashCode(callSuper = true, onlyExplicitlyIncluded = true)
@Entity
@Table(name = "CUSTOMERS_ADDRESSES")
@NoArgsConstructor
public class CustomerAddress extends AbstractModel {

	private static final String CUSTOMER_ADDRESS_GENERATOR = "customers_addresses_generator";

	@GeneratedValue(generator = CUSTOMER_ADDRESS_GENERATOR)
	@SequenceGenerator(name = CUSTOMER_ADDRESS_GENERATOR, sequenceName = "customers_addresses_sequence", initialValue = 1, allocationSize = 1)
	@Id
	@EqualsAndHashCode.Include
	private Long id;

	@Column(name = "CUSTOMER_ADDRESS", length = 1000)
	private String address;
	@Column(name = "LATITUDE")
	private String latitude;
	@Column(name = "LONGITUDE")
	private String longitude;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CUSTOMER_ID")
	private Customer customer;
}