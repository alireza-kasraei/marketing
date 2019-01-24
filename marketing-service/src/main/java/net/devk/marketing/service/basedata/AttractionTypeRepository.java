package net.devk.marketing.service.basedata;

import org.springframework.data.jpa.repository.JpaRepository;

import net.devk.marketing.service.model.AttractionType;

interface AttractionTypeRepository extends JpaRepository<AttractionType, Long> {
	
	public AttractionType findByCode(String code);

}
