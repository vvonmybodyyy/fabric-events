package ru.practice;

import ru.practice.events.EventHandler;
import ru.practice.events.impl.TickEvent;

public class Test {

    @EventHandler
    public void onTick(TickEvent event) {
        System.out.println("Tick Event");
    }
}
