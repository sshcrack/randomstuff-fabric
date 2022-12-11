package me.sshcrack.randomstuff.client.renderer;

import me.sshcrack.randomstuff.RandomStuffMod;
import me.sshcrack.randomstuff.entity.TntArrowEntity;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.ProjectileEntityRenderer;
import net.minecraft.util.Identifier;

public class TntArrowEntityRenderer extends ProjectileEntityRenderer<TntArrowEntity> {
    public static final Identifier TEXTURE = new Identifier(RandomStuffMod.ModID, "textures/entity/projectiles/tnt_arrow.png");

    public TntArrowEntityRenderer(EntityRendererFactory.Context context) {
        super(context);
    }

    @Override
    public Identifier getTexture(TntArrowEntity arrowEntity) {
        return TEXTURE;
    }
}
