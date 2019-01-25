package net.devk.marketing.service.targets;

import java.util.List;

import net.devk.marketing.service.model.Target;
import net.devk.marketing.service.model.TargetMember;
import net.devk.marketing.service.targets.dto.AggregateTargetResponseDTO;
import net.devk.marketing.service.targets.dto.PersonnelTargetsListResponseDTO;
import net.devk.marketing.service.targets.dto.PersonnelTargetsResponseDTO;

public interface TargetService {

	public Target getOneTarget(Long id);

	public TargetMember getOneTargetMember(Long id);

	public List<PersonnelTargetsResponseDTO> findPersonnelTargets(String username, Long serviceId);

	public List<PersonnelTargetsListResponseDTO> findTargets(String username);

	public AggregateTargetResponseDTO calculateTargetStatistics(Long targetId);

}
