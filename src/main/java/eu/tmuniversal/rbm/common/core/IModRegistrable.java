package eu.tmuniversal.rbm.common.core;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public interface IModRegistrable {
  @OnlyIn(Dist.CLIENT)
  void registerModel();
}
