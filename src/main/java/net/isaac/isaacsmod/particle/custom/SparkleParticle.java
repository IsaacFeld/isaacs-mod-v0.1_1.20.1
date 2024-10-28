package net.isaac.isaacsmod.particle.custom;

import net.minecraft.client.particle.*;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.particle.BlockStateParticleEffect;
import net.minecraft.particle.DefaultParticleType;
import net.minecraft.particle.ParticleType;
import org.jetbrains.annotations.Nullable;

public class SparkleParticle extends SpriteBillboardParticle {
    protected SparkleParticle(ClientWorld clientWorld, SpriteProvider spriteSet, double xCoord, double yCoord, double zCoord, double xd, double yd, double zd) {
        super(clientWorld, xCoord, yCoord, zCoord, xd, yd, zd);

        this.velocityMultiplier = 1.0f;
        this.x = xd;
        this.y = yd;
        this.z = zd;
        this.scale *= 2.0f;
        this.maxAge = 100;
        this.setSpriteForAge(spriteSet);

        this.red = 1f;
        this.green = 1f;
        this.blue = 1f;
    }

    @Override
    public void tick() {
        super.tick();
        fadeOut();
    }
    private void fadeOut(){
        this.alpha = (-(1/(float)maxAge)* age + 1);
    }

    @Override
    public ParticleTextureSheet getType() {
        return ParticleTextureSheet.PARTICLE_SHEET_TRANSLUCENT;
    }

    public static class Factory implements ParticleFactory<DefaultParticleType> {
        private final SpriteProvider sprites;

        public Factory(SpriteProvider spriteSet){
            this.sprites = spriteSet;
        }


        @Override
        public @Nullable Particle createParticle(DefaultParticleType particleType, ClientWorld level, double x, double y, double z,
                                                 double velocityX, double velocityY, double velocityZ) {
            return new SparkleParticle(level, this.sprites,  x, y, z, velocityX, velocityY, velocityZ);
        }
    }
}
