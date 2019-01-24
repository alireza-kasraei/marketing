package net.devk.marketing.service.targets;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import net.devk.marketing.service.charts.dto.PersonnelTargetsResponseDTO;
import net.devk.marketing.service.model.TargetMember;

interface TargetMemberRepository extends JpaRepository<TargetMember, Long> {

	@Query("select new net.devk.marketing.service.charts.dto.PersonnelTargetsResponseDTO(t.id,t.value,t.daysCount,tm.targetMemberValue) from TargetMember tm inner join tm.target t inner join tm.teamMember tmm inner join tmm.personnel p inner join t.service s where p.username=?1 and s.id=?2")
	public List<PersonnelTargetsResponseDTO> findPersonnelTargets(String username, Long serviceId);

}
