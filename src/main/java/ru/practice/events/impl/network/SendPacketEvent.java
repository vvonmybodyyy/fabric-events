package ru.practice.events.impl.network;

import lombok.AllArgsConstructor;
import lombok.Getter;
import net.minecraft.network.packet.Packet;
import ru.practice.events.Event;

/**
 * Вызывается при отправке пакетов на сервер
 *
 * @see ru.practice.mixins.ClientConnectionMixin
 */
@Getter @AllArgsConstructor
public class SendPacketEvent extends Event {
    /**
     * Любой тип пакета от вас
     */
    private Packet<?> packet;
}
