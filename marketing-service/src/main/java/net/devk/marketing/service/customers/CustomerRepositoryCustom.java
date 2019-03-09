package net.devk.marketing.service.customers;

import java.util.List;

import net.devk.marketing.service.customers.dto.CustomerFindAllQueryResultDTO;

interface CustomerRepositoryCustom {

	public List<CustomerFindAllQueryResultDTO> findAllCustomersLikeByName(String name,int pageNumber , int pageSize);

}
