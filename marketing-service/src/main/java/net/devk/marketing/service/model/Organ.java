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
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import net.devk.commons.jpa.model.AbstractModel;

@Data
@EqualsAndHashCode(callSuper = true, onlyExplicitlyIncluded = true)
@Entity
@Table(name = "ORGANS")
@NoArgsConstructor
public class Organ extends AbstractModel {
	private static final String GENERATOR_NAME = "organs_generator";

	@GeneratedValue(generator = GENERATOR_NAME)
	@SequenceGenerator(name = GENERATOR_NAME, sequenceName = "organs_sequence", initialValue = 1, allocationSize = 1)
	@Id
	@EqualsAndHashCode.Include
	private Long id;

	@Column(name = "ORGAN_NAME")
	private String name;
	// 0 is higher level
	@Column(name = "ORGAN_LEVEL")
	private Integer level;
	@Column(name = "ORGAN_ORDER")
	private Integer order;

	@JoinColumn(name = "PARENT_ID")
	@ManyToOne(fetch = FetchType.LAZY)
	private Organ parent;

}
