package io.github.ManaStar.poscendo.core.mixin;

import io.github.ManaStar.poscendo.core.PoscendoConfig;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.PotionItem;
import net.minecraft.world.item.alchemy.PotionUtils;
import net.minecraftforge.registries.ForgeRegistries;
import org.jetbrains.annotations.NotNull;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(PotionItem.class)
public abstract class PotionItemMixin extends Item {
    public PotionItemMixin(Properties properties) {
        super(properties);
    }

    @Inject(method = "isFoil", at = @At("HEAD"), cancellable = true)
    public void isFoil(ItemStack stack, CallbackInfoReturnable<Boolean> cir) {
        if (PoscendoConfig.REMOVE_POTION_GLINT.get()) {
            cir.setReturnValue(false);
        }
    }

    @Override
    @NotNull
    public Component getName(@NotNull ItemStack stack) {
        if (PoscendoConfig.REFINED_POTION_NAMES.get()) {
            String name = ForgeRegistries.POTIONS.getKey(PotionUtils.getPotion(stack)).getPath();

            if (name.startsWith("long_") || name.endsWith("_long")) {
                return Component.translatable("item.minecraft.potion.long", super.getName(stack));
            }
            else if (name.startsWith("strong_") || name.endsWith("_strong")) {
                return Component.translatable("item.minecraft.potion.strong", super.getName(stack));
            }
        }
        return super.getName(stack);
    }
}
