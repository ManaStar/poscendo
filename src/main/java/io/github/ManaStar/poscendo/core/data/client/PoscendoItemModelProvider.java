package io.github.ManaStar.poscendo.core.data.client;

import io.github.ManaStar.poscendo.Poscendo;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.client.model.generators.ModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class PoscendoItemModelProvider extends ItemModelProvider {
    public PoscendoItemModelProvider(DataGenerator generator, ExistingFileHelper existingFileHelper) {
        super(generator, Poscendo.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        ItemModelBuilder potion = getBuilder("minecraft:item/potion")
                .parent(new ModelFile.UncheckedModelFile(ModelProvider.ITEM_FOLDER + "/generated"))
                .texture("layer0", mcLoc(ModelProvider.ITEM_FOLDER + "/potion_overlay"))
                .texture("layer1", mcLoc(ModelProvider.ITEM_FOLDER + "/potion"));

        potion.override()
                .predicate(modLoc("potion"), 0.5F)
                .model(getBuilder("poscendo:item/long_potion")
                        .parent(new ModelFile.UncheckedModelFile(ModelProvider.ITEM_FOLDER + "/generated"))
                        .texture("layer0", modLoc(ModelProvider.ITEM_FOLDER + "/long_potion_overlay"))
                        .texture("layer1", modLoc(ModelProvider.ITEM_FOLDER + "/long_potion")))
                .end();

        potion.override()
                .predicate(modLoc("potion"), 1.0F)
                .model(getBuilder("poscendo:item/strong_potion")
                        .parent(new ModelFile.UncheckedModelFile(ModelProvider.ITEM_FOLDER + "/generated"))
                        .texture("layer0", modLoc(ModelProvider.ITEM_FOLDER + "/strong_potion_overlay"))
                        .texture("layer1", modLoc(ModelProvider.ITEM_FOLDER + "/strong_potion")))
                .end();

        //Splash
        ItemModelBuilder splashPotion = getBuilder("minecraft:item/splash_potion")
                .parent(new ModelFile.UncheckedModelFile(ModelProvider.ITEM_FOLDER + "/generated"))
                .texture("layer0", mcLoc(ModelProvider.ITEM_FOLDER + "/potion_overlay"))
                .texture("layer1", mcLoc(ModelProvider.ITEM_FOLDER + "/splash_potion"));

        splashPotion.override()
                .predicate(modLoc("potion"), 0.5F)
                .model(getBuilder("poscendo:item/long_splash_potion")
                        .parent(new ModelFile.UncheckedModelFile(ModelProvider.ITEM_FOLDER + "/generated"))
                        .texture("layer0", modLoc(ModelProvider.ITEM_FOLDER + "/long_potion_overlay"))
                        .texture("layer1", modLoc(ModelProvider.ITEM_FOLDER + "/long_splash_potion")))
                .end();

        splashPotion.override()
                .predicate(modLoc("potion"), 1.0F)
                .model(getBuilder("poscendo:item/strong_splash_potion")
                        .parent(new ModelFile.UncheckedModelFile(ModelProvider.ITEM_FOLDER + "/generated"))
                        .texture("layer0", modLoc(ModelProvider.ITEM_FOLDER + "/strong_potion_overlay"))
                        .texture("layer1", modLoc(ModelProvider.ITEM_FOLDER + "/strong_splash_potion")))
                .end();

        //Lingering
        ItemModelBuilder lingeringPotion = getBuilder("minecraft:item/lingering_potion")
                .parent(new ModelFile.UncheckedModelFile(ModelProvider.ITEM_FOLDER + "/generated"))
                .texture("layer0", mcLoc(ModelProvider.ITEM_FOLDER + "/potion_overlay"))
                .texture("layer1", mcLoc(ModelProvider.ITEM_FOLDER + "/lingering_potion"));

        lingeringPotion.override()
                .predicate(modLoc("potion"), 0.5F)
                .model(getBuilder("poscendo:item/long_lingering_potion")
                        .parent(new ModelFile.UncheckedModelFile(ModelProvider.ITEM_FOLDER + "/generated"))
                        .texture("layer0", modLoc(ModelProvider.ITEM_FOLDER + "/long_potion_overlay"))
                        .texture("layer1", modLoc(ModelProvider.ITEM_FOLDER + "/long_lingering_potion")))
                .end();

        lingeringPotion.override()
                .predicate(modLoc("potion"), 1.0F)
                .model(getBuilder("poscendo:item/strong_lingering_potion")
                        .parent(new ModelFile.UncheckedModelFile(ModelProvider.ITEM_FOLDER + "/generated"))
                        .texture("layer0", modLoc(ModelProvider.ITEM_FOLDER + "/strong_potion_overlay"))
                        .texture("layer1", modLoc(ModelProvider.ITEM_FOLDER + "/strong_lingering_potion")))
                .end();
    }
}
