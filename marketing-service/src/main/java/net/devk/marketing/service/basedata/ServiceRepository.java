package net.devk.marketing.service.basedata;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import net.devk.marketing.service.basedata.dto.ServiceDTO;
import net.devk.marketing.service.model.Service;

interface ServiceRepository extends JpaRepository<Service, Long> {

	@Query("select new net.devk.marketing.service.basedata.dto.ServiceDTO(s.id,s.name,s.parent.id) from Service s")
	public List<ServiceDTO> findAllServices();

	@Query(value = "select t.serviceName from (select ltrim(sys_connect_by_path(service_name,'-'),'-') as serviceName,parent_id as pid  from services connect by prior PARENT_ID = ID  start with id = ?1) t where t.pid is  null", nativeQuery = true)
	public String findFullServiceName(Long childServiceId);

}
