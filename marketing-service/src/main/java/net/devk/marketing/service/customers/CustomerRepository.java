package net.devk.marketing.service.customers;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import net.devk.marketing.service.customers.dto.CustomerFindOneQueryResultDTO;
import net.devk.marketing.service.model.Customer;

interface CustomerRepository extends JpaRepository<Customer, Long>, CustomerRepositoryCustom {

	@Query("select new net.devk.marketing.service.customers.dto.CustomerFindOneQueryResultDTO(c.id,c.name,c.registerDate,c.legal,c.economicCode,c.headCount,c.annualIncome,c.hasDocument,c.registrationStatus,c.username,adr.latitude,adr.longitude,b.id,b.name,osh.id,osh.type,ot.id,ot.type) from Customer c inner join c.businessScale b inner join c.ownershipType osh inner join c.organizationType ot inner join c.address adr where c.id=?1")
	public CustomerFindOneQueryResultDTO findCustomerQueryResultById(Long customerId);

}
