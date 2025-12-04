package ru.practice.events.impl;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import ru.practice.events.Event;

@Getter
@RequiredArgsConstructor
public class KeyPressEvent extends Event {
    private final int action, key;
}
