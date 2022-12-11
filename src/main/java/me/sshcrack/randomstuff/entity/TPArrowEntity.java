package me.sshcrack.randomstuff.entity;

import me.sshcrack.randomstuff.RandomStuffMod;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.TntEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.entity.projectile.thrown.EnderPearlEntity;
import net.minecraft.item.EnderPearlItem;
import net.minecraft.item.ItemStack;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class TPArrowEntity extends PersistentProjectileEntity {
    LivingEntity owner;


    public TPArrowEntity(EntityType<? extends TPArrowEntity> entityType, World world) {
        super(entityType, world);
    }

    public TPArrowEntity(World world, double x, double y, double z) {
        super(EntityType.ARROW, x, y, z, world);
    }

    public TPArrowEntity(World world, LivingEntity owner) {
        super(EntityType.ARROW, owner, world);
        this.owner = owner;
    }


    protected void onCollision(HitResult hitResult) {
        super.onCollision(hitResult);
        Vec3d vec = hitResult.getPos();

        BlockState block = world.getBlockState(new BlockPos(vec.getX(), vec.getY(), vec.getZ()));
        if(block.isAir())
            return;

        if(!this.world.isClient && !this.isRemoved()) {
            this.kill();
            this.owner.requestTeleport(vec.getX(), vec.getY(), vec.getZ());
            this.world.playSound(vec.getX(), vec.getY(), vec.getZ(), SoundEvents.ITEM_CHORUS_FRUIT_TELEPORT, SoundCategory.PLAYERS, 1, 1, true);
        }
    }


    public void tick() {
        Entity entity = this.getOwner();
        for(int i = 0; i < 5; ++i) {
            this.world.addParticle(ParticleTypes.PORTAL, this.getX(), this.getY() + this.random.nextDouble() * 2.0D, this.getZ(), this.random.nextGaussian(), 0.0D, this.random.nextGaussian());
        }

        if (entity instanceof PlayerEntity && !entity.isAlive()) {
            this.discard();
        } else {
            super.tick();
        }

    }


    protected ItemStack asItemStack() {
        return new ItemStack(RandomStuffMod.TntArrowItem);
    }
}
