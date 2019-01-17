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
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "MEETINGS_RESULTS")
@NoArgsConstructor
public class MeetingResult {

	private static final String MEETINGS_RESULTS_GENERATOR = "meetings_results_generator";

	@GeneratedValue(generator = MEETINGS_RESULTS_GENERATOR)
	@SequenceGenerator(name = MEETINGS_RESULTS_GENERATOR, sequenceName = "meetings_results_sequence", initialValue = 1)
	@Id
	private Long id;

	@Column(name = "description")
	private String description;

	@ManyToOne
	@JoinColumn(name = "MEETING_ID")
	private Meeting meeting;

}