package io.pivotal;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.bus.Event;
import reactor.bus.EventBus;

import java.util.UUID;

@Service
@Slf4j
public class Publisher {
    @Autowired
    EventBus eventBus;

    public void publishData() throws InterruptedException {
        DataToPass dataToPass = new DataToPass();
        UUID uuid = UUID.randomUUID();
        dataToPass.setDataId(uuid.toString());
        dataToPass.setDataValue(RandomStringUtils.randomAlphabetic(12));
        eventBus.notify("dataMessage", Event.wrap(dataToPass));
        log.info("Sent Message {}", dataToPass);
    }
}
