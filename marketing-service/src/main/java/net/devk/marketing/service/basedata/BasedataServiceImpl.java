package net.devk.marketing.service.basedata;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.devk.marketing.service.basedata.dto.AggregatedBasedataDTO;
import net.devk.marketing.service.basedata.dto.BasedataDTO;
import net.devk.marketing.service.basedata.dto.ContactTypeDTO;
import net.devk.marketing.service.basedata.dto.ServiceDTO;
import net.devk.marketing.service.model.AssignedStatusType;
import net.devk.marketing.service.model.AttractionType;
import net.devk.marketing.service.model.BusinessScale;
import net.devk.marketing.service.model.ContactRole;
import net.devk.marketing.service.model.ContactType;
import net.devk.marketing.service.model.DocumentType;
import net.devk.marketing.service.model.OrganizationType;
import net.devk.marketing.service.model.OwnershipType;
import net.devk.marketing.service.model.RequirementStatusType;

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
	private OwnershipTypeRepository ownershipTypeRepository;
	@Autowired
	private ServiceRepository serviceRepository;
	@Autowired
	private OrganizationTypeRepository organizationTypeRepository;

	@Override
	public AggregatedBasedataDTO getAggregatedBasedata() {

		List<BasedataDTO> valueTypes = Collections.unmodifiableList(valueTypeRepository.findAll().stream()
				.map(v -> new BasedataDTO(v.getId(), v.getName())).collect(Collectors.toList()));

		List<BasedataDTO> businessScales = Collections.unmodifiableList(businessScaleRepository.findAll().stream()
				.map(b -> new BasedataDTO(b.getId(), b.getName())).collect(Collectors.toList()));

		List<BasedataDTO> contactRoles = Collections.unmodifiableList(contactRoleRepository.findAll().stream()
				.map(c -> new BasedataDTO(c.getId(), c.getName())).collect(Collectors.toList()));

		List<ContactTypeDTO> contactTypes = Collections.unmodifiableList(contactTypeRepository.findAll().stream().map(
				ct -> new ContactTypeDTO(ct.getId(), ct.getName(), ct.getCategory().name(), ct.getCategory().ordinal()))
				.collect(Collectors.toList()));

		List<BasedataDTO> attractionTypes = Collections.unmodifiableList(attractionTypeRepository.findAll().stream()
				.map(a -> new BasedataDTO(a.getId(), a.getName())).collect(Collectors.toList()));

		List<BasedataDTO> documentTypes = Collections.unmodifiableList(documentTypeRepository.findAll().stream()
				.map(d -> new BasedataDTO(d.getId(), d.getType())).collect(Collectors.toList()));

		List<BasedataDTO> requirementStatusTypes = Collections.unmodifiableList(requirementStatusTypeRepository
				.findAll().stream().map(r -> new BasedataDTO(r.getId(), r.getType())).collect(Collectors.toList()));

		List<BasedataDTO> assignedStatusType = Collections.unmodifiableList(assignedStatusTypeRepository.findAll()
				.stream().map(a -> new BasedataDTO(a.getId(), a.getName())).collect(Collectors.toList()));

		List<BasedataDTO> ownershipTypes = Collections.unmodifiableList(ownershipTypeRepository.findAll().stream()
				.map(o -> new BasedataDTO(o.getId(), o.getType())).collect(Collectors.toList()));

		List<BasedataDTO> organizationTypes = Collections.unmodifiableList(organizationTypeRepository.findAll().stream()
				.map(o -> new BasedataDTO(o.getId(), o.getType())).collect(Collectors.toList()));

		List<ServiceDTO> services = Collections.unmodifiableList(serviceRepository.findAllServices());

		return new AggregatedBasedataDTO(valueTypes, businessScales, contactRoles, attractionTypes, documentTypes,
				requirementStatusTypes, assignedStatusType, ownershipTypes, organizationTypes, contactTypes, services);
	}

	@Override
	public BusinessScale getOneBusinessScale(Long id) {
		return businessScaleRepository.getOne(id);
	}

	@Override
	public OwnershipType getOneOwnershipType(Long id) {
		return ownershipTypeRepository.getOne(id);
	}

	@Override
	public AttractionType getOneAttractionType(Long id) {
		return attractionTypeRepository.getOne(id);
	}

	@Override
	public ContactType getOneContactType(Long id) {
		return contactTypeRepository.getOne(id);
	}

	@Override
	public ContactRole getOneContactRole(Long id) {
		return contactRoleRepository.getOne(id);
	}

	@Override
	public DocumentType getOneDocumentType(Long id) {
		return documentTypeRepository.getOne(id);
	}

	@Override
	public OrganizationType getOrganizationType(Long id) {
		return organizationTypeRepository.getOne(id);
	}

	@Override
	public AttractionType findAttractionTypeByCode(String code) {
		return attractionTypeRepository.findByCode(code);
	}

	@Override
	public RequirementStatusType findRequirementStatusTypeByCode(String code) {
		return requirementStatusTypeRepository.findByCode(code);
	}

	@Override
	public AssignedStatusType getAssignedStatusType(Long id) {
		return assignedStatusTypeRepository.getOne(id);
	}

}
