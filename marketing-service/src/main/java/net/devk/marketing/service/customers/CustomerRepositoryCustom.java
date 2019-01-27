package net.devk.marketing.service.customers;

import java.util.List;

import net.devk.marketing.service.customers.dto.CustomerQueryResultDTO;

interface CustomerRepositoryCustom {

	public List<CustomerQueryResultDTO> findAllCustomersLikeByName(String name);

}
