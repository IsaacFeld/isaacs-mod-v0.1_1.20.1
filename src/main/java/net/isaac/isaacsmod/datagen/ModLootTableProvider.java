package net.isaac.isaacsmod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.isaac.isaacsmod.block.ModBlocks;
import net.isaac.isaacsmod.item.ModItems;
import net.minecraft.block.Block;
import net.minecraft.data.server.loottable.BlockLootTableGenerator;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.Item;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.entry.LeafEntry;
import net.minecraft.loot.entry.LootPoolEntry;
import net.minecraft.loot.function.ApplyBonusLootFunction;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;

public class ModLootTableProvider extends FabricBlockLootTableProvider {
    public ModLootTableProvider(FabricDataOutput dataOutput) {
        super(dataOutput);
    }
/// Look through "BlockLootTableGenerator" class for more information on LootTable generators.
    @Override
    public void generate() {
        addDrop(ModBlocks.ADAMANT_BLOCK);
        addDrop(ModBlocks.MITHRIL_BLOCK);
        addDrop(ModBlocks.SOUND_BLOCK);

        addDrop(ModBlocks.MITHRIL_ORE, modOreDrops(ModBlocks.MITHRIL_ORE, ModItems.RAW_MITHRIL, 1, 2));
        addDrop(ModBlocks.ADAMANT_ORE, modOreDrops(ModBlocks.ADAMANT_ORE, ModItems.RAW_ADAMANT, 1, 1));
    }
    public LootTable.Builder modOreDrops(Block drop, Item item, float a, float b){
        return BlockLootTableGenerator.dropsWithSilkTouch(drop, (LootPoolEntry.Builder)this.applyExplosionDecay(drop,((LeafEntry.Builder)
                ItemEntry.builder(item).apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(a, b)))).apply(ApplyBonusLootFunction.oreDrops(Enchantments.FORTUNE))));
    }
}
