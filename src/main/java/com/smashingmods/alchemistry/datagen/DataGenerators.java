package com.smashingmods.alchemistry.datagen;

import net.minecraft.data.DataGenerator;
import net.minecraftforge.forge.event.lifecycle.GatherDataEvent;

public class DataGenerators {

    public static void gatherData(GatherDataEvent pEvent) {
        DataGenerator generator = pEvent.getGenerator();

        if (pEvent.includeServer()) {
            generator.addProvider(new RecipeProvider(generator));
            generator.addProvider(new BlockStateGenerator(generator, pEvent.getExistingFileHelper()));
            generator.addProvider(new LootTableProvider(generator));
            generator.addProvider(new BlockTagProvider(generator, pEvent.getExistingFileHelper()));
            generator.addProvider(new LocalizationGenerator(generator, "en_us"));
        }
    }
}

