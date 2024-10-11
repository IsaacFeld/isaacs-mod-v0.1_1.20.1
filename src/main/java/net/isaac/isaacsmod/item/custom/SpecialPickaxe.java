package net.isaac.isaacsmod.item.custom;

import net.fabricmc.yarn.constants.MiningLevels;
import net.isaac.isaacsmod.IsaacsMod;
import net.isaac.isaacsmod.item.ModToolMaterial;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.item.ToolMaterials;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.text.Text;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.List;

public class SpecialPickaxe extends PickaxeItem {
    public SpecialPickaxe(ToolMaterial material, int attackDamage, float attackSpeed, Settings settings) {
        super(material, attackDamage, attackSpeed, settings);
    }
    public static final ToolMaterial material = ToolMaterials.STONE;
    public static int attackDamage =  3;
    public static float attackSpeed = -2.8f;




    @Override
    public boolean postMine(ItemStack stack, World world, BlockState state, BlockPos pos, LivingEntity miner) {
            final String string = "tully";
            int x = pos.getX();
            int y = pos.getY();
            int z = pos.getZ();
            List<BlockPos> Blocks = findBlocks(x, y, z);

            for(int i = 0; i < Blocks.size(); i++){
                BlockPos bp = Blocks.get(i);
                if(stack.isSuitableFor(world.getBlockState(bp))){
                    extraBreak(stack, world, bp, miner, world.getBlockState(bp));
                    world.breakBlock(bp, true);

                }



            }
        if (!world.isClient && state.getHardness(world, pos) != 0.0F) {
            stack.damage(1, miner, e -> e.sendEquipmentBreakStatus(EquipmentSlot.MAINHAND));
        }

        return true;
    }

    private void extraBreak(ItemStack i, World w, BlockPos p, LivingEntity m, BlockState s) {

      //  m.sendMessage(Text.literal("not Client? " + !w.isClient + "Hardness for " + w.getBlockState(p).getBlock().getName() +  w + " " + p + s.getHardness(w, p) ));
        if (!w.isClient && s.getHardness(w, p) != 0.0F) {

            i.damage(1, m, e -> e.sendEquipmentBreakStatus(EquipmentSlot.MAINHAND));
        }
    }

    private List<BlockPos> findBlocks( int x, int y, int z) {
        List<BlockPos> blocks = new ArrayList<>(26);
        for(int newX = x-1; newX <= x + 1; newX++){
            for(int newY = y-1; newY <= y + 1; newY++){
                for(int newZ = z-1; newZ <= z+1; newZ ++){
                    if(newX == x && newY == y && newZ == z){
                        continue;
                    }
                   // IsaacsMod.LOGGER.info("Adding Block Position x: " + x + " y: " + y + " z: " + z );
                    blocks.add(new BlockPos(newX, newY, newZ));
                }
            }

        }
        return blocks;
    }
}
