package net.devk.marketing.service.personnels;

import org.springframework.data.jpa.repository.JpaRepository;

import net.devk.marketing.service.model.Personnel;

interface PersonnelRepository extends JpaRepository<Personnel, Long> {

}
