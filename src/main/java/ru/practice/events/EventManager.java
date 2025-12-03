package ru.practice.events;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class EventManager {

    private final Map<Class<?>, List<EventListener>> listeners = new ConcurrentHashMap<>();

    public void subscribe(Object object) {
        for (Method method : object.getClass().getDeclaredMethods()) {
            if (method.isAnnotationPresent(EventHandler.class)) {

                Class<?>[] params = method.getParameterTypes();

                if (params.length == 1 && Event.class.isAssignableFrom(params[0])) {
                    EventHandler handler = method.getAnnotation(EventHandler.class);

                    Class<?> eventType = params[0];

                    EventListenerImpl listener = new EventListenerImpl(object, method, handler.priority());

                    listeners.computeIfAbsent(eventType, k -> new ArrayList<>()).add(listener);

                    listeners.get(eventType).sort(Comparator.comparingInt(EventListener::priority).reversed());
                }
            }
        }
    }

    public void unsubscribe(Object object) {
        listeners.values().forEach(list ->
                list.removeIf(listener -> listener.owner() == object)
        );
    }

    public <T extends Event> T post(T event) {
        List<EventListener> eventListeners = listeners.get(event.getClass());
        if (eventListeners != null) {
            for (EventListener listener : eventListeners) {
                if (event.isCancelled()) break;

                listener.invoke(event);
            }
        }
        return event;
    }
}
