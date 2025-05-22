package me.sshcrack.randomstuff.entity;

import me.sshcrack.randomstuff.RandomStuffMod;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.TntEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.entity.projectile.thrown.EnderPearlEntity;
import net.minecraft.item.BowItem;
import net.minecraft.item.EnderPearlItem;
import net.minecraft.item.ItemStack;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

import java.util.Random;

public class TPArrowEntity extends PersistentProjectileEntity {
    LivingEntity owner;


    public TPArrowEntity(EntityType<? extends TPArrowEntity> entityType, World world) {
        super(entityType, world);
    }

    public TPArrowEntity(World world, double x, double y, double z) {
        super(RandomStuffMod.TPArrowEntityType, x, y, z, world);
    }

    public TPArrowEntity(World world, LivingEntity owner) {
        super(RandomStuffMod.TPArrowEntityType, owner, world);
        this.owner = owner;
    }

    @Override
    protected void onBlockHit(BlockHitResult blockHitResult) {
        super.onBlockHit(blockHitResult);
        BlockPos pos = blockHitResult.getBlockPos();
        BlockState state = this.world.getBlockState(pos);

        if(state.isAir() || this.owner == null)
            return;

        handleLanding(blockHitResult.getPos(), () -> {
            Vec3d t = blockHitResult.getPos().add(0, 1, 0);
            this.owner.requestTeleport(t.getX(), t.getY(), t.getZ());
        });
    }

    @Override
    protected void onEntityHit(EntityHitResult entityHitResult) {
        Entity hit = entityHitResult.getEntity();

        RandomStuffMod.LOGGER.info("Entity hit tp");
        if(this.owner == null)
            return;

        handleLanding(this.owner.getPos(), () -> {
            Vec3d ownerPos = this.owner.getPos();
            hit.requestTeleport(ownerPos.getX(), ownerPos.getY(), owner.getZ());
        });
    }

    private void handleLanding(Vec3d soundPos, Runnable handleTeleport) {
        if(!this.world.isClient && !this.isRemoved()) {
            this.kill();
            handleTeleport.run();
            this.world.playSound(soundPos.getX(), soundPos.getY(), soundPos.getZ(), SoundEvents.ITEM_CHORUS_FRUIT_TELEPORT, SoundCategory.PLAYERS, 1, 1, true);
        }
    }


    public void tick() {
        Entity entity = this.getOwner();
        for(int i = 0; i < 5; ++i) {
            this.world.addParticle(ParticleTypes.PORTAL, this.getX(), this.getY() + this.random.nextDouble() * .5f, this.getZ(), this.random.nextGaussian(), 0.0D, this.random.nextGaussian());
        }

        if (entity instanceof PlayerEntity && !entity.isAlive()) {
            this.discard();
        } else {
            super.tick();
        }

    }


    protected ItemStack asItemStack() {
        return new ItemStack(RandomStuffMod.TPArrowItem);
    }
}
