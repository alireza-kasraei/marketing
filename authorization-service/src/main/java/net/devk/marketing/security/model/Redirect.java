package net.devk.marketing.security.model;

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

@EqualsAndHashCode(callSuper = true, onlyExplicitlyIncluded = true)
@Data
@NoArgsConstructor
@Entity
@Table(name = "REDIRECTS")
public class Redirect extends AbstractModel {

	private static final String REDIRECT_SEQUENCE_NAME = "redirect_sequence";

	private static final String REDIRECT_GENERATOR_NAME = "redirect_generator";

	@Id
	@GeneratedValue(generator = REDIRECT_GENERATOR_NAME)
	@SequenceGenerator(name = REDIRECT_GENERATOR_NAME, sequenceName = REDIRECT_SEQUENCE_NAME, initialValue = 1, allocationSize = 1)
	@EqualsAndHashCode.Include
	private Long id;

	@Column(name = "REDIRECT_URL")
	private String url;

	@Column(name = "DESCRIPTION")
	private String description;

	@ManyToOne
	@JoinColumn(name = "CLIENT_ID")
	private Client client;

}
