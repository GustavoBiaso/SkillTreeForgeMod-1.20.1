package net.guinimos.skilltreemod.datagen;

import com.google.common.base.Function;

import net.guinimos.skilltreemod.SkillTreeMod;
import net.guinimos.skilltreemod.block.ModBlocks;
import net.guinimos.skilltreemod.block.custom.LettuceCropBlock;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockStateProvider extends BlockStateProvider {

    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, SkillTreeMod.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(ModBlocks.MITHRIL_BLOCK);
        blockWithItem(ModBlocks.MITHRIL_ORE);
        blockWithItem(ModBlocks.ADAMANTINA_BLOCK);
        blockWithItem(ModBlocks.ADAMANTINA_ORE);

        makeLettuceCrop((CropBlock) ModBlocks.LETTUCE_CROP.get(), "lettuce_stage", "lettuce_stage");
    }

    public void makeLettuceCrop(CropBlock block, String modelName, String textureName) {
        Function<BlockState, ConfiguredModel[]> function = state -> lettuceStates(state, block, modelName, textureName);

        getVariantBuilder(block).forAllStates(function);
    }

    private ConfiguredModel[] lettuceStates(BlockState state, CropBlock block, String modelName, String textureName) {
        ConfiguredModel[] models = new ConfiguredModel[1];
        models[0] = new ConfiguredModel(models().crop(modelName + state.getValue(((LettuceCropBlock) block).getAgeProperty()),
                new ResourceLocation(SkillTreeMod.MOD_ID, "block/" + textureName + state.getValue(((LettuceCropBlock) block).getAgeProperty()))).renderType("cutout"));

        return models;
    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }
}

