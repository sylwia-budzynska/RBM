package eu.tmuniversal.rbm.common.lib;

import net.minecraft.util.ResourceLocation;

public class ResourceLocationHelper {
  public static ResourceLocation prefix(String path) {
    return new ResourceLocation(Reference.MOD_ID, path);
  }

  public static String prefixId(String path) {
    return Reference.MOD_ID + ":" + path;
  }
}
