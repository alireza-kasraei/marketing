package net.devk.marketing.service.customers;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import net.devk.marketing.service.model.CustomerAddress;

interface CustomerAddressRepository extends JpaRepository<CustomerAddress, Long> {

	@Query("select ca from CustomerAddress ca where ca.customer.id=?1 ")
	public Optional<CustomerAddress> findByCustomerId(Long customerId);

}
