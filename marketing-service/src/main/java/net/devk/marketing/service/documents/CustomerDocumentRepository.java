package net.devk.marketing.service.documents;

import org.springframework.data.jpa.repository.JpaRepository;

import net.devk.marketing.service.model.CustomerDocument;

interface CustomerDocumentRepository extends JpaRepository<CustomerDocument, Long> {

}
