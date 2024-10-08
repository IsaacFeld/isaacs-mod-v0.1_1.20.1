package net.isaac.isaacsmod.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.isaac.isaacsmod.IsaacsMod;
import net.isaac.isaacsmod.block.ModBlocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {
    public static final ItemGroup MYTHICAL_ORES_GROUP = Registry.register(Registries.ITEM_GROUP,
            new Identifier(IsaacsMod.MOD_ID, "ruby"), FabricItemGroup.builder().displayName(Text.translatable("itemgroup.mythicalores")).icon(() ->
                    new ItemStack(ModItems.ADAMANT)).entries((displayContext, entries) -> {
                    entries.add(ModItems.ADAMANT);
                    entries.add(ModItems.MITHRIL);
                    entries.add(Items.IRON_INGOT);

                    entries.add(ModBlocks.MITHRIL_BLOCK);
                    entries.add(ModBlocks.ADAMANT_BLOCK);
            }).build());

    public static void registerItemGroups(){
        IsaacsMod.LOGGER.info("Registering Item Groups for " + IsaacsMod.MOD_ID);
    }
}
