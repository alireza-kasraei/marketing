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
@Table(name = "ATTRACTION_TYPES")
@NoArgsConstructor
public class AttractionType {

	private static final String ATTRACTION_TYPE_GENERATOR = "attraction_types_generator";

	@GeneratedValue(generator = ATTRACTION_TYPE_GENERATOR)
	@SequenceGenerator(name = ATTRACTION_TYPE_GENERATOR, sequenceName = "attraction_types_sequence", initialValue = 1)
	private Long id;

	@Column(name = "ATTRACTION_TYPE")
	private String type;
}