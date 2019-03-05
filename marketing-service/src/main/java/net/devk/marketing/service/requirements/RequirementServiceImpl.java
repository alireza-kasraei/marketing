package net.devk.marketing.service.requirements;

import net.devk.commons.util.date.DateUtils;
import net.devk.marketing.service.basedata.BasedataService;
import net.devk.marketing.service.customers.CustomerService;
import net.devk.marketing.service.model.*;
import net.devk.marketing.service.personnels.PersonnelService;
import net.devk.marketing.service.requirements.dto.CreateNewRequirementRequestDTO;
import net.devk.marketing.service.requirements.dto.CreateNewRequirementResponseDTO;
import net.devk.marketing.service.requirements.dto.CustomerRequirementResponseDTO;
import net.devk.marketing.service.targets.TargetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

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


    @Autowired
    private SupplyRequirementStatusRepository supplyRequirementStatusRepository;


    @Override
    @Transactional
    public CreateNewRequirementResponseDTO createRequirement(Long customerId, Long targetMemberId, Long estimatedValue,
                                                             String description) {

        Date now = DateUtils.now();
        Customer customer = customerService.findOneCustomer(customerId);
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
        Requirement requirement = findRequirement(requirementId);
        requirement.setRealValue(realValue);
        requirement.setRealValueEditDate(now);
        Requirement savedRequirement = requirementRepository.save(requirement);

        customerService.setCustomerAttractionStatus(savedRequirement.getCustomer().getId(),
                AttractionType.ATTRACTION_TYPE_TYPE3);

        RequirementStatus requirementStatus = new RequirementStatus();
        requirementStatus.setRequirment(savedRequirement);
        requirementStatus.setRegisterDate(now);
        requirementStatus.setRequirementStatusType(
                basedataService.findRequirementStatusTypeByCode(RequirementStatusType.REQUIREMENT_STATUS_STATUS4));
        requirementStatusRepository.save(requirementStatus);

        AssignedRequirement assignedRequirement = new AssignedRequirement();
        assignedRequirement.setCustomerRequirment(savedRequirement);
        assignedRequirement.setPersonnel(personnelService.getOnePersonnel(personnelId));
        assignedRequirement.setRegisterDate(now);
        AssignedRequirement savedAssignedRequirement = assignedRequirementRepository.save(assignedRequirement);
        AssignedRequirementStatus assignedRequirementStatus = new AssignedRequirementStatus();
        assignedRequirementStatus.setAssignedRequirement(savedAssignedRequirement);
        assignedRequirementStatus.setRegisterDate(now);
        assignedRequirementStatus.setAssignedStatusType(basedataService.findAssignedStatusType(assignedStatusTypeId));
        assignedRequirementStatusRepository.save(assignedRequirementStatus);

    }

    @Transactional
    @Override
    public void createSupplyRequirement(Long requirementId, String value, String supplyStatusCode) {
        Date now = DateUtils.now();
        Requirement requirement = findRequirement(requirementId);
        customerService.setCustomerAttractionStatus(requirement.getCustomer().getId(),
                AttractionType.ATTRACTION_TYPE_TYPE4);
        RequirementStatus requirementStatus = new RequirementStatus();
        requirementStatus.setRequirment(requirement);
        requirementStatus.setRegisterDate(now);
        requirementStatus.setRequirementStatusType(
                basedataService.findRequirementStatusTypeByCode(RequirementStatusType.REQUIREMENT_STATUS_STATUS4));
        RequirementStatus saveRequirementStatus = requirementStatusRepository.save(requirementStatus);

        SupplyRequirementStatus supplyRequirementStatus = new SupplyRequirementStatus();
        supplyRequirementStatus.setValue(value);
        supplyRequirementStatus.setRequirmentStatus(saveRequirementStatus);

        SupplyStatusType supplyStatusType = basedataService.findSupplyTypeByCode(supplyStatusCode);
        supplyRequirementStatus.setSupplyStatusType(supplyStatusType);
        supplyRequirementStatusRepository.save(supplyRequirementStatus);
    }


    private Requirement findRequirement(long requirementId) {
        Optional<Requirement> requirementOptional = requirementRepository.findById(requirementId);
        return requirementOptional.orElseThrow(() -> new RuntimeException("requirement not found"));
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
