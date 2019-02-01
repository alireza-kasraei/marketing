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
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = true, onlyExplicitlyIncluded = true)
@Entity
@Table(name = "TARGETS")
@NoArgsConstructor
public class Target extends AbstractModel {

	private static final String TARGETS_GENERATOR = "targets_generator";

	@GeneratedValue(generator = TARGETS_GENERATOR)
	@SequenceGenerator(name = TARGETS_GENERATOR, sequenceName = "targets_sequence", initialValue = 1, allocationSize = 1)
	@Id
	@EqualsAndHashCode.Include
	private Long id;

	@Column(name = "TARGET_NAME")
	private String name;
	// TODO FIXME is it integer?
	@Column(name = "TARGET_VALUE")
	private Long value;
	@Column(name = "REGISTER_DATE")
	private Date registerDate;
	@Column(name = "START_DATE")
	private Date startDate;
	@Column(name = "DUE_DATE")
	private Date dueDate;
	@Column(name = "DAYS_COUNT")
	private Integer daysCount;

	@JoinColumn(name = "ORGAN_ID")
	@ManyToOne(fetch = FetchType.LAZY)
	private Organ organ;
	@JoinColumn(name = "SERVICE_ID")
	@ManyToOne(fetch = FetchType.LAZY)
	private Service service;

	// TODO FIXME ??
	@JoinColumn(name = "VALUE_TYPE_ID")
	@ManyToOne(fetch = FetchType.LAZY)
	private ValueType valueType;
}
