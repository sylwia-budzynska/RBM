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
package eu.tmuniversal.rbm.common.core.proxy;

import net.minecraft.block.Block;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;

public interface IProxy {
  default void registerHandlers() {
  }

  default boolean isTheClientPlayer(LivingEntity entity) {
    return false;
  }

  default PlayerEntity getClientPlayer() {
    return null;
  }

  default int getClientRenderDistance() {
    return 0;
  }

  default Item.Properties propertiesWithRenderer(Item.Properties properties, Block block) {
    return properties;
  }
}
