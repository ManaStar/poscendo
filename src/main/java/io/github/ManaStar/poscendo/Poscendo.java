package io.github.ManaStar.poscendo;

import com.mojang.logging.LogUtils;
import io.github.ManaStar.poscendo.core.PoscendoConfig;
import io.github.ManaStar.poscendo.core.data.client.PoscendoItemModelProvider;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraft.world.item.alchemy.PotionUtils;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.ForgeRegistries;
import org.slf4j.Logger;

@Mod(Poscendo.MODID)
public class Poscendo {
    public static final String MODID = "poscendo";
    public static final Logger LOGGER = LogUtils.getLogger();

    public Poscendo() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();

        ModLoadingContext.get().registerConfig(ModConfig.Type.CLIENT, PoscendoConfig.CONFIG);

        bus.addListener(this::clientSetup);
        bus.addListener(this::gatherDataEvent);

        MinecraftForge.EVENT_BUS.register(this);
    }

    @SubscribeEvent
    public void clientSetup(final FMLClientSetupEvent event) {
        ItemProperties.register(Items.POTION, new ResourceLocation(MODID, "potion"), (stack, level, entity, i) -> {
            Potion potion = PotionUtils.getPotion(stack);

            if (PoscendoConfig.REFINED_POTION_BOTTLES.get()) {
                if (ForgeRegistries.POTIONS.getKey(potion).getPath().toString().startsWith("long") || ForgeRegistries.POTIONS.getKey(potion).getPath().toString().endsWith("long")) {
                    return 0.5F;
                } else if (ForgeRegistries.POTIONS.getKey(potion).getPath().toString().startsWith("strong") || ForgeRegistries.POTIONS.getKey(potion).getPath().toString().endsWith("strong")) {
                    return 1.0F;
                }
            }
            return 0.0F;
        });

        ItemProperties.register(Items.SPLASH_POTION, new ResourceLocation(MODID, "potion"), (stack, level, entity, i) -> {
            Potion potion = PotionUtils.getPotion(stack);

            if (PoscendoConfig.REFINED_POTION_BOTTLES.get()) {
                if (ForgeRegistries.POTIONS.getKey(potion).getPath().toString().startsWith("long") || ForgeRegistries.POTIONS.getKey(potion).getPath().toString().endsWith("long")) {
                    return 0.5F;
                } else if (ForgeRegistries.POTIONS.getKey(potion).getPath().toString().startsWith("strong") || ForgeRegistries.POTIONS.getKey(potion).getPath().toString().endsWith("strong")) {
                    return 1.0F;
                }
            }
            return 0.0F;
        });

        ItemProperties.register(Items.LINGERING_POTION, new ResourceLocation(MODID, "potion"), (stack, level, entity, i) -> {
            Potion potion = PotionUtils.getPotion(stack);

            if (PoscendoConfig.REFINED_POTION_BOTTLES.get()) {
                if (ForgeRegistries.POTIONS.getKey(potion).getPath().toString().startsWith("long") || ForgeRegistries.POTIONS.getKey(potion).getPath().toString().endsWith("long")) {
                    return 0.5F;
                } else if (ForgeRegistries.POTIONS.getKey(potion).getPath().toString().startsWith("strong") || ForgeRegistries.POTIONS.getKey(potion).getPath().toString().endsWith("strong")) {
                    return 1.0F;
                }
            }
            return 0.0F;
        });
    }

    @SubscribeEvent
    public void gatherDataEvent(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        ExistingFileHelper fileHelper = event.getExistingFileHelper();

        generator.addProvider(event.includeClient(), new PoscendoItemModelProvider(generator, fileHelper));
    }
}
