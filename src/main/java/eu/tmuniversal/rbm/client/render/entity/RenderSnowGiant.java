package eu.tmuniversal.rbm.client.render.entity;

import eu.tmuniversal.rbm.client.model.ModelSnowGiant;
import eu.tmuniversal.rbm.client.render.entity.layers.LayerSnowGiantHead;
import eu.tmuniversal.rbm.common.entity.EntitySnowGiant;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class RenderSnowGiant extends MobRenderer<EntitySnowGiant, ModelSnowGiant> {
  private static final ResourceLocation SNOW_MAN_TEXTURES = new ResourceLocation("textures/entity/snow_golem.png");

  public RenderSnowGiant(EntityRendererManager renderManagerIn) {
    super(renderManagerIn, new ModelSnowGiant(), 3.15F);
    this.addLayer(new LayerSnowGiantHead(this));
  }

  @Override
  public ResourceLocation getEntityTexture(EntitySnowGiant entity) {
    return SNOW_MAN_TEXTURES;
  }
}
