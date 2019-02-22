package net.devk.marketing.security.clients;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import net.devk.marketing.security.model.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {

	Optional<Client> findByClientId(String clientId);

	@Query("SELECT S.name FROM Client C INNER JOIN C.scopes S WHERE C.clientId=?1")
	Optional<List<String>> findScopes(String clientId);
}
