package eu.tmuniversal.rbm.client.render.entity.layers;

import com.mojang.blaze3d.matrix.MatrixStack;
import eu.tmuniversal.rbm.client.model.ModelSnowGiant;
import eu.tmuniversal.rbm.common.entity.EntitySnowGiant;
import net.minecraft.block.Blocks;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.entity.IEntityRenderer;
import net.minecraft.client.renderer.entity.LivingRenderer;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.client.renderer.model.ItemCameraTransforms;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.vector.Vector3f;

public class LayerSnowGiantHead extends LayerRenderer<EntitySnowGiant, ModelSnowGiant> {
  public LayerSnowGiantHead(IEntityRenderer<EntitySnowGiant, ModelSnowGiant> entityRendererIn) {
    super(entityRendererIn);
  }

  @Override
  public void render(MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int packedLightIn, EntitySnowGiant entitylivingbaseIn, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
    matrixStackIn.push();
    this.getEntityModel().func_205070_a().translateRotate(matrixStackIn);
    float f = 0.625F;
    matrixStackIn.translate(0.0D, -0.34375D, 0.0D);
    matrixStackIn.rotate(Vector3f.YP.rotationDegrees(180.0F));
    matrixStackIn.scale(0.625F, -0.625F, -0.625F);
    ItemStack itemstack = new ItemStack(Blocks.CARVED_PUMPKIN);
    Minecraft.getInstance().getItemRenderer().renderItem(entitylivingbaseIn, itemstack, ItemCameraTransforms.TransformType.HEAD, false, matrixStackIn, bufferIn, entitylivingbaseIn.world, packedLightIn, LivingRenderer.getPackedOverlay(entitylivingbaseIn, 0.0F));
    matrixStackIn.pop();
  }
}
