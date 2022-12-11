package me.sshcrack.randomstuff.client.renderer;

import me.sshcrack.randomstuff.RandomStuffMod;
import me.sshcrack.randomstuff.entity.TPArrowEntity;
import me.sshcrack.randomstuff.entity.TntArrowEntity;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.ProjectileEntityRenderer;
import net.minecraft.util.Identifier;

public class TPArrowEntityRenderer extends ProjectileEntityRenderer<TPArrowEntity> {
    public static final Identifier TEXTURE = new Identifier(RandomStuffMod.ModID, "textures/entity/projectiles/tp_arrow.png");

    public TPArrowEntityRenderer(EntityRendererFactory.Context context) {
        super(context);
    }

    @Override
    public Identifier getTexture(TPArrowEntity arrowEntity) {
        return TEXTURE;
    }
}
