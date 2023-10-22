package net.guinimos.skilltreemod.item;

import net.guinimos.skilltreemod.SkillTreeMod;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, SkillTreeMod.MOD_ID);

    public static final RegistryObject<Item> MITHRIL_INGOT = ITEMS.register("mithril_ingot", () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> RAW_MITHRIL = ITEMS.register("raw_mithril", () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> CORN = ITEMS.register("corn", () -> new Item(new Item.Properties().food(ModFoods.CORN)));

    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
