package net.devk.marketing.service.charts;

import java.util.List;

import net.devk.marketing.service.charts.dto.PersonnelTargetsResponseDTO;

public interface ChartService {

	public List<PersonnelTargetsResponseDTO> findPersonTargets(String username, Long serviceId);

}
