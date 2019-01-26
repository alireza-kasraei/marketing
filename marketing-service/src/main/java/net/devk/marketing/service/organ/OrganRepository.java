package net.devk.marketing.service.organ;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import net.devk.marketing.service.model.Organ;
import net.devk.marketing.service.organ.dto.OrganFindAllQueryResultDTO;

interface OrganRepository extends JpaRepository<Organ, Long> {

	@Query("select new net.devk.marketing.service.organ.dto.OrganFindAllQueryResultDTO(o.id,o.name,o.level,o.order,o.parent.id) from Organ o ")
	public List<OrganFindAllQueryResultDTO> findAllOrgans();

}
