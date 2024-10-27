package net.isaac.isaacsmod.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.isaac.isaacsmod.item.custom.MetalDetectorItem;
import net.isaac.isaacsmod.item.custom.SpecialPickaxe;
import net.minecraft.item.*;
import net.isaac.isaacsmod.IsaacsMod;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final Item ADAMANT = registerItem("adamant", new Item(new FabricItemSettings()));
    public static final Item MITHRIL = registerItem("mithril", new Item(new FabricItemSettings()));
    public static final Item TOMATO = registerItem("tomato", new Item(new FabricItemSettings().food(ModFoodComponents.TOMATO)));
    public static final Item ORODRUIN_REMNANT= registerItem("orodruin_remnant", new Item(new FabricItemSettings()));
    public static final Item RAW_ADAMANT = registerItem("raw_adamant", new Item(new FabricItemSettings()));
    public static final Item RAW_MITHRIL = registerItem("raw_mithril", new Item(new FabricItemSettings()));
    public static final Item METAL_DETECTOR = registerItem("metal_detector", new MetalDetectorItem(new FabricItemSettings().maxDamage(64)));
    public static final Item SPECIAL_PICKAXE = registerItem("special_pickaxe", new SpecialPickaxe(SpecialPickaxe.material, SpecialPickaxe.attackDamage, SpecialPickaxe.attackSpeed, new FabricItemSettings()));
    public static final Item MITHRIL_PICKAXE = registerItem("mithril_pickaxe", new PickaxeItem(ModToolMaterial.MITHRIL, 3, -2.8f, new FabricItemSettings()));
    public static final Item MITHRIL_AXE = registerItem("mithril_axe", new AxeItem(ModToolMaterial.MITHRIL, 8, 1, new FabricItemSettings()));
    public static final Item MITHRIL_SHOVEL = registerItem("mithril_shovel", new ShovelItem(ModToolMaterial.MITHRIL, 3, -2.8f, new FabricItemSettings()));
    public static final Item MITHRIL_SWORD = registerItem("mithril_sword", new SwordItem(ModToolMaterial.MITHRIL, 9, -2.4f, new FabricItemSettings()));
    public static final Item ADAMANT_AXE = registerItem("adamant_axe", new AxeItem(ModToolMaterial.ADAMANT, 10, 1, new FabricItemSettings()));
    public static final Item ADAMANT_SHOVEL = registerItem("adamant_shovel", new ShovelItem(ModToolMaterial.ADAMANT, 5, -2.8f, new FabricItemSettings()));
    public static final Item ADAMANT_SWORD = registerItem("adamant_sword", new SwordItem(ModToolMaterial.ADAMANT, 14, -2.4f, new FabricItemSettings()));
    public static final Item ADAMANT_PICKAXE = registerItem("adamant_pickaxe", new PickaxeItem(ModToolMaterial.ADAMANT, 5, -2.8f, new FabricItemSettings()));
    public static final Item LESSER_MANA = registerItem("lesser_mana", new Item(new FabricItemSettings()));
    public static final Item GREATER_MANA = registerItem("greater_mana", new Item(new FabricItemSettings()));
    public static final Item LESSER_GREEN_MANA = registerItem("lesser_green_mana", new Item(new FabricItemSettings()));
    public static final Item GREATER_GREEN_MANA = registerItem("greater_green_mana", new Item(new FabricItemSettings()));
    public static final Item LESSER_PINK_MANA = registerItem("lesser_pink_mana", new Item(new FabricItemSettings()));
    public static final Item GREATER_PINK_MANA = registerItem("greater_pink_mana", new Item(new FabricItemSettings()));
    private static void addItemsToIngredientTabItemGroup(FabricItemGroupEntries entries){


    }

    private static Item registerItem(String name, Item item){
        return Registry.register(Registries.ITEM, new Identifier(IsaacsMod.MOD_ID, name), item);
    }
    public static void registerModItems(){
        IsaacsMod.LOGGER.info("Registering Mod Items for " + IsaacsMod.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::addItemsToIngredientTabItemGroup);
    }
}
