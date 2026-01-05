package ru.practice.mixins;

import net.minecraft.client.MinecraftClient;
import net.minecraft.network.ClientConnection;
import net.minecraft.network.listener.PacketListener;
import net.minecraft.network.packet.Packet;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import ru.practice.FabricEvents;
import ru.practice.IMinecraft;
import ru.practice.events.impl.network.ReceivePacketEvent;
import ru.practice.events.impl.network.SendPacketEvent;

@Mixin(ClientConnection.class)
public class ClientConnectionMixin implements IMinecraft {

    @Unique
    private static boolean fix;

    @Inject(method = "handlePacket", at = @At("HEAD"), cancellable = true)
    private static <T extends PacketListener> void triggerReceivePacketEvent(Packet<T> packet, PacketListener listener, CallbackInfo ci) {
        ReceivePacketEvent event = new ReceivePacketEvent(packet);

        FabricEvents.getInstance().getEventManager().post(event);

        if (event.isCancelled()) ci.cancel();
    }

    @Inject(method = "send(Lnet/minecraft/network/packet/Packet;)V", at = @At("HEAD"), cancellable = true)
    public void triggerSendPacket(Packet<?> packet, CallbackInfo ci) {
        if (mc.player == null) return;

        SendPacketEvent event = new SendPacketEvent(packet);

        if (fix) return;

        FabricEvents.getInstance().getEventManager().post(event);

        if (event.isCancelled()) ci.cancel();

        Packet<?> newPacket = event.getPacket();

        if (newPacket != packet) {
            ci.cancel();

            fix = true;

            mc.player.networkHandler.sendPacket(newPacket);

            fix = false;
        }
    }
}
