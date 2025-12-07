package ru.practice.events.impl;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import ru.practice.events.Event;

/**
 * Вызывается при нажатии клавиши на клавиатуре
 *
 * @see ru.practice.mixins.KeyboardMixin
 */
@Getter @RequiredArgsConstructor
public class KeyPressEvent extends Event {
    /**
     * Тип действия: GLFW_PRESS, GLFW_RELEASE или GLFW_REPEAT
     */
    private final int action;

    /**
     * Нажатая клавиша
     */
    private final int key;
}
