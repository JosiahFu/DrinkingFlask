package archives.tater.drinkingflask.datagen;

import archives.tater.drinkingflask.DrinkingFlask;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;

public class ModelGenerator extends FabricModelProvider {

    public ModelGenerator(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {

    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(DrinkingFlask.DRINKING_FLASK, Models.GENERATED);
        itemModelGenerator.register(DrinkingFlask.PHANTOM_DRINKING_FLASK, Models.GENERATED);
    }
}
