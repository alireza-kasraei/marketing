package net.devk.marketing.service.customers;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;

import net.devk.marketing.service.customers.dto.CustomerQueryResultDTO;
import net.devk.marketing.service.model.Customer;

public class CustomerRepositoryImpl implements CustomerRepositoryCustom {

	@Autowired
	private EntityManager entityManager;

	@Override
	public List<CustomerQueryResultDTO> findAllCustomersLikeByName(String name) {

		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<CustomerQueryResultDTO> query = builder.createQuery(CustomerQueryResultDTO.class);

		Root<Customer> root = query.from(Customer.class);
		List<Predicate> predicateList = new ArrayList<>();
		if (name != null && !name.isEmpty()) {
			predicateList.add(builder.like(root.get("name"), "%" + name + "%"));
		}
		if (!predicateList.isEmpty()) {
			Predicate[] predicates = new Predicate[predicateList.size()];
			query.where(predicateList.toArray(predicates));
		}

		Join<Object, Object> businessScale = root.join("businessScale", JoinType.LEFT);
		Join<Object, Object> ownershipType = root.join("ownershipType", JoinType.LEFT);
		Join<Object, Object> organizationType = root.join("organizationType", JoinType.LEFT);
		query.multiselect(root.get("id").alias("id"), root.get("name").alias("name"),
				root.get("registerDate").alias("registerDate"), root.get("legal").alias("legal"),
				root.get("economicCode").alias("economicCode"), root.get("headCount").alias("headCount"),
				root.get("annualIncome").alias("annualIncome"), root.get("hasDocument").alias("hasDocument"),
				root.get("registrationStatus").alias("registrationStatus"), root.get("username").alias("username"),
				businessScale.get("id").alias("businessScaleId"), businessScale.get("name").alias("businessScaleName"),
				ownershipType.get("id").alias("ownershipTypeId"), ownershipType.get("type").alias("ownershipType"),
				organizationType.get("id").alias("organizationTypeId"),
				organizationType.get("type").alias("organizationTypeName"));
		TypedQuery<CustomerQueryResultDTO> typedQuery = entityManager.createQuery(query);
		return typedQuery.getResultList();

	}

}
