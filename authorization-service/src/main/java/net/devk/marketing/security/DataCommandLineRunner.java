package net.devk.marketing.security;

import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

import net.devk.marketing.security.clients.Client;
import net.devk.marketing.security.clients.ClientRepository;
import net.devk.marketing.security.users.User;
import net.devk.marketing.security.users.UserRepository;

//@Component
class DataCommandLineRunner implements CommandLineRunner {

	private final UserRepository userRepository;

	private final ClientRepository clientRepository;

	@Autowired
	public DataCommandLineRunner(UserRepository userRepository, ClientRepository clientRepository) {
		this.userRepository = userRepository;
		this.clientRepository = clientRepository;
	}

	@Override
	public void run(String... args) throws Exception {

		Stream.of("dsyer,cloud", "pwebb,boot", "mminella,batch", "rwinch,security", "jlong,spring")
				.map(s -> s.split(",")).forEach(tuple -> userRepository.save(new User(tuple[0], tuple[1], true)));

		Stream.of("html5,password", "android,secret").map(x -> x.split(","))
				.forEach(x -> clientRepository.save(new Client(x[0], x[1])));
	}
}
