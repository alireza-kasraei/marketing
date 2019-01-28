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
@Table(name = "BUSINESS_SCALES")
@NoArgsConstructor
public class BusinessScale {

	private static final String BUSINESS_SCALE_GENERATOR = "business_scales_generator";

	@GeneratedValue(generator = BUSINESS_SCALE_GENERATOR)
	@SequenceGenerator(name = BUSINESS_SCALE_GENERATOR, sequenceName = "business_scales_sequence", initialValue = 1, allocationSize = 1)
	@Id
	private Long id;

	@Column(name = "BUSINESS_SCALE_NAME")
	private String name;
}