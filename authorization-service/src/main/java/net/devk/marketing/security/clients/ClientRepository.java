package net.devk.marketing.security.clients;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {

	Optional<Client> findByClientId(String clientId);
}
