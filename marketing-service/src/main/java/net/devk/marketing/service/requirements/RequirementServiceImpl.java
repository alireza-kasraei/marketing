package net.devk.marketing.service.requirements;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.devk.marketing.service.basedata.BasedataService;
import net.devk.marketing.service.customers.CustomerService;
import net.devk.marketing.service.model.Customer;
import net.devk.marketing.service.model.Requirement;
import net.devk.marketing.service.model.RequirementStatus;
import net.devk.marketing.service.model.RequirementStatusType;
import net.devk.marketing.service.model.TargetMember;
import net.devk.marketing.service.requirements.dto.CreateNewRequirementResponseDTO;
import net.devk.marketing.service.targets.TargetService;

@Service
class RequirementServiceImpl implements RequirementService {

	@Autowired
	private RequirementRepository requirementRepository;

	@Autowired
	private RequirementStatusRepository requirementStatusRepository;

	@Autowired
	private CustomerService customerService;

	@Autowired
	private TargetService targetService;

	@Autowired
	private BasedataService basedataService;

	@Override
	@Transactional
	public CreateNewRequirementResponseDTO createRequirement(Long customerId, Long targetMemberId,
			Integer estimatedValue, String description) {

		Customer customer = customerService.getOneCustomer(customerId);
		TargetMember targetMember = targetService.getOneTargetMember(targetMemberId);
		Date now = new Date();

		Requirement requirement = new Requirement();
		requirement.setCustomer(customer);
		requirement.setTargetMember(targetMember);
		requirement.setDescription(description);
		requirement.setEstimatedValue(estimatedValue);
		requirement.setEstimatedValueRegisterDate(now);
		Requirement savedRequirement = requirementRepository.save(requirement);

		RequirementStatus requirementStatus = new RequirementStatus();
		requirementStatus.setRegisterDate(now);
		requirementStatus.setRequirment(savedRequirement);
		requirementStatus.setRequirementStatusType(
				basedataService.findRequirementStatusTypeByCode(RequirementStatusType.REQUIREMENT_STATUS_STATUS1));

		requirementStatusRepository.save(requirementStatus);

		return new CreateNewRequirementResponseDTO(savedRequirement.getId(), savedRequirement.getEstimatedValue(),
				savedRequirement.getRealValue(), savedRequirement.getDescription(),
				savedRequirement.getEstimatedValueEditDate(), savedRequirement.getEstimatedValueRegisterDate(),
				requirement.getRealValueEditDate(), requirement.getRealValueRegisterDate());
	}

}
