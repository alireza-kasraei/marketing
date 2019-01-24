package net.devk.marketing.service.requirements;

import org.springframework.data.jpa.repository.JpaRepository;

import net.devk.marketing.service.model.AssignedRequirement;

interface AssignedRequirementRepository extends JpaRepository<AssignedRequirement, Long> {

}
