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
@Table(name = "CUSTOMERS_DOCS")
@NoArgsConstructor
public class CustomerDocument {

	private static final String CUSTOMERS_DOCS_GENERATOR = "customers_docs_generator";

	@GeneratedValue(generator = CUSTOMERS_DOCS_GENERATOR)
	@SequenceGenerator(name = CUSTOMERS_DOCS_GENERATOR, sequenceName = "customers_docs_sequence", initialValue = 1)
	@Id
	private Long id;

	@Column(name = "REGISTER_DATE")
	private Date registerDate;

	@Column(name = "DOCUMENT_NAME")
	private String documentName;

	@Column(name = "FILE_PATH")
	private String filePath;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "DOCUMENT_TYPE_ID")
	private DocumentType documentType;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "CUSTOMER_ID")
	private Customer customer;

}