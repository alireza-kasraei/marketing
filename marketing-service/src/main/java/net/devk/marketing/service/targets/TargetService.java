package net.devk.marketing.service.targets;

import net.devk.marketing.service.model.Target;
import net.devk.marketing.service.model.TargetMember;
import net.devk.marketing.service.targets.dto.AggregateTargetResponseDTO;

public interface TargetService {

	public Target getOneTarget(Long id);

	public TargetMember getOneTargetMember(Long id);

	public AggregateTargetResponseDTO calculateTargetMemberStatistics(Long targetMemberId);

}
