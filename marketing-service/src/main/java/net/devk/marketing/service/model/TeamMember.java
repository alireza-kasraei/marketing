package net.devk.marketing.service.model;

import java.util.Date;

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

// TODO FIXME how can we find out this member is head?
@Data
@EqualsAndHashCode(callSuper = true, onlyExplicitlyIncluded = true)
@Entity
//TODO FIXME is "TEAMS_PERSONNELS" a better name?
@Table(name = "TEAMS_MEMBERS")
@NoArgsConstructor
public class TeamMember extends AbstractModel {

	private static final String TEAMS_MEMBERS_GENERATOR = "members_generator";

	@GeneratedValue(generator = TEAMS_MEMBERS_GENERATOR)
	@SequenceGenerator(name = TEAMS_MEMBERS_GENERATOR, sequenceName = "members_sequence", initialValue = 1, allocationSize = 1)
	@Id
	@EqualsAndHashCode.Include
	private Long id;

	@Column(name = "MEMBERSHIP_DATE")
	private Date membershipDate;
	// TODO FIXME is it a simple integer filed or relation to another table
	@Column(name = "MEMBERSHIP_STATUS")
	private Integer membershipStatus;

	@JoinColumn(name = "TEAM_ID")
	@ManyToOne
	private Team team;

	@JoinColumn(name = "PERSONNEL_ID")
	@ManyToOne
	private Personnel personnel;

}
