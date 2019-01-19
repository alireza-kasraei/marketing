package net.devk.marketing.service.customers;

import org.springframework.data.jpa.repository.JpaRepository;

import net.devk.marketing.service.model.Customer;

interface CustomerRepository extends JpaRepository<Customer, Long>, CustomerRepositoryCustom {

//	@Query("select new net.devk.marketing.service.customers.dto.GetCustomerResponseDTO(c.id,c.name,c.registerDate,c.legal,c.economicCode,c.headCount,c.annualIncome,c.hasDocument,c.registrationStatus,c.username,bs.id,bs.name,ct.id,ct.type,ot.id,ot.type,at.id,at.name) from Customer c join c.businessScale bs join c.customerType ct join c.ownershipType ot join c.attractionType at where c.name like %?1%")
//	public List<GetCustomerResponseDTO> findAllCustomersLikeByName(String name);

}
