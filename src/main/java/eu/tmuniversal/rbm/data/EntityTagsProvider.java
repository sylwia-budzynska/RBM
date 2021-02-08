/*
 * This class is distributed as part of the RBM Mod.
 * Get the Source Code in github:
 * https://github.com/TMUniversal/RBM
 *
 * RBM is Open Source and distributed under the
 * GPL-3.0 License: https://www.gnu.org/licenses/gpl-3.0.en.html
 */
package eu.tmuniversal.rbm.data;

import eu.tmuniversal.rbm.common.entity.ModEntities;
import eu.tmuniversal.rbm.common.lib.Reference;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.EntityTypeTagsProvider;
import net.minecraft.tags.EntityTypeTags;

public class EntityTagsProvider extends EntityTypeTagsProvider {
  public EntityTagsProvider(DataGenerator generator) {
    super(generator);
  }

  @Override
  protected void registerTags() {
    getOrCreateBuilder(EntityTypeTags.IMPACT_PROJECTILES).addTag(EntityTypeTags.ARROWS).add(ModEntities.BIG_SNOWBALL);
  }

  @Override
  public String getName() {
    return Reference.MOD_NAME_SHORT + " Entity Tags";
  }
}
