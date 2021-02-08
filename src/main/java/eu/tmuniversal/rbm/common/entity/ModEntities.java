/*
 * This class is distributed as part of the RBM Mod.
 * Get the Source Code in github:
 * https://github.com/TMUniversal/RBM
 *
 * RBM is Open Source and distributed under the
 * GPL-3.0 License: https://www.gnu.org/licenses/gpl-3.0.en.html
 */
package eu.tmuniversal.rbm.common.entity;

import eu.tmuniversal.rbm.common.entity.passive.EntitySnowGiant;
import eu.tmuniversal.rbm.common.entity.projectile.EntityBigSnowball;
import eu.tmuniversal.rbm.common.lib.LibEntityNames;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.registries.ForgeRegistries;

public class ModEntities {

  public static final float SNOW_GIANT_SCALE = 5.5F;
  public static final EntityType<EntitySnowGiant> SNOW_GIANT = EntityType.Builder.create(EntitySnowGiant::new, EntityClassification.MISC)
    .size(0.7F * SNOW_GIANT_SCALE, 1.9F * SNOW_GIANT_SCALE)
    .setTrackingRange(Math.round(8 * (SNOW_GIANT_SCALE / 1.9F)))
    .build("");

  public static final EntityType<EntityBigSnowball> BIG_SNOWBALL = EntityType.Builder.<EntityBigSnowball>create(EntityBigSnowball::new, EntityClassification.MISC)
    .size(0.25F * SNOW_GIANT_SCALE, 0.25F * SNOW_GIANT_SCALE)
    .setTrackingRange(4)
    .func_233608_b_(10)
    .build("");

  public static void registerEntities(RegistryEvent.Register<EntityType<?>> event) {
    register(SNOW_GIANT, LibEntityNames.SNOW_GIANT);
    register(BIG_SNOWBALL, LibEntityNames.BIG_SNOWBALL);
  }

  private static EntityType<?> register(EntityType<?> entity, String name) {
    entity.setRegistryName(name);
    ForgeRegistries.ENTITIES.register(entity);
    return entity;
  }
}
