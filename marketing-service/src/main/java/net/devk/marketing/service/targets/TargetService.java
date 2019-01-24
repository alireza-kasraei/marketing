package net.devk.marketing.service.targets;

import net.devk.marketing.service.model.Target;
import net.devk.marketing.service.model.TargetMember;

public interface TargetService {

	public Target getOneTarget(Long id);

	public TargetMember getOneTargetMember(Long id);

}
