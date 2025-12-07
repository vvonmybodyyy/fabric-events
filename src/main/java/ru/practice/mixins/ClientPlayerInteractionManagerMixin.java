package ru.practice.mixins;

import net.minecraft.client.network.ClientPlayerInteractionManager;
import net.minecraft.util.math.BlockPos;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import ru.practice.FabricEvents;
import ru.practice.IMinecraft;
import ru.practice.events.impl.game.BlockBreakEvent;

@Mixin(ClientPlayerInteractionManager.class)
public class ClientPlayerInteractionManagerMixin implements IMinecraft {

    @Inject(method = "breakBlock", at = @At("HEAD"))
    public void breakBlockHook(BlockPos pos, CallbackInfoReturnable<Boolean> cir) {
        BlockBreakEvent event = new BlockBreakEvent(pos, mc.world.getBlockState(pos).getBlock());

        FabricEvents.getInstance().getEventManager().post(event);
    }
}
