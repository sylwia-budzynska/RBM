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
package eu.tmuniversal.rbm.common.block;

import eu.tmuniversal.rbm.common.core.IModRegistrable;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;

public class ModBlock extends Block implements IModRegistrable {

  public ModBlock(Properties properties) {
    super(properties);
  }

  public static Properties getDefaultProperties() {
    return getDefaultProperties(Material.ROCK).hardnessAndResistance(3);
  }

  public static Properties getDefaultProperties(Material material) {
    return Properties.create(material).hardnessAndResistance(3);
  }

  public static Properties getDefaultProperties(Material material, MaterialColor materialColor) {
    return Properties.create(material, materialColor).hardnessAndResistance(3);
  }

  @Override
  public void registerModel() {

  }
}
