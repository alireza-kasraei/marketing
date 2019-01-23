package net.devk.marketing.service.model;

import java.util.Date;

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
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "TARGETS_MEMBERS")
@NoArgsConstructor
public class TargetMember {

	private static final String TARGETS_MEMBERS_GENERATOR = "targets_members_generator";

	@GeneratedValue(generator = TARGETS_MEMBERS_GENERATOR)
	@SequenceGenerator(name = TARGETS_MEMBERS_GENERATOR, sequenceName = "targets_members_sequence", initialValue = 1)
	@Id
	private Long id;

	@Column(name = "TARGET_MEMBER_NAME")
	private String name;
	// TODO FIXME is it integer?
	@Column(name = "TARGET_MEMBER_VALUE")
	private Integer value;

	@Column(name = "REGISTER_DATE")
	private Date registerDate;

	@Column(name = "DUE_DATE")
	private Date dueDate;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "VALUE_TYPE_ID")
	private ValueType valueType;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "MEMBER_ID")
	private TeamMember member;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "TARGET_ID")
	private Target target;

}
