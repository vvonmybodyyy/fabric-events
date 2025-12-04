package ru.practice.events;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public record EventListenerImpl(Object owner, Method method, int priority) implements EventListener {

    public EventListenerImpl(Object owner, Method method, int priority) {
        this.owner = owner;
        this.method = method;
        this.priority = priority;
        this.method.setAccessible(true);
    }

    @Override
    public void invoke(Event event) {
        try {
            method.invoke(owner, event);
        } catch (Exception ignore) {}
    }
}
