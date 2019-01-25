package net.devk.marketing.service.targets;

import java.util.List;

import net.devk.marketing.service.model.Target;
import net.devk.marketing.service.model.TargetMember;
import net.devk.marketing.service.targets.dto.AggregateTargetResponseDTO;
import net.devk.marketing.service.targets.dto.TargetMemberListQueryResultDTO;
import net.devk.marketing.service.targets.dto.TargetMemberQueryResultDTO;

public interface TargetService {

	public Target getOneTarget(Long id);

	public TargetMember getOneTargetMember(Long id);

	public List<TargetMemberQueryResultDTO> findPersonnelTargets(String username, Long serviceId);

	public List<TargetMemberListQueryResultDTO> findTargets(String username);

	public AggregateTargetResponseDTO calculateTargetStatistics(Long targetId);

}
