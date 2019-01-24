package net.devk.marketing.service.basedata;

import org.springframework.data.jpa.repository.JpaRepository;

import net.devk.marketing.service.model.RequirementStatusType;

interface RequirementStatusTypeRepository extends JpaRepository<RequirementStatusType, Long> {

	public RequirementStatusType findByCode(String code);

}
