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
        // System.out.println("Tick Event");
    }

    @EventHandler
    public void onBreakBlock(BlockBreakEvent event) {
        System.out.println(event.getBlock() + " breaked on " + event.getBlockPos());
    }

    @EventHandler
    public void onKeyPress(KeyPressEvent event) {
        System.out.println(GLFW.glfwGetKeyName(event.getKey(), 0) + " action: " + event.getAction());
    }

    @EventHandler
    public void onSendPacket(SendPacketEvent event) {
        if (event.getPacket() instanceof ChatMessageC2SPacket packet)
            System.out.println("sended message: " + packet.chatMessage());
    }

    @EventHandler
    public void onReceivePacket(ReceivePacketEvent event) {
        if (event.getPacket() instanceof GameMessageS2CPacket packet)
            System.out.println("recieved message: " + packet.content());
    }

    @EventHandler
    public void onAttackEvent(AttackEvent event) {
        System.out.println(event.getEntity());
    }

    @EventHandler
    public void onBreakTotem(BreakTotemEvent event) {
        System.out.println(event.getEntity().getName().getString());
    }
}
