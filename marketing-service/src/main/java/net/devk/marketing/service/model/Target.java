package net.devk.marketing.service.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "TARGETS")
@NoArgsConstructor
public class Target {

	private static final String TARGETS_GENERATOR = "targets_generator";

	@GeneratedValue(generator = TARGETS_GENERATOR)
	@SequenceGenerator(name = TARGETS_GENERATOR, sequenceName = "targets_sequence", initialValue = 1)
	private Long id;

	@Column(name = "TARGET_NAME")
	private String name;
	// TODO FIXME is it integer?
	@Column(name = "TARGET_VALUE")
	private Integer value;
	@Column(name = "REGISTER_DATE")
	private Date registerDate;
	@Column(name = "DUE_DATE")
	private Date dueDate;

	@Column(name = "ORGAN_ID")
	@ManyToOne(fetch = FetchType.LAZY)
	private Organ organ;
	@Column(name = "SERVICE_ID")
	@ManyToOne(fetch = FetchType.LAZY)
	private Service service;
	@Column(name = "VALUE_TYPE_ID")
	@ManyToOne(fetch = FetchType.LAZY)
	private ValueType valueType;
}
