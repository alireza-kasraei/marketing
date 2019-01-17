package net.devk.marketing.service.basedata;

import org.springframework.data.jpa.repository.JpaRepository;

import net.devk.marketing.service.model.ContactRole;

interface ContactRoleRepository extends JpaRepository<ContactRole, Long> {

}
