package net.isaac.isaacsmod;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.player.PlayerBlockBreakEvents;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.isaac.isaacsmod.block.ModBlocks;
import net.isaac.isaacsmod.item.ModItemGroups;
import net.isaac.isaacsmod.item.ModItems;
import net.isaac.isaacsmod.particle.ModParticles;
import net.minecraft.util.math.intprovider.IntProvider;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class IsaacsMod implements ModInitializer {
	public static final String MOD_ID = "isaacsmod";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
	public static final IntProvider count = UniformIntProvider.create(1, 2);





	@Override
	public void onInitialize() {

		PlayerBlockBreakEvents.AFTER.register((world, player, pos, state, entity) -> {
		});
		ModItems.registerModItems();
		ModItemGroups.registerItemGroups();
		ModBlocks.registerModBlocks();
		ModParticles.registerModParticles();
		FuelRegistry.INSTANCE.add(ModItems.ORODRUIN_REMNANT, 400);

		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		LOGGER.info("I thank thee for using my mod");
	}
}