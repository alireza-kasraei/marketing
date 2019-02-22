package net.devk.marketing.security.users;

import java.util.Optional;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import net.devk.marketing.security.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

	Optional<User> findByUsername(String username);

	@Query("SELECT DISTINCT R.name FROM User U INNER JOIN U.groups G INNER JOIN G.roles R WHERE U.username=?1")
	Set<String> findRoles(String username);

}
