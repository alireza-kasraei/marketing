package net.devk.marketing.service.basedata;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import net.devk.marketing.service.basedata.dto.ContactTypeDTO;
import net.devk.marketing.service.model.ContactType;

interface ContactTypeRepository extends JpaRepository<ContactType, Long> {

	@Query("select new net.devk.marketing.service.basedata.dto.ContactTypeDTO(c.id,c.name,c.category) from ContactType c")
	public List<ContactTypeDTO> findAllContactTypes();

}
