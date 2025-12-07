package ru.practice.events.impl.network;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import net.minecraft.network.packet.Packet;
import ru.practice.events.Event;

/**
 * Вызывается при получении пакетов от сервера
 *
 * @see ru.practice.mixins.ClientConnectionMixin
 */
@Getter @RequiredArgsConstructor
public class ReceivePacketEvent extends Event {
    /**
     * Любой тип пакета от сервера
     */
    private final Packet<?> packet;
}
