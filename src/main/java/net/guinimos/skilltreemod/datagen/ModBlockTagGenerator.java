package net.guinimos.skilltreemod.datagen;

import java.util.concurrent.CompletableFuture;

import org.jetbrains.annotations.Nullable;

import net.guinimos.skilltreemod.SkillTreeMod;
import net.guinimos.skilltreemod.block.ModBlocks;
import net.guinimos.skilltreemod.util.ModTags;
import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ModBlockTagGenerator extends BlockTagsProvider {

    public ModBlockTagGenerator(PackOutput output, CompletableFuture<Provider> lookupProvider,
            @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, SkillTreeMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(Provider pProvider) {
        //this.tag(ModTags.Blocks.NOME_DA_TAG).add(ModBlocks.NOME_BLOCO.get()).addTag(Tags.Blocks.TAG_MINE);

        this.tag(BlockTags.MINEABLE_WITH_PICKAXE).add(ModBlocks.MITHRIL_ORE.get(), ModBlocks.MITHRIL_BLOCK.get());
        this.tag(BlockTags.NEEDS_IRON_TOOL).add(ModBlocks.MITHRIL_ORE.get(), ModBlocks.MITHRIL_BLOCK.get());
        
        this.tag(BlockTags.MINEABLE_WITH_PICKAXE).add(ModBlocks.ADAMANTINA_ORE.get(), ModBlocks.ADAMANTINA_BLOCK.get());
        this.tag(BlockTags.NEEDS_IRON_TOOL).add(ModBlocks.ADAMANTINA_ORE.get(), ModBlocks.ADAMANTINA_BLOCK.get());
    }
    
}
