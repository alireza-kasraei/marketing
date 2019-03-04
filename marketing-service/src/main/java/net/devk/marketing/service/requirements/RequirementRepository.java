package net.devk.marketing.service.requirements;

import net.devk.marketing.service.model.Requirement;
import net.devk.marketing.service.requirements.dto.AssignedRequirementFindAllDTO;
import net.devk.marketing.service.requirements.dto.CustomerRequirementResponseDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

interface RequirementRepository extends JpaRepository<Requirement, Long> {

    @Query("select new net.devk.marketing.service.requirements.dto.CustomerRequirementResponseDTO(r.id,r.estimatedValue,r.realValue,r.description,r.estimatedValueEditDate,r.estimatedValueRegisterDate,r.realValueEditDate,r.realValueRegisterDate,r.customer.id,tm.id,tm.value,t.id,t.value,s.id,s.name) from RequirementStatus rs inner join rs.requirment r inner join rs.requirementStatusType rst inner join r.targetMember tm inner join tm.target t inner join t.service s where r.customer.id=?1 and rst.code=?2")
    public List<CustomerRequirementResponseDTO> findRequirements(Long customerId, String requirementStatusTypeId);

    @Query("select new net.devk.marketing.service.requirements.dto.AssignedRequirementFindAllDTO(r.id,r.estimatedValue,r.realValue,r.description,r.estimatedValueEditDate,r.estimatedValueRegisterDate,r.realValueEditDate,r.realValueRegisterDate,r.customer.id,tm.id,tm.value,t.id,t.value,s.id,s.name) from RequirementStatus rs inner join rs.requirment r inner join rs.requirementStatusType rst inner join r.targetMember tm inner join tm.target t inner join t.service s where r.customer.id=?1 and rst.code='RS2'")
    public List<AssignedRequirementFindAllDTO> findAllAssignedRequirementByCustomerId(long customerId);
}
