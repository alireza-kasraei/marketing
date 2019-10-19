package net.devk.marketing.security.clients;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import net.devk.marketing.security.clients.dto.ScopeDTO;
import net.devk.marketing.security.model.Client;

interface ClientRepository extends JpaRepository<Client, Long> {

	Optional<Client> findByName(String name);

	@Query("SELECT new net.devk.marketing.security.clients.dto.ScopeDTO(s.name,sc.autoApproved) FROM ScopeClient sc INNER JOIN sc.scope s INNER JOIN sc.client c WHERE c.name=?1")
	List<ScopeDTO> findScopes(String name);
}
