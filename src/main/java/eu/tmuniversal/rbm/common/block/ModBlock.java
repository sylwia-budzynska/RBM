package eu.tmuniversal.rbm.common.block;

import eu.tmuniversal.rbm.common.core.IModRegistrable;
import net.minecraft.block.AbstractBlock;
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
