package io.github.ManaStar.poscendo.core;

import net.minecraftforge.common.ForgeConfigSpec;

public class PoscendoConfig {
    public static final ForgeConfigSpec.ConfigValue<Boolean> REFINED_POTION_NAMES;
    public static final ForgeConfigSpec.ConfigValue<Boolean> REFINED_POTION_BOTTLES;

    public static final ForgeConfigSpec CONFIG;

    static {
        ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();

        BUILDER.comment("Potions").push("potions");
        REFINED_POTION_NAMES = BUILDER.comment("If potions refined using redstone or glowstone should be prefixed with either Lengthy or Potent respectively. (Default = true)").define("Refined Potion Names", true);
        REFINED_POTION_BOTTLES = BUILDER.comment("If potions refined using redstone or glowstone should have unique bottle textures to set them apart. (Default = true)").define("Refined Potion Bottles", true);
        BUILDER.pop();

        CONFIG = BUILDER.build();
    }
}
