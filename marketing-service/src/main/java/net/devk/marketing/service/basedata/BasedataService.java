package net.devk.marketing.service.basedata;

import net.devk.marketing.service.EntityNotFoundException;
import net.devk.marketing.service.basedata.dto.AggregatedBasedataDTO;
import net.devk.marketing.service.model.*;

/**
 * service interface for base data
 */
public interface BasedataService {

	public AggregatedBasedataDTO getAggregatedBasedata();

	/**
	 * returns the BusinessScale with the given id or else throws
	 * {@link EntityNotFoundException}
	 */
	public BusinessScale findOneBusinessScale(Long id);

	/**
	 * returns the ContactType with the given id or else throws
	 * {@link EntityNotFoundException}
	 */
	public ContactType findOneContactType(Long id);

	/**
	 * returns the ContactRole with the given id or else throws
	 * {@link EntityNotFoundException}
	 */
	public ContactRole findOneContactRole(Long id);

	/**
	 * returns the OwnershipType with the given id or else throws
	 * {@link EntityNotFoundException}
	 */
	public OwnershipType findOneOwnershipType(Long id);

	public OrganizationType findOneOrganizationType(Long id);

	/**
	 * returns the AttractionType with the given id or else throws
	 * {@link EntityNotFoundException}
	 */
	public AttractionType findOneAttractionType(Long id);

	/**
	 * returns the DocumentType with the given id or else throws
	 * {@link EntityNotFoundException}
	 */
	public DocumentType findOneDocumentType(Long id);

	/**
	 * returns the OrganizationType with the given id or else throws
	 * {@link EntityNotFoundException}
	 */
	public OrganizationType findOrganizationType(Long id);

	/**
	 * returns the AssignedStatusType with the given id or else throws
	 * {@link EntityNotFoundException}
	 */
	public AssignedStatusType findAssignedStatusType(Long id);

	public AttractionType findAttractionTypeByCode(String code);

	public RequirementStatusType findRequirementStatusTypeByCode(String code);
	
	public String findFullServiceName(Long childServiceId);

	public SupplyStatusType findSupplyTypeByCode(String supplyStatusCode);
}
