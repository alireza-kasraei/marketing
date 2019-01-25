package net.devk.marketing.service.requirements;

import org.springframework.data.jpa.repository.JpaRepository;

import net.devk.marketing.service.model.AssignedRequirement;
import net.devk.marketing.service.model.AssignedRequirementStatus;

interface AssignedRequirementStatusRepository extends JpaRepository<AssignedRequirementStatus, Long> {

}
