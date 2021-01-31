package eu.tmuniversal.rbm.common.entity;

import eu.tmuniversal.rbm.common.lib.LibEntityNames;
import eu.tmuniversal.rbm.common.setup.Registration;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraftforge.fml.RegistryObject;

import java.util.function.Supplier;

public class ModEntities {

  public static final EntityType<EntitySnowGiant> SNOW_GIANT = EntityType.Builder.create(EntitySnowGiant::new, EntityClassification.MISC)
          .size(4.4F, 12F)
          .setTrackingRange(16)
          .build("");
  public static final RegistryObject<EntityType<EntitySnowGiant>> SNOW_GIANT_REGISTRY_OBJECT = register(LibEntityNames.SNOW_GIANT, () -> SNOW_GIANT);

  public static void register() {
  }

  private static <T extends EntityType<?>> RegistryObject<T> register(String name, Supplier<T> entitySupplier) {
    return Registration.ENTITIES.register(name, entitySupplier);
  }
}
