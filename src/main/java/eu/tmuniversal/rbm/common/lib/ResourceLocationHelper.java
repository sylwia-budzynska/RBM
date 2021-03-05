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
