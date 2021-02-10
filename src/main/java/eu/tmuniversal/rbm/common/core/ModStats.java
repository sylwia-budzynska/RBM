/*
 * This class is distributed as part of the RBM Mod.
 * Get the Source Code in github:
 * https://github.com/TMUniversal/RBM
 *
 * RBM is Open Source and distributed under the
 * GPL-3.0 License: https://www.gnu.org/licenses/gpl-3.0.en.html
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
