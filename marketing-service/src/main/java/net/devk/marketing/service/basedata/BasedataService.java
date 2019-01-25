package net.devk.marketing.service.basedata;

import org.springframework.data.jpa.repository.JpaRepository;

import net.devk.marketing.service.basedata.dto.AggregatedBasedataDTO;
import net.devk.marketing.service.model.AssignedStatusType;
import net.devk.marketing.service.model.AttractionType;
import net.devk.marketing.service.model.BusinessScale;
import net.devk.marketing.service.model.ContactRole;
import net.devk.marketing.service.model.ContactType;
import net.devk.marketing.service.model.DocumentType;
import net.devk.marketing.service.model.OrganizationType;
import net.devk.marketing.service.model.OwnershipType;
import net.devk.marketing.service.model.RequirementStatusType;

/**
 * service interface for base data
 */
public interface BasedataService {

	public AggregatedBasedataDTO getAggregatedBasedata();

	/**
	 * @see JpaRepository#getOne(Object)
	 */
	public BusinessScale getOneBusinessScale(Long id);

	/**
	 * @see JpaRepository#getOne(Object)
	 */
	public ContactType getOneContactType(Long id);

	/**
	 * @see JpaRepository#getOne(Object)
	 */
	public ContactRole getOneContactRole(Long id);

	/**
	 * @see JpaRepository#getOne(Object)
	 */
	public OwnershipType getOneOwnershipType(Long id);

	/**
	 * @see JpaRepository#getOne(Object)
	 */
	public AttractionType getOneAttractionType(Long id);

	/**
	 * @see JpaRepository#getOne(Object)
	 */
	public DocumentType getOneDocumentType(Long id);

	/**
	 * @see JpaRepository#getOne(Object)
	 */
	public OrganizationType getOrganizationType(Long id);

	/**
	 * @see JpaRepository#getOne(Object)
	 */
	public AssignedStatusType getAssignedStatusType(Long id);

	public AttractionType findAttractionTypeByCode(String code);

	public RequirementStatusType findRequirementStatusTypeByCode(String code);

}
