/*
 * This class is distributed as part of the RBM Mod.
 * Get the Source Code in github:
 * https://github.com/TMUniversal/RBM
 *
 * RBM is Open Source and distributed under the
 * GPL-3.0 License: https://www.gnu.org/licenses/gpl-3.0.en.html
 */
package eu.tmuniversal.rbm.common.entity;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.passive.SnowGolemEntity;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

public class EntitySnowGiant extends SnowGolemEntity {

  public EntitySnowGiant(EntityType<? extends EntitySnowGiant> type, World worldIn) {
    super(type, worldIn);
  }

  public static AttributeModifierMap setAttributes() {
    return MobEntity.func_233666_p_()
            .createMutableAttribute(Attributes.MOVEMENT_SPEED, 0.2F / (ModEntities.SNOW_GIANT_SCALE / 3))
            .createMutableAttribute(Attributes.MAX_HEALTH, 69.0D)
            .createMutableAttribute(Attributes.KNOCKBACK_RESISTANCE, 0.95F)
            .createMutableAttribute(Attributes.ATTACK_SPEED, 7.0F)
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
  protected int calculateFallDamage(float distance, float damageMultiplier) {
    return super.calculateFallDamage(distance, damageMultiplier) / Math.round(ModEntities.SNOW_GIANT_SCALE);
  }

  @Override
  public void attackEntityWithRangedAttack(LivingEntity target, float distanceFactor) {
    EntityBigSnowball snowballentity = new EntityBigSnowball(this.world, this);
    double d0 = target.getPosYEye() - (double) 1.1F;
    double d1 = target.getPosX() - this.getPosX();
    double d2 = d0 - snowballentity.getPosY();
    double d3 = target.getPosZ() - this.getPosZ();
    float f = MathHelper.sqrt(d1 * d1 + d3 * d3) * 0.2F;
    snowballentity.shoot(d1, d2 + (double) f, d3, 1.6F, 12.0F / (ModEntities.SNOW_GIANT_SCALE * 1.9F));
    this.playSound(SoundEvents.ENTITY_SNOW_GOLEM_SHOOT, 1.0F, 0.4F / (this.getRNG().nextFloat() * 0.4F + 0.8F));
    this.world.addEntity(snowballentity);
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
