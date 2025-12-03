package ru.practice.events;

public interface EventListener {
    void invoke(Event event);
    int priority();
    Object owner();
}
