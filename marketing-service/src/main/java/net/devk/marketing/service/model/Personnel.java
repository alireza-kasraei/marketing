package net.devk.marketing.service.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = true, onlyExplicitlyIncluded = true)
@Entity
@Table(name = "PERSONNELS")
@NoArgsConstructor
public class Personnel extends AbstractModel {

	private static final String PERSONNELS_GENERATOR = "personnels_generator";

	@GeneratedValue(generator = PERSONNELS_GENERATOR)
	@SequenceGenerator(name = PERSONNELS_GENERATOR, sequenceName = "personnels_sequence", initialValue = 1, allocationSize = 1)
	@Id
	@EqualsAndHashCode.Include
	private Long id;

	@Column(name = "PERSONNEL_NAME")
	private String name;

	@Column(name = "USER_NAME")
	private String username;

	@JoinColumn(name = "ORGAN_ID")
	@ManyToOne
	private Organ organ;

	@ManyToMany(mappedBy = "personnels", fetch = FetchType.LAZY)
	private Set<Meeting> meetings = new HashSet<>();

}
