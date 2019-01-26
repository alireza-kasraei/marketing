package net.devk.marketing.service.customers;

import org.springframework.data.jpa.repository.JpaRepository;

import net.devk.marketing.service.model.AttractionStatus;

interface AttractionStatusRepository extends JpaRepository<AttractionStatus, Long> {

}
