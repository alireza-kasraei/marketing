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
@Table(name = "ATTRACTION_TYPES")
@NoArgsConstructor
public class AttractionType {
	//TODO FIXME change these names
	//belghovve!
	public static final String ATTRACTION_TYPE_TYPE1="AT1";
	//ragheb
	public static final String ATTRACTION_TYPE_TYPE2="AT2";
	//dar hale jazb
	public static final String ATTRACTION_TYPE_TYPE3="AT3";

	private static final String ATTRACTION_TYPE_GENERATOR = "attraction_types_generator";

	@GeneratedValue(generator = ATTRACTION_TYPE_GENERATOR)
	@SequenceGenerator(name = ATTRACTION_TYPE_GENERATOR, sequenceName = "attraction_types_sequence", initialValue = 1)
	@Id
	private Long id;

	@Column(name = "TYPE_NAME")
	private String name;

	@Column(name = "TYPE_CODE")
	private String code;
}