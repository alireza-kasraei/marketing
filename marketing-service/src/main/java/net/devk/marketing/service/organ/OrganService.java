package net.devk.marketing.service.organ;

import java.util.List;

import net.devk.marketing.service.model.Organ;
import net.devk.marketing.service.organ.dto.OrganFindAllQueryResultDTO;

public interface OrganService {

	public Organ createOrgan(String name, Integer level, Integer order, Long parentId);

	public List<OrganFindAllQueryResultDTO> findAllOrgans();

}
