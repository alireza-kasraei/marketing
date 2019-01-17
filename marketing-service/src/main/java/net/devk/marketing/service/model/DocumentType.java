package net.devk.marketing.service.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "DOCUMENT_TYPES")
@NoArgsConstructor
public class DocumentType {

	@GeneratedValue(generator = "document_types_generator")
	@SequenceGenerator(name = "document_types_generator", sequenceName = "document_types_sequence", initialValue = 1)
	@Id
	private Long id;

	@Column(name = "TYPE_NAME")
	private String type;

}