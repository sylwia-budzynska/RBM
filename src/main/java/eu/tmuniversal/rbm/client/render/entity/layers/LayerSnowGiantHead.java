/*
 * This class is distributed as part of the RBM Mod.
 * Get the Source Code in github:
 * https://github.com/TMUniversal/RBM
 *
 * RBM is Open Source and distributed under the
 * GPL-3.0 License: https://www.gnu.org/licenses/gpl-3.0.en.html
 */
package eu.tmuniversal.rbm.client.render.entity.layers;

import com.mojang.blaze3d.matrix.MatrixStack;
import eu.tmuniversal.rbm.client.model.ModelSnowGiant;
import eu.tmuniversal.rbm.common.block.ModBlocks;
import eu.tmuniversal.rbm.common.entity.EntitySnowGiant;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.entity.IEntityRenderer;
import net.minecraft.client.renderer.entity.LivingRenderer;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.client.renderer.model.ItemCameraTransforms;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.vector.Vector3f;

public class LayerSnowGiantHead extends LayerRenderer<EntitySnowGiant, ModelSnowGiant> {

  private static float scale;

  public LayerSnowGiantHead(IEntityRenderer<EntitySnowGiant, ModelSnowGiant> entityRenderer) {
    this(entityRenderer, 1F);
  }

  public LayerSnowGiantHead(IEntityRenderer<EntitySnowGiant, ModelSnowGiant> entityRendererIn, float scale) {
    super(entityRendererIn);
    LayerSnowGiantHead.scale = scale;
  }

  @Override
  public void render(MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int packedLightIn, EntitySnowGiant entitylivingbaseIn, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
    matrixStackIn.push();
    this.getEntityModel().func_205070_a().translateRotate(matrixStackIn);
    double hat_shift = 0.5 * 0.625 * 0.985 * scale; // default: 0.34375D;
    matrixStackIn.translate(0.0D, -hat_shift, 0.0D);
    matrixStackIn.rotate(Vector3f.YP.rotationDegrees(180.0F));
    matrixStackIn.scale(0.625F * scale, -0.625F * scale, -0.625F * scale);
    ItemStack itemstack = new ItemStack(ModBlocks.COMPRESSED_CARVED_PUMPKIN.get());
    Minecraft.getInstance().getItemRenderer().renderItem(entitylivingbaseIn, itemstack, ItemCameraTransforms.TransformType.HEAD, false, matrixStackIn, bufferIn, entitylivingbaseIn.world, packedLightIn, LivingRenderer.getPackedOverlay(entitylivingbaseIn, 0.0F));
    matrixStackIn.pop();
  }
}
