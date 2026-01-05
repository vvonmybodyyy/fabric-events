package ru.practice;

import net.minecraft.network.packet.c2s.play.ChatMessageC2SPacket;
import net.minecraft.network.packet.s2c.play.GameMessageS2CPacket;
import org.lwjgl.glfw.GLFW;
import ru.practice.events.EventHandler;
import ru.practice.events.impl.game.AttackEvent;
import ru.practice.events.impl.game.BlockBreakEvent;
import ru.practice.events.impl.KeyPressEvent;
import ru.practice.events.impl.TickEvent;
import ru.practice.events.impl.game.BreakTotemEvent;
import ru.practice.events.impl.network.ReceivePacketEvent;
import ru.practice.events.impl.network.SendPacketEvent;

public class Test {

    @EventHandler
    public void onTick(TickEvent event) {

    }

    @EventHandler
    public void onKeyPress(KeyPressEvent event) {
        FabricEvents.LOGGER.info("key: {} action: {}", GLFW.glfwGetKeyName(event.getKey(), 0), event.getAction());
    }

    @EventHandler
    public void onSendPacket(SendPacketEvent event) {
        if (event.getPacket() instanceof ChatMessageC2SPacket packet)
            FabricEvents.LOGGER.info("sended message: {}", packet.chatMessage());
    }

    @EventHandler
    public void onReceivePacket(ReceivePacketEvent event) {
        if (event.getPacket() instanceof GameMessageS2CPacket packet)
            FabricEvents.LOGGER.info("recieved message: {}", packet.content());
    }

    @EventHandler
    public void onAttackEvent(AttackEvent event) {
        FabricEvents.LOGGER.info("Attacked: {}", event.getEntity());
    }

    @EventHandler
    public void onBreakBlock(BlockBreakEvent event) {
        FabricEvents.LOGGER.info("{} breaked on {}", event.getBlock(), event.getBlockPos());
    }

    @EventHandler
    public void onBreakTotem(BreakTotemEvent event) {
        FabricEvents.LOGGER.info("entity: {} stack name: {}", event.getEntity().getName().getString(), event.getStack().getName().getString());
    }
}
