package ru.practice.events.impl.game;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import net.minecraft.entity.LivingEntity;
import ru.practice.events.Event;

/**
 * Вызывается при использовании тотема игроком (PlayerEntity)
 *
 * @see ru.practice.mixins.LivingEntityMixin
 */
@Getter @RequiredArgsConstructor
public class BreakTotemEvent extends Event {
    private final LivingEntity entity;
}
