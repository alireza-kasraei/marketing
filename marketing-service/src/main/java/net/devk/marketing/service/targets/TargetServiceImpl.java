package net.devk.marketing.service.targets;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.devk.marketing.service.model.Target;
import net.devk.marketing.service.model.TargetMember;

@Service
class TargetServiceImpl implements TargetService {

	@Autowired
	private TargetRepository targetRepository;

	@Autowired
	private TargetMemberRepository targetMemberRepository;

	@Override
	public Target getOneTarget(Long id) {
		return targetRepository.getOne(id);
	}

	@Override
	public TargetMember getOneTargetMember(Long id) {
		return targetMemberRepository.getOne(id);
	}

}
