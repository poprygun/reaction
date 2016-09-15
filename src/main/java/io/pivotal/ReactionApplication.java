package io.pivotal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import reactor.bus.EventBus;

import static reactor.bus.selector.Selectors.$;

@SpringBootApplication
public class ReactionApplication implements CommandLineRunner {

	@Autowired
	private EventBus eventBus;
	@Autowired
	private Receiver receiver;
	@Autowired
	private Publisher publisher;

	public static void main(String[] args) {
		SpringApplication.run(ReactionApplication.class, args);
	}

	public void run(String... args) throws Exception {
		eventBus.on($("dataMessage"), receiver);
		publisher.publishData();
	}
}
