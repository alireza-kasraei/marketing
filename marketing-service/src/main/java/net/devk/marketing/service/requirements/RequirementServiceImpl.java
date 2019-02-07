package net.devk.marketing.service.requirements;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.devk.marketing.service.basedata.BasedataService;
import net.devk.marketing.service.customers.CustomerService;
import net.devk.marketing.service.model.AssignedRequirement;
import net.devk.marketing.service.model.AssignedRequirementStatus;
import net.devk.marketing.service.model.AttractionType;
import net.devk.marketing.service.model.Customer;
import net.devk.marketing.service.model.Requirement;
import net.devk.marketing.service.model.RequirementStatus;
import net.devk.marketing.service.model.RequirementStatusType;
import net.devk.marketing.service.model.TargetMember;
import net.devk.marketing.service.personnels.PersonnelService;
import net.devk.marketing.service.requirements.dto.CreateNewRequirementRequestDTO;
import net.devk.marketing.service.requirements.dto.CreateNewRequirementResponseDTO;
import net.devk.marketing.service.requirements.dto.CustomerRequirementResponseDTO;
import net.devk.marketing.service.targets.TargetService;
import net.devk.marketing.service.util.DateUtils;

@Service
class RequirementServiceImpl implements RequirementService {

	@Autowired
	private AssignedRequirementRepository assignedRequirementRepository;

	@Autowired
	private AssignedRequirementStatusRepository assignedRequirementStatusRepository;

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

	@Autowired
	private PersonnelService personnelService;

	@Override
	@Transactional
	public CreateNewRequirementResponseDTO createRequirement(Long customerId, Long targetMemberId, Long estimatedValue,
			String description) {

		Date now = DateUtils.now();
		Customer customer = customerService.getOneCustomer(customerId);
		TargetMember targetMember = targetService.getOneTargetMember(targetMemberId);

		customerService.setCustomerAttractionStatus(customerId, AttractionType.ATTRACTION_TYPE_TYPE2);

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

	@Transactional
	@Override
	public void assignRequirement(Long requirementId, Long personnelId, Long assignedStatusTypeId, Long realValue) {
		Date now = DateUtils.now();
		Optional<Requirement> requirementOptional = requirementRepository.findById(requirementId);
		Requirement requirement = requirementOptional.orElseThrow(() -> new RuntimeException("requirement not found"));
		requirement.setRealValue(realValue);
		requirement.setRealValueEditDate(now);
		Requirement savedRequirement = requirementRepository.save(requirement);

		customerService.setCustomerAttractionStatus(savedRequirement.getCustomer().getId(),
				AttractionType.ATTRACTION_TYPE_TYPE3);

		RequirementStatus requirementStatus = new RequirementStatus();
		requirementStatus.setRequirment(savedRequirement);
		requirementStatus.setRegisterDate(now);
		requirementStatus.setRequirementStatusType(
				basedataService.findRequirementStatusTypeByCode(RequirementStatusType.REQUIREMENT_STATUS_STATUS2));
		requirementStatusRepository.save(requirementStatus);

		AssignedRequirement assignedRequirement = new AssignedRequirement();
		assignedRequirement.setCustomerRequirment(savedRequirement);
		assignedRequirement.setPersonnel(personnelService.getOnePersonnel(personnelId));
		assignedRequirement.setRegisterDate(now);
		AssignedRequirement savedAssignedRequirement = assignedRequirementRepository.save(assignedRequirement);
		AssignedRequirementStatus assignedRequirementStatus = new AssignedRequirementStatus();
		assignedRequirementStatus.setAssignedRequirement(savedAssignedRequirement);
		assignedRequirementStatus.setRegisterDate(now);
		assignedRequirementStatus.setAssignedStatusType(basedataService.getAssignedStatusType(assignedStatusTypeId));
		assignedRequirementStatusRepository.save(assignedRequirementStatus);

	}

	@Override
	@Transactional
	public List<CreateNewRequirementResponseDTO> createRequirement(Long customerId,
			List<CreateNewRequirementRequestDTO> list) {
		List<CreateNewRequirementResponseDTO> result = new ArrayList<CreateNewRequirementResponseDTO>();

		list.stream().forEach(c -> {
			CreateNewRequirementResponseDTO requirement = createRequirement(customerId, c.getTargetMemberId(),
					c.getEstimatedValue(), c.getDescription());
			result.add(requirement);
		});

		return result;
	}

	@Override
	public List<CustomerRequirementResponseDTO> findRequirements(Long customerId, String requirementStatusTypeCode) {
		return requirementRepository.findRequirements(customerId, requirementStatusTypeCode);
	}

}
