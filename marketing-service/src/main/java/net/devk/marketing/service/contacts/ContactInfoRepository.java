package net.devk.marketing.service.contacts;

import org.springframework.data.jpa.repository.JpaRepository;

import net.devk.marketing.service.model.ContactInfo;

interface ContactInfoRepository extends JpaRepository<ContactInfo, Long> {

}
