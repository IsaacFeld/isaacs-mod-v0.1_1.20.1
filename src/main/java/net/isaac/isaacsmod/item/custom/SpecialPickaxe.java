package net.isaac.isaacsmod.item.custom;
import net.isaac.isaacsmod.item.ModToolMaterial;
import net.isaac.isaacsmod.particle.ModParticles;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.UseAction;
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
    public static final IntProvider count = UniformIntProvider.create(1, 4);
    public static final ToolMaterial material = ModToolMaterial.ADAMANT;
    public static int attackDamage =  3;
    public static float attackSpeed = -2.8f;
    public int a = 0;



    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        return super.use(world, user, hand);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {

        spawnRuneParticles(context.getPlayer(), context.getWorld(), context.getBlockPos());
        return super.useOnBlock(context);
    }
    public void spawnRuneParticles(PlayerEntity player, World world, BlockPos bp){
        double janluckynumber = Math.random() * 100;

        System.out.println(janluckynumber);
        if(janluckynumber >98){
            player.sendMessage(Text.literal("Jan is a stinky poop"));
        }
        else{
            player.sendMessage(Text.literal("Theo is a stinkier poop"));
        }
        for(int i = 0; i < 3; i ++){
            if(i == 1){
                spawnParticle(world, bp, ModParticles.PINK_SPARKLE, count);
            }
            else if(i == 2){
                spawnParticle(world,bp, ModParticles.BLUE_SPARKLE, count);

            }
            else{
                spawnParticle(world,bp,ModParticles.GREEN_SPARKLE, count);
            }
        }


    }
    // https://www.youtube.com/watch?v=HQUkWjMWTik Mixins

    @Override
    public UseAction getUseAction(ItemStack stack) {

        return super.getUseAction(stack);
    }

    @Override
    public boolean postMine(ItemStack stack, World world, BlockState state, BlockPos pos, LivingEntity miner) {
            int x = pos.getX();
            int y = pos.getY();
            int z = pos.getZ();
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
