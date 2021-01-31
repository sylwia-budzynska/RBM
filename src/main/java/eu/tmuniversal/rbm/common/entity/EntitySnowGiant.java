package eu.tmuniversal.rbm.common.entity;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EntitySize;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.Pose;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.passive.SnowGolemEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

public class EntitySnowGiant extends SnowGolemEntity {

  public EntitySnowGiant(EntityType<? extends EntitySnowGiant> type, World worldIn) {
    super(type, worldIn);
  }

  public static AttributeModifierMap setAttributes() {
    return MobEntity.func_233666_p_()
            .createMutableAttribute(Attributes.MOVEMENT_SPEED, 0.2F / ModEntities.SNOW_GIANT_SCALE)
            .createMutableAttribute(Attributes.MAX_HEALTH, 69.0D)
            .createMutableAttribute(Attributes.KNOCKBACK_RESISTANCE, 0.9F)
            .create();
  }

  @Override
  public boolean isWaterSensitive() {
    return false;
  }

  @Override
  protected float getStandingEyeHeight(Pose poseIn, EntitySize sizeIn) {
    return (1.9F - 0.2F) * ModEntities.SNOW_GIANT_SCALE;
  }

  @Override
  public boolean isShearable() {
    return false;
  }

  @Override
  public void livingTick() {
    super.livingTick();
    if (!this.world.isRemote) {
      if (!net.minecraftforge.event.ForgeEventFactory.getMobGriefingEvent(this.world, this)) {
        return;
      }

      BlockState blockstate = Blocks.SNOW.getDefaultState();

      for (int i = 0; i < 4; ++i) {
        int x = MathHelper.floor(this.getPosX() + (double) ((float) (i % 2 * 2 - 1) * 0.25F));
        int y = MathHelper.floor(this.getPosY());
        int z = MathHelper.floor(this.getPosZ() + (double) ((float) (i / 2 % 2 * 2 - 1) * 0.25F));
        BlockPos blockpos = new BlockPos(x, y, z); // .add(-4, -4, -4).add(4, 4, 4);
        if (this.world.isAirBlock(blockpos) && blockstate.isValidPosition(this.world, blockpos)) {
          this.world.setBlockState(blockpos, blockstate);
        }
      }
    }

  }
}
