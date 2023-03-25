package io.github.ManaStar.poscendo.core.mixin;

import net.minecraft.world.effect.MobEffects;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

@Mixin(MobEffects.class)
public class MobEffectsMixin {

    @ModifyArg(method = "<clinit>", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/effect/MobEffect;<init>(Lnet/minecraft/world/effect/MobEffectCategory;I)V"), index = 1)
    private static int injected(int color) {
        switch (color) {
            case (8171462): {
                return 3402751;
            }
            case (5926017): {
                return 9154528;
            }
            case (2293580): {
                return 16646020;
            }
            case (14981690): {
                return 16750848;
            }
            case (3035801): {
                return 10017472;
            }
            case (8356754): {
                return 16185078;
            }
            case (2039713): {
                return 12779366;
            }
            case (5149489): {
                return 8889187;
            }
            case (3381504): {
                return 5882118;
            }
            case (16773073): {
                return 15978425;
            }
            case (3484199): {
                return 7561558;
            }
        }

        return color;
    }

    @ModifyArg(method = "<clinit>", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/effect/AttackDamageMobEffect;<init>(Lnet/minecraft/world/effect/MobEffectCategory;ID)V"), index = 1)
    private static int injected2(int color) {
        if (color == 9643043) {
            return 16762624;
        }

        return color;
    }

    @ModifyArg(method = "<clinit>", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/effect/InstantenousMobEffect;<init>(Lnet/minecraft/world/effect/MobEffectCategory;I)V"), index = 1)
    private static int injected3(int color) {
        if (color == 4393481) {
            return 11101546;
        }
        return color;
    }
}
