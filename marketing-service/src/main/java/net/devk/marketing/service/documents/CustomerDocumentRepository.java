package net.devk.marketing.service.documents;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import net.devk.marketing.service.documents.dto.CustomerDocumentQueryResultDTO;
import net.devk.marketing.service.model.CustomerDocument;

interface CustomerDocumentRepository extends JpaRepository<CustomerDocument, Long> {

	@Query("select new net.devk.marketing.service.documents.dto.CustomerDocumentQueryResultDTO(cd.id,cd.documentName,cd.filePath,dt.id,dt.type,cd.customer.id) from CustomerDocument cd inner join cd.documentType dt where cd.customer.id=?1")
	public List<CustomerDocumentQueryResultDTO> findDocumentsByCustomerId(Long customerId);

}
