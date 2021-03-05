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
package eu.tmuniversal.rbm.common.core;

import eu.tmuniversal.rbm.mixin.AccessorStats;
import net.minecraft.stats.IStatFormatter;
import net.minecraft.util.ResourceLocation;

import static eu.tmuniversal.rbm.common.lib.ResourceLocationHelper.prefixId;

public class ModStats {
  public static final ResourceLocation CUPS_OF_TEA_CONSUMED =
    AccessorStats.rbm_registerCustom(prefixId("cups_of_tea_consumed"), IStatFormatter.DEFAULT);

  public static void init() {
  }
}
