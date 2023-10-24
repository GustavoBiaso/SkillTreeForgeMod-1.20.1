package net.guinimos.skilltreemod.item;

import java.util.List;

import net.guinimos.skilltreemod.SkillTreeMod;
import net.guinimos.skilltreemod.util.ModTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;
import net.minecraftforge.common.TierSortingRegistry;

public class ModToolTiers {
    public static final Tier MITHRIL = TierSortingRegistry.registerTier(
        //arrumar os danos da tag junto dos itens.
        new ForgeTier(2, 530, 0f, 0f, 16, ModTags.Blocks.NEEDS_MITHRIL_TOOL, () -> Ingredient.of(ModItems.MITHRIL_INGOT.get())),
        new ResourceLocation(SkillTreeMod.MOD_ID, "mithril"), List.of(Tiers.IRON), List.of(Tiers.DIAMOND));
}
