package net.guinimos.skilltreemod.datagen.loot;

import java.util.Set;

import net.guinimos.skilltreemod.block.ModBlocks;
import net.guinimos.skilltreemod.item.ModItems;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockLootTables extends BlockLootSubProvider {

    public ModBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        this.dropSelf(ModBlocks.MITHRIL_BLOCK.get());
        this.add(ModBlocks.MITHRIL_ORE.get(), block -> createOreDrop(ModBlocks.MITHRIL_ORE.get(), ModItems.RAW_MITHRIL.get()));

        this.dropSelf(ModBlocks.ADAMANTINA_BLOCK.get());
        this.add(ModBlocks.ADAMANTINA_ORE.get(), block -> createOreDrop(ModBlocks.ADAMANTINA_ORE.get(), ModItems.RAW_ADAMANTINA.get()));
    }

    @Override
    protected Iterable<Block> getKnownBlocks(){
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
    
}
