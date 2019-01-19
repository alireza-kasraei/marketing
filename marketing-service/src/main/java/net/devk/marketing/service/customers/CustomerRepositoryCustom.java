package net.devk.marketing.service.customers;

import java.util.List;

import net.devk.marketing.service.customers.dto.GetCustomerResponseDTO;

interface CustomerRepositoryCustom {

	public List<GetCustomerResponseDTO> findAllCustomersLikeByName(String name);

}
