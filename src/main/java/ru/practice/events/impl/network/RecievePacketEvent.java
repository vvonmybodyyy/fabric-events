package ru.practice.events.impl.network;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import net.minecraft.network.packet.Packet;
import ru.practice.events.Event;

@Getter
@RequiredArgsConstructor
public class RecievePacketEvent extends Event {
    private final Packet<?> packet;
}
