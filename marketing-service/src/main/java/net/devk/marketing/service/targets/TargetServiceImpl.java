package net.devk.marketing.service.targets;

import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.devk.marketing.service.model.AssignedStatusType;
import net.devk.marketing.service.model.RequirementStatusType;
import net.devk.marketing.service.model.Target;
import net.devk.marketing.service.model.TargetMember;
import net.devk.marketing.service.targets.dto.AggregateTargetResponseDTO;
import net.devk.marketing.service.targets.dto.TargetMemberListQueryResultDTO;
import net.devk.marketing.service.targets.dto.TargetMemberQueryResultDTO;

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
	public AggregateTargetResponseDTO calculateTargetStatistics(Long targetId) {

		Date now = new Date();
		Long summation = targetMemberRepository.sumTargetStatistics(targetId, now,
				RequirementStatusType.REQUIREMENT_STATUS_STATUS1, AssignedStatusType.ASSIGNED_STATUS_TYPE1);

		Target target = targetRepository.findById(targetId).get();
		long days = calculateDayNumber(target.getRegisterDate(), now);

		Long totalValue = target.getValue();

		long averageProgressToNow = (totalValue.longValue() / target.getDaysCount().intValue()) * days;

		long totalDays = calculateDayNumber(target.getRegisterDate(), target.getDueDate());

		long progressPercentageToNow = (summation.longValue() / averageProgressToNow) * 100;

		long todayProgress = (summation.longValue() / days) * 100;

		return new AggregateTargetResponseDTO(summation.longValue(), days, totalValue.longValue(), averageProgressToNow,
				totalDays, progressPercentageToNow, todayProgress);
	}

	@Override
	@Transactional
	public AggregateTargetResponseDTO calculateTargetMemberStatistics(Long targetMemberId) {
		Date now = new Date();
		Long summation = targetMemberRepository.sumTargetMemberStatistics(targetMemberId, now,
				RequirementStatusType.REQUIREMENT_STATUS_STATUS1, AssignedStatusType.ASSIGNED_STATUS_TYPE1);

		TargetMember targetMember = targetMemberRepository.findById(targetMemberId).get();
		long days = calculateDayNumber(targetMember.getRegisterDate(), now);

		Target target = targetMember.getTarget();
		Long totalValue = target.getValue();

		long averageProgressToNow = (totalValue.longValue() / target.getDaysCount().intValue()) * days;

		long totalDays = calculateDayNumber(targetMember.getRegisterDate(), targetMember.getDueDate());

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
