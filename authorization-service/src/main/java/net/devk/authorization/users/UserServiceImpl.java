package net.devk.authorization.users;

import java.util.Optional;
import java.util.Set;

import org.springframework.stereotype.Service;

import net.devk.authorization.model.User;

@Service
class UserServiceImpl implements UserService {

	private final UserRepository userRepository;

	public UserServiceImpl(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}

	@Override
	public Optional<User> findByUsername(String username) {
		return userRepository.findByUsername(username);
	}

	@Override
	public Set<String> findRoles(String username) {
		return userRepository.findRoles(username);
	}

}
