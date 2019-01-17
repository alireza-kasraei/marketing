package net.devk.marketing.service.model;

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
@Table(name = "SERVICES")
@NoArgsConstructor
public class Service {

	private static final String SERVICE_GENERATOR = "services_generator";

	@GeneratedValue(generator = SERVICE_GENERATOR)
	@SequenceGenerator(name = SERVICE_GENERATOR, sequenceName = "services_sequence", initialValue = 1)
	private Long id;

	@Column(name = "SERVICE_NAME")
	private String name;

	@ManyToOne(fetch = FetchType.LAZY)
	@Column(name = "PARENT_ID")
	private Service parent;

}
