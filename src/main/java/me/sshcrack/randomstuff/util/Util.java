package me.sshcrack.randomstuff.util;

import net.minecraft.block.BlockState;
import net.minecraft.util.math.Vec2f;

import java.util.ArrayList;

public class Util {
    public static long countElements(ArrayList<Vec2f> list, Vec2f item) {
        return list
                .stream()
                .filter(e -> e.x == item.x && e.y == item.y)
                .count();
    }

    public static boolean isSolid(BlockState state) {
        return state.getMaterial().isSolid();
    }
}
