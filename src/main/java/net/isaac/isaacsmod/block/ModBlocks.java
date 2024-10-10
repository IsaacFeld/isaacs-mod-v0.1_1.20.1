package net.isaac.isaacsmod.block;

import net.fabricmc.fabric.api.block.v1.FabricBlock;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.isaac.isaacsmod.IsaacsMod;
import net.isaac.isaacsmod.block.custom.SoundBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.ExperienceDroppingBlock;
import net.minecraft.client.sound.Sound;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;

public class ModBlocks {

    public static final Block MITHRIL_BLOCK = registerBlock("mithril_block", new Block(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK))); /// THE NAME HERE MUST MATCH THE JSON BLOCKSTATES FILE'S NAME (THIS IS THE ID OF THE BLOCK)
    public static final Block ADAMANT_BLOCK = registerBlock("adamant_block", new Block(FabricBlockSettings.copyOf(Blocks.DIAMOND_BLOCK)));
    public static final Block MITHRIL_ORE = registerBlock("mithril_ore", new ExperienceDroppingBlock(FabricBlockSettings.copyOf(Blocks.STONE).strength(2f), UniformIntProvider.create(2,5)));
    public static final Block ADAMANT_ORE = registerBlock("adamant_ore", new ExperienceDroppingBlock(FabricBlockSettings.copyOf(Blocks.STONE).strength(3.5f), UniformIntProvider.create(4, 10)));
    public static final Block SOUND_BLOCK = registerBlock("sound_block", new SoundBlock(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK)));
    /// /// You can copy other block settings and override certain settings by just typing .sounds or .strength() after
    private static Block registerBlock(String name, Block block){
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(IsaacsMod.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block){
        return Registry.register(Registries.ITEM, new Identifier(IsaacsMod.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings()));
    }
    public static void registerModBlocks(){
        IsaacsMod.LOGGER.info("Registering Mod Blocks for " + IsaacsMod.MOD_ID);
    }
}
