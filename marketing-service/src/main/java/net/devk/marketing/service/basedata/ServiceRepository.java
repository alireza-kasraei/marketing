package net.devk.marketing.service.basedata;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import net.devk.marketing.service.basedata.dto.ServiceDTO;
import net.devk.marketing.service.model.Service;

interface ServiceRepository extends JpaRepository<Service, Long> {

	@Query("select new net.devk.marketing.service.basedata.dto.ServiceDTO(s.id,s.name,s.parent.id) from Service s")
	public List<ServiceDTO> findAllServices();

}
