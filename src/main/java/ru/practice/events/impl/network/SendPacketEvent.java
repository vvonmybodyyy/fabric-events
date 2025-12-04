package ru.practice.events.impl.network;

import lombok.AllArgsConstructor;
import lombok.Getter;
import net.minecraft.network.packet.Packet;
import ru.practice.events.Event;

@Getter
@AllArgsConstructor
public class SendPacketEvent extends Event {
    private Packet<?> packet;
}
