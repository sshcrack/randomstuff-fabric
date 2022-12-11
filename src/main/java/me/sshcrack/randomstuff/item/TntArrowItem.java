package me.sshcrack.randomstuff.item;

import me.sshcrack.randomstuff.entity.TntArrowEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.item.ArrowItem;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class TntArrowItem extends ArrowItem {
    public TntArrowItem(Settings settings) {
        super(settings);
    }

    @Override
    public PersistentProjectileEntity createArrow(World world, ItemStack stack, LivingEntity shooter) {
        return new TntArrowEntity(world, shooter);
    }
}
