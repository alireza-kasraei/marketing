package net.devk.marketing.service.basedata;

import org.springframework.data.jpa.repository.JpaRepository;

import net.devk.marketing.service.model.ValueType;

interface ValueTypeRepository extends JpaRepository<ValueType, Long> {

}
