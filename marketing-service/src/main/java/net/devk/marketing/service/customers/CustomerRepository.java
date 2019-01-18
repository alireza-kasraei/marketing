package net.devk.marketing.service.customers;

import org.springframework.data.jpa.repository.JpaRepository;

import net.devk.marketing.service.model.Customer;

interface CustomerRepository extends JpaRepository<Customer, Long> {

}
