/*
 * This class is distributed as part of the RBM Mod.
 * Get the Source Code in github:
 * https://github.com/TMUniversal/RBM
 *
 * RBM is Open Source and distributed under the
 * GPL-3.0 License: https://www.gnu.org/licenses/gpl-3.0.en.html
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
