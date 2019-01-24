package net.devk.marketing.service.charts;

import java.util.List;

import org.springframework.stereotype.Service;

import net.devk.marketing.service.charts.dto.PersonnelTargetsResponseDTO;

@Service
class ChartServiceImpl implements ChartService {

	@Override
	public List<PersonnelTargetsResponseDTO> findPersonTargets(String username, Long serviceId) {
		return null;
	}

}
