package net.guinimos.skilltreemod.datagen;

import java.util.concurrent.CompletableFuture;

import org.jetbrains.annotations.Nullable;

import net.guinimos.skilltreemod.SkillTreeMod;
import net.guinimos.skilltreemod.item.ModItems;
import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ModItemTagGenerator extends ItemTagsProvider {

    public ModItemTagGenerator(PackOutput pOutput, CompletableFuture<Provider> pLookupProvider,
            CompletableFuture<TagLookup<Block>> pBlockTags,
            @Nullable ExistingFileHelper existingFileHelper) {
        super(pOutput, pLookupProvider, pBlockTags, SkillTreeMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(Provider pProvider) {
        this.tag(ItemTags.TRIMMABLE_ARMOR)
                .add(ModItems.MITHRIL_HELMET.get(),
                        ModItems.MITHRIL_CHESTPLATE.get(),
                        ModItems.MITHRIL_LEGGINGS.get(),
                        ModItems.MITHRIL_BOOTS.get());
    }
}
