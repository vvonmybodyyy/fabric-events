package ru.practice.mixins;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.player.PlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import ru.practice.FabricEvents;
import ru.practice.IMinecraft;
import ru.practice.events.impl.game.BreakTotemEvent;

@Mixin(LivingEntity.class)
public abstract class LivingEntityMixin implements IMinecraft {

    @Inject(method = "tryUseDeathProtector", at = @At("HEAD"))
    private void onTotemUse(DamageSource source, CallbackInfoReturnable<Boolean> cir) {
        LivingEntity entity = (LivingEntity) (Object) this;

        if (entity instanceof PlayerEntity playerEntity && playerEntity != mc.player) {
            FabricEvents.getInstance().getEventManager().post(new BreakTotemEvent(entity));
        }
    }
}
