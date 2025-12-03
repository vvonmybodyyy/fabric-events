package ru.practice.events;

import lombok.Getter;

@Getter
public abstract class Event {
    private boolean cancelled;

    public void cancel() {
        cancelled = true;
    }
}
