package net.devk.marketing.service.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "MEETINGS")
@NoArgsConstructor
public class Meeting {

	private static final String MEETINGS_GENERATOR = "meetings_generator";

	@GeneratedValue(generator = MEETINGS_GENERATOR)
	@SequenceGenerator(name = MEETINGS_GENERATOR, sequenceName = "meeetings_sequence", initialValue = 1)
	private Long id;

	@Column(name = "SCHEDULE_DATE")
	private Date scheduleDate;

	@Column(name = "SUBJECT")
	private String subject;

	@ManyToMany
	@JoinTable(name = "MEETINGS_CONTACTS_INFO", joinColumns = @JoinColumn(name = "MEETING_ID"), inverseJoinColumns = @JoinColumn(name = "CONTACT_INFO_ID"))
	private Set<ContactInfo> contactInfos;
}