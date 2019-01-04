package net.devk.marketing.security.accounts;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {

	// <1>
	Optional<Account> findByUsername(String username);
}
