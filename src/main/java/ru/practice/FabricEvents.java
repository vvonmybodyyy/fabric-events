package ru.practice;

import lombok.Getter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.practice.events.EventManager;

@Getter
public enum FabricEvents {

    INSTANCE;

    public static final Logger LOGGER = LoggerFactory.getLogger("fabric-events");

    private EventManager eventManager;

    public void onInit() {
        eventManager = new EventManager();
        eventManager.subscribe(new Test());
    }

    public static FabricEvents getInstance() {
        return INSTANCE;
    }
}
