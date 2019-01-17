package net.devk.marketing.service.model;

import java.util.Date;

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
@Table(name = "TEAMS")
@NoArgsConstructor
public class Team {

	private static final String TEAMS_GENERATOR = "teams_generator";

	@GeneratedValue(generator = TEAMS_GENERATOR)
	@SequenceGenerator(name = TEAMS_GENERATOR, sequenceName = "teams_sequence", initialValue = 1)
	private Long id;

	@Column(name = "TEAM_NAME")
	private String name;
	@Column(name = "REGISTER_DATE")
	private Date registerDate;

	@Column(name = "ORGAN_ID")
	@ManyToOne(fetch = FetchType.LAZY)
	private Organ organ;

}
