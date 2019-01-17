package net.devk.marketing.service.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "MEMBERS")
@NoArgsConstructor
public class Member {

	private static final String TEAMS_MEMBERS_GENERATOR = "members_generator";

	@GeneratedValue(generator = TEAMS_MEMBERS_GENERATOR)
	@SequenceGenerator(name = TEAMS_MEMBERS_GENERATOR, sequenceName = "members_sequence", initialValue = 1)
	private Long id;

	@Column(name = "MEMBER_NAME")
	private String name;
	// TODO FIXME should we change it to registerDate?
	@Column(name = "MEMBERSHIP_DATE")
	private Date membershipDate;
	// TODO FIXME is it a simple integer filed or relation to another table
	@Column(name = "MEMBERSHIP_STATUS")
	private Integer membershipStatus;
	// TODO FIXME how can we find out this member is head?

	@Column(name = "TEAM_ID")
	@ManyToOne
	private Team team;

}
