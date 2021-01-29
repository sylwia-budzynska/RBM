package eu.tmuniversal.rbm.common.data.common;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.LootTableProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ModLootTableProvider extends LootTableProvider {
  public ModLootTableProvider(DataGenerator dataGeneratorIn) {
    super(dataGeneratorIn);
  }

  @Override
  public String getName() {
    return "RBM LootTable";
  }
}
