package net.devk.marketing.service.targets;

import java.util.List;

import net.devk.marketing.service.charts.dto.PersonnelTargetsResponseDTO;
import net.devk.marketing.service.model.Target;
import net.devk.marketing.service.model.TargetMember;

public interface TargetService {

	public Target getOneTarget(Long id);

	public TargetMember getOneTargetMember(Long id);
	
	public List<PersonnelTargetsResponseDTO> findPersonnelTargets(String username, Long serviceId);

}
