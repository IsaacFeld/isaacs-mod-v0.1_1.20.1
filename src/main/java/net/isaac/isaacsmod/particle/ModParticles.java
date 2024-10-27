package net.isaac.isaacsmod.particle;

import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.isaac.isaacsmod.IsaacsMod;
import net.isaac.isaacsmod.particle.custom.SparkleParticle;
import net.minecraft.particle.BlockStateParticleEffect;
import net.minecraft.particle.DefaultParticleType;
import net.minecraft.particle.ParticleEffect;
import net.minecraft.particle.ParticleType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.client.particle.*;
import net.minecraft.util.Identifier;

public class ModParticles {
    public static final DefaultParticleType BLUE_SPARKLE = registerParticle("blue_sparkle", FabricParticleTypes.simple());
    public static final DefaultParticleType PINK_SPARKLE = registerParticle("pink_sparkle", FabricParticleTypes.simple());
    public static final DefaultParticleType GREEN_SPARKLE = registerParticle("green_sparkle", FabricParticleTypes.simple());
    private static DefaultParticleType registerParticle(String name, DefaultParticleType particle){

        return Registry.register(Registries.PARTICLE_TYPE, new Identifier(IsaacsMod.MOD_ID, name), particle);
    }


    public static void registerModParticles(){
        IsaacsMod.LOGGER.info("Registering Mod Items for " + IsaacsMod.MOD_ID);


    }
}
