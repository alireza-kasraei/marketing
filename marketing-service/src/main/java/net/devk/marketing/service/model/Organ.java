package net.devk.marketing.service.model;

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
@Table(name = "ORGANS")
@NoArgsConstructor
public class Organ {
	private static final String GENERATOR_NAME = "organs_generator";

	@GeneratedValue(generator = GENERATOR_NAME)
	@SequenceGenerator(name = GENERATOR_NAME, sequenceName = "organs_sequence", initialValue = 1)
	@Id
	private Long id;

	@Column(name = "ORGAN_NAME")
	private String name;
	@Column(name = "ORGAN_LEVEL")
	private Integer level;
	@Column(name = "ORGAN_ORDER")
	private Integer order;

	@JoinColumn(name = "PARENT_ID")
	@ManyToOne(fetch = FetchType.LAZY)
	private Organ parent;

}
