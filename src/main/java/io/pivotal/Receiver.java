package io.pivotal;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.bus.Event;
import reactor.fn.Consumer;


@Service
@Slf4j
public class Receiver implements Consumer<Event<DataToPass>>  {

    public void accept(Event<DataToPass> ev) {
        log.info("Received message {}", ev);
    }
}
