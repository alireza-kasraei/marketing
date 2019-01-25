package net.devk.marketing.service.model;

import java.util.Date;

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
@Table(name = "REQUIREMENTS")
@NoArgsConstructor
public class Requirement {

	private static final String CUSTOMERS_REQUIREMENTS_GENERATOR = "customers_requirements_generator";

	@GeneratedValue(generator = CUSTOMERS_REQUIREMENTS_GENERATOR)
	@SequenceGenerator(name = CUSTOMERS_REQUIREMENTS_GENERATOR, sequenceName = "cr_sequence", initialValue = 1)
	@Id
	private Long id;

	@Column(name = "ESTIMATED_VALUE")
	private Long estimatedValue;
	@Column(name = "REAL_VALUE")
	private Long realValue;
	@Column(name = "DESCRIPTION")
	private String description;

	@Column(name = "ESTIMATED_VALUE_EDIT_DATE")
	private Date estimatedValueEditDate;

	@Column(name = "ESTIMATED_VALUE_REGISTER_DATE")
	private Date estimatedValueRegisterDate;

	@Column(name = "REAL_VALUE_EDIT_DATE")
	private Date realValueEditDate;

	@Column(name = "REAL_VALUE_REGISTER_DATE")
	private Date realValueRegisterDate;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "TARGET_MEMBER_ID")
	private TargetMember targetMember;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "CUSTOMER_ID")
	private Customer customer;

}
