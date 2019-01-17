package net.devk.marketing.service.basedata;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.devk.marketing.service.basedata.dto.AggregatedBasedataDTO;
import net.devk.marketing.service.basedata.dto.BasedataDTO;
import net.devk.marketing.service.basedata.dto.ContactTypeDTO;
import net.devk.marketing.service.basedata.dto.ServiceDTO;

@Service
class BasedataServiceImpl implements BasedataService {

	@Autowired
	private ValueTypeRepository valueTypeRepository;
	@Autowired
	private BusinessScaleRepository businessScaleRepository;
	@Autowired
	private ContactRoleRepository contactRoleRepository;
	@Autowired
	private ContactTypeRepository contactTypeRepository;
	@Autowired
	private AttractionTypeRepository attractionTypeRepository;
	@Autowired
	private DocumentTypeRepository documentTypeRepository;
	@Autowired
	private RequirementStatusTypeRepository requirementStatusTypeRepository;
	@Autowired
	private AssignedStatusTypeRepository assignedStatusTypeRepository;
	@Autowired
	private CustomerTypeRepository customerTypeRepository;
	@Autowired
	private OwnershipTypeRepository ownershipTypeRepository;
	@Autowired
	private ServiceRepository serviceRepository;

	@Override
	public AggregatedBasedataDTO getAggregatedBasedata() {

		List<BasedataDTO> valueTypes = valueTypeRepository.findAll().stream()
				.map(v -> new BasedataDTO(v.getId(), v.getName())).collect(Collectors.toList());

		List<BasedataDTO> businessScales = businessScaleRepository.findAll().stream()
				.map(b -> new BasedataDTO(b.getId(), b.getName())).collect(Collectors.toList());

		List<BasedataDTO> contactRoles = contactRoleRepository.findAll().stream()
				.map(c -> new BasedataDTO(c.getId(), c.getName())).collect(Collectors.toList());

		List<ContactTypeDTO> contactTypes = contactTypeRepository.findAllContactTypes();

		List<BasedataDTO> attractionTypes = attractionTypeRepository.findAll().stream()
				.map(a -> new BasedataDTO(a.getId(), a.getName())).collect(Collectors.toList());

		List<BasedataDTO> documentTypes = documentTypeRepository.findAll().stream()
				.map(d -> new BasedataDTO(d.getId(), d.getType())).collect(Collectors.toList());

		List<BasedataDTO> requirementStatusTypes = requirementStatusTypeRepository.findAll().stream()
				.map(r -> new BasedataDTO(r.getId(), r.getType())).collect(Collectors.toList());

		List<BasedataDTO> assignedStatusType = assignedStatusTypeRepository.findAll().stream()
				.map(a -> new BasedataDTO(a.getId(), a.getName())).collect(Collectors.toList());

		List<BasedataDTO> customerTypes = customerTypeRepository.findAll().stream()
				.map(c -> new BasedataDTO(c.getId(), c.getType())).collect(Collectors.toList());

		List<BasedataDTO> ownershipTypes = ownershipTypeRepository.findAll().stream()
				.map(o -> new BasedataDTO(o.getId(), o.getType())).collect(Collectors.toList());

		List<ServiceDTO> services = serviceRepository.findAllServices();

		AggregatedBasedataDTO aggregatedBasedataDTO = new AggregatedBasedataDTO();
		aggregatedBasedataDTO.setAssignStatusTypes(assignedStatusType);
		aggregatedBasedataDTO.setAttractionTypes(attractionTypes);
		aggregatedBasedataDTO.setBusinessScales(businessScales);
		aggregatedBasedataDTO.setContactRoles(contactRoles);
		aggregatedBasedataDTO.setContactTypes(contactTypes);
		aggregatedBasedataDTO.setCustomerTypes(customerTypes);
		aggregatedBasedataDTO.setDocumentTypes(documentTypes);
		aggregatedBasedataDTO.setOwnershipTypes(ownershipTypes);
		aggregatedBasedataDTO.setRequirementStatusTypes(requirementStatusTypes);
		aggregatedBasedataDTO.setValueTypes(valueTypes);

		aggregatedBasedataDTO.setServices(services);
		return aggregatedBasedataDTO;
	}

}
