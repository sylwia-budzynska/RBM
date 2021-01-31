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
