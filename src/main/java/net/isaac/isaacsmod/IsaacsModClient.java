package net.isaac.isaacsmod;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.isaac.isaacsmod.particle.ModParticles;
import net.isaac.isaacsmod.particle.custom.SparkleParticle;
import net.minecraft.client.particle.*;


public class IsaacsModClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
    // Bubblepop and CloudParticle and EnchantGlyph

        ParticleFactoryRegistry.getInstance().register(ModParticles.BLUE_SPARKLE, SparkleParticle.Factory::new);
        ParticleFactoryRegistry.getInstance().register(ModParticles.PINK_SPARKLE, SparkleParticle.Factory::new);
        ParticleFactoryRegistry.getInstance().register(ModParticles.GREEN_SPARKLE, SparkleParticle.Factory::new);


    }
}
