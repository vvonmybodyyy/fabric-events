package ru.practice.mixins;

import net.minecraft.component.DataComponentTypes;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import ru.practice.FabricEvents;
import ru.practice.IMinecraft;
import ru.practice.events.impl.game.BreakTotemEvent;

@Mixin(LivingEntity.class)
public abstract class LivingEntityMixin implements IMinecraft {

    @Inject(method = "tryUseDeathProtector", at = @At(value = "INVOKE", target = "Lnet/minecraft/item/ItemStack;decrement(I)V"))
    private void onTotemUse(DamageSource source, CallbackInfoReturnable<Boolean> cir) {
        LivingEntity entity = (LivingEntity) (Object) this;
        if (!(entity instanceof PlayerEntity player) || player == mc.player) return;

        for (Hand hand : Hand.values()) {
            ItemStack stack = entity.getStackInHand(hand);

            FabricEvents.getInstance().getEventManager().post(new BreakTotemEvent(entity, stack));

            if (stack.contains(DataComponentTypes.DEATH_PROTECTION)) {
                return;
            }
        }
    }
}
