package net.isaac.isaacsmod.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.isaac.isaacsmod.IsaacsMod;
import net.isaac.isaacsmod.block.ModBlocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {
    public static final ItemGroup MYTHICAL_ORES_GROUP = Registry.register(Registries.ITEM_GROUP,
            new Identifier(IsaacsMod.MOD_ID, "ruby"), FabricItemGroup.builder().displayName(Text.translatable("itemgroup.mythicalores")).icon(() ->
                    new ItemStack(ModItems.ADAMANT)).entries((displayContext, entries) -> {
                    entries.add(ModItems.RAW_ADAMANT);
                    entries.add(ModItems.ADAMANT);
                    entries.add(ModItems.RAW_MITHRIL);
                    entries.add(ModItems.MITHRIL);
                    entries.add(ModItems.TOMATO);
                    entries.add(ModItems.ORODRUIN_REMNANT);
                    entries.add(ModItems.METAL_DETECTOR);
                    entries.add(ModItems.MITHRIL_PICKAXE);
                    entries.add(ModItems.ADAMANT_PICKAXE);
                    entries.add(ModItems.ADAMANT_AXE);
                    entries.add(ModItems.ADAMANT_SWORD);
                    entries.add(ModItems.ADAMANT_SHOVEL);
                    entries.add(ModItems.MITHRIL_SHOVEL);
                    entries.add(ModItems.MITHRIL_AXE);
                    entries.add(ModItems.MITHRIL_SWORD);
                    entries.add(ModItems.SPECIAL_PICKAXE);
                    entries.add(ModItems.LESSER_MANA);

                    entries.add(ModBlocks.SOUND_BLOCK);
                    entries.add(ModBlocks.ADAMANT_ORE);
                    entries.add(ModBlocks.MITHRIL_ORE);
                    entries.add(ModBlocks.MITHRIL_BLOCK);
                    entries.add(ModBlocks.ADAMANT_BLOCK);
            }).build());

    public static void registerItemGroups(){
        IsaacsMod.LOGGER.info("Registering Item Groups for " + IsaacsMod.MOD_ID);
    }
}
