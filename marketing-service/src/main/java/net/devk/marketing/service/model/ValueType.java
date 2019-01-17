package net.devk.marketing.service.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "VALUE_TYPES")
@NoArgsConstructor
public class ValueType {

	private static final String VALUE_TYPE_GENERATOR = "value_types_generator";

	@GeneratedValue(generator = VALUE_TYPE_GENERATOR)
	@SequenceGenerator(name = VALUE_TYPE_GENERATOR, sequenceName = "value_types_sequence", initialValue = 1)
	@Id
	private Long id;

	@Column(name = "TYPE_NAME")
	private String name;

}
