/*
 * This class is distributed as part of the RBM Mod.
 * Get the Source Code on github:
 * https://github.com/TMUniversal/RBM
 *
 * RBM is Open Source and distributed under the
 * Creative Commons Attribution-NonCommercial-ShareAlike 4.0
 * International Public License (CC BY-NC-SA 4.0):
 * https://creativecommons.org/licenses/by-nc-sa/4.0/
 */
package eu.tmuniversal.rbm.common.block;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class BlockLaunchpad extends Block {
  public BlockLaunchpad(Properties properties) {
    super(properties);
  }

  public BlockLaunchpad() {
    this(ModBlock.getDefaultProperties(Material.SPONGE)
      .sound(SoundType.ANCIENT_DEBRIS)
      .hardnessAndResistance(0.3F, 1.0F)
      .jumpFactor(4.5F)
      .speedFactor(1.1F)
    );
  }
}
