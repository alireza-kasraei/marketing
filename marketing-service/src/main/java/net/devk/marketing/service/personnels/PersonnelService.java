package net.devk.marketing.service.personnels;

import java.util.List;

import net.devk.marketing.service.model.Personnel;
import net.devk.marketing.service.personnels.dto.PersonnelFindAllQueryResultDTO;

public interface PersonnelService {

	public Personnel getOnePersonnel(Long id);

	public List<PersonnelFindAllQueryResultDTO> findByOrganId(Long organId);

}
