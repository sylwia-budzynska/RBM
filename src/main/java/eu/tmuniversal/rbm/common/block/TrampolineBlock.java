package eu.tmuniversal.rbm.common.block;

import net.minecraft.block.SlimeBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.IBlockReader;

public class TrampolineBlock extends SlimeBlock {

  public static final double WALKING_MODIFIER = 0.85D;
  public static final SoundEvent SLIME_SOUND_EVENT = SoundEvents.BLOCK_SLIME_BLOCK_STEP;

  public TrampolineBlock() {
    super(ModBlocks.makeBlockProperties(Material.CLAY, MaterialColor.GRASS)
            .slipperiness(0.8F)
            .sound(SoundType.SLIME)
            .jumpFactor(1.5F / 1.25F) // divide by default jump height of 1.25 blocks
            .notSolid()
    );
  }

  @Override
  public void onLanded(IBlockReader worldIn, Entity entityIn) {
    if (entityIn.isSuppressingBounce()) {
      super.onLanded(worldIn, entityIn);
    } else {
      Vector3d motion = entityIn.getMotion();
      if (motion.y < -0.1D) {
        double modifier = entityIn instanceof LivingEntity ? 1.35D : 0.8D;
        entityIn.playSound(SLIME_SOUND_EVENT, ((float) Math.abs(motion.y) / 5), 1.0F);
        entityIn.setMotion(motion.x, -motion.y * modifier, motion.z);
      }
      else {
//        hacky solution to prevent infinite bouncing on the spot
        entityIn.setMotion(entityIn.getMotion().mul(1.0, 0.0, 1.0));
      }
    }
  }
}
