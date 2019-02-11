package net.devk.marketing.service.contacts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import net.devk.marketing.service.contacts.dto.ContactDetailInfoQueryResultDTO;
import net.devk.marketing.service.model.ContactDetailInfo;

interface ContactDetailInfoRepository extends JpaRepository<ContactDetailInfo, Long> {

	@Query("select new net.devk.marketing.service.contacts.dto.ContactDetailInfoQueryResultDTO(c.id,cdi.id,cdi.contactData,ct.id,ct.name,ct.category) from ContactDetailInfo cdi join cdi.contactInfo c join cdi.contactType ct where c.id=?1")
	public List<ContactDetailInfoQueryResultDTO> findContactDetailInfoByContactInfoId(Long contactInfoId);

}
