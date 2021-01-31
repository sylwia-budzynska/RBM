package eu.tmuniversal.rbm.common.entity;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.passive.SnowGolemEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.common.extensions.IForgeEntity;

public class EntitySnowGiant extends SnowGolemEntity implements IForgeEntity {

  public EntitySnowGiant(EntityType<? extends EntitySnowGiant> type, World worldIn) {
    super(type, worldIn);
  }

  @Override
  public boolean isWaterSensitive() {
    return false;
  }

  @Override
  protected float getStandingEyeHeight(Pose poseIn, EntitySize sizeIn) {
    return 11.8F;
  }

  @Override
  public boolean isShearable() {
    return false;
  }

  @Override
  public void livingTick() {
    super.livingTick();
    if (!this.world.isRemote) {
      int i;
      int j;
      int k;

      if (!net.minecraftforge.event.ForgeEventFactory.getMobGriefingEvent(this.world, this)) {
        return;
      }

      BlockState blockstate = Blocks.SNOW.getDefaultState();

      for (int l = 0; l < 4; ++l) {
        i = MathHelper.floor(this.getPosX() + (double) ((float) (l % 2 * 2 - 1) * 0.25F));
        j = MathHelper.floor(this.getPosY());
        k = MathHelper.floor(this.getPosZ() + (double) ((float) (l / 2 % 2 * 2 - 1) * 0.25F));
        BlockPos blockpos = new BlockPos(i, j, k).add(-4, -4, -4).add(4, 4, 4);
        if (this.world.isAirBlock(blockpos) && this.world.getBiome(blockpos).getTemperature(blockpos) < 0.8F && blockstate.isValidPosition(this.world, blockpos)) {
          this.world.setBlockState(blockpos, blockstate);
        }
      }
    }

  }
}
