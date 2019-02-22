package net.devk.marketing.service.model;

import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name = "SUPPLY_STATUS_TYPES")
@NoArgsConstructor
public class SupplyStatusType extends AbstractModel {

	// TODO FIXME change these codes
	// Eftetahe hesab , 10 ta fasele gozashtam alal hesab vase status hayi ke baadan
	// momkene be system ezafe beshan
	public static final String SUPPLY_STATUS_STATUS1 = "SS1";

	// VARIZE TAS HILAT
	public static final String SUPPLY_STATUS_STATUS2 = "SS20";

	// AKHZE KARMOZD
	public static final String SUPPLY_STATUS_STATUS3 = "SS30";

	// JAZBE MOSHTARI
	public static final String SUPPLY_STATUS_STATUS4 = "SS40";

	private static final String SUPPLY_STATUS_TYPES_GENERATOR = "supply_status_types_generator";

	@GeneratedValue(generator = SUPPLY_STATUS_TYPES_GENERATOR)
	@SequenceGenerator(name = SUPPLY_STATUS_TYPES_GENERATOR, sequenceName = "sst_sequence", initialValue = 1, allocationSize = 1)
	@Id
	@EqualsAndHashCode.Include
	private Long id;

	@Column(name = "TYPE_NAME")
	private String type;

	@Column(name = "TYPE_CODE", unique = true)
	private String code;

	@ManyToOne
	@JoinColumn(name = "SERVICE_ID")
	private Service service;

}
