package ru.practice.events.impl.game;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import net.minecraft.entity.Entity;
import ru.practice.events.Event;

/**
 * Вызывается после того, как игрок ударил Entity
 *
 * @see ru.practice.mixins.PlayerEntityMixin
 */
@Getter @RequiredArgsConstructor
public class AttackEvent extends Event {
    /**
     * Entity которого ударили
     */
    private final Entity entity;
}
