package net.devk.marketing.service.personnels;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import net.devk.marketing.service.model.Personnel;
import net.devk.marketing.service.personnels.dto.PersonnelFindAllQueryResultDTO;

interface PersonnelRepository extends JpaRepository<Personnel, Long> {

	@Query("select new net.devk.marketing.service.personnels.dto.PersonnelFindAllQueryResultDTO(p.id,p.name,p.username,p.registerDate,p.organ.id) from Personnel p where p.organ.id=?1")
	public List<PersonnelFindAllQueryResultDTO> findByOrganId(Long organId);

}
