package net.guinimos.skilltreemod.block;

import com.google.common.base.Supplier;

import net.guinimos.skilltreemod.SkillTreeMod;
import net.guinimos.skilltreemod.block.custom.LettuceCropBlock;
import net.guinimos.skilltreemod.item.ModItems;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FlowerBlock;
import net.minecraft.world.level.block.FlowerPotBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, SkillTreeMod.MOD_ID);

    public static final RegistryObject<Block> MITHRIL_BLOCK = registerBlock("mithril_block",  
    () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));
    public static final RegistryObject<Block> MITHRIL_ORE = registerBlock("mithril_ore",  
    () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_ORE)));

    public static final RegistryObject<Block> ADAMANTINA_BLOCK = registerBlock("adamantina_block",  
    () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));
    public static final RegistryObject<Block> ADAMANTINA_ORE = registerBlock("adamantina_ore",  
    () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_ORE)));

    public static final RegistryObject<Block> LETTUCE_CROP = BLOCKS.register("lettuce_crop",  
    () -> new LettuceCropBlock(BlockBehaviour.Properties.copy(Blocks.CARROTS).noCollission().noOcclusion()));

    public static final RegistryObject<Block> SWIFTTHISTLE = registerBlock("swiftthistle",  
    () -> new FlowerBlock(() -> MobEffects.DAMAGE_BOOST, 15, BlockBehaviour.Properties.copy(Blocks.DANDELION).noCollission().noOcclusion()));
    public static final RegistryObject<Block> POTTED_SWIFTTHISTLE = BLOCKS.register("potted_swiftthistle",  
    () -> new FlowerPotBlock(() -> ((FlowerPotBlock) Blocks.FLOWER_POT), ModBlocks.SWIFTTHISTLE, BlockBehaviour.Properties.copy(Blocks.POTTED_DANDELION).noOcclusion()));

    //public static final RegistryObject<Block> EXP_ORE = registerBlock("EXP_ORE",  
    //() -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.STONE).strengh(2f).requiresCorrectToolForDrops(), UniformInt.of(1, 4)));

    public static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block){
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    public static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block){
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus){
        BLOCKS.register(eventBus);
    }
}
