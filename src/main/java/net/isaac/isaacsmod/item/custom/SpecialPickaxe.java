package net.isaac.isaacsmod.item.custom;

import net.isaac.isaacsmod.item.ModToolMaterial;
import net.minecraft.block.AirBlock;
import net.minecraft.block.BlockState;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.text.Text;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class SpecialPickaxe extends PickaxeItem {
    public SpecialPickaxe(ToolMaterial material, int attackDamage, float attackSpeed, Settings settings) {
        super(material, attackDamage, attackSpeed, settings);
    }
    public static final ToolMaterial material = ModToolMaterial.ADAMANT;
    public static int attackDamage =  3;
    public static float attackSpeed = -2.8f;


    @Override
    public boolean postMine(ItemStack stack, World world, BlockState state, BlockPos pos, LivingEntity miner) {
            final int x = pos.getX();
            int y = pos.getY();
            int z = pos.getZ();
            for(int i = 1; i <= 3; i ++) {
                for(int j = 1; j <= 3; j++){
                    world.removeBlock(new BlockPos(x, (y - 2) + i, (z - 2) + j), false);
                }


            }
        if (!world.isClient && state.getHardness(world, pos) != 0.0F) {
            stack.damage(1, miner, e -> e.sendEquipmentBreakStatus(EquipmentSlot.MAINHAND));
        }

        return true;
    }
}
