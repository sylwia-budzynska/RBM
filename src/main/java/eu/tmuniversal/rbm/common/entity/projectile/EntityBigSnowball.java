/*
 * This class is distributed as part of the RBM Mod.
 * Get the Source Code in github:
 * https://github.com/TMUniversal/RBM
 *
 * RBM is Open Source and distributed under the
 * GPL-3.0 License: https://www.gnu.org/licenses/gpl-3.0.en.html
 */
package eu.tmuniversal.rbm.common.entity.projectile;

import eu.tmuniversal.rbm.common.entity.ModEntities;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.monster.BlazeEntity;
import net.minecraft.entity.projectile.ProjectileItemEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.particles.IParticleData;
import net.minecraft.particles.ItemParticleData;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.EntityRayTraceResult;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class EntityBigSnowball extends ProjectileItemEntity {
  public EntityBigSnowball(EntityType<? extends EntityBigSnowball> type, World world) {
    super(type, world);
  }

  public EntityBigSnowball(World worldIn, LivingEntity throwerIn) {
    super(ModEntities.BIG_SNOWBALL, throwerIn, worldIn);
  }

  public EntityBigSnowball(World worldIn, double x, double y, double z) {
    super(ModEntities.BIG_SNOWBALL, x, y, z, worldIn);
  }

  @Override
  protected void onEntityHit(EntityRayTraceResult entityHit) {
    Entity entity = entityHit.getEntity();
    int base_damage = 15;
    int i = entity instanceof BlazeEntity ? (3 * base_damage) + 1 : base_damage;
    entity.attackEntityFrom(DamageSource.causeThrownDamage(this, this.func_234616_v_()), (float) i);
  }

  @OnlyIn(Dist.CLIENT)
  private IParticleData makeParticle() {
    ItemStack itemstack = this.func_213882_k();
    return itemstack.isEmpty() ? ParticleTypes.ITEM_SNOWBALL : new ItemParticleData(ParticleTypes.ITEM, itemstack);
  }

  @Override
  @OnlyIn(Dist.CLIENT)
  public void handleStatusUpdate(byte id) {
    if (id == 3) {
      IParticleData iparticledata = this.makeParticle();

      for (int i = 0; i < 8; ++i) {
        this.world.addParticle(iparticledata, this.getPosX(), this.getPosY(), this.getPosZ(), 0.0D, 0.0D, 0.0D);
      }
    }
  }

  @Override
  protected void onImpact(RayTraceResult result) {
    super.onImpact(result);
    if (!this.world.isRemote) {
      this.world.setEntityState(this, (byte) 3);
      this.remove();
    }
  }

  @Override
  protected Item getDefaultItem() {
    return Items.SNOWBALL;
  }
}
