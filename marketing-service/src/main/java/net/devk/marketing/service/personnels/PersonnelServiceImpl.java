package net.devk.marketing.service.personnels;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.devk.marketing.service.model.Personnel;
import net.devk.marketing.service.personnels.dto.PersonnelFindAllQueryResultDTO;

@Service
class PersonnelServiceImpl implements PersonnelService {

	@Autowired
	private PersonnelRepository personnelRepository;

	@Override
	public Personnel getOnePersonnel(Long id) {
		return personnelRepository.getOne(id);
	}

	@Override
	public List<PersonnelFindAllQueryResultDTO> findByOrganId(Long organId) {
		return personnelRepository.findByOrganId(organId);
	}

}
