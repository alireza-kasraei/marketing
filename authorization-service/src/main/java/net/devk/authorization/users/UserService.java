package net.devk.authorization.users;

import java.util.Optional;
import java.util.Set;

import net.devk.authorization.model.User;

public interface UserService {

	Optional<User> findByUsername(String username);

	Set<String> findRoles(String username);

}
