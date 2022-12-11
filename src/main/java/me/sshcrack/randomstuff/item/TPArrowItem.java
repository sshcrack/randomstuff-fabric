package me.sshcrack.randomstuff.item;

import me.sshcrack.randomstuff.entity.TPArrowEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.item.ArrowItem;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class TPArrowItem extends ArrowItem {
    public TPArrowItem(Settings settings) {
        super(settings);
    }

    @Override
    public PersistentProjectileEntity createArrow(World world, ItemStack stack, LivingEntity shooter) {
        return new TPArrowEntity(world, shooter);
    }
}
