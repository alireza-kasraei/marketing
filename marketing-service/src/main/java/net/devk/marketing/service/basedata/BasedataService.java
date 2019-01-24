package net.devk.marketing.service.basedata;

import net.devk.marketing.service.basedata.dto.AggregatedBasedataDTO;
import net.devk.marketing.service.model.AttractionType;
import net.devk.marketing.service.model.BusinessScale;
import net.devk.marketing.service.model.ContactRole;
import net.devk.marketing.service.model.ContactType;
import net.devk.marketing.service.model.CustomerType;
import net.devk.marketing.service.model.DocumentType;
import net.devk.marketing.service.model.OrganizationType;
import net.devk.marketing.service.model.OwnershipType;
import net.devk.marketing.service.model.RequirementStatusType;

public interface BasedataService {

	public AggregatedBasedataDTO getAggregatedBasedata();

	public BusinessScale getOneBusinessScale(Long id);

	public CustomerType getOneCustomerType(Long id);

	public ContactType getOneContactType(Long id);

	public ContactRole getOneContactRole(Long id);

	public OwnershipType getOneOwnershipType(Long id);

	public AttractionType getOneAttractionType(Long id);

	public DocumentType getOneDocumentType(Long id);

	public OrganizationType getOrganizationType(Long id);

	public AttractionType findAttractionTypeByCode(String code);

	public RequirementStatusType findRequirementStatusTypeByCode(String code);

}
