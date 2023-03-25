package io.github.ManaStar.poscendo.core.mixin;

import com.simibubi.create.AllFluids;
import com.simibubi.create.content.contraptions.fluids.potion.PotionFluid;
import com.simibubi.create.content.contraptions.fluids.potion.PotionFluidHandler;
import com.simibubi.create.foundation.utility.NBTHelper;
import io.github.ManaStar.poscendo.core.PoscendoConfig;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.alchemy.PotionUtils;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.registries.ForgeRegistries;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Pseudo;

@Pseudo
@Mixin(PotionFluid.PotionFluidType.class)
public abstract class CreatePotionFluidTypeMixin extends AllFluids.TintedFluidType {

    public CreatePotionFluidTypeMixin(Properties properties, ResourceLocation stillTexture, ResourceLocation flowingTexture) {
        super(properties, stillTexture, flowingTexture);
    }

    @Override
    public Component getDescription(FluidStack stack) {
        if (PoscendoConfig.REFINED_POTION_NAMES.get()) {
            CompoundTag tag = stack.getOrCreateTag();
            String name = ForgeRegistries.POTIONS.getKey(PotionUtils.getPotion(tag)).getPath();
            ItemLike itemFromBottleType = PotionFluidHandler.itemFromBottleType((PotionFluid.BottleType) NBTHelper.readEnum(tag, "Bottle", PotionFluid.BottleType.class));

            if (name.startsWith("long_") || name.endsWith("_long") || name.startsWith("strong_") || name.endsWith("_strong")) {
                return itemFromBottleType.asItem().getName(PotionFluidHandler.fillBottle(new ItemStack(itemFromBottleType), stack));
            }
        }
        return super.getDescription(stack);
    }
}
