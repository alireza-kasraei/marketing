package net.devk.marketing.service.targets;

import net.devk.commons.util.date.DateUtils;
import net.devk.marketing.service.basedata.BasedataService;
import net.devk.marketing.service.model.AttractionType;
import net.devk.marketing.service.model.RequirementStatusType;
import net.devk.marketing.service.model.Target;
import net.devk.marketing.service.model.TargetMember;
import net.devk.marketing.service.targets.dto.AggregateTargetResponseDTO;
import net.devk.marketing.service.targets.dto.TargetMemberListQueryResultDTO;
import net.devk.marketing.service.targets.dto.TargetMemberQueryResultDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.List;

@Service
class TargetServiceImpl implements TargetService {

    @Autowired
    private TargetRepository targetRepository;

    @Autowired
    private TargetMemberRepository targetMemberRepository;

    @Autowired
    private BasedataService basedataService;

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

    @Override
    public List<TargetMemberQueryResultDTO> findPersonnelTargetsWithoutServiceId(String username) {
        return targetMemberRepository.findTargetMemberByUsername(username);
    }

    private long calculateDayNumber(Date firstDate, Date secondDate) {
        return ChronoUnit.DAYS.between(firstDate.toInstant(), secondDate.toInstant());
    }

    @Override
    @Transactional
    public AggregateTargetResponseDTO calculateTargetMemberStatistics(Long targetMemberId) {
        Date now = DateUtils.now();
//        startDate = DateUtils.convertToMidday(startDate);
//        endDate = DateUtils.convertToMidnight(endDate);
//        Long summation = targetMemberRepository.sumTargetMemberStatistics(targetMemberId, startDate, endDate, RequirementStatusType.REQUIREMENT_STATUS_STATUS4, AttractionType.ATTRACTION_TYPE_TYPE3);
        Long summation = targetMemberRepository.sumTargetMemberStatistics(targetMemberId, now, RequirementStatusType.REQUIREMENT_STATUS_STATUS4, AttractionType.ATTRACTION_TYPE_TYPE3);

        TargetMember targetMember = targetMemberRepository.findById(targetMemberId)
                .orElseThrow(() -> new RuntimeException("targetmember not found"));
        Target target = targetMember.getTarget();
        long days = calculateDayNumber(target.getStartDate(), now);

        Long totalValue = targetMember.getValue();

        double averageProgressToNow = (totalValue.doubleValue() / target.getDaysCount().intValue()) * days;

//		long totalDays = calculateDayNumber(targetMember.getRegisterDate(), targetMember.getDueDate());
        long totalDays = target.getDaysCount();

        double progressPercentageToNow = (summation.longValue() / averageProgressToNow) * 100;

        double todayProgress = (summation.doubleValue() / totalValue.doubleValue()) * 100;

        return new AggregateTargetResponseDTO(summation.longValue(), days, totalValue.longValue(), averageProgressToNow,
                totalDays, progressPercentageToNow, todayProgress);
    }

    @Override
    @Transactional
    public AggregateTargetResponseDTO calculateTargetMemberStatistics(Long targetMemberId, Date startDate, Date endDate) {
        Date now = DateUtils.now();
        startDate = DateUtils.convertToMidday(startDate);
        endDate = DateUtils.convertToMidnight(endDate);
/*        Long summation = targetMemberRepository.sumTargetMemberStatistics(targetMemberId, startDate, endDate,
                RequirementStatusType.REQUIREMENT_STATUS_STATUS4, AttractionType.ATTRACTION_TYPE_TYPE3);
        */
        Long summation = targetMemberRepository.sumTargetMemberStatistics(targetMemberId, now,
                RequirementStatusType.REQUIREMENT_STATUS_STATUS4, AttractionType.ATTRACTION_TYPE_TYPE3);

        TargetMember targetMember = targetMemberRepository.findById(targetMemberId)
                .orElseThrow(() -> new RuntimeException("targetmember not found"));
        Target target = targetMember.getTarget();
        long days = calculateDayNumber(target.getStartDate(), now);

        Long totalValue = targetMember.getValue();

        double averageProgressToNow = (totalValue.doubleValue() / target.getDaysCount().intValue()) * days;

//		long totalDays = calculateDayNumber(targetMember.getRegisterDate(), targetMember.getDueDate());
        long totalDays = target.getDaysCount();

        double progressPercentageToNow = (summation.longValue() / averageProgressToNow) * 100;

        double todayProgress = (summation.doubleValue() / totalValue.doubleValue()) * 100;

        return new AggregateTargetResponseDTO(summation.longValue(), days, totalValue.longValue(), averageProgressToNow,
                totalDays, progressPercentageToNow, todayProgress);
    }

    @Override
    public List<TargetMemberListQueryResultDTO> findTargets(String username) {
        List<TargetMemberListQueryResultDTO> targetMembers = targetMemberRepository.findTargetsByUsername(username);
        // replace with oracle function
        targetMembers.stream().forEach(tm -> tm.setServiceName(basedataService.findFullServiceName(tm.getServiceId())));
        return targetMembers;
    }

}
