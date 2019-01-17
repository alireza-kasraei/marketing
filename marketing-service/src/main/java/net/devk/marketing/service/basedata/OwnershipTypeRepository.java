package net.devk.marketing.service.basedata;

import org.springframework.data.jpa.repository.JpaRepository;

import net.devk.marketing.service.model.OwnershipType;

interface OwnershipTypeRepository extends JpaRepository<OwnershipType, Long> {

}
