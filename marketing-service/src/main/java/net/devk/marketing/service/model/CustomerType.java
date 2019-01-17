package net.devk.marketing.service.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "CUSTOMER_TYPES")
@NoArgsConstructor
public class CustomerType {

	private static final String CUSTOMER_TYPE_GENERATOR = "customer_types_generator";
	@GeneratedValue(generator = CUSTOMER_TYPE_GENERATOR)
	@SequenceGenerator(name = CUSTOMER_TYPE_GENERATOR, sequenceName = "customer_types_sequence", initialValue = 1)
	private Long id;

	@Column(name = "CUSTOMER_TYPE")
	private String type;
}