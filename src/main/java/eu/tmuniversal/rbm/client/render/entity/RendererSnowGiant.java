package eu.tmuniversal.rbm.client.render.entity;

import com.mojang.blaze3d.matrix.MatrixStack;
import eu.tmuniversal.rbm.client.model.ModelSnowGiant;
import eu.tmuniversal.rbm.client.render.entity.layers.LayerSnowGiantHead;
import eu.tmuniversal.rbm.common.entity.EntitySnowGiant;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class RendererSnowGiant extends MobRenderer<EntitySnowGiant, ModelSnowGiant> {
  private static final ResourceLocation SNOW_MAN_TEXTURES = new ResourceLocation("textures/entity/snow_golem.png");
  private final float scale;

  public RendererSnowGiant(EntityRendererManager rendererManager) {
    this(rendererManager, 6.0F);
  }

  public RendererSnowGiant(EntityRendererManager renderManagerIn, float scaleIn) {
    super(renderManagerIn, new ModelSnowGiant(scaleIn), 0.5F * scaleIn);
    this.scale = scaleIn;
    this.addLayer(new LayerSnowGiantHead(this, 1.0F));
  }

  protected void preRenderCallback(EntitySnowGiant entitiylivingbaseIn, MatrixStack matrixStackIn, float partialTickTime) {
    matrixStackIn.scale(this.scale, this.scale, this.scale);
  }

  @Override
  public ResourceLocation getEntityTexture(EntitySnowGiant entity) {
    return SNOW_MAN_TEXTURES;
  }
}
