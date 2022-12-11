package me.sshcrack.randomstuff.entity;

import me.sshcrack.randomstuff.RandomStuffMod;
import net.minecraft.block.BlockState;
import net.minecraft.block.TntBlock;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.TntEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class TntArrowEntity extends PersistentProjectileEntity {
    LivingEntity owner;


    public TntArrowEntity(EntityType<? extends TntArrowEntity> entityType, World world) {
        super(entityType, world);
    }

    public TntArrowEntity(World world, double x, double y, double z) {
        super(EntityType.ARROW, x, y, z, world);
    }

    public TntArrowEntity(World world, LivingEntity owner) {
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
            TntEntity entity = new TntEntity(world, vec.getX(), vec.getY(), vec.getZ(), this.owner);
            entity.setFuse(20);
            world.spawnEntity(entity);
        }
    }


    protected ItemStack asItemStack() {
        return new ItemStack(RandomStuffMod.TntArrowItem);
    }
}
