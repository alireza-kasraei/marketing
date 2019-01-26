package net.devk.marketing.service.organ;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.devk.marketing.service.model.Organ;
import net.devk.marketing.service.organ.dto.OrganFindAllQueryResultDTO;

@Service
class OrganServiceImpl implements OrganService {

	@Autowired
	private OrganRepository organRepository;

	@Override
	@Transactional
	public Organ createOrgan(String name, Integer level, Integer order, Long parentId) {
		Organ organ = new Organ();
		organ.setName(name);
		organ.setLevel(level);
		organ.setOrder(order);
		if (parentId != null) {
			organ.setParent(organRepository.getOne(parentId));
		}
		return organRepository.save(organ);
	}

	@Override
	public List<OrganFindAllQueryResultDTO> findAllOrgans() {
		return organRepository.findAllOrgans();
	}

}
