/*
 * This class is distributed as part of the RBM Mod.
 * Get the Source Code in github:
 * https://github.com/TMUniversal/RBM
 *
 * RBM is Open Source and distributed under the
 * GPL-3.0 License: https://www.gnu.org/licenses/gpl-3.0.en.html
 */
package eu.tmuniversal.rbm.common.core;

import net.minecraft.block.Block;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;

public interface IProxy {
  default void registerHandlers() {}

  default boolean isTheClientPlayer(LivingEntity entity) {
    return false;
  }

  default PlayerEntity getClientPlayer() { return null; }

  default int getClientRenderDistance() {
    return 0;
  }

  default Item.Properties propertiesWithRenderer(Item.Properties properties, Block block) {
    return properties;
  }
}
