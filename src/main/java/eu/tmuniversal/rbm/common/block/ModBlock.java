/*
 * This class is distributed as part of the RBM Mod.
 * Get the Source Code in github:
 * https://github.com/TMUniversal/RBM
 *
 * RBM is Open Source and distributed under the
 * GPL-3.0 License: https://www.gnu.org/licenses/gpl-3.0.en.html
 */
package eu.tmuniversal.rbm.common.block;

import eu.tmuniversal.rbm.common.core.IModRegistrable;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;

public class ModBlock extends Block implements IModRegistrable {

  public static Properties getDefaultProperties() {
    return getDefaultProperties(Material.ROCK).hardnessAndResistance(3);
  }

  public static Properties getDefaultProperties(Material material) {
    return Properties.create(material).hardnessAndResistance(3);
  }

  public static Properties getDefaultProperties(Material material, MaterialColor materialColor) {
    return Properties.create(material, materialColor).hardnessAndResistance(3);
  }

  public ModBlock(Properties properties) {
    super(properties);
  }



  @Override
  public void registerModel() {

  }
}
