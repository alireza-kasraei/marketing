package net.devk.marketing.service.contacts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import net.devk.marketing.service.model.ContactInfo;

interface ContactInfoRepository extends JpaRepository<ContactInfo, Long> {

	@Query("select c from ContactInfo c where c.customer.id=?1")
	public List<ContactInfo> findByCustomerId(Long customerId);

	@Query("select count(c) from ContactInfo c inner join c.meetings m where c.id=?1")
	public Long countMeetings(Long contacyInfoId);

}
