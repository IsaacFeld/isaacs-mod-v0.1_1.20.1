package net.isaac.isaacsmod.item.custom;

import net.isaac.isaacsmod.item.ModToolMaterial;
import net.isaac.isaacsmod.particle.ModParticles;
import net.isaac.isaacsmod.particle.custom.SparkleParticle;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.particle.BlockStateParticleEffect;
import net.minecraft.particle.ParticleEffect;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.intprovider.IntProvider;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.world.World;
import net.isaac.isaacsmod.item.ModItems;
import java.util.ArrayList;
import java.util.List;

import static net.minecraft.client.util.ParticleUtil.spawnParticle;

public class SpecialPickaxe extends PickaxeItem {
    public SpecialPickaxe(ToolMaterial material, int attackDamage, float attackSpeed, Settings settings) {
        super(material, attackDamage, attackSpeed, settings);
    }
    public static final IntProvider count = UniformIntProvider.create(1, 5);
    public static final ToolMaterial material = ModToolMaterial.ADAMANT;
    public static int attackDamage =  3;
    public static float attackSpeed = -2.8f;
    public static ParticleEffect BLUE_SPARKLE = ModParticles.BLUE_SPARKLE;
    public static ParticleEffect GREEN_SPARKLE = ModParticles.GREEN_SPARKLE;
    public static ParticleEffect PINK_SPARKLE = ModParticles.PINK_SPARKLE;

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {

       //world.addParticle(BLUE_SPARKLE, user.getX(), user.getY() + 2, user.getZ(), 0, 0, 0);
        return super.use(world, user, hand);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        spawnRuneParticles(context.getWorld(), context.getBlockPos());
        return super.useOnBlock(context);
    }
    public void spawnRuneParticles(World world, BlockPos bp){
        spawnParticle(world, bp, GREEN_SPARKLE, count);
    }


    @Override
    public boolean postMine(ItemStack stack, World world, BlockState state, BlockPos pos, LivingEntity miner) {

            int x = pos.getX();
            int y = pos.getY();
            int z = pos.getZ();
            world.addParticle(new BlockStateParticleEffect(ParticleTypes.BLOCK,state), x, y, z, 0, 0 ,0 );
            List<BlockPos> Blocks = findBlocks(x, y, z);
            for (BlockPos bp : Blocks) {
                if (stack.isSuitableFor(world.getBlockState(bp))) {
                    extraBreak(stack, world, bp, miner, world.getBlockState(bp));
                    world.breakBlock(bp, true);
                    rollRuneDrops(world, bp.getX(), bp.getY(), bp.getZ(), bp);
                }
            }




        if (!world.isClient && state.getHardness(world, pos) != 0.0F) {
            stack.damage(1, miner, e -> e.sendEquipmentBreakStatus(EquipmentSlot.MAINHAND));
        }

        return true;
    }

    private void rollRuneDrops(World world, int localBlockX, int localBlockY, int localBlockZ, BlockPos bp) {
        Item smallRune = ModItems.LESSER_MANA;
        Item smallRune_1 = ModItems.LESSER_GREEN_MANA;
        Item smallRune_2 = ModItems.LESSER_PINK_MANA;
        double weight = Math.random() * 100;
        if(weight > 50 && weight <= 80){
            Entity lesserRune = new ItemEntity(world, localBlockX, localBlockY, localBlockZ, new ItemStack(smallRune, 1) );
            world.spawnEntity(lesserRune);
        }
        if(weight > 80 && weight <= 100){
            Entity lesserRune = new ItemEntity(world, localBlockX, localBlockY, localBlockZ, new ItemStack(smallRune_1, 1));
            world.spawnEntity(lesserRune);
        }
        if(weight <= 10){
            Entity lesserRune = new ItemEntity(world,localBlockX,localBlockY,localBlockZ, new ItemStack(smallRune_2, 1));
            world.spawnEntity(lesserRune);
        }

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
