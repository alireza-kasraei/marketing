package net.devk.marketing.service.basedata;

import org.springframework.data.jpa.repository.JpaRepository;

import net.devk.marketing.service.model.AssignedStatusType;

interface AssignedStatusTypeRepository extends JpaRepository<AssignedStatusType, Long> {

}
