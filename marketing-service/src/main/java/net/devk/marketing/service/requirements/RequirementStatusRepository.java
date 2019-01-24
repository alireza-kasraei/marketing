package net.devk.marketing.service.requirements;

import org.springframework.data.jpa.repository.JpaRepository;

import net.devk.marketing.service.model.RequirementStatus;

interface RequirementStatusRepository extends JpaRepository<RequirementStatus, Long> {

}
