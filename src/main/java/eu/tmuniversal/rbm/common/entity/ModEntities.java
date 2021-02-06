/*
 * This class is distributed as part of the RBM Mod.
 * Get the Source Code in github:
 * https://github.com/TMUniversal/RBM
 *
 * RBM is Open Source and distributed under the
 * GPL-3.0 License: https://www.gnu.org/licenses/gpl-3.0.en.html
 */
package eu.tmuniversal.rbm.common.entity;

import eu.tmuniversal.rbm.common.lib.LibEntityNames;
import eu.tmuniversal.rbm.common.setup.Registration;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraftforge.fml.RegistryObject;

import java.util.function.Supplier;

public class ModEntities {

  public static final float SNOW_GIANT_SCALE = 5.5F;
  public static final EntityType<EntitySnowGiant> SNOW_GIANT = EntityType.Builder.<EntitySnowGiant>create(EntitySnowGiant::new, EntityClassification.MISC)
          .size(0.7F * SNOW_GIANT_SCALE, 1.9F * SNOW_GIANT_SCALE)
          .setTrackingRange(Math.round(8 * (SNOW_GIANT_SCALE / 1.9F)))
          .build("");
  public static final RegistryObject<EntityType<EntitySnowGiant>> SNOW_GIANT_REGISTRY_OBJECT = register(LibEntityNames.SNOW_GIANT, () -> SNOW_GIANT);

  public static final EntityType<EntityBigSnowball> BIG_SNOWBALL = EntityType.Builder.<EntityBigSnowball>create(EntityBigSnowball::new, EntityClassification.MISC)
          .size(0.25F * SNOW_GIANT_SCALE, 0.25F * SNOW_GIANT_SCALE)
          .setTrackingRange(4)
          .func_233608_b_(10)
          .build("");
  public static final RegistryObject<EntityType<EntityBigSnowball>> BIG_SNOWBALL_REGISTRY_OBJECT = register(LibEntityNames.BIG_SNOWBALL, () -> BIG_SNOWBALL);

  public static void register() {
  }

  private static <T extends EntityType<?>> RegistryObject<T> register(String name, Supplier<T> entitySupplier) {
    return Registration.ENTITIES.register(name, entitySupplier);
  }
}
