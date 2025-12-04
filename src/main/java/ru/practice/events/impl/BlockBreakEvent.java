package ru.practice.events.impl;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import net.minecraft.block.Block;
import net.minecraft.util.math.BlockPos;
import ru.practice.events.Event;

@Getter
@RequiredArgsConstructor
public class BlockBreakEvent extends Event {
    private final BlockPos blockPos;
    private final Block block;
}
