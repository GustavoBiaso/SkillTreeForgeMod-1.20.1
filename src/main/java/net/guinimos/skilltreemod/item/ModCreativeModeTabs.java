package net.guinimos.skilltreemod.item;

import net.guinimos.skilltreemod.SkillTreeMod;
import net.guinimos.skilltreemod.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, SkillTreeMod.MOD_ID);

    public static final RegistryObject<CreativeModeTab> SKILLTREE_TAB = CREATIVE_MODE_TABS.register("skilltree_tab",
     () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.MITHRIL_INGOT.get()))
     .title(Component.translatable("creativetab.skilltree_tab"))
     .displayItems((pParameters, pOutput) -> {
        pOutput.accept(ModItems.MITHRIL_INGOT.get());
        pOutput.accept(ModItems.RAW_MITHRIL.get());
        pOutput.accept(ModItems.ADAMANTINA_INGOT.get());
        pOutput.accept(ModItems.RAW_ADAMANTINA.get());
        pOutput.accept(ModItems.CORN.get());
        pOutput.accept(ModItems.LETTUCE.get());

        pOutput.accept(ModItems.MITHRIL_SWORD.get());
        pOutput.accept(ModItems.MITHRIL_PICKAXE.get());
        pOutput.accept(ModItems.MITHRIL_AXE.get());
        pOutput.accept(ModItems.MITHRIL_SHOVEL.get());
        pOutput.accept(ModItems.MITHRIL_HOE.get());

        pOutput.accept(ModItems.MITHRIL_HELMET.get());
        pOutput.accept(ModItems.MITHRIL_CHESTPLATE.get());
        pOutput.accept(ModItems.MITHRIL_LEGGINGS.get());
        pOutput.accept(ModItems.MITHRIL_BOOTS.get());

        pOutput.accept(ModBlocks.MITHRIL_BLOCK.get());
        pOutput.accept(ModBlocks.MITHRIL_ORE.get());
        pOutput.accept(ModBlocks.ADAMANTINA_BLOCK.get());
        pOutput.accept(ModBlocks.ADAMANTINA_ORE.get());
     })
     .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }

}
