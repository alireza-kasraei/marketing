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
@Table(name = "ATTRACTIONS_STATUSES")
@NoArgsConstructor
public class AttractionStatus {

	private static final String ATTRACTIONS_STATUSES_GENERATOR = "attractions_statuses_generator";

	@GeneratedValue(generator = ATTRACTIONS_STATUSES_GENERATOR)
	@SequenceGenerator(name = ATTRACTIONS_STATUSES_GENERATOR, sequenceName = "attractions_statuses_sequence", initialValue = 1, allocationSize = 1)
	@Id
	private Long id;

	@Column(name = "REGISTER_DATE")
	private Date registerDate;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ATTRACTION_TYPE_ID")
	private AttractionType attractionType;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CUSTOMER_ID")
	private Customer customer;

}