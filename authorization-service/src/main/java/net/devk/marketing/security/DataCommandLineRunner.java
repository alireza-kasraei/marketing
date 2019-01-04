package net.devk.marketing.security;

import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import net.devk.marketing.security.accounts.Account;
import net.devk.marketing.security.accounts.AccountRepository;
import net.devk.marketing.security.clients.Client;
import net.devk.marketing.security.clients.ClientRepository;

@Component
class DataCommandLineRunner implements CommandLineRunner {

	private final AccountRepository accountRepository;

	private final ClientRepository clientRepository;

	@Autowired
	public DataCommandLineRunner(AccountRepository accountRepository, ClientRepository clientRepository) {
		this.accountRepository = accountRepository;
		this.clientRepository = clientRepository;
	}

	@Override
	public void run(String... args) throws Exception {

		Stream.of("dsyer,cloud", "pwebb,boot", "mminella,batch", "rwinch,security", "jlong,spring")
				.map(s -> s.split(",")).forEach(tuple -> accountRepository.save(new Account(tuple[0], tuple[1], true)));

		Stream.of("html5,password", "android,secret").map(x -> x.split(","))
				.forEach(x -> clientRepository.save(new Client(x[0], x[1])));
	}
}
