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

import net.minecraft.util.text.TranslationTextComponent;

public class TooltipHelper {

  public static final String TOOLTIP_EXTENSION = "tooltip";
  public static final String LINE_EXTENSION = "line";

  public static TranslationTextComponent blockTooltip(String blockName) {
    return tooltip("block", blockName);
  }

  public static TranslationTextComponent blockTooltip(String blockName, int line) {
    return tooltip("block", blockName, line);
  }

  public static TranslationTextComponent itemTooltip(String itemName) {
    return tooltip("item", itemName);
  }

  public static TranslationTextComponent itemTooltip(String itemName, int line) {
    return tooltip("item", itemName, line);
  }

  private static TranslationTextComponent tooltip(String prefix, String name, int line) {
    return tooltip(prefix, name, LINE_EXTENSION + line);
  }

  private static TranslationTextComponent tooltip(String prefix, String name) {
    return tooltip(prefix, name, TOOLTIP_EXTENSION);
  }

  private static TranslationTextComponent tooltip(String prefix, String name, String extension) {
    return new TranslationTextComponent(buildKey(prefix, name, extension));
  }

  private static String buildKey(String prefix, String name, String extension) {
    return buildKey(prefix, name) + "." + extension;
  }

  private static String buildKey(String prefix, String name) {
    return prefix + "." + Reference.MOD_ID + "." + name;
  }
}
