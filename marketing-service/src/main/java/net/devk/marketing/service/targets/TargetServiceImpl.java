package net.devk.marketing.service.targets;

import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.devk.marketing.service.model.AttractionType;
import net.devk.marketing.service.model.RequirementStatusType;
import net.devk.marketing.service.model.Target;
import net.devk.marketing.service.model.TargetMember;
import net.devk.marketing.service.targets.dto.AggregateTargetResponseDTO;
import net.devk.marketing.service.targets.dto.TargetMemberListQueryResultDTO;
import net.devk.marketing.service.targets.dto.TargetMemberQueryResultDTO;
import net.devk.marketing.service.util.DateUtils;

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

	@Override
	public List<TargetMemberQueryResultDTO> findPersonnelTargets(String username, Long serviceId) {
		return targetMemberRepository.findTargetMemberByUsernameAndServiceId(username, serviceId);
	}

	private long calculateDayNumber(Date firstDate, Date secondDate) {
		return ChronoUnit.DAYS.between(firstDate.toInstant(), secondDate.toInstant());
	}

	@Override
	@Transactional
	public AggregateTargetResponseDTO calculateTargetMemberStatistics(Long targetMemberId) {
		Date now = DateUtils.now();
		Long summation = targetMemberRepository.sumTargetMemberStatistics(targetMemberId, now,
				RequirementStatusType.REQUIREMENT_STATUS_STATUS3, AttractionType.ATTRACTION_TYPE_TYPE3);

		TargetMember targetMember = targetMemberRepository.findById(targetMemberId).orElseThrow(()-> new RuntimeException("targetmember not found"));
		Target target = targetMember.getTarget();
		long days = calculateDayNumber(target.getStartDate(), now);

		Long totalValue = targetMember.getValue();

		long averageProgressToNow = (totalValue.longValue() / target.getDaysCount().intValue()) * days;

//		long totalDays = calculateDayNumber(targetMember.getRegisterDate(), targetMember.getDueDate());
		long totalDays = target.getDaysCount();

		long progressPercentageToNow = (summation.longValue() / averageProgressToNow) * 100;

		long todayProgress = (summation.longValue() / days) * 100;

		return new AggregateTargetResponseDTO(summation.longValue(), days, totalValue.longValue(), averageProgressToNow,
				totalDays, progressPercentageToNow, todayProgress);
	}

	@Override
	public List<TargetMemberListQueryResultDTO> findTargets(String username) {
		return targetMemberRepository.findTargetsByUsername(username);
	}

}
