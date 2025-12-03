package ru.practice;

import lombok.Getter;
import ru.practice.events.EventManager;

@Getter
public enum FabricEvents {

    INSTANCE;

    private EventManager eventManager;

    public void onInit() {
        eventManager = new EventManager();
        eventManager.subscribe(new Test());
    }

    public static FabricEvents getInstance() {
        return INSTANCE;
    }
}
