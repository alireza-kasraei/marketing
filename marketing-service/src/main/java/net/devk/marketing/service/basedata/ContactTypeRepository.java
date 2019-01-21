package net.devk.marketing.service.basedata;

import org.springframework.data.jpa.repository.JpaRepository;

import net.devk.marketing.service.model.ContactType;

interface ContactTypeRepository extends JpaRepository<ContactType, Long> {

//	@Query("select new net.devk.marketing.service.basedata.dto.ContactTypeDTO(c.id,c.name,c.category.name,c.category.ordinal) from ContactType c")
//	public List<ContactTypeDTO> findAllContactTypes();

}
