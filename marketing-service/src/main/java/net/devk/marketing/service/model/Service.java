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
@Table(name = "SERVICES")
@NoArgsConstructor
public class Service extends AbstractModel {

	private static final String SERVICE_GENERATOR = "services_generator";

	@GeneratedValue(generator = SERVICE_GENERATOR)
	@SequenceGenerator(name = SERVICE_GENERATOR, sequenceName = "services_sequence", initialValue = 1, allocationSize = 1)
	@Id
	@EqualsAndHashCode.Include
	private Long id;

	@Column(name = "SERVICE_NAME")
	private String name;
	
	@Column(name = "ICON")
	private String icon;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PARENT_ID")
	private Service parent;

}
