/*
 * This class is distributed as part of the RBM Mod.
 * Get the Source Code in github:
 * https://github.com/TMUniversal/RBM
 *
 * RBM is Open Source and distributed under the
 * GPL-3.0 License: https://www.gnu.org/licenses/gpl-3.0.en.html
 */
package eu.tmuniversal.rbm.common.block;

import net.minecraft.block.BarrierBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class BlockSolidAirBase extends BarrierBlock {

  public static final Properties PROPERTIES = ModBlock.getDefaultProperties(Material.GLASS)
    .notSolid()
    .setAllowsSpawn((p1, p2, p3, p4) -> false)
    .hardnessAndResistance(0.3F)
    .setSuffocates((p1, p2, p3) -> false)
    .sound(SoundType.FUNGUS)
    .setBlocksVision((p1, p2, p3) -> false)
    .setOpaque((p1, p2, p3) -> false);

  public BlockSolidAirBase(Properties properties) {
    super(properties);
  }
}
