package eu.tmuniversal.rbm.common.entity;

import eu.tmuniversal.rbm.common.lib.LibEntityNames;
import eu.tmuniversal.rbm.common.setup.Registration;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraftforge.fml.RegistryObject;

import java.util.function.Supplier;

public class ModEntities {

  public static final float SNOW_GIANT_SCALE = 5.5F;
  public static final EntityType<EntitySnowGiant> SNOW_GIANT = EntityType.Builder.create(EntitySnowGiant::new, EntityClassification.MISC)
          .size(0.7F * SNOW_GIANT_SCALE, 1.9F * SNOW_GIANT_SCALE)
          .setTrackingRange(16)
          .build("");
  public static final RegistryObject<EntityType<EntitySnowGiant>> SNOW_GIANT_REGISTRY_OBJECT = register(LibEntityNames.SNOW_GIANT, () -> SNOW_GIANT);

  public static void register() {
  }

  private static <T extends EntityType<?>> RegistryObject<T> register(String name, Supplier<T> entitySupplier) {
    return Registration.ENTITIES.register(name, entitySupplier);
  }
}
