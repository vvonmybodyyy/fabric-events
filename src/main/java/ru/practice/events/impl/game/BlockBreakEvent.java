package ru.practice.events.impl.game;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import net.minecraft.block.Block;
import net.minecraft.util.math.BlockPos;
import ru.practice.events.Event;

/**
 * Вызывается после того, как игрок сломал блок
 *
 * @see ru.practice.mixins.ClientPlayerInteractionManagerMixin
 */
@Getter @RequiredArgsConstructor
public class BlockBreakEvent extends Event {
    /**
     * Позиция сломанного блока
     */
    private final BlockPos blockPos;
    /**
     * Тип блока
     */
    private final Block block;
}
