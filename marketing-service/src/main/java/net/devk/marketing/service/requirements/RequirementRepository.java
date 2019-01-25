package net.devk.marketing.service.requirements;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import net.devk.marketing.service.model.Requirement;
import net.devk.marketing.service.requirements.dto.CustomerRequirementResponseDTO;

interface RequirementRepository extends JpaRepository<Requirement, Long> {

	@Query("select new net.devk.marketing.service.requirements.dto.CustomerRequirementResponseDTO(r.id,r.estimatedValue,r.realValue,r.description,r.estimatedValueEditDate,r.estimatedValueRegisterDate,r.realValueEditDate,r.realValueRegisterDate,r.customer.id,tm.id,tm.value,t.id,t.value,s.id,s.name) from Requirement r inner join r.targetMember tm inner join tm.target t inner join t.service s where r.customer.id=?1")
	public List<CustomerRequirementResponseDTO> findRequirements(Long customerId);

}
